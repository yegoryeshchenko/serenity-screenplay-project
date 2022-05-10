package serenityswag.inventory;

import static serenityswag.authentication.User.STANDARD_USER;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.authentication.User;
import serenityswag.cart.AddToCartActions;
import serenityswag.cart.ShoppingCartBadge;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

  @Managed
  WebDriver driver;

  @Steps
  LoginActions login;

  ShoppingCartBadge shoppingCartBadge;

  @Steps
  AddToCartActions addToCart;

  @BeforeEach
  public void login() {
    login.as(STANDARD_USER);
  }

  @Test
  public void theCorrectItemCountShouldBeShown() {
    assertThat(shoppingCartBadge.count()).isEmpty();
    addToCart.item("Sauce Labs Backpack");

    Serenity.reportThat("Shopping cart should be '1'",
        () -> assertThat(shoppingCartBadge.count()).isEqualTo("1")
    );
  }

  @Test
  public void allTheItemsShouldAppearInTheCart() {

  }

}
