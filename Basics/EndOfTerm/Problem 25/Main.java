/*
1. Có, là data class code smell, tức là class chỉ chứa toàn dữ liệu
trong khi những hành vi của productService có thể gộp vào được
 */
class Product {
    public String name;
    public double price;
    public int quantity;
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return price * quantity;
    }

    public boolean isExpensive() {
        return price > 1000;
    }
}
public class Main {
    public static void main(String[] args) {
        Product iphone = new Product("Iphone", 5000.0, 4);
        System.out.println(iphone.calculateTotal());
        System.out.println(iphone.isExpensive());
    }
}

