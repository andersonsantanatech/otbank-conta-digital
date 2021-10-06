package br.zup.com.otbank.transacao;

import br.zup.com.otbank.Conta;
import br.zup.com.otbank.ContaRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/transacoes")
public class TransacaoController {

    private ContaRepository repository;

    public TransacaoController(ContaRepository contaRepository) {
        this.repository = contaRepository;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> creditar(@RequestBody @Valid TransacaoRequest request) {
        Conta conta = repository.findByNumeroConta(request.getNumeroConta()).get();
        request.executaTransacao(conta);

        return ResponseEntity.ok().build();
    }

}
