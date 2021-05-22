<template>
  <div>
    <!--v-bins:isLogin 으로 로그인 여부, userInfo로 로그인 정보를 navBar쪽에 props로 보내준다. -->
    <app-nav></app-nav>
    <router-view></router-view>
    <app-footer></app-footer>
    <app-top></app-top>
    <!-- 로그인이 성공하면 emit으로 부모 호출한다 -> loginSuccess -->
  </div>
</template>

<script>

import AppNav from './components/AppNav.vue'
import AppFooter from './components/AppFooter.vue'
import AppTop from './components/AppTop.vue'


export default {
  name: 'App',
  components: {
    AppNav,
    AppFooter,
    AppTop,
  }
}
</script>


<style></style>