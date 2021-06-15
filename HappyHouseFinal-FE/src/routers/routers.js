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
import House from "@/components/House.vue"; 
import Animal from "@/components/Animal.vue";  
import AnimalChart from "@/components/AnimalChart.vue"; 
import AnimalHospital from "@/components/AnimalHospital.vue"; 
import AnimalPharmacy from "@/components/AnimalPharmacy.vue"; 
import About from "@/components/About.vue";  

export default new VueRouter({
  routes: [
    {
      path: '/',component: Main
    },
    {
      name: 'MyPage',path: '/mypage',component: MyPage
    },
    {
      name: 'SignUp',path: '/signup',component: SignUp
    },
    {
      name: 'NoticeList',path: '/noticelist',component: NoticeList
    },
    {
      name: 'NoticeWrite',path: '/noticewrite',component: NoticeWrite
    },
    {
      name: 'NoticeModify',path: '/noticemodify',component: NoticeModify
    },
    {
      name: 'NoticeDetail',path: '/noticedetail',component: NoticeDetail
    },
    {
      name: "House",path: "/house",component: House
    },
    {
      name: "About",path: "/about",component: About
    },
    {
      path: "/animal",component: Animal,
      children: [
        { 
          path: "",component: AnimalChart
        },
        {
          path: "/animalhospital",component: AnimalHospital
        },
        {
          path: "/animalpharmacy",component: AnimalPharmacy
        }
      ]
    },
  ],
});