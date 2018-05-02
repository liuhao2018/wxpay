package com.liuhao.pay.wxpay.service;

import com.liuhao.pay.wxpay.model.Order;

public interface IOrderService {
    int addOne(Order order);
    void updateOne(String orderCode,String wxPayId);
}
