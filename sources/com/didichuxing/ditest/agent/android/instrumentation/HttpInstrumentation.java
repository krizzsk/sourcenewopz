package com.didichuxing.ditest.agent.android.instrumentation;

import com.didichuxing.ditest.agent.android.Agent;
import com.didichuxing.ditest.agent.android.TaskQueue;
import com.didichuxing.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.ditest.agent.android.instrumentation.httpclient.ResponseHandlerImpl;
import com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
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
            return paramWrapper(httpClient.execute(httpHost, paramWrapper(httpHost, httpRequest, transactionState), httpContext), transactionState);
        } catch (IOException e) {
            httpClientError(transactionState, e);
            throw e;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpHost, httpRequest, responseHandler, httpContext);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return httpClient.execute(httpHost, paramWrapper(httpHost, httpRequest, transactionState), paramWrapper(responseHandler, transactionState), httpContext);
        } catch (ClientProtocolException e) {
            httpClientError(transactionState, e);
            throw e;
        } catch (IOException e2) {
            httpClientError(transactionState, e2);
            throw e2;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpHost, httpRequest, responseHandler);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return httpClient.execute(httpHost, paramWrapper(httpHost, httpRequest, transactionState), paramWrapper(responseHandler, transactionState));
        } catch (ClientProtocolException e) {
            httpClientError(transactionState, e);
            throw e;
        } catch (IOException e2) {
            httpClientError(transactionState, e2);
            throw e2;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpHost, httpRequest);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return paramWrapper(httpClient.execute(httpHost, paramWrapper(httpHost, httpRequest, transactionState)), transactionState);
        } catch (IOException e) {
            httpClientError(transactionState, e);
            throw e;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpUriRequest, httpContext);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return paramWrapper(httpClient.execute(paramWrapper(httpUriRequest, transactionState), httpContext), transactionState);
        } catch (IOException e) {
            httpClientError(transactionState, e);
            throw e;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpUriRequest, responseHandler, httpContext);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return httpClient.execute(paramWrapper(httpUriRequest, transactionState), paramWrapper(responseHandler, transactionState), httpContext);
        } catch (ClientProtocolException e) {
            httpClientError(transactionState, e);
            throw e;
        } catch (IOException e2) {
            httpClientError(transactionState, e2);
            throw e2;
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpUriRequest, responseHandler);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return httpClient.execute(paramWrapper(httpUriRequest, transactionState), paramWrapper(responseHandler, transactionState));
        } catch (ClientProtocolException e) {
            httpClientError(transactionState, e);
            throw e;
        } catch (IOException e2) {
            httpClientError(transactionState, e2);
            throw e2;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        if (!Agent.isApmNetEnable() && !Agent.isEnvSwitchEnable()) {
            return httpClient.execute(httpUriRequest);
        }
        TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTPCLIENT);
        try {
            return paramWrapper(httpClient.execute(paramWrapper(httpUriRequest, transactionState)), transactionState);
        } catch (IOException e) {
            httpClientError(transactionState, e);
            throw e;
        }
    }

    private static void httpClientError(TransactionState transactionState, Exception exc) {
        if (!transactionState.isComplete()) {
            TransactionStateUtil.setErrorCodeFromException(transactionState, exc);
            TransactionData end = transactionState.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            }
        }
    }

    private static HttpUriRequest paramWrapper(HttpUriRequest httpUriRequest, TransactionState transactionState) {
        return TransactionStateUtil.inspectAndInstrument(transactionState, httpUriRequest);
    }

    private static HttpRequest paramWrapper(HttpHost httpHost, HttpRequest httpRequest, TransactionState transactionState) {
        return TransactionStateUtil.inspectAndInstrument(transactionState, httpHost, httpRequest);
    }

    private static HttpResponse paramWrapper(HttpResponse httpResponse, TransactionState transactionState) {
        return TransactionStateUtil.inspectAndInstrument(transactionState, httpResponse);
    }

    private static <T> ResponseHandler<? extends T> paramWrapper(ResponseHandler<? extends T> responseHandler, TransactionState transactionState) {
        return ResponseHandlerImpl.wrap(responseHandler, transactionState);
    }
}
