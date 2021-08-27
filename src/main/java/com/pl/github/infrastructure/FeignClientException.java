package com.pl.github.infrastructure;

import feign.FeignException;

public class FeignClientException extends FeignException {

    public FeignClientException(int status, String message) {
        super(status, message);
    }

}
