<template>
  <main id="main">
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>공지사항</h2>
        </div>

        <div align="center" class="mb-5">

          <div class="col-lg-10 mt-5 mt-lg-0">
          
            <div class="justify-content-end input-group mb-3 d-flex">
              <div class=" form-row float-right me-2 mt-1" >
                <input v-model="searchWord" @keydown.enter="noticeSearch" type="text" placeholder="검색어 입력" class="form-control me-2">
              </div>
              <div>
                <button class="btn-green" @click="noticeSearch">검색</button>
              </div>
            </div>
            <div class="notice-list">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th style="width: 10%">번호</th>
                  <th style="width: 45%">제목</th>
                  <th style="width: 20%">작성자</th>
                  <th style="width: 15%">작성일시</th>
                  <th style="width: 10%">조회수</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(notice, index) in listGetters" @click="noticeDetail(notice.noticeId)" v-bind:key="index">
                  <td>{{ ($store.state.notice.currentPageIndex-1)*10+index+1 }}</td>
                  <td>{{ notice.title }}</td>
                  <td>{{ notice.userName }}</td>
                  <td>{{ formatDate[index] }}</td>
                  <td>{{ notice.readCount }}</td>
                </tr>
              </tbody>
            </table>
            </div>
    
            <div align="right">
              <router-link v-if="$store.state.login.userCode=='001'" to="/noticewrite">글작성</router-link>
            </div>

            <pagination v-on:call-parent="movePage"></pagination>
          </div>
          
        </div>

      </div>
    </section>
  </main>
</template>

<script>
import Pagination from './Pagination.vue';
import util from "@/common/util.js";
import http from "@/common/axios.js";

export default {
  name: 'NoticeList',
  components: { Pagination },
  data(){
    return {
      searchWord: ''
    }
  },
  computed: {
    listGetters(){
      return this.$store.getters.getNoticeList;
    },
    formatDate : function(){
      let $this = this;
      return this.$store.state.notice.list.map( function( notice ){
      return $this.makeDateStr(notice.regDt.date.year, notice.regDt.date.month, notice.regDt.date.day, '.')
      });
    }
  },
  methods: {
    noticeSearch(){
      // 페이지 초기화
      this.$store.state.notice.offset = 0;
      this.$store.state.notice.currentPageIndex = 1;
      this.$store.state.notice.searchWord = this.searchWord;
      this.noticeList();
    },
    noticeList(){
      this.$store.dispatch('noticeList');
    },

    // 페이지 이동
    movePage(pageIndex){
      console.log("NoticeMainVue : movePage : pageIndex : " + pageIndex );
      this.$store.commit( 'SET_NOTICE_MOVE_PAGE', pageIndex );
      this.noticeList();
    },

    makeDateStr : util.makeDateStr,

    noticeDetail(noticeId){
      http.get(
      '/notices/'+noticeId,
      )
      .then(({ data }) => {
        console.log("DetailNotice: data : ");
        console.log(data);

        if( data.result == 'login' ){
          this.$router.push("/login")
        }else{
          this.$store.commit(
            'SET_NOTICE_DETAIL',
            {  
              noticeId: data.dto.noticeId,
              userName: data.dto.userName,
              title: data.dto.title,
              content: data.dto.content,
              regDt: this.makeDateStr(data.dto.regDt.date.year, data.dto.regDt.date.month, data.dto.regDt.date.day, '.'),
              isOwner: data.isOwner, // not data.dto.isOwner
            }
          );
          this.$router.push("/noticedetail");
        }
      })
      .catch((error) => {
        console.log("DetailModalVue: error ");
        console.log(error);
      });
    }
    
  },
  created() {
    // 페이지 초기화
    this.$store.state.notice.offset = 0;
    this.$store.state.notice.currentPageIndex = 1;
    this.$store.state.notice.searchWord = '';
    this.noticeList();
    // 상세 초기화
    this.$store.state.notice.noticeId = 0;
    this.$store.state.notice.title = '';
    this.$store.state.notice.content = '';
    this.$store.state.notice.userName = '';
    this.$store.state.notice.regDt = '';
    this.$store.state.notice.readCount = '';
    this.$store.state.notice.isOwner = false;
  },
}
</script>

<style>
.notice-list{
  height: 460px;
}
</style>