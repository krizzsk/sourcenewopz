package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class zag implements DialogInterface.OnClickListener {
    public static zag zab(Activity activity, Intent intent, int i) {
        return new zad(intent, activity, i);
    }

    public static zag zac(Fragment fragment, Intent intent, int i) {
        return new zae(intent, fragment, i);
    }

    public static zag zad(LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new zaf(intent, lifecycleFragment, 2);
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        try {
            zaa();
        } catch (ActivityNotFoundException e) {
            SystemUtils.log(6, "DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e, "com.google.android.gms.common.internal.zag", 3);
        } finally {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zaa();
}
