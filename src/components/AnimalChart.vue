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
      datacollection: null,
      options:[
        { 
        responsive: true, 
        maintainAspectRatio: false,
        plugins: {
            legend: {
              position: 'top',
            },
            title: {
              display: true,
              text: 'Chart.js Bar Chart'
            }
          } 
        }
      ]
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
          labels: this.guguns,
          datasets: [
            {
              label: 'Data One',
              backgroundColor: '#FFC738',
              data: this.hospitalCounts,
            }, {
              label: 'Data two',
              backgroundColor: '#6FBBED',
              data: this.pharmacyCounts,
            }
          ]
        }
      },

  }
}


</script>
<style>
  
</style>