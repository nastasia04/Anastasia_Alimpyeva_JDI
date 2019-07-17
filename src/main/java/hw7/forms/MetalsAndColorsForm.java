package hw7.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw7.entities.MetalsAndColors;

public class MetalsAndColorsForm {
    @XPath("//p[contains(.//label, '%s')]")
    private RadioButtons summary;

    @XPath("//p[@class='checkbox'][contains(., '%s')]//label")
    private UIElement elements;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist metals;

    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist vegetables;

    public void fill(MetalsAndColors data) {
        data.getSummary().forEach(number -> summary.select(String.valueOf(number)));
        data.getElements().forEach(element -> elements.select(element));
        colors.select(data.getColor());
        metals.select(data.getMetals());
        emptyVegetablesForm();
        data.getVegetables().forEach(vegetable -> vegetables.select(vegetable));
    }

    private void emptyVegetablesForm() {
        vegetables.select("Vegetables");
    }
}
