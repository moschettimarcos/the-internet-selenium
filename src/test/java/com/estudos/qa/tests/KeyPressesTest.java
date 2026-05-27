package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys; // O "teclado" do Selenium
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyPressesTest extends BaseTest {

    @Test
    public void testarPressionarTeclasEspeciais() {
        
        // 1. AÇÃO. Navegar para a página de Key Presses
        driver.findElement(By.linkText("Key Presses")).click();

        // 2. LOCALIZAR. O campo de input onde as teclas serão testadas
        WebElement campoInput = driver.findElement(By.id("target"));


         // 3. CENÁRIO 1. Testar a letra A
        campoInput.sendKeys("A");
        validarResultado("A");

        // 4. CENÁRIO 2. Testar a tecla ESCAPE
        campoInput.sendKeys(Keys.ESCAPE);
        validarResultado("ESCAPE");

        // 5. CENÁRIO 3. Testar a tecla SPACE
        campoInput.sendKeys(Keys.SPACE);
        validarResultado("SPACE");

        // 6. CENÁRIO 4. Testar uma letra comum
        campoInput.sendKeys("Q");
        validarResultado("Q");


        System.out.println("Todas as teclas foram validadas com sucesso!");
    }

    // Método auxiliar para não repetir código de validação
    private void validarResultado(String teclaEsperada) {
        String mensagemResultado = driver.findElement(By.id("result")).getText();
        assertTrue(mensagemResultado.contains(teclaEsperada), 
            "ERRO. O sistema não detectou a tecla: " + teclaEsperada);
        System.out.println("Detectado com sucesso: " + mensagemResultado);
    }
}
