package br.zup.com.otbank.creditar;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/creditar")
public class CreditarController {

    private GerarContaService gerarContaService;

    public CreditarController(GerarContaService gerarContaService) {
        this.gerarContaService = gerarContaService;
    }

    @PostMapping
    public void creditar() {

        System.out.println(gerarContaService.criarNumeroConta());

    }
}
