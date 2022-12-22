package com.didichuxing.foundation.net.http;

import com.koushikdutta.async.http.AsyncHttpDelete;

public enum HttpMethod {
    GET,
    POST,
    PUT,
    DELETE,
    HEAD,
    PATCH,
    MOVE,
    OPTIONS,
    REPORT,
    PROPFIND,
    PROPPATCH,
    MKCOL,
    LOCK;

    public boolean invalidatesCache() {
        return invalidatesCache(name());
    }

    public boolean requiresRequestBody() {
        return requiresRequestBody(name());
    }

    public boolean permitsRequestBody() {
        return permitsRequestBody(name());
    }

    public static boolean invalidatesCache(String str) {
        return str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PATCH") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase(AsyncHttpDelete.METHOD) || str.equalsIgnoreCase("MOVE");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("PATCH") || str.equalsIgnoreCase("PROPPATCH") || str.equalsIgnoreCase("REPORT");
    }

    public static boolean permitsRequestBody(String str) {
        return requiresRequestBody(str) || str.equalsIgnoreCase("OPTIONS") || str.equalsIgnoreCase(AsyncHttpDelete.METHOD) || str.equalsIgnoreCase("PROPFIND") || str.equalsIgnoreCase("MKCOL") || str.equalsIgnoreCase("LOCK");
    }
}
