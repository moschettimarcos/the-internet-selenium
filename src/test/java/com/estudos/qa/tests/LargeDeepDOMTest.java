package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargeDeepDOMTest extends BaseTest {

    @Test
    public void testarLocalizacaoEmDOMComplexo() {
        
        // 1. AÇÃO. Navegar para a página de Large & Deep DOM
        driver.findElement(By.linkText("Large & Deep DOM")).click();

        // 2. DESAFIO 1: O "Deep" (Profundo)
        // O ID 'sibling-50.3' existe e funciona (conforme seu log de sucesso).
        WebElement elementoProfundo = driver.findElement(By.id("sibling-50.3"));
        assertEquals("50.3", elementoProfundo.getText());
        System.out.println("Elemento profundo (camada 50) validado.");

        // 3. DESAFIO 2: O "Large" (Tabela) - O AJUSTE ESTÁ AQUI
        // Mudamos de '#' (ID) para '.' (Classe) para bater com o HTML do site.
        // Seletor: ".row-27 .column-32" (A célula da coluna 32 dentro da linha 27)
        WebElement celulaTabela = driver.findElement(By.cssSelector(".row-27 .column-32"));

        String textoReal = celulaTabela.getText().trim();

        // 4. VALIDAÇÃO.
        assertEquals("27.32", textoReal, 
            "ERRO. O conteúdo da célula na posição 27x32 está incorreto!");
        
        System.out.println("Célula na tabela gigante (" + textoReal + ") validada com sucesso.");
    }
}