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
        <a href="#" data-bs-toggle="modal" data-bs-target="#modalLogin">Login</a>
        <router-link to="/mypage">MyPage</router-link>
        <a href="#" data-bs-toggle="modal" data-bs-target="#modalLogout">Logout</a>
      </div>
    </div>
  </header>

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

<!--로그아웃 모달-->
  <div id="modalLogout" class="modal" tabindex="-1">
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

  </div>
</template>
<script>
export default {
  name: 'AppNav',
}
</script>
<style>
  
</style>