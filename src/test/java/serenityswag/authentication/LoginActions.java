package serenityswag.authentication;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class LoginActions extends UIInteractions {

  @Step("Log in as {0}")
  public void as(User user) {
    openUrl("https://www.saucedemo.com/");

    //    login standard user
    find(LoginForm.USER_NAME).type(user.getUsername());
    find(LoginForm.PASSWORD).type(user.getPassword());
    find(LoginForm.LOGIN_BUTTON).click();
  }
}
