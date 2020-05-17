package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static WebDriver driver; // webdriver que recebera a instancia do webdriver criado na classe do caso de teste (base)
	
	//definindo o titulo da página para validação
	public String title = "My Store";
	
	
	public HomePage(WebDriver driver) {
		//driver local recebendo a instancia do driver instanciado na classe do caso de teste
		this.driver = driver;
		
		//comando utilizado para poder utilizar a metodologia Page Factory
		PageFactory.initElements(driver, this);
	}
	
	
	
	//mapeando a caixa de texto search
	@FindBy(id="search_query_top")
	private WebElement searchBox;
	
	//mapeando o botão search
	@FindBy(xpath="//button[@name='submit_search']")
	private WebElement searchButton;	
	
	//mapeando o link de Sign In
	@FindBy(css="a[class='login']")
	private WebElement signInButton;
	
	//mapeando o menu dresses
	@FindBy(xpath="//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
	private WebElement menuDresses;
	
	//mapeando o menu summer dresses
	@FindBy(xpath="//li[@class='sfHover']//ul[@class='submenu-container clearfix first-in-line-xs']//li//a[contains(text(),'Summer Dresses')]")
	private WebElement menuSummerDresses;
	
	//li[@class='sfHover']//ul[@class='submenu-container clearfix first-in-line-xs']//li//a[contains(text(),'Summer Dresses')]
	
	//Metodo que retorna o elemento caixa de texto da busca
	public WebElement searchBox() {
		return searchBox;
	}
	
	//Metodo que retorna o menu dresses
	public WebElement menuDresses() {
		return menuDresses;
	}
	
	//Metodo que retorna o menu summer dresses
	public WebElement menuSummerDresses() {
		return menuSummerDresses;
	}
	
	//Metodo que retorna o elemento botão de busca
	public WebElement searchButton() {
		return searchButton;
	}
	
	//Metodo que retorna o elemento caixa de texto da busca
	public WebElement signInButton() {
		return signInButton;
	}
	
	//metodo que retorna o titulo da pagina (para validação)
	public String getTitleHomePage() {
		return title;
	}
	
}
