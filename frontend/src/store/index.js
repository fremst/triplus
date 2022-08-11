import { createStore } from 'vuex'

export default createStore({
  state: {
    loginUser:{id:"",pwd:"",auth:"",name:"",tel:"",gender:"",addr:"",email:"",bdate:"",regdate:"",active:""}
       
    
  },
  getters: {
  },
  mutations: {
    loginInfo:function(state,payload){
      state.loginUser=payload;
    }
  },
  actions: {
    loginInfo:function(context,payload){
      context.commit('loginInfo',payload);
   }
  },
  modules: {
  }
})
