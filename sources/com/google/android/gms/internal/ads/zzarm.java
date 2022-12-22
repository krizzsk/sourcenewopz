package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzarm extends NativeAd {
    private final List<NativeAd.Image> zzdhe = new ArrayList();
    private final zzags zzdhm;
    private final List<MuteThisAdReason> zzdhn = new ArrayList();
    private final zzarn zzdrx;
    private final NativeAd.AdChoicesInfo zzdry;

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0097 A[Catch:{ RemoteException -> 0x00a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzarm(com.google.android.gms.internal.ads.zzags r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdhe = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdhn = r1
            r5.zzdhm = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch:{ RemoteException -> 0x0043 }
            if (r6 == 0) goto L_0x0047
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x0043 }
        L_0x0020:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x0043 }
            if (r2 == 0) goto L_0x0047
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x0043 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0043 }
            if (r3 == 0) goto L_0x0035
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.internal.ads.zzaes r2 = com.google.android.gms.internal.ads.zzaev.zzo(r2)     // Catch:{ RemoteException -> 0x0043 }
            goto L_0x0036
        L_0x0035:
            r2 = r1
        L_0x0036:
            if (r2 == 0) goto L_0x0020
            java.util.List<com.google.android.gms.ads.nativead.NativeAd$Image> r3 = r5.zzdhe     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.internal.ads.zzarn r4 = new com.google.android.gms.internal.ads.zzarn     // Catch:{ RemoteException -> 0x0043 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0043 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0043 }
            goto L_0x0020
        L_0x0043:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x0047:
            com.google.android.gms.internal.ads.zzags r6 = r5.zzdhm     // Catch:{ RemoteException -> 0x0076 }
            java.util.List r6 = r6.getMuteThisAdReasons()     // Catch:{ RemoteException -> 0x0076 }
            if (r6 == 0) goto L_0x007a
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x0076 }
        L_0x0053:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x0076 }
            if (r2 == 0) goto L_0x007a
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x0076 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0076 }
            if (r3 == 0) goto L_0x0068
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0076 }
            com.google.android.gms.internal.ads.zzys r2 = com.google.android.gms.internal.ads.zzyr.zzg(r2)     // Catch:{ RemoteException -> 0x0076 }
            goto L_0x0069
        L_0x0068:
            r2 = r1
        L_0x0069:
            if (r2 == 0) goto L_0x0053
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzdhn     // Catch:{ RemoteException -> 0x0076 }
            com.google.android.gms.internal.ads.zzyt r4 = new com.google.android.gms.internal.ads.zzyt     // Catch:{ RemoteException -> 0x0076 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0076 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0076 }
            goto L_0x0053
        L_0x0076:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x007a:
            com.google.android.gms.internal.ads.zzags r6 = r5.zzdhm     // Catch:{ RemoteException -> 0x0088 }
            com.google.android.gms.internal.ads.zzaes r6 = r6.zztt()     // Catch:{ RemoteException -> 0x0088 }
            if (r6 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzarn r2 = new com.google.android.gms.internal.ads.zzarn     // Catch:{ RemoteException -> 0x0088 }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x0088 }
            goto L_0x008d
        L_0x0088:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x008c:
            r2 = r1
        L_0x008d:
            r5.zzdrx = r2
            com.google.android.gms.internal.ads.zzags r6 = r5.zzdhm     // Catch:{ RemoteException -> 0x00a4 }
            com.google.android.gms.internal.ads.zzaek r6 = r6.zztu()     // Catch:{ RemoteException -> 0x00a4 }
            if (r6 == 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzarl r6 = new com.google.android.gms.internal.ads.zzarl     // Catch:{ RemoteException -> 0x00a4 }
            com.google.android.gms.internal.ads.zzags r2 = r5.zzdhm     // Catch:{ RemoteException -> 0x00a4 }
            com.google.android.gms.internal.ads.zzaek r2 = r2.zztu()     // Catch:{ RemoteException -> 0x00a4 }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x00a4 }
            r1 = r6
            goto L_0x00a8
        L_0x00a4:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x00a8:
            r5.zzdry = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarm.<init>(com.google.android.gms.internal.ads.zzags):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzts */
    public final IObjectWrapper zzjw() {
        try {
            return this.zzdhm.zzts();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzdhm.performClick(bundle);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdhm.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdhm.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final String getHeadline() {
        try {
            return this.zzdhm.getHeadline();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzdhe;
    }

    public final String getBody() {
        try {
            return this.zzdhm.getBody();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzdrx;
    }

    public final String getCallToAction() {
        try {
            return this.zzdhm.getCallToAction();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double starRating = this.zzdhm.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zzdhm.getStore();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final String getPrice() {
        try {
            return this.zzdhm.getPrice();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdry;
    }

    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzdhm.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
        return new Bundle();
    }

    public final void enableCustomClickGesture() {
        try {
            this.zzdhm.zzud();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzdhm.isCustomClickGestureEnabled();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return false;
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zzdhm.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdhn;
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdhm.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return false;
        }
    }

    public final void destroy() {
        try {
            this.zzdhm.destroy();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final void setUnconfirmedClickListener(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdhm.zza((zzagr) new zzarv(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzbao.zzc("Failed to setUnconfirmedClickListener", e);
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbao.zzex("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.zzdhm.zza((zzys) null);
            } else if (muteThisAdReason instanceof zzyt) {
                this.zzdhm.zza(((zzyt) muteThisAdReason).zzrl());
            } else {
                zzbao.zzex("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdhm.zza((zzyo) new zzyp(muteThisAdListener));
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zzdhm.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzbao.zzc("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final String getAdvertiser() {
        try {
            return this.zzdhm.getAdvertiser();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zzdhm.zzue() != null) {
                return new zzaab(this.zzdhm.zzue());
            }
            return null;
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzzc zzzc;
        try {
            zzzc = this.zzdhm.zzkm();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            zzzc = null;
        }
        return ResponseInfo.zza(zzzc);
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdhm.zza((zzyx) new zzaaq(onPaidEventListener));
        } catch (RemoteException e) {
            zzbao.zzc("Failed to setOnPaidEventListener", e);
        }
    }
}
