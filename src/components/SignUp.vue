<template>
  <main id="main">

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>회원가입</h2>
        </div>

        <div align="center" class="mb-5">

          <div class="col-lg-8 mt-5 mt-lg-0">
            <p class="mb-5">가입 정보를 입력하세요.</p>

            <div action="forms/contact.php" method="post" role="form" class="php-email-form">
              <div class="form-group mt-3" align="left">
                <label for="user-id">아이디</label>
                <input type="text" class="form-control" name="user-id" id="user-id" placeholder="Your ID" required>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="password">비밀번호</label>
                <input type="password" class="form-control" name="user-pwd" id="user-pwd" placeholder="Your Password" required>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="user-name">이름</label>
                <input type="text" name="user-name" class="form-control" id="user-name" placeholder="Your Name" required>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="email">이메일</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="address">주소</label>
                <input type="text" class="form-control" name="address" id="address" placeholder="Your Address" required>
              </div>

              <div class="form-group mt-3" align="left">
                <label for="interestArea">관심 지역 설정</label>
                <input type="text" class="form-control" name="address" id="address" placeholder="Your Address" required>
              </div>

              <div class="form-group mt-3 mb-3" id="imgFileUploadInsertWrapper" align="left">
                <p>프로필 사진 첨부</p>
                <input @change="changeFile" type="file" id="inputFileUploadInsert">
                <div id="imgFileUploadInsertThumbnail" class="thumbnail-wrapper">
                  <img v-for="(file, index) in fileList" v-bind:src="file" v-bind:key="index">
                </div>
              </div>
            
              <div class="text-center"><button type="submit" @click.prevent="test()">회원가입</button></div>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->
</template>

<script>
export default {
  name: 'SignUp',
  data() {
    return {
      fileList: [],
    }
  },
  methods: {
    changeFile(fileEvent) {
      if( fileEvent.target.files && fileEvent.target.files.length > 0 ){

        for( var i=0; i<fileEvent.target.files.length; i++ ){
          const file = fileEvent.target.files[i];
          this.fileList.push(URL.createObjectURL(file));
        }
      }
    },
  }
}
</script>

<style>

</style>