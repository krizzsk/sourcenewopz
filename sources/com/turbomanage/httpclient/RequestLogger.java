package com.turbomanage.httpclient;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface RequestLogger {
    boolean isLoggingEnabled();

    void log(String str);

    void logRequest(HttpURLConnection httpURLConnection, Object obj) throws IOException;

    void logResponse(HttpResponse httpResponse);
}
