package EZEN.brandcon.Brand;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandRestController {

    public final BrandService brandService;

    public BrandRestController(BrandService brandService) {
        this.brandService = brandService;
    }

//    GET /brands?categoryId=5
    @GetMapping
    public List<BrandResponse> findAll(@RequestParam Long categoryId) {
        return brandService.findAllByCategoryId(categoryId);
    }
}
