package hw8;

import base.BaseClass;
import hw7.JdiSite;
import hw7.entities.MetalsAndColors;
import hw8.testData.MetalsAndColorsDataProvider;
import org.testng.annotations.Test;

import static hw7.testData.UsersData.PITER_CHAILOVSKII;

public class JdiSiteTest extends BaseClass {

    @Test(dataProvider = "provideData", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void loginTest(MetalsAndColors dataSet) {
        JdiSite.open()
                .checkHomePageOpened()
                .login(PITER_CHAILOVSKII)
                .checkLoggedin(PITER_CHAILOVSKII)
                .goToMetalsAndColorsPage()
                .checkMetalsAndColorsPageOpened()
                .fillAndSubmitForm(dataSet)
                .checkResultSection(dataSet)
                .goToHomePage()
                .loggedOut();
    }
}
