package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {

	public static WebDriver driver; // webdriver que recebera a instancia do webdriver criado na classe do caso de teste (base)
	
	//definindo o titulo da página para validação
	public String title = "Login - My Store";
	
	public AuthenticationPage(WebDriver driver) {
		//driver local recebendo a instancia do driver instanciado na classe do caso de teste
		this.driver = driver;
		
		//comando utilizado para poder utilizar a metodologia Page Factory
		PageFactory.initElements(driver, this);
	}
		
	//mapeando a caixa de texto criar conta email
	@FindBy(id="email_create")
	private WebElement emailCriarConta;
	
	//mapeando a caixa de texto criar conta email
	@FindBy(id="SubmitCreate")
	private WebElement botaoCriarConta;
	
	//mapeando a caixa de texto de login email
	@FindBy(id="email")
	private WebElement emailLogin;
	
	//mapeando a caixa de texto de senha email
	@FindBy(id="passwd")
	private WebElement senhaLogin;
	
	//mapeando a caixa de texto de senha email
	@FindBy(id="SubmitLogin")
	private WebElement botaoLogin;
	
	//mapeando mensagem de email invalido
	@FindBy(xpath="//li[contains(text(),'Invalid email address.')]")
	private WebElement alertaEmailInvalido;
	
	//mapeando mensagem de email invalido
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")
	private WebElement alertaFalhaNaAutenticacao;
	
	//mapeando mensagem de email invalido
	@FindBy(xpath="//li[contains(text(),'An account using this email address has already be')]")
	private WebElement alertaEmailJaCadastrado;
	//li[contains(text(),'An account using this email address has already be')]
	
	
	
	//Metodo que retorna o elemento caixa de texto da busca
		public WebElement alertaEmailJaCadastrado() {
			return alertaEmailJaCadastrado;
		}
	
	//Metodo que retorna o elemento caixa de texto da busca
	public WebElement alertaFalhaNaAutenticacao() {
		return alertaFalhaNaAutenticacao;
	}
	
	//Metodo que retorna o elemento caixa de texto da busca
	public WebElement alertaEmailInvalido() {
		return alertaEmailInvalido;
	}
	
	//Metodo que retorna o elemento caixa de texto da busca
	public WebElement emailCriarConta() {
		return emailCriarConta;
	}
	
	//Metodo que retorna o elemento caixa de texto da busca
	public WebElement botaoCriarConta() {
		return botaoCriarConta;
	}
	
	//Metodo que retorna o elemento caixa de texto da busca
	public WebElement emailLogin() {
		return emailLogin;
	}
	
	//Metodo que retorna o elemento caixa de texto da busca
	public WebElement senhaLogin() {
		return senhaLogin;
	}
	
	//Metodo que retorna o elemento caixa de texto da busca
	public WebElement botaoLogin() {
		return botaoLogin;
	}
	
	//metodo que retorna o titulo da pagina (para validação)
	public String getTitleAuthenticationPage() {
		return title;
	}
	
}
