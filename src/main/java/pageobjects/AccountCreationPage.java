package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {

	public static WebDriver driver; // webdriver que recebera a instancia do webdriver criado na classe do caso de teste (base)
	
	//definindo o titulo da página para validação
	public String title = "My Store";

	public AccountCreationPage(WebDriver driver) {
		//driver local recebendo a instancia do driver instanciado na classe do caso de teste
		this.driver = driver;
		
		//comando utilizado para poder utilizar a metodologia Page Factory
		PageFactory.initElements(driver, this);
	}
	
	//INFORMAÇÕES PESSOAIS
	
	//mapeando radio button Mr
	@FindBy(id="id_gender1")
	private WebElement pessoalGeneroMr;
	
	//mapeando radio button Mrs
	@FindBy(id="id_gender2")
	private WebElement pessoalGeneroMrs;
	
	//mapeando a caixa de texto primeiro nome
	@FindBy(id="customer_firstname")
	private WebElement pessoalPrimeiroNome;
	
	//mapeando a caixa de texto ultimo nome
	@FindBy(id="customer_lastname")
	private WebElement pessoalUltimoNome;

	//mapeando a caixa de texto email
	@FindBy(id="email")
	private WebElement pessoalEmailPrincipal;
	
	//mapeando a caixa de texto da senha
	@FindBy(id="passwd")
	private WebElement pessoalSenha;
	
	//mapeando a combobox dia de nascimento
	@FindBy(id="days")
	private WebElement pessoalDiaNascimento;
	
	//mapeando a combobox dia de nascimento
	@FindBy(id="months")
	private WebElement pessoalMesNascimento;
	
	//mapeando a combobox dia de nascimento
	@FindBy(id="years")
	private WebElement pessoalAnoNascimento;
	
	//mapeando a checkbox para receber ofertas especiais
	@FindBy(id="optin")
	private WebElement pessoalReceberOfertas;
	
	//----------------------------------------------------------
	
	//ENDEREÇO
	
	//mapeando primeiro nome da seção endereço
	@FindBy(id="firstname")
	private WebElement enderecoPrimeiroNome;
	
	//mapeando ultimo nome da seção endereço
	@FindBy(id="lastname")
	private WebElement enderecoUltimoNome;
	
	//mapeando empresa da seção endereço
	@FindBy(id="company")
	private WebElement enderecoEmpresa;
	
	//mapeando endereço 1 da seção endereço
	@FindBy(id="address1")
	private WebElement endereco1;
	
	//mapeando endereço 2 da seção endereço
	@FindBy(id="address2")
	private WebElement endereco2;
	
	//mapeando cidade da seção endereço
	@FindBy(id="city")
	private WebElement enderecoCidade;
	
	//mapeando estado da seção endereço
	@FindBy(id="id_state")
	private WebElement enderecoEstado;
	
	//mapeando estado da seção endereço
	@FindBy(id="postcode")
	private WebElement enderecoCodigoPostal;
	
	//mapeando pais da seção endereço
	@FindBy(id="id_country")
	private WebElement enderecoPais;
	
	//mapeando info adicional da seção endereço
	@FindBy(id="phone")
	private WebElement enderecoTelefoneCasa;
	
	//mapeando info adicional da seção endereço
	@FindBy(id="phone_mobile")
	private WebElement enderecoTelefoneCelular;
	
	//mapeando info adicional da seção endereço
	@FindBy(id="alias")
	private WebElement enderecoOpcional;
	
	//mapeando info adicional da seção endereço
	@FindBy(id="submitAccount")
	private WebElement botaoRegistrar;
	
	
	
	
	//INFORMAÇÕES PESSOAIS
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalGeneroMr() {
		return pessoalGeneroMr;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalGeneroMrs() {
		return pessoalGeneroMrs;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalPrimeiroNome() {
		return pessoalPrimeiroNome;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalUltimoNome() {
		return pessoalUltimoNome;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalEmailPrincipal() {
		return pessoalEmailPrincipal;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalSenha() {
		return pessoalSenha;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalDiaNascimento() {
		return pessoalDiaNascimento;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalMesNascimento() {
		return pessoalMesNascimento;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalAnoNascimento() {
		return pessoalAnoNascimento;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement pessoalReceberOfertas() {
		return pessoalReceberOfertas;
	}
	
	//----------------------------------------------------------
	
	//ENDEREÇO
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoPrimeiroNome() {
		return enderecoPrimeiroNome;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoUltimoNome() {
		return enderecoUltimoNome;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoEmpresa() {
		return enderecoEmpresa;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement endereco1() {
		return endereco1;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement endereco2() {
		return endereco2;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoCidade() {
		return enderecoCidade;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoEstado() {
		return enderecoEstado;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoCodigoPostal() {
		return enderecoCodigoPostal;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoPais() {
		return enderecoPais;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoTelefoneCasa() {
		return enderecoTelefoneCasa;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoTelefoneCelular() {
		return enderecoTelefoneCelular;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement enderecoOpcional() {
		return enderecoOpcional;
	}
	
	//Metodo que retorna o radio button Mr
	public WebElement botaoRegistrar() {
		return botaoRegistrar;
	}
	
	//metodo que retorna o titulo da pagina (para validação)
	public String getTitleAccountCreationPage() {
		return title;
	}
	
	public void selecionaValorCombo(WebElement combo, String valor) {
		
		Select s = new Select(combo);
		
		s.selectByVisibleText(valor);
		
	}
	
}
