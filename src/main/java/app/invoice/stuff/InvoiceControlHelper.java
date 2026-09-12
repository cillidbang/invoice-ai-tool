package app.invoice.stuff;

import app.invoice.InvoiceEntity;

public class InvoiceControlHelper {


    public static InvoiceEntity getChangedEntity(InvoiceEntity changes, InvoiceEntity existing) {

        existing.setInvoiceType(changes.getInvoiceType());
        existing.setInvoiceNumber(changes.getInvoiceType());
        existing.setInvoiceDate(changes.getInvoiceType());
        existing.setExpiryDate(changes.getInvoiceType());
        existing.setCashAmount(changes.getCashAmount());
        existing.setPayed(changes.isPayed());
        existing.setPaymentDate(changes.getPaymentDate());
        return existing;
    }
}
