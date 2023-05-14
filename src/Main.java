import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running) {
            String input = scanner.next();

            switch(input) {
                case "c":
                    calculator.reset();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                    calculator.updatePreviousValue();
                    calculator.setOperator(input.charAt(0));
                    break;
                case "=":
                    calculator.performCalculation();
                    calculator.displayCurrentValue();
                    break;
                case "q":
                    running = false;
                    break;
                default:
                    calculator.updateCurrentValue(input);
                    break;
            }
        }

        scanner.close();

    }
}