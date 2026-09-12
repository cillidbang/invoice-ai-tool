package app.invoice.stuff;

import app.invoice.InvoiceEntity;

public class InvoiceControlHelper {


    public static InvoiceEntity getChangedEntity(InvoiceEntity changes, InvoiceEntity existing) {

        existing.setInvoiceType(changes.getInvoiceType());
        existing.setInvoiceNumber(changes.getInvoiceType());
        existing.setDeliverer(changes.getInvoiceType());
        existing.setInvoiceDate(changes.getInvoiceType());
        existing.setDateOfExpiery(changes.getInvoiceType());
        existing.setAmount(changes.getAmount());
        existing.setPayed(changes.isPayed());
        existing.setPaymentDate(changes.getPaymentDate());
        return existing;
    }
}
