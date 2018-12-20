public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super();
        System.out.println("Please check your password");
    }

    @Override
    public String getMessage() {
        return "Wrong password";
    }

    @Override
    public String getLocalizedMessage() {
        return "Please check inputted password";
    }
}
