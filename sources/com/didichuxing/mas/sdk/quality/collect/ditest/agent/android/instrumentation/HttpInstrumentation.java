package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Agent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.TaskQueue;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.httpclient.ResponseHandlerImpl;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public final class HttpInstrumentation {
    private HttpInstrumentation() {
    }

    public static URLConnection openConnection(URLConnection uRLConnection) {
        URLConnection httpURLConnectionExtension;
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return uRLConnection;
        }
        if (uRLConnection instanceof HttpsURLConnection) {
            httpURLConnectionExtension = new HttpsURLConnectionExtension((HttpsURLConnection) uRLConnection);
        } else if (!(uRLConnection instanceof HttpURLConnection)) {
            return uRLConnection;
        } else {
            httpURLConnectionExtension = new HttpURLConnectionExtension((HttpURLConnection) uRLConnection);
        }
        return httpURLConnectionExtension;
    }

    public static URLConnection openConnectionWithProxy(URLConnection uRLConnection) {
        URLConnection httpURLConnectionExtension;
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return uRLConnection;
        }
        if (uRLConnection instanceof HttpsURLConnection) {
            httpURLConnectionExtension = new HttpsURLConnectionExtension((HttpsURLConnection) uRLConnection);
        } else if (!(uRLConnection instanceof HttpURLConnection)) {
            return uRLConnection;
        } else {
            httpURLConnectionExtension = new HttpURLConnectionExtension((HttpURLConnection) uRLConnection);
        }
        return httpURLConnectionExtension;
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpHost, httpRequest, httpContext);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return m34224a(httpClient.execute(httpHost, m34223a(httpHost, httpRequest, transactionState), httpContext), transactionState);
        } catch (IOException e) {
            m34227a(transactionState, (Exception) e);
            throw e;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpHost, httpRequest, responseHandler, httpContext);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return httpClient.execute(httpHost, m34223a(httpHost, httpRequest, transactionState), m34225a(responseHandler, transactionState), httpContext);
        } catch (ClientProtocolException e) {
            m34227a(transactionState, (Exception) e);
            throw e;
        } catch (IOException e2) {
            m34227a(transactionState, (Exception) e2);
            throw e2;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpHost, httpRequest, responseHandler);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return httpClient.execute(httpHost, m34223a(httpHost, httpRequest, transactionState), m34225a(responseHandler, transactionState));
        } catch (ClientProtocolException e) {
            m34227a(transactionState, (Exception) e);
            throw e;
        } catch (IOException e2) {
            m34227a(transactionState, (Exception) e2);
            throw e2;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpHost, httpRequest);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return m34224a(httpClient.execute(httpHost, m34223a(httpHost, httpRequest, transactionState)), transactionState);
        } catch (IOException e) {
            m34227a(transactionState, (Exception) e);
            throw e;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpUriRequest, httpContext);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return m34224a(httpClient.execute(m34226a(httpUriRequest, transactionState), httpContext), transactionState);
        } catch (IOException e) {
            m34227a(transactionState, (Exception) e);
            throw e;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpUriRequest, responseHandler, httpContext);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return httpClient.execute(m34226a(httpUriRequest, transactionState), m34225a(responseHandler, transactionState), httpContext);
        } catch (ClientProtocolException e) {
            m34227a(transactionState, (Exception) e);
            throw e;
        } catch (IOException e2) {
            m34227a(transactionState, (Exception) e2);
            throw e2;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpUriRequest, responseHandler);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return httpClient.execute(m34226a(httpUriRequest, transactionState), m34225a(responseHandler, transactionState));
        } catch (ClientProtocolException e) {
            m34227a(transactionState, (Exception) e);
            throw e;
        } catch (IOException e2) {
            m34227a(transactionState, (Exception) e2);
            throw e2;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpUriRequest);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return m34224a(httpClient.execute(m34226a(httpUriRequest, transactionState)), transactionState);
        } catch (IOException e) {
            m34227a(transactionState, (Exception) e);
            throw e;
        }
    }

    /* renamed from: a */
    private static void m34227a(TransactionState transactionState, Exception exc) {
        if (!transactionState.isComplete()) {
            TransactionStateUtil.setErrorCodeFromException(transactionState, exc);
            TransactionData end = transactionState.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            }
        }
    }

    /* renamed from: a */
    private static HttpUriRequest m34226a(HttpUriRequest httpUriRequest, TransactionState transactionState) {
        return TransactionStateUtil.inspectAndInstrument(transactionState, httpUriRequest);
    }

    /* renamed from: a */
    private static HttpRequest m34223a(HttpHost httpHost, HttpRequest httpRequest, TransactionState transactionState) {
        return TransactionStateUtil.inspectAndInstrument(transactionState, httpHost, httpRequest);
    }

    /* renamed from: a */
    private static HttpResponse m34224a(HttpResponse httpResponse, TransactionState transactionState) {
        return TransactionStateUtil.inspectAndInstrument(transactionState, httpResponse);
    }

    /* renamed from: a */
    private static <T> ResponseHandler<? extends T> m34225a(ResponseHandler<? extends T> responseHandler, TransactionState transactionState) {
        return ResponseHandlerImpl.wrap(responseHandler, transactionState);
    }
}
