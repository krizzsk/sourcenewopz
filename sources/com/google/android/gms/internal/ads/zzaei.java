package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaei extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaei> CREATOR = new zzael();
    public final int versionCode;
    public final int zzboc;
    public final int zzbod;
    public final boolean zzboe;
    public final int zzbof;
    public final boolean zzboh;
    public final boolean zzdgx;
    public final zzaaz zzdgy;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzaei(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaaz(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjx(), nativeAdOptions.getMediaAspectRatio());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzaei(com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), -1, nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaaz(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjx(), nativeAdOptions.getMediaAspectRatio());
    }

    public zzaei(int i, boolean z, int i2, boolean z2, int i3, zzaaz zzaaz, boolean z3, int i4) {
        this.versionCode = i;
        this.zzdgx = z;
        this.zzboc = i2;
        this.zzboe = z2;
        this.zzbof = i3;
        this.zzdgy = zzaaz;
        this.zzboh = z3;
        this.zzbod = i4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdgx);
        SafeParcelWriter.writeInt(parcel, 3, this.zzboc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzboe);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbof);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdgy, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzboh);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbod);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static com.google.android.gms.ads.nativead.NativeAdOptions zzb(zzaei zzaei) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzaei == null) {
            return builder.build();
        }
        int i = zzaei.versionCode;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    builder.setRequestCustomMuteThisAd(zzaei.zzboh).setMediaAspectRatio(zzaei.zzbod);
                }
                builder.setReturnUrlsForImageAssets(zzaei.zzdgx).setRequestMultipleImages(zzaei.zzboe);
                return builder.build();
            }
            zzaaz zzaaz = zzaei.zzdgy;
            if (zzaaz != null) {
                builder.setVideoOptions(new VideoOptions(zzaaz));
            }
        }
        builder.setAdChoicesPlacement(zzaei.zzbof);
        builder.setReturnUrlsForImageAssets(zzaei.zzdgx).setRequestMultipleImages(zzaei.zzboe);
        return builder.build();
    }

    public static com.google.android.gms.ads.formats.NativeAdOptions zzc(zzaei zzaei) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzaei == null) {
            return builder.build();
        }
        int i = zzaei.versionCode;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    builder.setRequestCustomMuteThisAd(zzaei.zzboh).setMediaAspectRatio(zzaei.zzbod);
                }
                builder.setReturnUrlsForImageAssets(zzaei.zzdgx).setImageOrientation(zzaei.zzboc).setRequestMultipleImages(zzaei.zzboe);
                return builder.build();
            }
            zzaaz zzaaz = zzaei.zzdgy;
            if (zzaaz != null) {
                builder.setVideoOptions(new VideoOptions(zzaaz));
            }
        }
        builder.setAdChoicesPlacement(zzaei.zzbof);
        builder.setReturnUrlsForImageAssets(zzaei.zzdgx).setImageOrientation(zzaei.zzboc).setRequestMultipleImages(zzaei.zzboe);
        return builder.build();
    }
}
