package br.zup.com.otbank.creditar;

import br.zup.com.otbank.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByNumeroConta(String numeroConta);

    Boolean existsByNumeroContaAndIdCliente(String numeroConta, UUID idCliente);

    boolean existsByNumeroConta(String numeroConta);
}
