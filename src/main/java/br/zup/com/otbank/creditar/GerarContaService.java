package br.zup.com.otbank.creditar;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GerarContaService {

    public String criarNumeroConta() {
        Random random = new Random();
        int digito = random.nextInt(9);

        String numeroConta = "";

        for (int i = 0; i < 4; i++) {
            numeroConta += random.nextInt(9);
        }
            numeroConta+= "-" + digito;
        return numeroConta;
    }
}
