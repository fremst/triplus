<!--
  220810 김주현
  가장 기본적인 게시판 상세보기 폼입니다.
  
  [ 프로퍼티 ]
  detailLnk : String
    게시글 조회를 시도할 때 GET 요청을 보낼 URL을 설정합니다.
  title : String
    폼 좌상단의 대문짝만한 문구
  article : Object { number, title, id, date, content }
    게시글을 표현합니다.
    게시글 수정/삭제를 시도할 때, [ 해당링크 + "?num=" + number ] 의 형태로 GET/POST 요청을 보냅니다.
  updateLink, deleteLink, listLink : String
    각각 수정/삭제/목록으로 향하는 URL을 설정합니다.
-->

<template>
  <div class="main">
    <div class="board">
      <div class="board-header">
        <h1>{{title}}</h1>
      </div>
      <div class="board-main">
        <table class="article-header" >
          <tr>
            <th style="text-align: start; padding-left: 20px;">{{article.title}}</th>
            <th width="200px">{{article.id}}</th>
            <th width="200px">{{article.date}}</th>
          </tr>
        </table>
        <div class="article-main">
          <div v-html="article.content"></div>
        </div>
        <div class="article-footer" />
      </div>
      <div class="board-footer">
          <!-- TODO 버튼 구현 -->
        <v-btn color="#67AB9F" @click="onUpdate">수정</v-btn>
        <v-btn color="#67AB9F" @click="onDelete">삭제</v-btn>
        <v-btn color="#67AB9F" @click="onList">목록으로</v-btn>
      </div>
    </div>
  </div>
</template>
<script>
  export default
  {
    name: 'CommonBoard',
    props: {
      title: String, // 타이틀
      article: { // 게시글 number, title, id, date, content
        number: Number,
        title: String,
        id: String,
        date: String,
        content: String
      },
      updateLink: String, // 수정 링크
      deleteLink: String, // 삭제 링크
      listLink: String, // 목록 링크
    },
    computed: {
      icon() {
        return this.icons[this.iconIndex];
      }
    },
    methods: {
      onUpdate() {
        alert("미구현");
      },
      onDelete() {
        alert("미구현");
      },
      onList() {
        alert("미구현");
      },
    }
  }
</script>
<style scoped>
  * {
    padding: 20px;
    font-family: 'Helvetica';
    margin: 0px; 
    padding: 0px;
  }
  a {
    color: #333;
    font-weight: bold;
    text-decoration: none;
  }
  button, input[type="submit"] {
    border: none;
    font-weight: bold;
    color: white;
    background-color: #67AB9F;
    padding: 5px;
  }
  .main {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: white;
  }
  .board {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 1080px;
    border: 1px solid lightgray;
  }
  .board-header {
    display: flex;
    flex-direction: column;
    justify-content: center;
    width: 100%;
    height: 100px;
    align-items: flex-start;
    padding: 20px;
  }
  .board-header h1 {
    font-size: 50px;
    font-weight: bold;
    color: #222;
  }
  .board-main {
    display: flex;
    flex-direction: column;
    justify-content: top;
    width: 100%;
    align-items: center;
    padding: 20px;
  }
  .article-header {
    width: 100%;
    margin: 0px 0px 0px 0px;
    text-align: center;
    border-top: 1px solid gray;
    border-collapse: collapse;
  }
  .article-header tr {
    height: 55px;
  }
  .article-header th {
    border-bottom: 1px solid gray;
    font-size: 22px; /* 30px */
    color: #222;
  }
  .article-main {
    display: flex;
    width: 100%;
    margin: 20px 0px;
    padding: 0px 20px;
  }
  .article-footer {
    width: 100%;
    margin: 0px 0px 20px 0px;
    border-top: 1px solid gray;
  }
  .board-footer {
    display: flex;
    flex-direction: row;
    justify-content: end;
    width: 100%;
    align-items: center;
    padding: 20px;
    margin: 0px 20px;
  }
  .board-footer * {
    margin: 0px 4px;
  }
</style>
