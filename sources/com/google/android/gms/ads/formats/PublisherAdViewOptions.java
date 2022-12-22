package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzaax;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzagp;
import com.google.android.gms.internal.ads.zzvz;
import com.google.android.gms.internal.ads.zzxx;
import com.google.android.gms.internal.ads.zzxy;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zze();
    private final boolean zzbns;
    private final IBinder zzbnt;
    private final zzxy zzbon;
    private AppEventListener zzboo;

    private PublisherAdViewOptions(Builder builder) {
        this.zzbns = builder.zzbns;
        AppEventListener zzb = builder.zzboo;
        this.zzboo = zzb;
        zzaax zzaax = null;
        this.zzbon = zzb != null ? new zzvz(this.zzboo) : null;
        this.zzbnt = builder.zzbnu != null ? new zzaax(builder.zzbnu) : zzaax;
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbns = false;
        /* access modifiers changed from: private */
        public ShouldDelayBannerRenderingListener zzbnu;
        /* access modifiers changed from: private */
        public AppEventListener zzboo;

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbns = z;
            return this;
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzboo = appEventListener;
            return this;
        }

        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzbnu = shouldDelayBannerRenderingListener;
            return this;
        }

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }
    }

    PublisherAdViewOptions(boolean z, IBinder iBinder, IBinder iBinder2) {
        this.zzbns = z;
        this.zzbon = iBinder != null ? zzxx.zze(iBinder) : null;
        this.zzbnt = iBinder2;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboo;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbns;
    }

    public final zzxy zzjz() {
        return this.zzbon;
    }

    public final zzagm zzjv() {
        return zzagp.zzy(this.zzbnt);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzxy zzxy = this.zzbon;
        SafeParcelWriter.writeIBinder(parcel, 2, zzxy == null ? null : zzxy.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzbnt, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
