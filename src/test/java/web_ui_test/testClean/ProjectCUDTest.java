package web_ui_test.testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web_ui_test.pagesTodoist.*;

import java.util.Date;

public class ProjectCUDTest extends BaseTodoist {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    TopBarTools topBarTools = new TopBarTools();
    LeftMenu leftMenu = new LeftMenu();
    Add_Edit_ProjectModal addEditProjectModal = new Add_Edit_ProjectModal();
    CentralSection centralSection = new CentralSection();
    String email = "manli2001@hotmail.es";
    String password="PruebaWeb123";

    @Test
    public void verifyCudProject() throws InterruptedException {

        //Log in
        Thread.sleep(2000);
        mainPage.loginButton.click();
        loginPage.emailTxtBox.setText(email);
        loginPage.passwordTxtBox.setText(password);
        loginPage.loginButton.click();
        Thread.sleep(5000);
        topBarTools.avatarMenuButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(topBarTools.logoutButton.isControlDisplayed(),"ERROR, no se hizo el login");
        topBarTools.exitAvatarMenuButton.click();
        Thread.sleep(2000);

        //Create
        String projName= "MANUEL"+new Date().getMinutes()+new Date().getSeconds();
        leftMenu.addProjButton.click();
        addEditProjectModal.projNameTxtBox.setText(projName);
        Thread.sleep(2000);
        addEditProjectModal.submitProjButton.click();
        Assertions.assertEquals(projName,centralSection.actualProjectLabel.getTextControl(),"Error no se creo el proyecto");
        Assertions.assertTrue(centralSection.actualProjectLabel.isControlDisplayed());
        Thread.sleep(2000);


        //UPDATE
        leftMenu.clickNameProject(projName);
        leftMenu.moreActionsButton.click();
        leftMenu.updateProjButton.click();
        String newProjName="manuelUpdate"+new Date().getSeconds();
        addEditProjectModal.projNameTxtBox.clearSetText(newProjName);
        addEditProjectModal.submitProjButton.click();
        Assertions.assertEquals(newProjName,centralSection.actualProjectLabel.getTextControl(),"Error no se creo el proyecto");
        Assertions.assertTrue(centralSection.actualProjectLabel.isControlDisplayed());
        Thread.sleep(3000);

        //DELETE
        leftMenu.clickNameProject(newProjName);
        leftMenu.moreActionsButton.click();
        leftMenu.deleteProjButton.click();
        Thread.sleep(3000);
        leftMenu.confirmDeleteButton.click();
        Assertions.assertTrue(!leftMenu.isProjectNameDisplayed(newProjName));
        Thread.sleep(3000);

    }
}
