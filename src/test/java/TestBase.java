import driver.DriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class TestBase {

    BasePage basePage = new BasePage();

    @BeforeClass
    public void setUp() {
        DriverManager.initializeDriver();
        basePage.startApp();
    }
}
