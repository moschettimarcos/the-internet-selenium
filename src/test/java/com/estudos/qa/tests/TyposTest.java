package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TyposTest extends BaseTest {

    @Test
    public void testarPresencaDeErrosDeDigitacao() {
        
        // 1. AÇÃO. Navegar para a página de Typos
        driver.findElement(By.linkText("Typos")).click();

        // 2. LOCALIZAR. 
        // Pegamos a lista de parágrafos e focamos no segundo (índice 1).
        List<WebElement> paragrafos = driver.findElements(By.tagName("p"));
        String textoReal = paragrafos.get(1).getText();
        
        System.out.println("Texto capturado nesta rodada: " + textoReal);

        // 3. VALIDAÇÃO (A MUDANÇA TÉCNICA).
        // Em vez de assertEquals, usamos assertTrue com a lógica OU (||).
        // O teste passará se o texto contiver a versão com apóstrofo OU a versão com vírgula.
        boolean textoCorreto = textoReal.contains("won't");
        boolean textoComErro = textoReal.contains("won,t");

        assertTrue(textoCorreto || textoComErro, 
            "ERRO CRÍTICO. O texto mudou completamente! Texto encontrado: " + textoReal);
        
        if(textoComErro) {
            System.out.println("Aviso: O site apresentou o 'typo' (vírgula), mas o teste passou por ser resiliente.");
        } else {
            System.out.println("Sucesso: O texto estava 100% correto desta vez.");
        }
    }
}