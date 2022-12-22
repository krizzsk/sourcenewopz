package com.didi.foundation.sdk.upgrade;

import android.content.Context;
import com.didichuxing.foundation.spi.ServiceLoader;

public final class UpgradeService implements UpgradeServiceProvider {

    /* renamed from: a */
    private final UpgradeServiceProvider f21385a;

    private UpgradeService() {
        this.f21385a = (UpgradeServiceProvider) ServiceLoader.load(UpgradeServiceProvider.class).get();
    }

    public static final UpgradeService getInstance() {
        return Singleton.INSTANCE;
    }

    public final void checkUpdate(String str, Context context, String str2, String str3, String str4, double d, double d2, LogListener logListener, UpgradeListener upgradeListener) {
        UpgradeServiceProvider upgradeServiceProvider = this.f21385a;
        if (upgradeServiceProvider != null) {
            upgradeServiceProvider.checkUpdate(str, context, str2, str3, str4, d, d2, logListener, upgradeListener);
        }
    }

    public final void goToGooglePlay(Context context, String str, String str2) {
        UpgradeServiceProvider upgradeServiceProvider = this.f21385a;
        if (upgradeServiceProvider != null) {
            upgradeServiceProvider.goToGooglePlay(context, str, str2);
        }
    }

    public final boolean isGooglePlay(String str) {
        UpgradeServiceProvider upgradeServiceProvider = this.f21385a;
        return upgradeServiceProvider != null && upgradeServiceProvider.isGooglePlay(str);
    }

    public final void releaseDownloadSdk() {
        UpgradeServiceProvider upgradeServiceProvider = this.f21385a;
        if (upgradeServiceProvider != null) {
            upgradeServiceProvider.releaseDownloadSdk();
        }
    }

    public final void startDownload(Context context, UpgradeEntity upgradeEntity, DownloadListener downloadListener) {
        UpgradeServiceProvider upgradeServiceProvider = this.f21385a;
        if (upgradeServiceProvider != null) {
            upgradeServiceProvider.startDownload(context, upgradeEntity, downloadListener);
        }
    }

    private static final class Singleton {
        static final UpgradeService INSTANCE = new UpgradeService();

        private Singleton() {
        }
    }
}
