<template>
<div>
  <main id="main">
    <section id="animal-header" class="animal-header">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>관심지역 동행</h2>
          <p>나와 함께 사는 반려동물을 위한</p>
          <router-link to="/animal">차트 </router-link>
          <router-link to="/animalhospital"> 동물병원 </router-link>
          <router-link to="/animalpharmacy"> 동물약국 </router-link>
        </div>
      </div>
    </section>
  </main>
  <div id="animal-body" class="animal-body">
    <div class="container-fluid container" data-aos="fade-up">
      <router-view></router-view>
      <!-- default : AnimalChart, 동물병원 클릭시 AnimalDetail-hospital, 동물약국 클릭시 AnimalDetail-hospital-->
    </div>
  </div>
</div>
</template>
<script>
export default {
  name:'Animal', 
}
</script>

<style>
</style>