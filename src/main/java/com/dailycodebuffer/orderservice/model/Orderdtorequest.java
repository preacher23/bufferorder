package com.dailycodebuffer.orderservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orderdtorequest {
    @JsonProperty("product")
    private long productid;
    private long amount;
   private long quantity;
   private Paymentmode paymentmode;
}
