import static org.junit.jupiter.api.Assertions.assertEquals;


import app.Application;
import app.invoice.InvoiceControl;
import app.invoice.InvoiceEntity;
import app.invoice.InvoiceType;
import app.invoice.stuff.ResponseData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDateTime;


@SpringBootTest(classes = Application.class)
@TestPropertySource(locations = "classpath:/application-integrationtest.properties")
class InvoiceControlTest {

    @Autowired
    InvoiceControl invoiceControl;

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