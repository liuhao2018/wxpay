package com.liuhao.pay.wxpay.model;


/**
 * 订单实体
 *
 */
public class Order {
    private int id;
    private int totalPrice;
    private String goodsDesc;
    private String userId;
    private String orderCode;
    private int payStatus;
    private String wxPayId;
    private String goodsId;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public String getWxPayId() {
        return wxPayId;
    }

    public void setWxPayId(String wxPayId) {
        this.wxPayId = wxPayId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", userId='" + userId + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", payStatus=" + payStatus +
                ", wxPayId='" + wxPayId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                '}';
    }
}
