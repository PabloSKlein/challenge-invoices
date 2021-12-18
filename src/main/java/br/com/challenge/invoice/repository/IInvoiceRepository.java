package br.com.challenge.invoice.repository;

import br.com.challenge.invoice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
}
