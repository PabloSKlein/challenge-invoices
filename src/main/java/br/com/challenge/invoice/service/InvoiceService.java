package br.com.challenge.invoice.service;

import br.com.challenge.invoice.dto.InvoiceDTO;
import br.com.challenge.invoice.exception.BusinessException;
import br.com.challenge.invoice.exception.NotFoundException;
import br.com.challenge.invoice.model.Invoice;
import br.com.challenge.invoice.repository.IInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService implements IInvoiceService {

    private final IInvoiceRepository invoiceRepository;
    private final IBahamasInvoiceService bahamasInvoiceService;
    private final ModelMapper modelMapper;

    @Override
    public Long sendInvoice(Long invoiceId, Long fiscalId, String name, String email) {
        invoiceRepository.findById(invoiceId).ifPresent(invoice -> {
            throw new BusinessException("Invoice already registered");
        });

        var invoiceID = saveInvoice(invoiceId, fiscalId, name, email);

       // bahamasInvoiceService.registerInvoice(invoiceId, fiscalId, name, email);
        return invoiceID;
    }

    private Long saveInvoice(Long invoiceId, Long fiscalId, String name, String email) {
        var newInvoice = Invoice.builder()
                .invoiceId(invoiceId)
                .fiscalId(fiscalId)
                .name(name)
                .email(email)
                .build();

        return invoiceRepository.save(newInvoice).getInvoiceId();
    }

    @Override
    public InvoiceDTO getInvoice(Long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .map(invoice -> modelMapper.map(invoice, InvoiceDTO.class))
                .orElseThrow(() -> new NotFoundException());
    }
}
