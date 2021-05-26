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

            <img v-bind:src="profileImg" alt="" class="d-inline-block align-text-top profile-img">
            <form action="forms/contact.php" method="post" role="form" class="php-email-form">
              <div class="form-group mt-3" align="left">
                <label for="user-id">아이디</label>
                <input type="text" class="form-control" name="user-id" id="user-id" required readonly v-model=userId>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="password">비밀번호</label>
                <input type="password" class="form-control" name="user-pwd" id="user-pwd" required v-model=userPwd>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="user-name">이름</label>
                <input type="text" name="user-name" class="form-control" id="user-name" required v-model=userName>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="email">이메일</label>
                <input type="email" class="form-control" name="email" id="email" v-model=email>
              </div>
              <div class="form-group mt-3" align="left">
                <label for="address">주소</label>
                <input type="text" class="form-control" name="address" id="address" v-model=address>
              </div>

              <div class="form-group mt-3" align="left">
                <label>관심 지역 설정</label>
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
                        <select v-model="dongSelected" class="form-select py-2 btn btn-light">
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

              <div class="text-center"><button type="submit" @click.prevent="userModify()">수정</button>
              <div align="right"><a href="#" @click.prevent="userDelete()">탈퇴하기</a></div></div>
            </form>

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
  name: 'MyPage',
  data(){
    return{

      userId: "",
      userName: "",
      userPwd: "",
      email: "",
      address: "",
      interestArea: "",
      profileImageUrl: "",
      
      sidoOptions : [],
      gugunOptions : [],
      dongOptions : [],

      fileList: [],

      sidoSelected : '도/광역시',
      gugunSelected : '시/구/군',
      dongSelected: '동',
    }
  },
  created: function(){
    // console.log(this.$store.state.login.profileImageUrl);
    this.userId = this.$store.state.login.userId;
    this.userName = this.$store.state.login.userName;
    this.userPwd = this.$store.state.login.userPwd;
    this.email = this.$store.state.login.email;
    this.address = this.$store.state.login.address;
    this.interestArea = this.$store.state.login.interestArea;
    this.profileImageUrl = this.$store.state.login.profileImageUrl; 
    // 데이터들 가져오고 동코드 기반으로, 시, 도, 가져오기!
    http
      .get('/area/sido')
      .then(({ data }) => {
        // console.log("sido data : ");
        this.sidoOptions = data;
        // console.log(this.sidoOptions);
      })
      .catch((error) => {
        console.log(error);
      });

    if(this.$store.state.login.interestArea != undefined){
      this.sidoSelected = this.$store.state.login.interestArea.substr(0,2);
      this.updateGugun();
      this.gugunSelected = this.$store.state.login.interestArea.substr(0,5);
      this.updateDong();
      this.dongSelected = this.$store.state.login.interestArea
    }
    
    // console.log(this.gugunSelected);
  },
  computed: {
    profileImg(){
      if( this.$store.state.login.profileImageUrl == undefined) {
        return '/img/noProfile.png';
      }else{
        return '/' + this.$store.state.login.profileImageUrl;
      }
    }
  },
  methods: {
    
    updateGugun() {
      this.gugunSelected = '시/구/군';
      this.dongSelected = '동';
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
    updateDong() {
      this.dongSelected = '동';
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

    changeFile(fileEvent) {
      this.fileList = [];
      if( fileEvent.target.files && fileEvent.target.files.length > 0 ){
        for( var i=0; i<fileEvent.target.files.length; i++ ){
          const file = fileEvent.target.files[i];
          this.fileList.push(URL.createObjectURL(file));
        }
      }
    },
    userModify() {
      var formData = new FormData();
        formData.append("userId", this.userId);
        formData.append("userName", this.userName);
        formData.append("userPwd", this.userPwd);
        formData.append("email", this.email);
        formData.append("address", this.address);
        if(this.dongSelected != "동") formData.append("interestArea", this.dongSelected);

    // file upload
    var attachFiles = document.querySelector("#inputFileUploadInsert");
    //console.log("InsertUser: data 1 : ");
    console.log(attachFiles);

    var cnt = attachFiles.files.length;
    for (var i = 0; i < cnt; i++) {
      formData.append("file", attachFiles.files[i]);
    }

    http.post(
      '/users/' + this.$store.state.login.userId, // store boardId 
      formData,
      { headers: { 'Content-Type': 'multipart/form-data' } })
      .then(({ data }) => {
        //console.log("UpdateUser: data : ");
        console.log(data);
        this.$store.commit(
        'SET_USER_UPDATE',
        { userPwd: data.userPwd, userName: data.userName, email: data.email,
          address: data.address, interestArea: data.interestArea,
          profileImageUrl: data.profileImageUrl},
        );
        //console.log(this.$store.state.login.profileImageUrl);
        this.$alertify.alert('회원 정보 수정 성공','회원 정보가 수정 되었습니다.');
      
      })
      .catch((error) => {
        //console.log("UpdateUser: error ");
        console.log(error);
      });
      },
      userDelete(){
      http.delete(
          '/users/' + this.$store.state.login.userId)
          .then(({ data }) => {
            //console.log("UpdateUser: data : ");
            console.log(data);
<<<<<<< HEAD
            if( data.result == 'login' ){
              this.$router.push("/login")
            }else{
              this.$store.state.login.isLogin = false;
              this.$alertify.alert('회원 탈퇴 성공','회원 탈퇴되었습니다.');
              this.$router.push("/")
            }
=======
            this.$store.state.login.isLogin = false;
            this.$alertify.alert('회원 탈퇴 성공','회원 탈퇴되었습니다.');
            this.$router.push("/")
>>>>>>> 596da778adad70dc3c14ec53a92ecab099103084
          })
          .catch((error) => {
            //console.log("UpdateUser: error ");
            console.log(error);
          });
      }
    }

  }

</script>

<style>
.profile-img{
  width: 120px;
  height: 120px;
  border-radius: 50%;
}
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