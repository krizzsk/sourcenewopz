package org.osgi.service.url;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public interface URLStreamHandlerService {
    boolean equals(URL url, URL url2);

    int getDefaultPort();

    InetAddress getHostAddress(URL url);

    int hashCode(URL url);

    boolean hostsEqual(URL url, URL url2);

    URLConnection openConnection(URL url) throws IOException;

    void parseURL(URLStreamHandlerSetter uRLStreamHandlerSetter, URL url, String str, int i, int i2);

    boolean sameFile(URL url, URL url2);

    String toExternalForm(URL url);
}
