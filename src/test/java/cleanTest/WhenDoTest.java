package cleanTest;

import activities.whenDo.ConfirmDelete;
import activities.whenDo.CreateTaskScreen;
import activities.whenDo.MainScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import session.Session;

import java.net.MalformedURLException;
public class WhenDoTest {

    MainScreen mainScreen = new MainScreen();
    CreateTaskScreen createTaskScreen = new CreateTaskScreen();
    ConfirmDelete confirmDelete = new ConfirmDelete();

    @Test
    public void verify_create_task() throws MalformedURLException {
        String title = "Creates Task";
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.setValue(title);
        createTaskScreen.descriptionTextBox.setValue("This is a test");
        createTaskScreen.saveButton.click();

        Assert.assertEquals("ERROR! task was not created.",title, mainScreen.nameTaskLabel.text());
    }

    @Test
    public void verify_modification_task() throws MalformedURLException {
        String title = "Creates Task";
        String modifiedTitle = "Creates Task Modified";
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.setValue(title);
        createTaskScreen.descriptionTextBox.setValue("This is a test");
        createTaskScreen.saveButton.click();

        mainScreen.selectElementFromList(title).click();
        createTaskScreen.titleTextBox.setValue(modifiedTitle);
        createTaskScreen.saveButton.click();

        Assert.assertEquals("ERROR! task was not created.",modifiedTitle, mainScreen.nameTaskLabel.text());
    }

    @Test
    public void verify_task_deletion() throws MalformedURLException {
        String title = "Creates Task";
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.setValue(title);
        createTaskScreen.descriptionTextBox.setValue("This is a test");
        createTaskScreen.saveButton.click();

        mainScreen.selectElementFromList(title).click();
        createTaskScreen.deleteButton.click();
        confirmDelete.delete.click();
        Assert.assertFalse("ERROR! task was not deleted.", mainScreen.nameTaskLabel.isVisible());
    }

    @After
    public void close() throws MalformedURLException {
        Session.getInstance().closeSession();
    }

}
