import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import SignUp from '@/components/SignUp'
import About from '@/components/About'
import Grammar from '@/components/Grammar'
import Translator from '@/components/Translator'
Vue.use(Router)

export default new Router({
  routes: [

    {
      path:'/',
      name:'AppIndex',
      component:AppIndex
    },

    {
      path: '/login',
      name: 'Login',
      component: Login
    },

    {
        path: '/signup',
        name: 'SignUp',
        component:SignUp
    },

    {
        path: '/grammar',
        name: 'Grammar',
        component:Grammar
    },

    {
      path: '/translator',
      name:'Translator',
      component:Translator
    },

    {
      path: '/about',
      name: 'About',
      component:About
    }
  ]
})
