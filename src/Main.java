import Excecution.WrongLoginException;
import Excecution.WrongPasswordException;
import check.Check;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        authorization("java_skypro.go","21431-_4", "21431-_4");


    }

    public static boolean authorization(String login, String password, String confirmPassword) {
        try {
            Check.checkRightEnterLogin(login);
        }catch (WrongLoginException e){
            System.out.println("Неверно введён логин\nЛогин содержит в себе только латинские буквы, цифры и знак подчеркивания");
            return false;
        }
        try {
            Check.checkRightEnterPassword(password);
        }catch (WrongLoginException e){
            System.out.println("Неверно введен пароль\nПароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
            return false;
        }
        try {
            Check.checkLog(login);
        } catch (WrongLoginException e) {
            System.out.println("login error");
            return false;
        }
        try {
            Check.checkPass(password);
        } catch (WrongPasswordException e) {
            System.out.println("Пароль слошком длинный");
            return false;
        }
        try {
            Check.checkPassConfirm(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
            return false;
        }

        System.out.println("Авторизация прошла успешно!");
        return true;
        }
}





