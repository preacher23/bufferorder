package com.dailycodebuffer.orderservice.external.externalclient.request;

import com.dailycodebuffer.orderservice.model.Paymentmode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String referncenumber;
    private long orderid;
    private long amount;
    private Paymentmode paymentmode;
}
