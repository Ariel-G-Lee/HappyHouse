<template>
  <div>
    <h1>shelter</h1> 
    <table class="table table-hover">
      <thead>
        <tr>
          <th class="col-2">보호소번호</th>
          <th class="col-2">보호소명</th> 
        </tr>
      </thead>
      <tbody>
        <tr v-for="(shel, index) in shelterAll" v-bind:key="index">
          <td>{{shel.careRegNo}}</td>
          <td>{{ shel.careNm }}</td> 
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import axios from 'axios';
const SERVICE_KEY = 'LY9%2F0XJJlPLjYmwd%2BmT%2FBlIiWSg1IFIenvFq6b9L7KV86lRxhPI7%2BHCOLcbHXFJjsJbGsYMXtxgmj4DeDMrXgg%3D%3D';
export default {
  name:'Shelter',
  data() {
    return {
      // sidos : [], 
      sigungu : [],
      shelter: [],
      shelterAll: [],
    };
  },
  computed: {
    // listGetters(){
    //   return this.$store.getters.getHouseList;
    // },
  },
  created(){
    // this.Sido() //Sido -> sidos에 저장
    this.getSigungu() 
    // this.getShelter()
    // this.getShelterAll()
    setTimeout(()=>{
      this.getShelterAll()
    }, 1000)
    
  },
  methods: {
    // searchSido() {
    //   const SERVICE_URL='http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/sido?ServiceKey='+SERVICE_KEY;
    //   axios.get(SERVICE_URL, { 
    //     })
    //     .then((response) => { 
    //       console.log(response.data.response.body.items.item);
    //       this.sidio = response.data.response.body.items.item;
    //     })
    //     .catch((error) => {
    //       console.dir(error);
    //     });
    // },
    getSigungu() {
      const UPR_CD ='6110000'; //서울시
      const SERVICE_URL='http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/sigungu?upr_cd='+UPR_CD+'&ServiceKey='+SERVICE_KEY;
      axios.get(SERVICE_URL, { 
        })
        .then((response) => { 
          console.log(response.data.response.body.items.item);
          this.sigungu = response.data.response.body.items.item;
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    getShelter() {
      const UPR_CD ='6110000';
      const ORG_CD='3220000';
      const SERVICE_URL='http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/shelter?upr_cd='+UPR_CD+'&org_cd='+ORG_CD+'&ServiceKey='+SERVICE_KEY;
      axios.get(SERVICE_URL, { 
        })
        .then((response) => { 
          console.log(response.data.response.body.items.item);
          this.shelter = response.data.response.body.items.item;
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    getShelterAll(){
      const UPR_CD ='6110000';
      this.sigungu.forEach((e)=>{
        var ORG_CD=e.orgCd;
        const SERVICE_URL='http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/shelter?upr_cd='+UPR_CD+'&org_cd='+ORG_CD+'&ServiceKey='+SERVICE_KEY;
        axios.get(SERVICE_URL, { 
          })
          .then((response) => { 
            console.log(response.data.response.body.items.item);
            this.shelter = (response.data.response.body.items.item);
            this.shelterAll = this.shelterAll.concat(this.shelter);
          })
          .catch((error) => {
            console.dir(error);
          });
      })
    }
  },
}
</script>
<style>
  
</style>