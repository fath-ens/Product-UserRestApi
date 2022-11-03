package com.productuserapi.productUser.validation.constraints.validators;

import com.productuserapi.productUser.validation.constraints.Autherizer;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;


@Slf4j
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class AutherizerValidator implements ConstraintValidator<Autherizer, Object[]> {

    private int OSname;
    private String FieldName;



    @Override
    public void initialize(Autherizer constraintAnnotation) {
        OSname = constraintAnnotation.OSname();
        FieldName = constraintAnnotation.FieldName();
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        Object product= value[OSname];
        if (product == null){
            return false;
        }
        Field OSField = getField(product.getClass(), FieldName);
        if (OSField == null) {
            return false;
        }

        OSField.setAccessible(true);
        Object OSname;
        try {
            OSname = OSField.get(product);
        } catch (IllegalAccessException ex) {
            log.error("Illegal access on OS field {}.", OSField, ex);
            return false;
        }
        OSField.setAccessible(false);

        List<String> OSnm = new ArrayList<String>(3);
        OSnm.add("Windows");
        OSnm.add("MacOS");
        OSnm.add("Linux");
        int a =0;
        for (String oss :OSnm){
            if (Objects.equals(oss,OSname)){
                a++;
            }
        }
        if (a>0){
            return true;
        }
        else{
            return false;
        }

    }

    private <T> Field getField(Class<T> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException ex) {
            if (clazz.getSuperclass() != null) {
                return getField(clazz.getSuperclass(), fieldName);
            }
            log.error("No OS field on {} found.", clazz, ex);
        }
        return null;
    }
}
