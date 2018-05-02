package com.liuhao.pay.wxpay.service.impl;

import com.liuhao.pay.wxpay.mapper.OrderMapper;
import com.liuhao.pay.wxpay.model.Order;
import com.liuhao.pay.wxpay.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int addOne(Order order) {
        return orderMapper.addOne(order);
    }

    @Override
    public void updateOne(String orderCode, String wxPayId) {
        orderMapper.updateOne(orderCode,wxPayId);
    }

}
