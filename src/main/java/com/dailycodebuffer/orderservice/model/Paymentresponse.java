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
public class Paymentresponse {
    private long paymentid;
    private String status;
    private Paymentmode paymentmode;
    private long amount;
    private Instant paymentdate;
    private long orderid;
}
