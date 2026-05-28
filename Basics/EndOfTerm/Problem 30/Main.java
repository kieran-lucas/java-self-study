/*
1. Code này có smell là shotgun surgery, tức là có một đoạn code
nhỏ khi cần sửa thì phải sửa ở nhiều nơi, ở đây là tên Lexora,
ví dụ như lúc mình muốn đổi tên thì lại phải sửa nó ở khắp nơi,
cách sửa là mình đặt nó làm một thuộc tính static final */

class WelcomeService {
    public static final String APP_NAME = "Lexora";
}
class EmailService {
    public void sendWelcomeEmail() {
        System.out.println("Welcome to " + WelcomeService.APP_NAME);
    }
}
class SmsService {
    public void sendWelcomeSms() {
        System.out.println("Welcome to " + WelcomeService.APP_NAME);
    }
}
class NotificationService {
    public void sendWelcomeNotification() {
        System.out.println("Welcome to " + WelcomeService.APP_NAME);
    }
}
