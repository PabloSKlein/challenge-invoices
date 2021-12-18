package br.com.challenge.invoice.controller;

import br.com.challenge.invoice.dto.InvoiceDTO;
import br.com.challenge.invoice.service.IInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store-bahamas-client")
public class InvoiceController {

    private final IInvoiceService invoiceService;

    @PostMapping("/{invoiceId}")
    public ResponseEntity<URI> sendInvoice(@PathVariable Long invoiceId,
                                           @RequestParam Long fiscalId,
                                           @RequestParam String name,
                                           @RequestParam String email) {
        var id = invoiceService.sendInvoice(invoiceId, fiscalId, name, email);
        return created(URI.create("/store-bahamas-client/" + id)).build();
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable Long invoiceId) {
        return ok(invoiceService.getInvoice(invoiceId));
    }

}
