package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Agent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Measurements;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.TaskQueue;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingOutputStream;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteEvent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.StreamCompleteListener;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.assistant.EnvSwitchManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HttpURLConnectionExtension extends HttpURLConnection {

    /* renamed from: c */
    private static final AgentLog f47941c = AgentLogManager.getAgentLog();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HttpURLConnection f47942a;

    /* renamed from: b */
    private TransactionState f47943b;

    public HttpURLConnectionExtension(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        if (!Agent.isEnvSwitchEnable()) {
            this.f47942a = httpURLConnection;
        } else {
            this.f47942a = EnvSwitchManager.getInstance().replaceHttpURLConnection(httpURLConnection);
        }
    }

    public void addRequestProperty(String str, String str2) {
        if (!(str == null || str2 == null)) {
            m34234b();
            try {
                String requestProperty = this.f47942a.getRequestProperty(str);
                int length = str2.length() + 1;
                if (requestProperty == null) {
                    length += str.length() + 2;
                }
                this.f47943b.setBytesHeaderSent(this.f47943b.getBytesHeaderSent() + ((long) length));
                if (TransactionStateUtil.isTraceIdHeader(str)) {
                    this.f47943b.setTraceId(str2);
                }
            } catch (IllegalStateException e) {
                f47941c.error("http url connection already connected when set Request Property");
                throw e;
            }
        }
        this.f47942a.addRequestProperty(str, str2);
    }

    public void disconnect() {
        TransactionState transactionState = this.f47943b;
        if (transactionState != null && !transactionState.isComplete()) {
            m34232a(this.f47943b);
        }
        this.f47942a.disconnect();
    }

    public boolean usingProxy() {
        return this.f47942a.usingProxy();
    }

    public void connect() throws IOException {
        m34234b();
        try {
            this.f47942a.connect();
        } catch (IOException e) {
            m34233a((Exception) e);
            throw e;
        }
    }

    public boolean getAllowUserInteraction() {
        return this.f47942a.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.f47942a.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        m34234b();
        try {
            Object content = this.f47942a.getContent();
            int contentLength = this.f47942a.getContentLength();
            if (contentLength >= 0) {
                TransactionState b = m34234b();
                if (!b.isComplete()) {
                    b.setBytesReceived((long) contentLength);
                    m34232a(b);
                }
            }
            return content;
        } catch (IOException e) {
            m34233a((Exception) e);
            throw e;
        }
    }

    public Object getContent(Class[] clsArr) throws IOException {
        m34234b();
        try {
            Object content = this.f47942a.getContent(clsArr);
            m34229a();
            return content;
        } catch (IOException e) {
            m34233a((Exception) e);
            throw e;
        }
    }

    public String getContentEncoding() {
        m34234b();
        String contentEncoding = this.f47942a.getContentEncoding();
        m34229a();
        return contentEncoding;
    }

    public int getContentLength() {
        m34234b();
        int contentLength = this.f47942a.getContentLength();
        m34229a();
        return contentLength;
    }

    public String getContentType() {
        m34234b();
        String contentType = this.f47942a.getContentType();
        m34229a();
        return contentType;
    }

    public long getDate() {
        m34234b();
        long date = this.f47942a.getDate();
        m34229a();
        return date;
    }

    public InputStream getErrorStream() {
        m34234b();
        try {
            return new CountingInputStream(this.f47942a.getErrorStream(), true);
        } catch (Exception e) {
            f47941c.error(e.toString());
            return this.f47942a.getErrorStream();
        }
    }

    public long getHeaderFieldDate(String str, long j) {
        m34234b();
        long headerFieldDate = this.f47942a.getHeaderFieldDate(str, j);
        m34229a();
        return headerFieldDate;
    }

    public boolean getInstanceFollowRedirects() {
        return this.f47942a.getInstanceFollowRedirects();
    }

    public Permission getPermission() throws IOException {
        return this.f47942a.getPermission();
    }

    public String getRequestMethod() {
        return this.f47942a.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        m34234b();
        try {
            int responseCode = this.f47942a.getResponseCode();
            m34229a();
            return responseCode;
        } catch (IOException e) {
            m34233a((Exception) e);
            throw e;
        }
    }

    public String getResponseMessage() throws IOException {
        m34234b();
        try {
            String responseMessage = this.f47942a.getResponseMessage();
            m34229a();
            return responseMessage;
        } catch (IOException e) {
            m34233a((Exception) e);
            throw e;
        }
    }

    public void setChunkedStreamingMode(int i) {
        this.f47942a.setChunkedStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f47942a.setFixedLengthStreamingMode(i);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f47942a.setInstanceFollowRedirects(z);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        m34234b();
        try {
            this.f47942a.setRequestMethod(str);
        } catch (ProtocolException e) {
            m34233a((Exception) e);
            throw e;
        }
    }

    public boolean getDefaultUseCaches() {
        return this.f47942a.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f47942a.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f47942a.getDoOutput();
    }

    public long getExpiration() {
        m34234b();
        long expiration = this.f47942a.getExpiration();
        m34229a();
        return expiration;
    }

    public String getHeaderField(int i) {
        m34234b();
        String headerField = this.f47942a.getHeaderField(i);
        m34229a();
        return headerField;
    }

    public String getHeaderField(String str) {
        m34234b();
        String headerField = this.f47942a.getHeaderField(str);
        m34229a();
        return headerField;
    }

    public int getHeaderFieldInt(String str, int i) {
        m34234b();
        int headerFieldInt = this.f47942a.getHeaderFieldInt(str, i);
        m34229a();
        return headerFieldInt;
    }

    public String getHeaderFieldKey(int i) {
        m34234b();
        String headerFieldKey = this.f47942a.getHeaderFieldKey(i);
        m34229a();
        return headerFieldKey;
    }

    public Map<String, List<String>> getHeaderFields() {
        m34234b();
        Map<String, List<String>> headerFields = this.f47942a.getHeaderFields();
        m34229a();
        return headerFields;
    }

    public long getIfModifiedSince() {
        m34234b();
        long ifModifiedSince = this.f47942a.getIfModifiedSince();
        m34229a();
        return ifModifiedSince;
    }

    public InputStream getInputStream() throws IOException {
        final TransactionState b = m34234b();
        try {
            CountingInputStream countingInputStream = new CountingInputStream(this.f47942a.getInputStream());
            TransactionStateUtil.inspectAndInstrumentResponse(b, this.f47942a);
            countingInputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        b.setBytesReceived(streamCompleteEvent.getBytes());
                    }
                    HttpURLConnectionExtension.this.m34233a(streamCompleteEvent.getException());
                }

                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        long contentLength = (long) HttpURLConnectionExtension.this.f47942a.getContentLength();
                        long bytes = streamCompleteEvent.getBytes();
                        if (contentLength < 0) {
                            contentLength = bytes;
                        }
                        b.setBytesReceived(contentLength);
                        HttpURLConnectionExtension.this.m34232a(b);
                    }
                }
            });
            return countingInputStream;
        } catch (IOException e) {
            m34233a((Exception) e);
            throw e;
        }
    }

    public long getLastModified() {
        m34234b();
        long lastModified = this.f47942a.getLastModified();
        m34229a();
        return lastModified;
    }

    public OutputStream getOutputStream() throws IOException {
        final TransactionState b = m34234b();
        try {
            CountingOutputStream countingOutputStream = new CountingOutputStream(this.f47942a.getOutputStream());
            countingOutputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        b.setBytesSent(streamCompleteEvent.getBytes());
                    }
                    HttpURLConnectionExtension.this.m34233a(streamCompleteEvent.getException());
                }

                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        String requestProperty = HttpURLConnectionExtension.this.f47942a.getRequestProperty("content-length");
                        long bytes = streamCompleteEvent.getBytes();
                        if (requestProperty != null) {
                            try {
                                bytes = Long.parseLong(requestProperty);
                            } catch (NumberFormatException unused) {
                            }
                        }
                        b.setBytesSent(bytes);
                    }
                }
            });
            return countingOutputStream;
        } catch (IOException e) {
            m34233a((Exception) e);
            throw e;
        }
    }

    public int getReadTimeout() {
        return this.f47942a.getReadTimeout();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f47942a.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.f47942a.getRequestProperty(str);
    }

    public URL getURL() {
        return this.f47942a.getURL();
    }

    public boolean getUseCaches() {
        return this.f47942a.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f47942a.setAllowUserInteraction(z);
    }

    public void setConnectTimeout(int i) {
        this.f47942a.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.f47942a.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.f47942a.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.f47942a.setDoOutput(z);
    }

    public void setIfModifiedSince(long j) {
        this.f47942a.setIfModifiedSince(j);
    }

    public void setReadTimeout(int i) {
        this.f47942a.setReadTimeout(i);
    }

    public void setRequestProperty(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                if (this.f47942a.getRequestProperty(str) != null) {
                    m34234b();
                    this.f47943b.setBytesHeaderSent(this.f47943b.getBytesHeaderSent() + ((long) str.length()) + 1 + ((long) str2.length()) + 1);
                }
            } catch (IllegalStateException e) {
                f47941c.error("http url connection already connected when set Request Property");
                throw e;
            }
        }
        this.f47942a.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.f47942a.setUseCaches(z);
    }

    public String toString() {
        return this.f47942a.toString();
    }

    /* renamed from: a */
    private void m34229a() {
        if (!m34234b().isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(m34234b(), this.f47942a);
        }
    }

    /* renamed from: b */
    private TransactionState m34234b() {
        if (this.f47943b == null) {
            TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTP_URL_CONNECTION);
            this.f47943b = transactionState;
            TransactionStateUtil.inspectAndInstrumentRequet(transactionState, this.f47942a);
        }
        return this.f47943b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34233a(Exception exc) {
        TransactionState b = m34234b();
        TransactionStateUtil.setErrorCodeFromException(b, exc);
        if (!b.isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(b, this.f47942a);
            TransactionData end = b.end();
            if (end != null) {
                TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34232a(TransactionState transactionState) {
        TransactionData end = transactionState.end();
        if (end != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), end.getErrorCode(), end.getTimestamp(), end.getTime(), end.getBytesSent(), end.getBytesReceived(), end.getBusinessType(), end.getTraceId(), end.getErrCodeClass(), end.getErrCodeInfo()));
            if (transactionState.getStatusCode() >= 400) {
                StringBuilder sb = new StringBuilder();
                try {
                    InputStream errorStream = getErrorStream();
                    if (errorStream instanceof CountingInputStream) {
                        sb.append(((CountingInputStream) errorStream).getBufferAsString());
                    }
                } catch (Exception e) {
                    f47941c.error(e.toString());
                }
                TreeMap treeMap = new TreeMap();
                String contentType = this.f47942a.getContentType();
                if (contentType != null && !"".equals(contentType)) {
                    treeMap.put("content_type", contentType);
                }
                treeMap.put("content_length", transactionState.getBytesReceived() + "");
                Measurements.addHttpError(end.getUrl(), end.getHttpMethod(), end.getStatusCode(), sb.toString(), end.getBusinessType(), end.getTraceId(), end.isForground(), end.getWanType(), end.getCarrier(), treeMap);
                return;
            }
        }
    }
}
