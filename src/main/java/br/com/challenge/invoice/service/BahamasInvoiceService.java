package br.com.challenge.invoice.service;

import br.com.challenge.invoice.client.IBahamasInvoiceClient;
import br.com.challenge.invoice.exception.IntegrationException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BahamasInvoiceService implements IBahamasInvoiceService {
    private final IBahamasInvoiceClient invoiceClient;

    @Override
    public void registerInvoice(Long idInvoice, Long fiscalId, String name, String email) {
        try {
            invoiceClient.registerInvoice(idInvoice, fiscalId, name, email);
        }catch (FeignException e){
            throw new IntegrationException("Fail to register invoice", e);
        }
    }
}
