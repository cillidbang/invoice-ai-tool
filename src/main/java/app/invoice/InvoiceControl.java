package app.invoice;

import app.invoice.stuff.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static app.invoice.stuff.InvoiceControlHelper.getChangedEntity;

@Service
public class InvoiceControl {

    private final InvoiceRepository invoiceRepository;

    public InvoiceControl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public ResponseEntity<ResponseData<InvoiceEntity>> getById(Long id) {

        Optional<InvoiceEntity> entity = invoiceRepository.findById(id);

        if (entity.isEmpty()) {
            return new ResponseEntity<>(new ResponseData<>("cannot find id %s".formatted(id)), HttpStatus.OK);
        }
        InvoiceEntity found = entity.get();

        return new ResponseEntity<>(new ResponseData<>(found,"entity found"), HttpStatus.OK);
    }

    public ResponseEntity<ResponseData<List<InvoiceEntity>>> getAllInvoices() {
        return new ResponseEntity<>(new ResponseData<>(invoiceRepository.findAll(), "sucessful"), HttpStatus.OK);
    }

    public ResponseEntity<ResponseData<InvoiceEntity>> add(InvoiceEntity invoiceEntity) {
        invoiceEntity.setCreationDate(LocalDateTime.now().toString());
        InvoiceEntity added = invoiceRepository.save(invoiceEntity);
        return new ResponseEntity<>(new ResponseData<>(added, "sucessful"), HttpStatus.OK);
    }

    public ResponseEntity<ResponseData<InvoiceEntity>> edit(InvoiceEntity fromFe) {
        Optional<InvoiceEntity> existing = invoiceRepository.findById(fromFe.id);

        if (existing.isEmpty()) return new ResponseEntity<>(new ResponseData<>(null, "failed"), HttpStatus.INTERNAL_SERVER_ERROR);

        InvoiceEntity foundEntity = getChangedEntity(fromFe, existing.get());
        InvoiceEntity added = invoiceRepository.save(foundEntity);

        return new ResponseEntity<>(new ResponseData<>(added, "sucessfully edited id: %s".formatted(added.getId())), HttpStatus.OK);
    }

    public ResponseEntity<ResponseData<InvoiceEntity>> delete(Long id) {
        Optional<InvoiceEntity> entity = invoiceRepository.findById(id);

        if (entity.isEmpty()) {
            return new ResponseEntity<>(new ResponseData<>("cannot find id %s".formatted(id)), HttpStatus.OK);
        }

        InvoiceEntity found = entity.get();
        invoiceRepository.delete(found);

        return new ResponseEntity<>(new ResponseData<>("successfully deleted invoice with id: %s".formatted(id)), HttpStatus.OK);
    }

}
