import enums.Priority;
import org.testng.annotations.Test;
import pages.TaskPage;

public class Task extends TestBase {
    TaskPage taskPage = new TaskPage();
    models.Task task = new models.Task("Todo", "8/8/2024", Priority.PRIORITY_1, null, null);

    @Test
    void CreateTask() {
        taskPage.createTask(task);
    }

    @Test
    void Delete() {
        taskPage.deleteTask(task.getName(), task.getProjectName());
    }
}
