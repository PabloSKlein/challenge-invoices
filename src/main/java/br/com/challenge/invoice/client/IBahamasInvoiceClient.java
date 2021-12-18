package br.com.challenge.invoice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${client.bahamas-invoice}")
public interface IBahamasInvoiceClient {

    @PostMapping("/register/{invoiceId}")
    void registerInvoice(@PathVariable Long invoiceId, @RequestParam Long fiscalId,
                         @RequestParam String name, @RequestParam String email);
}
