package src.main.java.ru.training.at.hw6.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import src.main.java.ru.training.at.hw6.site.sections.MetalAndColorsForm;
import src.main.java.ru.training.at.hw6.site.sections.ResultSection;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalAndColorsPage extends WebPage {

    @UI(".form")
    public MetalAndColorsForm metalAndColorsForm;

    @UI(".results")
    public ResultSection resultSection;

}

