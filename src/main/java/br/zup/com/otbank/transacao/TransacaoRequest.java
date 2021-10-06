package br.zup.com.otbank.transacao;

import br.zup.com.otbank.Conta;
import br.zup.com.otbank.validacao.ExistsConta;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@ExistsConta
public class TransacaoRequest {

    @NotBlank
    private String numeroConta;

    @NotBlank
    private String idCliente;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private TipoTransacao tipoTransacao;

    public TransacaoRequest(String numeroConta, String idCliente, BigDecimal valor, TipoTransacao tipoTransacao) {
        this.numeroConta = numeroConta;
        this.idCliente = idCliente;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void executaTransacao(Conta conta) {
        tipoTransacao.execute(conta, valor);
    }
}
