// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
var axios = require('axios')

axios.defaults.baseURL = 'http://localhost:8443/api'
/* 全局注册,之后可以在其组件中通过this.$axios发送数据 */
Vue.prototype.$axios = axios

Vue.config.productionTip = false

Vue.use(ElementUI)
/* eslint-disable no-new */

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
