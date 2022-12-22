package diditransreq;

import android.text.TextUtils;
import android.util.Log;
import didihttp.Call;
import didihttp.Interceptor;
import didihttp.LogEventListener;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.Response;
import didihttp.ServerCallItem;
import didihttp.StatisticalContext;
import didihttp.internal.http.RealInterceptorChain;
import didihttp.internal.trace.IdGenrator;
import didinet.Logger;
import didinet.NetEngine;
import java.io.IOException;
import java.net.InetAddress;

public class Http2SocketInterceptor implements Interceptor {

    /* renamed from: a */
    private static final String f57164a = "Http2Socket";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        return m40975a((RealInterceptorChain) chain);
    }

    /* renamed from: a */
    private Response m40975a(RealInterceptorChain realInterceptorChain) throws IOException {
        StatisticalContext statisticalContext = (StatisticalContext) realInterceptorChain.getExtraData();
        Request request = realInterceptorChain.request();
        String c = Http2SocketManager.m40982c(request.url().toString());
        ServerCallItem currentServerCallData = statisticalContext.currentServerCallData();
        currentServerCallData.setBootStatus(NetEngine.getInstance().getBootStatus());
        if (statisticalContext.getLonglinkState() != 1) {
            Logger.m40928d(f57164a, String.format("normal http request: %s", new Object[]{c}));
            return realInterceptorChain.proceed(request);
        }
        RealInterceptorChain realInterceptorChain2 = realInterceptorChain;
        Call call = realInterceptorChain.call();
        LogEventListener logEventListener = realInterceptorChain.logEventListener();
        logEventListener.transStart(call);
        int updateTid = Http2SocketParam.getParam().getUpdateTid();
        int retryCount = statisticalContext.getRetryCount();
        Response response = null;
        try {
            if (TextUtils.isEmpty(request.header("didi-header-rid")) || (updateTid == 1 && retryCount > 0)) {
                Request.Builder newBuilder = request.newBuilder();
                newBuilder.addHeader("didi-header-rid", IdGenrator.generate((InetAddress) null));
                request = newBuilder.build();
            }
            currentServerCallData.setRequest(request);
            currentServerCallData.setProtocol(Protocol.DIDI_LINK);
            response = Http2SocketManager.m40976a().mo170578a(request, statisticalContext, currentServerCallData);
        } catch (Throwable th) {
            logEventListener.transFail(call, th);
            statisticalContext.setTransDGCode(StatisticalContext.TransDGCode.TransReqDGRCodeTransError);
        }
        if (response == null) {
            if (statisticalContext.getLonglinkState() == 1) {
                statisticalContext.setLonglinkState(2);
                Logger.m40928d(f57164a, String.format("[%s] Transreq failed [%s]", new Object[]{f57164a, c}));
            }
            Logger.m40928d(f57164a, String.format("[%s] Downgrade to normal http(s) [%s]", new Object[]{f57164a, c}));
            Http2SocketException http2SocketException = new Http2SocketException();
            logEventListener.transFail(call, http2SocketException);
            throw http2SocketException;
        }
        try {
            if ("1".equals(request.header("use_trans"))) {
                Response.Builder newBuilder2 = response.newBuilder();
                newBuilder2.addHeader("use_trans", "1");
                response = newBuilder2.build();
            }
        } catch (Throwable th2) {
            Logger.m40928d(f57164a, "doLongLink: " + Log.getStackTraceString(th2));
        }
        currentServerCallData.setConnReused(true);
        currentServerCallData.traceEnd();
        currentServerCallData.setResponse(response);
        Logger.m40928d(f57164a, String.format("[%s] Transreq succeed [%s]", new Object[]{f57164a, c}));
        logEventListener.transEnd(call);
        logEventListener.receiveResponse(call);
        return response;
    }
}
