package com.didichuxing.bigdata.p173dp.locsdk;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.PermRetryApollo */
public class PermRetryApollo {

    /* renamed from: a */
    private boolean f45717a;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.PermRetryApollo$Holder */
    private static class Holder {
        static PermRetryApollo instance = new PermRetryApollo();

        private Holder() {
        }
    }

    public static PermRetryApollo getInstance() {
        return Holder.instance;
    }

    private PermRetryApollo() {
        IToggle toggle = Apollo.getToggle("map_common_loc_perm_retry_AB");
        if (toggle == null || !toggle.allow() || toggle.getExperiment() == null) {
            DLog.m32737d("map_common_loc_perm_retry_AB not allow");
            return;
        }
        boolean z = ((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() == 1;
        this.f45717a = z;
        if (z) {
            DLog.m32737d("map_common_loc_perm_retry_AB enabled");
        } else {
            DLog.m32737d("map_common_loc_perm_retry_AB not enable");
        }
    }

    public boolean shouldRetryLoc() {
        return this.f45717a;
    }
}
