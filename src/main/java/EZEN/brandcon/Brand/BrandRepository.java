package EZEN.brandcon.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("select b from CategoryBrand cb JOIN cb.brand b where cb.category.id = ?1")
    List<Brand> findAllByCategoryId(Long categoryId);
}
