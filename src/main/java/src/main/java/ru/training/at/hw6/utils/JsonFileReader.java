package src.main.java.ru.training.at.hw6.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.main.java.ru.training.at.hw6.entities.MetalAndColors;

import java.io.File;
import java.io.IOException;
import java.util.Map;


public class JsonFileReader {
    private ObjectMapper objectMapper = new ObjectMapper();
    public Map<String, MetalAndColors> map;

    {
        try {
            map = objectMapper
                    .readValue(new File(
                                    "src/test/resources/JDI_ex8_metalsColorsDataSet.json"),
                            new TypeReference<Map<String, MetalAndColors>>() {
                            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getJsonDataArray() {
        Object[][] arr = new Object[map.size()][1];

        int i = 0;
        for (Map.Entry<String, MetalAndColors> entry : map.entrySet()) {
            arr[i][0] = entry.getValue();
            i++;
        }
        return arr;
    }
}

