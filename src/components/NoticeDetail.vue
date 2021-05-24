<template>
  <main id="main">
    <section id="about" class="about">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
        </div>
        <div align="center" class="mb-5">

          <div class="col-lg-8 mt-5 mt-lg-0">
            <table class="table">
              <tbody>
                  <tr class="d-flex">
                      <th class="col-2">제목</th>
                      <td class="col-10">{{ $store.state.notice.title }}</td>
                  </tr>
                  <tr class="d-flex">
                      <th class="col-2">작성자</th>
                      <td class="col-4">{{ $store.state.notice.userName }}</td>
                      <th class="col-2">작성일</th>
                      <td class="col-4">{{ $store.state.notice.regDt }}</td>
                  </tr>
                  <tr class="d-flex">
                      <td class="col-12 d-flex align-items-center" style="min-height: 300px;"
                      v-html="$store.state.notice.content">
                      </td>
                  </tr>
              </tbody>
            </table>
            <div align="right">
              <router-link to="/noticelist" class="text-dark">목록으로</router-link>
            </div>
          </div>

        </div>

        <div align="center">
          <button class="btn-green" v-if="$store.state.notice.isOwner" @click="moveToModify()">수정하기</button>
          <button type="submit"  v-if="$store.state.notice.isOwner" class="btn-white ms-2" @click.prevent="noticeDelete()">삭제하기</button>
        </div>


        </div>
    </section>
  </main>
</template>

<script>
import http from "@/common/axios.js";
export default {
  name: 'NoticeDetail',
  methods: {
    moveToModify(){
      this.$router.push("/noticemodify");
    },
    noticeDelete(){
      console.log("modify"+this.$store.state.notice.noticeId);
      http.delete(
        "/notices/" + this.$store.state.notice.noticeId
        )
        .then(({ data }) => {
          console.log("DeleteNotice: data : ");
          console.log(data);
          if( data.result == 'login' ){
            this.$router.push("/login")
          }else{
            this.$alertify.success('글이 삭제되었습니다.');
            this.$router.push("/noticelist");
          }
        })
        .catch( error => {
            console.log(error)
        });
      }
  }
}
</script>

<style>

</style>