package web_ui_test.pagesTodoist;

import web_ui_test.control.Button;
import web_ui_test.control.Image;
import org.openqa.selenium.By;

public class TopBarTools {
public Image avatarMenuButton = new Image(By.xpath("//img[@alt='Manuel']"));
public Button logoutButton = new Button(By.xpath("//button[position() = 2]//span[@class=\"user_menu_label\"]"));
public Button exitAvatarMenuButton = new Button(By.xpath("//div[@data-dialog-ref]"));
}
