package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Set;

public class MultipleWindowsTest extends BaseTest {

    @Test
    public void testarTrocaDeJanelas() {
        
        // 1. AÇÃO. Navegar para a página de Multiple Windows
        driver.findElement(By.linkText("Multiple Windows")).click();

        // 2. LOGICA DE QA. Guardar o ID (Handle) da janela onde estamos agora
        String janelaOriginal = driver.getWindowHandle();
        System.out.println("ID da Janela Original: " + janelaOriginal);

        // 3. AÇÃO. Clicar no link que, pelo HTML (target="_blank"), abre nova aba
        driver.findElement(By.linkText("Click Here")).click();

        // 4. LOGICA DE QA (O PULO DO GATO). 
        // Capturamos todos os IDs de janelas abertas no momento.
        Set<String> todasJanelas = driver.getWindowHandles();

        // 5. AÇÃO. Percorrer a lista de IDs e mudar o foco para o ID que for diferente do original
        for (String janela : todasJanelas) {
            if (!janela.equals(janelaOriginal)) {
                driver.switchTo().window(janela);
                break;
            }
        }

        // 6. VALIDAÇÃO. Verificar se o título na nova aba é o esperado
        String textoNovaJanela = driver.findElement(By.tagName("h3")).getText();
        assertEquals("New Window", textoNovaJanela, 
            "ERRO. O Selenium ainda está focado na janela errada!");
        
        System.out.println("Sucesso! O driver agora enxerga a: " + textoNovaJanela);

        // 7. LIMPEZA. Fechar a aba atual (a nova) e retornar para a principal
        driver.close(); 
        driver.switchTo().window(janelaOriginal);
        
        System.out.println("Foco devolvido à janela principal.");
    }
}