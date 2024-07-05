package EZEN.brandcon.Brand;

import EZEN.brandcon.Category.Category;
import jakarta.persistence.*;

@Entity
public class CategoryBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    public Long getId() {
        return id;
    }
}


