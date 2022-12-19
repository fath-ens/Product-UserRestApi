package com.productuserapi.productUser.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    @NotNull
    private int userid;

    @NotEmpty
    @Size(max = 255)
    private String name;

    @NotEmpty
    @Size(max = 255)
    private String os;

    @NotEmpty
    @Size(max = 255)
    private String cpu;

    @NotNull
    @Max(64)
    private int gpu;

    @NotNull
    @Max(64)
    private int ram;

}