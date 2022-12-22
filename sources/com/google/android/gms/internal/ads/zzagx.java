package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzagx extends UnifiedNativeAd {
    private final VideoController zzcks = new VideoController();
    private final List<NativeAd.Image> zzdhe = new ArrayList();
    private final zzaex zzdhf;
    private final NativeAd.AdChoicesInfo zzdhg;
    private final zzags zzdhm;
    private final List<MuteThisAdReason> zzdhn = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A[Catch:{ RemoteException -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzagx(com.google.android.gms.internal.ads.zzags r6) {
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
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdhn = r1
            r5.zzdhm = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch:{ RemoteException -> 0x005a }
            if (r6 == 0) goto L_0x005e
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x005a }
        L_0x0027:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x005e
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x005a }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005a }
            if (r3 == 0) goto L_0x004c
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x004c
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005a }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzaes     // Catch:{ RemoteException -> 0x005a }
            if (r4 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzaes r3 = (com.google.android.gms.internal.ads.zzaes) r3     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004d
        L_0x0046:
            com.google.android.gms.internal.ads.zzaeu r3 = new com.google.android.gms.internal.ads.zzaeu     // Catch:{ RemoteException -> 0x005a }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004d
        L_0x004c:
            r3 = r1
        L_0x004d:
            if (r3 == 0) goto L_0x0027
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.zzdhe     // Catch:{ RemoteException -> 0x005a }
            com.google.android.gms.internal.ads.zzaex r4 = new com.google.android.gms.internal.ads.zzaex     // Catch:{ RemoteException -> 0x005a }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x005a }
            r2.add(r4)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x0027
        L_0x005a:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x005e:
            com.google.android.gms.internal.ads.zzags r6 = r5.zzdhm     // Catch:{ RemoteException -> 0x008d }
            java.util.List r6 = r6.getMuteThisAdReasons()     // Catch:{ RemoteException -> 0x008d }
            if (r6 == 0) goto L_0x0091
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x008d }
        L_0x006a:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x008d }
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x008d }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x008d }
            if (r3 == 0) goto L_0x007f
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzys r2 = com.google.android.gms.internal.ads.zzyr.zzg(r2)     // Catch:{ RemoteException -> 0x008d }
            goto L_0x0080
        L_0x007f:
            r2 = r1
        L_0x0080:
            if (r2 == 0) goto L_0x006a
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzdhn     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzyt r4 = new com.google.android.gms.internal.ads.zzyt     // Catch:{ RemoteException -> 0x008d }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x008d }
            r3.add(r4)     // Catch:{ RemoteException -> 0x008d }
            goto L_0x006a
        L_0x008d:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x0091:
            com.google.android.gms.internal.ads.zzags r6 = r5.zzdhm     // Catch:{ RemoteException -> 0x009f }
            com.google.android.gms.internal.ads.zzaes r6 = r6.zztt()     // Catch:{ RemoteException -> 0x009f }
            if (r6 == 0) goto L_0x00a3
            com.google.android.gms.internal.ads.zzaex r2 = new com.google.android.gms.internal.ads.zzaex     // Catch:{ RemoteException -> 0x009f }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x009f }
            goto L_0x00a4
        L_0x009f:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x00a3:
            r2 = r1
        L_0x00a4:
            r5.zzdhf = r2
            com.google.android.gms.internal.ads.zzags r6 = r5.zzdhm     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzaek r6 = r6.zztu()     // Catch:{ RemoteException -> 0x00bb }
            if (r6 == 0) goto L_0x00bf
            com.google.android.gms.internal.ads.zzaep r6 = new com.google.android.gms.internal.ads.zzaep     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzags r2 = r5.zzdhm     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzaek r2 = r2.zztu()     // Catch:{ RemoteException -> 0x00bb }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x00bb }
            r1 = r6
            goto L_0x00bf
        L_0x00bb:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbao.zzc(r0, r6)
        L_0x00bf:
            r5.zzdhg = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagx.<init>(com.google.android.gms.internal.ads.zzags):void");
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

    public final Object zzka() {
        try {
            IObjectWrapper zztv = this.zzdhm.zztv();
            if (zztv != null) {
                return ObjectWrapper.unwrap(zztv);
            }
            return null;
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
        return this.zzdhf;
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

    public final VideoController getVideoController() {
        try {
            if (this.zzdhm.getVideoController() != null) {
                this.zzcks.zza(this.zzdhm.getVideoController());
            }
        } catch (RemoteException e) {
            zzbao.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcks;
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdhg;
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzdhm.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
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

    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdhm.zza((zzagr) new zzahl(unconfirmedClickListener));
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
