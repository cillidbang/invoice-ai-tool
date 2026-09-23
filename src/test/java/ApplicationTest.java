import static org.junit.jupiter.api.Assertions.assertEquals;


import app.Application;
import app.invoice.InvoiceControl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest(classes = Application.class)
@TestPropertySource(locations = "classpath:/application-integrationtest.properties")
class ApplicationTest {

    @Autowired
    InvoiceControl invoiceControl;

    @Test
    void addition() {
        assertEquals("Hello", invoiceControl.sayHello());
    }

}