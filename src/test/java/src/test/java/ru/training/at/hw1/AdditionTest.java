package src.test.java.ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AdditionTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "AdditionTest")
    public Object[][] sumData() {
        return new Object[][]{
                {6.5, 5.5, 12.0}
        };
    }

    @Test(dataProvider = "AdditionTest", groups = "AddSubtract")
    public void testSum(double a, double b, double result) {
        double sum = calculator.sum(a, b);
        Assert.assertEquals(sum, result, 0.1);
    }
}
