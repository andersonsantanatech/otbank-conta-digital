package br.zup.com.otbank.debitar;

import br.zup.com.otbank.Conta;
import br.zup.com.otbank.ContaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/debitar")
public class DebitarController {

    private ContaRepository repository;

    public DebitarController(ContaRepository repository) {
        this.repository = repository;
    }

    @PutMapping
    public ResponseEntity<?> debitar(@RequestBody @Valid DebitarRequest request) {

        Conta conta = repository.findByNumeroConta(request.getNumeroConta()).get();
        conta.debitar(request.getValor());

        return ResponseEntity.ok(new DebitarResponse(conta.getSaldo()));
    }
}
