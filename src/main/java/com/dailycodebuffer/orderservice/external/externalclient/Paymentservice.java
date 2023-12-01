package com.dailycodebuffer.orderservice.external.externalclient;

import com.dailycodebuffer.orderservice.external.externalclient.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service/payment/pay")
public interface Paymentservice {
    @PostMapping
    public ResponseEntity<Long> dopayment(@RequestBody PaymentRequest paymentRequest);
}
