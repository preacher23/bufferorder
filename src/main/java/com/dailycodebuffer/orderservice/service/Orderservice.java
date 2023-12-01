package com.dailycodebuffer.orderservice.service;


import com.dailycodebuffer.orderservice.entity.Order;
import com.dailycodebuffer.orderservice.exception.Customexception;
import com.dailycodebuffer.orderservice.external.externalclient.Paymentservice;
import com.dailycodebuffer.orderservice.external.externalclient.Productservice;
import com.dailycodebuffer.orderservice.external.externalclient.request.PaymentRequest;
import com.dailycodebuffer.orderservice.model.Orderdtorequest;
import com.dailycodebuffer.orderservice.model.Orderresponse;
import com.dailycodebuffer.orderservice.model.Paymentresponse;
import com.dailycodebuffer.orderservice.repo.Orderrepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
@Log4j2
public class Orderservice {
    @Autowired
    Orderrepo orderrepo;
    @Autowired
    Productservice productservice;
    @Autowired
    Paymentservice paymentservice;
   @Autowired
    RestTemplate restTemplate;
    public long placeorder(Orderdtorequest orderdtorequest) {
        //order entity-> save the data with status order created
        //product service-> block products(reduce the quantity)
        //payment service -> payments -> success -> complete,else cancelled
        productservice.reducequantity(orderdtorequest.getProductid(),orderdtorequest.getQuantity());
        log.info("placing order");
        Order order= Order.builder().quantity(orderdtorequest.getQuantity()).
                orderstatus("created").orderdate(Instant.now()).amount(orderdtorequest.getAmount()).productid(orderdtorequest.getProductid()).build();
       Order order1=orderrepo.save(order);
       log.info("calling payment");
        PaymentRequest paymentRequest=PaymentRequest.builder().orderid(order.getId()).paymentmode(orderdtorequest.getPaymentmode()).amount(orderdtorequest.getAmount())
                        .build();
        String orderstatus=null;
        try {
            paymentservice.dopayment(paymentRequest);
            orderstatus="placed";
        }catch (Exception e){
            System.out.println();
            orderstatus="failure";
        }
        order1.setOrderstatus(orderstatus);
        orderrepo.save(order1);
       log.info("order plced with id");

        return order1.getId();
    }

    public Orderresponse getorder(long orderid) {
             Order order=orderrepo.findById(orderid).orElseThrow(()-> new Customexception("order id not found"+orderid,"NOT FOUND",404));
             log.info("Invokeing product service to fetch the product for id:{}",order.getProductid());
         // Productresponsedto
        //Orderresponse.Productdetails productdetails=restTemplate.getForObject("http://product-service/product"+order.getProductid(), Orderresponse.Productdetails.class);
        //Paymentresponse paymentresponse=
             Orderresponse orderresponse=Orderresponse.builder().orderid(order.getId()).orderstatus(order.getOrderstatus())
                     .amount(order.getAmount()).orderdate(order.getOrderdate()).build();
             return orderresponse;
    }
}

