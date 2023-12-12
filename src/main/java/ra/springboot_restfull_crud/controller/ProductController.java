package ra.springboot_restfull_crud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.springboot_restfull_crud.dto.ProductDto;
import ra.springboot_restfull_crud.exception.NotFoundException;
import ra.springboot_restfull_crud.model.Product;
import ra.springboot_restfull_crud.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable String id) throws NotFoundException {
        return productService.findById(id);
    }

    @PostMapping
    public Product add (@ModelAttribute ProductDto productDto){
        return productService.add(productDto);
    }

    @PutMapping("/{id}")
    public Product update(@ModelAttribute Product product, @PathVariable String id, @RequestParam("fileImage") MultipartFile fileImage){
        product.setProductId(id);
        return productService.update(product, fileImage);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        productService.delete(id);
        return "Xóa thành công";
    }
}
