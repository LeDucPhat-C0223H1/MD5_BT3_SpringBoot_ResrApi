package ra.springboot_restfull_crud.service;


import org.springframework.web.multipart.MultipartFile;
import ra.springboot_restfull_crud.dto.ProductDto;
import ra.springboot_restfull_crud.exception.NotFoundException;
import ra.springboot_restfull_crud.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(String id) throws NotFoundException;
    Product add (ProductDto productDto);
    Product update (Product product, MultipartFile fileImage);
    void delete(String id);
}
