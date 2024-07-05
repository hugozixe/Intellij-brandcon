package EZEN.brandcon.Product;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductResponse> findAll(Long brandId, Long categoryId, String sort) {
        return productMapper.findAll(brandId, categoryId, sort);
    }

    public ProductDetailResponse findProductById(Long productId) {

        Product product = productRepository.findById(productId)
                .orElse(null);

        if (product == null) {
            throw new NoSuchElementException("상품을 찾을 수가 없습니다 productId : " + productId);
        }

        return new ProductDetailResponse(
                product.getId(),
                product.getName(),
                product.getBrand().getId(),
                product.getBrand().getName(),
                product.getPrice(),
                product.getExpiryDays()
        );
    }

    @Transactional
    public void incrementSales(Long id) {
        Product product = productRepository.findByIdForUpdate(id)
                .orElse(null);
        if (product == null) {
            throw new IllegalArgumentException("판매량을 증가시킬 수 없는 상품입니다 id: " + id);
        }
        product.incrementSales();
    }
}

