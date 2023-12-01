package com.dailycodebuffer.orderservice.external.externalclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service/product")
public interface Productservice {
    @PutMapping("/reduce/{id}")
    public ResponseEntity<Void> reducequantity(@PathVariable("id") long productid, @RequestParam long quantity);
}
