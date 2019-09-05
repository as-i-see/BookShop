package dism3mb3r.shop.model.book;

import dism3mb3r.shop.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Column(columnDefinition = "INT(5) UNSIGNED")
    private Integer price;
    @ManyToOne
    private Category category;
}
