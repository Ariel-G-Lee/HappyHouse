<template>
  <div>  
    <bar-chart></bar-chart>
  </div>
</template>
<script>

import http from "@/common/axios.js";
import BarChart from './BarChart.vue'

export default {
  name:'AnimalChart', 
  data(){
    return{
      hospitalList : [],
      pharmacyList : [],
      datacollection: null,
    }
  },
  components: { BarChart },
  created(){
    http.get('/animalhpt')
      .then(({ data }) => {
        this.hospitalList = data; 
        if( data.result == 'login' ){
          this.$router.push("/login")
        }
      })
      .catch((error) => {
        console.log(error);
      });

    http.get('/animalpmc')
    .then(({ data }) => {
      this.pharmacyList = data; 
      if( data.result == 'login' ){
        this.$router.push("/login")
      }
    })
    .catch((error) => {
      console.log(error);
    });
  },
  mounted(){
    this.fillData()
  },
  methods:{
    fillData () {
        this.datacollection = {
          labels: [this.hospitalList.name],
          datasets: [
            {
              label: 'Data One',
              backgroundColor: '#f87979',
              data: [this.hospitalList.count]
            }, {
              label: 'Data One',
              backgroundColor: '#f87979',
              data: [this.pharmacyList.count]
            }
          ]
        }
      },
  }
}


</script>
<style>
  
</style>