<!--
  220810 김주현
  가장 기본적인 입력 폼입니다.

  [ 프로퍼티 ]
  title : String
    폼 좌상단 대문짝만한 문구
  category : Array[String]
    카테고리 드롭다운 메뉴를 표현합니다. (미구현)
  submitLink : String
    작성 버튼을 눌렀을 때 POST 요청을 보낼 URL을 설정합니다. (미구현)
  cancelLink : String
    취소 버튼을 눌렀을 때 GET 요청을 보낼 URL을 설정합니다. (미구현)
-->

<template>
  <div class="main">
    <div class="board">
      <div class="board-header">
        <h1>{{title}}</h1>
      </div>
      <div class="board-main">
        <v-text-field
          label="제목"
          name="title"
          clearable
          style="width: 100%" />
        <TextEditor
          @onChangeContent="onChangeContent"
          :placeholder="'여기에 내용 입력'" />
      </div>
      <div class="board-footer">
          <v-btn color="#999999" style="color: white;" @click="onCancel">취소</v-btn>
          <v-btn color="#67AB9F" style="color: white;" @click="onSubmit">작성</v-btn>
      </div>
    </div>
  </div>
</template>
<script>
  import TextEditor from '@/components/TextEditor.vue'

  export default
  {
    name: 'CommonWrite',
    components: {
      TextEditor
    },
    props: {
      title: String, // 글쓰기 타이틀(제목 아님)
      category: Array, // 카테고리
      submitLink: String, // 쓰기 링크
      cancelLink: String // 취소 링크
    },
    data() {
      return {
        content: ""
      }
    },
    methods: {
      onChangeContent(content) {
        this.content = content;
      },
      onSubmit() {
        console.log(this.content);
        console.log(this.submitLink);
      },
      onCancel() {
        console.log(this.cancelLink);
      }
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
  .board-footer {
    display: flex;
    flex-direction: row;
    justify-content: end;
    width: 100%;
    align-items: center;
    padding: 20px;
  }
  .board-footer * {
    margin: 0px 4px;
  }
</style>
