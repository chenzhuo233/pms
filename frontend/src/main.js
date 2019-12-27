import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'

Vue.prototype.$axios = axios    //把axios挂载到vue的原型中，在vue中每个组件都可以使用axios发送请求

Vue.use(ElementUI)
Vue.config.productionTip = false

router.beforeEach((to,from,next)=>{
  if(to.matched.some(record => record.meta.requireLogin)){
    if(sessionStorage.getItem('loginInfo')){
      next();
    }
    else{
      alert("你还没登录")
      next({
        path:'/'
      });
    }
  }else{
    next();
  }
})

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
