package com.dailycodebuffer.orderservice.external.externalclient.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Errorresponse {
    private String errormessage;
    private String errorcode;
}
