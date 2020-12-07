package sec03.exam02_console;

import java.io.Console;

public class ConsoleExample {
    public static void main(String[] args) {
        Console console = System.console();

        System.out.print("ID: ");
        String id = console.readLine();

        System.out.print("PW: ");
        char[] charPW = console.readPassword();
        String pw = new String(charPW);

        System.out.println("----------------------");
        System.out.println(id);
        System.out.println(pw);
    }
}
