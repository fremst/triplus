<template>
  <div class="login">
    <div class="login_title">로그인</div>

    <form>
    <div class="login_form">
      <input placeholder="아이디를 입력하세요" type="text" v-model="id">
      <input placeholder="비밀번호를 입력하세요" type="password" v-model="pwd">
      <input type="checkbox"> 로그인 유지하기
      <div>{{errMsg}}</div>
      <input type="submit" value="로그인" @click.prevent="login">
    </div>
    </form>

      <div class="login_insert">아직 회원이 아닙니까? <a @click.prevent="">회원 가입하기</a></div>
      <div class="login_findpwd">아이디 또는 비밀번호를 잊었습니까?<a @click.prevent="">아이디 비밀번호 찾기</a></div>

    <div class="login_sns">

    </div>
    ID
    {{$store.state.loginUser.id}}


  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: "LoginView",
  data(){
    return{
      id:"",
      pwd:"",
      auth:"",
      name:"",
      tel:"",
      gender:"",
      addr:"",
      email:"",
      bdate:"",
      regdate:"",
      active:"",

      errMsg:"", 
    }
  },
  methods:{
    login(){
        const joinparam = new URLSearchParams();
        joinparam.append('id',this.id);
        joinparam.append('pwd',this.pwd);
        
        axios.post('http://localhost:8082/triplus/member/login',joinparam,{
            headers:{
                'Access-Control-Allow-Origin': '*'
            }
        }).then(function(resp){
            if(resp.data=='success'){
              this.auth = resp.data.dto.auth;
              this.name = resp.data.dto.name;
              this.tel = resp.data.dto.tel;
              this.gender = resp.data.dto.gender;
              this.addr = resp.data.dto.addr;
              this.email = resp.data.dto.email;
              this.bdate = resp.data.dto.bdate;
              this.regdate = resp.data.dto.regdate;
              this.active = resp.data.dto.active;

                 this.$store.dispatch('loginInfo',{id:this.id,pwd:this.pwd,auth:this.auth,name:this.name,
                                tel:this.tel,gender:this.gender,addr:this.addr,email:this.email,
                                bdate:this.bdate,regdate:this.regdate,active:this.active});
              
            }else{
              this.errMsg = '아이디 또는 비밀번호를 잘못 입력했습니다';
            }
        }.bind(this));
    }
  }

}
</script>

<style scoped>

</style>