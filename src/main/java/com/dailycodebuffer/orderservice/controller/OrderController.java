package com.dailycodebuffer.orderservice.controller;


import com.dailycodebuffer.orderservice.model.Orderdtorequest;
import com.dailycodebuffer.orderservice.model.Orderresponse;
import com.dailycodebuffer.orderservice.service.Orderservice;
import jakarta.persistence.GeneratedValue;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
    @Autowired
    Orderservice orderservice;
    @PostMapping("/placeorder")
    public ResponseEntity<Long> placeorder(@RequestBody Orderdtorequest orderdtorequest){
        long orderid=orderservice.placeorder(orderdtorequest);
        log.info("order id created");
        return new ResponseEntity<>(orderid, HttpStatus.OK);
    }
    @GetMapping("/{orderid}")
    public ResponseEntity<Orderresponse> getorderdetails(@PathVariable long orderid){
        Orderresponse orderresponse=orderservice.getorder(orderid);
        return new ResponseEntity<>(orderresponse,HttpStatus.OK);
    }
}
