
import javax.swing.JOptionPane;

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
        String expression = JOptionPane.showInputDialog("Enter an expression containing parenthesis");
        if(ParenChecker.isBalanced(expression)) {
            JOptionPane.showMessageDialog(null, expression + " is balanced");
        }
        else {
            JOptionPane.showMessageDialog(null, expression + " is not balanced");
        }
        System.exit(0);
    }
    
}
