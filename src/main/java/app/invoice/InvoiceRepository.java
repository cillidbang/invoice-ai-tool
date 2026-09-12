package app.invoice;

import org.jspecify.annotations.NullMarked;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {

    List<InvoiceEntity> findAll();

}
