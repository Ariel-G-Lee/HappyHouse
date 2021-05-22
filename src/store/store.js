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
      profileImageUrl: "",
    },
  },
  mutations: {
    SET_LOGIN(state, payload) {
      state.login.isLogin = payload.isLogin;
      state.login.userName = payload.userName;
      state.login.profileImageUrl = payload.profileImageUrl;
    },
  },
  actions: {
    //
  },
  getters: {
    isLogin: function(state) {
      return state.login.isLogin;
    },
  },
});
