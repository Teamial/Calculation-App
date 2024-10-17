import java.util.ArrayList;
import java.util.Scanner;

public class MyCalculator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // For user input
        double answer; // For calculation result
        String operation, userNums, continueC; // Calculation operation, user problem numbers, continue calculation flag

        System.out.println("Enter your calculation mode: [1] Standard [2] Scientific");
        int mode = scnr.nextInt(); // The user enters a number which is stored in mode.
        
        while (mode != 1 && mode != 2) {
            System.out.println("Invalid calculation mode, try again.");
            System.out.println("Enter your calculation mode: [1] Standard [2] Scientific");
            mode = scnr.nextInt(); // Continues to prompt the user until a valid calculation mode is entered.
        }

        switch (mode) {
            case 1: // Executes the block for Standard mode
                System.out.println("Options: \n[+] Addition\n[-] Subtraction\n[*] Multiplication\n[/] Division\nPick one: ");
                operation = scnr.next(); // The user enters their chosen operator, stored in operation.

                // Validate operator
                while (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
                    System.out.println("Invalid operator, try again.");
                    System.out.println("Options: \n[+] Addition\n[-] Subtraction\n[*] Multiplication\n[/] Division\nPick one: ");
                    operation = scnr.next(); // Continues to prompt the user until a valid operator is entered.
                }

                // Input numbers
                System.out.println("How many numbers do you want to input?: "); // Asks how many numbers the user wants to calculate with.
                int numValues = scnr.nextInt(); // The user enters the number of values
                System.out.println("Input " + numValues + " numbers now (separated by spaces): ");
                scnr.nextLine(); // Clear the buffer
                userNums = scnr.nextLine(); // Users enter the numbers separated by spaces to represent math problem such as: "1 1 1" 

                // Parse numbers
                ArrayList<Double> numbers = new ArrayList<>(); // Stores the numbers entered by the user.
                Scanner inSS = new Scanner(userNums); // A second scanner that parses the userNums string to individual numbers
                while (inSS.hasNextDouble()) {   // While there's another double in the userNums it loops and adds the number to the array list
                    numbers.add(inSS.nextDouble()); 
                } 

                if (numbers.size() < 1) { // Validate if numbers were entered.
                    System.out.println("No numbers entered.");
                    break;
                }

                // Initialize answer with the first number
                answer = numbers.get(0);

                // Goes through each subsequent number and applies the chosen operation.
                for (int i = 1; i < numbers.size(); i++) {
                    double currentNumber = numbers.get(i);
                    switch (operation) {
                        case "+":
                            answer += currentNumber;
                            break;
                        case "-":
                            answer -= currentNumber;
                            break;
                        case "*":
                            answer *= currentNumber;
                            break;
                        case "/":
                            if (currentNumber != 0) {
                                answer /= currentNumber;
                            } else {
                                System.out.println("Error: Division by 0");
                                return;
                            }
                            break;
                        default:
                            System.out.println("Invalid operator");
                            return;
                    }
                }

                // Show final result of calculation
                System.out.println("Result: " + answer);
                break;

            case 2: // Executes the block for Scientific mode.
                System.out.println("Options: \n[+] Addition\n[-] Subtraction\n[*] Multiplication\n[/] Division\n[sin] Sine\n[cos] Cosine\n[tan] Tangent\n[sqrt] Square Root\n[^] Power\nPick one: ");
                operation = scnr.next();

                // Validate operator
                while (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/") &&
                       !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") &&
                       !operation.equalsIgnoreCase("tan") && !operation.equalsIgnoreCase("sqrt") &&
                       !operation.equals("^")) { 
                    System.out.println("Invalid operator, try again.");
                    System.out.println("Options: \n[+] Addition\n[-] Subtraction\n[*] Multiplication\n[/] Division\n[sin] Sine\n[cos] Cosine\n[tan] Tangent\n[sqrt] Square Root\n[^] Power\nPick one: ");
                    operation = scnr.next(); // Continues to prompt the user until a valid operator is entered.
                }

                switch (operation.toLowerCase()) { // Performing scientific calculation
                    case "sin":
                        System.out.println("Input the angle in degrees: ");
                        double angleSin = scnr.nextDouble(); // Declaring doubles for angle inputs
                        answer = Math.sin(Math.toRadians(angleSin)); // Using the Math Class for trigonometric calculations of user's angle input
                        break;
                    case "cos":
                        System.out.println("Input the angle in degrees: ");
                        double angleCos = scnr.nextDouble();
                        answer = Math.cos(Math.toRadians(angleCos));
                        break;
                    case "tan":
                        System.out.println("Input the angle in degrees: ");
                        double angleTan = scnr.nextDouble();
                        answer = Math.tan(Math.toRadians(angleTan));
                        break;
                    case "sqrt":
                        System.out.println("Input the number: ");
                        double numSqrt = scnr.nextDouble();
                        if (numSqrt >= 0) {
                            answer = Math.sqrt(numSqrt);
                        } else {
                            System.out.println("Error: Square root of a negative number"); // Calculates square root of numSqrt if it's non-negative. If negative it prints an error.
                            return;
                        }
                        break;
                    case "^":
                        System.out.println("Input the base number: ");
                        double base = scnr.nextDouble();
                        System.out.println("Input the exponent: ");
                        double exponent = scnr.nextDouble();
                        answer = Math.pow(base, exponent);
                        break;
                    case "+": 
                    case "-":
                    case "*":
                    case "/":
                        // For basic arithmetic in scientific mode
                        System.out.println("How many numbers do you want to input?: ");
                        numValues = scnr.nextInt();
                        System.out.println("Input " + numValues + " numbers now (separated by spaces): ");
                        scnr.nextLine(); // Clear the buffer
                        userNums = scnr.nextLine();

                        // Parse numbers
                        numbers = new ArrayList<>();
                        inSS = new Scanner(userNums);
                        while (inSS.hasNextDouble()) {
                            numbers.add(inSS.nextDouble());
                        }

                        if (numbers.size() < 1) {
                            System.out.println("No numbers entered.");
                            return;
                        }

                        // Initialize answer with the first number
                        answer = numbers.get(0);

                        // Perform calculation based on operator
                        for (int i = 1; i < numbers.size(); i++) {
                            double currentNumber = numbers.get(i);
                            switch (operation) {
                                case "+":
                                    answer += currentNumber;
                                    break;
                                case "-":
                                    answer -= currentNumber;
                                    break;
                                case "*":
                                    answer *= currentNumber;
                                    break;
                                case "/":
                                    if (currentNumber != 0) {
                                        answer /= currentNumber;
                                    } else {
                                        System.out.println("Error: Division by 0");
                                        break;
                                    }
                                    break;
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid operator");
                        return;
                }

                // Output result
                System.out.println("Result: " + answer);
                break;

            default:
                System.out.println("Invalid mode selected.");
                break;
        }
        System.out.println("Continue? (Y/N): "); // Ask the user if they want to continue.
    	continueC = scnr.nextLine(); // User inputs yes for continuation
    	
        if (continueC.equalsIgnoreCase("Y")) {
        	main(args); // Restart the program if yes.
        } 
        if (continueC.equalsIgnoreCase("N")) {
        	System.out.println("Calculator closed."); // If user enters "no" the program ends.
        	scnr.close(); // Close the scanner
        	
        } 
    }
}
