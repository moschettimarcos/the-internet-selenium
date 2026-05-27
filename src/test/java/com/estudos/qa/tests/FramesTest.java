package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramesTest extends BaseTest {

    @Test
    public void testarInteracaoComIFrame() {

        // 1. NAVEGAÇÃO
        driver.findElement(By.linkText("Frames")).click();
        driver.findElement(By.linkText("iFrame")).click();

        // 2. FECHA O ALERTA DO TINYMCE (USANDO SUA LÓGICA DE JS)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Aguarda o botão de fechar (X) estar presente no código
            WebElement closeButton = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("button.tox-notification__dismiss")
                    )
            );

            // Usa JavaScript para clicar (evita erros de "elemento interceptado")
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", closeButton);
            System.out.println("Aviso do TinyMCE fechado via JavaScript.");
        } catch (Exception e) {
            System.out.println("Aviso não apareceu ou já estava fechado.");
        }

        // 3. MUDANÇA DE FOCO: Entra no iframe do editor
        // O Selenium agora 'mergulha' no documento interno
        driver.switchTo().frame("mce_0_ifr");

        // 4. LOCALIZAR E VALIDAR: Apenas ler o texto existente
        // O corpo do editor tem o ID 'tinymce'
        WebElement corpoEditor = driver.findElement(By.id("tinymce"));
        String textoEncontrado = corpoEditor.getText();

        // Validação Junit: Verifica se o texto é exatamente o esperado
        assertEquals("Your content goes here.", textoEncontrado, 
            "ERRO: O texto padrão do editor não foi encontrado!");

        System.out.println("Texto validado com sucesso: " + textoEncontrado);

        // 5. VOLTAR AO NORMAL: Sai do iframe e volta para o documento principal
        driver.switchTo().defaultContent();
    }
}