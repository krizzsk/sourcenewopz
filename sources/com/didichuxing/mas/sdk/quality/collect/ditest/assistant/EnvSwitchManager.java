package com.didichuxing.mas.sdk.quality.collect.ditest.assistant;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class EnvSwitchManager {

    /* renamed from: b */
    private static EnvSwitchManager f48071b;

    /* renamed from: a */
    private Map<String, String> f48072a;

    private EnvSwitchManager() {
        if (this.f48072a == null) {
            this.f48072a = new HashMap();
        }
    }

    public static synchronized EnvSwitchManager getInstance() {
        EnvSwitchManager envSwitchManager;
        synchronized (EnvSwitchManager.class) {
            if (f48071b == null) {
                f48071b = new EnvSwitchManager();
            }
            envSwitchManager = f48071b;
        }
        return envSwitchManager;
    }

    public void addReplaceRule(String str, String str2) {
        synchronized (this.f48072a) {
            this.f48072a.put(str, str2);
        }
    }

    public void clearReplaceRule() {
        synchronized (this.f48072a) {
            this.f48072a.clear();
        }
    }

    public String replaceHost(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.f48072a) {
            for (String next : this.f48072a.keySet()) {
                if (str.contains(next)) {
                    String replace = str.replace(next, this.f48072a.get(next));
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
        synchronized (this.f48072a) {
            for (String next : this.f48072a.keySet()) {
                if (url.toString().contains(next)) {
                    try {
                        StringBuilder sb = new StringBuilder(url.toString().replace(next, this.f48072a.get(next)));
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
            URL a = m34289a(httpsURLConnection);
            if (a != null && !a.equals(httpsURLConnection.getURL())) {
                return (HttpsURLConnection) a.openConnection();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return httpsURLConnection;
    }

    /* renamed from: a */
    private URL m34289a(URLConnection uRLConnection) throws MalformedURLException {
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
            URL a = m34289a(httpURLConnection);
            if (a != null && !a.equals(httpURLConnection.getURL())) {
                return (HttpURLConnection) a.openConnection();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return httpURLConnection;
    }

    public boolean isEffect() {
        return this.f48072a.size() > 0;
    }
}
