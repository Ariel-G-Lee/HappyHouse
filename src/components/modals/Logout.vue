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
          <button type="button" class="btn btn-green">로그아웃</button>
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
  name: 'Login',
    methods: {
    login(){
      http.post(
        "/login",
        {
          userId: this.$store.state.login.userId,
          userPwd: this.$store.state.login.userPwd
        }
      )
      .then(({ data }) => {
        console.log("LoginVue: data : ");
        console.log(data);

        // $emit 사용 X
        // login 성공 전달
        //this.$emit('call-parent-loginSuccess', {userName: data.userName, userProfileImageUrl: data.userProfileImageUrl});

        // isLogin 포함 mutator 호출
        this.$store.commit(
          'SET_LOGIN',
          { isLogin: true, userName: data.userName, userProfileImageUrl: data.userProfileImageUrl}
        );
        
        this.closeModal();
        this.$router.push("/")
      })
      .catch( error => {
        console.log("LoginVue: error : ");
        console.log(error);
        if( error.response.status == '404'){
          this.$alertify.error('이메일 또는 비밀번호를 확인하세요.');
        }else{
          this.$alertify.error('Opps!! 서버에 문제가 발생했습니다.');
        }

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