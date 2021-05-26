<template>
  <div class="container">
    <h5><strong>서울시 동물 보호소</strong></h5>
    <p>사지말고 입양하세요</p>
    <div class="d-flex justify-content-center mt-2">     
      <div class="selectbox me-2 mt-1">
        <!-- @change="searchShelter" -->
        <select v-model="sigunguSelected" @change="searchShelter" class="form-select py-2 btn btn-light">
          <option selected value="시/군/구">시/구/군</option>
          <option v-for="(option, index) in sigungu" :key="index" :value="option.code">{{ option.name }}</option>
        </select>
      </div>
    </div>
    <div class="shelter-table mt-2">
    <table v-if="this.isExist" class="table table-hover">
      <thead>
        <tr>
          <th class="col-5">보호소번호</th>
          <th class="col-7">보호소명</th> 
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in shelter" v-bind:key="index">
          <td>{{ item.careRegNo }}</td>
          <td>{{ item.careNm }}</td> 
        </tr>
      </tbody>
    </table>
    </div>
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
      isExist: false,
      UPR_CD:'6110000',
      sigunguSelected: '시/군/구',
      sigungu : [],
      shelter: [],
    };
  },
  computed: {
    
  },
  created(){

    // this.Sido() //Sido -> sidos에 저장
    this.getSigungu() 
    // this.getShelter()
    // this.getShelterAll()
    setTimeout(()=>{
    }, 1000)

  },
  methods: {
    getSigunguName(option){
      this.sigunguName = option.name;
      return this.sigunguName;
      
    },
    getSigungu() {
      const SERVICE_URL='http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/sigungu?upr_cd='+this.UPR_CD+'&ServiceKey='+SERVICE_KEY;
      axios.get(SERVICE_URL, { 
        })
        .then((response) => { 
          response.data.response.body.items.item.forEach((el) => {
            if(el.orgdownNm != '가정보호' && el.orgdownNm != '서울특별시') this.sigungu.push({code: el.orgCd, name: el.orgdownNm})
          });
          // console.log(this.sigungu);
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    searchShelter() {
      this.isExist = false;
      const SERVICE_URL='http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/shelter?upr_cd='+this.UPR_CD+'&org_cd='+this.sigunguSelected+'&ServiceKey='+SERVICE_KEY;
      if(this.sigunguSelected != '시/군/구'){
        axios.get(SERVICE_URL, { 
        })
        .then((response) => { 
          this.shelter = [];
          if(response.data.response.body.items.item.constructor == Array){
              response.data.response.body.items.item.forEach((el) => {
              this.shelter.push({careRegNo: el.careRegNo, careNm: el.careNm});
            });
          } else {
            this.shelter.push(response.data.response.body.items.item);
          }
          
          // console.log(this.shelter);
          this.isExist = true;
        })
        .catch((error) => {
          console.dir(error);
        });
      } else {
        console.log(this.sigunguSelected);
        this.isExist = false;
      }
      
    },
  },
}
</script>
<style>
.shelter-table{
  width: 80%;
}
</style>