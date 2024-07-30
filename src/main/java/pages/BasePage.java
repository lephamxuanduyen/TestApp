package pages;

import enums.Swipe;
import org.openqa.selenium.By;
import utils.Actions;

public class BasePage {
    public static String tbx = "//android.widget.EditText[@text=\"%s\"]";
    public static String btn = "//android.widget.Button[@text=\"%s\"]";
    public static String app = "//android.widget.TextView[@text=\"Todoist\"]";
    public String menuBtn = "//android.widget.ImageButton[@content-desc=\"Menu\"]";
    public String projectBtn = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"android:id/list\"]/android.view.ViewGroup//android.widget.TextView[@text=\"%s\"]";

    public void startApp(){
        Actions.swipe(Swipe.UP);
        Actions.click(By.xpath(app));
    }
}
