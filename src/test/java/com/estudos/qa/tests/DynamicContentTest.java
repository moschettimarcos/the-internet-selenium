package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;

public class DynamicContentTest extends BaseTest {

    @Test
    public void testarConteudoDinamico() {
        
        // 1. AÇÃO: Navegar para a página de Dynamic Content
        driver.findElement(By.linkText("Dynamic Content")).click();

        // 2. CAPTURAR: Pegar o texto do conteúdo antes do refresh
        // Usamos a classe 'large-10' que contém as colunas de texto no site
        List<WebElement> textosIniciais = driver.findElements(By.className("large-10"));
        String textoOriginal = textosIniciais.get(0).getText();
        
        System.out.println("Texto antes do refresh: " + textoOriginal.substring(0, 30) + "...");

        // 3. AÇÃO: Atualizar a página para forçar a mudança do conteúdo
        driver.navigate().refresh();

        // 4. CAPTURAR: Pegar o texto novamente após o refresh
        List<WebElement> textosNovos = driver.findElements(By.className("large-10"));
        String textoAposRefresh = textosNovos.get(0).getText();

        System.out.println("Texto após o refresh: " + textoAposRefresh.substring(0, 30) + "...");

        // 5. VALIDAÇÃO: O texto novo deve ser DIFERENTE do original
        // assertNotEquals garante que a dinâmica do site está funcionando
        assertNotEquals(textoOriginal, textoAposRefresh, "ERRO: O conteúdo não mudou após o refresh!");
        
        System.out.println("Teste concluído: O conteúdo mudou conforme o esperado.");
    }
}