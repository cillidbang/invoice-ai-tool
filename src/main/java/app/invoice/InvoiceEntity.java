package app.invoice;

import app.deliverer.DelivererEntity;
import jakarta.persistence.*;

@Table(name = "invoice")
@Entity
public class InvoiceEntity {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliverer_id")
    DelivererEntity deliverer;

    String invoiceType;
    String invoiceNumber;
    String invoiceDate;
    String expiryDate;
    Double cashAmount;
    boolean isPayed;
    String paymentDate;
    String creationDate;

    public InvoiceEntity() {
    }

    public DelivererEntity getDeliverer() {
        return deliverer;
    }

    public InvoiceEntity setDeliverer(DelivererEntity deliverer) {
        this.deliverer = deliverer;
        return this;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public InvoiceEntity setCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
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

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public InvoiceEntity setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public InvoiceEntity setExpiryDate(String dateOfExpiery) {
        this.expiryDate = dateOfExpiery;
        return this;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public InvoiceEntity setCashAmount(Double amount) {
        this.cashAmount = amount;
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
