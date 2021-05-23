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
      const mapContainer = document.querySelector('#map')
      const options = {
        center: new kakao.maps.LatLng(35.19656853772262, 129.0807270648317),
        level: 3
      }
      const map = new kakao.maps.Map(mapContainer, options)
      const coords = new kakao.maps.LatLng(35.19656853772262, 129.0807270648317);

      const marker = new kakao.maps.Marker({
        position: coords
      });
      marker.setMap(map)

      
			var infowindow = new kakao.maps.InfoWindow(
					{
						content : `<div style="width: 180px; text-align: center; padding: 5px;">멀티스퀘어</div>`
					});

			kakao.maps.event.addListener(marker, "mouseover", function() {
				infowindow.open(map, marker);
			});

			kakao.maps.event.addListener(marker, "mouseout", function() {
				infowindow.close();
			});

			map.setCenter(coords);
    }
  }
}
</script> 
<style> 
</style>

