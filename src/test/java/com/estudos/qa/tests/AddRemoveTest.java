package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class AddRemoveTest extends BaseTest {

    private static final By ADD_REMOVE_LINK = By.linkText("Add/Remove Elements");
    private static final By ADD_ELEMENT_BTN = By.xpath("//button[text()='Add Element']");
    private static final By DELETE_BTN = By.className("added-manually");

    @Test
    @DisplayName("Deve adicionar e remover um elemento na tela com sucesso")
    public void testarAdicionarRemoverElemento() {
        driver.findElement(ADD_REMOVE_LINK).click();
        driver.findElement(ADD_ELEMENT_BTN).click();
        
        WebElement btnDelete = driver.findElement(DELETE_BTN);
        assertTrue(btnDelete.isDisplayed(), "O botão Delete deveria estar visível na tela.");
        
        btnDelete.click();
        
        List<WebElement> listaDeBotoes = driver.findElements(DELETE_BTN);
        assertTrue(listaDeBotoes.isEmpty(), "O botão Delete não foi removido do sistema.");
    }
}
