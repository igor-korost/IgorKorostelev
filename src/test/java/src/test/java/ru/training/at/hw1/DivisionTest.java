package src.test.java.ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DivisionTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "DivisionTest")
    public Object[][] divData() {
        return new Object[][]{
                {120.2, 2.0, 60.1}
        };
    }

    @Test(dataProvider = "DivisionTest", groups = "MultiplyDivide")
    public void testDiv(double a, double b, double result) {
        double div = calculator.div(a, b);
        Assert.assertEquals(div, result, 0.1);
    }
}
