<template>
  <div class="cloud">
    <vue-word-cloud
      :words="words"
      :color="([ , weight]) => weight > 1000 ? 'DeepPink' : weight > 5 ? 'RoyalBlue' : 'Indigo'"
      font-family="Roboto"
    />
    
  </div>
</template>
<script> 
import VueWordCloud from 'vuewordcloud';
import http from "@/common/axios.js";

export default {
  name:'AnimalName',
  components: {
    [VueWordCloud.name]: VueWordCloud,
  },
  data() {
		return {
			loaded: false,
			words: [], 
		}
	},
  created(){
		http.get('/animalname')
      .then(({ data }) => {
        data.forEach((el) =>{
          this.words.push({text: el.name, weight: el.count}); 
        })
        this.loaded = true;
				console.log(data)
				console.log(this.words)

      })
      .catch((error) => {
        console.log(error);
      });
	},

}
</script>
<style>
.cloud{ 
  height: 480px;
  width: 640px; 
}
</style>