package com.didi.entrega.customer.downgrade;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.storage.CustomerStorage;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

public class DowngradeStorage extends CustomerStorage<DowngradeConfig> implements DowngradeToggle {

    /* renamed from: a */
    private static final int f19885a = 1;

    /* renamed from: b */
    private static final String f19886b = "DowngradeStorage";

    /* renamed from: c */
    private DowngradeConfig f19887c;

    public boolean isDowngradeNavigation() {
        return false;
    }

    DowngradeStorage() {
        DowngradeConfig downgradeConfig = (DowngradeConfig) getData();
        this.f19887c = downgradeConfig;
        if (downgradeConfig == null) {
            this.f19887c = new DowngradeConfig();
        }
        LogUtil.m14765i(f19886b, "Read cached toggle mToggle = " + this.f19887c.mToggle + " mDowngradeMap = " + this.f19887c.mDowngradeMap + " mDowngradeIM = " + this.f19887c.mDowngradeIM + " mDowngradeFacebookLogin = " + this.f19887c.mDowngradeFacebookLogin + " mDowngradeShare = " + this.f19887c.mDowngradeShare + " mDowngradeGoogleLogin = " + this.f19887c.mDowngradeGoogleLogin);
        Apollo.addCacheLoadedListener(new OnCacheLoadedListener() {
            public final void onCacheAlreadyLoaded() {
                DowngradeStorage.this.m14719c();
            }
        });
        Apollo.addToggleStateChangeListener(new OnToggleStateChangeListener() {
            public final void onStateChanged() {
                DowngradeStorage.this.m14718b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m14719c() {
        LogUtil.m14765i(f19886b, "onCacheAlreadyLoaded");
        m14716a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m14718b() {
        LogUtil.m14765i(f19886b, "onStateChanged");
        m14716a();
    }

    /* renamed from: a */
    private void m14716a() {
        DowngradeConfig downGradeConfig = CustomerApolloUtil.getDownGradeConfig();
        LogUtil.m14765i(f19886b, "updateCachedApolloToggle mToggle = " + downGradeConfig.mToggle + " mDowngradeMap = " + downGradeConfig.mDowngradeMap + " mDowngradeIM = " + downGradeConfig.mDowngradeIM + " mDowngradeFacebookLogin = " + downGradeConfig.mDowngradeFacebookLogin + " mDowngradeShare = " + downGradeConfig.mDowngradeShare + " mDowngradeGoogleLogin = " + downGradeConfig.mDowngradeGoogleLogin);
        setData(downGradeConfig);
        m14717a(downGradeConfig);
    }

    /* renamed from: a */
    private void m14717a(DowngradeConfig downgradeConfig) {
        LogUtil.m14765i(f19886b, "updateMemoryCachedToggle data: " + downgradeConfig);
        if (downgradeConfig.mToggle == 1) {
            this.f19887c.mToggle = 1;
        }
        if (downgradeConfig.mDowngradeIM == 1) {
            this.f19887c.mDowngradeIM = 1;
        }
        if (downgradeConfig.mDowngradeMap == 1) {
            this.f19887c.mDowngradeMap = 1;
        }
        if (downgradeConfig.mDowngradeShare == 1) {
            this.f19887c.mDowngradeShare = 1;
        }
        if (downgradeConfig.mDowngradeFacebookLogin == 1) {
            this.f19887c.mDowngradeFacebookLogin = 1;
        }
        if (downgradeConfig.mDowngradeGoogleLogin == 1) {
            this.f19887c.mDowngradeGoogleLogin = 1;
        }
    }

    public boolean toggle() {
        return this.f19887c.mToggle == 1;
    }

    public boolean isDowngradeMap() {
        return this.f19887c.mDowngradeMap == 1;
    }

    public boolean isDowngradeIM() {
        return this.f19887c.mDowngradeIM == 1;
    }

    public boolean isDowngradeShare() {
        return this.f19887c.mDowngradeShare == 1;
    }

    public boolean isDowngradeFaceBookLogin() {
        return this.f19887c.mDowngradeFacebookLogin == 1;
    }

    public boolean isDowngradeGoogleLogin() {
        return this.f19887c.mDowngradeGoogleLogin == 1;
    }
}
