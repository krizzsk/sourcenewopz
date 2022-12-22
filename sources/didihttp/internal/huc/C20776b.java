package didihttp.internal.huc;

import didihttp.Handshake;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: didihttp.internal.huc.b */
/* compiled from: DelegatingHttpsURLConnection */
abstract class C20776b extends HttpsURLConnection {

    /* renamed from: a */
    private final HttpURLConnection f56866a;

    public abstract HostnameVerifier getHostnameVerifier();

    public abstract SSLSocketFactory getSSLSocketFactory();

    /* access modifiers changed from: protected */
    public abstract Handshake handshake();

    public abstract void setHostnameVerifier(HostnameVerifier hostnameVerifier);

    public abstract void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory);

    public C20776b(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.f56866a = httpURLConnection;
    }

    public String getCipherSuite() {
        Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.cipherSuite().javaName();
        }
        return null;
    }

    public Certificate[] getLocalCertificates() {
        Handshake handshake = handshake();
        if (handshake == null) {
            return null;
        }
        List<Certificate> localCertificates = handshake.localCertificates();
        if (!localCertificates.isEmpty()) {
            return (Certificate[]) localCertificates.toArray(new Certificate[localCertificates.size()]);
        }
        return null;
    }

    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        Handshake handshake = handshake();
        if (handshake == null) {
            return null;
        }
        List<Certificate> peerCertificates = handshake.peerCertificates();
        if (!peerCertificates.isEmpty()) {
            return (Certificate[]) peerCertificates.toArray(new Certificate[peerCertificates.size()]);
        }
        return null;
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.peerPrincipal();
        }
        return null;
    }

    public Principal getLocalPrincipal() {
        Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.localPrincipal();
        }
        return null;
    }

    public void connect() throws IOException {
        this.connected = true;
        this.f56866a.connect();
    }

    public void disconnect() {
        this.f56866a.disconnect();
    }

    public InputStream getErrorStream() {
        return this.f56866a.getErrorStream();
    }

    public String getRequestMethod() {
        return this.f56866a.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        return this.f56866a.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return this.f56866a.getResponseMessage();
    }

    public void setRequestMethod(String str) throws ProtocolException {
        this.f56866a.setRequestMethod(str);
    }

    public boolean usingProxy() {
        return this.f56866a.usingProxy();
    }

    public boolean getInstanceFollowRedirects() {
        return this.f56866a.getInstanceFollowRedirects();
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f56866a.setInstanceFollowRedirects(z);
    }

    public boolean getAllowUserInteraction() {
        return this.f56866a.getAllowUserInteraction();
    }

    public Object getContent() throws IOException {
        return this.f56866a.getContent();
    }

    public Object getContent(Class[] clsArr) throws IOException {
        return this.f56866a.getContent(clsArr);
    }

    public String getContentEncoding() {
        return this.f56866a.getContentEncoding();
    }

    public int getContentLength() {
        return this.f56866a.getContentLength();
    }

    public long getContentLengthLong() {
        return this.f56866a.getContentLengthLong();
    }

    public String getContentType() {
        return this.f56866a.getContentType();
    }

    public long getDate() {
        return this.f56866a.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.f56866a.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f56866a.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f56866a.getDoOutput();
    }

    public long getExpiration() {
        return this.f56866a.getExpiration();
    }

    public String getHeaderField(int i) {
        return this.f56866a.getHeaderField(i);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.f56866a.getHeaderFields();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f56866a.getRequestProperties();
    }

    public void addRequestProperty(String str, String str2) {
        this.f56866a.addRequestProperty(str, str2);
    }

    public String getHeaderField(String str) {
        return this.f56866a.getHeaderField(str);
    }

    public long getHeaderFieldLong(String str, long j) {
        return this.f56866a.getHeaderFieldLong(str, j);
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.f56866a.getHeaderFieldDate(str, j);
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.f56866a.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        return this.f56866a.getHeaderFieldKey(i);
    }

    public long getIfModifiedSince() {
        return this.f56866a.getIfModifiedSince();
    }

    public InputStream getInputStream() throws IOException {
        return this.f56866a.getInputStream();
    }

    public long getLastModified() {
        return this.f56866a.getLastModified();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f56866a.getOutputStream();
    }

    public Permission getPermission() throws IOException {
        return this.f56866a.getPermission();
    }

    public String getRequestProperty(String str) {
        return this.f56866a.getRequestProperty(str);
    }

    public URL getURL() {
        return this.f56866a.getURL();
    }

    public boolean getUseCaches() {
        return this.f56866a.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f56866a.setAllowUserInteraction(z);
    }

    public void setDefaultUseCaches(boolean z) {
        this.f56866a.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.f56866a.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.f56866a.setDoOutput(z);
    }

    public void setFixedLengthStreamingMode(long j) {
        this.f56866a.setFixedLengthStreamingMode(j);
    }

    public void setIfModifiedSince(long j) {
        this.f56866a.setIfModifiedSince(j);
    }

    public void setRequestProperty(String str, String str2) {
        this.f56866a.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.f56866a.setUseCaches(z);
    }

    public void setConnectTimeout(int i) {
        this.f56866a.setConnectTimeout(i);
    }

    public int getConnectTimeout() {
        return this.f56866a.getConnectTimeout();
    }

    public void setReadTimeout(int i) {
        this.f56866a.setReadTimeout(i);
    }

    public int getReadTimeout() {
        return this.f56866a.getReadTimeout();
    }

    public String toString() {
        return this.f56866a.toString();
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f56866a.setFixedLengthStreamingMode(i);
    }

    public void setChunkedStreamingMode(int i) {
        this.f56866a.setChunkedStreamingMode(i);
    }
}
