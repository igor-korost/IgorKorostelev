package src.main.java.ru.training.at.hw6;

import org.testng.annotations.DataProvider;
import src.main.java.ru.training.at.hw6.utils.JsonFileReader;

public class DataProviders {

    @DataProvider
    public static Object[][] testData() {
        JsonFileReader jsonFileReader = new JsonFileReader();
        return jsonFileReader.getJsonDataArray();
    }
}

