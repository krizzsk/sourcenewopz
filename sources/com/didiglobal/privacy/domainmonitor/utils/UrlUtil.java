package com.didiglobal.privacy.domainmonitor.utils;

import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didiglobal.privacy.domainmonitor.DomainMonitor;
import com.didiglobal.privacy.domainmonitor.model.InterceptRouter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

public class UrlUtil {
    public static String getAbsoluteUrl(HttpURLConnection httpURLConnection) {
        URL url = httpURLConnection.getURL();
        if (url == null) {
            return "";
        }
        return getAbsoluteUrl(url.toString());
    }

    public static String getAbsoluteUrl(String str) {
        return (str == null || str.trim().length() <= 0 || !str.contains("?")) ? str : str.substring(0, str.indexOf("?"));
    }

    public static String getBFFAbilityName(InputStream inputStream) {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            String str = new String(bArr);
            StringBuilder sb = new StringBuilder();
            Map<String, Object> json2Map = JsonUtil.json2Map(str);
            if (json2Map != null && json2Map.containsKey("abilities")) {
                for (String append : ((Map) json2Map.get("abilities")).keySet()) {
                    sb.append(append);
                    sb.append("__");
                }
                sb.delete(sb.length() - 2, sb.length());
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<InterceptRouter> stringToList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            InterceptRouter[] interceptRouterArr = (InterceptRouter[]) JsonUtil.fromJson(str, InterceptRouter[].class);
            for (int i = 0; i < interceptRouterArr.length; i++) {
                String osType = interceptRouterArr[i].getOsType();
                if (osType.equals("both") || osType.equals("android")) {
                    arrayList.add(interceptRouterArr[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String getTraceId(HttpRpcRequest httpRpcRequest) {
        String header = httpRpcRequest.getHeader("didi-header-rid");
        return header != null ? header : "";
    }

    public static String getRequestSources(String str) {
        String urlQueryParam = getUrlQueryParam(str, "request_sources");
        return urlQueryParam != null ? urlQueryParam : "android";
    }

    public static String getRequestSources(URLConnection uRLConnection) {
        String urlQueryParam;
        URL url = uRLConnection.getURL();
        if (url == null || (urlQueryParam = getUrlQueryParam(url.toString(), "request_sources")) == null) {
            return "android";
        }
        return urlQueryParam;
    }

    public static String getUrlQueryParam(String str, String str2) {
        Map<String, String> params = ParseUrlParamUtil.getParams(str);
        if (params.isEmpty() || !params.containsKey(str2)) {
            return null;
        }
        return params.get(str2);
    }

    public static String replaceUrl(HttpUrl httpUrl) {
        return replaceUrl(httpUrl.toString(), httpUrl.host(), httpUrl.encodedPath());
    }

    public static String replaceUrl(URL url) {
        return replaceUrl(url.toString(), url.getHost(), url.getPath());
    }

    public static String replaceUrl(String str, String str2, String str3) {
        if (DomainMonitor.getRedirectList().isEmpty()) {
            return "";
        }
        for (InterceptRouter next : DomainMonitor.getRedirectList()) {
            String matchType = next.getMatchType();
            char c = 65535;
            int hashCode = matchType.hashCode();
            if (hashCode != 3029889) {
                if (hashCode != 3208616) {
                    if (hashCode == 3433509 && matchType.equals("path")) {
                        c = 1;
                    }
                } else if (matchType.equals("host")) {
                    c = 0;
                }
            } else if (matchType.equals("both")) {
                c = 2;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        throw new IllegalStateException("Unexpected value: " + next.getMatchType());
                    } else if (str3.equals(next.getPathOriginal()) && str2.equals(next.getHostOriginal())) {
                        return str.replace(str2 + str3, next.getHostNew() + next.getPathNew());
                    }
                } else if (str3.equals(next.getPathOriginal())) {
                    return str.replace(str3, next.getPathNew());
                }
            } else if (str2.equals(next.getHostOriginal())) {
                return str.replace(str2, next.getHostNew());
            }
        }
        return "";
    }
}
