<template>
  <div> 
    <h4>지도</h4>
    <div id="map" style="width:500px;height:400px;"></div>
    <hr>
  </div>
</template> 
<script> 
export default{  
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=127668908d2cbfb39da9f78e92b308fa'; 
      document.head.appendChild(script);
    }
  },
  watch:{
    listGetters(){
      this.initMap();
    }
  },
  computed: {
    listGetters(){
      return this.$store.getters.getHouseList;
    }
  },
  methods: {
    initMap () {
      const mapContainer = document.querySelector('#map')
      const options = {
        center: new kakao.maps.LatLng(37.567065, 126.977914),
        level: 8
      }
      const map = new kakao.maps.Map(mapContainer, options);
      
      var positions = [];
      // const coords = new kakao.maps.LatLng(35.19656853772262, 129.0807270648317);
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
      this.listGetters.forEach(e => {
        positions.push({title: e.aptName, latlng: new kakao.maps.LatLng(e.lat, e.lng)});      
      });

      for (var i = 0; i < positions.length; i ++) {
    
        var imageSize = new kakao.maps.Size(24, 35); 
    
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    

        var marker = new kakao.maps.Marker({
       
          map: map, // 마커를 표시할 지도
          position: positions[i].latlng, // 마커를 표시할 위치
          title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image : markerImage // 마커 이미지 
        });
        marker.setMap(map)
    }

      // const marker = new kakao.maps.Marker({
      //   position: coords
      // });

      
			// var infowindow = new kakao.maps.InfoWindow(
			// 		{
			// 			content : `<div style="width: 180px; text-align: center; padding: 5px;">멀티스퀘어</div>`
			// 		});

			// kakao.maps.event.addListener(marker, "mouseover", function() {
			// 	infowindow.open(map, marker);
			// });

			// kakao.maps.event.addListener(marker, "mouseout", function() {
			// 	infowindow.close();
			// });

			// map.setCenter(coords);
    }
  }
}
</script> 
<style> 
</style>

