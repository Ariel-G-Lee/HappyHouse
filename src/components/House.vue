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
                      <option value="dongName" selected>동</option>
                      <option value="aptName">아파트명 </option> 
                    </select>
                  </div>
                  <div>
                    <input v-model="searchKeyword" @keydown.enter="houseSearch" id="searchKeyword" type="text" class="form-control me-2" placeholder="검색어 입력" name="word">
                  </div> 
                  <div> 
                    <button @click.prevent="houseSearch" class="btn btn-green">검색</button>
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
export default {
  name:'House',
  components: { HouseList, HouseMap, HouseDetail},
  data(){
    return{
      searchOption: 'dongName',
      searchKeyword: ''
    }
  },
  created(){
    // 초기화 페이지 1로 보내기
    this.$store.state.house.offset = 0;
    this.$store.state.house.currentPageIndex = 1;
    this.$store.state.house.searchKeyword = '';
  },
  methods:{
    houseSearch(){
      // 초기화 페이지 1로 보내기
      this.$store.state.house.offset = 0;
      this.$store.state.house.currentPageIndex = 1;
      this.houseList();
    },
    houseList(){
      this.$store.state.house.searchOption = this.searchOption;
      this.$store.state.house.searchKeyword = this.searchKeyword;
      this.$store.dispatch('houseList');
    }
  }
}
</script>
<style>
  
</style>