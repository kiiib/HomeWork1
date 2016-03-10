/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jianbin Liu
 */
public class Caesar {
    private String plainText; //plain text
    private String cipherText = "";   //cipher text
    private int key;    //offset
    //alphabet
    private String alphabet = new String("qwertyuiopasdfghjklzxcvbnm");
    //temp text, for store the text after handling
    //private String tempText;
    
    //method to set plain text
    public void setplainText(String text)
    {
        plainText = text; //store the plain text
    }   //end method setStudentName
    
    //method to retrieve the plain text
    public String getPlainText()
    {
        return plainText;
    }   //end method getPlainText
    
    //method to set cipher text
    public void setCipherText(String text)
    {
        cipherText = text; //store the cipher text
    }   //end method setCipherText
    
    //method to retrieve the cipher text
    public String getCipherText()
    {
        return cipherText;
    }   //end method getCipherText
    
    //method to set key
    public void setKey(int offset)
    {
        key = offset; //store the key
    }   //end method setKey
    
    //method to retrieve the key
    public int getKey()
    {
        return key;
    }   //end method getKey
    
    //method to get the alphabet
    public String getAlphabet()
    {
        return alphabet;
    }   //end method getAlphabet
    
    //this function for making the plain text become the cipher text
    public void handlePassword()
    {
        //travel each character
        for(int i = 0; i < plainText.length();i++)
        {
            //get the current character in the i's position
            char item = plainText.charAt(i);
            //find the character in the alphabet's position
            int position = alphabet.indexOf(item);
            //make the current character add the offset
            int offset = position + key;
            if(offset < 26)
            {
                cipherText += alphabet.charAt(offset);
            }else
            {
                //if offset bigger than 26, make offset minus 26
                cipherText +=alphabet.charAt(offset-26);
            }
        }
    }
}
