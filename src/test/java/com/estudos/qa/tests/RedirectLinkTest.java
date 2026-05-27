package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedirectLinkTest extends BaseTest {

    @Test
    public void testarRedirecionamentoDePagina() {
        
        // 1. AÇÃO. Navegar para a página de Redirector
        driver.findElement(By.linkText("Redirect Link")).click();

        // 2. AÇÃO. Clicar no link que dispara o redirecionamento
        driver.findElement(By.id("redirect")).click();

        // 3. LOGICA DE QA (O PULO DO GATO). 
        // Capturamos a URL atual após o clique.
        String urlAtual = driver.getCurrentUrl();
        System.out.println("URL após redirecionamento: " + urlAtual);

        // 4. VALIDAÇÃO. Verificar se fomos levados para a página de Status Codes
        // O esperado é que a URL termine em '/status_codes'
        assertTrue(urlAtual.endsWith("/status_codes"), 
            "ERRO. O redirecionamento não levou para a página de status codes!");

        // 5. VALIDAÇÃO EXTRA. Verificar se o cabeçalho da nova página está correto
        String cabecalho = driver.findElement(By.tagName("h3")).getText();
        assertEquals("Status Codes", cabecalho, "ERRO. O título da página de destino está incorreto.");
        
        System.out.println("Teste concluído: Redirecionamento validado com sucesso.");
    }
}