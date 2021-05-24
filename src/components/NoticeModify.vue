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
                <input type="text" class="form-control" name="title" id="title" v-model="title">
              </div>
              <div class="form-group mt-3" align="left">
                <!-- <textarea class="form-control col-sm-5" name="contents" id="contents" rows="10"></textarea> -->
                <div class="mb-3">
                  <div id=divEditorModify></div>
                </div>
              </div>
          </div>

        </div>
        
        <div align="center">
          <button type="button" class="btn-green" @click="noticeModify()">수정완료</button>
        </div>


        </div>
    </section>
  </main>
</template>

<script>
import Vue from 'vue';
import CKEditor from '@ckeditor/ckeditor5-vue2';
import http from "@/common/axios.js";
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

Vue.use(CKEditor);
export default {
  name: 'NoticeModify',
  data(){
    return{
      title: '',
      CKEditor: ''
    }
  },
  created: function(){


  },
  methods: {
    noticeModify(){
      console.log(this.title);
      console.log(this.CKEditor.getData());
      http.put(
        '/notices/' + this.$store.state.notice.noticeId,
        { 
            title: this.title,
            content: this.CKEditor.getData()
           })
        .then(({ data }) => {
        console.log("UpdateNotice: data : ");
        console.log(data);
        if( data.result == 'login' ){
          this.$router.push("/login")
        }else{
          this.$store.state.notice.title = this.title;
          this.$store.state.notice.content = this.CKEditor.getData();
          this.$alertify.success('글이 수정되었습니다.');
          this.$router.push("/noticelist");    
        }
        })
        .catch((error) => {
          console.log("UpdateModalVue: error ");
          console.log(error);
        });
    },
  },
  mounted() {
    let $this = this;
    this.title = this.$store.state.notice.title;
    ClassicEditor
    .create(document.querySelector('#divEditorModify'))
    .then(editor => {
      this.CKEditor = editor;
      this.CKEditor.setData( $this.$store.state.notice.content );
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