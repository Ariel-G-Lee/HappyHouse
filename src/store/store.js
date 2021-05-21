import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import http from "@/common/axios.js";
import router from "@/routers/routers.js";

export default new Vuex.Store({
  state: {
    login: {
      isLogin: false,
      userId: "testid",
      userName: "testname",
      userPwd: "testpwd",
      Email: "test@test.com",
      Address: "testaddress",
    },
  },
  mutations: {
    SET_LOGIN(state, payload) {
      state.login.isLogin = payload.isLogin;
      state.login.userName = payload.userName;
      state.login.userProfileImageUrl = payload.userProfileImageUrl;
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
