package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatusCodesTest extends BaseTest {

    @Test
    public void testarMensagensDeStatusHTTP() {
        
        // 1. AÇÃO. Navegar para a página de Status Codes
        driver.findElement(By.linkText("Status Codes")).click();

        // 2. TESTE: Status 200 (Sucesso)
        verificarMensagemDeStatus("200");

        // 3. TESTE: Status 404 (Não Encontrado)
        verificarMensagemDeStatus("404");

        // 4. TESTE: Status 500 (Erro de Servidor)
        verificarMensagemDeStatus("500");
        
        System.out.println("Fluxos de 200, 404 e 500 validados na interface.");
    }

    /**
     * Método auxiliar para evitar repetição de código (DRY - Don't Repeat Yourself)
     */
    private void verificarMensagemDeStatus(String codigo) {
        // Clica no link correspondente ao código
        driver.findElement(By.linkText(codigo)).click();

        // Captura o texto que aparece na página de destino
        String textoPagina = driver.findElement(By.id("content")).getText();

        // VALIDAÇÃO. O texto deve conter a confirmação do código clicado.
        assertTrue(textoPagina.contains("This page returned a " + codigo + " status code"), 
            "ERRO. A mensagem para o status " + codigo + " não foi encontrada!");

        System.out.println("Interface confirmou o recebimento do Status " + codigo);

        // Volta para a listagem para testar o próximo código
        driver.navigate().back();
    }
}