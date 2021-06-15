<template>
  <div class="housedetail-table mt-5 p-2">
    <div class="house-name ps-2">
       <h5><strong>{{ $store.state.house.aptName }}</strong></h5>
    </div>
    <table class="table ps-2 mt-2">
      <tbody>
        <tr>
          <th class="col-2">지역</th>
          <td class="col-4">{{ $store.state.house.dongName }}</td>
          <th class="col-2">가격</th>
          <td class="col-4">{{ $store.state.house.dealAmount}}</td>
        </tr>
        <tr>
          <th>면적</th>
          <td>{{ area }}</td>
          <th>층</th>
          <td>{{ $store.state.house.floor }}</td>
        </tr>
        <tr>
          <th>건축년도</th>
          <td>{{ $store.state.house.buildYear }}</td>
          <th>매매 등록일</th>
          <td>{{ dealdate }}</td>
        </tr>

        <tr>
          
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
export default {
  name:'HouseDetail',
  computed: {
    dealdate(){
      if(this.$store.state.house.dealDay == '') return '';
      return this.$store.state.house.dealYear+"."+this.$store.state.house.dealMonth+"."+this.$store.state.house.dealDay;
    },
    area(){
      if(this.$store.state.house.area == '') return '';
      else return this.$store.state.house.area+" m2";
    }
  }
}
</script>
<style>
.house-name{
  height: 30px;
}
</style>