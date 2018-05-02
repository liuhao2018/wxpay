package com.liuhao.pay.wxpay.model;

public class WxPayResult {

    private String result_code;
    private String transaction_id;
    private String out_trade_no;
    private String time_end;

    public WxPayResult() {
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    @Override
    public String toString() {
        return "WxPayResult{" +
                "result_code='" + result_code + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", time_end='" + time_end + '\'' +
                '}';
    }
}
