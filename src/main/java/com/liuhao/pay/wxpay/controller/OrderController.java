package com.liuhao.pay.wxpay.controller;

import com.liuhao.pay.wxpay.model.APIResponse;
import com.liuhao.pay.wxpay.model.Order;
import com.liuhao.pay.wxpay.model.Trade;
import com.liuhao.pay.wxpay.service.IOrderService;
import com.liuhao.pay.wxpay.service.IWxPayService;
import com.liuhao.pay.wxpay.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IWxPayService wxPayService;

    @PostMapping("/")
    public APIResponse<String> createOrder(Order order) {
        APIResponse<String> apiResponse = new APIResponse<>();
        order.setOrderCode(MD5Util.MD5Encode(String.format("%s%d",order.getUserId(),
                System.currentTimeMillis()),"UTF-8"));
        int result = orderService.addOne(order);
        if (result < 0) {
            apiResponse.setStatusCode(400);
            apiResponse.setMessage("下单失败");
            return apiResponse;
        }
        String qrCode = wxPayService.getQRCodeURL(order);
        if (qrCode == null || qrCode.isEmpty()) {
            apiResponse.setStatusCode(400);
            apiResponse.setMessage("微信支付暂时无法使用");
            return apiResponse;
        }
        apiResponse.setStatusCode(200);
        apiResponse.setMessage("操作成功");
        apiResponse.setData(qrCode);
        return apiResponse;
    }

}
