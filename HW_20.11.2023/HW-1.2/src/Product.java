public class Product {
    private String name;
    private double price;
    private int quantityInStock;

    public Product(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public boolean stockCheck(Product product) {
        if(product.quantityInStock < 0){
            return false;
        }
        return true;
    }
    public void quantityUpdate(int quantity){
        if (quantity > 0) {
            quantityInStock = quantity;
            System.out.println("Количество обнавлено");
        } else {
            System.out.println("Данного количества нет");
        }
    }
}
