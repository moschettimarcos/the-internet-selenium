package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries; // Para capturar logs do sistema
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class JavaScriptErrorTest extends BaseTest {

	@Test
	public void testarCapturaDeErroNoConsole() {

		// 1. AÇÃO. Navegar para a página que contém o erro de JavaScript
        driver.findElement(By.linkText("JavaScript onload event error")).click();

        // 2. LOGICA: Erros de Onload não aparecem na tela como texto comum.
        // Precisamos pedir ao Selenium para ler os logs do tipo "BROWSER"
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> listaDeLogs = logs.getAll();

        System.out.println("Analisando logs do console...");

        // 3. VERIFICAÇÃO: Vamos procurar pela mensagem de erro específica do site.
        // O erro esperado é: "Cannot read properties of undefined (reading 'split')"
        boolean erroEncontrado = false;
        String mensagemEsperada = "Cannot read properties of undefined";

        for (LogEntry entrada : listaDeLogs) {
            if (entrada.getMessage().contains(mensagemEsperada)) {
                erroEncontrado = true;
                System.out.println("ERRO CAPTURADO: " + entrada.getMessage());
                break;
            }
        }

        // 4. VALIDAÇÃO: O teste passa se encontrar o erro que sabíamos que existia.
        assertTrue(erroEncontrado, "ERRO: O erro de JavaScript esperado não foi encontrado na log do console!");

	}
}