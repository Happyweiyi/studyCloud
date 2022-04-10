package com.hewei.springcloud.controller;



import com.hewei.springcloud.entities.CommonResult;
import com.hewei.springcloud.entities.Payment;
import com.hewei.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        if (result>0){
            return new CommonResult(200,"插入数据成功",result);
        }else {
            return new CommonResult(500,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){

        Payment payment = paymentService.paymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询数据成功",payment);
        }else {
            return new CommonResult(500,"查询数据失败,查询id:"+id,null);
        }
    }
}
