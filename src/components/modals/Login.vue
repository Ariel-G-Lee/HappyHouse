<template>
  <!--로그인 모달-->
  <div id="modalLogin" class="modal" tabindex="-1">
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
              <input type="text" class="form-control"
                id="loginId" name="loginId" placeholder="">
            </div>
            <div class="form-group mt-3" align="left">
              <label for="loginPwd">비밀번호</label>
              <input type="password"
                class="form-control" id="loginPwd" name="userPwd" placeholder="">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-green">로그인</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Login',
}
</script>
<style>
  
</style>