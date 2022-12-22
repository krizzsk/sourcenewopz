package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzafp extends NativeContentAd {
    private final VideoController zzcks = new VideoController();
    private final List<NativeAd.Image> zzdhe = new ArrayList();
    private final NativeAd.AdChoicesInfo zzdhg;
    private final zzafk zzdhh;
    private final zzaex zzdhi;

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074 A[Catch:{ RemoteException -> 0x0081 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzafp(com.google.android.gms.internal.ads.zzafk r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdhe = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzcks = r1
            r5.zzdhh = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch:{ RemoteException -> 0x0053 }
            if (r6 == 0) goto L_0x0057
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x0053 }
        L_0x0020:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x0053 }
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x0053 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0053 }
            if (r3 == 0) goto L_0x0045
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0053 }
            if (r2 == 0) goto L_0x0045
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x0053 }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzaes     // Catch:{ RemoteException -> 0x0053 }
            if (r4 == 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzaes r3 = (com.google.android.gms.internal.ads.zzaes) r3     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0046
        L_0x003f:
            com.google.android.gms.internal.ads.zzaeu r3 = new com.google.android.gms.internal.ads.zzaeu     // Catch:{ RemoteException -> 0x0053 }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0046
        L_0x0045:
            r3 = r1
        L_0x0046:
            if (r3 == 0) goto L_0x0020
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.zzdhe     // Catch:{ RemoteException -> 0x0053 }
            com.google.android.gms.internal.ads.zzaex r4 = new com.google.android.gms.internal.ads.zzaex     // Catch:{ RemoteException -> 0x0053 }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x0053 }
            r2.add(r4)     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0020
        L_0x0053:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x0057:
            com.google.android.gms.internal.ads.zzafk r6 = r5.zzdhh     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.internal.ads.zzaes r6 = r6.zztw()     // Catch:{ RemoteException -> 0x0065 }
            if (r6 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzaex r2 = new com.google.android.gms.internal.ads.zzaex     // Catch:{ RemoteException -> 0x0065 }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x006a
        L_0x0065:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x0069:
            r2 = r1
        L_0x006a:
            r5.zzdhi = r2
            com.google.android.gms.internal.ads.zzafk r6 = r5.zzdhh     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzaek r6 = r6.zztu()     // Catch:{ RemoteException -> 0x0081 }
            if (r6 == 0) goto L_0x0085
            com.google.android.gms.internal.ads.zzaep r6 = new com.google.android.gms.internal.ads.zzaep     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzafk r2 = r5.zzdhh     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzaek r2 = r2.zztu()     // Catch:{ RemoteException -> 0x0081 }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x0081 }
            r1 = r6
            goto L_0x0085
        L_0x0081:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x0085:
            r5.zzdhg = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafp.<init>(com.google.android.gms.internal.ads.zzafk):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzts */
    public final IObjectWrapper zzjw() {
        try {
            return this.zzdhh.zzts();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzdhh.performClick(bundle);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdhh.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdhh.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.zzdhh.getHeadline();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzdhe;
    }

    public final CharSequence getBody() {
        try {
            return this.zzdhh.getBody();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getLogo() {
        return this.zzdhi;
    }

    public final CharSequence getCallToAction() {
        try {
            return this.zzdhh.getCallToAction();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final CharSequence getAdvertiser() {
        try {
            return this.zzdhh.getAdvertiser();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzdhh.getVideoController() != null) {
                this.zzcks.zza(this.zzdhh.getVideoController());
            }
        } catch (RemoteException e) {
            zzbao.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcks;
    }

    public final Bundle getExtras() {
        try {
            return this.zzdhh.getExtras();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdhg;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzdhh.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzdhh.destroy();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}
