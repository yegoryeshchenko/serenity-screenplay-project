package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import serenityswag.authentication.User;

public class LoginActions extends UIInteractions {

  @Step("Log in as {0}")
  public void as(User user) {
    openUrl("https://www.saucedemo.com/");

//    login standard user

    $("#user-name").sendKeys(user.getUsername());
    $("#password").sendKeys(user.getPassword());
    $("#login-button").click();
  }
}
