<template>
  <div class="home">
    <CommonBoard :detailLink="detailLink" :board="board"/>
  </div>
</template>

<script>
// @ is an alias to /src
import CommonBoard from '@/components/CommonBoard.vue'

export default {
  name: 'QnAView',
  components: {
    CommonBoard
  },
  data() {
    return {
      detailLink: "/service/qna",
      board: {
        title: "이곳에 타이틀 입력",
        list: [
          {
            number: 1,
            title: "이곳에 제목 입력",
            id: "이곳에 아이디 입력",
            date: "20:14",
            view: 10
          }, {
            number: 2,
            title: "bbb",
            id: "id 2",
            date: "2022.08.01",
            view: 3
          }, {
            number: 3,
            title: "ccc",
            id: "id 3",
            date: "2022.06.04",
            view: 1597
          }, {
            number: 4,
            title: "ddd",
            id: "id 4",
            date: "1970.01.01",
            view: 256375
          }
        ],
        pageCur: 6, pageEnd: 70
      }
    };
  }
}
</script>
