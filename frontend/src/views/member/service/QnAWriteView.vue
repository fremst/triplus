<template>
  <div class="home">
    <CommonWrite :title="title" :submitLink="submitLink" :cancelLink="cancelLink"/>
  </div>
</template>

<script>
// @ is an alias to /src
import CommonWrite from '@/components/CommonWrite.vue'

export default {
  name: 'QnAWriteView',
  components: {
    CommonWrite
  },
  data() {
    return {
      title: "이곳에 타이틀 입력",
      submitLink: "/service/qna/write",
      cancelLink: "/service/qna",
    };
  }
}
</script>
