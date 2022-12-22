package com.didichuxing.ditest.agent.android.instrumentation;

import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didichuxing.ditest.agent.android.Measurements;
import com.didichuxing.ditest.agent.android.TaskQueue;
import com.didichuxing.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.ditest.agent.android.instrumentation.httpclient.ContentBufferingResponseEntityImpl;
import com.didichuxing.ditest.agent.android.instrumentation.httpclient.HttpRequestEntityImpl;
import com.didichuxing.ditest.agent.android.instrumentation.httpclient.HttpResponseEntityImpl;
import com.didichuxing.ditest.agent.android.instrumentation.p187io.CountingInputStream;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.ditest.agent.android.util.NetworkFailure;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLException;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;

public class TransactionStateUtil {
    private static final String CONTENT_LENGTH_HEADER = "Content-Length";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    protected static final String DIDI_TRACE_ID_HEADER = "didi-header-rid";
    public static final int NSURLErrorBadServerResponse = NetworkFailure.BadServerResponse.getErrorCode();
    public static final int NSURLErrorBadURL = NetworkFailure.BadURL.getErrorCode();
    public static final int NSURLErrorCannotConnectToHost = NetworkFailure.CannotConnectToHost.getErrorCode();
    public static final int NSURLErrorDNSLookupFailed = NetworkFailure.DNSLookupFailed.getErrorCode();
    public static final int NSURLErrorSecureConnectionFailed = NetworkFailure.SecureConnectionFailed.getErrorCode();
    public static final int NSURLErrorTimedOut = NetworkFailure.TimedOut.getErrorCode();
    public static final int NSURLErrorUnknown = NetworkFailure.Unknown.getErrorCode();
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public static void inspectAndInstrumentRequet(TransactionState transactionState, HttpURLConnection httpURLConnection) {
        transactionState.setUrl(httpURLConnection.getURL().toString());
        transactionState.setHttpMethod(httpURLConnection.getRequestMethod());
    }

