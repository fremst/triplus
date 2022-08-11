package com.triplus.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Data
public class OrderDto {
    private String oid;
    private int brdNum;
    private String id;
    private int adultCnt;
    private int childCnt;
    private String bookerName;
    private String bookerTel;
    private String bookerEmail;
    private int cpnNum;
    private String resSta;
}
