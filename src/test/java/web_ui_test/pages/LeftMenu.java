package web_ui_test.pages;

import web_ui_test.control.AlertControl;
import web_ui_test.control.Button;
import web_ui_test.control.Label;
import org.openqa.selenium.By;

public class LeftMenu {
 //CREATE
 public Button addProjButton = new Button(By.xpath("//button[@class=\"adder_icon\"]"));

 //UPDATE
 public Button moreActionsButton = new Button(By.xpath("//div[@class=\"reactist collapse collapse--entered\"]//li[last()]//button"));
 public Button updateProjButton = new Button(By.xpath("//div[text()=\"Editar proyecto\"]"));

 //DELETE
 public Button deleteProjButton = new Button(By.xpath("//div[text()=\"Eliminar proyecto\"]"));
 public Button confirmDeleteButton = new Button(By.xpath("//button[text()='Eliminar']"));
 public AlertControl alertControl = new AlertControl();

 public LeftMenu(){}
 public boolean isProjectNameDisplayed(String name){
  Label nameProject= new Label(By.xpath("//a//span[text()=\""+name+"\"]"));
  return nameProject.isControlDisplayed();
 }
 public void clickNameProject(String name){
  Label nameProject = new Label(By.xpath("//a//span[text()=\""+name+"\"]"));
  nameProject.click();
 }


}
