<template>
  <div class="cloud">
		<h5><strong>인기가 많은 반려동물 이름이래요!</strong></h5>
    <vue-word-cloud
      style="
          height: 550px;
          width: 550px;
          margin-left: 30px;
          cursor: pointer;
        "
      :words="words"
      :color="color"
      font-family="Anton"
      font-weight="Bold"
    />
    
  </div>
</template>
<script> 
import VueWordCloud from 'vuewordcloud';
import http from "@/common/axios.js";

let Chance = require('chance')
let chance = new Chance();

export default {
  name:'AnimalName',
  components: {
    [VueWordCloud.name]: VueWordCloud,
  },
  data() {
		return {
			loaded: false,
			words: [], 
      colorItemIndex: undefined,
      colorItems: [
        ['#E7DED9', '#16306a', '#988780', '#01949a', '#5ba9ac']
      ],
		}
	},
  computed:{ 
    color() {
      const colors = this.colorItems[this.colorItemIndex]
      return function() {
        return chance.pickone(colors)
      }
    },
  },
  created(){
		http.get('/animalname')
      .then(({ data }) => {
        data.forEach((el) =>{
          this.words.push({text: el.name, weight: el.count}); 
        })
        this.loaded = true;
      })
      .catch((error) => {
        console.log(error);
      });
    this.colorItemIndex = chance.integer({min: 0, max: this.colorItems.length - 1});
	},

}
</script>
<style> 
</style>