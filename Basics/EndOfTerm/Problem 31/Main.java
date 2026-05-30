/*Câu 2
a, Khối finally trong xử lý ngoại lệ có tác dụng đặt những viêjc
cần làm sau cùng, cho dù chương trình có bị lỗi hay không, những
dòng lệnh trong khối finally sẽ luôn được thực hiện */
try {
    int x = 10/0
} catch (Exception e) {
    System.out.println("Error");
} finally {
    System.out.println("Close file");
}
output:
Error
Close file
ta thấy dù chương trình bị lỗi nhưng khối finally vẫn được thực hiện
khối finally thường được ứng dụng trong việc giải phóng tài
nguyên sau chương trình (đóng file, ngắt kết nối database,..)
b, interface Animal {
    void makeSound();
}
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }
}
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}

public class Main {
    static void makeSound(Animal a) {
        a.makeSound();
    }
    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Cat();
        makeSound(a); //Woof Woof
        makeSound(b); //Meow Meow

    }
}
Ta thấy là kiểu tham chiếu Animal của interface Animal được truyền
vào hàm makeSound của Main như một kiểu dữ liệu, khi gọi makeSound(a),
nhờ vào cơ chế đa hình mà lúc runtime Java sẽ tìm đến đối tượng thật là
Dog để gọi phương thức makeSound của Dog
c, ở trong class gốc Object, equals được cài đặt giống hệt việc so sánh
hai giá trị tham chiếu (tức là so sánh địa chỉ bộ nhớ)
ta cần phải ghi đè lại mỗi lần sử dụng để đạt được mong muốn so sánh
giá trị của hai đối tượng
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        Point other = (Point) o;
        return this.x == other.x && this.y == other.y;
    }
}
public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        System.out.println(p1 == p2); //false (do hai địa chỉ bộ nhớ khác nhau)
        System.out.println(p1.equals(p2)); //true (do so sánh hai giá trị x, y)
    }
}
Câu 3:
import java.util.*;

class Employee {
    String name;
    List<String> listOfTask;
    List<Employee> listOfManager = new ArrayList<>();

    public Employee(String name, List<String> listOfTask) {
        this.name = name;
        this.listOfTask = listOfTask;
    }

    public void displayInfo() {
        for (Employee e : this.listOfManager) {
            System.out.print(e.name + " ");
        }
        System.out.println();
        for (String task : this.listOfTask) {
            System.out.print(task + " ");
        }

    }
}

class Manager extends Employee {
    public Manager(String name, List<String> listOfTask) {
        super(name, listOfTask);
    }

    public void addEmployee(Employee e) {
        e.listOfManager.add(this);
    }
}

class Developer extends Employee {
    public Developer(String name, List<String> listOfTask) {
        super(name, listOfTask);
    }
}

class Tester extends Employee {
    public Tester(String name, List<String> listOfTask) {
        super(name, listOfTask);
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> developerTask = new ArrayList<>();
        developerTask.add("Task 1");
        developerTask.add("Task 2");
        List<String> managerTask = new ArrayList<>();
        managerTask.add("Task 3");
        managerTask.add("Task 4");
        Developer developer = new Developer("Kieran", developerTask);
        Manager manager = new Manager("Lucas", managerTask);
        manager.addEmployee(developer);
        developer.displayInfo();
    }
}

Câu 4:
a, class Pairs<T, V> {
    T t;
    V v;
    public Pairs(T t, V v) {
        this.t = t;
        this.v = v;
    }
    public T getT() {
        return this.t;
    }
    public V getV() {
        return this.t;
    }
}
b, import java.util.*;

class MyUtility {
    public static <T extends Comparable<T>> T findMax(List<T> array) {
        T maxArray = array.get(0);
        for (T t : array) {
            if (t.compareTo(maxArray) > 0) {
                maxArray = t;
            }
        }
        return maxArray;
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>(List.of("A", "B", "C"));
        System.out.println(MyUtility.findMax(array));
    }
}
c,
Mẫu thiết kế factory method: Thiết kế một giao diện/phương thức để
tạo đối tượng, nhưng để subclass quyết định đối tượng thuộc lớp nào
sẽ được tạo ra. factory method cho phép trì hoãn việc tạo đối tượng
của lớp cha cho lớp con

interface Animal {
    void makeSound();
}
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }
}
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}
abstract class AnimalCreator {
    public abstract Animal createAnimal();
    public void active() {
        Animal a = createAnimal();
        a.makeSound();
    }
}
class DogCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
class CatCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
public class Main {
    public static void main(String[] args) {
        AnimalCreator a = new DogCreator();
        a.active();
    }
}

Abstract factory: Cung cấp một họ các giao diện để tạo một họ đối tượng liên quan hoặc phụ thuộc vào nhau mà không cần chỉ ra lớp cụ thể của chúng

interface Food {
    void eat();
}
interface Drink {
    void drink();
}
class BanhMi implements Food {
    @Override
    public void eat() {
        System.out.println("Eat Banh Mi");
    }
}
class Sushi implements Food {
    @Override
    public void eat() {
        System.out.println("Eat Sushi");
    }
}
class Coffee implements Drink {
    @Override
    public void drink() {
        System.out.println("Drink Coffee");
    }
}

