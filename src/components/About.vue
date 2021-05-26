<template >
<div>
  <main id="main">
    <section id="animal-header" class="animal-header">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>About</h2> 
          <br> 

          <div class="row" id="about-team" align="center">
            <h6><strong>팀원소개</strong></h6>
            <div class="col-md-3">
            </div>
            <div class="col-md-3">
              <p><strong>이가빈</strong></p>
              <img class="developer-profile" src="../assets/img/gv_profile.png">
              <br>
              <div class="mt-1">
              <img class="git-img" src="../assets/img/github.png"><a href="https://github.com/Ariel-G-Lee" class="text-dark">github</a>
              </div>
            </div>
            <div class="col-md-3">
              <p><strong>정진주</strong></p>
              <img class="developer-profile" src="../assets/img/jj_profile.png">
              <br>
              <div class="mt-1">
              <img class="git-img" src="../assets/img/github.png"><a href="https://github.com/ritajeong" class="text-dark">github</a>
              </div>
            </div>
            <div class="col-md-3">
            </div>
          </div> 

          <div>
            <br>
            <h6><strong>기획의도</strong></h6>
            <p>싸피 파이널 프로젝트인 happyhouse와 저희의 관심사인 동물을 싸피 파이널 프로젝트인 happyhouse와 저희의 관심사인 동물을 싸피 파이널 프로젝트인 happyhouse와 저희의 관심사인 동물을 싸피 파이널 프로젝트인 happyhouse와 저희의 관심사인 동물을 싸피 파이널 프로젝트인 happyhouse와 저희의 관심사인 동물을 </p>
          </div>


          <a href="#" @click="toggleOnOff">동물 입양을 고려하고 있는 당신에게...</a>
          <div class="mt-5" v-show="isStatusOn" align="center">
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
      </div>
    </section>
  </main>
  
</div>
</template>
<script>
import AnimalName from './AnimalName.vue'
import Shelter from './Shelter.vue'
export default {
  name:'About',
  components: { Shelter, AnimalName },
  data(){
    return{
      isStatusOn: false,
    }
  },
  methods:{
    toggleOnOff: function() {
      this.isStatusOn = !this.isStatusOn;
      console.log(this.isStatusOn);
    }
  }
  
}
</script>
<style>
.developer-profile{
  width: 250px;
  border-radius: 50%;
  border: 2px solid rgb(235, 235, 235);
}
.git-img{
  width:25px;
}
</style>