package com.productuserapi.productUser.validation.constraints;



import com.productuserapi.productUser.validation.constraints.validators.IdParametersEqualValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = IdParametersEqualValidator.class)
@Target({METHOD, CONSTRUCTOR})
@Retention(RUNTIME)
@Documented
public @interface IdParametersEqual {

    /**
     * Index of the id field in the method argument list.
     *
     * @return the index of the id field
     */
    int idIndex() default 0;

    /**
     * Index of the given DTO in the method argument list.
     *
     * @return the index of the given DTO
     */
    int dtoIndex() default 1;

    /**
     * Name of the id field of the DTO.
     *
     * @return the name of the id field
     */
    String idFieldName() default "id";

    String message() default "Id in the path and id in the given DTO should match.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
