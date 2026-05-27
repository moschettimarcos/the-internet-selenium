package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;

public class EntryAdTest extends BaseTest {

    private static final By ENTRY_AD_LINK = By.linkText("Entry Ad");
    private static final By MODAL = By.id("modal");
    private static final By BOTAO_FECHAR = By.cssSelector(".modal-footer p");

    @Test
    @DisplayName("Deve exibir e fechar o modal de anúncio com sucesso")
    public void testarFecharAnuncio() {
        driver.findElement(ENTRY_AD_LINK).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement janelaModal = wait.until(ExpectedConditions.visibilityOfElementLocated(MODAL));

        driver.findElement(BOTAO_FECHAR).click();

        boolean modalSumiu = wait.until(ExpectedConditions.invisibilityOf(janelaModal));
        assertTrue(modalSumiu, "O anúncio modal ainda está visível na tela.");
    }
}
