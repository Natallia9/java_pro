public class Main {
    public static void main(String[] args) {

        Product product = new Product("Название", 2.45, 23);
        Product product1 = new Product("Название2", 10, 8);

        Order order = new Order("В наличии", "", null);
        order.addProduct(product1);
        order.sum(product);

        Costumer costumer = new Costumer();
        costumer.cancellations(product.getQuantityInStock());
        costumer.makeAnOrder(order.getOrderStatus());

        OrderManager orderManager = new OrderManager();
        orderManager.addOrder(product);
        orderManager.orderStatus(new Order());

    }
}