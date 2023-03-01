package check;

import Excecution.WrongLoginException;
import Excecution.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    //проверка на использование символов логина
    public static void checkRightEnterLogin(String login){
        Pattern pt = Pattern.compile("^[aA-zZ(0-9)\\.]*$");
        Matcher mt = pt.matcher(login);
        if(!mt.matches()){
            throw new WrongLoginException();
        }
    }
    //проверка на использование символов логина
    public static void checkRightEnterPassword(String password){
        Pattern pt = Pattern.compile("^[aA-zZ(0-9)\\-\\_]*$");
        Matcher mt = pt.matcher(password);
        if(!mt.matches()){
            throw new WrongLoginException();
        }
    }
    //проверка на кол-во символов
    public static void checkLog(String log){
        if (log.length() >= 20 ){
            throw new WrongLoginException();
        }
    }
    //проверка на кол-во символов
    public static void checkPass(String password){
        if(password.length() > 20){
            throw new WrongPasswordException();
        }
    }

    //проверка на совпадение
    public static void checkPassConfirm(String password, String passwordConfirm){
        if(!password.equals(passwordConfirm)){
            throw new WrongPasswordException();
        }
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
