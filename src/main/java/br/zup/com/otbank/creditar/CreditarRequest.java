package br.zup.com.otbank.creditar;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class CreditarRequest {

    @ExistsConta
    @NotBlank
    private String numeroConta;

    @NotBlank
    private String idCliente;

    @NotNull
    @Positive
    private BigDecimal valor;

    public CreditarRequest() {
    }

    public CreditarRequest(String numeroConta, String idCliente, BigDecimal valor) {
        this.numeroConta = numeroConta;
        this.idCliente = idCliente;
        this.valor = valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
