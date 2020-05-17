package suitetest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.AccountCreationPage;
import pageobjects.AuthenticationPage;
import resources.Base;

public class SignIn_RegisterSuiteTest extends Base{

		//metodo será executado assim sempre antes de um caso de teste iniciar
		@BeforeMethod
		public void iniciaDriver() throws IOException {
			//recebendo driver instanciado pelo metodo da classe pai e atribuindo a variavel local
			driver = inicializaDriver();
			
			//carregando a pagina Your Logo
			driver.get(url);
			
			//maximizando a pagina
			driver.manage().window().maximize();
		}
		
		@Test
		public void validaCadastro() throws InterruptedException {
			//instanciando um objeto do tipo SignInPage para que possamos usar os elementos mapeados na classe com o PageFactory 
				// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
			HomePage hp = new HomePage(driver);
			
			//Caso de teste: Fazer registro com dados válidos
			
			//Clicar no link "Sign in"
			hp.signInButton().click();
			
			//instancia da página de autenticação
			AuthenticationPage ap = new AuthenticationPage(driver);
			
			//Inserir um email válido na caixa de texto "Email Address"
			ap.emailCriarConta().sendKeys(prop.getProperty("email_cadastro"));
			
			//Clicar no botão "Create an account"
			ap.botaoCriarConta().click();
			
			//instancia da página de autenticação
			AccountCreationPage acp = new AccountCreationPage(driver);
			
			//Preencha os campos com valores válidos
			
			acp.pessoalGeneroMr().click();
			acp.pessoalPrimeiroNome().sendKeys("Primeiro Nome");
			acp.pessoalUltimoNome().sendKeys("Ultimo Nome");
			acp.pessoalSenha().sendKeys(prop.getProperty("senha_cadastro"));
			acp.selecionaValorCombo(acp.pessoalDiaNascimento(), "20  ");
			acp.selecionaValorCombo(acp.pessoalMesNascimento(), "August ");
			acp.selecionaValorCombo(acp.pessoalAnoNascimento(), "1985  ");
			acp.pessoalReceberOfertas().click();
			acp.enderecoEmpresa().sendKeys("Empresa 1");
			acp.endereco1().sendKeys("Endereco 1");
			acp.endereco2().sendKeys("Outro endereço");
			acp.enderecoCidade().sendKeys("Cidade 1");
			acp.selecionaValorCombo(acp.enderecoEstado(), "New York");
			acp.enderecoCodigoPostal().sendKeys("00000");
			acp.selecionaValorCombo(acp.enderecoPais(), "United States");
			acp.enderecoTelefoneCasa().sendKeys("00000000");
			acp.enderecoTelefoneCelular().sendKeys("11111111");
			
			acp.enderecoOpcional().clear();
			acp.enderecoOpcional().sendKeys("Outro endereço");
			
			//Clicar no botão "Register"
			acp.botaoRegistrar().click();
			
			//instancia da página de My account
			MyAccountPage map = new MyAccountPage(driver);
			
			//validando se o titulo da página corresponde a página My Account
			if (map.getTitleMyAccountPage().equals(driver.getTitle())) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
			//Fechando o navegador
			//driver.close();
		}
		
		@Test
		public void validaLoginValido() {
			//instanciando um objeto do tipo SignInPage para que possamos usar os elementos mapeados na classe com o PageFactory 
				// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
			HomePage hp = new HomePage(driver);
			
			//Caso de teste: Login com credenciais válidos
			
			//Clicar no link "Sign in"
			hp.signInButton().click();
		
			//instancia da página de autenticação
			AuthenticationPage ap = new AuthenticationPage(driver);			
			
			//Entre com um email válido no campo email do login
			ap.emailLogin().sendKeys(prop.getProperty("email_login"));
			
			//Entre com uma senha válida no campo Password
			ap.senhaLogin().sendKeys(prop.getProperty("senha_login"));
			
			//Clicar no botão "Sign In"
			ap.botaoLogin().click();
			
			//instancia da página de My Account
			MyAccountPage map = new MyAccountPage(driver);
			
			//validando se o titulo da página corresponde a página My Account
			if (map.getTitleMyAccountPage().equals(driver.getTitle())) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
			//Fechando o navegador
			//driver.close();
		}
		
		@Test
		public void validaLoginEmailInvalido() {
			//instanciando um objeto do tipo SignInPage para que possamos usar os elementos mapeados na classe com o PageFactory 
				// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
			HomePage hp = new HomePage(driver);
			
			//Caso de teste: Login com um email inválido
			
			//Clicar no link "Sign in"
			hp.signInButton().click();
			
			//instancia da página de autenticação
			AuthenticationPage ap = new AuthenticationPage(driver);	
			
			//Entre com um email invalido no campo email do login
			ap.emailLogin().sendKeys("emailgenerico1@yourlogo;com");
			
			//Entre com uma senha válida no campo Password
			ap.senhaLogin().sendKeys("123456");
			
			//Clicar no botão "Sign In"
			ap.botaoLogin().click();
			
			//verificar se a mensagem de email invalido está aparecendo na tela
			if (ap.alertaEmailInvalido().isDisplayed()) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
			//Fechando o navegador
			//driver.close();
		}
		
		@Test
		public void validaLoginSenhaIncorreta() {
			//instanciando um objeto do tipo SignInPage para que possamos usar os elementos mapeados na classe com o PageFactory 
				// driver sendo passado para o metodo construtor para ser utilizada a mesma instancia criada nessa classe
			HomePage hp = new HomePage(driver);
			
			//Caso de teste: Login com uma senha incorreta
			
			//Clicar no link "Sign in"
			hp.signInButton().click();
			
			//instancia da página de autenticação
			AuthenticationPage ap = new AuthenticationPage(driver);	
			
			//Entre com um email válido no campo email do login
			ap.emailLogin().sendKeys("emailgenerico@yourlogo.com");
			
			//Entre com uma senha incorreta no campo Password
			ap.senhaLogin().sendKeys("xxxxxxx");
			
			//Clicar no botão "Sign In"
			ap.botaoLogin().click();
			
			//verificar se a mensagem de falha no login está aparecendo na tela
			if (ap.alertaFalhaNaAutenticacao().isDisplayed()) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
			//Fechando o navegador
			//driver.close();
		}
		
		@AfterClass
		public void fecharNavegadores() {
			//fechando os navegadores
			driver.quit();
		}
}
