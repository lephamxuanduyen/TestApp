package pages;

import constant.Constant;
import models.User;
import org.openqa.selenium.By;
import utils.Actions;

public class LoginPage extends BasePage {

    private By btnSignInByEmail = By.xpath(String.format(BasePage.btn, "Continue with email"));
    private By txbEmail = By.xpath(String.format(BasePage.tbx, ""));
    private By btnSubmitEmail = By.xpath(String.format(BasePage.btn, "CONTINUE WITH EMAIL"));
    private By txbPwd = By.xpath(String.format(BasePage.tbx, "Password"));
    private By btnLogin = By.xpath(String.format(BasePage.btn, "LOG IN"));

    public void signIn(User user){
        Actions.click(btnSignInByEmail);
        Actions.enter(txbEmail, user.getEmail());
        Actions.click(btnSubmitEmail);
        Actions.enter(txbPwd, user.getPassword());
        Actions.click(btnLogin);
    }

}
