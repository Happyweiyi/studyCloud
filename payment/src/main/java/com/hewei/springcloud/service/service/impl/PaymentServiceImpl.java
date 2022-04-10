package com.hewei.springcloud.service.service.impl;

import com.hewei.springcloud.dao.PaymentDao;
import com.hewei.springcloud.entities.Payment;
import com.hewei.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment paymentById(Long id) {
        return paymentDao.paymentById(id);
    }
}
