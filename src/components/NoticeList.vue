<template>
  <main id="main">
    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>공지사항</h2>
        </div>

        <div align="center" class="mb-5">

          <div class="col-lg-10 mt-5 mt-lg-0">
          
            <div class="justify-content-end input-group">
              <div class="d-flex form-row float-right" >
                <input class="form-control me-2">
              </div>
              <div>
                <button class="btn-green">검색</button>
              </div>
            </div>
          
            <table class="table table-hover">
              <thead>
                <tr>
                  <th style="width: 10%">번호</th>
                  <th style="width: 55%">제목</th>
                  <th style="width: 20%">작성자</th>
                  <th style="width: 15%">작성일시</th>
                </tr>
              </thead>
              <tbody>
                <tr @click="moveToDetail()">
                  <td>1</td>
                  <td>테스트입니다.</td>
                  <td>김싸피</td>
                  <td>2021-05-18</td>
                </tr>
              </tbody>
            </table>
    
            <div align="right">
              <router-link to="/noticewrite">글작성</router-link>
            </div>
    
            <nav aria-label="Page navigation example">
              <ul class="pagination justify-content-center">
                <li class="page-item">
                  <a class="page-link text-dark" href="#">이전</a>
                </li>
                <li class="page-item"><a class="page-link text-dark" href="#">1</a></li>
                <li class="page-item"><a class="page-link text-dark" href="#">2</a></li>
                <li class="page-item"><a class="page-link text-dark" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link text-dark" href="#">다음</a>
                </li>
              </ul>
            </nav>
          </div>
          
        </div>

      </div>
    </section><!-- End Contact Section -->
  </main><!-- End #main -->
</template>

<script>
export default {
  name: 'NoticeList',
  methods: {
    moveToDetail(){
      this.$router.push("/noticedetail");
    }
  }
}
</script>

<style>

</style>