package hw7;

import com.epam.jdi.light.driver.get.DriverData;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static hw7.testData.MetalsAndColorsData.DEFAULT_DATA;
import static hw7.testData.UsersData.PITER_CHAILOVSKII;

public class JdiSiteTest {
    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
    }

    // TODO Why don't you create .gitignore file ?
    @Test
    public void loginTest() {
        JdiSite.open()
                .checkHomePageOpened()
                .login(PITER_CHAILOVSKII)
                .checkLoggedin(PITER_CHAILOVSKII)
                .goToMetalsAndColorsPage()
                .checkMetalsAndColorsPageOpened()
                .fillAndSubmitForm(DEFAULT_DATA)
                .checkResultSection(DEFAULT_DATA);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
