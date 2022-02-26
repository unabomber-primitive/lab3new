package heroes;

public class IncorrectSexExcepion extends Exception{
    public IncorrectSexExcepion() {
        super();
    }
    public IncorrectSexExcepion(String message) {
        super(message);
    }
    public IncorrectSexExcepion(String message, Throwable cause) {
        super(message, cause);
    }
    public IncorrectSexExcepion(Throwable cause) {
        super(cause);
    }
    protected IncorrectSexExcepion(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
