package com.didiglobal.privacy.domainmonitor.urlconnection;

import com.didiglobal.privacy.domainmonitor.interceptor.NetworkParamsDispatcher;
import com.didiglobal.privacy.domainmonitor.model.NetworkParam;
import com.didiglobal.privacy.domainmonitor.urlconnection.FlowInputStream;
import com.didiglobal.privacy.domainmonitor.urlconnection.FlowOutputStream;
import com.didiglobal.privacy.domainmonitor.utils.UrlUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public class MonitorHttpURLConnection extends HttpURLConnection {

    /* renamed from: e */
    private static final String f50550e = "MonitorHttpURLCon";

    /* renamed from: a */
    private final HttpURLConnection f50551a;

    /* renamed from: b */
    private NetworkParam f50552b;

    /* renamed from: c */
    private FlowOutputStream f50553c;

    /* renamed from: d */
    private FlowInputStream f50554d;

    protected MonitorHttpURLConnection(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        NetworkParam networkParam = new NetworkParam();
        this.f50552b = networkParam;
        this.f50551a = httpURLConnection;
        networkParam.setUrl(UrlUtil.getAbsoluteUrl((HttpURLConnection) this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo123526a(IOException iOException) {
        this.f50552b.appendErrorMessage(iOException.getLocalizedMessage());
    }

    public void disconnect() {
        this.f50551a.disconnect();
    }

    public boolean usingProxy() {
        return this.f50551a.usingProxy();
    }

    public void connect() throws IOException {
        try {
            this.f50551a.connect();
        } catch (IOException e) {
            mo123526a(e);
            throw e;
        }
    }

    public String getHeaderFieldKey(int i) {
        return this.f50551a.getHeaderFieldKey(i);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f50551a.setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long j) {
        this.f50551a.setFixedLengthStreamingMode(j);
    }

    public void setChunkedStreamingMode(int i) {
        this.f50551a.setChunkedStreamingMode(i);
    }

    public String getHeaderField(int i) {
        return this.f50551a.getHeaderField(i);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f50551a.setInstanceFollowRedirects(z);
    }

    public boolean getInstanceFollowRedirects() {
        return this.f50551a.getInstanceFollowRedirects();
    }

    public void setRequestMethod(String str) throws ProtocolException {
        try {
            this.f50551a.setRequestMethod(str);
        } catch (ProtocolException e) {
            mo123526a((IOException) e);
            throw e;
        }
    }

    public String getRequestMethod() {
        return this.f50551a.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        try {
            int responseCode = this.f50551a.getResponseCode();
            this.f50552b.setStatusCode(responseCode);
            return responseCode;
        } catch (IOException e) {
            mo123526a(e);
            throw e;
        }
    }

    public String getResponseMessage() throws IOException {
        try {
            return this.f50551a.getResponseMessage();
        } catch (IOException e) {
            mo123526a(e);
            throw e;
        }
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.f50551a.getHeaderFieldDate(str, j);
    }

    public Permission getPermission() throws IOException {
        try {
            return this.f50551a.getPermission();
        } catch (IOException e) {
            mo123526a(e);
            throw e;
        }
    }

    public InputStream getErrorStream() {
        return this.f50551a.getErrorStream();
    }

    public void setConnectTimeout(int i) {
        this.f50551a.setConnectTimeout(i);
    }

    public int getConnectTimeout() {
        return this.f50551a.getConnectTimeout();
    }

    public void setReadTimeout(int i) {
        this.f50551a.setReadTimeout(i);
    }

    public int getReadTimeout() {
        return this.f50551a.getReadTimeout();
    }

    public URL getURL() {
        return this.f50551a.getURL();
    }

    public int getContentLength() {
        return this.f50551a.getContentLength();
    }

    public long getContentLengthLong() {
        return this.f50551a.getContentLengthLong();
    }

    public String getContentType() {
        return this.f50551a.getContentType();
    }

    public String getContentEncoding() {
        return this.f50551a.getContentEncoding();
    }

    public long getExpiration() {
        return this.f50551a.getExpiration();
    }

    public long getDate() {
        return this.f50551a.getDate();
    }

    public long getLastModified() {
        return this.f50551a.getLastModified();
    }

    public String getHeaderField(String str) {
        return this.f50551a.getHeaderField(str);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.f50551a.getHeaderFields();
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.f50551a.getHeaderFieldInt(str, i);
    }

    public long getHeaderFieldLong(String str, long j) {
        return this.f50551a.getHeaderFieldLong(str, j);
    }

    public Object getContent() throws IOException {
        try {
            return this.f50551a.getContent();
        } catch (IOException e) {
            mo123526a(e);
            throw e;
        }
    }

    public Object getContent(Class[] clsArr) throws IOException {
        try {
            return this.f50551a.getContent(clsArr);
        } catch (IOException e) {
            mo123526a(e);
            throw e;
        }
    }

    public OutputStream getOutputStream() throws IOException {
        try {
            if (this.f50553c == null) {
                this.f50553c = new FlowOutputStream(this.f50551a.getOutputStream(), (FlowOutputStream.OutputStreamStatusListener) null);
            }
            return this.f50553c;
        } catch (IOException e) {
            mo123526a(e);
            throw e;
        }
    }

    public InputStream getInputStream() throws IOException {
        try {
            if (this.f50554d == null) {
                this.f50554d = new FlowInputStream(this.f50551a.getInputStream(), new FlowInputStream.InputStreamStatusListener() {
                    public final void onReadFinished(long j) {
                        MonitorHttpURLConnection.this.m36328a(j);
                    }
                });
            }
            return this.f50554d;
        } catch (IOException e) {
            mo123526a(e);
            throw e;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m36328a(long j) {
        FlowOutputStream flowOutputStream = this.f50553c;
        if (flowOutputStream != null) {
            this.f50552b.setUploadByteCount(flowOutputStream.getUploadByteCountAndClear());
        }
        this.f50552b.setDownloadByteCount(j);
        NetworkParamsDispatcher.onRequestFinished(this.f50552b);
        this.f50552b = new NetworkParam();
    }

    public String toString() {
        return this.f50551a.toString();
    }

    public void setDoInput(boolean z) {
        this.f50551a.setDoInput(z);
    }

    public boolean getDoInput() {
        return this.f50551a.getDoInput();
    }

    public void setDoOutput(boolean z) {
        this.f50551a.setDoOutput(z);
    }

    public boolean getDoOutput() {
        return this.f50551a.getDoOutput();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f50551a.setAllowUserInteraction(z);
    }

    public boolean getAllowUserInteraction() {
        return this.f50551a.getAllowUserInteraction();
    }

    public void setUseCaches(boolean z) {
        this.f50551a.setUseCaches(z);
    }

    public boolean getUseCaches() {
        return this.f50551a.getUseCaches();
    }

    public void setIfModifiedSince(long j) {
        this.f50551a.setIfModifiedSince(j);
    }

    public long getIfModifiedSince() {
        return this.f50551a.getIfModifiedSince();
    }

    public boolean getDefaultUseCaches() {
        return this.f50551a.getDefaultUseCaches();
    }

    public void setDefaultUseCaches(boolean z) {
        this.f50551a.setDefaultUseCaches(z);
    }

    public void setRequestProperty(String str, String str2) {
        this.f50551a.setRequestProperty(str, str2);
    }

    public void addRequestProperty(String str, String str2) {
        this.f50551a.addRequestProperty(str, str2);
    }

    public String getRequestProperty(String str) {
        return this.f50551a.getRequestProperty(str);
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f50551a.getRequestProperties();
    }

    public int hashCode() {
        return this.f50551a.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f50551a.equals(obj);
    }
}
