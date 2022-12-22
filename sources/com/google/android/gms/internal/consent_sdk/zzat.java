package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzat implements ConsentForm {
    /* access modifiers changed from: private */
    public final Application zza;
    private final zzab zzb;
    private final zzbh zzc;
    private final zzal zzd;
    private final zzbb zze;
    private final zzct<zzbe> zzf;
    private Dialog zzg;
    private zzbe zzh;
    private final AtomicBoolean zzi = new AtomicBoolean();
    private final AtomicReference<zzax> zzj = new AtomicReference<>();
    private final AtomicReference<ConsentForm.OnConsentFormDismissedListener> zzk = new AtomicReference<>();
    private final AtomicReference<zzay> zzl = new AtomicReference<>();

    public zzat(Application application, zzab zzab, zzbh zzbh, zzal zzal, zzbb zzbb, zzct<zzbe> zzct) {
        this.zza = application;
        this.zzb = zzab;
        this.zzc = zzbh;
        this.zzd = zzal;
        this.zze = zzbb;
        this.zzf = zzct;
    }

    /* access modifiers changed from: package-private */
    public final void zza(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzbe zza2 = this.zzf.zza();
        this.zzh = zza2;
        zza2.setBackgroundColor(0);
        zza2.getSettings().setJavaScriptEnabled(true);
        zza2.setWebViewClient(new zzbf(zza2));
        this.zzj.set(new zzax(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener));
        this.zzh.loadDataWithBaseURL(this.zze.zza(), this.zze.zzb(), "text/html", "UTF-8", (String) null);
        zzcd.zza.postDelayed(new zzaw(this), 10000);
    }

    /* access modifiers changed from: package-private */
    public final zzbe zza() {
        return this.zzh;
    }

    public final void show(Activity activity, ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        zzcd.zza();
        if (!this.zzi.compareAndSet(false, true)) {
            onConsentFormDismissedListener.onConsentFormDismissed(new zzk(3, "ConsentForm#show can only be invoked once.").zza());
            return;
        }
        zzay zzay = new zzay(this, activity);
        this.zza.registerActivityLifecycleCallbacks(zzay);
        this.zzl.set(zzay);
        this.zzc.zza(activity);
        Dialog dialog = new Dialog(activity, 16973840);
        dialog.setContentView(this.zzh);
        dialog.setCancelable(false);
        Window window = dialog.getWindow();
        if (window == null) {
            onConsentFormDismissedListener.onConsentFormDismissed(new zzk(3, "Activity with null windows is passed in.").zza());
            return;
        }
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        this.zzk.set(onConsentFormDismissedListener);
        SystemUtils.showDialog(dialog);
        this.zzg = dialog;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        zzax andSet = this.zzj.getAndSet((Object) null);
        if (andSet != null) {
            andSet.onConsentFormLoadSuccess(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzk zzk2) {
        zzax andSet = this.zzj.getAndSet((Object) null);
        if (andSet != null) {
            andSet.onConsentFormLoadFailure(zzk2.zza());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, int i2) {
        zzd();
        ConsentForm.OnConsentFormDismissedListener andSet = this.zzk.getAndSet((Object) null);
        if (andSet != null) {
            this.zzd.zza(3);
            this.zzd.zzb(i2);
            andSet.onConsentFormDismissed((FormError) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzk zzk2) {
        zzd();
        ConsentForm.OnConsentFormDismissedListener andSet = this.zzk.getAndSet((Object) null);
        if (andSet != null) {
            andSet.onConsentFormDismissed(zzk2.zza());
        }
    }

    private final void zzd() {
        Dialog dialog = this.zzg;
        if (dialog != null) {
            dialog.dismiss();
            this.zzg = null;
        }
        this.zzc.zza((Activity) null);
        zzay andSet = this.zzl.getAndSet((Object) null);
        if (andSet != null) {
            andSet.zza();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        zza(new zzk(4, "Web view timed out."));
    }
}
