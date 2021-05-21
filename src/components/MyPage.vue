<template>
  <main id="main">

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>내 정보</h2>
        </div>

        <div align="center" class="mb-5">

          <div class="col-lg-8 mt-5 mt-lg-0">
            <p class="mb-5">회원님의 정보를 수정하세요.</p>

            <form action="forms/contact.php" method="post" role="form" class="php-email-form">
              <div class="form-group mt-3" align="left">
                <label for="user-id">아이디</label>
                <input type="text" class="form-control" name="user-id" id="user-id" placeholder="Your ID" required readonly value="test">
              </div>
              <div class="form-group mt-3" align="left">
                <label for="password">비밀번호</label>
                <input type="password" class="form-control" name="user-pwd" id="user-pwd" placeholder="Your Password" required value="1234">
              </div>
              <div class="form-group mt-3" align="left">
                <label for="user-name">이름</label>
                <input type="text" name="user-name" class="form-control" id="user-name" placeholder="Your Name" required value="test">
              </div>
              <div class="form-group mt-3" align="left">
                <label for="email">이메일</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required value="test@test.com">
              </div>
              <div class="form-group mt-3" align="left">
                <label for="address">주소</label>
                <input type="text" class="form-control" name="address" id="address" placeholder="Your Address" required value="서울시 강남구">
              </div>
              <div class="form-group mt-3" align="left">
                <label for="phone">전화번호</label>
                <input type="text" class="form-control" name="phone" id="phone" placeholder="Your Phone Number" required value="01012345678">
              </div>
              <div class="text-center"><button type="submit">수정</button>
              <div align="right"><a href="#">탈퇴하기</a></div></div>
            </form>

          </div>
          
        </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->
</template>

<script>
export default {
  name: 'MyPage',
}
</script>

<style>

</style>