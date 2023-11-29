public class Order {
    private Product[] listOfProducts;
    private String orderStatus;
    private double totalAmount;

    public Order(String orderStatus) {
        this.listOfProducts = listOfProducts;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
    }

    public Product[] getListOfProducts() {
        return listOfProducts;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addProduct(Product newProduct) {
        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] == null) {
                listOfProducts[i] = newProduct;
                System.out.println("Товар " + newProduct + " добавлен");
                return;
            }
        }
        System.out.println("Нельзя добавить товар");
    }

    public void sum(Product product){
        totalAmount += product.getPrice();
        System.out.println("Общая сумма заказа " + totalAmount);
    }

}
