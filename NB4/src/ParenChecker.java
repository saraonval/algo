
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
public class ParenChecker {
    
    private static final String OPEN = "([{";
    private static final String CLOSE = ")]}";
    
    /**
     * Returns true if expression is balanced with respect to parentheses and false if it is not.
     * 
     * @param expression
     * @return 
     */
    public static boolean isBalanced(String expression) {
        
        Stack<Character> stack = new Stack<Character>();
        boolean balanced = true;
        
        try {
            int index = 0;
            while(balanced && index < expression.length()) {
                char ch = expression.charAt(index);
                if(isOpen(ch)) {
                    stack.push(ch);
                }
                else if(isClose(ch)) {
                    char top = stack.pop();
                    balanced = OPEN.indexOf(top) == CLOSE.indexOf(ch);
                }
                index++;
            }
        }
        
        catch (EmptyStackException ex) { 
            balanced = false;
        }
        
        return balanced && stack.empty();
    }
    
    private static boolean isOpen(char ch) {
        return OPEN.indexOf(ch) > -1;
    }
    
    private static boolean isClose(char ch) {
        return CLOSE.indexOf(ch) > -1;
    }
    
}
