import Vue from "vue";
import App from "./App.vue";
import router from "./routers/routers.js";
import store from "./store/store.js";

// for bootstrap 5
// 부트스트랩을 사용할 수 있도록
// 다른 페이지에서 필요한 경우만 쓰면 됨
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.min.js";
import "./assets/css/style.css";

Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
  router,
  store,
}).$mount("#app");
