import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import login from '../components/login.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path:'/person',
    name:'person',
    component:() => import('../views/person.vue'),
    meta:{
      requireLogin:true
    }
  },
  {
    path: '/home',
    name: 'home',
    component: Home,
    meta:{
      requireLogin:true
    }
  },
]

const router = new VueRouter({
  routes
})

export default router
