package src.main.java.ru.training.at.hw6.site.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import src.main.java.ru.training.at.hw6.entities.MetalAndColors;

import java.util.ArrayList;
import java.util.List;

public class ResultSection {

    @UI(".results > li")
    public static List<WebElement> results;

    public List<String> getResults() {
        List<String> list = new ArrayList<>();

        for (WebElement web : results) {
            list.add(web.getText());
        }
        return list;
    }

    public List<String> getListFromEntity(MetalAndColors entity) {
        List<String> list = new ArrayList<>();

        int sum = Integer.parseInt(entity.summary.get(0))
                + Integer.parseInt(entity.summary.get(1));
        list.add("Summary: " + sum);
        String elements = String.join(", ", entity.elements);
        list.add("Elements: " + elements);
        list.add("Color: " + entity.color);
        list.add("Metal: " + entity.metals);
        String vegetables = String.join(", ", entity.vegetables);
        list.add("Vegetables: " + vegetables);

        return list;
    }
}