    public static boolean isTraceIdHeader(String str) {
        return DIDI_TRACE_ID_HEADER.equals(str);
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionState, HttpURLConnection httpURLConnection) {
        int contentLength = httpURLConnection.getContentLength();
        if (contentLength <= 0) {
            try {
                contentLength = httpURLConnection.getResponseMessage().length();
            } catch (IOException e) {
                AgentLog agentLog = log;
                agentLog.error("Fail to retrieve response message: " + e.getMessage());
            }
        }
        transactionState.setBytesReceived((long) contentLength);
        long j = 0;
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            synchronized (headerFields) {
                for (String str : headerFields.keySet()) {
                    if (str != null) {
                        j += (long) (str.length() + 1);
                        for (String length : (List) headerFields.get(str)) {
                            j += (long) (length.length() + 1);
                        }
                    }
                }
            }
            transactionState.setBytesHeaderReceived(j);
        }
        try {
            transactionState.setStatusCode(httpURLConnection.getResponseCode());
        } catch (IOException e2) {
            AgentLog agentLog2 = log;
            agentLog2.debug("Failed to retrieve response code due to an I/O exception: " + e2.getMessage());
        } catch (NullPointerException e3) {
            log.error("Failed to retrieve response code due to underlying (Harmony?) NPE", e3);
        }
    }

    public static HttpRequest inspectAndInstrument(TransactionState transactionState, HttpHost httpHost, HttpRequest httpRequest) {
        RequestLine requestLine = httpRequest.getRequestLine();
        if (requestLine != null) {
            String uri = requestLine.getUri();
            boolean z = uri != null && uri.length() >= 10 && uri.substring(0, 10).indexOf(HWMapConstant.HTTP.SEPARATOR) >= 0;
            if (!z && uri != null && httpHost != null) {
                String uri2 = httpHost.toURI();
                StringBuilder sb = new StringBuilder();
                sb.append(uri2);
                sb.append((uri2.endsWith("/") || uri.startsWith("/")) ? "" : "/");
                sb.append(uri);
                transactionState.setUrl(sb.toString());
            } else if (z) {
                transactionState.setUrl(uri);
            }
            transactionState.setHttpMethod(requestLine.getMethod());
            long j = 0;
            Header[] allHeaders = httpRequest.getAllHeaders();
            if (allHeaders != null) {
                synchronized (allHeaders) {
                    for (Header header : allHeaders) {
                        j = j + ((long) header.getName().length()) + ((long) header.getValue().length()) + 2;
                        if (header.getName().equals(DIDI_TRACE_ID_HEADER)) {
                            transactionState.setTraceId(header.getValue());
                        }
                    }
                }
            }
            transactionState.setBytesHeaderSent(j);
        }
        if (transactionState.getUrl() == null || transactionState.getHttpMethod() == null) {
            try {
                throw new Exception("TransactionData constructor was not provided with a valid URL, host or HTTP method");
            } catch (Exception e) {
                AgentLogManager.getAgentLog().error(MessageFormat.format("TransactionStateUtil.inspectAndInstrument(...) for {0} could not determine request URL or HTTP method [host={1}, requestLine={2}]", new Object[]{httpRequest.getClass().getCanonicalName(), httpHost, requestLine}), e);
                return httpRequest;
            }
        } else {
            wrapRequestEntity(transactionState, httpRequest);
            return httpRequest;
        }
    }

    public static HttpUriRequest inspectAndInstrument(TransactionState transactionState, HttpUriRequest httpUriRequest) {
        int i;
        if (httpUriRequest != null) {
            transactionState.setUrl(httpUriRequest.getURI().toString());
            transactionState.setHttpMethod(httpUriRequest.getMethod());
            Header[] allHeaders = httpUriRequest.getAllHeaders();
            int i2 = 0;
            if (allHeaders != null) {
                synchronized (allHeaders) {
                    int length = allHeaders.length;
                    i = 0;
                    while (i2 < length) {
                        Header header = allHeaders[i2];
                        i = i + header.getName().length() + header.getValue().length() + 2;
                        if (header.getName().equals(DIDI_TRACE_ID_HEADER)) {
                            transactionState.setTraceId(header.getValue());
                        }
                        i2++;
                    }
                }
                i2 = i;
            }
            transactionState.setBytesHeaderSent((long) i2);
        }
        wrapRequestEntity(transactionState, httpUriRequest);
        return httpUriRequest;
    }

    public static void inspectAndInstrument(TransactionState transactionState, String str, String str2) {
        transactionState.setUrl(str);
        transactionState.setHttpMethod(str2);
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionState, int i, int i2) {
        if (i >= 0) {
            transactionState.setBytesReceived((long) i);
        }
        transactionState.setStatusCode(i2);
    }

    private static void wrapRequestEntity(TransactionState transactionState, HttpRequest httpRequest) {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
            if (httpEntityEnclosingRequest.getEntity() != null) {
                httpEntityEnclosingRequest.setEntity(new HttpRequestEntityImpl(httpEntityEnclosingRequest.getEntity(), transactionState));
            }
        }
    }

    public static HttpResponse inspectAndInstrument(TransactionState transactionState, HttpResponse httpResponse) {
        long j;
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine != null) {
            transactionState.setStatusCode(statusLine.getStatusCode());
            Header[] allHeaders = httpResponse.getAllHeaders();
            if (allHeaders != null) {
                synchronized (allHeaders) {
                    j = 0;
                    for (Header header : allHeaders) {
                        j = j + ((long) header.getName().length()) + ((long) header.getValue().length()) + 2;
                    }
                }
            } else {
                j = 0;
            }
            transactionState.setBytesHeaderReceived(j);
            Header[] headers = httpResponse.getHeaders("Content-Length");
            if (headers != null && headers.length > 0) {
                try {
                    transactionState.setBytesReceived(Long.parseLong(headers[0].getValue()));
                    addTransactionAndErrorData(transactionState, httpResponse);
                } catch (NumberFormatException e) {
                    log.warning("Failed to parse content length: " + e.toString());
                }
            } else if (httpResponse.getEntity() != null) {
                httpResponse.setEntity(new HttpResponseEntityImpl(httpResponse.getEntity(), transactionState, -1));
            } else {
                transactionState.setBytesReceived(0);
                addTransactionAndErrorData(transactionState, (HttpResponse) null);
            }
        }
        return httpResponse;
    }

    public static void setErrorCodeFromException(TransactionState transactionState, Exception exc) {
        if (exc instanceof UnknownHostException) {
            transactionState.setErrorCode(NSURLErrorDNSLookupFailed);
        } else if ((exc instanceof SocketTimeoutException) || (exc instanceof ConnectTimeoutException)) {
            transactionState.setErrorCode(NSURLErrorTimedOut);
        } else if (exc instanceof ConnectException) {
            transactionState.setErrorCode(NSURLErrorCannotConnectToHost);
        } else if (exc instanceof MalformedURLException) {
            transactionState.setErrorCode(NSURLErrorBadURL);
        } else if (exc instanceof SSLException) {
            transactionState.setErrorCode(NSURLErrorSecureConnectionFailed);
        } else if (exc instanceof HttpResponseException) {
            transactionState.setStatusCode(((HttpResponseException) exc).getStatusCode());
        } else if (exc instanceof ClientProtocolException) {
            transactionState.setErrorCode(NSURLErrorBadServerResponse);
        } else {
            transactionState.setErrorCode(NSURLErrorUnknown);
            transactionState.setErrCodeClass(exc.getClass().getName());
            transactionState.setErrCodeInfo(exc.getMessage());
        }
    }

    private static void addTransactionAndErrorData(TransactionState transactionState, HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        TransactionData end = transactionState.end();
        if (end != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            if (transactionState.getStatusCode() >= 400) {
                StringBuilder sb = new StringBuilder();
                try {
                    if (httpResponse.getEntity() != null) {
                        if (!(httpResponse.getEntity() instanceof HttpRequestEntityImpl)) {
                            httpResponse2.setEntity(new ContentBufferingResponseEntityImpl(httpResponse.getEntity()));
                        }
                        InputStream content = httpResponse.getEntity().getContent();
                        if (content instanceof CountingInputStream) {
                            sb.append(((CountingInputStream) content).getBufferAsString());
                        } else {
                            log.error("Unable to wrap content stream for entity");
                        }
                    } else {
                        log.debug("null response entity. response-body will be reported empty");
                    }
                } catch (IllegalStateException e) {
                    log.error(e.toString());
                } catch (IOException e2) {
                    log.error(e2.toString());
                }
                Header[] headers = httpResponse2.getHeaders("Content-Type");
                String str = null;
                if (headers != null && headers.length > 0 && !"".equals(headers[0].getValue())) {
                    str = headers[0].getValue();
                }
                TreeMap treeMap = new TreeMap();
                if (str != null && str.length() > 0) {
                    treeMap.put("content_type", str);
                }
                treeMap.put("content_length", transactionState.getBytesReceived() + "");
                Measurements.addHttpError(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), sb.toString(), end.getBusinessType(), end.getTraceId(), end.isForground(), end.getWanType(), end.getCarrier(), treeMap);
            }
        }
    }
}
