package Ex15;

import java.util.List;

public class Order2 {
    private String customerName;
    private List<Product> products;

    public Order2(String customerName, List<Product> products) {
        this.customerName = customerName;
        this.products = products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Product> getProducts() {
        return products;
    }
}
