# 🚀 Automação de Testes E2E com Selenium WebDriver

Este repositório contém um projeto de automação de testes End-to-End (E2E) desenvolvido em **Java**, utilizando o **Selenium WebDriver** e o framework de testes **JUnit 5**.

O objetivo deste projeto é demonstrar a resolução de desafios técnicos avançados em testes de UI (User Interface), interagindo com o site de práticas [The Internet Herokuapp](https://the-internet.herokuapp.com/).

## 🛠️ Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal.
- **Selenium WebDriver 4**: Ferramenta para interação e automação de navegadores web.
- **JUnit 5 (Jupiter)**: Framework utilizado para construção das asserções e orquestração dos testes.
- **Maven**: Gerenciador de dependências e build do projeto.

## ⚙️ Cenários de Teste Cobertos

Este projeto engloba diversos desafios e componentes não-triviais de automação Web, incluindo:

- **Ações Complexas de Mouse:** Menus de contexto (botão direito) e interações via classe `Actions`.
- **Autenticação:** Bypass em HTTP Basic Auth via injeção de credenciais na URL.
- **Componentes Dinâmicos:** Manipulação de elementos com IDs que mudam a cada requisição (Challenging DOM).
- **Controles Dinâmicos e Esperas:** Utilização de `WebDriverWait` (Waits explícitos) para aguardar o carregamento de AJAX, botões sendo habilitados e elementos surgindo no DOM.
- **iFrames e Nested Frames:** Mudança de contexto do driver (`switchTo()`) para navegar entre frames aninhados.
- **Scroll e JavaScript:** Execução de scripts via `JavascriptExecutor` para testar "Infinite Scroll" e elementos flutuantes.
- **Shadow DOM:** Abertura e inspeção de shadow roots diretamente com os novos recursos do Selenium 4.
- **Upload e Download de Arquivos:** Criação dinâmica de arquivos temporários para upload isolado e validação em disco local para downloads simulados.

## 📁 Estrutura do Projeto

O projeto segue a estrutura padrão do Maven e aplica boas práticas de código como extração de seletores (Locators) em constantes:

```text
src/
 ├── main/java/com/estudos/qa/
 │    └── base/
 │         └── BaseTest.java          # Configuração de Setup e Teardown do WebDriver
 │
 └── test/java/com/estudos/qa/tests/  # Classes de testes E2E divididas por funcionalidade
      ├── AddRemoveTest.java
      ├── ContextMenuTest.java
      ├── DynamicControlsTest.java
      ├── FileUploadTest.java
      ├── ShadowDOMTest.java
      └── ...
```

## 🚀 Como Executar o Projeto

### Pré-requisitos

- Ter o **Java Development Kit (JDK) 21** ou superior instalado e configurado nas variáveis de ambiente.
- Ter o **Apache Maven** instalado.
- Ter o navegador **Google Chrome** instalado (o Selenium Manager cuidará automaticamente do download do ChromeDriver).

### Passos para execução

1. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git
   ```
2. Acesse a pasta raiz do projeto via terminal:
   ```bash
   cd NOME_DO_REPOSITORIO
   ```
3. Execute o comando do Maven para baixar as dependências e rodar os testes:
   ```bash
   mvn clean test
   ```
