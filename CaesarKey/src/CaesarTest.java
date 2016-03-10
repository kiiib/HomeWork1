/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jianbin Liu
 */
import java.util.Scanner;

public class CaesarTest {
    public static void main(String args[])
    {
        Caesar caesarPassword = new Caesar();   //create caesar
        
        //create Scanner to obtain plain text from command window 
        System.out.print("Plaintext: ");
        Scanner inputPlainText = new Scanner(System.in);
        //set plain text, if upper than change to lower
        caesarPassword.setplainText(inputPlainText.next().toLowerCase());

        //create Scanner to obtain key from command window 
        System.out.print("Key: ");
        Scanner inputKey = new Scanner(System.in);
        //set cipher text
        caesarPassword.setKey(inputKey.nextInt());
        
        caesarPassword.handlePassword();
        String CipherText = "CipherText: %s\n";
        System.out.printf(CipherText,caesarPassword.getCipherText());
        
    }
}
