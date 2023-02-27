package check;

import Excecution.WrongLoginException;
import Excecution.WrongPasswordException;

public class Check {
    public void checkLog(String log){
        if (log.length() >= 20 ){
            throw new WrongLoginException();
        }
    }
    public void checkPass(String password){
        if(password.length() > 20){
            throw new WrongPasswordException();
        }
    }
    public void checkPassConfirm(String password, String passwordConfirm){
        if(!password.equals(passwordConfirm)){
            throw new WrongPasswordException();
        }
    }

}
