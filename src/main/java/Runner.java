import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        NumeralConverter numConverter = new NumeralConverter();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Please enter a number to convert (1-999): ");
        System.out.println("(Enter 0 to quit.)");

        while(running) {
            Integer number = scanner.nextInt();
            if(number.equals(0)){
                running = false;
            } else {
                String conversion = numConverter.conversionManager(number);
                System.out.println(number + " converted to Roman numerals is " + conversion);
            }
        }
    }
}
