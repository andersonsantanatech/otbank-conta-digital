package br.zup.com.otbank.debitar;

import java.math.BigDecimal;

public class DebitarResponse {

    private BigDecimal saldo;

    public DebitarResponse(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
