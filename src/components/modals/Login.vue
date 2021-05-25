<template>
  <!--로그인 모달-->
  <div id="loginModal" class="modal" tabindex="-1">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">로그인</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form id="loginform" method="post" action="">
            <div class="form-group" align="left">
              <label for="loginId">아이디</label>
              <input type="text" class="form-control" id="loginId" name="loginId" placeholder="" v-model="$store.state.login.userId">
            </div>
            <div class="form-group mt-3" align="left">
              <label for="loginPwd">비밀번호</label>
              <input type="password" class="form-control" id="loginPwd" name="userPwd" placeholder="" v-model="$store.state.login.userPwd">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button @click="login" class="btn btn-green">로그인</button>
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
        //("LoginVue: data : ");
        console.log(data);

        // $emit 사용 X
        // login 성공 전달
        //this.$emit('call-parent-loginSuccess', {userName: data.userName, userProfileImageUrl: data.userProfileImageUrl});

        // isLogin 포함 mutator 호출
        this.$store.commit(
          'SET_LOGIN',
          { isLogin: true, userName: data.userName, email: data.email,
            address: data.address, interestArea: data.interestArea,
            profileImageUrl: data.profileImageUrl, userCode: data.userCode},
        );

        this.closeModal()
        this.$alertify.success("로그인에 성공했습니다")
        //console.log(this.$store.state.login.isLogin) 
        if(this.$route.path=='/signup'){
          this.$router.push("/")
        }
        
      })
      .catch( error => {
        //console.log("LoginVue: error : ");
        console.log(error);
        if( error.response.status == '404'){
          this.$alertify.error('이메일 또는 비밀번호를 확인하세요.');
        }else{
          this.$alertify.error('Opps!! 서버에 문제가 발생했습니다.');
        }

      });
    },
    closeModal(){
       this.$emit('call-parent-login'); // no parameter
    },
  }
}
</script>
<style>
</style>