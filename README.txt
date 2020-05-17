Selenium Page Object Pattern - YourLogo website

Pré considerações: 

Os testes escolhidos na página sugerida foram montados pensando em demosntrar técnicas de automação. Seria possível pensar em diversos outros casos de teste, porém eu preferi dar prioridade a casos de testes que me forcessem usar diferentes métodos e técnicas de automação.
Dentro da pasta do projeto existe uma pasta chamada "documentacao", onde eu montei um pequeno plano de testes e um arquivo excel com o design dos casos de testes realizados.
Um dos requisitos foi que os scripts deveriam ser executados tanto na versão padrão do Chrome como na versão “Headless”, para executar os mesmos scripts na versão Headless é necessário editar o arquivos data.properties que se encontra no sequinte diretoriro YourLogo/src/main/java/resources/data.properties, o valor de browser deve ser setado para "Chrome(HeadLess)" e para executar na sua versão normal o valor deve estar como "Chrome".
Além disso o arquivo data.properties define os emails e senhas utilizados no teste de cadastro e de login no sistema. Sendo possível setar esses dados antes de iniciar os testes.

Descrição:

Exemplo de análise e impolementação de casos de testes em Page Object Pattern, implementação baseada na pagina http://automationpractice.com/index.php webpage.

Os testes foram implementados e executados em:

    Sistema Operacional: Windows 10 - 64 bits
    Browsers: Chrome Versão 81.0.4044.138 (64-bit)
    Selenium WebDriver: 3.141.59
    Java: 8

Para rodar os testes:

1. Clone/Download o projeto: https://github.com/fabriciob/YourLogo.git

2. Instale o Maven seguindo os passos em: https://maven.apache.org/install.html

3. Abra o prompt de comando e navegue até a pasta raiz do projeto (YourLogo/)

4. Execute o comando "mvn test"
