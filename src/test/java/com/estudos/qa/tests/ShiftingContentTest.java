package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShiftingContentTest extends BaseTest {

    @Test
    public void testarConteudoQueDesloca() {
        
        // 1. AÇÃO. Navegar para a página de Shifting Content
        driver.findElement(By.linkText("Shifting Content")).click();

        // 2. ESCOLHA. Entrar no primeiro exemplo (Menu Element)
        driver.findElement(By.linkText("Example 1: Menu Element")).click();

        // 3. LOCALIZAR. O elemento "Home" que se desloca lateralmente a cada refresh.
        // O "pulo do gato": Usamos LinkText porque ele ignora a posição visual (X, Y) 
        // e foca no atributo do elemento.
        WebElement menuHome = driver.findElement(By.linkText("Home"));

        // 4. VALIDAÇÃO VISUAL. Confirmar que o elemento está renderizado.
        assertTrue(menuHome.isDisplayed(), "ERRO. O elemento 'Home' não está visível na tela!");
        
        // 5. AÇÃO. Clicar no elemento. 
        // O Selenium recalcula a posição do elemento exatamente antes de disparar o clique.
        menuHome.click();

        // 6. VALIDAÇÃO (CORREÇÃO DO ERRO ANTERIOR).
        // Clicar em Home nos leva para a raiz do site. 
        // Vamos validar se a URL é a Home ou se o título principal apareceu.
        String urlAtual = driver.getCurrentUrl();
        boolean naHome = urlAtual.equals("https://the-internet.herokuapp.com/") || urlAtual.endsWith(".com/");
        
        assertTrue(naHome, "ERRO. O clique no menu Home não levou para a página inicial! URL: " + urlAtual);
        
        System.out.println("Sucesso! O Selenium rastreou e clicou no menu mesmo com o deslocamento de pixels.");
    }
}