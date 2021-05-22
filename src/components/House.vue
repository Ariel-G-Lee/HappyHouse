<template>
<div>
  <main id="main">
    <section id="house-header" class="house-header">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>실거래 매물 검색</h2>
        </div>
        <div align="center" class="mb-5">
          <div class="col-lg-8 mt-5 mt-lg-0">
            <p class="mb-5">원하시는 매물을 검색해보세요.</p>
              <div class="form-group mt-3" align="left">
                <div class="d-flex mt-2">
                  <div class="selectbox me-2">
                    <select class="form-select py-2 btn btn-light">
                      <option value="dong" selected="selected">동 </option>
                      <option value="AptName">아파트명 </option> 
                    </select>
                    <input id="searchKeyword" type="text" class="form-control" placeholder="검색어 입력" name="word">
                    <button id="apartSearch" type="button" class="btn btn-green">검색</button>
                  </div>
                </div>
              </div>
          </div>
        </div>
      </div>
    </section>
    <section id="house-body" class="house-body">
      <div class="container-fluid container" data-aos="fade-up">
        <div class="row">
          <div class="col-md-6">
              <house-list></house-list>
          </div>
          <div class="col-md-6">
            <div class="row">
              <div class="col-md-12">
                <house-map></house-map> 
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <house-detail></house-detail>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>

  </div>
  
</template>
<script>
import HouseDetail from './HouseDetail.vue'
import HouseList from './HouseList.vue'
import HouseMap from './HouseMap.vue'
export default {
  components: { HouseList, HouseMap, HouseDetail},
  
}
</script>
<style>
  
</style>