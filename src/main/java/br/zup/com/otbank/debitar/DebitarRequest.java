package br.zup.com.otbank.debitar;

import br.zup.com.otbank.TransacaoRequest;
import br.zup.com.otbank.validacao.ExistsConta;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@ExistsConta
public class DebitarRequest extends TransacaoRequest {

    @NotNull
    @Positive
    private BigDecimal valor;

    public DebitarRequest(String numeroConta, String idCliente, BigDecimal valor) {
        super(numeroConta, idCliente);
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
