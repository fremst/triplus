<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@page import="com.triplus.payment.utils.HashUtils" %>
<%@ page import="com.triplus.payment.utils.HttpUtil" %>

환불 페이지
<%
    //* JSP 경우 아래 통신, Hash 에 필요한 암호화 lib 는 별도 제공하지 않습니다. 관련 사이트 참고및 직접 구현 부탁드립니다.

    Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다//년월일시분초 14자리 포멧
    SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");

    //step1. 요청을 위한 파라미터 설정
    String key = "ItEQKi3rY7uvDS8l"; // INIpayTest 의 INIAPI key
    String type = "Refund";
    String paymethod = "Card";
    String timestamp = fourteen_format.format(date_now);
    String clientIp = "192.0.0.1";
    String mid = "INIpayTest";
    String tid = "StdpayCARDINIpayTest20220811002302210383";  // 40byte 승인 TID 입력
    String msg = "거래취소요청";

    //Hash 암호화
    String data_hash = key + type + paymethod + timestamp + clientIp + mid + tid;
    String hashData = HashUtils.getSHA_512(data_hash); // SHA_512_Util 을 이용하여 hash암호화(해당 LIB는 직접구현 필요)
    System.out.println(hashData);

    // 전송 URL
    String APIURL = "https://iniapi.inicis.com/api/v1/refund"; // 전송 URL
    Map<Object, Object> CashReceiptsMap = new HashMap<>();

    CashReceiptsMap.put("type", type);
    CashReceiptsMap.put("paymethod", paymethod);
    CashReceiptsMap.put("timestamp", timestamp);
    CashReceiptsMap.put("clientIp", clientIp);
    CashReceiptsMap.put("mid", mid);
    CashReceiptsMap.put("tid", tid);
    CashReceiptsMap.put("msg", msg);
    CashReceiptsMap.put("hashData", hashData);

    //step2. key=value 로 post 요청

    HttpUtil httpUtil = new HttpUtil();

    try {
        String authResultString = httpUtil.processHTTP(CashReceiptsMap, APIURL);
        System.out.println(authResultString);

        //step3. 요청 결과
        out.println("<h2>" + authResultString + "</h2>");

    } catch (Exception ex) {
        ex.printStackTrace();
    }

%>