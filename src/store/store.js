import Vue from "vue";
import Vuex from "vuex";
import http from "@/common/axios.js";
import router from '@/routers/routers.js'
Vue.use(Vuex);

// import http from "@/common/axios.js";
// import router from "@/routers/routers.js";

export default new Vuex.Store({
  state: {
    login: {
      isLogin: false,
      userId: "testid",
      userName: "testname",
      userPwd: "testpwd",
      email: "test@test.com",
      address: "testaddress",
      interestArea: "",
      profileImageUrl: "",
      userCode: ""
    },
    notice:{
      // list
      list: [],
      limit: 10,
      offset: 0,
      searchWord: '',

      // pagination
      listRowCount: 10,
      pageLinkCount: 5,
      currentPageIndex: 1,

      totalListItemCount: 0,

      // detail, update, delete
      noticeId: 0,
      title: '',
      content: '',
      userName: '',
      regDt: {},
      readCount: 0,
      isOwner: false
    },
    house:{
      // list
      list: [],
      limit: 10,
      offset: 0,
      searchOption: '',
      searchKeyword: '',

      // pagination
      listRowCount: 10,
      pageLinkCount: 5,
      currentPageIndex: 1,

      totalListItemCount: 0,

      // detail
      no: 0,
      dongName:'',
      aptName:'',
      dealAmount:'',
      area:'',
      buildYear:'',
      dealMonth:'',
      dealDay:'',
      lat:'',
      lng:'',
    }
  },
  mutations: {
    SET_LOGIN(state, payload) {
      state.login.isLogin = payload.isLogin;
      state.login.userName = payload.userName;
      state.login.email = payload.email;
      state.login.address = payload.address;
      state.login.interestArea = payload.interestArea;
      state.login.profileImageUrl = payload.profileImageUrl;
    },
    SET_USER_UPDATE(state, payload) {
      state.login.userPwd = payload.userPwd;
      state.login.userName = payload.userName;
      state.login.email = payload.email;
      state.login.address = payload.address;
      state.login.interestArea = payload.interestArea;
      if (payload.profileImageUrl != null) {
        state.login.profileImageUrl = payload.profileImageUrl;
      }
    },
    SET_NOTICE_LIST(state, list){
      state.notice.list = list
    },

    SET_NOTICE_TOTAL_LIST_ITEM_COUNT(state, count){
      state.notice.totalListItemCount = count
    },

    SET_NOTICE_MOVE_PAGE(state, pageIndex){
      state.notice.offset = (pageIndex - 1) * state.notice.listRowCount;
      state.notice.currentPageIndex = pageIndex;
    },

    SET_NOTICE_DETAIL(state, payload) {
      state.notice.noticeId = payload.noticeId;
      state.notice.title = payload.title;
      state.notice.content = payload.content;
      state.notice.userName = payload.userName;
      state.notice.regDt = payload.regDt;
      state.notice.isOwner = payload.isOwner;
    },

    SET_HOUSE_LIST(state, list) {
      state.house.list = list;
    },
    SET_HOUSE_TOTAL_LIST_ITEM_COUNT(state, count) {
      state.house.totalListItemCount = count;
    },

    SET_HOUSE_MOVE_PAGE(state, pageIndex) {
      state.house.offset = (pageIndex - 1) * state.house.listRowCount;
      state.house.currentPageIndex = pageIndex;
    },

    SET_HOUSE_DETAIL(state, payload) {
      state.house.no= payload.no;
      state.house.dongName= payload.dongName;
      state.house.aptName= payload.aptName;
      state.house.dealAmount= payload.dealAmount;
      state.house.area= payload.area;
      state.house.buildYear= payload.buildYear;
      state.house.dealMonth= payload.dealMonth;
      state.house.dealDay= payload.dealDay;
      state.house.lat= payload.lat;
      state.house.lng= payload.lng;

    },
  },
  actions: {
    noticeList(context){
      http.get(
        "/notices",
        {
          // get query string
          params: {
            limit: this.state.notice.limit,
            offset: this.state.notice.offset,
            searchWord: this.state.notice.searchWord
          }
        })
        .then(({ data }) => {
          console.log("NoticeList: data : ");
          console.log(data);
          if( data.result == 'login' ){ 
            router.push("/login")
          }else{
            context.commit( 'SET_NOTICE_LIST', data.list );
            context.commit( 'SET_NOTICE_TOTAL_LIST_ITEM_COUNT', data.count );
          }
      });
    },
    houseList(context){
      http.get(
        "/houses",
        {
          // get query string
          params: {
            limit: this.state.house.limit,
            offset: this.state.house.offset,
            searchOption: this.state.house.searchOption,
            searchKeyword: this.state.house.searchKeyword
          }
        })
        .then(({ data }) => {
          console.log("HouseList: data : ");
          console.log(data);
          if( data.result == 'login' ){ 
            router.push("/login")
          }else{
            context.commit( 'SET_HOUSE_LIST', data.list );
            context.commit( 'SET_HOUSE_TOTAL_LIST_ITEM_COUNT', data.count );
          }
      });
    }
  },
  getters: {
    isLogin: function(state) {
      return state.login.isLogin;
    },
    getNoticeList : function(state){
      return state.notice.list;
    },
    getHouseList : function(state){
      return state.house.list;
    },
  },
});
