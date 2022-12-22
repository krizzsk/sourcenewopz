package com.didichuxing.mas.sdk.quality.init;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpTransactionEventReductionUtil {

    /* renamed from: a */
    private static final String f48249a = "HttpEventReduction";

    /* renamed from: b */
    private static final Map<String, Integer> f48250b = new ConcurrentHashMap();

    /* renamed from: a */
    static void m34408a(String str) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle(str, false);
        if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
            m34410b((String) experiment.getParam("black_list", ""));
        }
    }

    /* renamed from: b */
    static void m34410b(String str) {
        f48250b.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("l");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        f48250b.put(optJSONArray.optString(i, ""), 0);
                    }
                }
            } catch (JSONException e) {
                SystemUtils.log(6, f48249a, "", e, "com.didichuxing.mas.sdk.quality.init.HttpTransactionEventReductionUtil", 58);
            }
        }
    }

    /* renamed from: a */
    static boolean m34409a(String str, int i) {
        if (f48250b.isEmpty()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (!f48250b.containsKey(m34411c(str)) || i != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static String m34411c(String str) {
        try {
            URL url = new URL(str);
            String host = url.getHost();
            String path = url.getPath();
            return host + path;
        } catch (MalformedURLException e) {
            SystemUtils.log(6, f48249a, "", e, "com.didichuxing.mas.sdk.quality.init.HttpTransactionEventReductionUtil", 89);
            return str;
        }
    }
}
