package src.test.java.ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SubtractionTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "SubtractionTest")
    public Object[][] subData() {
        return new Object[][]{
                {36.6, 6.6, 30.0}
        };
    }

    @Test(dataProvider = "SubtractionTest", groups = "AddSubtract")
    public void testSub(double a, double b, double result) {
        double sub = calculator.sub(a, b);
        Assert.assertEquals(sub, result, 0.1);
    }
}
