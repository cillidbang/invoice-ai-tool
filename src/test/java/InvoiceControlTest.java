import app.Application;
import app.api.invoice.InvoiceControl;
import app.api.invoice.InvoiceEntity;
import app.api.invoice.InvoiceRepository;
import app.api.invoice.InvoiceType;
import app.model.ResponseData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = Application.class)
@TestPropertySource(locations = "classpath:/application-integrationtest.properties")
class InvoiceControlTest {

    @Autowired
    InvoiceControl invoiceControl;

    @Autowired
    InvoiceRepository invoiceRepository;

    @AfterEach
    public void after() {
        invoiceRepository.deleteAll();
    }

    @Test
    public void addInvoice() {
        InvoiceEntity expected = getInvoiceDummy();

        ResponseEntity<ResponseData<InvoiceEntity>> response = invoiceControl.add(expected);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Assertions.assertNotNull(response.getBody());

        InvoiceEntity actual = response.getBody().getEntity();

        assertEquals(actual.getCashAmount(), expected.getCashAmount());
        assertEquals(actual.getInvoiceNumber(), expected.getInvoiceNumber());
        assertEquals(actual.getInvoiceType(), expected.getInvoiceType());
        assertEquals(actual.getInvoiceDate(), expected.getInvoiceDate());
        assertEquals(actual.getDeliverer(), expected.getDeliverer());
        assertEquals(actual.getId(), expected.getId());
        assertEquals(actual.getExpiryDate(), expected.getExpiryDate());
        assertEquals(actual.getPaymentDate(), expected.getPaymentDate());
        assertEquals(actual.getCreationDate(), expected.getCreationDate());
    }

    @Test
    public void getInvoiceById() {
        InvoiceEntity expected = getInvoiceDummy();

        ResponseEntity<ResponseData<InvoiceEntity>> response = invoiceControl.add(expected);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Assertions.assertNotNull(response.getBody());
        Assertions.assertNotNull(response.getBody().getEntity());

        ResponseEntity<ResponseData<InvoiceEntity>> match = invoiceControl.getById(response.getBody().getEntity().getId());

        Assertions.assertNotNull(match.getBody());
        Assertions.assertNotNull(match.getBody().getEntity());

        assertEquals(1L, match.getBody().getEntity().getId());
    }

    @Test
    public void getAllInvoicesEmptyIfEmpty() {
        assertTrue(invoiceControl
                .getAllInvoices()
                .getBody()
                .getEntity()
                .isEmpty());
    }

    @Test
    public void getAllInvoices() {
        List<InvoiceEntity> invoiceDummys = List.of(
                getInvoiceDummy(),
                getInvoiceDummy(),
                getInvoiceDummy()
        );

        //prepare
        for (InvoiceEntity entity : invoiceDummys) {
            invoiceControl.add(entity);
        }

        int totalInvoices = invoiceControl.getAllInvoices().getBody().getEntity().size();

        assertEquals(3, totalInvoices);
    }

    @Test
    public void editInvoice() {
        InvoiceEntity stored = saveDummy();

        assertEquals("123123", stored.getInvoiceNumber());
        assertEquals(1200.00, stored.getCashAmount());

        stored.setInvoiceNumber("FFF");

        ResponseEntity<ResponseData<InvoiceEntity>> responseAfterEdit = invoiceControl.edit(stored);

        assertNotNull(responseAfterEdit.getBody());
        assertNotNull(responseAfterEdit.getBody().getEntity());

        InvoiceEntity edited = responseAfterEdit.getBody().getEntity();

        assertNotEquals(edited, stored);
        assertEquals("FFF", edited.getInvoiceNumber());
    }


    public InvoiceEntity saveDummy() {
        InvoiceEntity expected = getInvoiceDummy();

        ResponseEntity<ResponseData<InvoiceEntity>> response = invoiceControl.add(expected);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Assertions.assertNotNull(response.getBody());

        return response.getBody().getEntity();
    }


    public InvoiceEntity getInvoiceDummy() {
        InvoiceEntity expected = new InvoiceEntity();
        expected.setDeliverer(null);
        expected.setInvoiceType(String.valueOf(InvoiceType.RECHNUNG));
        expected.setInvoiceNumber("123123");
        expected.setInvoiceDate(LocalDateTime.now().toString());
        expected.setExpiryDate(LocalDateTime.now().plusWeeks(5L).toString());
        expected.setCashAmount(1200.00);
        expected.setPayed(false);
        expected.setPaymentDate(null);
        expected.setCreationDate(String.valueOf(LocalDateTime.now()));
        return expected;
    }

}