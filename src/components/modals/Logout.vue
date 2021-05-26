<template> 
<!--로그아웃 모달-->
  <div id="logoutModal" class="modal" tabindex="-1">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">로그아웃</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <p>로그아웃 하시겠습니까?</p>
        </div>
        <div class="modal-footer">
          <button @click="logout" class="btn btn-green">로그아웃</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Vue from 'vue';
import VueAlertify from 'vue-alertify'; 
Vue.use(VueAlertify);

import http from "@/common/axios.js";

export default {
  name: 'Logout',
    methods: {
    logout(){
      http.get(
        "/logout",
      )
      .then(() => {

        this.$store.commit(
          'SET_LOGIN',
          { isLogin: false, userName: "", userProfileImageUrl: "",
            userId: "", userPwd: "",
            email: "", address: "", interestArea: "", userCode: ""}
        );
        
        // this.$router.push("/")
        this.closeModal();
        this.$alertify.success("로그아웃에 성공했습니다");
        //console.log(this.$store.state.login.isLogin);

        //console.log(this.$route.path);
        if(this.$route.path=='/noticewrite' || this.$route.path=='/noticemodify' || this.$route.path=='/mypage' ){
          this.$router.push("/")
        }

      })
      .catch( error => {
        console.log("LogoutVue: error : ");
        console.log(error);
        // if( error.response.status == '404'){
        //   this.$alertify.error('이메일 또는 비밀번호를 확인하세요.');
        // }else{
        //   this.$alertify.error('Opps!! 서버에 문제가 발생했습니다.');
        // }

      });
    },
    closeModal(){
      this.$emit('call-parent-logout');  
    },
  }
}
</script>
<style>
  
</style>