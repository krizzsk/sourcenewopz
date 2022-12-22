package com.didichuxing.ditest.assistant;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class EnvSwitchManager {
    private static EnvSwitchManager instance;
    private Map<String, String> hostMap;

    private EnvSwitchManager() {
        if (this.hostMap == null) {
            this.hostMap = new HashMap();
        }
    }

    public static synchronized EnvSwitchManager getInstance() {
        EnvSwitchManager envSwitchManager;
        synchronized (EnvSwitchManager.class) {
            if (instance == null) {
                instance = new EnvSwitchManager();
            }
            envSwitchManager = instance;
        }
        return envSwitchManager;
    }

    public void addReplaceRule(String str, String str2) {
        synchronized (this.hostMap) {
            this.hostMap.put(str, str2);
        }
    }

    public void clearReplaceRule() {
        synchronized (this.hostMap) {
            this.hostMap.clear();
        }
    }

    public String replaceHost(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.hostMap) {
            for (String next : this.hostMap.keySet()) {
                if (str.contains(next)) {
                    String replace = str.replace(next, this.hostMap.get(next));
                    return replace;
                }
            }
            return str;
        }
    }

    public URL replaceHost(URL url) {
        if (url == null) {
            return null;
        }
        synchronized (this.hostMap) {
            for (String next : this.hostMap.keySet()) {
                if (url.toString().contains(next)) {
                    try {
                        StringBuilder sb = new StringBuilder(url.toString().replace(next, this.hostMap.get(next)));
                        if (url.getQuery() != null && url.getQuery().length() > 0) {
                            sb.append("?");
                            sb.append(url.getQuery());
                        }
                        URL url2 = new URL(sb.toString());
                        return url2;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return url;
                    }
                }
            }
            return url;
        }
    }

    public HttpsURLConnection replaceHttpsURLConnection(HttpsURLConnection httpsURLConnection) {
        try {
            URL replaceURL = replaceURL(httpsURLConnection);
            if (replaceURL != null && !replaceURL.equals(httpsURLConnection.getURL())) {
                return (HttpsURLConnection) replaceURL.openConnection();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return httpsURLConnection;
    }

    private URL replaceURL(URLConnection uRLConnection) throws MalformedURLException {
        if (uRLConnection.getURL() != null) {
            String replaceHost = replaceHost(uRLConnection.getURL().toString());
            if (!uRLConnection.getURL().toString().equals(replaceHost)) {
                StringBuilder sb = new StringBuilder(replaceHost);
                if (uRLConnection.getURL().getQuery() != null && uRLConnection.getURL().getQuery().length() > 0) {
                    sb.append("?");
                    sb.append(uRLConnection.getURL().getQuery());
                }
                return new URL(sb.toString());
            }
        }
        return uRLConnection.getURL();
    }

    public HttpURLConnection replaceHttpURLConnection(HttpURLConnection httpURLConnection) {
        try {
            URL replaceURL = replaceURL(httpURLConnection);
            if (replaceURL != null && !replaceURL.equals(httpURLConnection.getURL())) {
                return (HttpURLConnection) replaceURL.openConnection();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return httpURLConnection;
    }

    public boolean isEffect() {
        return this.hostMap.size() > 0;
    }
}
