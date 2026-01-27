import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        String text = "32ab45cdk=-2";
        secondTaskEasy(text);
        System.out.println();
        changePlaceWith2Var(2, 9);
//        firstTask(text);
    }

    private static void changePlaceWith2Var(int value1, int value2) {
        System.out.println(value1 + " " + value2);
        value1 += value2;
        value2 = value1 - value2;
        value1 = value1 - value2;
        System.out.println(value1 + " " + value2);
    }

    private static void changePlace(Object value1, Object value2){
        System.out.println(value1 + " " + value2);
        Object prom = value1;
        value1 = value2;
        value2 = prom;
        System.out.println(value1 + " " + value2);
    }

    private static void firstTask(String text) {
        StringBuilder result = new StringBuilder();
        result.append(text);
        System.out.println(result.reverse());
    }

    private static void secondTaskEasy(String text) {
        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i));
        }
    }

    private static String secondTaskHard(String text) {
        var array = text.toCharArray();
        char prom;
        var length = array.length;
        for (int i = 0; i < length / 2; i++) {
            prom = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = prom;
        }
        return Arrays.toString(array);
    }
}
