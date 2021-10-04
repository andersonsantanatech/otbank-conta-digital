package br.zup.com.otbank.creditar;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsContaValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsConta {
    //Spring não retorna mensagem que esta no resources -> messages.properties
    //String message() default "{br.com.zupacademy.eduardo.casadocodigo.beanvalidation.existsId}";

    String message() default "Conta não encontrada !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
