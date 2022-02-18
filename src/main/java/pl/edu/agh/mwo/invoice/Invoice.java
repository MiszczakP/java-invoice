package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.*;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    //  private List<Product> products = new ArrayList<>();

    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        this.addProduct(product, 1);

    }

    public void addProduct(Product product, Integer quantity) {
        if (quantity == -1 || quantity == 0) {
            throw new IllegalArgumentException("Quantity cannot be null or empty");
        }
        this.products.put(product, quantity);

    }

    public BigDecimal getNetPrice() {
        BigDecimal sum = BigDecimal.ZERO;

        for (Product product : this.products.keySet()) {
            Integer quantity = this.products.get(product);
            BigDecimal quantityAsBigDecimal = BigDecimal.valueOf(quantity);
            BigDecimal priceOfThisItem = product.getPrice().multiply(quantityAsBigDecimal);
            sum = sum.add(priceOfThisItem);
        }
        return sum;
    }

    public BigDecimal getTax() {
        BigDecimal tax = BigDecimal.ZERO;

        for (Product product : this.products.keySet()) {
            BigDecimal taxPercentage = product.getTaxPercent();
            BigDecimal priceTaxPercentage = product.getPrice().multiply(taxPercentage);
            tax = tax.add(priceTaxPercentage);
        }
        return tax;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : this.products.keySet()) {
            Integer quantity = this.products.get(product);
            BigDecimal quantityAsBigDecimal = BigDecimal.valueOf(quantity);
            BigDecimal priceOfThisItem = product.getPrice().multiply(quantityAsBigDecimal);
            BigDecimal taxPercentage = product.getTaxPercent();
            BigDecimal priceTaxPercentage = product.getPrice().multiply(taxPercentage);

            total = total.add((priceOfThisItem).add(priceTaxPercentage.multiply(quantityAsBigDecimal)));
        }
        return total;
    }
}
