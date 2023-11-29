public class OrderManager {
    private Order[] listOfOrders;
    private Product[] listOfProducts;

    public OrderManager(Order[] listOfOrders, Product[] listOfProducts) {
        this.listOfOrders = listOfOrders;
        this.listOfProducts = listOfProducts;
    }

    public Order[] getListOfOrders() {
        return listOfOrders;
    }

    public Product[] getListOfProducts() {
        return listOfProducts;
    }
    public void addOrder(Product newProduct) {
        for (int i = 0; i < listOfProducts.length; i++) {
            if (listOfProducts[i] == null) {
                listOfProducts[i] = newProduct;
                System.out.println("Заказ в обработке " + newProduct);
                return;
            } else {
                System.out.println("Невозможно обработать заказ");
            }
        }
    }
    public void orderStatus(Order order, String newStatus) {
        for (int i = 0; i < listOfOrders.length; i++) {
            if (listOfOrders[i].equals(order)) {
                listOfOrders[i].setOrderStatus(newStatus);
                System.out.println("Статус заказа обновлен: " + newStatus);
                return;
            }
        }
        System.out.println("Ошибка: Заказ не найден");
    }

}

