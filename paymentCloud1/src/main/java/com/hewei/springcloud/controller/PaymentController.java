package com.hewei.springcloud.controller;


import com.hewei.springcloud.entities.CommonResult;
import com.hewei.springcloud.entities.Payment;
import com.hewei.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //读取application.yml的端口号
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        if (result>0){
            return new CommonResult(200,"插入数据成功"+serverPort,result);
        }else {
            return new CommonResult(500,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){

        Payment payment = paymentService.paymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询数据成功"+serverPort,payment);
        }else {
            return new CommonResult(500,"查询数据失败,查询id:"+id,null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        //查询全部的服务信息
        List<String> services = discoveryClient.getServices();
        for(String element:services){
            log.info("****element:"+element);
        }

        //查询服务的具体信息，例如主机ip,端口号,url
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for(ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
