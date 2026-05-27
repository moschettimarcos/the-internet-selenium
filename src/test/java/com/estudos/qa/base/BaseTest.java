package com.estudos.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.BeforeEach; // Comando que roda ANTES de cada teste
import org.junit.jupiter.api.AfterEach;  // Comando que roda DEPOIS de cada teste
import java.time.Duration;

public class BaseTest {

    // O modificador 'protected' permite que as classes de teste enxerguem o driver
    protected WebDriver driver;


    // @BeforeEach indica que esse codigo vai rodar antes dos @Test
    @BeforeEach
    public void setup() {

        // --- CONFIGURAÇÃO: Sempre inicia aqui ---
        WebDriverManager.chromedriver().setup(); // Selecionando o driver do Google Chrome
        driver = new ChromeDriver();
        
        // Espera implícita: aguarda até 5 segundos antes de dar erro se não achar um elemento
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Abre o site principal
        driver.get("https://the-internet.herokuapp.com/");
        // driver.manage().window().maximize(); // Abre o navegador em tela cheia
    }

    @AfterEach
    public void tearDown() {
        // --- FINALIZAÇÃO: Sempre encerra aqui após executar os @Test---
        if (driver != null) {
            driver.quit();
        }
    }
}
