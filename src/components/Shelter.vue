<template>
  <div>
    <h1>shelter</h1>
    <text></text>
  </div>
</template>
<script>
import axios from 'axios';
const SERVICE_KEY = 'LY9%2F0XJJlPLjYmwd%2BmT%2FBlIiWSg1IFIenvFq6b9L7KV86lRxhPI7%2BHCOLcbHXFJjsJbGsYMXtxgmj4DeDMrXgg%3D%3D';
export default {
  name:'Shelter',
  data() {
    return {
      shelter: [],
    };
  },
  created(){
    this.sendKeyword()
  },
  methods: {
    sendKeyword: function() {

      const SERVICE_URL =
        'http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/sido?ServiceKey='+SERVICE_KEY;
      // npm install --save axios
      axios
        .get(SERVICE_URL, { 
        })
        .then((response) => {
          console.log("hi")
          console.log(response.data.response.body.items.item);
          this.shelter = response.data.response.body.items.item;
        })
        .catch((error) => {
          console.dir(error);
        });
    },
  },
}
</script>
<style>
  
</style>