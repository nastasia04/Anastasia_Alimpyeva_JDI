package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.complex.Menu;
import hw7.pages.HomePage;
import hw7.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;

    @XPath("//ul[contains(@class, 'm-l8')]//li")
    private static Menu header;

    public static HomePage open() {
        homePage.open();
        return homePage;
    }

    public static void clickHeaderMenuItem(String item) {
        // TODO This is completely prohibited to use raw selenium calls in PO methods ! - fixed
        header.select(item);
    }
}
