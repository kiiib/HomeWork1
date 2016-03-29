/**
 * Created by Jianbin Liu on 3/29/2016.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Detector {

    /**
     * the match function
     * @param str string
     */
    public void match(String str){
        System.out.println("Email: " + matchEmailFrequency(str));
        System.out.println("PhoneNumber: " + matchPhoneNumberFrequency(str));
        System.out.println("PersonalID: " + matchIdFrequency(str) + "\n");
        System.out.println("TotalItems:");
        matchEmailItem(str);
        matchPhoneNumberItem(str);
        matchIdNumberItem(str);
    }

    /**
     * How many times are the phone number appearance
     * @param str the string
     * @return int
     */
    public int matchPhoneNumberFrequency(String str){
        Pattern pattern = Pattern.compile("[0]{1}[0-9]{9}");
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while(matcher.find()){
            i++;
        }
        return i;
    }

    /**
     * output the phone number item in the string
     * @param str string
     */
    public void matchPhoneNumberItem(String str){
        Pattern pattern = Pattern.compile("[0]{1}[0-9]{9}");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    /**
     * How many times are the email appearance
     * @param str the string
     * @return int
     */
    public int matchEmailFrequency(String str){
        String check = "([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while(matcher.find()){
            i++;
        }
        return i;
    }

    /**
     * output the email item in the string
     * @param str string
     */
    public void matchEmailItem(String str){
        String check = "([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    /**
     * How many times are the id number appearance
     * @param str the string
     * @return int
     */
    public int matchIdFrequency(String str){
        Pattern pattern = Pattern.compile("[A-Z]{1}[1-2]{1}[0-9]{8}");
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while(matcher.find()){
            i++;
        }
        return i;
    }

    /**
     * output the Id number in the string
     * @param str string
     */
    public void matchIdNumberItem(String str){
        Pattern pattern = Pattern.compile("[A-Z]{1}[1-2]{1}[0-9]{8}");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
