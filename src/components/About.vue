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
            <div class="row" id="about-project">
              <h6><strong>프로젝트 소개</strong></h6>
              <div class="col-md-3">
              </div>
              <div class="col-md-6">
                <p></p>
                <ul>
                  <li>주제 : HAPPY HOUSE</li>
                  <li>목적 : 이사할 동네가 동물을 키우기에 적합한 곳인지 알아본다. </li>
                  <li>기능
                    <ol>
                      <li>동/아파트별 매매정보 검색</li>
                      <li>서울시 동물병원/약국 통계</li>
                      <li>동별 동물병원/약국 검색</li>
                    </ol>
                  <li>팀명 : 멋쟁이 고양이처럼</li>
                  <li>개발기간 : 2021.05.18 ~ 20201.05.26 (9일)</li>
                </ul>
              </div>
              <div class="col-md-6">
              </div> 
            </div>
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