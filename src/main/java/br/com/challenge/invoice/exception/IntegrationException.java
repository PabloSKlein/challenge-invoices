package br.com.challenge.invoice.exception;

import feign.FeignException;

public class IntegrationException extends RuntimeException {
    public IntegrationException(String message, FeignException e) {
        super(message, e);
    }
}
