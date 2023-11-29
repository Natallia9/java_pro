import java.util.ArrayList;
import java.util.List;

public class Costumer {
    private String nameCostumer;
    private String email;
    private List<Order> orderHistory;

    public Costumer(String nameCostumer, String email) {
        this.nameCostumer = nameCostumer;
        this.email = email;
        this.orderHistory = new ArrayList<>();
    }

    public String getNameCostumer() {
        return nameCostumer;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public String getEmail() {
        return email;
    }

    public void makeAnOrder(String status) {
        Order newOrder = new Order(status);
        orderHistory.add(newOrder);
        System.out.println("Заказ создан " + status);
    }


    public void cancellations(int orderIndex) {
        if (orderIndex >= 0 && orderIndex < orderHistory.size()) {
            System.out.println("Заказ отменен для " + orderIndex);
        } else {
            System.out.println("Неверный индекс заказа.");
        }
    }
}


