package calculator;
import java.util.*;

public class calculator_application {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Expression:");
        String input = sc.nextLine();
        System.out.println(input+"="+splitting(input)); 
        sc.close();
    }
    static double applyOp(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
    public static int splitting(String input){
        Stack<Double> numbers=new Stack<>();
        Stack<Character> operator=new Stack<>();
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            char temp=' ';
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                // collect full number (includes decimals)
                while (i < input.length() && 
                      (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.')) {
                    sb.append(input.charAt(i));
                    i++;
                }
                numbers.push(Double.parseDouble(sb.toString()));
                i--; // adjust index
            }
            else if (ch == '(') {
                operator.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {
                while (operator.peek() != '(') {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = operator.pop();
                    numbers.push(applyOp(a, b, op));
                }
                operator.pop(); // remove '('
            }

            // Operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = operator.pop();
                    numbers.push(applyOp(a, b, op));
                }
                operator.push(ch);
            }
        }

        
        while (!operator.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char op = operator.pop();
            numbers.push(applyOp(a, b, op));
        }
        return numbers.pop().intValue();

       
        }
}
    


