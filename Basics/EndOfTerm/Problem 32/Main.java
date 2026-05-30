import java.util.*;

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
"

