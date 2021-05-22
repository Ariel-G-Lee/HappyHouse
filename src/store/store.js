import Vue from "vue";
import Vuex from "vuex";

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
      pageLinkCount: 10,
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
  },
  actions: {

  },
  getters: {
    isLogin: function(state) {
      return state.login.isLogin;
    },
  },
});
