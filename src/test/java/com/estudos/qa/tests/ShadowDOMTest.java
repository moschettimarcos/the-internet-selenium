package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShadowDOMTest extends BaseTest {

    private static final String URL_SHADOW_DOM = "https://the-internet.herokuapp.com/shadowdom";
    private static final By SHADOW_HOST = By.cssSelector("my-paragraph");
    private static final By PARAGRAFO_INTERNO = By.cssSelector("p");

    @Test
    @DisplayName("Deve extrair e validar o texto contido dentro de um Shadow DOM")
    public void testarInteracaoComShadowDOM() {
        driver.get(URL_SHADOW_DOM);

        SearchContext shadowRoot = driver.findElement(SHADOW_HOST).getShadowRoot();
        WebElement elementoInterno = shadowRoot.findElement(PARAGRAFO_INTERNO);
        String textoCapturado = elementoInterno.getText();

        assertTrue(textoCapturado.contains("Let's have some different text!"), 
            "Não foi possível validar o texto projetado dentro do Shadow DOM.");
    }
}