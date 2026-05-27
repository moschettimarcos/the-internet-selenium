package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    private static final By DYNAMIC_CONTROLS_LINK = By.linkText("Dynamic Controls");
    private static final By BTN_REMOVE = By.xpath("//button[text()='Remove']");
    private static final By BTN_ENABLE = By.xpath("//button[text()='Enable']");
    private static final By MENSAGEM = By.id("message");
    private static final By INPUT_TEXTO = By.cssSelector("#input-example input");

    @Test
    @DisplayName("Deve interagir com controles dinâmicos de adição, remoção e input")
    public void testarControlesDinamicos() {
        driver.findElement(DYNAMIC_CONTROLS_LINK).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(BTN_REMOVE).click();
        WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(MENSAGEM));
        assertTrue(mensagem.getText().contains("gone"), "A mensagem de sucesso de remoção não foi exibida.");

        WebElement inputTexto = driver.findElement(INPUT_TEXTO);
        assertFalse(inputTexto.isEnabled(), "O input deveria estar desabilitado no estado inicial.");

        driver.findElement(BTN_ENABLE).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputTexto));

        inputTexto.sendKeys("Agora eu consigo digitar!");
        assertTrue(inputTexto.isEnabled(), "O input não foi habilitado após clicar no botão.");
    }
}