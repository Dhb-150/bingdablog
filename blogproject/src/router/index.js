import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/login',
      name: 'login',
      //路由懒加载
      //当打包构建应用时，JavaScript 包会变得非常大，影响页面加载。
      //如果我们能把不同路由对应的组件分割成不同的代码块，
      //然后当路由被访问的时候才加载对应组件，这样就会更加高效。
      // 将import UserDetails from './views/UserDetails.vue'
      // 替换成const UserDetails = () => import('./views/UserDetails.vue')
      component: () => import('../views/Login/Login.vue')
    }
  ]
})

export default router
