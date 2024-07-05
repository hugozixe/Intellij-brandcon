package EZEN.brandcon.Product;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductResponse> findAll(Long brandId, Long categoryId, String sort);
}
