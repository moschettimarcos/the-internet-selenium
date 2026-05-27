package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest; // Importa a configuração (ignição do navegador)
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

// O 'extends BaseTest' garante que o navegador abra na home do site antes de começar

public class CheckboxesTest extends BaseTest {

    @Test
    public void testarMarcacaoDeCheckboxes() {
        
        // 1. AÇÃO: Entrar na página de Checkboxes
        driver.findElement(By.linkText("Checkboxes")).click();

        // 2. LOCALIZAR: Encontrar todos os inputs de checkbox da página
        // Dica de QA: Como existem dois elementos iguais, usamos findElements para criar uma lista
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input"));
        
        // Pegamos o primeiro checkbox (índice 0) e o segundo (índice 1)
        WebElement checkbox1 = checkboxes.get(0);
        WebElement checkbox2 = checkboxes.get(1);

        // 3. COMANDO NOVO: .isSelected()
        // Este comando retorna 'true' se a caixa estiver marcada e 'false' se estiver desmarcada.
        // O checkbox 1 começa desmarcado por padrão no site.
        boolean estaSelecionado = checkbox1.isSelected();
        System.out.println("O checkbox 1 está marcado inicialmente? " + estaSelecionado);

        // 4. AÇÃO: Marcar o checkbox 1
        // Dica de QA: Só clicamos se ele não estiver marcado (usando a negação '!')
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        // 5. VALIDAÇÃO: Verificar se ele foi marcado com sucesso
        assertTrue(checkbox1.isSelected(), "ERRO: O checkbox 1 deveria estar marcado!");

        // 6. AÇÃO: Desmarcar o checkbox 2 (que já vem marcado por padrão)
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }

        // 7. VALIDAÇÃO: Verificar se ele foi desmarcado
        // Usamos o '!' para validar que o isSelected agora é FALSO
        assertTrue(!checkbox2.isSelected(), "ERRO: O checkbox 2 deveria estar desmarcado!");
        
        System.out.println("Teste de Checkboxes finalizado com sucesso.");
    }
}
