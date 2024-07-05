package EZEN.brandcon.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    public ProductRestController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

//    @PostMapping
//    public ResponseEntity<ProductDetailResponse> create(@RequestBody CreateProductRequest request) {
//        ProductDetailResponse product = productService.create(request);
//        return ResponseEntity.created(URI.create("/products/" + product.getId()))
//                .body(product);
//    }
//
//    @GetMapping("/mybatis")
//    public List<ProductDao> findAllMybatis(
//            @RequestParam(required = false) Long brandId,
//            @RequestParam(required = false) Long categoryId,
//            @RequestParam(required = false) String sort
//    ) {
//        return productMapper.findAllByCategoryId(brandId, categoryId, sort);
//    }

//    GET /products?sort=POPULAR
//    GET /products?brandId=23&sort=RECENT
//    GET /products?brandId=23&sort=POPULAR
//    GET /products?categoryId=6&sort=POPULAR
    @GetMapping
    public List<ProductResponse> findAll(@RequestParam(required = false) Long brandId,
                                         @RequestParam(required = false) Long categoryId,
                                         @RequestParam(required = false) String sort
    ) {
        return productService.findAll(brandId, categoryId, sort);
    }

    @GetMapping("/{id}")
    public ProductDetailResponse findById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PatchMapping("/{id}")
    public void purchase(@PathVariable Long id) {
        productService.incrementSales(id);
    }
}
