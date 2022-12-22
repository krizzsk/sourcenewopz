package diditransreq;

import java.io.IOException;

public class Http2SocketException extends IOException {
    public Http2SocketException() {
    }

    public Http2SocketException(String str) {
        super(str);
    }

    public Http2SocketException(String str, Throwable th) {
        super(str, th);
    }

    public Http2SocketException(Throwable th) {
        super(th);
    }
}
