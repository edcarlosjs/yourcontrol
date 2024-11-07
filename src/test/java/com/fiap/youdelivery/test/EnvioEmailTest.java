package com.fiap.youdelivery.test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class EnvioEmailTest {

    @Autowired
    private EnvioEmailService envioEmailService;

    @Test
    public void testeEnvioEmail() {
        // Chama o método de envio de e-mail para testar a configuração
        envioEmailService.testarEnvioDeEmail();
    }
}