package didihttp.internal.connection;

import java.io.IOException;

public class RouteExException extends RouteException {
    public RouteExException(IOException iOException) {
        super(iOException);
    }
}
