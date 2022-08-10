import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import QnAView from '../views/member/service/QnAView.vue'
import QnAWriteView from '../views/member/service/QnAWriteView.vue'
import QnADetailView from '../views/member/service/QnADetailView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/service/qna',
    name: 'qna',
    component: QnAView
  },
  {
    path: '/service/qna/write',
    name: 'qna-write',
    component: QnAWriteView
  },
  {
    path: '/service/qna/detail',
    name: 'qna-detail',
    component: QnADetailView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
