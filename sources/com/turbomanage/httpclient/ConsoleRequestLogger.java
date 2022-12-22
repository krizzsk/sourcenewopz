package com.turbomanage.httpclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class ConsoleRequestLogger implements RequestLogger {
    public boolean isLoggingEnabled() {
        return true;
    }

    public void log(String str) {
        System.out.println(str);
    }

    public void logRequest(HttpURLConnection httpURLConnection, Object obj) throws IOException {
        log("=== HTTP Request ===");
        log(httpURLConnection.getRequestMethod() + " " + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            log("Content: " + ((String) obj));
        }
        logHeaders(httpURLConnection.getRequestProperties());
    }

    public void logResponse(HttpResponse httpResponse) {
        if (httpResponse != null) {
            log("=== HTTP Response ===");
            log("Receive url: " + httpResponse.getUrl());
            log("Status: " + httpResponse.getStatus());
            logHeaders(httpResponse.getHeaders());
            log("Content:\n" + httpResponse.getBodyAsString());
        }
    }

    private void logHeaders(Map<String, List<String>> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                for (String str : map.get(next)) {
                    log(next + ":" + str);
                }
            }
        }
    }
}
