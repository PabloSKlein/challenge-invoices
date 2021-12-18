package br.com.challenge.invoice.service;

import br.com.challenge.invoice.dto.InvoiceDTO;

public interface IInvoiceService {
    Long sendInvoice(Long idInvoice, Long fiscalId, String name, String email);

    InvoiceDTO getInvoice(Long idInvoice);
}
