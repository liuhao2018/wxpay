package com.liuhao.pay.wxpay.mapper;

import com.liuhao.pay.wxpay.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper {

    @Insert("insert into shop_order (total_price,goods_desc,user_id,order_code) values (#{totalPrice},#{goodsDesc},#{userId},#{orderCode})")
    int addOne(Order order);

    @Update("update shop_order set wx_pay_id = #{wxPayId},pay_status = 1 where orderCode = #{orderCode} and pay_status = 0")
    int updateOne(@Param("orderCode")String orderCode,@Param("wxPayId") String wxPayId);

}
