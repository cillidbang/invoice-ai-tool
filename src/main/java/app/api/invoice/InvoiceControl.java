package app.api.invoice;

import app.model.ResponseData;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceControl {

    private final InvoiceRepository invoiceRepository;

    public InvoiceControl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public ResponseEntity<ResponseData<InvoiceEntity>> getById(Long id) {
        Optional<InvoiceEntity> entity = invoiceRepository.findById(id);
        if (entity.isEmpty()) return ResponseEntity.ok(new ResponseData<>("cannot find id: %s".formatted(id)));
        InvoiceEntity found = entity.get();
        return ResponseEntity.ok(new ResponseData<>(found,"entity found"));
    }

    public ResponseEntity<ResponseData<List<InvoiceEntity>>> getAllInvoices() {
        return ResponseEntity.ok(new ResponseData<>(invoiceRepository.findAll(),"entity found"));
    }

    public ResponseEntity<ResponseData<InvoiceEntity>> add(InvoiceEntity invoiceEntity) {
        invoiceEntity.setCreationDate(LocalDateTime.now().toString());
        InvoiceEntity added = invoiceRepository.save(invoiceEntity);
        return ResponseEntity.ok(new ResponseData<>(added,"saved"));
    }

    public ResponseEntity<ResponseData<InvoiceEntity>> readInvoiceFile(MultipartFile file) throws IOException {

        file.getBytes();

        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName("gpt-5.1")
                .strictJsonSchema(true)
                .build();

        InvoiceExtractor personExtractor = AiServices.create(InvoiceExtractor.class, model);

        InvoiceEntity e = personExtractor.extract("1200€");

        return null;
    }

    public ResponseEntity<ResponseData<InvoiceEntity>> edit(InvoiceEntity fromFe) {
        Optional<InvoiceEntity> existing = invoiceRepository.findById(fromFe.id);

        if (existing.isEmpty()) return ResponseEntity
                .internalServerError()
                .body(new ResponseData<>("saved"));

        InvoiceEntity added = invoiceRepository.save(fromFe);

        return ResponseEntity.ok(new ResponseData<>(added,"sucessfully edited id: %s".formatted(added.getId())));
    }

    public ResponseEntity<ResponseData<InvoiceEntity>> delete(Long id) {
        Optional<InvoiceEntity> entity = invoiceRepository.findById(id);

        if (entity.isEmpty()) return ResponseEntity
                .badRequest()
                .body(new ResponseData<>("cannot find id %s".formatted(id)));

        InvoiceEntity found = entity.get();
        invoiceRepository.delete(found);

        return ResponseEntity.ok().body(new ResponseData<>("successfully deleted invoice with id: %s".formatted(id)));
    }

}
