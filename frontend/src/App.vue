<template>
  <MainHeader/>
  <v-app>
    <MainNavbar/>
    <v-main>
      <router-view/>
    </v-main>
    <MainFooter/>
  </v-app>
</template>

<script>
import MainFooter from "@/components/common/MainFooter";
import MainHeader from "@/components/common/MainHeader";
import MainNavbar from "@/components/common/MainNavbar";

export default {
  name: 'App',
  components: {
    MainNavbar,
    MainFooter,
    MainHeader
  },
  data: () => ({
    //
  }),
}
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #333333;
}
</style>
