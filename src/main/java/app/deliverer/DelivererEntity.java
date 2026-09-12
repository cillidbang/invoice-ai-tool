package app.deliverer;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "deliverer")
@Entity
public class DelivererEntity {

    @Id
    @GeneratedValue
    Long id;

    String companyName;
    String iban;
    String creationDate;

    public DelivererEntity() {
    }

    public Long getId() {
        return id;
    }

    public DelivererEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public DelivererEntity setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getIban() {
        return iban;
    }

    public DelivererEntity setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public DelivererEntity setCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}
