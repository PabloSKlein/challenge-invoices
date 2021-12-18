package br.com.challenge.invoice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDTO {
    private Long invoiceId;
    private Long fiscalId;
    private String name;
    private String email;
}
