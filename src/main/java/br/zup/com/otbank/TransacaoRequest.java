package br.zup.com.otbank;

import javax.validation.constraints.NotBlank;

public abstract class TransacaoRequest {

    @NotBlank
    protected String numeroConta;

    @NotBlank
    protected String idCliente;

    public TransacaoRequest(String numeroConta, String idCliente) {
        this.numeroConta = numeroConta;
        this.idCliente = idCliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getIdCliente() {
        return idCliente;
    }
}
