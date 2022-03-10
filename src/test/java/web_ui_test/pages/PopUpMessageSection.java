package web_ui_test.pages;

import org.openqa.selenium.By;
import web_ui_test.control.Label;

public class PopUpMessageSection {
    public Label emptyRecyclerBinMessage=new Label(By.xpath("//td[@class=\"HeaderTd\"]//div[@style=\"display: block;\"]"));
}
