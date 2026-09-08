package app.invoice;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceBoundary {

    private final InvoiceControl invoiceControl;

    public InvoiceBoundary(InvoiceControl invoiceControl) {
        this.invoiceControl = invoiceControl;
    }

    @GetMapping("/all")
    public ResponseEntity<List<InvoiceEntity>> all() {
        return invoiceControl.getAllInvoices();
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(InvoiceEntity invoiceEntity) {
        return invoiceControl.add(invoiceEntity);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> edit(InvoiceEntity invoiceEntity) {
        return invoiceControl.edit(invoiceEntity);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(InvoiceEntity invoiceEntity) {
        return invoiceControl.delete(invoiceEntity);
    }


}
