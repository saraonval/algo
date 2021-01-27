
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
public class Test {
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Converter converter = new Converter();

        
        String line;
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a postfix expression to evaluate");
            line = in.nextLine();
            if(!line.equals("")) {
                try {
                    //String result = translator.convert(line);
                    int result = converter.eval(converter.convert(line));
                    System.out.println("Value is " + result);
                }
                catch(Converter.SyntaxErrorException ex) {
                    System.out.println("Syntax error " + ex.getMessage());
                }
            }
            else {
                break;
            }
        }
        
    }
    
}
