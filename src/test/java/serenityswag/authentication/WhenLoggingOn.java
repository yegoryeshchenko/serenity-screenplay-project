package serenityswag.authentication;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.inventory.InventoryPage;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn extends UIInteractionSteps {

  @Managed
  WebDriver driver;

  @Steps
  LoginActions login;

  InventoryPage inventory;

  @Test
  public void usersCanLogOnViaTheHomePage() {
    login.as(STANDARD_USER);

    // Should see Product catalog
    Serenity.reportThat("Inventory page should be displayed with the correct title",
        () -> assertThat(inventory.getHeading()).isEqualToIgnoringCase("Products")
    );
  }

}
