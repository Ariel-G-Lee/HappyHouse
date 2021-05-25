<template>
<div> 
    <div>
      <!-- v-if 관심지역설정 없으면 고양이와 안내문구-->
      <div align="center" class="mb-2"><h5><strong> 관심 지역 동물 약국 </strong></h5></div>
      <div class="d-flex justify-content-center mt-2">     
          <div class="selectbox me-2 mt-1">
            <select v-model="sidoSelected" @change="updateGugun" class="form-select py-2 btn btn-light">
              <option selected>도/광역시</option>
              <option v-for="(option, index) in sidoOptions" :key="index" :value="option.sidoCode" >{{option.sidoName}}</option>
            </select>
          </div>

          <div class="selectbox me-2 mt-1">
            <select v-model="gugunSelected" @change="updateDong" class="form-select py-2 btn btn-light">
              <option selected>시/구/군</option>
              <option v-for="(option, index) in gugunOptions" :key="index" :value="option.gugunCode">{{option.gugunName}}</option>
            </select>
          </div>

          <div class="selectbox me-2 mt-1">
            <select v-model="dongSelected" class="form-select py-2 btn btn-light">
              <option selected>동</option>
              <option v-for="(option, index) in dongOptions" :key="index" :value="option.dongCode">{{option.dongName}}</option>
            </select>
          </div>
          <div> 
          <button @click="hospitalSearch" class="btn btn-green">검색</button>
          </div>
        </div>
    </div>
    

    <div v-if="!showCheck">
      <div align="center" class="mt-5 mb-5">
        설정하신 관심 지역이 없습니다!
        <h5><strong>관심 지역을 선택해주세요.</strong></h5>
        <img src="@/assets/img/interest.png" class="interest-img">
      </div>
    </div>


    <div v-if="showCheck">
      <div class="container-fluid container"> 
        <div v-if="!isList">
          <div align="center" class="mt-5 mb-5">
          <h5><strong>해당 지역 동물 약국 정보가 없습니다.</strong></h5>
          <img src="@/assets/img/no_list.jpg" class="interest-img">
          </div>
        </div>
        
        <div v-if="isList">
          <div align="center">
            <h6 class="mt-3"><strong>{{ pharmacyList[0].pmcDong }}</strong>에는 <strong>{{ count }}</strong>개의 약국이 있습니다.</h6>
          </div>
          <h5><strong>지도</strong></h5>
          <div id="map" style="width:500px;height:400px;"></div>

          <h5 class="ms-5"><strong>약국 목록</strong></h5>
          <table class="table table-hover" align="center" style="width: 1200px">
              <thead>
                <tr>
                  <th style="width: 30%">약국</th>
                  <th style="width: 50%">주소</th>
                  <th style="width: 20%">전화번호</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(item, index) in pharmacyList" v-bind:key="index">
                  <td>{{ item.pmcName }}</td>
                  <td>{{ item.pmcAddress == null ? item.pmcJibun : item.pmcAddress }}</td>
                  <td>{{ item.pmcCall }}</td>
                </tr>
              </tbody>
            </table>
        </div>
        

    </div>

    </div>
  </div>
</template>
<script>
import http from "@/common/axios.js";
export default {
  name:'AnimalPharmacy',
  data(){
    return{
      sidoOptions : [],
      gugunOptions : [],
      dongOptions : [],

      pharmacyList: [],

      isList : false,
      count : 0,
      interestArea: '',

      sidoSelected : '도/광역시',
      gugunSelected : '시/구/군',
      dongSelected: '동',
    }
  },
  watch: {
    loginAreaCheck(){
      this.init();
    }
  },
  computed:{
    loginAreaCheck(){
      return this.$store.state.login.interestArea;
    },
    showCheck(){
      if(this.interestArea == '' || this.interestArea == undefined) return false;
      else return true; 
    },
  },
  created(){
    this.init();
  },
  methods:{
    init(){
      this.sidoSelected = '도/광역시',
      this.gugunSelected = '시/구/군',
      this.dongSelected = '동',
      this.interestArea = '';
      http
      .get('/area/sido')
      .then(({ data }) => {
        this.sidoOptions = data;
        if( data.result == 'login' ){
          this.$router.push("/login")
        }
      })
      .catch((error) => {
        console.log(error);
      });

      // console.log(this.sidoSelected);

    if(this.$store.state.login.interestArea != undefined && this.$store.state.login.interestArea != ''){
      // 로그인 되었고, 관심지역이 비어있지 않은 경우에는 생성하면서 interestArea 에 넣어준다.
      this.interestArea = this.$store.state.login.interestArea;
      
      this.sidoSelected = this.$store.state.login.interestArea.substr(0,2);
      this.updateGugun();
      this.gugunSelected = this.$store.state.login.interestArea.substr(0,5);
      this.updateDong();
      this.dongSelected = this.$store.state.login.interestArea
      // console.log(this.interestArea);
      this.setPmcList();
    }
    },
    updateGugun() {
      this.gugunSelected = '시/구/군';
      this.dongSelected = '동';
      http
      .get('/area/gugun?sidoCode='+this.sidoSelected)
      .then(({data}) => {        
      let list = [];
      data.forEach((el) =>{
        if(el['sidoCode'] == this.sidoSelected){
          list.push(el);
        }
      })
                
      this.gugunOptions = list;
      // console.log(data);
      })
      .catch((error) =>{
        console.log(error);
      })
    },
    updateDong() {
      this.dongSelected = '동';
      http
      .get('/area/dong?gugunCode='+this.gugunSelected)
      .then(({data}) => {
                
      let list = [];
      // 원래 디비에서 필터할 활동
      data.forEach((el) =>{
        if(el['gugunCode'] == this.gugunSelected){
          list.push(el);
        }
      })
      this.dongOptions = list;
      })
      .catch((error) =>{
        console.log(error);
      })
    },
    hospitalSearch(){
      // 선택된 동으로 검색!
      this.interestArea = this.dongSelected;
      this.setPmcList();

    },
    setPmcList(){
      http
      .get('/animalpmc/'+this.interestArea)
      .then(({data}) => {
        console.log(data.pmcList);
        this.count = data.count;
        this.pharmacyList = data.pmcList;
        if(this.pharmacyList.length == 0) this.isList = false;
        else this.isList = true;
      })
      .catch((error) =>{
        console.log(error);
      })
    }
  }
}
</script>
<style>
  
</style>