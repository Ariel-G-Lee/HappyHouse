<template>
  <main id="main">
    <section id="about" class="about">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>글 작성</h2>
        </div>
        <div align="center" class="mb-5">

          <div class="col-lg-8 mt-5 mt-lg-0">
              <div class="form-group mt-3" align="left">
                <label for="subject">제목</label>
                <input type="text" class="form-control" name="subject" id="subject">
              </div>
              <div class="form-group mt-3" align="left">
                <label for="contents">내용</label><br>
                <textarea class="form-control col-sm-5" name="contents" id="contents" rows="10"></textarea>
              </div>
          </div>

        </div>
        
        <div align="center">
          <button class="btn btn-secondary">작성완료</button>
          <button class="btn btn-outline-secondary">취소</button>
        </div>

      </div>
    </section>
  </main>
</template>

<script>
export default {
  name: 'NoticeWrite',
}
</script>

<style>

</style>