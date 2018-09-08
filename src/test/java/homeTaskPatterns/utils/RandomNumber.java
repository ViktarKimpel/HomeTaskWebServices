package homeTaskPatterns.utils;

import java.util.Random;


public class RandomNumber {

    public static final int DEFAULT_INTERVAL_INT = 99;

    public static String getRandomInt(int maxValue){
    return String.valueOf(new Random().nextInt(maxValue));
    }
    public static String getRandomInt(){
        return getRandomInt(DEFAULT_INTERVAL_INT);
    }
}
