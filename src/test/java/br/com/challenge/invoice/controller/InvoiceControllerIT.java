package br.com.challenge.invoice.controller;

import br.com.challenge.invoice.client.IBahamasInvoiceClient;
import br.com.challenge.invoice.util.BaseIT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "../controller/CleanTable.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class InvoiceControllerIT extends BaseIT {

    @MockBean
    private IBahamasInvoiceClient bahamasInvoiceClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveAndSearchForInvoice() throws Exception {
        getMockMvc()
                .perform(post("/store-bahamas-client/{id}", "1")
                        .param("fiscalId", "2")
                        .param("name", "Test")
                        .param("email", "Teste@challenge.com"))
                .andExpect(status().isCreated())
        ;

        getMockMvc()
                .perform(get("/store-bahamas-client/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.invoiceId", equalTo(1)))
        ;
    }

    @Test
    void shouldThrowErroOnAlreadyRegisteredInvoice() throws Exception {
        getMockMvc()
                .perform(post("/store-bahamas-client/{id}", "1")
                        .param("fiscalId", "2")
                        .param("name", "Test")
                        .param("email", "Teste@challenge.com"))
                .andExpect(status().isCreated())
        ;

        getMockMvc()
                .perform(post("/store-bahamas-client/{id}", "1")
                        .param("fiscalId", "3")
                        .param("name", "Test2")
                        .param("email", "Test2@challenge.com"))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.message", equalTo("Invoice already registered")))
        ;


        getMockMvc()
                .perform(get("/store-bahamas-client/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.invoiceId", equalTo(1)))
        ;
    }

    @Test
    void shouldReturn404WhenInvoiceNotFound() throws Exception {
        getMockMvc()
                .perform(get("/store-bahamas-client/{id}", "1"))
                .andExpect(status().isNotFound());
    }

}