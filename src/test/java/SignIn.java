import constant.Constant;
import models.User;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SignIn extends TestBase {

    User user = new User(Constant.email, Constant.password);
    LoginPage loginPage = new LoginPage();

    @Test
    public void SignIn() {
        loginPage.signIn(user);
    }
}
