package com.didi.foundation.sdk.upgrade;

import android.content.Context;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface UpgradeServiceProvider {
    void checkUpdate(String str, Context context, String str2, String str3, String str4, double d, double d2, LogListener logListener, UpgradeListener upgradeListener);

    void goToGooglePlay(Context context, String str, String str2);

    boolean isGooglePlay(String str);

    void releaseDownloadSdk();

    void startDownload(Context context, UpgradeEntity upgradeEntity, DownloadListener downloadListener);
}
