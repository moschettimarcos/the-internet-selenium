package com.estudos.qa.tests;

import com.estudos.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class DisappearingElementsTest extends BaseTest {

    @Test
    public void testarElementoQueSumiu() {
        
        // 1. AÇÃO: Entrar na página de Disappearing Elements
        driver.findElement(By.linkText("Disappearing Elements")).click();

        // 2. LÓGICA DE QA (O DESAFIO):
        // Precisamos encontrar o botão "Gallery". Ele pode ou não estar lá.
        // Vamos criar um loop que tenta encontrar o botão até 5 vezes, dando refresh.
        
        boolean encontrou = false;
        int tentativas = 0;

        while (!encontrou && tentativas < 5) {
            // Buscamos todos os itens da lista do menu (tag <li>)
            List<WebElement> itensMenu = driver.findElements(By.cssSelector("ul li"));
            
            System.out.println("Tentativa " + (tentativas + 1) + ": Itens no menu = " + itensMenu.size());

            // No site, quando o 'Gallery' aparece, o menu tem 5 itens. Quando some, tem 4.
            if (itensMenu.size() == 5) {
                encontrou = true;
                System.out.println("Sucesso! O botão 'Gallery' apareceu.");
            } else {
                // COMANDO NOVO: Simular o F5 do navegador
                driver.navigate().refresh();
                tentativas++;
            }
        }

        // 3. VALIDAÇÃO: O teste passa se o botão foi encontrado antes de esgotar as tentativas
        assertTrue(encontrou, "ERRO: O elemento 'Gallery' não apareceu após 5 atualizações.");
    
    }

}