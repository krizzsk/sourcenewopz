package didihttp.internal.trace;

import android.util.Log;
import com.didi.beatles.p099im.views.bottombar.IMSkinTextView;
import com.didi.raven.config.RavenKey;
import didihttp.internal.C20747Util;
import didinet.ApolloAPI;
import didinet.Logger;
import didinet.NetEngine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class IcpStatStrategy {

    /* renamed from: a */
    private static final String f56903a = "IcpStatStrategy";

    /* renamed from: b */
    private static final int f56904b = 200;

    /* renamed from: c */
    private boolean f56905c;

    /* renamed from: d */
    private Map<String, Integer> f56906d;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static IcpStatStrategy INSTANCE = new IcpStatStrategy();

        private SingletonHolder() {
        }
    }

    /* renamed from: a */
    static IcpStatStrategy m40852a() {
        return SingletonHolder.INSTANCE;
    }

    private IcpStatStrategy() {
        this.f56905c = false;
        this.f56906d = new HashMap();
        m40854c();
    }

    /* renamed from: c */
    private void m40854c() {
        ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
        boolean allow = apolloAPI.getToggle("icp_conf").allow();
        this.f56905c = allow;
        if (allow) {
            ApolloAPI.Experiment experiment = apolloAPI.getToggle("icp_conf").getExperiment();
            if (((Integer) experiment.getParam(RavenKey.VERSION, 0)).intValue() == 1) {
                m40853a(experiment);
            } else {
                this.f56905c = false;
            }
        }
    }

    /* renamed from: a */
    private void m40853a(ApolloAPI.Experiment experiment) {
        String str = (String) experiment.getParam("l", "");
        try {
            this.f56906d.clear();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.f56906d.put(next, Integer.valueOf(jSONObject.optInt(next)));
            }
        } catch (JSONException e) {
            Logger.m40928d(f56903a, "parseParam: " + Log.getStackTraceString(e));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo170360a(Tree tree) {
        if (tree == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Node next : tree.transformToList()) {
            String fixClassName = C20747Util.fixClassName(next.value.toString());
            int i = 200;
            if (this.f56906d.containsKey(fixClassName)) {
                i = this.f56906d.get(fixClassName).intValue();
            } else if (this.f56906d.containsKey(IMSkinTextView.IM_SKIN_COMMON)) {
                i = this.f56906d.get(IMSkinTextView.IM_SKIN_COMMON).intValue();
            }
            if (next.cost > ((long) i)) {
                sb.append(fixClassName);
                sb.append(":");
                sb.append(next.cost);
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo170361b() {
        return this.f56905c;
    }
}
