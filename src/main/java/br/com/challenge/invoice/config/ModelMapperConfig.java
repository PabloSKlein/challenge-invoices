package br.com.challenge.invoice.config;

import br.com.challenge.invoice.dto.InvoiceDTO;
import br.com.challenge.invoice.model.Invoice;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Invoice.class, InvoiceDTO.class);

        return modelMapper;
    }
}
