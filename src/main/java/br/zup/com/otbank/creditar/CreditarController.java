package br.zup.com.otbank.creditar;

import br.zup.com.otbank.Conta;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/creditar")
public class CreditarController {

    private GerarContaService gerarContaService;
    private ContaRepository repository;

    public CreditarController(GerarContaService gerarContaService, ContaRepository contaRepository) {
        this.gerarContaService = gerarContaService;
        this.repository = contaRepository;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> creditar(@RequestBody @Valid CreditarRequest request) {
        Conta conta = repository.findByNumeroConta(request.getNumeroConta()).get();
        conta.creditar(request.getValor());

        return ResponseEntity.ok(new CreditarResponse(conta.getSaldo()));
    }
}
