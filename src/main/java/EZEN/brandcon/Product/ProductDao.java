package EZEN.brandcon.Product;

public record ProductDao(Long id,
                         String productImageUrl,
                         long price,
                         String productName,
                         String brandName) {
}
