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
        level: 3
      }
      const map = new kakao.maps.Map(mapContainer, options);
      
      var positions = []; //좌표 저장
      var bounds = new kakao.maps.LatLngBounds();   //범위저장

      // const coords = new kakao.maps.LatLng(35.19656853772262, 129.0807270648317);
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
      this.listGetters.forEach(e => {
        positions.push({title: e.aptName, latlng: new kakao.maps.LatLng(e.lat, e.lng)});      
      });

      for (var i = 0; i < positions.length; i ++) {
        var imageSize = new kakao.maps.Size(24, 35);
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        //마커
        var marker = new kakao.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: positions[i].latlng, // 마커를 표시할 위치
          title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image : markerImage // 마커 이미지 
        });

        //인포윈도우 
        var infowindow = new kakao.maps.InfoWindow({
            content: positions[i].title // 인포윈도우에 표시할 내용
        });
        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

        marker.setMap(map)  //좌표하나를 마커에 추가
        bounds.extend(positions[i].latlng); //좌표하나를 범위에 추가
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
</style>

