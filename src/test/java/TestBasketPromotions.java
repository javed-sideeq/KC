import com.kc.Basket;
import com.kc.Product;
import com.kc.PromotionalRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestBasketPromotions {

    @Test
    public void test_PromotionalRule_ProductPriceDiscounted() {
        Basket basket = createBasket();
        basket.applyPromotions();
        // this line requires refactoring such that we can retrieve objects by ID.
        Product waterBottle = (Product)basket.getProducts().toArray()[0];
        Double productPrice = waterBottle.getProductPrice();
        // this line requires refactoring such that 22.99 is taken from the basket object
        Assertions.assertEquals(22.99, productPrice);
    }

    @Test
    public void test_baskDiscount_ThresholdValue_Applied() {
        Basket basket = createBasket();
        // this line needs refactoring such that 0.1 is taken from the promotions object
        Double basketTotalAfterDiscountApplied = basket.getBasketTotal() - (basket.getBasketTotal() * 0.1);
        basket.applyPromotions();
        Assertions.assertEquals(basketTotalAfterDiscountApplied, basket.getBasketTotal());
    }

    // refactor hardcoded variables by creating method variables instead
    private static PromotionalRules createPromotionalRules() {
        PromotionalRules promotionalRules = new PromotionalRules();
        Map percentageDiscountToThresholdValue = new HashMap<Integer, Double>();
        percentageDiscountToThresholdValue.put(75,0.1);
        promotionalRules.setPercentageDiscountToThresholdValue(percentageDiscountToThresholdValue);
        PromotionalRules.ProductDiscount productDiscount = new PromotionalRules.ProductDiscount();
        productDiscount.setDiscountedAmount(22.99);
        productDiscount.setProductId(1);
        productDiscount.setQtyRequiredForDiscount(2);
        Set<PromotionalRules.ProductDiscount> productDiscounts = new HashSet<>();
        productDiscounts.add(productDiscount);
        promotionalRules.setProductDiscounts(productDiscounts);
        return promotionalRules;
    }

    // refactor hardcoded variables and create method variables instead
    private static Basket createBasket() {
        Basket basket = new Basket(createPromotionalRules());
        Product waterBottle = new Product(1, 2, 24.95);
        basket.addProduct(waterBottle);
        Product hoodie = new Product(2, 1, 65.00);
        basket.addProduct(hoodie);
        Product stickerSet = new Product(3, 1, 3.99);
        basket.addProduct(stickerSet);
        return basket;
    }

}
