<template>
<!--    <div class="home">-->
<!--        <CommonBoard :detailLink="detailLink" :board="board"/>-->
<!--    </div>-->
    <div id="main">
    <v-table>
        <thead>
        <tr>
            <th class="text-left">
                Number
            </th>
            <th class="text-left">
                Title
            </th>
            <th class="text-left">
                Id
            </th>
            <th class="text-left">
                Date
            </th>
            <th class="text-left">
                View
            </th>

        </tr>
        </thead>
        <tbody>
        <tr
                v-for="item in board"
                :key="item.number"
        >
            <td>{{ item.number }}</td>
            <td>{{ item.title }}</td>
            <td>{{ item.id }}</td>
            <td>{{ item.date }}</td>
            <td>{{ item.view }}</td>
        </tr>
        </tbody>
    </v-table>
    </div>
</template>

<script>
    // @ is an alias to /src
//    import CommonBoard from '@/components/CommonBoard.vue'

    export default {
        name: 'NoticeListView',
        // components: {
        //     CommonBoard
        // },
        data() {
            return {
                detailLink: "/service/notice",
                board: {
                    title: "공지사항",
                    list: [
                        {
                            number: 1,
                            title: "제목",
                            id: "작성자",
                            date: "20:14",
                            view: 10
                        }, {
                            number: 2,
                            title: "bbb",
                            id: "id 2",
                            date: "2022.08.01",
                            view: 3
                        },

                    ],
                    pageCur: 5, pageEnd: 15
                }
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
</style>
