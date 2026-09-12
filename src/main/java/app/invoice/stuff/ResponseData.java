package app.invoice.stuff;

public class ResponseData<T> {

    T entity;
    String responseMessage;

    public ResponseData(T entity, String responseMessage) {
        this.entity = entity;
        this.responseMessage = responseMessage;
    }

    public ResponseData(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseData() {
    }

    public T getEntity() {
        return entity;
    }

    public ResponseData<T> setEntity(T entity) {
        this.entity = entity;
        return this;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public ResponseData<T> setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
        return this;
    }
}
