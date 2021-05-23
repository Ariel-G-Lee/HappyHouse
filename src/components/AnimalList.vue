<template>
  <div>
    <h4>매물 목록</h4>
    <table class="table table-hover">
      <thead>
        <tr>
          <th>번호</th>
          <th>동명</th>
          <th>상호명</th>
          <th>전화번호</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(animal, index) in listGetters" @click="animalDetail(animal.no)" v-bind:key="index">
          <td>{{ animal.no }}</td>
          <td>{{ animal.dongName }}</td>
          <td>{{ animal.aptName }}</td>
          <td>{{ animal.dealAmount }}</td>
        </tr>
      </tbody>
    </table>
    <pagination-animal v-on:call-parent="movePage"></pagination-animal>
  </div> 
</template>
<script>
export default {
  
}
</script>
<style>
  
</style>