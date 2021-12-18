package br.com.challenge.invoice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INVOICE")
public class Invoice {
    @Id
    @Column(name = "INVOICE_ID")
    private Long invoiceId;
    @Column(name = "FISCAL_ID")
    private Long fiscalId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
}
