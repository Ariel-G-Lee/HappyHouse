<template>
  <div> 
    <div id="map" class="mt-4 map-size"></div>
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
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=127668908d2cbfb39da9f78e92b308fa&libraries=clusterer'; 
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
        level: 14
      }
      const map = new kakao.maps.Map(mapContainer, options);
      
      var positions = []; //좌표를 저장할 배열
      var bounds = new kakao.maps.LatLngBounds();   //범위 저장할 변수  
      var clusterer = new kakao.maps.MarkerClusterer({ //마커 클러스터러
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
      });

      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
      this.listGetters.forEach(e => {
        positions.push({title: e.aptName, latlng: new kakao.maps.LatLng(e.lat, e.lng)});      
      });

      for (var i = 0; i < positions.length; i ++) {
        var imageSize = new kakao.maps.Size(24, 35);
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        //마커
        var marker = new kakao.maps.Marker({
          position: positions[i].latlng, // 마커를 표시할 위치
          title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image : markerImage // 마커 이미지 
        });
        clusterer.addMarker(marker);

        //인포윈도우 
        var infowindow = new kakao.maps.InfoWindow({
            content: positions[i].title // 인포윈도우에 표시할 내용
        });
        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

        marker.setMap(map)  //좌표하나를 마커에 추가
        bounds.extend(positions[i].latlng); //좌표하나를 범위에 추가
        console.log(positions[i].latlng)
        
      } //position for문 끝
      map.setBounds(bounds) //추가된 좌표에 따른 범위 재설정
      

      
      // 인포윈도우를 표시하는 클로저를 만드는 함수
      function makeOverListener(map, marker, infowindow) {
          return function() {
              infowindow.open(map, marker);
          };
      }
      // 인포윈도우를 닫는 클로저를 만드는 함수
      function makeOutListener(infowindow) {
          return function() {
              infowindow.close();
          };
      }
    } //initMap() end
  }
}
</script> 
<style>
.map-size{
  width:100%;
  height:400px;
  border: 2px solid rgb(235, 235, 235);
}
</style>

