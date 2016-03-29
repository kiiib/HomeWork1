import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jianbin Liu on 3/23/2016.
 */

public class User {
    private String userName;    // user's username
    private String password;    // user's password
    private boolean isNext = false;     // use this variable to judge if can go to next step
    private Console cons = System.console();
    private String name;    //user's name after set the information
    private String email;   //user's email after set the information
    private String phoneNumber; //user's phone number after set the information

    /**
     * createAccount: creating a account for user
     */
    public void createAccount(){
        char passwordArray[];

        do{
            System.out.println("********** Create an Account **********");
            userName = cons.readLine("Username: ");
            if(cons != null){
                passwordArray = cons.readPassword("Password: "); // the temp variable for the password
                password = new String(passwordArray);

            }else{
                //the readPassword only can run on the command line, so do this tips
                System.out.println("please run in the command line, do not run in the IDE");
            }
            if(cons != null){
                char confirmPwd[] = cons.readPassword("Confirm password: ");
                String pwd = new String(confirmPwd);

                //if the confirmPwd not equal to password or username and passwords' length < 6, unable to create account
                if(!pwd.equals(password) || userName.length() < 6 || password.length() < 6){
                    System.out.println("Unable to create account!");
                }else{
                    System.out.println("Account successfully created!");
                    isNext = true;
                }
            }else{
                //the readPassword only can run on the command line, so do this tips
                System.out.println("please run in the command line, do not run in the IDE");
            }
        }while (!isNext);
        isNext = false; // make the isNext variable change to false, for going to next step
    }

    /**
     * login: user login
     */
    public void login(){
        do{
            String inputUserName;   // user's inputted username
            char inputPwdArray[];    // user's inputted password
            System.out.println("********** Login Account **********");
            inputUserName = cons.readLine("Username: ");
            inputPwdArray = cons.readPassword("Password: ");
            String inputPwd = new String(inputPwdArray);    // change the variable's type
            if(inputUserName.equals(userName) && inputPwd.equals(password)){    // judge the input value
                System.out.println("Logged in successfully!");
                isNext = true;
            }else{
                System.out.println("Incorrect login!");
            }
        }while (!isNext);
        isNext = false; // make the isNext variable change to false, for going to next step
    }

    /**
     * setInfo: user set his information
     */
    public void setInfo(){
        do{
            isNext = true;  // when in the loop isNext must be reset to true in case the last value affect now
            System.out.println("********** Set User Data **********");
            name = cons.readLine("Name: ");
            email = cons.readLine("E-mail: ");
            phoneNumber = cons.readLine("Phone: ");

            if(!validateName(name)){
                System.out.println("Invalid Name Format!");
                isNext = false;
            }
            if(!validateEmail(email)){
                System.out.println("Invalid Email Format!");
                isNext = false;
            }
            if(!validatePhoneNumber(phoneNumber)){
                System.out.println("Invalid Phone Format!");
                isNext = false;
            }
        }while (!isNext);
    }

    /**
     * showInfo: show the user information
     */
    public void showInfo(){
        System.out.printf("********** %s's User Data **********\n",userName);
        System.out.printf("Name: %s\n",name);
        System.out.printf("E-mail: %s\n",email);
        System.out.printf("Phone: %s\n",phoneNumber);
    }

    /**
     * validateName: check the name formatting
     * @param name username
     * @return boolean
     */
    public boolean validateName(String name) {
        return name.matches("[a-zA-Z]*");   // name variable, only can be inputted character
    }

    /**
     * validateEmail: check the email formatting
     * @param email email
     * @return boolean
     */
    public boolean validateEmail(String email) {
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();   // email variable
    }

    /**
     * validatePhoneNumber: check the PhoneNumber formatting
     * @param phone PhoneNumber
     * @return boolean
     */
    public boolean validatePhoneNumber(String phone) {
        return phone.matches("[0-9]{4}-[0-9]{6}");   // phone number variable, only can be inputted character
    }

}
