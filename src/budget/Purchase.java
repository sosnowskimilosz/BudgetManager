package budget;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Purchase {

    BigDecimal price;
    String title;
    Category category;

    Purchase(String title, BigDecimal price, Category category) {
        this.title = title;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public Double getPriceInDouble() {
        return price.doubleValue();
    }

    public String getPriceFromBigDecimal() {
        return price.toString();
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return title + "@" + price.setScale(2, RoundingMode.HALF_UP) + "@" + category;
    }
}
