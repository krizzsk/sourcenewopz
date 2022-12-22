package com.example.compapollovisitor;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public abstract class BaseApollo {
    private static final String TAG = "DriverApollo";
    private boolean mAllow;

    /* access modifiers changed from: protected */
    public abstract String getKey();

    /* access modifiers changed from: protected */
    public abstract void initParams(IExperiment iExperiment);

    /* access modifiers changed from: protected */
    public abstract boolean reAllow();

    public boolean allow() {
        return this.mAllow;
    }

    public void init() {
        String key = getKey();
        if (!TextUtils.isEmpty(key)) {
            try {
                IToggle toggle = Apollo.getToggle(key);
                this.mAllow = toggle.allow();
                DLog.m7384d(TAG, "initApollo Key=%s | %s", key, toggle);
                if (reAllow()) {
                    ApolloVisitHelper.getInstance().addApolloKey(key);
                }
                if (this.mAllow) {
                    initParams(toggle.getExperiment());
                }
            } catch (Throwable th) {
                DLog.m7384d(TAG, "initApollo Key=" + key + " Exception = " + th, new Object[0]);
            }
        }
    }
}
