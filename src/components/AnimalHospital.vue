<template>
  <div> 
    <div>
      <!-- v-if 관심지역설정 없으면 고양이와 안내문구-->
      <div align="center" class="mb-2"><h5><strong> 관심 지역 동물 병원 </strong></h5></div>
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
          <h5><strong>해당 지역 동물 병원 정보가 없습니다.</strong></h5>
          <img src="@/assets/img/no_list.jpg" class="interest-img">
          </div>
        </div>
        
        <div v-if="isList">
          <div align="center">
            <h6 class="mt-3"><strong>{{ hospitalList[0].hptDong }}</strong>에는 <strong>{{ count }}</strong>개의 병원이 있습니다.</h6>
          </div>
          <animal-hospital-map :hospitalList="hospitalList"></animal-hospital-map>
          <h5 class="ms-5"><strong>병원 목록</strong></h5>
          <table class="table table-hover" align="center" style="width: 1200px">
              <thead>
                <tr>
                  <th style="width: 15%">병원</th>
                  <th style="width: 65%">주소</th>
                  <th style="width: 20%">전화번호</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(item, index) in hospitalList" v-bind:key="index">
                  <td>{{ item.hptName }}</td>
                  <td>{{ item.hptAddress == null ? item.hptJibun : item.hptAddress }}</td>
                  <td>{{ item.hptCall }}</td>
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

import AnimalHospitalMap from './AnimalHospitalMap.vue';

export default {
  name:'AnimalHospital', 
  components: { AnimalHospitalMap },
  data(){
    return{
      sidoOptions : [],
      gugunOptions : [],
      dongOptions : [],

      hospitalList: [],

      isList : false,

      interestArea: '',

      count: 0,

      sidoSelected : '도/광역시',
      gugunSelected : '시/구/군',
      dongSelected: '동',
    }
  },
  watch: {
    loginAreaCheck(){
      this.init();
    }, 
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
      // 로그인 되었을 경우에는 생성하면서 interestArea 에 넣어준다.
      this.interestArea = this.$store.state.login.interestArea;
      
      this.sidoSelected = this.$store.state.login.interestArea.substr(0,2);
      this.updateGugun();
      this.gugunSelected = this.$store.state.login.interestArea.substr(0,5);
      this.updateDong();
      this.dongSelected = this.$store.state.login.interestArea
      // console.log(this.interestArea);
      this.setHptList();

      if(this.$store.state.login.isLogin && this.$store.state.login.interestArea != undefined) {
      this.$alertify.success("설정하신 관심지역"+this.hospitalList[0].hptDong+"에 대한 정보입니다.");
    }
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
      this.setHptList(); 
    },
    setHptList(){
      http
      .get('/animalhpt/'+this.interestArea)
      .then(({data}) => {
        this.count = data.count;
        this.hospitalList = data.hptList;
        if(this.hospitalList.length == 0) this.isList = false;
        else this.isList = true;
        // console.log(this.hospitalList);
      })
      .catch((error) =>{
        console.log(error);
      })
    },
  }
}

</script>
<style>
.interest-img{
  width: 500px;
  border: 2px solid rgb(235, 235, 235);
}
</style>