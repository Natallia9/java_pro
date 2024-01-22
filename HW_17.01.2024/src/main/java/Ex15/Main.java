package Ex15;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        System.out.println("High value products by customer:");

        Order2 order1 = new Order2("Customer1", List.of(new Product("1", 23.5), new Product("2", 12.5)));
        Order2 order2 = new Order2("Customer2", List.of(new Product("3", 5.5)));

        List<Order2> orders = List.of(order1, order2);

        double threshold = 7.0;

        Map<String, List<String>> result = highValueProductsByCustomer(orders, threshold);

        result.forEach((customerName, categories) -> {
            System.out.println("Customer: " + customerName);
            System.out.println("Categories: " + categories);
        });

    }
    public static Map<String, List<String>> highValueProductsByCustomer(List<Order2> orders, double threshold){
//        return orders.stream()
//                .flatMap(order -> order.getProducts().stream())
//                .filter(product -> product.getPrice() > threshold)
//                .collect(Collectors.groupingBy(Product::getCustomerName, Collectors.mapping(Product::getCategory, Collectors.toList())
//                ));

        return orders.stream()
                .flatMap(order -> order.getProducts().stream()
                        .filter(product -> product.getPrice() > threshold)
                        .map(Product::getCategory)
                        .map(category -> Map.entry(order.getCustomerName(), category))
                )
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));

    }
}
