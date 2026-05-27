interface Coffee {
    int cost();
}

class BasicCoffee implements Coffee {
    @Override
    public int cost() {


        return 20;
    }
}







class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int cost() {
        return coffee.cost() + 5;
    }
}
class SugarDecorator implements Coffee {
    private Coffee coffee;
    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public int cost() {
        return coffee.cost() + 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SugarDecorator(new MilkDecorator(new BasicCoffee()));

        System.out.println(coffee.cost());
    }
}
