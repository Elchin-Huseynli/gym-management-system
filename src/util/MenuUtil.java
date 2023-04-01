package util;

public class MenuUtil {
    public static Integer entry() {
        System.out.println(
                "\n----------| Gym Management System |----------\n" +
                        "0. exit\n" +
                        "1. Register gym member\n" +
                        "2. Show all members\n" +
                        "3. Enter the gym\n" +
                        "4. Update departures\n"
        );
        return InputUtil.inputTypeInteger("Choose the option: ");
    }
}
