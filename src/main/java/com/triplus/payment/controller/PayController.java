package com.triplus.payment.controller;

import com.triplus.payment.dto.PcPayRequest;
import com.triplus.payment.dto.PcPayReturn;
import com.triplus.payment.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/api/v1/pay")
@Controller
public class PayController {

    //    @Autowired
    private final PayService payService;

    @PostMapping("/pcpay")
    public String PayRequest(Model model, PcPayRequest pcPayRequest) {
        payService.saveOrder(pcPayRequest.getOid(), pcPayRequest.getTimestamp(), pcPayRequest.getSignature(), pcPayRequest.getPrice());
        model.addAttribute("pay", pcPayRequest);
        return "payform";
    }

    @GetMapping("/close")
    public String pcClose() {
        return "close";
    }

    //    @PostMapping("/return")
//    public String pcReturn(PcPayReturn pcPayReturn) throws IllegalAccessException, IOException, InterruptedException {
//        System.out.println(payService.checkPcReturn(pcPayReturn.getResultCode(), pcPayReturn.getMid(), pcPayReturn.getOrderNumber(), pcPayReturn.getAuthToken(), pcPayReturn.getAuthUrl(), pcPayReturn.getCharset()));
////        System.out.println(payService.checkPcReturn(pcPayReturn.getResultCode(), pcPayReturn.getResultMsg(), pcPayReturn.getMid(), pcPayReturn.getOrderNumber(), pcPayReturn.getAuthToken(), pcPayReturn.getAuthUrl(), pcPayReturn.getNetCancelUrl(), pcPayReturn.getCharset(), pcPayReturn.getMerchantData()));
//        return "redirect:http://localhost:8081/resources/PayComplete";
//    }
    @PostMapping("/return")
    public String pcReturn() {
        return "INIStdPayReturn";
    }

    @GetMapping("/popup")
    public String pcPopup() {
        return "popup";
    }

    @GetMapping("/refund")
    public String pcRefund() {
        return "INISTdPayRefund";
    }
}