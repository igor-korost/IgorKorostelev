package src.test.java.ru.training.at.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}