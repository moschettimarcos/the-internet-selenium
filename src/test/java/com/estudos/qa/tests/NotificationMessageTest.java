package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationMessageTest extends BaseTest {

    @Test
    public void testarMensagemDeNotificacaoDinamica() {
        
        // 1. AÇÃO. Navegar para a página (Ajustado para o texto plural "Messages")
        driver.findElement(By.linkText("Notification Messages")).click();

        // 2. AÇÃO. Clicar no link para gerar uma nova mensagem
        driver.findElement(By.linkText("Click here")).click();

        // 3. LOCALIZAR. Capturar o banner de notificação (ID 'flash')
        WebElement bannerNotificacao = driver.findElement(By.id("flash"));
        String textoCompleto = bannerNotificacao.getText();
        
        System.out.println("Mensagem capturada no sistema: " + textoCompleto);

        // 4. VALIDAÇÃO (O PULO DO GATO).
        // Ajustamos para aceitar o erro ortográfico do site "unsuccesful" (com um 's')
        // E usamos partes menores das frases para evitar quebra por pontuação ou ícones.
        boolean sucesso = textoCompleto.contains("Action successful");
        boolean falha = textoCompleto.contains("Action unsuccesful"); 

        assertTrue(sucesso || falha, 
            "ERRO. A mensagem exibida não contém 'Action successful' ou 'Action unsuccesful'. Texto real: " + textoCompleto);
        
        System.out.println("Teste concluído: Notificação validada (mesmo com a pegadinha do site).");
    }
}