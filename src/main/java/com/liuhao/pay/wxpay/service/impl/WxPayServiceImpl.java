package com.liuhao.pay.wxpay.service.impl;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.liuhao.pay.wxpay.model.Order;
import com.liuhao.pay.wxpay.service.IWxPayService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxPayServiceImpl implements IWxPayService {
    @Override
    public String getQRCodeURL(Order order) {
        try {
            WXPayConfig wxPayConfig = new MyConfig();
            WXPay wxPay = new WXPay(wxPayConfig);
            Map<String, String> data = new HashMap<String, String>();
            data.put("body", order.getGoodsDesc());
            data.put("out_trade_no", order.getOrderCode());
            data.put("device_info", "");
            data.put("fee_type", "CNY");
            data.put("total_fee", order.getTotalPrice() + "");
            data.put("spbill_create_ip", "http://127.0.0.1");
            data.put("notify_url", "http://127.0.0.1:8080/pay/result");
            data.put("trade_type", "NATIVE");
            data.put("product_id", order.getGoodsId());

            Map<String, String> orderResponse = wxPay.unifiedOrder(data);
            return orderResponse.get("code_url");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public class MyConfig implements WXPayConfig{

        private byte[] certData;

        public MyConfig() throws Exception {
            String certPath = "/path/to/apiclient_cert.p12";
            File file = new File(certPath);
            InputStream certStream = new FileInputStream(file);
            this.certData = new byte[(int) file.length()];
            certStream.read(this.certData);
            certStream.close();
        }

        @Override
        public String getAppID() {
            return "wx8888888888888888";
        }

        @Override
        public String getMchID() {
            return "12888888";
        }

        @Override
        public String getKey() {
            return "88888888888888888888888888888888";
        }

        @Override
        public InputStream getCertStream() {
            ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
            return certBis;
        }

        @Override
        public int getHttpConnectTimeoutMs() {
            return 8000;
        }

        @Override
        public int getHttpReadTimeoutMs() {
            return 10000;
        }
    }

}
