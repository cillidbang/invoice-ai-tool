package app.invoice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceControl {


    private final InvoiceRepository invoiceRepository;

    public InvoiceControl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public ResponseEntity<List<InvoiceEntity>> getAllInvoices() {
        return new ResponseEntity<>(invoiceRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> add(InvoiceEntity invoiceEntity) {
        invoiceRepository.save(invoiceEntity);
        return new ResponseEntity<>("succeed", HttpStatus.OK);

    }

    public ResponseEntity<String> edit(InvoiceEntity invoiceEntity) {
        Optional<InvoiceEntity> entity = invoiceRepository.findById(invoiceEntity.id);
        if (entity.isEmpty()) return new ResponseEntity<>("failed", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>("succeed", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(InvoiceEntity invoiceEntity) {
        invoiceRepository.delete(invoiceEntity);
        return new ResponseEntity<>("succeed", HttpStatus.OK);
    }

}
