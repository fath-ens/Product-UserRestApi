package com.productuserapi.productUser.Controller;

import com.productuserapi.productUser.DTO.Existing;
import com.productuserapi.productUser.DTO.New;
import com.productuserapi.productUser.DTO.ProductDto;
import com.productuserapi.productUser.DTO.UserDto;
import com.productuserapi.productUser.Entity.Product;
import com.productuserapi.productUser.Entity.User;
import com.productuserapi.productUser.Exception.ErrorCode;
import com.productuserapi.productUser.Exception.ServerException;
import com.productuserapi.productUser.Mapped.MapStructMapper;
import com.productuserapi.productUser.Service.ProductService;
import com.productuserapi.productUser.Service.UserService;
import com.productuserapi.productUser.validation.constraints.Autherizer;
import com.productuserapi.productUser.validation.constraints.IdParametersEqual;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;
    private final UserService userService;
    private final MapStructMapper mapStructMapper;

    @GetMapping("/AllProduct")
    public List<ProductDto> getAllProduct(){
        List<Product> products = productService.getAllProduct();
        List<ProductDto> productDtos = new ArrayList<ProductDto>(products.size());
        for (Product product:products){
            productDtos.add(mapStructMapper.productToProductDto(product));
        }
        return productDtos;
    }

    @GetMapping("/Product/{UserID}")
    public List<ProductDto> getUserID(@PathVariable("UserID") Integer userid){
        User user = userService.getUserID(userid).orElseThrow(() -> new ServerException(ErrorCode.RESOURCE_NOT_FOUND,"hata %s",userid));
        List<Product> products = productService.getUserID(user);
        List<ProductDto> productDtos = new ArrayList<ProductDto>(products.size());
        for (Product product:products){
            productDtos.add(mapStructMapper.productToProductDto(product));
        }
        return productDtos;
    }

    @PostMapping("/NewProduct")
    @Autherizer
    public String newProduct(@Validated(New.class) @RequestBody ProductDto productDto){
        productService.saveNewProduct(mapStructMapper.productDtoToProduct(productDto));
        return "Save to product";
    }

    @PutMapping("/Product/{ProductID}")
    @IdParametersEqual
    @Autherizer
    public ResponseEntity<ProductDto> editProduct(@PathVariable("ProductID") Integer productid, @Validated(Existing.class) @RequestBody ProductDto productDto ){
        return productService.getProductID(productid)
                .map(product -> mapStructMapper.productDtoToProduct(productDto))
                .map(productService::editProduct)
                .map(mapStructMapper::productToProductDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}