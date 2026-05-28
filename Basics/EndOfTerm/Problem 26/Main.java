/*1. Code này có smell là feature envy, tức là một phương thức của một class lại
phụ thuộc quá nhiều vào dữ liệu ở một class khác, ở đây là calculateTotal , và
ta nên đưa nó vào class Order  */
class Order {
    private double price;
    private int quantity;

    public Order(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return price * quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Order order = new Order(20.0, 5);
        System.out.println(order.calculateTotal());
    }
}
