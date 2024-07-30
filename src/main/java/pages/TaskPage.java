package pages;

import enums.Swipe;
import models.Task;
import org.openqa.selenium.By;
import utils.Actions;

public class TaskPage extends BasePage {
    private By quickTaskBtn =By.xpath("//android.widget.ImageButton[@content-desc=\"Quick add\"]");
    private By taskNameTxb = By.xpath(String.format(tbx, "Task name"));
    private By taskDescriptiontxb = By.xpath(String.format(tbx, "Description"));
    private By addBtn = By.xpath("//android.widget.ImageView[@content-desc=\"Add\"]");
    private String cbxDoneTask = "//android.widget.RelativeLayout[android.widget.TextView[@text=\"%s\"]]/android.widget.CheckBox[@content-desc=\"Complete\"]";

    public void createTask(Task task) {
        Actions.click(quickTaskBtn);
        String taskName = task.getName();
        if (task.getDate() != null) {
            taskName += " " + task.getDate();
        }
        if (task.getPriority() != null) {
            taskName += " !!" + task.getPriority();
        }
        if (task.projectName != null) {
            taskName += " #" + task.getProjectName();
        }
        Actions.enter(taskNameTxb, taskName);
        if (task.getDescription() != null){
            Actions.enter(taskDescriptiontxb, task.getDescription());
        }
        Actions.click(addBtn);
        Actions.swipe(Swipe.DOWN);
    }

    public void deleteTask(String taskName, String projectName) {
        Actions.click(By.xpath(menuBtn));
        if (projectName == null) projectName = "Inbox";
        Actions.click(By.xpath(String.format(projectBtn, projectName)));
        Actions.click(By.xpath(String.format(cbxDoneTask, taskName)));
    }
}     