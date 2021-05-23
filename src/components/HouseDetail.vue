<template>
  <div>
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
          <td>{{ $store.state.house.no }}</td>
        </tr> 
        <tr>
          <td>동이름</td>
          <td>{{ $store.state.house.dongName }}</td>
        </tr>
        <tr>
          <td>아파트명</td>
          <td>{{ $store.state.house.aptName }}</td>
        </tr>
        <tr>
          <td>가격</td>
          <td>{{ $store.state.house.dealAmount}}</td>
        </tr>
        <tr>
          <td>면적</td>
          <td>{{ $store.state.house.area }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
export default {
  name:'HouseDetail',
}
</script>
<style>
  
</style>