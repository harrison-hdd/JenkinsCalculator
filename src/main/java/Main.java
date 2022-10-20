import java.io.*;

public class Main {
    public static void main(String[] args) {
        while(true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String commandLine = reader.readLine();

                String[] arguments = commandLine.split("\\s+");

//                if(arguments[0].equalsIgnoreCase("exit")) return;

                calculate(arguments);

            } catch (Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        }
    }

    private static void calculate(String[] args){

        String command = args[0];
        Calculator calculator = new Calculator();

        String res;

        if (command.equalsIgnoreCase("add") ||
                command.equalsIgnoreCase("subtract") ||
                command.equalsIgnoreCase("divide") ||
                command.equalsIgnoreCase("multiply")) {

            if (args.length < 3) {
                System.out.println("Usage: " + command + " a b");
                return;
            }
            int a = Integer.parseInt(args[1]);
            int b = Integer.parseInt(args[2]);


            if (command.equalsIgnoreCase("add")) res = String.valueOf(calculator.add(a, b));
            else if (command.equalsIgnoreCase("subtract")) res = String.valueOf(calculator.subtract(a, b));
            else if (command.equalsIgnoreCase("multiply")) res = String.valueOf(calculator.multiply(a, b));
            else res = String.valueOf(calculator.divide(a, b));
        } else if (command.equalsIgnoreCase("fibonacci") ||
                command.equalsIgnoreCase("binary")) {
            if (args.length < 2) {
                System.out.println("Usage: " + command + " n");
                return;
            }

            int n = Integer.parseInt(args[1]);

            if (command.equalsIgnoreCase("fibonacci")) res = String.valueOf(calculator.fibonacciNumberFinder(n));
            else res = calculator.intToBinaryNumber(n);

        } else {
            System.out.println("Command not found!");
            return;
        }

        System.out.println(res);

    }
}
