package br.com.challenge.invoice.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface IBahamasInvoiceService {
    void registerInvoice(@PathVariable Long idInvoice, @RequestParam Long fiscalId,
                         @RequestParam String name, @RequestParam String email);
}
