package ni.edu.nicamazon.infrastructure.error;

public class NicamazonGeneralException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NicamazonGeneralException() {
        super();
    }

    public NicamazonGeneralException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public NicamazonGeneralException(String arg0) {
        super(arg0);
    }

    public static Throwable getCausaOriginal(Throwable throwable){
        if (throwable == null) {
            return null;
        }

        int max = 10;

        while (throwable.getCause()!=null){
            throwable = throwable.getCause();
            max--;

            if (max <= 0) {
                break;
            }
        }

        return throwable;
    }
}
