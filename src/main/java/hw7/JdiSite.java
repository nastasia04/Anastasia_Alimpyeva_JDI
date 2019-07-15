package hw7;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import hw7.pages.HomePage;
import hw7.pages.MetalsAndColorsPage;
import org.openqa.selenium.By;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;

    @XPath("//header")
    private static UIElement header;

    public static HomePage open() {
        homePage.open();
        return homePage;
    }

    public static void clickHeaderMenuItem(String item) {
        header.find(By.xpath("//a[contains(.,'" + item + "')]")).click();
    }
}
