package com.hewei.springcloud.dao;

import com.hewei.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment paymentById(@Param("id") Long id);
}
