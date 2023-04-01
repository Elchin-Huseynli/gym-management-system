package util;

import java.util.Scanner;

public class InputUtil {
    public static String inputTypeString(String title){
        Scanner input = new Scanner(System.in);
        System.out.print(title);
        return input.nextLine();
    }
    public static Integer inputTypeInteger(String title){
        Scanner input = new Scanner(System.in);
        System.out.print(title);
        return input.nextInt();

    }
}
