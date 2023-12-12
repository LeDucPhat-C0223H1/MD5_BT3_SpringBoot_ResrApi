package ra.springboot_restfull_crud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import ra.springboot_restfull_crud.dto.ProductDto;

import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(length = 4)
    private String productId;

    @Column(length = 100)
    private String productName;

    @Column(columnDefinition = "text")
    private String imageUrl;

    @Column(columnDefinition = "text")
    private String description;

    private Boolean status;

    public Product(ProductDto productDto, String imageUrl) {
        this.productId = productDto.getProductId();
        this.productName = productDto.getProductName();
        this.imageUrl = imageUrl;
        this.description = productDto.getDescription();
        this.status = true;
    }
}
