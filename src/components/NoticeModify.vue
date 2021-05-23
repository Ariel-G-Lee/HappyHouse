<template>
  <main id="main">
    <section id="about" class="about">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>글 수정</h2>
        </div>
         <div align="center" class="mb-5">

          <div class="col-lg-8 mt-5 mt-lg-0">
              <div class="form-group mt-3" align="left">
                <input type="text" class="form-control" name="title" id="title">
              </div>
              <div class="form-group mt-3" align="left">
                <!-- <textarea class="form-control col-sm-5" name="contents" id="contents" rows="10"></textarea> -->
                <div class="mb-3">
                  <div id=divEditorInsert></div>
                </div>
              </div>
          </div>

        </div>
        
        <div align="center">
          <button type="button" class="btn-green" @click="noticeModify()">수정완료</button>
          <button type="submit"  class="btn-white ms-2" @click.prevent="noticeDelete()">삭제하기</button>
        </div>


        </div>
    </section>
  </main>
</template>

<script>
import Vue from 'vue';
import CKEditor from '@ckeditor/ckeditor5-vue2';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

Vue.use(CKEditor);
export default {
  name: 'NoticeModify',
  methods: {
    noticeModify(){

    },
    noticeDelete(){
      
    }
  },
  mounted() {
    ClassicEditor
    .create(document.querySelector('#divEditorInsert'))
    .then(editor => {
        this.CKEditor = editor;
    })
    .catch(err => {
        console.error(err.stack);
    });
  },
}
</script>

<style>
.ck-editor__editable {
    min-height: 400px !important;
}
</style>