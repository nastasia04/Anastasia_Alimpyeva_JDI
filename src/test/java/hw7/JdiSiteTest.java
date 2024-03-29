package hw7;

import base.BaseClass;
import org.testng.annotations.Test;

import static hw7.testData.MetalsAndColorsData.DEFAULT_DATA;
import static hw7.testData.UsersData.PITER_CHAILOVSKII;

public class JdiSiteTest extends BaseClass {

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

}
