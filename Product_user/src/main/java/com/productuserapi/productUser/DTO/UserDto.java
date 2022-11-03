package com.productuserapi.productUser.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class UserDto implements Serializable {

    @NotNull(groups = Existing.class)
    @Null(groups = New.class)
    private int id;

    @NotEmpty
    @Size(max = 255)
    private String name;

}