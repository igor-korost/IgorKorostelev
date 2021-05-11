package src.test.java.ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class MultiplicationTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "MultiplicationTest")
    public Object[][] multData() {
        return new Object[][]{
                {15.5, 2.0, 31.0}
        };
    }

    @Test(dataProvider = "MultiplicationTest", groups = "MultiplyDivide")
    public void testMul(double a, double b, double result) {
        double mult = calculator.mult(a, b);
        Assert.assertEquals(mult, result, 0.1);
    }
}
