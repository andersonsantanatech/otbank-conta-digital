package br.zup.com.otbank.transacao;

import br.zup.com.otbank.Conta;

import java.math.BigDecimal;

public enum TipoTransacao {

    CREDITO {

        @Override
        public void execute(Conta conta, BigDecimal valor) {
            conta.creditar(valor);
        }

    }, DEBITO{

        @Override
        public void execute(Conta conta, BigDecimal valor) {
            conta.debitar(valor);
        }

    };

    public abstract void execute(Conta conta, BigDecimal valor);

}
