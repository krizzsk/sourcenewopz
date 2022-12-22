package com.didi.payment.commonsdk.spi;

import android.app.Activity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/spi/JumioServiceProvider;", "", "checkPermissions", "", "ctx", "Landroid/app/Activity;", "isSupportedPlatform", "startDDCustomActivity", "", "activity", "token", "", "type", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioServiceProvider.kt */
public interface JumioServiceProvider {
    boolean checkPermissions(Activity activity);

    boolean isSupportedPlatform(Activity activity);

    void startDDCustomActivity(Activity activity, String str, String str2);
}
