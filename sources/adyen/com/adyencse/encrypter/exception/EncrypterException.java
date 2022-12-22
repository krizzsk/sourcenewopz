package adyen.com.adyencse.encrypter.exception;

public class EncrypterException extends Exception {
    private static final long serialVersionUID = 2699577096011945291L;

    public EncrypterException(String str, Throwable th) {
        super(str, th);
    }
}
