package com.productuserapi.productUser.Mapped;

import com.productuserapi.productUser.DTO.ProductDto;
import com.productuserapi.productUser.DTO.UserDto;
import com.productuserapi.productUser.Entity.Product;
import com.productuserapi.productUser.Entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-03T14:34:16+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl extends MapStructMapper {

    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( productDto.getName() );
        product.setOs( productDto.getOs() );
        product.setCpu( productDto.getCpu() );
        product.setGpu( productDto.getGpu() );
        product.setRam( productDto.getRam() );

        ProductDtoToProduct( productDto, product );

        return product;
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setOs( product.getOs() );
        productDto.setCpu( product.getCpu() );
        productDto.setGpu( product.getGpu() );
        productDto.setRam( product.getRam() );

        ProductToProductDtoAfter( product, productDto );

        return productDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto, User user) {
        if ( userDto == null ) {
            return null;
        }

        user.setName( userDto.getName() );

        return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );

        return userDto;
    }
}
