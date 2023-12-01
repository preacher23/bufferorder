package com.dailycodebuffer.orderservice.external.externalclient.decoder;

import com.dailycodebuffer.orderservice.exception.Customexception;
import com.dailycodebuffer.orderservice.external.externalclient.response.Errorresponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomerrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper=new ObjectMapper();
        log.info("::{}",response.request().headers());

        try {
            Errorresponse errorresponse=objectMapper.readValue(response.body().asInputStream(), Errorresponse.class);
            return new Customexception(errorresponse.getErrormessage(), errorresponse.getErrorcode(), response.status());
        } catch (IOException e) {
            throw new Customexception("INTERNAL server","internal ERROR",500);
        }

    }
}
