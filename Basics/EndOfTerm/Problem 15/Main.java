/*
Abstract Factory: Cung cấp một giao diện để tạo các họ đối tượng có liên quan
hoặc phụ thuộc nhau mà không cần chỉ rõ các lớp cụ thể của chúng

*/
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

class Shushi implements Food {
    @Override
    public void eat() {
        System.out.println("Eat Shushi");
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
    Food foodCreator();

    Drink drinkCreator();
}

class VietNameseBreakfast implements BreakfastFactory {
    @Override
    public Food foodCreator() {
        return new BanhMi();
    }

    @Override
    public Drink drinkCreator() {
        return new Coffee();
    }
}

class JapaneseBreakfast implements BreakfastFactory {
    @Override
    public Food foodCreator() {
        return new Shushi();
    }

    @Override
    public Drink drinkCreator() {
        return new Tea();
    }
}

class Breakfast {
    Food food;
    Drink drink;

    public Breakfast(BreakfastFactory factory) {
        food = factory.foodCreator();
        drink = factory.drinkCreator();
    }

    public void serve() {
        food.eat();
        drink.drink();
    }
}

public class Main {
    public static void main(String[] args) {
        BreakfastFactory factory1 = new VietNameseBreakfast();
        Breakfast breakfast1 = new Breakfast(factory1);
        breakfast1.serve();

        BreakfastFactory factory2 = new JapaneseBreakfast();
        Breakfast breakfast2 = new Breakfast(factory2);
        breakfast2.serve();
    }
}
