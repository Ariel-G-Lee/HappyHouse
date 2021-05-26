<template >
<div>
  <main id="main">
    <section id="animal-header" class="animal-header">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>About</h2>
          <p>소개페이지</p>
          <br>
          <text>소개내용</text>
          <p>만약 동물 입양을 원하는 당신이라면...</p>
          <a>클릭</a>
        </div>
      </div>
    </section>
  </main>
  <div align="center">
    <div class="row">
          <div class="col-md-6">
            <shelter></shelter>
          </div>
          <div class="col-md-6">
            <animal-name></animal-name>
          </div>
    </div>
  </div>
</div>
</template>
<script>
import AnimalName from './AnimalName.vue'
import Shelter from './Shelter.vue'
export default {
  name:'About',
  components: { Shelter, AnimalName },
  
}
</script>
<style lang="">
  
</style>