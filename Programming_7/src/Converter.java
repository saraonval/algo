
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saraonval
 */
public class Converter {

    public static class SyntaxErrorException extends Exception {

        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private StringBuilder postFix;
    private static final String OPERATORS = "+-*/()";
    private Stack<Character> operatorStack;
    private Stack<Integer> stack;

    private int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};

    public String convert(String infix) throws SyntaxErrorException {
        this.postFix = new StringBuilder();
        this.operatorStack = new Stack();
        //String[] tokens = infix.split(" +");
        try {
            String nextToken;
            Scanner scan = new Scanner(infix);
            while ((nextToken = scan.findInLine("[\\p{L}\\p{N}]+|[-+/\\*()]")) != null) {
                char firstChar = nextToken.charAt(0);
                if (Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar)) {
                    postFix.append(nextToken);
                    postFix.append(' ');
                } else if (isOperator(firstChar)) {
                    processOperator(firstChar);
                } else {
                    throw new SyntaxErrorException("Invalid character encountred: " + firstChar);
                }
            }
            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                if (op == '(') {
                    throw new SyntaxErrorException("Unmatched opening parenthesis");
                }
                postFix.append(op);
                postFix.append(' ');
            }
            return postFix.toString();
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    private int evalOp(char op) {
        //hit skickar vi en operator den ska nu utföras på de två översta talen på stacken som ska tas bort. 
        //Sedan ska resultatet upp på stacken
        int digit1 = stack.pop();
        int digit2 = stack.pop();
        int result = 0;
        
        switch (op) {
            case '+':
                result = digit1 + digit2;
                break;
            case '-':
                result = digit1 - digit2;
                break;
            case '*':
                result = digit1 * digit2;
                break;
            case '/':
                result = digit1 / digit2;
                break;
            default:
                break;
        }
        
        return result;
    }
    
    public int eval(String expression) throws SyntaxErrorException {

        // Skapa en stack för denna beräkning
        stack = new Stack<>();
        String[] tokens = expression.split(" +"); // Delar upp strängen vid mellanslag

        try {
            for (String nextToken : tokens) {

                if (Character.isDigit(nextToken.charAt(0))) {
                    // Det kommer ett tal
                    // Använd Integer.parseInt(nextToken) och lägg det på stacken
                    stack.push(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {
                    // Det kommer en operator
                    // Anropa evalOp för att göra beräkningen med operatorn
                    int result = evalOp(nextToken.charAt(0));
                    stack.push(result);
                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }

            }
        } // Vi har läst hela uttrycket och gjort alla beräkningar
        // Dags att ta ut svaret som borde vara det enda som är kvar på stacken
        // Om stacken inte är tom, kasta ett syntax error annars returnera resultatet
        catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }

        int result = stack.pop();

        if (stack.empty()) {
            return result;
        } else {
            throw new SyntaxErrorException("Syntax Error: The stack should be empty");
        }
    }

    private void processOperator(char op) {
        if (operatorStack.empty() || op == '(') {
            operatorStack.push(op);
        } else {
            char topOp = operatorStack.peek();
            if (precendence(op) > precendence(topOp)) {
                operatorStack.push(op);
            } else {
                while (!operatorStack.empty() && precendence(op) <= precendence(topOp)) {
                    operatorStack.pop();
                    if (topOp == '(') {
                        break;
                    }
                    postFix.append(topOp);
                    postFix.append(' ');
                    if (!operatorStack.empty()) {
                        topOp = operatorStack.peek();
                    }
                }
                if (op != ')') {
                    operatorStack.push(op);
                }
            }
        }
    }

    public boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    private int precendence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

}
