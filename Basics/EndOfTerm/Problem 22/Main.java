/*
OCP: Khi thêm một chức năng mới cùng loại, ta nên thiết kể để chỉ cần
thêm code mới, chứ không phải sửa đi sửa lại phần code cũ đã ổn định

1. Có vi phạm, bởi vì, ví dụ như khi ta cần thêm cách thức
gửi thông báo mới, ta lại phải vào code cũ để sửa
2. Nếu như sau này thêm Telegram, class NotificationService sẽ bị sửa
 */

interface NotificationService {
    void send(String message);
}

class EmailSender implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Send email: " + message);
    }
}

class SMSSender implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Send SMS: " + message);
    }
}

class ZaloSender implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Send Zalo: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationService service = new EmailSender();
        service.send("Hello, my name is Kieran");
    }
}
