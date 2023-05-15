import java.util.Scanner;
public class Calculator {
    private double currentValue;
    private double previousValue;
    private char operator;

    public void setOperator(char op) {
        operator = op;
    }
    public double add(double operand1, double operand2) {
        return operand1 + operand2;
    }

    public double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    public double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

    public double divide(double operand1, double operand2) {
        return operand1 / operand2;
    }

    public double power(double operand1, double operand2) {
        return Math.pow(operand1, operand2);
    }
    public void updateCurrentValue(String input) {
        double value = Double.parseDouble(input);
        currentValue = value;
    }

    public void updatePreviousValue() {
        previousValue = currentValue;
        currentValue = 0;
    }

    public void performCalculation() {
        switch(operator) {
            case '+':
                currentValue = add(previousValue, currentValue);
                break;
            case '-':
                currentValue = subtract(previousValue, currentValue);
                break;
            case '*':
                currentValue = multiply(previousValue, currentValue);
                break;
            case '/':
                currentValue = divide(previousValue, currentValue);
                break;
            case '^':
                currentValue = power(previousValue, currentValue);
                break;
        }
    }

    public void reset() {
        currentValue = 0;
        previousValue = 0;
        operator = '\0';
    }

    public void displayCurrentValue() {
        System.out.println(currentValue);
    }

    public void startCalculator(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running) {
            String input = scanner.next();

            switch(input) {
                case "c":
                    reset();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                    updatePreviousValue();
                    setOperator(input.charAt(0));
                    break;
                case "=":
                    performCalculation();
                    displayCurrentValue();
                    break;
                case "q":
                    running = false;
                    break;
                default:
                    updateCurrentValue(input);
                    break;
            }
        }

        scanner.close();
    }
}
