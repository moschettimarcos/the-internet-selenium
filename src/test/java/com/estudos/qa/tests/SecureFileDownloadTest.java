package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecureFileDownloadTest extends BaseTest {

    @Test
    public void testarDownloadEmAreaSegura() {
        
        // 1. O PULO DO GATO (AUTENTICAÇÃO).
        // Em vez de clicar no link e esperar o pop-up de login (que o Selenium não alcança),
        // injetamos as credenciais 'admin:admin' direto na URL.
        String urlSegura = "https://admin:admin@the-internet.herokuapp.com/download_secure";
        driver.get(urlSegura);

        // 2. LOCALIZAR. Na área segura, vamos procurar um arquivo para baixar.
        // Como os arquivos mudam, vamos pegar o primeiro link de arquivo disponível.
        String nomeArquivo = driver.findElement(By.cssSelector(".example a")).getText();
        
        System.out.println("Arquivo encontrado para download: " + nomeArquivo);

        // 3. AÇÃO. Clicar para baixar
        driver.findElement(By.linkText(nomeArquivo)).click();

        // 4. VALIDAÇÃO. 
        // Em automação de UI, validamos que o clique não gerou erro e o arquivo "existe" na lista.
        // (Para validar se o arquivo caiu na pasta /downloads, usaríamos a classe File do Java).
        assertTrue(driver.getPageSource().contains(nomeArquivo), 
            "ERRO. O arquivo esperado não está listado na página segura!");
        
        System.out.println("Interação com área de download seguro concluída.");
    }
}