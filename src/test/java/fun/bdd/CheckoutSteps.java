package fun.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class CheckoutSteps {
    private int bananaPrice;
    private int applePrice;
    private Checkout checkout = new Checkout();

    @Given("the price of (a|an) {string} is {int}c")
    public void the_price_of_a_is_c(String itemName, Integer priceOfItem) {
        if (itemName.equals("banana"))
            bananaPrice = priceOfItem;
        else
            applePrice = priceOfItem;
    }

    @When("I checkout {int} {string}")
    public void i_checkout(Integer numberOfItems, String itemName) {
        if (itemName.equals("banana"))
            checkout.add(numberOfItems, bananaPrice);
        else
            checkout.add(numberOfItems, applePrice);
    }

    @Then("the total price is {int}c")
    public void the_total_price_is_c(Integer expectedTotalPrice) {
        assertEquals(expectedTotalPrice, checkout.total());
    }
}
