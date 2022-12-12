package sesosas.simpleexp.classes;

public class Mathematics {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
