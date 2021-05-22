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

            <img v-bind:src="requireImg" class="d-inline-block align-text-top profile-img">
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
                <label for="interestArea">관심 지역 설정</label>
                  <div class="d-flex mt-2">
                      <div class="selectbox me-2">
                        <select v-model="sidoSelected" @change="updateGugun" class="form-select py-2 btn btn-light">
                          <option selected>도/광역시</option>
                          <option v-for="(option, index) in sidoOptions" :key="index" :value="option.sidoCode" >{{option.sidoName}}</option>
                        </select>
                      </div>
                      <div class="selectbox me-2">
                        <select v-model="gugunSelected" @change="updateDong" class="form-select py-2 btn btn-light">
                          <option selected>시/구/군</option>
                          <option v-for="(option, index) in gugunOptions" :key="index" :value="option.gugunCode">{{option.gugunName}}</option>
                        </select>
                      </div>
                      <div class="selectbox">
                        <select v-model="interestArea" class="form-select py-2 btn btn-light">
                          <option selected>동</option>
                          <option v-for="(option, index) in dongOptions" :key="index" :value="option.dongCode">{{option.dongName}}</option>
                        </select>
                      </div>

                  </div>
              </div>

              <div class="form-group mt-3 mb-3" id="imgFileUploadInsertWrapper" align="left">
                <p>프로필 사진 변경</p>
                <input @change="changeFile" type="file" id="inputFileUploadInsert">
                <div id="imgFileUploadInsertThumbnail" class="thumbnail-wrapper">
                  <img v-for="(file, index) in fileList" v-bind:src="file" v-bind:key="index">
                </div>
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
  computed: {
    requireImg : function(){
      if( this.$store.state.login.profileImageUrl == '' ) {
        return require('../assets/img/noProfile.png')
      }else{
        return require('../assets' + this.$store.state.login.profileImageUrl);
      }
    }
  },
  created: function(){
    // 데이터들 가져오고 동코드 기반으로, 시, 도, 가져오기!
  }
}
</script>

<style>
.profile-img{
  width: 150px;
  height: 150px;
  border-radius: 50%;
}
</style>