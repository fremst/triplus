<template>
<!--    <div class="home">-->
<!--        <CommonWrite :title="title" :submitLink="submitLink" :cancelLink="cancelLink"/>-->
<!--    </div>-->
    <div id="main">
            <div class="container">
                <h1>공지사항 등록</h1>
                <form action="" method="post">
                    <v-form>
                        제목<br>
                        <input type="text" class="form-control" id="title" placeholder="제목 입력" name="title">
                    </v-form>
                    <br>

                    <v-form>
                        작성자<br>
                        <input type="text" class="form-control" id="id" name="id" value="admin"
                                                                   readonly="readonly">
                    </v-form>
                    <br>

                    <v-form>
                        내용<br>
                        <v-text-field class="form-control" rows="10" id="contents"
                                  name="contents" placeholder="내용 작성(최대 500자)"></v-text-field>
                    </v-form>
                    <br> <br>
                    <v-btn id="btn1">등록</v-btn>
                    <v-btn id="btn1">취소</v-btn>
                </form>
            </div>

    </div>
</template>

<script>
    //  @ is an alias to /src
    // import CommonWrite from '@/components/CommonWrite.vue'

    export default {
        name: 'NoticeWriteView',
        // components: {
        //     CommonWrite
        // },
        data() {
            return {
                title: "이곳에 타이틀 입력",
                submitLink: "/service/notice/write",
                cancelLink: "/service/notice",
            };
        }
    }
</script>
<style scoped>
    #main{
        width:1060px;
        height: 1500px;
        margin: auto;
    }
    #btn1{
        margin-right: 10px;
    }
</style>