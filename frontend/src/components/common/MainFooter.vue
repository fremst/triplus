<template>
  <div class="footer">
    <v-img
        :src="require('@/assets/logo.png')"
        class="footer-img"
    />
  </div>
</template>

<script>
export default {
  name: 'MainFooter'
}
</script>
<style scoped>
.footer {
  height: 200px;
  background: #91D9CC no-repeat padding-box;
  opacity: 1;
}

.footer-img {
  justify-content: flex-start;
}
</style>