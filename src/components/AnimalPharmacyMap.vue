<template>
  <div>
    <div id="map" class="mt-4 pmc-map-size"></div>
  </div>
</template>
<script>
export default {
  props:['pharmacyList'],
  mounted(){
    // console.log(this.pharmacyList)
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=127668908d2cbfb39da9f78e92b308fa&libraries=services'; 
      document.head.appendChild(script);
    }
  },
  methods:{
    initMap () {
      const mapContainer = document.querySelector('#map')
      const options = {
        center: new kakao.maps.LatLng(37.567065, 126.977914),
        level: 14
      }
      const map = new kakao.maps.Map(mapContainer, options);
      
      var bounds = new kakao.maps.LatLngBounds();   //범위 저장할 변수  
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 

      this.pharmacyList.forEach(e => {

        var geocoder = new kakao.maps.services.Geocoder(), // 좌표계 변환 객체를 생성합니다
          wtmX = e.pmcX, // 변환할 WTM X 좌표 입니다
          wtmY = e.pmcY; // 변환할 WTM Y 좌표 입니다
          // console.log(wtmX)
          // WTM 좌표를 WGS84 좌표계의 좌표로 변환합니다
          geocoder.transCoord(wtmX, wtmY, transCoordCB, {
            input_coord: kakao.maps.services.Coords.WTM, // 변환을 위해 입력한 좌표계 입니다
            output_coord: kakao.maps.services.Coords.WGS84 // 변환 결과로 받을 좌표계 입니다 
          });     
      });

      // 좌표 변환 결과를 받아서 처리할 콜백함수 입니다.
      function transCoordCB(result, status) {
        // console.log("result");
        console.log(result);
        // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {

        var imageSize = new kakao.maps.Size(24, 35);
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
        var latlng = new kakao.maps.LatLng(result[0].y, result[0].x);
        console.log(latlng)
          // 마커를 변환된 위치에 표시합니다
          var marker = new kakao.maps.Marker({
            position: latlng, // 마커를 표시할 위치입니다
            image : markerImage, // 마커 이미지 
            map:map
          })
          
          marker.setMap(map)
          bounds.extend(latlng);
        }
        map.setBounds(bounds) //추가된 좌표에 따른 범위 재설정
      } 
    } //initMap() end
  },
}
</script>
<style>
  .pmc-map-size{
  width:100%;
  height:400px;
  border: 2px solid rgb(235, 235, 235);
}
</style>
