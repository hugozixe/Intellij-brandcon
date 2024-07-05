package EZEN.brandcon.Product;

public record ProductDetailResponse(Long productId,
                                    String productName,
                                    Long brandId,
                                    String brandName,
                                    long price,
                                    int expiryTime
) {
}
