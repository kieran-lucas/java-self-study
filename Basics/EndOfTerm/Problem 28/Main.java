/*
1.Code này đang bị smell primitive obsession, tức là dùng kiểu dữ liệu
nguyên thủy cho mọi loại thông tin, bao gồm các loại thông tin như
price, quantity, đáng lẽ ra nên có logic nghiệp vụ riêng */

class Product {
    private String name;
    private Price price;
    private Quantity quantity;

    public Product(String name, Price price, Quantity quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Price {
    private double value;

    public Price(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("So tien khong hop le");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

class Quantity {
    private int value;

    public Quantity(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("So luong khong hop le");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Price price = new Price(500.0);
        Quantity quantity = new Quantity(5);

        Product product = new Product("Iphone", price, quantity);
    }
}
