/*
Singleton: Bảm đảm một lớp chỉ có duy nhất một thể hiện và cung cấp
điểm truy cập toàn cục tới thể hiện đó
*/

class Singleton {
    private static Singleton instance;
    private Singleton() {

    }
    public static synchronized getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
