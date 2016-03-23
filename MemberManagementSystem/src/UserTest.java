/**
 * Created by Jianbin Liu on 3/23/2016.
 */
public class UserTest {
    public static void main(String args[]){
        User newUser = new User();
        newUser.createAccount();
        newUser.login();
        newUser.setInfo();
        newUser.showInfo();
    }
}
