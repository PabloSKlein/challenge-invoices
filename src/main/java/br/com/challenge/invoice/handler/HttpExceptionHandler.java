package br.com.challenge.invoice.handler;

import br.com.challenge.invoice.dto.ErrorDTO;
import br.com.challenge.invoice.exception.BusinessException;
import br.com.challenge.invoice.exception.IntegrationException;
import br.com.challenge.invoice.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDTO> handleBusinesException(BusinessException businessException) {
        return ResponseEntity.unprocessableEntity().body(new ErrorDTO(businessException.getMessage()));
    }

    @ExceptionHandler(IntegrationException.class)
    public ResponseEntity<ErrorDTO> handleIntegrationException(IntegrationException integrationException) {
        return ResponseEntity.internalServerError().body(new ErrorDTO(integrationException.getMessage()));
    }
}
