package EZEN.brandcon.Product;

import EZEN.brandcon.Brand.Brand;
import EZEN.brandcon.Category.Category;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String name;

    @Column(nullable = false)
    private Long price;

    private int expiryDays;

    private Long sales;

    @ManyToOne
    private Brand brand;

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getExpiryDays() {
        return expiryDays;
    }

    public void incrementSales() {
        this.sales = this.sales + 1;
    }
}
