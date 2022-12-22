package didihttp.internal.connection;

import android.text.TextUtils;
import didihttp.Call;
import didihttp.DidiHttpClient;
import didihttp.Interceptor;
import didihttp.LogEventListener;
import didihttp.Request;
import didihttp.Response;
import didihttp.Route;
import didihttp.ServerCallItem;
import didihttp.StatisticalContext;
import didihttp.internal.http.HttpCodec;
import didihttp.internal.http.RealInterceptorChain;
import didihttp.internal.trace.IdGenrator;
import didinet.NetEngine;
import diditransreq.Http2SocketParam;
import java.io.IOException;
import java.net.Socket;

public final class ConnectInterceptor implements Interceptor {
    public final DidiHttpClient client;

    public ConnectInterceptor(DidiHttpClient didiHttpClient) {
        this.client = didiHttpClient;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request();
        StatisticalContext statisticalContext = (StatisticalContext) realInterceptorChain.getExtraData();
        ServerCallItem currentServerCallData = statisticalContext.currentServerCallData();
        currentServerCallData.setBootStatus(NetEngine.getInstance().getBootStatus());
        Request.Builder newBuilder = request.newBuilder();
        Call call = realInterceptorChain.call();
        LogEventListener logEventListener = realInterceptorChain.logEventListener();
        boolean z = statisticalContext.getCustomDns() != null;
        currentServerCallData.setUseHttpDns(z);
        logEventListener.useHttpDns(call, z);
        if (z) {
            newBuilder.header("_ddns_", "1");
            request = newBuilder.build();
        }
        StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        HttpCodec newStream = streamAllocation.newStream(this.client, !request.method().equals("GET"), currentServerCallData);
        RealConnection connection = streamAllocation.connection();
        Socket socket = connection.socket();
        currentServerCallData.setSocket(socket);
        currentServerCallData.setProtocol(connection.protocol());
        currentServerCallData.setHandShake(connection.handshake());
        Route route = connection.route();
        if (route != null) {
            currentServerCallData.setProxy(route.proxy());
        }
        int updateTid = Http2SocketParam.getParam().getUpdateTid();
        int retryCount = statisticalContext.getRetryCount();
        if (TextUtils.isEmpty(request.header("didi-header-rid")) || (updateTid == 1 && retryCount > 0)) {
            Request.Builder newBuilder2 = request.newBuilder();
            newBuilder2.addHeader("didi-header-rid", IdGenrator.generate(socket != null ? socket.getLocalAddress() : null));
            request = newBuilder2.build();
        }
        currentServerCallData.setRequest(request);
        Response proceed = realInterceptorChain.proceed(request, streamAllocation, newStream, connection);
        ServerCallItem currentServerCallData2 = statisticalContext.currentServerCallData();
        currentServerCallData2.traceEnd();
        currentServerCallData2.setResponse(proceed);
        return proceed;
    }
}
