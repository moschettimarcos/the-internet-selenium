package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExitIntentTest extends BaseTest {

    @Test
    public void testarDisparoAoSairDaPagina() {

        // 1. Navegar para Exit Intent
        driver.findElement(By.linkText("Exit Intent")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // 2. DISPARO REAL DO EXIT INTENT (via JS)
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "document.dispatchEvent(new MouseEvent('mouseleave', {" +
            "clientY: 0," +
            "bubbles: true" +
            "}));"
        );

        System.out.println("Evento de exit intent disparado via JavaScript.");

        // 3. Esperar o modal aparecer
        WebElement modal = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("ouibounce-modal"))
        );

        // 4. Validação
        assertTrue(modal.isDisplayed(), "ERRO: Modal de Exit Intent não apareceu.");

        // 5. Fechar o modal
        driver.findElement(By.cssSelector(".modal-footer p")).click();

        System.out.println("Teste finalizado com sucesso.");
    }
}
