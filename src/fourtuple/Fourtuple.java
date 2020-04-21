/*
 * Amer Stas
 * 20/4/2020
 * This program starts with a four-tuple of nonnegative integers (a,b,c,d) and that repeatedly apply this rule:
 (a,b,c,d) will change into (|a−b|,|b−c|,|c−d|,|d−a|)
 */
package fourtuple;

/**
 *
 * @author canada
 */
import java.util.ArrayList;
import javax.swing.*;

public class Fourtuple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Asking the user to input their numbers
        int number1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the first number"));
        int number2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the second number"));
        int number3 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the third number"));
        int number4 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the fourth number"));
        // making sure the user are not inputting negative numbers 
        if (number1 < 0 || number2 < 0 || number3 < 0 || number4 < 0) {
            System.out.println("Please do not enter negative numbers");
        }
        // Creating a static array for the new variables
        ArrayList<Integer> numberss = new ArrayList();
        numberss.add(0, number1);
        numberss.add(1, number2);
        numberss.add(2, number3);
        numberss.add(3, number4);
        numberss.add(0);// Zero have been added to track the number of steps
        change(numberss);// calling the method
        // removing the step counter from the output
        String output = numberss.toString().substring(1, numberss.toString().length() - 4);
        // outputting the results to the screen
        System.out.println("the number of recusion is " + numberss.get(4) + "(" + output + ")");
    }

    public static ArrayList<Integer> change(ArrayList<Integer> numberss) {
        // Matching the varibales  to the input by the user
        int num1 = numberss.get(0);
        int num2 = numberss.get(1);
        int num3 = numberss.get(2);
        int num4 = numberss.get(3);
        // Recursive method: if one of the numbers reaches 0, the method will stop 
        if (num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0) {
            return numberss;
        } else {
            // making each new number as the absoulute value of the diffrence between itself and the number after 
            numberss.set(0, Math.abs(num1 - num2));
            numberss.set(1, Math.abs(num2 - num3));
            numberss.set(2, Math.abs(num3 - num4));
            numberss.set(3, Math.abs(num4 - num1));
            numberss.set(4, numberss.get(4) + 1);// keeping track of the number of steps
            return change(numberss);
        }
    }
}
