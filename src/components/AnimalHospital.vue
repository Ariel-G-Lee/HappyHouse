<template>
  <div> 
    <div>
      <!-- v-if 관심지역설정 없으면 고양이와 안내문구-->
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
    

    <div v-if="$store.state.login.interestArea == '' && interestArea == ''">
      <div align="center" class="mt-5 mb-5">
        설정하신 관심 지역이 없습니다!
        <h5><strong>관심 지역을 설정해주세요.</strong></h5>
        <img src="@/assets/img/interest.png" class="interest-img">
      </div>
    </div>


    <div v-if="$store.state.login.interestArea != '' || interestArea != ''">
      <div class="container-fluid container"> 
        <h4>지도</h4>
        <p>병원</p>
        <div id="map" style="width:500px;height:400px;"></div>
      </div>
    </div>
  </div>
</template>
<script> 
import http from "@/common/axios.js";

export default {
  name:'AnimalHospital',
  data(){
    return{
      sidoOptions : [],
      gugunOptions : [],
      dongOptions : [],

      hospitalList: [],

      interestArea: '',

      sidoSelected : '도/광역시',
      gugunSelected : '시/구/군',
      dongSelected: '동',
    }
  },
  created(){
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
      this.sidoSelected = this.$store.state.login.interestArea.substr(0,2);
      this.updateGugun();
      this.gugunSelected = this.$store.state.login.interestArea.substr(0,5);
      this.updateDong();
      this.dongSelected = this.$store.state.login.interestArea

      http
      .get('/animalhpt/'+this.$store.state.login.interestArea)
      .then(({data}) => {
        this.hospitalList = data.hptList;
      })
      .catch((error) =>{
        console.log(error);
      })
    }

    

  },
  methods:{
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
      this.interestArea = this.dongSelected;
      http
      .get('/animalhpt/'+this.interestArea)
      .then(({data}) => {
        this.hospitalList = data.hptList;
        console.log(this.hospitalList);
      })
      .catch((error) =>{
        console.log(error);
      })

    }
  }
}

</script>
<style>
.interest-img{
  width: 500px;
  border: 2px solid rgb(235, 235, 235);
}
</style>