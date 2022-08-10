<!--
  220810 김주현
  가장 기본적인 게시판 폼입니다.
  
  [ 프로퍼티 ]
  detailLnk : String
    게시글 조회를 시도할 때 GET 요청을 보낼 URL을 설정합니다.
  board : {
    title : String
      폼 좌상단의 대문짝만한 문구
    list : Array[Object { number, title, id, date, view }]
      게시글 목록을 표현합니다.
      배열 내의 데이터를 전부 표현합니다. (10개인지 15개인지 안따지고 전부 표현)
      게시글 조회를 시도할 때, [ detailLink + "?num=" + number ] 의 형태로 GET 요청을 보냅니다.
    pageCur : Number
      현재 몇 페이지를 가리키는지를 표현합니다.
    pageEnd : Number
      조회한 페이지 목록의 최대값을 표현합니다.
  }
  
  [ 문제점 ]
    검색 기능 미구현
    v-data-table 적용에 어려움 있음

-->

<template>
  <div class="main">
    <div class="board">
      <div class="board-header">
        <h1>{{board.title}}</h1>
      </div>
      <div class="board-main">
        <div class="board-search">
          <!-- TODO 검색 기능(axios...) -->
            <v-col cols="2"><v-select :items="searchOpt" label="검색 옵션" outlined name="option"></v-select></v-col>
            <v-col cols="4">
              <v-text-field 
                label="검색"
                name="keyword"
                clearable
                :append-icon="'mdi-magnify'"
                @click:append="onSearch">
              </v-text-field>
            </v-col>
        </div>
        <table class="board-table">
          <tr>
            <th width="120px">글 번호</th>
            <th>제목</th>
            <th width="120px">작성자</th>
            <th width="150px">작성일</th>
            <th width="120px">조회수</th>
          </tr>
          <tr v-for="article in board.list" :key="article">
            <td>{{article.number}}</td>
            <td><a :href="(detailLink + '?num=' + article.number)">{{article.title}}</a></td>
            <td>{{article.id}}</td>
            <td>{{article.date}}</td>
            <td>{{article.view}}</td>
          </tr>
        </table>
        <!--
        <div class="board-page">
          <a v-if="hasPrev()" href="">&lt;</a>
          <span v-for="page in (getPageMin(), getPageMax())" :key="page">
            <span v-if="page == board.pageCur" class="currentPage">{{page}}</span>          
            <a v-else href="">{{page}}</a>
          </span>
          <a v-if="board.pageCur > 2" href="">&gt;</a>
        </div>
        -->
        <v-pagination
          v-model="curPage"
          :length="board.pageEnd"
          total-visible="9"
          color="#67AB9F"
          @input="onPageChange"
          @next="onPageChange"
          circle>
        </v-pagination>
      </div>
      <div class="board-footer">
          <!-- TODO 버튼 구현 -->
        <v-btn color="#67AB9F" x-large>전체 글 보기(?)</v-btn>
        <v-btn color="#67AB9F">공지 등록(??)</v-btn>
      </div>
    </div>
  </div>
</template>
<script>
  export default
  {
    name: 'CommonBoard',
    props: {
      detailLink: String, // 자세히 보기 링크
      board: {
        type: Object,
        default() {
          return {
            title: "여기에 타이틀 입력", // 타이틀
            list: [], // 게시글 리스트 (number, title, id, date, view)
            pageCur: 1, // 현재 페이지 인덱스
            pageEnd: 10 // 최대 페이지 수
          };
        }
      },
    },
    data() {
      return {
        searchOpt: ["제목", "내용", "제목/내용"],
        curPage: this.board.pageCur
      }
    },
    computed: {
      icon() {
        return this.icons[this.iconIndex];
      }
    },
    methods: {
      // 페이징: 최소값
      getPageMin() {
        return Math.max((this.board.pageCur - this.board.pageCur % 10), 0);
      },
      // 페이징: 최대값
      getPageMax() {
        return Math.min((this.board.pageCur - this.board.pageCur % 10) + 10, this.board.pageEnd);
      },
      // 페이징: 이전 페이지로 갈 수 있는지 여부
      hasPrev() {
        return (this.board.pageCur - this.board.pageCur % 10) > 0;
      },
      // 페이징: 다음 페이지로 갈 수 있는지 여부
      hasNext() {
        return (this.board.pageCur - this.board.pageCur % 10) > 0;
      },
      onSearch() {
        alert("미구현");
      },
      onPageChange(n) {
        this.curPage = n;
        console.log(`${this.detailLink}?page=${this.curPage}`);
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
  .board-search {
    display: flex;
    width: 100%;
    justify-content: end;
    align-items: right;
  }
  .board-search * {
    margin: 0px 0px 0px 0px;
  }
  .board-search input[type="submit"] {
    width: 100px;
  }
  .board-table {
    width: 100%;
    margin: 0px 0px 20px 0px;
    text-align: center;
    border-top: 1px solid gray;
    border-collapse: collapse;
  }
  .board-table tr {
    height: 55px;
  }
  .board-table th {
    border-bottom: 1px solid gray;
    font-size: 22px; /* 30px */
    color: #222;
  }
  .board-table td {
    border-bottom: 1px solid gray;
    font-size: 16px; /* 12px */
    color: #333;
  }
  .board-page .currentPage {
    color: #67AB9F;
  }
  .board-page * {
    margin: 0px 4px;
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
