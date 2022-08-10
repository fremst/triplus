<template>
  <div>
    <form id="PayForm" action="http://localhost:8082/triplus/api/v1/pay/pcpay" method="POST" target="PayForm">
      <label for="goodname">상품명: </label>
      <input id="goodname" name="goodname" type="text" value="test_goodname"><br>
      <label for="buyername">구매자 성명: </label>
      <input id="buyername" name="buyername" type="text" value="test_buyername"><br>
      <label for="buyertel">구매자 전화번호: </label>
      <input id="buyertel" name="buyertel" type="text" value="010-1234-5678"><br>
      <label for="buyeremail">구매자 이메일: </label>
      <input id="buyeremail" name="buyeremail" type="text" value="test@triplus.com"><br>
      <label for="price">가격: </label>
      <input id="price" name="price" type="text" value="1000">원
    </form>
    <v-btn color="primary" elevation="1"
           @click="sendForm">
      결제 요청
    </v-btn>
    <iframe name="PayForm" style="display:block; width:100vw; height: 600px; border:none"/>
  </div>
</template>

<script>
export default {
  methods: {
    sendForm() {
      document.querySelector('#PayForm').submit()
    }
  }
}
</script>