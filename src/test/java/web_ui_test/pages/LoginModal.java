package web_ui_test.pages;

import org.openqa.selenium.By;
import web_ui_test.control.Button;
import web_ui_test.control.TextBox;

public class LoginModal {
    public TextBox emailLogInTxtBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"));
    public TextBox pwdLoginTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"));
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"));
}
