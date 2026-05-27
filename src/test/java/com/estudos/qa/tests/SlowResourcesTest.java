package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlowResourcesTest extends BaseTest {

    @Test
    public void testarPaginaComCarregamentoLento() {
        
        // 1. CONFIGURAÇÃO (O PULO DO GATO). 
        // Aumentamos o tempo limite de carregamento da página para 35 segundos,
        // já que o recurso interno do site demora 30s para responder.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

        // 2. AÇÃO. Navegar para a página de Slow Resources.
        // O Selenium ficará "parado" nesta linha até a página carregar ou dar timeout.
        driver.findElement(By.linkText("Slow Resources")).click();

        // 3. LOCALIZAR. Capturar o cabeçalho da página.
        String tituloPagina = driver.findElement(By.tagName("h3")).getText();
        
        System.out.println("Página carregada após a espera do recurso lento.");

        // 4. VALIDAÇÃO. Confirmar se o título está correto.
        assertEquals("Slow Resources", tituloPagina, "ERRO. A página não carregou corretamente!");

        // 5. LIMPEZA (BOA PRÁTICA). 
        // Resetamos o timeout para o padrão (ex: 10 ou 20s) para não atrasar outros testes que falharem.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
}