package EZEN.brandcon.Product;

import java.util.List;

public record ProductResponse(Long productId,
                              String imageUrl,
                              long price,
                              String productName,
                              String brandName
) {
}
