<template>
  <div>
    <v-form id="PayForm" action="http://localhost:8082/triplus/api/v1/pay/pcpay" method="POST" target="PayFormFrame">

      <label for="brdNum">상품번호: </label>
      <input id="brdNum" name="brdNum" type="text" value="100"><br>
      <label for="goodname">상품명: </label>
      <input id="goodname" name="goodname" type="text" value="빵의 도시 대전! 먹방 투어(2박3일)"><br>

      <label for="adultCnt">성인 수: </label>
      <input id="adultCnt" name="adultCnt" type="text" value="1"><br>
      <label for="childCnt">아동 수: </label>
      <input id="childCnt" name="childCnt" type="text" value="1"><br>
      <label for="price">가격: </label>
      <input id="price" name="price" readonly type="text" value="1000">원<br>
      <label for="cpnNum">임시쿠폰번호: </label>
      <input id="cpnNum" name="cpnNum" readonly type="text" value="0"><br><br>

      <label for="id">구매자 아이디: </label>
      <input id="id" name="id" type="text" value="test"><br>

      <label for="buyername">구매자 성명: </label>
      <input id="buyername" name="buyername" type="text" value="회원명"><br>
      <label for="buyertel">구매자 전화번호: </label>
      <input id="buyertel" name="buyertel" type="text" value="010-1234-5678"><br>
      <label for="buyeremail">구매자 이메일: </label>
      <input id="buyeremail" name="buyeremail" type="text" value="test@triplus.com"><br><br>

      <label for="bookername">예약자 성명: </label>
      <input id="bookername" name="bookerName" type="text" value="예약자명"><br>
      <label for="bookertel">예약자 전화번호: </label>
      <input id="bookertel" name="bookerTel" type="text" value="010-8765-4321"><br>
      <label for="bookeremail">구매자 이메일: </label>
      <input id="bookeremail" name="bookerEmail" type="text" value="test@triplus.com"><br><br>

      <label for="resSta">예약 상태: </label>
      <input id="resSta" name="resSta" type="text" value="결제전"><br><br>

      <v-btn color="primary" elevation="1" type="submit">결제하기</v-btn>
    </v-form>
    <v-btn color="primary" href="http://localhost:8082/triplus/api/v1/pay/refund">환불하기</v-btn>
    <iframe name="PayFormFrame" style="display: block; width: 100vw; height: 620px; border: none"/>
  </div>
</template>