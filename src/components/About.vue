<template >
<div>
  <main id="main">
    <section id="animal-header" class="animal-header">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>About</h2>
          <p>소개페이지</p>
          <br>
        </div>
      </div>
    </section>
  </main>
  <div>
    <animal-name></animal-name>
    <shelter></shelter>
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