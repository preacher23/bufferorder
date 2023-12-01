package com.dailycodebuffer.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orderresponse {
    private long orderid;
    private Instant orderdate;
    private String orderstatus;
    private long amount;
    private Productdetails productdetails;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Productdetails {

        private String productname;
        private long productid;
        private long price;
        private long quantity;


    }
}
