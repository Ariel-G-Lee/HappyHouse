<template>
  <div>  
    <bar-chart v-if = "loaded" :chart-data="datacollection" :options="options"></bar-chart>
  </div>
</template>
<script>

import http from "@/common/axios.js";
import BarChart from './BarChart.vue';

export default {
  name:'AnimalChart', 
  data(){
    return{
      loaded: false,
      hospitalList : [],
      pharmacyList : [],
      guguns : [],
      hospitalCounts : [],
      pharmacyCounts : [],
      datacollection: {
          labels: '',
          datasets: [
            {
              label: '병원',
              backgroundColor: '#FFC738',
              data: '',
            }, {
              label: '약국',
              backgroundColor: '#6FBBED',
              data: '',
            }
          ]
        },
      options:
        { 
        responsive: true, 
        maintainAspectRatio: false,
        plugins: {
            legend: {
              position: 'top',
            },
          }, 
          title: {
              display: true,
              text: '서울시 동물 병원 및 동물 약국 통계'
          }
        }
      
    }
  },
  components: { BarChart },
  created(){
    http.get('/animalstats')
      .then(({ data }) => {
        this.hospitalList = data.stsHptList; 
        this.pharmacyList = data.stsPmcList;  
        if( data.result == 'login' ){
          this.$router.push("/login")
        }

        this.hospitalList.forEach((el) =>{
          this.guguns.push(el.name);
          this.hospitalCounts.push(el.count); 
        })

        this.datacollection.labels = this.guguns
        this.datacollection.datasets[0].data = this.hospitalCounts
        
        this.pharmacyList.forEach((el) =>{
          this.pharmacyCounts.push(el.count); 
        })

        this.datacollection.datasets[1].data = this.pharmacyCounts
        this.loaded = true;

      })
      .catch((error) => {
        console.log(error);
      });
  },
}


</script>
<style>
  
</style>