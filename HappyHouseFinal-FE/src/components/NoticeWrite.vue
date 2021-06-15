<template>
  <main id="main">
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>글 작성</h2>
        </div>
        <div align="center" class="mb-5">

          <div class="col-lg-8 mt-5 mt-lg-0">
              <div class="form-group mt-3" align="left">
                <input type="text" class="form-control" name="title" v-model="title" placeholder="제목">
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
          <button type="submit"  class="btn-green me-2" @click.prevent="noticeInsert()">작성완료</button>
        </div>



      </div>
    </section>
  </main>
</template>

<script>
import Vue from 'vue';
import http from "@/common/axios.js";
import CKEditor from '@ckeditor/ckeditor5-vue2';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

Vue.use(CKEditor);

export default {
  name: 'NoticeWrite',
  data() {
    return {
      title: '',
      CKEditor: '',
    }
  },
  created(){
    
  },
  methods: {
    noticeInsert(){
      http.post(
          '/notices',
          { 
            title: this.title,
            content: this.CKEditor.getData()
          })
          .then(({ data }) => {
            //console.log("InsertNotice: data : ");
            console.log(data);
            if( data.result == 'login' ){
              this.$router.push("/login")
            }else{
              this.$alertify.success('글이 등록되었습니다.');
              this.$router.push("/noticelist")
            }
          })
          .catch((error) => {
            console.log("InsertNotice: error ");
            console.log(error);
          });
    },

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
  }
}
</script>

<style>
.ck-editor__editable {
    min-height: 400px !important;
}
</style>