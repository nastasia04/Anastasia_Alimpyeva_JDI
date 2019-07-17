package hw7.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import hw7.entities.Users;
import hw7.forms.LoginForm;
import org.hamcrest.Matchers;

import static hw7.JdiSite.clickHeaderMenuItem;
import static hw7.JdiSite.metalsAndColorsPage;
import static hw7.enums.HeaderMenu.METALS_COLORS;

@Url("index.html")
@Title("Home Page")
public class HomePage extends WebPage {

    private LoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    @XPath("//i[contains(@class, 'fa-sign-out')]")
    private UIElement logout;

    public HomePage login(Users user) {
        profilePhoto.click();
        loginForm.login(user);
        return this;
    }

    public void loggedOut() {
        if (userName.isDisplayed()) {
            if (!(logout.isDisplayed()))
                profilePhoto.click();
            logout.click();
        }
    }

    public HomePage checkHomePageOpened() {
        checkOpened();
        return this;
    }

    public HomePage checkLoggedin(Users user) {
        userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
        return this;
    }

    public MetalsAndColorsPage goToMetalsAndColorsPage() {
        clickHeaderMenuItem(METALS_COLORS.getValue());
        return metalsAndColorsPage;
    }
}
