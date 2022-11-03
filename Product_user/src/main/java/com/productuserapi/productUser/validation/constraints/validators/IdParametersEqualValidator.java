package com.productuserapi.productUser.validation.constraints.validators;

import com.productuserapi.productUser.validation.constraints.IdParametersEqual;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.lang.reflect.Field;
import java.util.Objects;

@Slf4j
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class IdParametersEqualValidator implements ConstraintValidator<IdParametersEqual,Object[]> {

    private int idIndex;

    private int dtoIndex;

    private String idFieldName;


    @Override
    public void initialize(IdParametersEqual constraintAnnotation) {
        idIndex = constraintAnnotation.idIndex();
        dtoIndex = constraintAnnotation.dtoIndex();
        idFieldName = constraintAnnotation.idFieldName();
    }

    @Override
    public boolean isValid(Object[] methodParameters, ConstraintValidatorContext context) {
        Object idParameter = methodParameters[idIndex];
        Object dtoParameter = methodParameters[dtoIndex];
        if (idParameter == null || dtoParameter == null) {
            return false;
        }

        Field idFieldOfDto = getField(dtoParameter.getClass(), idFieldName);
        if (idFieldOfDto == null) {
            return false;
        }

        idFieldOfDto.setAccessible(true);
        Object idFieldValueOfDto;
        try {
            idFieldValueOfDto = idFieldOfDto.get(dtoParameter);
        } catch (IllegalAccessException ex) {
            log.error("Illegal access on id field {}.", idFieldOfDto, ex);
            return false;
        }
        idFieldOfDto.setAccessible(false);

        return Objects.equals(idParameter, idFieldValueOfDto);
    }

    private <T> Field getField(Class<T> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException ex) {
            if (clazz.getSuperclass() != null) {
                return getField(clazz.getSuperclass(), fieldName);
            }
            log.error("No id field on {} found.", clazz, ex);
        }
        return null;
    }

}
