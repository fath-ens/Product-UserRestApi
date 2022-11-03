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
    @NotNull(groups = Existing.class)
    @Null(groups = New.class)
    private int id;

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

    public ProductDto(int userid, String name, String os, String cpu, int gpu, int ram) {
        this.userid = userid;
        this.name = name;
        this.os = os;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
    }
}