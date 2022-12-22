package org.osgi.service.url;

import java.net.URL;

public interface URLStreamHandlerSetter {
    void setURL(URL url, String str, String str2, int i, String str3, String str4);

    void setURL(URL url, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7);
}
