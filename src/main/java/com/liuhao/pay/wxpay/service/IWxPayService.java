package com.liuhao.pay.wxpay.service;

import com.liuhao.pay.wxpay.model.Order;

public interface IWxPayService {

    String getQRCodeURL(Order order);

}
