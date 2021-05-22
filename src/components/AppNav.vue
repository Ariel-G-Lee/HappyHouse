<template> 
    
  <div>
    <!--nav bar-->
    <header id="header" class="fixed-top">
      <div class="container-fluid d-flex justify-content-between align-items-center">

        <h1 class="logo me-auto me-lg-0"><router-link to="/">Happy House</router-link></h1>
        
        <nav id="navbar" class="navbar order-last order-lg-0">
          <ul>
            <li><router-link to="/" class="active">Home</router-link></li>
            <li><router-link to="/noticelist" >공지사항</router-link></li>
            <li><router-link to="/house" >실거래 매물 검색</router-link></li>
            <!-- <li><a href="resume.html">QnA</a></li> -->
          </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->

        <div class="header-social-links text-end">
          <router-link to="/signup">SignUp</router-link>
          <button @click="showLoginModal">Login</button>
          <router-link to="/mypage">MyPage</router-link>
          <button @click="showLogoutModal">Logout</button>
        </div>
      </div>
    </header>
    <login v-on:call-parent-login="closeAfterLogin"></login>
    <logout v-on:call-parent-logout="closeAfterLogout"></logout>
  </div>
</template>
<script>
import Login from './modals/Login.vue';
import Logout from './modals/Logout.vue';

import { Modal } from 'bootstrap';

import Vue from 'vue';
import VueAlertify from 'vue-alertify'; 
Vue.use(VueAlertify);

export default {
  name: 'AppNav',
  data(){
    return{
      //modal
      loginModal:null,
      logoutModal:null,
    }
  },
  components:{ Login, Logout },
  methods : {  
    showLoginModal(){
      this.loginModal.show();
    },
    closeAfterLogin(){
      this.loginModal.hide();
    },
    showLogoutModal(){
      this.logoutModal.show();
    },
    closeAfterLogout(){
      this.logoutModal.hide();
    },
  },
  mounted(){
    this.loginModal = new Modal(document.getElementById('loginModal'));
    this.logoutModal = new Modal(document.getElementById('logoutModal'));
  }
}
</script>


<style scoped>

</style>