package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	public static WebDriver driver; // webdriver que recebera a instancia do webdriver criado na classe do caso de teste (base)
	
	//definindo o titulo da página para validação
	public String title = "My account - My Store";

	public MyAccountPage(WebDriver driver) {
		//driver local recebendo a instancia do driver instanciado na classe do caso de teste
		this.driver = driver;
		
		//comando utilizado para poder utilizar a metodologia Page Factory
		PageFactory.initElements(driver, this);
	}
	
	//metodo que retorna o titulo da pagina (para validação)
	public String getTitleMyAccountPage() {
		return title;
	}
	
}
