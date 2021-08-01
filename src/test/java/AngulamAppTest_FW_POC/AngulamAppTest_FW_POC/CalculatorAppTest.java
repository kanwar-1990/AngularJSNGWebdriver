package AngulamAppTest_FW_POC.AngulamAppTest_FW_POC;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorAppTest {
	CalculatorPage calc;

	@BeforeTest
	public void setup() {
		calc = new CalculatorPage();

	}

	@Test(priority = 1)
	public void CalcAddTest() {
		String result = calc.doCalculation("10", "20", "+");
		Assert.assertEquals(result, "30");
	}

	@Test(priority = 2)
	public void CalcSubTest() {
		String result = calc.doCalculation("50", "30", "-");
		Assert.assertEquals(result, "20");
	}

	@Test(priority = 3)
	public void CalcmultiTest() {
		String result = calc.doCalculation("5", "5", "*");
		Assert.assertEquals(result, "25");
	}

	@Test(priority = 4)
	public void CalcDivTest() {
		String result = calc.doCalculation("10", "2", "/");
		Assert.assertEquals(result, "5");
	}

}
