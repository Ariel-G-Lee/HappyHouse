<template>
<div>
  <div> 
      <!-- 여기서 v-if 관심지역설정 없으면 고양이와 안내문구-->
      <!--select box-->
      <div class="d-flex justify-content-center mt-2">
        <div class="selectbox me-2">
          <select v-model="sidoSelected" @change="updateGugun" class="form-select py-2 btn btn-light">
            <option selected>도/광역시</option>
            <option v-for="(option, index) in sidoOptions" :key="index" :value="option.sidoCode" >{{option.sidoName}}</option>
          </select>
        </div>
        <div class="selectbox me-2">
          <select v-model="gugunSelected" @change="updateDong" class="form-select py-2 btn btn-light">
            <option selected>시/구/군</option>
            <option v-for="(option, index) in gugunOptions" :key="index" :value="option.gugunCode">{{option.gugunName}}</option>
          </select>
        </div>
        <div class="selectbox">
          <select v-model="dongSelected" class="form-select py-2 btn btn-light">
            <option selected>동</option>
            <option v-for="(option, index) in dongOptions" :key="index" :value="option.dongCode">{{option.dongName}}</option>
          </select>
        </div> 
        <div> 
          <button @click.prevent="houseSearch" class="btn btn-green">검색</button>
        </div>
      </div>
      
      <div class="container-fluid container"> 
        <h4>지도</h4>
        <p>약국</p>
        <div id="map" style="width:500px;height:400px;"></div>
      </div>

      <div>
        <div class="container-fluid container">
          <table class="table">
            <thead>
              <tr>
                <th>제목</th>
                <th>내용</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>No.</td>
                <td>1}</td>
              </tr> 
              <tr>
                <td>동이름</td>
                <td>1</td>
              </tr>
              <tr>
                <td>아파트명</td>
                <td>1</td>
              </tr>
              <tr>
                <td>가격</td>
                <td>1</td>
              </tr>
              <tr>
                <td>면적</td>
                <td>1</td>
              </tr>
            </tbody>
          </table>
        </div>
    </div>
  </div>
</div>
</template>
<script> 
export default {
  name:'AnimalPharmacy',
}
</script>
<style>
  
</style>