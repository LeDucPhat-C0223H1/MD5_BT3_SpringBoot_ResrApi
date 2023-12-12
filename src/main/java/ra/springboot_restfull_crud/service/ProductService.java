package ra.springboot_restfull_crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.springboot_restfull_crud.dto.ProductDto;
import ra.springboot_restfull_crud.exception.NotFoundException;
import ra.springboot_restfull_crud.model.Product;
import ra.springboot_restfull_crud.repository.IProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final IProductRepository productRepository;
    private final UploadService uploadService;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy id"));
    }

    @Override
    public Product add(ProductDto productDto) {
        String imageUrl = null;
        if(!productDto.getFileImage().isEmpty()){
            imageUrl = uploadService.uploadFileImage(productDto.getFileImage());
        }
        return productRepository.save(new Product(productDto,imageUrl));
    }

    @Override
    public Product update(Product product, MultipartFile fileImage) {
        String imageUrl = productRepository.findById(product.getProductId()).get().getImageUrl();
        if(!fileImage.isEmpty()){
            imageUrl = uploadService.uploadFileImage(fileImage);
        }
        product.setImageUrl(imageUrl);
        return productRepository.save(product);
    }


    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
