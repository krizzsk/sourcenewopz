package p242io.socket.engineio.client;

/* renamed from: io.socket.engineio.client.EngineIOException */
public class EngineIOException extends Exception {
    public Object code;
    public String transport;

    public EngineIOException() {
    }

    public EngineIOException(String str) {
        super(str);
    }

    public EngineIOException(String str, Throwable th) {
        super(str, th);
    }

    public EngineIOException(Throwable th) {
        super(th);
    }
}
