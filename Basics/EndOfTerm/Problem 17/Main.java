/*
Adapter: Chuyển đổi giao diện của một lớp thành giao diện khác mà
client mong đợi
*/
interface Printer {
    void print(String text);
}

class OldPrinter {
    public void printText(String text) {
        System.out.println("OldPrinter: " + text);
    }
}

class Client {
    Printer printer;

    public Client(Printer printer) {
        this.printer = printer;
    }

    public void doPrint() {
        printer.print("Hello Adapter");
    }
}

class PrintAdapter implements Printer {
    private OldPrinter oldPrinter;

    public PrintAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String text) {
        oldPrinter.printText(text);
    }
}

public class Main {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();
        Printer printer = new PrintAdapter(oldPrinter);
        Client client = new Client(printer);
        client.doPrint();

    }

}
