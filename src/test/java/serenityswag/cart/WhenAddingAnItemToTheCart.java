package serenityswag.cart;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.inventory.ProductList;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

  @Managed
  WebDriver driver;

  @Steps
  LoginActions login;

  ShoppingCartIcon shoppingCartBadge;

  @Steps
  CartActions cart;

  @BeforeEach
  public void login() {
    login.as(STANDARD_USER);
  }

  @Test
  public void theCorrectItemCountShouldBeShown() {
    assertThat(shoppingCartBadge.badgeCount()).isEmpty();
    cart.addItem("Sauce Labs Backpack");

    Serenity.reportThat("The shopping cart should be '1'",
        () -> assertThat(shoppingCartBadge.badgeCount()).isEqualTo("1")
    );
  }

  ProductList productList;

  @Test
  public void allTheItemsShouldAppearInTheCart() {
    // add several items to the cart
    List<String> selectedItems = firstThreeProductTitlesDisplayed();

    // open the cart page
    cart.addItems(selectedItems);
    String cartBadgeCount = Integer.toString(selectedItems.size());
    Serenity.reportThat("The shopping cart should be " + selectedItems.size(),
        () -> assertThat(shoppingCartBadge.badgeCount()).isEqualTo(cartBadgeCount)
    );

    cart.openCart();
    // should see all the items listed

    Serenity.reportThat("Should see all of the items listed",
        () ->
            assertThat(cart.displayedItems()).containsExactlyElementsOf(selectedItems)
            .isEqualTo(selectedItems));
  }

  private List<String> firstThreeProductTitlesDisplayed() {
    return productList.titles().subList(0, 3);
  }

}
