package com.didiglobal.privacy.domainmonitor.urlconnection;

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
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public class MonitorHttpsURLConnection extends HttpsURLConnection {

    /* renamed from: a */
    private final HttpsURLConnection f50555a;

    /* renamed from: b */
    private final MonitorHttpURLConnection f50556b;

    protected MonitorHttpsURLConnection(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        this.f50556b = new MonitorHttpURLConnection(httpsURLConnection);
        this.f50555a = httpsURLConnection;
    }

    public String getCipherSuite() {
        return this.f50555a.getCipherSuite();
    }

    public Certificate[] getLocalCertificates() {
        return this.f50555a.getLocalCertificates();
    }

    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        try {
            return this.f50555a.getServerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            this.f50556b.mo123526a((IOException) e);
            throw e;
        }
    }

    public void disconnect() {
        this.f50556b.disconnect();
    }

    public boolean usingProxy() {
        return this.f50556b.usingProxy();
    }

    public void connect() throws IOException {
        this.f50556b.connect();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        try {
            return this.f50555a.getPeerPrincipal();
        } catch (SSLPeerUnverifiedException e) {
            this.f50556b.mo123526a((IOException) e);
            throw e;
        }
    }

    public Principal getLocalPrincipal() {
        return this.f50555a.getLocalPrincipal();
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f50555a.setHostnameVerifier(hostnameVerifier);
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f50555a.getHostnameVerifier();
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f50555a.setSSLSocketFactory(sSLSocketFactory);
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.f50555a.getSSLSocketFactory();
    }

    public String getHeaderFieldKey(int i) {
        return this.f50556b.getHeaderFieldKey(i);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f50556b.setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long j) {
        this.f50556b.setFixedLengthStreamingMode(j);
    }

    public void setChunkedStreamingMode(int i) {
        this.f50556b.setChunkedStreamingMode(i);
    }

    public String getHeaderField(int i) {
        return this.f50556b.getHeaderField(i);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f50556b.setInstanceFollowRedirects(z);
    }

    public boolean getInstanceFollowRedirects() {
        return this.f50556b.getInstanceFollowRedirects();
    }

    public void setRequestMethod(String str) throws ProtocolException {
        this.f50556b.setRequestMethod(str);
    }

    public String getRequestMethod() {
        return this.f50556b.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        return this.f50556b.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return this.f50556b.getResponseMessage();
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.f50556b.getHeaderFieldDate(str, j);
    }

    public Permission getPermission() throws IOException {
        return this.f50556b.getPermission();
    }

    public InputStream getErrorStream() {
        return this.f50556b.getErrorStream();
    }

    public void setConnectTimeout(int i) {
        this.f50556b.setConnectTimeout(i);
    }

    public int getConnectTimeout() {
        return this.f50556b.getConnectTimeout();
    }

    public void setReadTimeout(int i) {
        this.f50556b.setReadTimeout(i);
    }

    public int getReadTimeout() {
        return this.f50556b.getReadTimeout();
    }

    public URL getURL() {
        return this.f50556b.getURL();
    }

    public int getContentLength() {
        return this.f50556b.getContentLength();
    }

    public long getContentLengthLong() {
        return this.f50556b.getContentLengthLong();
    }

    public String getContentType() {
        return this.f50556b.getContentType();
    }

    public String getContentEncoding() {
        return this.f50556b.getContentEncoding();
    }

    public long getExpiration() {
        return this.f50556b.getExpiration();
    }

    public long getDate() {
        return this.f50556b.getDate();
    }

    public long getLastModified() {
        return this.f50556b.getLastModified();
    }

    public String getHeaderField(String str) {
        return this.f50556b.getHeaderField(str);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.f50556b.getHeaderFields();
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.f50556b.getHeaderFieldInt(str, i);
    }

    public long getHeaderFieldLong(String str, long j) {
        return this.f50556b.getHeaderFieldLong(str, j);
    }

    public Object getContent() throws IOException {
        return this.f50556b.getContent();
    }

    public Object getContent(Class[] clsArr) throws IOException {
        return this.f50556b.getContent(clsArr);
    }

    public InputStream getInputStream() throws IOException {
        return this.f50556b.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f50556b.getOutputStream();
    }

    public String toString() {
        return this.f50556b.toString();
    }

    public void setDoInput(boolean z) {
        this.f50556b.setDoInput(z);
    }

    public boolean getDoInput() {
        return this.f50556b.getDoInput();
    }

    public void setDoOutput(boolean z) {
        this.f50556b.setDoOutput(z);
    }

    public boolean getDoOutput() {
        return this.f50556b.getDoOutput();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f50556b.setAllowUserInteraction(z);
    }

    public boolean getAllowUserInteraction() {
        return this.f50556b.getAllowUserInteraction();
    }

    public void setUseCaches(boolean z) {
        this.f50556b.setUseCaches(z);
    }

    public boolean getUseCaches() {
        return this.f50556b.getUseCaches();
    }

    public void setIfModifiedSince(long j) {
        this.f50556b.setIfModifiedSince(j);
    }

    public long getIfModifiedSince() {
        return this.f50556b.getIfModifiedSince();
    }

    public boolean getDefaultUseCaches() {
        return this.f50556b.getDefaultUseCaches();
    }

    public void setDefaultUseCaches(boolean z) {
        this.f50556b.setDefaultUseCaches(z);
    }

    public void setRequestProperty(String str, String str2) {
        this.f50556b.setRequestProperty(str, str2);
    }

    public void addRequestProperty(String str, String str2) {
        this.f50556b.addRequestProperty(str, str2);
    }

    public String getRequestProperty(String str) {
        return this.f50556b.getRequestProperty(str);
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f50556b.getRequestProperties();
    }

    public int hashCode() {
        return this.f50556b.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f50556b.equals(obj);
    }
}
