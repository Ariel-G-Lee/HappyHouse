import Vue from "vue"; // defalut module
import VueRouter from "vue-router"; // installed module

Vue.use(VueRouter);

import Main from '@/components/Main.vue';
import SignUp from '@/components/SignUp.vue';
import MyPage from '@/components/MyPage.vue';
import NoticeList from '@/components/NoticeList.vue';
import NoticeWrite from '@/components/NoticeWrite.vue';
import NoticeModify from '@/components/NoticeModify.vue';
import NoticeDetail from '@/components/NoticeDetail.vue';

export default new VueRouter({
  routes: [
    {
      path: '/',
      component: Main
    },
    {
      name: 'MyPage',
      path: '/mypage',
      component: MyPage
    },
    {
      name: 'SingUp',
      path: '/signup',
      component: SignUp
    },
    {
      name: 'NoticeList',
      path: '/noticelist',
      component: NoticeList
    },
    {
      name: 'NoticeWrite',
      path: '/noticewrite',
      component: NoticeWrite
    },
    {
      name: 'NoticeModify',
      path: '/noticemodify',
      component: NoticeModify
    },
    {
      name: 'NoticeDetail',
      path: '/noticedetail',
      component: NoticeDetail
    }
  ],
});