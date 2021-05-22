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
  methods: {
    initMap () {
      const container = document.querySelector('#map')
      const options = {
        center: new kakao.maps.LatLng(35.19656853772262, 129.0807270648317),
        level: 3
      }
      const map = new kakao.maps.Map(container, options)
      const markerPosition = new kakao.maps.LatLng(35.19656853772262, 129.0807270648317);

      const marker = new kakao.maps.Marker({
        position: markerPosition
      });
      marker.setMap(map)
    }
  }
}
</script> 
<style> 
</style>

