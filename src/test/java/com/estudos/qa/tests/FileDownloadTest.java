package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File; // COMANDO NOVO: Para interagir com arquivos do computador

public class FileDownloadTest extends BaseTest {

    @Test
    public void testarDownloadDeArquivo() throws InterruptedException {
        
        // 1. AÇÃO: Navegar para a página de File Download
        driver.findElement(By.linkText("File Download")).click();

        // 2. LOCALIZAR: Escolher um arquivo para baixar (ex: 'test.txt' ou o primeiro da lista)
        WebElement linkArquivo = driver.findElement(By.linkText("some-file.txt"));
        String nomeArquivo = linkArquivo.getText();
        
        // 3. AÇÃO: Clicar para baixar
        linkArquivo.click();

        // 4. DICA DE QA (A ESPERA): 
        // O download não é instantâneo. Precisamos esperar alguns segundos para o arquivo "pousar" na pasta.
        // Usamos um sleep curto aqui apenas porque downloads dependem da velocidade da internet/OS.
        Thread.sleep(3000); 

        // 5. LÓGICA DE VERIFICAÇÃO:
        // Definimos o caminho da pasta de downloads do usuário
        String homeUsuario = System.getProperty("user.home");
        String caminhoDownload = homeUsuario + File.separator + "Downloads" + File.separator + nomeArquivo;
        
        File arquivoBaixado = new File(caminhoDownload);

        // 6. VALIDAÇÃO: O arquivo existe na pasta e tem conteúdo?
        assertTrue(arquivoBaixado.exists(), "ERRO: O arquivo " + nomeArquivo + " não foi encontrado na pasta Downloads!");
        assertTrue(arquivoBaixado.length() > 0, "ERRO: O arquivo está vazio!");

        System.out.println("Download verificado com sucesso em: " + caminhoDownload);

        // 7. BOA PRÁTICA: Deletar o arquivo após o teste para não lotar sua pasta
        if (arquivoBaixado.exists()) {
            arquivoBaixado.delete();
            System.out.println("Arquivo de teste removido para limpeza.");
        }
    }
}