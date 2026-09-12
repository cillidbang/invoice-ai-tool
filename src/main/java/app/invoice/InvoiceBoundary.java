package app.invoice;


import app.invoice.stuff.ResponseData;
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
    public ResponseEntity<ResponseData<List<InvoiceEntity>>> all() {
        return invoiceControl.getAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<InvoiceEntity>> findById(@PathVariable Long id) {
        return invoiceControl.getById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseData<InvoiceEntity>> add(@RequestBody InvoiceEntity invoiceEntity) {
        return invoiceControl.add(invoiceEntity);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<InvoiceEntity>> edit(@RequestBody InvoiceEntity invoiceEntity) {
        return invoiceControl.edit(invoiceEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<InvoiceEntity>> deleteById(@PathVariable Long id) {
        return invoiceControl.delete(id);
    }


}
