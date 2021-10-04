package br.zup.com.otbank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroConta;

    private UUID idCliente;

    private BigDecimal saldo;

    @Deprecated
    public Conta() { }

    public Conta(String numeroConta, UUID idCliente, BigDecimal saldo) {
        this.numeroConta = numeroConta;
        this.idCliente = idCliente;
        this.saldo = saldo;
    }

    public void creditar(BigDecimal valor) {
        if (valor.doubleValue() <= 0) {
            return;
        }

        this.saldo = this.saldo.add(valor);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(numeroConta, conta.numeroConta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroConta);
    }
}
