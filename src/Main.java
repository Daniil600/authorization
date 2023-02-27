import Excecution.WrongLoginException;
import Excecution.WrongPasswordException;
import check.Check;

public class Main {
    public static void main(String[] args) {
        authorization("java_skypro.go","D_1hWiKjjP_9", "D_1hWiKjjP_9");
    }

    public static boolean authorization(String login, String password, String confirmPassword) {
        Check check = new Check();
        try {
            check.checkLog(login);
        } catch (WrongLoginException e) {
            System.out.println("login error");
            return false;
        }
        try {
            check.checkPass(password);
        } catch (WrongPasswordException e) {
            System.out.println("the password is small");
            return false;
        }
        try {
            check.checkPassConfirm(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println("password does not match");
            return false;
        }


        return true;
        }
}





