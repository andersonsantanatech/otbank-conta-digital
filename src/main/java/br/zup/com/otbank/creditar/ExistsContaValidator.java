package br.zup.com.otbank.creditar;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsContaValidator implements ConstraintValidator<ExistsConta, Object> {

    @Autowired
    private ContaRepository repository;

    private Class<?> clazz;
    private String field;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

        return repository.existsByNumeroConta((String) value);
    }
}