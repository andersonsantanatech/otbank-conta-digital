package br.zup.com.otbank.creditar;

import java.math.BigDecimal;

public class CreditarResponse {

    private BigDecimal saldo;

    public CreditarResponse(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
