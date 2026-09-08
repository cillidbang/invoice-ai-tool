package app.invoice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class InvoiceEntity {


    @Id
    Long id;

    String invoiceType;
    String invoiceNumber;
    String deliverer;
    LocalDate invoiceDate;
    LocalDate dateOfExpiery;
    Double amount;
    boolean isPayed;
    LocalDate paymentDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
