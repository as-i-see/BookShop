package dism3mb3r.shop.model.user;

import dism3mb3r.shop.model.invoice.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    private Type type;
    @OneToMany
    private List<Invoice> invoices;

    public enum Type {
        CUSTOMER, ADMIN
    }
}
