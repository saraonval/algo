
import java.util.EmptyStackException;
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
public class PostfixEvaluator {
    
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }
    
    private static final String OPERATORS = "+-*/";
    
    private Stack<Integer> stack;
    
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
    
    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }
    
    public int eval(String expression) throws SyntaxErrorException {
        
        // Skapa en stack för denna beräkning
        stack = new Stack<>();
        String[] tokens = expression.split(" +"); // Delar upp strängen vid mellanslag
        
        try {
            for(String nextToken: tokens) {
                
                if(Character.isDigit(nextToken.charAt(0))) {
                    // Det kommer ett tal
                    // Använd Integer.parseInt(nextToken) och lägg det på stacken
                    stack.push(Integer.parseInt(nextToken));
                }
                
                else if(isOperator(nextToken.charAt(0))) {
                    // Det kommer en operator
                    // Anropa evalOp för att göra beräkningen med operatorn
                    int result = evalOp(nextToken.charAt(0));
                    stack.push(result);
                }
                
                else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
                
            }
        }
        
        // Vi har läst hela uttrycket och gjort alla beräkningar
        // Dags att ta ut svaret som borde vara det enda som är kvar på stacken
        // Om stacken inte är tom, kasta ett syntax error annars returnera resultatet
        
        catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
        
        int result = stack.pop();
        
        if(stack.empty()) {
            return result;
        }
        else {
            throw new SyntaxErrorException("Syntax Error: The stack should be empty");
        }
    }
    
}
