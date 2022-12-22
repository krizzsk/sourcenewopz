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
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public class HttpsURLConnectionExtension extends HttpsURLConnection {

    /* renamed from: c */
    private static final AgentLog f47944c = AgentLogManager.getAgentLog();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HttpsURLConnection f47945a;

    /* renamed from: b */
    private TransactionState f47946b;

    public HttpsURLConnectionExtension(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        if (!Agent.isEnvSwitchEnable()) {
            this.f47945a = httpsURLConnection;
        } else {
            this.f47945a = EnvSwitchManager.getInstance().replaceHttpsURLConnection(httpsURLConnection);
        }
    }

    public String getCipherSuite() {
        return this.f47945a.getCipherSuite();
    }

    public Certificate[] getLocalCertificates() {
        return this.f47945a.getLocalCertificates();
    }

    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        try {
            return this.f47945a.getServerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            m34240a((Exception) e);
            throw e;
        }
    }

    public void addRequestProperty(String str, String str2) {
        if (!(str == null || str2 == null)) {
            m34241b();
            try {
                String requestProperty = this.f47945a.getRequestProperty(str);
                int length = str2.length() + 1;
                if (requestProperty == null) {
                    length += str.length() + 2;
                }
                this.f47946b.setBytesHeaderSent(this.f47946b.getBytesHeaderSent() + ((long) length));
                if (TransactionStateUtil.isTraceIdHeader(str)) {
                    this.f47946b.setTraceId(str2);
                }
            } catch (IllegalStateException e) {
                f47944c.error("http url connection already connected when set Request Property");
                throw e;
            }
        }
        this.f47945a.addRequestProperty(str, str2);
    }

    public void disconnect() {
        TransactionState transactionState = this.f47946b;
        if (transactionState != null && !transactionState.isComplete()) {
            m34239a(this.f47946b);
        }
        this.f47945a.disconnect();
    }

    public boolean usingProxy() {
        return this.f47945a.usingProxy();
    }

    public void connect() throws IOException {
        m34241b();
        try {
            this.f47945a.connect();
        } catch (IOException e) {
            m34240a((Exception) e);
            throw e;
        }
    }

    public boolean getAllowUserInteraction() {
        return this.f47945a.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.f47945a.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        m34241b();
        try {
            Object content = this.f47945a.getContent();
            int contentLength = this.f47945a.getContentLength();
            if (contentLength >= 0) {
                TransactionState b = m34241b();
                if (!b.isComplete()) {
                    b.setBytesReceived((long) contentLength);
                    m34239a(b);
                }
            }
            return content;
        } catch (IOException e) {
            m34240a((Exception) e);
            throw e;
        }
    }

    public Object getContent(Class[] clsArr) throws IOException {
        m34241b();
        try {
            Object content = this.f47945a.getContent(clsArr);
            m34236a();
            return content;
        } catch (IOException e) {
            m34240a((Exception) e);
            throw e;
        }
    }

    public String getContentEncoding() {
        m34241b();
        String contentEncoding = this.f47945a.getContentEncoding();
        m34236a();
        return contentEncoding;
    }

    public int getContentLength() {
        m34241b();
        int contentLength = this.f47945a.getContentLength();
        m34236a();
        return contentLength;
    }

    public String getContentType() {
        m34241b();
        String contentType = this.f47945a.getContentType();
        m34236a();
        return contentType;
    }

    public long getDate() {
        m34241b();
        long date = this.f47945a.getDate();
        m34236a();
        return date;
    }

    public InputStream getErrorStream() {
        m34241b();
        try {
            return new CountingInputStream(this.f47945a.getErrorStream(), true);
        } catch (Exception e) {
            f47944c.error(e.toString());
            return this.f47945a.getErrorStream();
        }
    }

    public long getHeaderFieldDate(String str, long j) {
        m34241b();
        long headerFieldDate = this.f47945a.getHeaderFieldDate(str, j);
        m34236a();
        return headerFieldDate;
    }

    public boolean getInstanceFollowRedirects() {
        return this.f47945a.getInstanceFollowRedirects();
    }

    public Permission getPermission() throws IOException {
        return this.f47945a.getPermission();
    }

    public String getRequestMethod() {
        return this.f47945a.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        m34241b();
        try {
            int responseCode = this.f47945a.getResponseCode();
            m34236a();
            return responseCode;
        } catch (IOException e) {
            m34240a((Exception) e);
            throw e;
        }
    }

    public String getResponseMessage() throws IOException {
        m34241b();
        try {
            String responseMessage = this.f47945a.getResponseMessage();
            m34236a();
            return responseMessage;
        } catch (IOException e) {
            m34240a((Exception) e);
            throw e;
        }
    }

    public void setChunkedStreamingMode(int i) {
        this.f47945a.setChunkedStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f47945a.setFixedLengthStreamingMode(i);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f47945a.setInstanceFollowRedirects(z);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        try {
            this.f47945a.setRequestMethod(str);
        } catch (ProtocolException e) {
            m34240a((Exception) e);
            throw e;
        }
    }

    public boolean getDefaultUseCaches() {
        return this.f47945a.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f47945a.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f47945a.getDoOutput();
    }

    public long getExpiration() {
        m34241b();
        long expiration = this.f47945a.getExpiration();
        m34236a();
        return expiration;
    }

    public String getHeaderField(int i) {
        m34241b();
        String headerField = this.f47945a.getHeaderField(i);
        m34236a();
        return headerField;
    }

    public String getHeaderField(String str) {
        m34241b();
        String headerField = this.f47945a.getHeaderField(str);
        m34236a();
        return headerField;
    }

    public int getHeaderFieldInt(String str, int i) {
        m34241b();
        int headerFieldInt = this.f47945a.getHeaderFieldInt(str, i);
        m34236a();
        return headerFieldInt;
    }

    public String getHeaderFieldKey(int i) {
        m34241b();
        String headerFieldKey = this.f47945a.getHeaderFieldKey(i);
        m34236a();
        return headerFieldKey;
    }

    public Map<String, List<String>> getHeaderFields() {
        m34241b();
        Map<String, List<String>> headerFields = this.f47945a.getHeaderFields();
        m34236a();
        return headerFields;
    }

    public long getIfModifiedSince() {
        m34241b();
        long ifModifiedSince = this.f47945a.getIfModifiedSince();
        m34236a();
        return ifModifiedSince;
    }

    public InputStream getInputStream() throws IOException {
        final TransactionState b = m34241b();
        try {
            CountingInputStream countingInputStream = new CountingInputStream(this.f47945a.getInputStream());
            TransactionStateUtil.inspectAndInstrumentResponse(b, this.f47945a);
            countingInputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        b.setBytesReceived(streamCompleteEvent.getBytes());
                    }
                    HttpsURLConnectionExtension.this.m34240a(streamCompleteEvent.getException());
                }

                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        long contentLength = (long) HttpsURLConnectionExtension.this.f47945a.getContentLength();
                        long bytes = streamCompleteEvent.getBytes();
                        if (contentLength < 0) {
                            contentLength = bytes;
                        }
                        b.setBytesReceived(contentLength);
                        HttpsURLConnectionExtension.this.m34239a(b);
                    }
                }
            });
            return countingInputStream;
        } catch (IOException e) {
            m34240a((Exception) e);
            throw e;
        }
    }

    public long getLastModified() {
        m34241b();
        long lastModified = this.f47945a.getLastModified();
        m34236a();
        return lastModified;
    }

    public OutputStream getOutputStream() throws IOException {
        final TransactionState b = m34241b();
        try {
            CountingOutputStream countingOutputStream = new CountingOutputStream(this.f47945a.getOutputStream());
            countingOutputStream.addStreamCompleteListener(new StreamCompleteListener() {
                public void streamError(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        b.setBytesSent(streamCompleteEvent.getBytes());
                    }
                    HttpsURLConnectionExtension.this.m34240a(streamCompleteEvent.getException());
                }

                public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
                    if (!b.isComplete()) {
                        String requestProperty = HttpsURLConnectionExtension.this.f47945a.getRequestProperty("content-length");
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
            m34240a((Exception) e);
            throw e;
        }
    }

    public int getReadTimeout() {
        return this.f47945a.getReadTimeout();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f47945a.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.f47945a.getRequestProperty(str);
    }

    public URL getURL() {
        return this.f47945a.getURL();
    }

    public boolean getUseCaches() {
        return this.f47945a.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f47945a.setAllowUserInteraction(z);
    }

    public void setConnectTimeout(int i) {
        this.f47945a.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.f47945a.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.f47945a.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.f47945a.setDoOutput(z);
    }

    public void setIfModifiedSince(long j) {
        this.f47945a.setIfModifiedSince(j);
    }

    public void setReadTimeout(int i) {
        this.f47945a.setReadTimeout(i);
    }

    public void setRequestProperty(String str, String str2) {
        int i;
        if (!(str == null || str2 == null)) {
            m34241b();
            try {
                String requestProperty = this.f47945a.getRequestProperty(str);
                int length = str2.length();
                if (requestProperty != null) {
                    i = length - requestProperty.length();
                } else {
                    i = length + str.length() + 2;
                }
                this.f47946b.setBytesHeaderSent(this.f47946b.getBytesHeaderSent() + ((long) i));
                if (TransactionStateUtil.isTraceIdHeader(str)) {
                    this.f47946b.setTraceId(str2);
                }
            } catch (IllegalStateException e) {
                f47944c.error("http url connection already connected when set Request Property");
                throw e;
            }
        }
        this.f47945a.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.f47945a.setUseCaches(z);
    }

    public String toString() {
        return this.f47945a.toString();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.f47945a.getPeerPrincipal();
    }

    public Principal getLocalPrincipal() {
        return this.f47945a.getLocalPrincipal();
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f47945a.setHostnameVerifier(hostnameVerifier);
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f47945a.getHostnameVerifier();
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f47945a.setSSLSocketFactory(sSLSocketFactory);
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.f47945a.getSSLSocketFactory();
    }

    /* renamed from: a */
    private void m34236a() {
        if (!m34241b().isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(m34241b(), this.f47945a);
        }
    }

    /* renamed from: b */
    private TransactionState m34241b() {
        if (this.f47946b == null) {
            TransactionState transactionState = new TransactionState(TransactionState.NetIntfaceType.HTTP_URL_CONNECTION);
            this.f47946b = transactionState;
            TransactionStateUtil.inspectAndInstrumentRequet(transactionState, this.f47945a);
        }
        return this.f47946b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34240a(Exception exc) {
        TransactionState b = m34241b();
        TransactionStateUtil.setErrorCodeFromException(b, exc);
        if (!b.isComplete()) {
            TransactionStateUtil.inspectAndInstrumentResponse(b, this.f47945a);
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
    public void m34239a(TransactionState transactionState) {
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
                    f47944c.error(e.toString());
                }
                TreeMap treeMap = new TreeMap();
                String contentType = this.f47945a.getContentType();
                if (contentType != null && !"".equals(contentType)) {
                    treeMap.put("content_type", contentType);
                }
                treeMap.put("content_length", transactionState.getBytesReceived() + "");
                Measurements.addHttpError(end, sb.toString(), treeMap);
                return;
            }
        }
    }
}
