package in.ems.ui;

public class ConsoleUI {

    public static void header(String title) {
        System.out.println("\n==================================================");
        System.out.println("   " + title);
        System.out.println("==================================================\n");
    }

    public static void subHeader(String title) {
        System.out.println("\n---------------- " + title + " ----------------\n");
    }

    public static void menuItem(int number, String text) {
        System.out.printf("   [%d] %s%n", number, text);
    }

    public static void success(String message) {
        System.out.println("\n ✔ " + message);
    }

    public static void error(String message) {
        System.out.println("\n ✖ " + message);
    }

    public static void info(String message) {
        System.out.println("\n ℹ " + message);
    }

    public static void line() {
        System.out.println("--------------------------------------------------");
    }
}
