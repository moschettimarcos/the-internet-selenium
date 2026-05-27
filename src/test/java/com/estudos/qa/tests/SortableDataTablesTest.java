package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortableDataTablesTest extends BaseTest {

    @Test
    public void testarOrdenacaoELiteraturaDeTabela() {
        
        // 1. AÇÃO. Navegar para a página de Data Tables
        driver.findElement(By.linkText("Sortable Data Tables")).click();

        // --- EXEMPLO 1: LER DADO ESPECÍFICO ---
        
        // 2. LOGICA DE QA. Localizar o e-mail do 'Bach' na primeira tabela.
        // Usamos um XPath que busca a linha onde o texto é 'Bach' e pega a 3ª coluna (Email).
        String emailBach = driver.findElement(By.xpath("//table[@id='table1']//tr[contains(.,'Bach')]//td[3]")).getText();
        
        assertEquals("fbach@yahoo.com", emailBach, "ERRO. O e-mail do Bach está incorreto!");
        System.out.println("E-mail do Bach validado: " + emailBach);

        // --- EXEMPLO 2: TESTAR ORDENAÇÃO ---

        // 3. AÇÃO. Clicar no cabeçalho 'Last Name' da Tabela 2 para ordenar (A-Z)
        // O HTML da Tabela 2 usa classes específicas, facilitando o CSS Selector.
        driver.findElement(By.cssSelector("#table2 .last-name")).click();

        // 4. VALIDAÇÃO (O PULO DO GATO). 
        // Se a ordem for alfabética (A-Z), o sobrenome 'Bach' deve ser o primeiro da lista agora.
        String primeiroSobrenome = driver.findElement(By.cssSelector("#table2 tbody tr:nth-child(1) .last-name")).getText();
        
        assertEquals("Bach", primeiroSobrenome, "ERRO. A ordenação da tabela falhou!");
        System.out.println("Ordenação validada: 'Bach' é o primeiro da lista.");
    }
}