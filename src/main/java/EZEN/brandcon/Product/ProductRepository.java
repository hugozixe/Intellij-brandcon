package EZEN.brandcon.Product;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Product p where p.id = ?1")
    Optional<Product> findByIdForUpdate(Long id);
    List<Product> findAllByOrderBySalesDesc();
    List<Product> findAllByBrandId(Long brandId);
    List<Product> findAllByBrandIdOrderBySalesDesc(Long brandId);
//    List<Product> findAllByCategoryId(Long categoryId);
//    List<Product> findAllByCategoryIdOrderBySalesDesc(Long categoryId);
}
