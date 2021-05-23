<template>
<div>
  <main id="main">
    <section id="house-header" class="house-header">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>실거래 매물 검색</h2>
        </div>
        <div align="center" class="mb-5"> 
          <div class="col-lg-8 mt-5 mt-lg-0" align="center">
            <p class="mb-5">원하시는 매물을 검색해보세요.</p>
              <div class="form-group mt-3">
                <div class="d-flex justify-content-center mt-2"> 
                  <div class="selectbox me-2">
                    <select v-model="searchOption" class="form-select py-2 btn btn-light" name="key" id="key">
                      <option selected>동/아파트명</option>
                      <option value="dong">동 </option>
                      <option value="aptName">아파트명 </option> 
                    </select>
                  </div>
                  <div>
                    <input v-model="searchKeyword" id="searchKeyword" type="text" class="form-control me-2" placeholder="검색어 입력" name="word">
                  </div> 
                  <div> 
                    <button @click.prevent="apartSearch" class="btn btn-green">검색</button>
                  </div>
                </div>
              </div>
          </div>
        </div>
      </div>
    </section>
  </main>
    <div id="house-body" class="house-body">
      <div class="container-fluid container" data-aos="fade-up">
        <div class="row">
          <div class="col-md-6">
              <house-list></house-list>
          </div>
          <div class="col-md-6">
            <house-map></house-map>  
            <house-detail></house-detail> 
          </div>
        </div>
      </div>
    </div>
  </div> 
</template>
<script>
import HouseDetail from './HouseDetail.vue'
import HouseList from './HouseList.vue'
import HouseMap from './HouseMap.vue'
import http from "@/common/axios.js";
export default {
  name:'House',
  components: { HouseList, HouseMap, HouseDetail},
  data(){
    return{
      searchOption:'동/아파트명',
      searchKeyword:'',
    }
  }, 
  created() {
    this.searchOption = '동/아파트명'
  },
  methods:{
    apartSearch(){
      if(this.searchKeyword == '')
        alert("전체 검색되게") 
      console.log(this.searchOption);
      console.log(this.searchKeyword);
      this.dongSearch();
    }, 
    dongSearch(){
      http.get(
          '/houses',
          {
            params : {
              key : this.searchOption,
              word : this.searchKeyword
            }
          }
          )
          .then(({ data }) => { 
            console.log("success");
            console.log("현재 데이터 리스트 : ", data);
            console.log("총 갯수 : ", Object.keys(data).length);	
            this.list = data.list;
          })
          .catch((error) => {
            console.log("search houses : error ");
            console.log(error);
          });
    }
  }
}
</script>
<style>
  
</style>