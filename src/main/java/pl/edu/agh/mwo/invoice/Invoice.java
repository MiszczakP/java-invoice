package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.*;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
  //  private List<Product> products = new ArrayList<>();

    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        this.addProduct(product,1);//product with quantity =1

    }
    public void addProduct(Product product, Integer quantity) {
        //if conditions will be implements to both ,,addProduct"
        if(quantity == -1 || quantity == 0){
            throw new IllegalArgumentException("Quantity cannot be null or empty");
        }
        this.products.put(product, quantity); //we use put, add is not at map

    }

    public BigDecimal getNetPrice() {
        BigDecimal sum = BigDecimal.ZERO;
    //    for (Product product : this.products) {
    //    }
        for (Product product : this.products.keySet()) {
            Integer quantity = this.products.get(product);
           sum=sum.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        }
        return sum;
    }

    public BigDecimal getTax() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getTotal() {
        return BigDecimal.ZERO;
    }
}
