import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("1) Install hard drives");
        System.out.println("2) List drives");
        System.out.println("3) Create physical volumes");
        System.out.println("4) List physical volumes");
        System.out.println("5) Create and extend volume groups");
        System.out.println("6) List volume groups");
        System.out.println("7) Create logical volumes");
        System.out.println("8) List logical volumes");
        System.out.println("9) Exit");
        System.out.println("Choose a number:");
        Control s = new Control();
        Scanner user = new Scanner(System.in);
        String input = user.next();
        while(!input.equals("9")) {
            s.start(input);
            System.out.println("1) Install hard drives");
            System.out.println("2) List drives");
            System.out.println("3) Create physical volumes");
            System.out.println("4) List physical volumes");
            System.out.println("5) Create and extend volume groups");
            System.out.println("6) List volume groups");
            System.out.println("7) Create logical volumes");
            System.out.println("8) List logical volumes");
            System.out.println("9) Exit");
            System.out.println("Choose a number:");
            user = new Scanner(System.in);
            input = user.next();
        }
    }
}
