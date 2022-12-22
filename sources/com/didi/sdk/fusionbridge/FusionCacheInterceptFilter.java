package com.didi.sdk.fusionbridge;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashSet;
import java.util.Set;

public class FusionCacheInterceptFilter {

    /* renamed from: a */
    private static final String f35945a = "global_fusion_cache_intercept_filter";

    /* renamed from: b */
    private static final String f35946b = "updateFlag";

    /* renamed from: c */
    private static final String f35947c = "blackList";
    public static FusionCacheInterceptFilter sInstance = new FusionCacheInterceptFilter();

    /* renamed from: d */
    private Set<String> f35948d = new HashSet();

    /* renamed from: e */
    private int f35949e = 0;

    public boolean shouldIntercept(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        IToggle toggle = Apollo.getToggle(f35945a, false);
        if (!toggle.allow()) {
            return false;
        }
        IExperiment experiment = toggle.getExperiment();
        if (m25451a(experiment)) {
            m25452b(experiment);
        }
        String[] split = str.split("\\?");
        if (split == null || split.length <= 0 || !this.f35948d.contains(split[0])) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m25451a(IExperiment iExperiment) {
        int i;
        try {
            i = Integer.parseInt((String) iExperiment.getParam(f35946b, "1"));
        } catch (Exception unused) {
            i = 1;
        }
        if (i <= this.f35949e) {
            return false;
        }
        this.f35949e = i;
        return true;
    }

    /* renamed from: b */
    private void m25452b(IExperiment iExperiment) {
        String str = (String) iExperiment.getParam(f35947c, "");
        this.f35948d.clear();
        if (!TextUtils.isEmpty(str)) {
            for (String add : str.split(",")) {
                this.f35948d.add(add);
            }
        }
    }
}
