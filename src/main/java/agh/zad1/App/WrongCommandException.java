package agh.zad1.App;

public class WrongCommandException extends Exception{
    public WrongCommandException(String errorMessage) {
        super(errorMessage);
    }

}
