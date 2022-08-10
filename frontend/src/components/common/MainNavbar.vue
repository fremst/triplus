<template>
  <v-tabs
      background-color="#91D9CC" centered="true"
  >
    <v-tab class="tab" href="/">
      <v-icon>fa-solid fa-house</v-icon>
      홈
    </v-tab>
    <v-tab class="tab" href="/about">
      <v-icon>fa-house</v-icon>
      패키지
    </v-tab>
    <v-tab class="tab" href="/">
      <v-icon>mdi-auto_stories</v-icon>
      매거진
    </v-tab>
    <v-tab class="tab" href="/">
      <v-icon>mdi-home</v-icon>
      관광명소
    </v-tab>
    <v-tab class="tab" href="/">
      <v-icon>mdi-home</v-icon>
      맛집
    </v-tab>
    <v-tab class="tab" href="/">
      <v-icon>mdi-home</v-icon>
      숙소
    </v-tab>
    <v-tab class="tab" href="/">
      <v-icon>mdi-home</v-icon>
      커뮤니티
    </v-tab>
    <v-tab class="tab" href="/">
      <v-icon>mdi-home</v-icon>
      일정등록
    </v-tab>
  </v-tabs>
</template>
<script>
export default {
  name: 'MainNavbar'
}
</script>
<style>
.tab {
  color: #424242;
}
</style>