package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {

        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty and cannot be empty");
        }
        if (price==null || price.signum() ==-1) {
            throw new IllegalArgumentException("Price cannot be empty or lower than 0");
        }
        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public BigDecimal getTaxPercent() {

        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {

        return this.price.multiply(this.taxPercent).add(this.price);
    }
}
