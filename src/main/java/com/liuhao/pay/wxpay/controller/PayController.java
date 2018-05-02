package com.liuhao.pay.wxpay.controller;

import com.liuhao.pay.wxpay.model.FeedbackWx;
import com.liuhao.pay.wxpay.model.WxPayResult;
import com.liuhao.pay.wxpay.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pay")
@RestController
public class PayController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/result")
    public FeedbackWx notifyPayResult(WxPayResult wxPayResult) {
        FeedbackWx feedbackWx = new FeedbackWx();
        if (wxPayResult.getResult_code().equals("SUCCESS")) {
            String orderCode = wxPayResult.getOut_trade_no();
            String wxPayId = wxPayResult.getTransaction_id();
            orderService.updateOne(orderCode,wxPayId);
            feedbackWx.setReturn_code("SUCCESS");
            feedbackWx.setReturn_msg("OK");
            return feedbackWx;
        }
        return null;
    }

}
