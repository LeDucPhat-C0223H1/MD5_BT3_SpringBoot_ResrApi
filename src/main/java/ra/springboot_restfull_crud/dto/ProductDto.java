package ra.springboot_restfull_crud.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
    private String productId;
    private String productName;
    private MultipartFile fileImage;
    private String description;


    public ProductDto() {
    }

    public ProductDto(String productId, String productName, MultipartFile fileImage, String description) {
        this.productId = productId;
        this.productName = productName;
        this.fileImage = fileImage;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public MultipartFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(MultipartFile fileImage) {
        this.fileImage = fileImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
