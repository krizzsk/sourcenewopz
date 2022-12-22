package didihttp.internal.http;

import com.google.common.net.HttpHeaders;
import didihttp.Call;
import didihttp.Interceptor;
import didihttp.LogEventListener;
import didihttp.Request;
import didihttp.Response;
import didihttp.ServerCallItem;
import didihttp.StatisticalContext;
import didihttp.internal.C20747Util;
import didihttp.internal.connection.RealConnection;
import didihttp.internal.connection.StreamAllocation;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSink;
import okio.Okio;

public final class CallServerInterceptor implements Interceptor {

    /* renamed from: a */
    private final boolean f56695a;

    public CallServerInterceptor(boolean z) {
        this.f56695a = z;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        HttpCodec httpStream = realInterceptorChain.httpStream();
        ServerCallItem currentServerCallData = ((StatisticalContext) realInterceptorChain.getExtraData()).currentServerCallData();
        RealConnection realConnection = (RealConnection) chain.connection();
        realConnection.resetFlowsStream();
        StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        Request request = chain.request();
        long currentTimeMillis = System.currentTimeMillis();
        Call call = realInterceptorChain.call();
        LogEventListener logEventListener = realInterceptorChain.logEventListener();
        if (currentServerCallData != null) {
            currentServerCallData.traceRequestSendStart();
        }
        httpStream.writeRequestHeaders(request);
        Response.Builder builder = null;
        if (HttpMethod.permitsRequestBody(request.method()) && request.body() != null) {
            if ("100-continue".equalsIgnoreCase(request.header(HttpHeaders.EXPECT))) {
                httpStream.flushRequest();
                builder = httpStream.readResponseHeaders(true);
            }
            if (builder == null) {
                BufferedSink buffer = Okio.buffer(httpStream.createRequestBody(request, request.body().contentLength()));
                request.body().writeTo(buffer);
                buffer.close();
            }
        }
        httpStream.finishRequest();
        if (currentServerCallData != null) {
            currentServerCallData.traceRequestSendEnd();
            currentServerCallData.setSinkCount(realConnection.getSinkCount());
        }
        if (currentServerCallData != null) {
            currentServerCallData.traceResponseReceiveStart();
        }
        if (builder == null) {
            builder = httpStream.readResponseHeaders(false);
        }
        Response build = builder.request(request).handshake(streamAllocation.connection().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build.code();
        if (!this.f56695a || code != 101) {
            response = build.newBuilder().body(httpStream.openResponseBody(build)).build();
        } else {
            response = build.newBuilder().body(C20747Util.EMPTY_RESPONSE).build();
        }
        if (currentServerCallData != null) {
            currentServerCallData.traceResponseReceiveEnd();
            currentServerCallData.setSourceCount(realConnection.getSourceCount());
        }
        logEventListener.receiveResponse(call);
        if ("close".equalsIgnoreCase(response.request().header(HttpHeaders.CONNECTION)) || "close".equalsIgnoreCase(response.header(HttpHeaders.CONNECTION))) {
            streamAllocation.noNewStreams();
            if (currentServerCallData != null) {
                currentServerCallData.setCloseConnection(true);
            }
        }
        if ((code != 204 && code != 205) || response.body().contentLength() <= 0) {
            return response;
        }
        throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + response.body().contentLength());
    }
}
