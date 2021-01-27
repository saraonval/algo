
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author saraonval
 */
public class TestEvaluator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        InfixToPostfixParens translator = new InfixToPostfixParens();
        
        String line;
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a postfix expression to evaluate");
            line = in.nextLine();
            if(!line.equals("")) {
                try {
                    //String result = translator.convert(line);
                    int result = evaluator.eval(translator.convert(line));
                    System.out.println("Value is " + result);
                }
                catch(InfixToPostfixParens.SyntaxErrorException | PostfixEvaluator.SyntaxErrorException ex) {
                    System.out.println("Syntax error " + ex.getMessage());
                }
            }
            else {
                break;
            }
        }
        
    }
    
}
