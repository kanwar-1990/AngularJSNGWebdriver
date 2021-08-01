package AngulamAppTest_FW_POC.AngulamAppTest_FW_POC;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorPage {
	// references created and By locators created

	WebDriver driver;
	NgWebDriver NgWebDriver;
	JavascriptExecutor jsDriver;

	ByAngularModel first = ByAngular.model("first");
	ByAngularModel operator = ByAngular.model("operator");
	ByAngularModel second = ByAngular.model("second");
	ByAngularButtonText BTN = ByAngular.buttonText("Go!");
	By result = By.tagName("h2");

	// Create Constructor

	public CalculatorPage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		jsDriver = (JavascriptExecutor) driver;
		NgWebDriver = new NgWebDriver(jsDriver);
		driver.get("http://localhost:3456/");
		NgWebDriver.waitForAngularRequestsToFinish();

	}

	/**
	 * Created generic wrapper-- Give two numbers to add and give the operator as
	 * well
	 * 
	 * @param v1
	 * @param v2
	 * @param GiveOperator
	 * @return
	 */
	public String doCalculation(String v1, String v2, String GiveOperator) {
		driver.findElement(first).clear();
		driver.findElement(first).sendKeys(v1);
		
		driver.findElement(second).clear();
		driver.findElement(second).sendKeys(v2);

		driver.findElement(operator).sendKeys(GiveOperator);
		driver.findElement(BTN).click();
		
		NgWebDriver.waitForAngularRequestsToFinish();

		return driver.findElement(result).getText();

	}

}
