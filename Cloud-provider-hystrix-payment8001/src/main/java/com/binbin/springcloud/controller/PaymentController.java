package com.binbin.springcloud.controller;

import com.binbin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author binbin
 * @date 2022年06月11日  下午8:55
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;




}
