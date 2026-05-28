/*1. Code này đang có smell là switch statements, tức là
đang dùng quá nhiều if else để phân tách các hạng mục, giả sử
như sau này chúng ta muốn mở rộng hệ thống bằng cách thêm một
hạng mục như vip thì lại phải sửa lại code cũ, điều này cũng
dẫn đến vi phạm OCP, cách làm là ta sẽ tách những hạng mục thành
từng class con và cho chúng cài đặt cùng một interface, và khi
cần mở rộng thì ta chỉ cần viết thêm class thay vì phải đi sửa
code cũ */

interface ShippingMethod {
    double calculateFee(double weight);
}

class StandardShipping implements ShippingMethod {
    @Override
    public double calculateFee(double weight) {
        return weight * 5;
    }
}

class ExpressShipping implements ShippingMethod {
    @Override
    public double calculateFee(double weight) {
        return weight * 10;
    }
}

class InternationalShipping implements ShippingMethod {
    @Override
    public double calculateFee(double weight) {
        return weight * 20;
    }
}

public class Main {
    public static void main(String[] args) {
        ShippingMethod method = new InternationalShipping();
        System.out.println(method.calculateFee(20.0));
    }
}
