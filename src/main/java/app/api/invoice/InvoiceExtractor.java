package app.api.invoice;

public interface InvoiceExtractor {

    InvoiceEntity extract(String invoiceContent);
}