class Tea implements Drink {
    @Override
    public void drink() {
        System.out.println("Drink Tea");
    }
}
interface BreakfastFactory {
    Food createFood();
    Drink createDrink();
}
class VietnameseBreakfast implements BreakfastFactory {
    @Override
    public Food createFood() {
        return new BanhMi();
    }
    @Override
    public Drink createDrink() {
        return new Coffee();
    }
}
class BreakfastService {
    Food food;
    Drink drink;
    public void serve(BreakfastFactory breakfast) {
        food = breakfast.createFood();
        drink = breakfast.createDrink();
        food.eat();
        drink.drink();
    }
}
public class Main {
    public static void main(String[] args) {
        BreakfastFactory breakfast = new VietnameseBreakfast();
        BreakfastService service = new BreakfastService();
        service.serve(breakfast);

    }
}


1. try-catch-finally là một cơ chế trong Java để xử lí ngoại lệ
đoạn code trong khối try là đoạn code ta muốn chạy nó và nó có thể
phát sinh ngoại lệ, khối catch dùng để bắt ngoại lệ đó và xử lí, còn
khối finally là để làm những việc sau cùng, khối này sẽ luôn được
thực thi bất kể chương trình có phát sinh ngoại lệ hay không, người
ta thường khối finally để thông báo kết thúc, giải phóng tài nguyên
(đóng file, ngắt kết nối tới database)
ví dụ:
try {
    int a = 10/0;
} catch (ArthrimaticException e) {
    System.out.println("Không thể chia cho 0");
} finally {
    System.out.println("Kết thúc chương trình");
}
ở đây trong khối try đã phát sinh ngoại lệ là chia một số cho 0,
đã được khối catch bắt lại và xử lí (in ra thông báo), ta có thể
thêm nhiều khối catch (nên theo thứ tự cụ thể đến tổng quát), vì Java
sẽ xét từ trên xuống đến khi bắt được, khối finally đã in thông báo
kết thúc mặc dù chương trình phát sinh ngoại lệ

2. final mang ý nghĩa chung là trạng thái cuối cùng của một yếu tố gì
đó, tuy nhiên khi được áp dụng vào từng trường hợp cụ thể sẽ cho ra
hành vi khác nhau đôi chút. Cụ thể thì:
final với thuộc tính mang ý nghĩa là thuộc tính đó không thể thay đổi giá
trị, với kiểu dữ liệu nguyên thủy thì là giá trị của nó không được thay đổi,
còn với những kiểu dữ liệu không nguyên thủy thì là giá trị của biến tham
chiếu không được thay đổi, tức là địa chỉ bộ nhớ của đối tượng
được khai báo final là không thể thay đổi (không thể trỏ qua địa chỉ khác), tuy
nhiên những gì bên trong đối tượng vẫn có thể thay đổi nếu được phép
ví dụ final String a = "text";
khi này nếu cố gắng gán lại a = "number"; sẽ bị lỗi complile
final Person p1 = new Student();
p1 = new Student(); sẽ gây lỗi compile;
tuy nhiên p1.name = "nameChanged"; vẫn có thể đổi được nếu thuộc tính name được phép
truy cập
final với phương thức thì nội dung của phương thức, thức là thân phương thức
(những dòng code được viết trong block định nghĩa của phương thức) không thể
thay đổi, hay nói cách khác là không thể ghi đè lại được
ví dụ public void eat() {
    System.out.println("Eat Bread");
}
lớp con muốn override sẽ bị lỗi complile:
public void eat() {
    System.out.println("Eat Cake"); //lỗi complile
}
một class được khai báo là final thì có nghĩa là class đó không thể
được kế thừa
ví dụ như public final class Person {}
class Student extends Person {} //lỗi compile

Câu 4:
Mẫu thiết kế Adapter: Cho phép chuyển đổi giao diện theo mong muốn của client
Ví dụ ở đây ta có một Printer chỉ có phương thức print, và client cũng
chỉ dùng được print, nhưng ta lại muốn sử dụng cho một OldPrinter
chỉ có phương thức printText

interface Printer {
    void print(String message);
}

class OldPrinter {
    public void printText(String message) {
        System.out.println("Old Printer: " + message);
    }
}
class Client {
    Printer printer;
    public Client(Printer printer) {
        this.printer = printer;
    }
    public void doPrint(String message) {
        printer.print("Hello Adaper: " + message);
    }
}
class PrintAdapter implements Printer {
    OldPrinter oldPrinter;
    public PrintAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }
    @Override
    public void print(String message) {
        oldPrinter.printText(message);
    }
}
public class Main {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();
        Printer printer = new PrinterAdapter(oldPrinter);
        Client client = new Client(printer);
        client.doPrint("Hello");
    }
}


class Student {
    private String id;
    private String name;
    public Student(String id, String name) {

    }
    public String getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
}
public class Main {
    static boolean existsByID(ArrayList<Student> list, String id) {
        return list.stream().anyMatch(s -> s.getID().equals(id));
    }
    static void sortByName(ArrayList<Student> list) {
        list.sort((a, b) -> a.getName().compareTo(b.getName()));
    }
}
import java.util.ArrayList;

public class Template<T> {
    ArrayList<T> list = new ArrayList<>();

    public T search(T t) {
        for (T e : this.list) {
            if (e.equals(t)) {
                return e;
            }
        }
        return null; // nằm ngoài vòng lặp
    }
}

public class Main {
    public static void main(String[] args) {
        Template<String> template = new Template<>();
        template.list.add("A");
        template.list.add("B");
        System.out.println(template.search("B")); // gọi đúng đối tượng
    }
}
