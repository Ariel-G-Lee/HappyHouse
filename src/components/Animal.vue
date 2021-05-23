<template>
<div>
  <main id="main">
    <section id="animal-header" class="animal-header">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>멋쟁이 고양이처럼</h2>
        </div>
      </div>
    </section>
  </main>
  <div id="animal-body" class="animal-body">
    <div class="container-fluid container" data-aos="fade-up">
      <div class="row">
        <div class="col-md-6">
            <animal-list></animal-list>
        </div>
        <div class="col-md-6">
          <animal-map></animal-map>  
          <animal-detail></animal-detail> 
        </div>
      </div>
    </div>
  </div>
</div>
</template>
<script>
import AnimalDetail from './AnimalDetail.vue'
import AnimalList from './AnimalList.vue'
import AnimalMap from './AnimalMap.vue'
export default {
  name:'Animal',
  components: { AnimalList, AnimalMap, AnimalDetail},
  data(){
    return{ 
    }
  }, 
  created() {
    this.animalList();
  },
  methods:{
    animalList(){
      this.$store.state.animal.searchOption = this.searchOption;
      this.$store.state.animal.searchKeyword = this.searchKeyword;
      this.$store.dispatch('animalList');
    }
  }
}
</script>

<style>
  
</style>