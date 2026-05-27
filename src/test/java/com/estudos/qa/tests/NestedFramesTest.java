package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedFramesTest extends BaseTest {

    private static final By NESTED_FRAMES_LINK = By.linkText("Nested Frames");
    private static final By CONTENT = By.id("content");
    private static final By BODY = By.tagName("body");

    @Test
    @DisplayName("Deve navegar corretamente entre frames aninhados e validar seus textos")
    public void testarNavegacaoEmFramesAninhados() {
        driver.findElement(NESTED_FRAMES_LINK).click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        String textoMeio = driver.findElement(CONTENT).getText();
        assertEquals("MIDDLE", textoMeio, "O texto do frame do meio está incorreto.");

        driver.switchTo().defaultContent(); 
        driver.switchTo().frame("frame-bottom");
        
        String textoBaixo = driver.findElement(BODY).getText();
        assertEquals("BOTTOM", textoBaixo, "O texto do frame inferior está incorreto.");
        
        driver.switchTo().defaultContent();
    }
}