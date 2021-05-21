<template> 
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
</template>
<script>
export default {
  name: 'AppNav',
}
</script>
<style>
  
</style>