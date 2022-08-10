<template>
  <div class="header">
    <a href="/about">
      <div class="loginLink">로그인/회원가입</div>
    </a>
    <a href="/">
      <v-img
          :src="require('@/assets/logo.png')"
      />
    </a>
  </div>
</template>

<script>
export default {
  name: 'MainHeader'
}
</script>
<style scoped>
.header {
  height: 200px;
  background: #91D9CC no-repeat padding-box;
  opacity: 1;
}

a {
  text-decoration: none;
}

.loginLink {
  color: #333333;
}
</style>