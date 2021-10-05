package br.zup.com.otbank.validacao;

import br.zup.com.otbank.creditar.ContaRepository;
import br.zup.com.otbank.creditar.CreditarRequest;
import br.zup.com.otbank.exception.UnprocessableContaException;
import org.springframework.beans.factory.annotation.Autowired;
import br.zup.com.otbank.exception.ContaNotFoundException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class ExistsContaValidator implements ConstraintValidator<ExistsConta, CreditarRequest> {

    @Autowired
    private ContaRepository repository;

    private Class<?> clazz;
    private String field;

    @Override
    public boolean isValid(CreditarRequest value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        if (!repository.existsByNumeroConta(value.getNumeroConta())){
            throw new ContaNotFoundException("Conta Não Existe");
        }
        if(!repository.existsByNumeroContaAndIdCliente(value.getNumeroConta(), UUID.fromString(value.getIdCliente()))){
            throw new UnprocessableContaException("Conta Não pertence a este cliente.");
        }

        return true;
    }
}