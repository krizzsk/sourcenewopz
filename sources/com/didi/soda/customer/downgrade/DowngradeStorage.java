package com.didi.soda.customer.downgrade;

import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.storage.CustomerStorage;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

public class DowngradeStorage extends CustomerStorage<DowngradeConfig> implements DowngradeToggle {

    /* renamed from: a */
    private static final int f40882a = 1;

    /* renamed from: b */
    private static final String f40883b = "DowngradeStorage";

    /* renamed from: c */
    private DowngradeConfig f40884c;

    public boolean isDowngradeNavigation() {
        return false;
    }

    DowngradeStorage() {
        DowngradeConfig downgradeConfig = (DowngradeConfig) getData();
        this.f40884c = downgradeConfig;
        if (downgradeConfig == null) {
            this.f40884c = new DowngradeConfig();
        }
        LogUtil.m29104i(f40883b, "Read cached toggle mToggle = " + this.f40884c.mToggle + " mDowngradeMap = " + this.f40884c.mDowngradeMap + " mDowngradeIM = " + this.f40884c.mDowngradeIM + " mDowngradeFacebookLogin = " + this.f40884c.mDowngradeFacebookLogin + " mDowngradeShare = " + this.f40884c.mDowngradeShare + " mDowngradeGoogleLogin = " + this.f40884c.mDowngradeGoogleLogin);
        Apollo.addCacheLoadedListener(new OnCacheLoadedListener() {
            public final void onCacheAlreadyLoaded() {
                DowngradeStorage.this.m29050c();
            }
        });
        Apollo.addToggleStateChangeListener(new OnToggleStateChangeListener() {
            public final void onStateChanged() {
                DowngradeStorage.this.m29049b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m29050c() {
        LogUtil.m29104i(f40883b, "onCacheAlreadyLoaded");
        m29047a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m29049b() {
        LogUtil.m29104i(f40883b, "onStateChanged");
        m29047a();
    }

    /* renamed from: a */
    private void m29047a() {
        DowngradeConfig downGradeConfig = CustomerApolloUtil.getDownGradeConfig();
        LogUtil.m29104i(f40883b, "updateCachedApolloToggle mToggle = " + downGradeConfig.mToggle + " mDowngradeMap = " + downGradeConfig.mDowngradeMap + " mDowngradeIM = " + downGradeConfig.mDowngradeIM + " mDowngradeFacebookLogin = " + downGradeConfig.mDowngradeFacebookLogin + " mDowngradeShare = " + downGradeConfig.mDowngradeShare + " mDowngradeGoogleLogin = " + downGradeConfig.mDowngradeGoogleLogin);
        setData(downGradeConfig);
        m29048a(downGradeConfig);
    }

    /* renamed from: a */
    private void m29048a(DowngradeConfig downgradeConfig) {
        LogUtil.m29104i(f40883b, "updateMemoryCachedToggle data: " + downgradeConfig);
        if (downgradeConfig.mToggle == 1) {
            this.f40884c.mToggle = 1;
        }
        if (downgradeConfig.mDowngradeIM == 1) {
            this.f40884c.mDowngradeIM = 1;
        }
        if (downgradeConfig.mDowngradeMap == 1) {
            this.f40884c.mDowngradeMap = 1;
        }
        if (downgradeConfig.mDowngradeShare == 1) {
            this.f40884c.mDowngradeShare = 1;
        }
        if (downgradeConfig.mDowngradeFacebookLogin == 1) {
            this.f40884c.mDowngradeFacebookLogin = 1;
        }
        if (downgradeConfig.mDowngradeGoogleLogin == 1) {
            this.f40884c.mDowngradeGoogleLogin = 1;
        }
    }

    public boolean toggle() {
        return this.f40884c.mToggle == 1;
    }

    public boolean isDowngradeMap() {
        return this.f40884c.mDowngradeMap == 1;
    }

    public boolean isDowngradeIM() {
        return this.f40884c.mDowngradeIM == 1;
    }

    public boolean isDowngradeShare() {
        return this.f40884c.mDowngradeShare == 1;
    }

    public boolean isDowngradeFaceBookLogin() {
        return this.f40884c.mDowngradeFacebookLogin == 1;
    }

    public boolean isDowngradeGoogleLogin() {
        return this.f40884c.mDowngradeGoogleLogin == 1;
    }
}
