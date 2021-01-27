
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saraonval
 */
public class InfixToPostfixParens {

public static class SyntaxErrorException extends Exception {

        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private StringBuilder postFix;
    private static final String OPERATORS = "+-*/()";
    private Stack<Character> operatorStack;
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
