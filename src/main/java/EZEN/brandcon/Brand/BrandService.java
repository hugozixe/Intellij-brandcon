package EZEN.brandcon.Brand;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandResponse> findAllBrands() {
        return brandRepository.findAll()
                .stream().map(brand -> new BrandResponse(
                        brand.getId(),
                        brand.getImageUrl(),
                        brand.getName()
                ))
                .toList();
    }

    public List<BrandResponse> findAllByCategoryId(Long categoryId) {
        return brandRepository.findAllByCategoryId(categoryId)
                .stream().map(brand -> new BrandResponse(
                        brand.getId(),
                        brand.getImageUrl(),
                        brand.getName()
                ))
                .toList();
    }
}
