package org.osgi.service.url;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public abstract class AbstractURLStreamHandlerService extends URLStreamHandler implements URLStreamHandlerService {
    protected volatile URLStreamHandlerSetter realHandler;

    public abstract URLConnection openConnection(URL url) throws IOException;

    public void parseURL(URLStreamHandlerSetter uRLStreamHandlerSetter, URL url, String str, int i, int i2) {
        this.realHandler = uRLStreamHandlerSetter;
        parseURL(url, str, i, i2);
    }

    public String toExternalForm(URL url) {
        return super.toExternalForm(url);
    }

    public boolean equals(URL url, URL url2) {
        return super.equals(url, url2);
    }

    public int getDefaultPort() {
        return super.getDefaultPort();
    }

    public InetAddress getHostAddress(URL url) {
        return super.getHostAddress(url);
    }

    public int hashCode(URL url) {
        return super.hashCode(url);
    }

    public boolean hostsEqual(URL url, URL url2) {
        return super.hostsEqual(url, url2);
    }

    public boolean sameFile(URL url, URL url2) {
        return super.sameFile(url, url2);
    }

    /* access modifiers changed from: protected */
    public void setURL(URL url, String str, String str2, int i, String str3, String str4) {
        this.realHandler.setURL(url, str, str2, i, str3, str4);
    }

    /* access modifiers changed from: protected */
    public void setURL(URL url, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7) {
        this.realHandler.setURL(url, str, str2, i, str3, str4, str5, str6, str7);
    }
}
