package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; // Classe para movimentos de mouse
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class HoversTest extends BaseTest {

    @Test
    public void testarPassarMouseSobreImagens() {
        
        // 1. AÇÃO. Navegar para a página de Hovers
        driver.findElement(By.linkText("Hovers")).click();

        // 2. LOCALIZAR. Pegar a lista de todas as figuras (imagens + legendas escondidas)
        List<WebElement> figuras = driver.findElements(By.className("figure"));

        // 3. COMANDO DE QA (O PULO DO GATO).
        // Criamos o objeto 'acao' passando o nosso driver.
        // O moveToElement simula o mouse "parado" sobre o centro do elemento.
        Actions acao = new Actions(driver);

        // Vamos focar na primeira imagem (índice 0)
        WebElement primeiraFigura = figuras.get(0);

        // 4. EXECUTAR. Move o mouse e chama o .perform() para realizar o movimento
        acao.moveToElement(primeiraFigura).perform();
        
        System.out.println("Hover executado sobre a primeira imagem.");

        // 5. LOCALIZAR CONTEÚDO REVELADO.
        // A legenda (h5) só se torna visível (isDisplayed) após o hover.
        WebElement legenda = primeiraFigura.findElement(By.tagName("h5"));

        // 6. VALIDAÇÃO. Verificar se o nome do usuário apareceu e se está correto
        assertTrue(legenda.isDisplayed(), "ERRO. A legenda não ficou visível após o hover!");
        assertTrue(legenda.getText().contains("user1"), "ERRO. O texto da legenda está incorreto!");

        System.out.println("Conteúdo validado com sucesso: " + legenda.getText());
    }
}