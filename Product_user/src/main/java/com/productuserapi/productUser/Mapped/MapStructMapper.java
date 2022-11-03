package com.productuserapi.productUser.Mapped;

import com.productuserapi.productUser.DTO.ProductDto;
import com.productuserapi.productUser.DTO.UserDto;
import com.productuserapi.productUser.Entity.Product;
import com.productuserapi.productUser.Entity.User;
import com.productuserapi.productUser.Exception.ErrorCode;
import com.productuserapi.productUser.Exception.ServerException;
import com.productuserapi.productUser.Service.UserService;
import org.mapstruct.*;

import javax.inject.Inject;

@Mapper(componentModel = "spring")
public abstract class MapStructMapper {
   @Inject
   UserService userService;

    @Mapping(target = "userid", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract Product productDtoToProduct(ProductDto productDto);

    @Mapping(target = "userid", ignore = true)
    public abstract ProductDto productToProductDto(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    public abstract User userDtoToUser(UserDto userDto, @MappingTarget User user);


    public abstract UserDto userToUserDto(User user);

    @AfterMapping
    public void ProductToProductDtoAfter(Product product, @MappingTarget ProductDto productDto){
        productDto.setUserid(product.getUserid().getId());
    }

    @AfterMapping
    public void ProductDtoToProduct(ProductDto productDto, @MappingTarget Product product){
        product.setUserid(userService.getUserID(productDto.getUserid()).orElseThrow(()->new ServerException(ErrorCode.RESOURCE_NOT_FOUND,"Hata %s",productDto.getUserid())));
    }


}
