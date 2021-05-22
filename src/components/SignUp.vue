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
                <input type="text" class="form-control" name="user-id" v-model="userId" placeholder="Your ID" required>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="password">비밀번호</label>
                <input type="password" class="form-control" name="user-pwd" v-model="userPwd" placeholder="Your Password" required>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="user-name">이름</label>
                <input type="text" name="user-name" class="form-control" v-model="userName" placeholder="Your Name" required>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="email">이메일</label>
                <input type="email" class="form-control" name="email" v-model="email" placeholder="Your Email" required>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="address">주소</label>
                <input type="text" class="form-control" name="address" v-model="address" placeholder="Your Address" required>
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
                <p>프로필 사진 첨부</p>
                <input @change="changeFile" type="file" id="inputFileUploadInsert">
                <div id="imgFileUploadInsertThumbnail" class="thumbnail-wrapper">
                  <img v-for="(file, index) in fileList" v-bind:src="file" v-bind:key="index">
                </div>
              </div>
            
              <div class="text-center">
                <button type="submit" @click.prevent="userInsert()">회원가입</button>
              </div>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->
</template>

<script>
import Vue from 'vue';
import http from "@/common/axios.js";
import VueAlertify from 'vue-alertify'; 

Vue.use(VueAlertify);

export default {
  name: 'SignUp',
  data() {
    return {
      userId: '',
      userName: '',
      userPwd: '',
      email: '',
      address: '',
      interestArea: '동',

      fileList: [],

      sidoOptions : [],
      gugunOptions : [],
      dongOptions : [],

      sidoSelected : '도/광역시',
      gugunSelected : '시/구/군',

    }
  },
  created: function(){
    this.sidoSelected = '도/광역시';
    this.gugunSelected = '시/구/군';
    this.interestArea = '동';
    http
      .get('/area/sido')
      .then(({ data }) => {
        // console.log("sido data : ");
        this.sidoOptions = data;
        console.log(this.sidoOptions);
        if( data.result == 'login' ){
          this.$router.push("/login")
        }
      })
      .catch((error) => {
        console.log(error);
      });
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
    userInsert(){
      var formData = new FormData();
        formData.append("userId", this.userId);
        formData.append("userName", this.userName);
        formData.append("userPwd", this.userPwd);
        formData.append("email", this.email);
        formData.append("address", this.address);
        if(this.interestArea != "동") formData.append("interestArea", this.interestArea);

        // file upload
        var attachFiles = document.querySelector("#inputFileUploadInsert");
        console.log("InsertUser: data 1 : ");
        console.log(attachFiles);

        var cnt = attachFiles.files.length;
        for (var i = 0; i < cnt; i++) {
          formData.append("file", attachFiles.files[i]);
        }

        http.post(
          '/users',
          formData,
          { headers: { 'Content-Type': 'multipart/form-data' } })
          .then(({ data }) => {
            console.log("InsertUser: data : ");
            console.log(data);
            if( data.result == 'login' ){
              this.$router.push("/login")
            }else{
              this.$alertify.alert('회원 가입 성공', '회원 가입이 완료되었습니다.');
              this.$router.push("/");
            }
          })
          .catch((error) => {
            console.log("InsertUser: error ");
            console.log(error);
          });
    },
    updateGugun() {
      this.gugunSelected = '시/구/군';
      this.interestArea = '동';
      http
      .get('/area/gugun?sidoCode='+this.sidoSelected)
      .then(({data}) => {        
      let list = [];
      data.forEach((el) =>{
        if(el['sidoCode'] == this.sidoSelected){
          list.push(el);
        }
      })
                
      this.gugunOptions = list;
      // console.log(data);
      })
      .catch((error) =>{
        console.log(error);
      })
    },
    // 동코드 업데이트
    updateDong() {
      this.interestArea = '동';
      http
      .get('/area/dong?gugunCode='+this.gugunSelected)
      .then(({data}) => {
                
      let list = [];
      // 원래 디비에서 필터할 활동
      data.forEach((el) =>{
        if(el['gugunCode'] == this.gugunSelected){
          list.push(el);
        }
      })
      this.dongOptions = list;
      })
      .catch((error) =>{
        console.log(error);
      })
    },
  }
}
</script>

<style>
.selectbox{
  width: 200px;
}
.thumbnail-wrapper{
    margin-top: 5px;
}

.thumbnail-wrapper img {
    width: 100px !important;
    margin-right: 5px;
    max-width: 100%;
}
</style>
