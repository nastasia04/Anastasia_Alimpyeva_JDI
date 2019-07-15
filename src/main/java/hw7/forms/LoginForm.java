package hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import hw7.entities.Users;

public class LoginForm extends Form<Users> {
    @Css("#name")
    private TextField login;

    @Css("#password")
    private TextField password;

    @Css("#login-button")
    private Button submit;

    @Override
    public void login(Users user) {
        login.input(user.getLogin());
        password.input(user.getPassword());
        submit.click();
    }
}
