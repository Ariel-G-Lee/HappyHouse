<template>
  <div>  
    <bar-chart :chart-data="datacollection" :options="options"></bar-chart>
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
              text: 'Chart.js Bar Chart'
          }
        }
      
    }
  },
  components: { BarChart },
  created(){
    http.get('/animalhpt')
      .then(({ data }) => {
        this.hospitalList = data.stsList; 
        if( data.result == 'login' ){
          this.$router.push("/login")
        }

        this.hospitalList.forEach((el) =>{
          this.guguns.push(el.name);
          this.hospitalCounts.push(el.count); 
        })

        this.datacollection.labels = this.guguns
        this.datacollection.datasets[0].data = this.hospitalCounts
      })
      .catch((error) => {
        console.log(error);
      });

    http.get('/animalpmc')
    .then(({ data }) => {
      this.pharmacyList = data.stsList; 
      if( data.result == 'login' ){
        this.$router.push("/login")
      }

      this.pharmacyList.forEach((el) =>{
          this.pharmacyCounts.push(el.count); 
        })

      this.datacollection.datasets[1].data = this.pharmacyCounts
    })
    .catch((error) => {
      console.log(error);
    }); 

  },
}


</script>
<style>
  
</style>