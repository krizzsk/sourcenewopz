package didihttp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

public interface LogEventListener {

    public interface Factory {
        LogEventListener create(Call call);
    }

    void callEnd(Call call);

    void callFailed(Call call, Throwable th);

    void callStart(Call call, int i);

    void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol);

    void connectFail(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException);

    void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy);

    void connectionAcquired(Call call);

    void connectionReleased(Call call);

    void dnsEnd(Call call, String str, List<InetAddress> list);

    void dnsFailed(Call call, String str, IOException iOException);

    void dnsStart(Call call, String str);

    void enqueue(Call call);

    void interceptorEnd(Call call, Object obj);

    void interceptorStart(Call call, Object obj);

    void receiveResponse(Call call);

    void redirect(Call call);

    void retry(Call call, Throwable th);

    void tlsConnectEnd(Call call, Handshake handshake);

    void tlsConnectStart(Call call);

    void transEnd(Call call);

    void transFail(Call call, Throwable th);

    void transStart(Call call);

    void useHttpDns(Call call, boolean z);
}
