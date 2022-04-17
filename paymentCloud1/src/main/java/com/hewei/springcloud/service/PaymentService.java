package com.hewei.springcloud.service;

import com.hewei.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int create(Payment payment);

    public Payment paymentById(@Param("id") Long id);

}
