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
                      <td class="col-10">테스트입니다.</td>
                  </tr>
                  <tr class="d-flex">
                      <th class="col-2">작성자</th>
                      <td class="col-4">김싸피</td>
                      <th class="col-2">작성일</th>
                      <td class="col-4">2021-05-18</td>
                  </tr>
                  <tr class="d-flex">
                      <td class="col-12 d-flex align-items-center" style="min-height: 300px;">
                          글 내용
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
          <button class="btn-green" @click="moveToModify()">수정하기</button>
        </div>


        </div>
    </section>
  </main>
</template>

<script>
export default {
  name: 'NoticeDetail',
  methods: {
    moveToModify(){
      this.$router.push("/noticemodify");
    }
  }
}
</script>

<style>

</style>