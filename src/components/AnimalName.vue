<template>
  <div class="cloud">
    <vue-word-cloud
      style="
          height: 550px;
          width: 450px;
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
			words: [], 
      colorItemIndex: undefined,
      colorItems: [
        ['#FEDE00', '#B4F8C8', '#6AB8EE'],
        ['#4C5270', '#F652A0', '#36EEE0', '#BCECE0'],
        ['#ffd077', '#3bc4c7', '#3a9eea', '#ff4e69', '#461e47'],
        ['#DB1F48', '#004369', '#01949A', '#E5DDC8'],
        ['#E7DED9', '#13292A', '#988780']
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