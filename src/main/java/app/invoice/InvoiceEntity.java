package app.invoice;

import jakarta.persistence.*;

@Table(name = "invoice")
@Entity
public class InvoiceEntity {

    @Id
    @GeneratedValue
    Long id;

    String invoiceType;
    String invoiceNumber;
    String deliverer;
    String invoiceDate;
    String dateOfExpiery;
    Double amount;
    boolean isPayed;
    String paymentDate;

    public InvoiceEntity() {
    }

    public Long getId() {
        return id;
    }

    public InvoiceEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public InvoiceEntity setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
        return this;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public InvoiceEntity setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public InvoiceEntity setDeliverer(String deliverer) {
        this.deliverer = deliverer;
        return this;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public InvoiceEntity setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public String getDateOfExpiery() {
        return dateOfExpiery;
    }

    public InvoiceEntity setDateOfExpiery(String dateOfExpiery) {
        this.dateOfExpiery = dateOfExpiery;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public InvoiceEntity setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public InvoiceEntity setPayed(boolean payed) {
        isPayed = payed;
        return this;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public InvoiceEntity setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }
}
