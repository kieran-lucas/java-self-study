/*
Cung cấp một object đại diện hoặc thay thế cho object khác
để kiểm soát quyền truy cập đến object đó

*/
interface Image {
    void display();
}

class RealImage implements Image {
    String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    public void loadFromDisk() {
        System.out.println("Load from disk: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Display image: " + fileName);
    }
}

class ProxyImage implements Image {
    String fileName;
    RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

}

public class Main {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("Picture");
        System.out.println("Image object created");
        image.display();
        image.display();
    }
}
