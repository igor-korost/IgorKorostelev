package src.main.java.ru.training.at.hw6.site.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import src.main.java.ru.training.at.hw6.entities.MetalAndColors;

import java.util.ArrayList;

public class MetalAndColorsForm extends Form<MetalAndColors> {

    // summary RadioButtons
    @UI("[name=custom_radio_odd]")
    public static RadioButtons odds;
    @UI("[name=custom_radio_even]")
    public static RadioButtons even;

    // elements CheckList
    @UI("#elements-checklist input[type=checkbox]")
    public Checklist elements;

    // colors Dropdown
    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
            list = "li", expand = ".caret")
    public static DropdownExpand colors;

    // metals Dropdown
    @JDropdown(root = "div[ui=combobox]", value = "input",
            list = "li", expand = ".caret")
    public static Dropdown metals;

    // vegetables Dropdown
    @JDropdown(root = "div[ui=droplist]", value = ".filter-option",
            list = "li", expand = ".caret")
    public static Dropdown vegetables;

    // submit Button
    @ByText("Submit")
    public static Button submit;


    private void selectSummary(ArrayList<String> list) {
        odds.select(list.get(0));
        even.select(list.get(1));
    }

    private void selectElements(ArrayList<String> list) {
        for (String s : list) {
            elements.select(s);
        }
    }

    private void selectVegetables(ArrayList<String> list) {
        vegetables.select("Vegetables"); // unselect default value
        for (String s : list) {
            vegetables.select(s);
        }
    }

    @Override
    public void submit(MetalAndColors entity) {
        selectSummary(entity.summary);
        selectElements(entity.elements);
        colors.select(entity.color);
        metals.select(entity.metals);
        selectVegetables(entity.vegetables);
        submit.click();
    }
}
