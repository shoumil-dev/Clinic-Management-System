package tools;

import java.util.Random;

public class Utils {
    public static int nextID(int low, int high) {
        Random r = new Random();
        return (r.nextInt(high - low) + low);
    }
}
