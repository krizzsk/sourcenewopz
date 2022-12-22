package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    public static final AdSize zzadc = new AdSize(50, 50, "50x50_mb");
    private final int height;
    private final int width;
    private final String zzadd;
    private boolean zzade;
    private boolean zzadf;
    private int zzadg;
    private boolean zzadh;
    private int zzadi;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdSize(int r5, int r6) {
        /*
            r4 = this;
            r0 = -1
            if (r5 != r0) goto L_0x0006
            java.lang.String r0 = "FULL"
            goto L_0x000a
        L_0x0006:
            java.lang.String r0 = java.lang.String.valueOf(r5)
        L_0x000a:
            r1 = -2
            if (r6 != r1) goto L_0x0010
            java.lang.String r1 = "AUTO"
            goto L_0x0014
        L_0x0010:
            java.lang.String r1 = java.lang.String.valueOf(r6)
        L_0x0014:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 4
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = "x"
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = "_as"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r4.<init>(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.width = i;
            this.height = i2;
            this.zzadd = str;
        } else {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize zza = zzbae.zza(context, i, 50, 1);
        zza.zzade = true;
        return zza;
    }

    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize zza = zzbae.zza(context, i, 50, 2);
        zza.zzade = true;
        return zza;
    }

    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize zza = zzbae.zza(context, i, 50, 0);
        zza.zzade = true;
        return zza;
    }

    @Deprecated
    public static AdSize getPortraitBannerAdSizeWithWidth(Context context, int i) {
        return getPortraitAnchoredAdaptiveBannerAdSize(context, i);
    }

    @Deprecated
    public static AdSize getLandscapeBannerAdSizeWithWidth(Context context, int i) {
        return getLandscapeAnchoredAdaptiveBannerAdSize(context, i);
    }

    @Deprecated
    public static AdSize getCurrentOrientationBannerAdSizeWithWidth(Context context, int i) {
        return getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, i);
    }

    public static AdSize getPortraitInlineAdaptiveBannerAdSize(Context context, int i) {
        int zzg = zzbae.zzg(context, 1);
        AdSize adSize = new AdSize(i, 0);
        if (zzg == -1) {
            return INVALID;
        }
        adSize.zzadg = zzg;
        adSize.zzadf = true;
        return adSize;
    }

    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(Context context, int i) {
        int zzg = zzbae.zzg(context, 2);
        AdSize adSize = new AdSize(i, 0);
        if (zzg == -1) {
            return INVALID;
        }
        adSize.zzadg = zzg;
        adSize.zzadf = true;
        return adSize;
    }

    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i) {
        int zzg = zzbae.zzg(context, 0);
        if (zzg == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i, 0);
        adSize.zzadg = zzg;
        adSize.zzadf = true;
        return adSize;
    }

    public static AdSize getPortraitInterscrollerAdSize(Context context, int i) {
        return zza(i, zzbae.zzg(context, 1));
    }

    public static AdSize getLandscapeInterscrollerAdSize(Context context, int i) {
        return zza(i, zzbae.zzg(context, 2));
    }

    public static AdSize getCurrentOrientationInterscrollerAdSize(Context context, int i) {
        return zza(i, zzbae.zzg(context, 0));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.width == adSize.width && this.height == adSize.height && this.zzadd.equals(adSize.zzadd);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getHeightInPixels(Context context) {
        int i = this.height;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -2) {
            return zzvt.zzc(context.getResources().getDisplayMetrics());
        }
        zzww.zzqw();
        return zzbae.zze(context, this.height);
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getWidthInPixels(Context context) {
        int i = this.width;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -1) {
            return zzvt.zzb(context.getResources().getDisplayMetrics());
        }
        zzww.zzqw();
        return zzbae.zze(context, this.width);
    }

    public final int hashCode() {
        return this.zzadd.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.height == -2;
    }

    public final boolean isFullWidth() {
        return this.width == -1;
    }

    public final boolean isFluid() {
        return this.width == -3 && this.height == -4;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzdu() {
        return this.zzade;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzdv() {
        return this.zzadf;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(boolean z) {
        this.zzadf = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzr(int i) {
        this.zzadg = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzdw() {
        return this.zzadg;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzdx() {
        return this.zzadh;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(boolean z) {
        this.zzadh = true;
    }

    /* access modifiers changed from: package-private */
    public final int zzdy() {
        return this.zzadi;
    }

    /* access modifiers changed from: package-private */
    public final void zzs(int i) {
        this.zzadi = i;
    }

    public final String toString() {
        return this.zzadd;
    }

    private static AdSize zza(int i, int i2) {
        if (i2 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i, 0);
        adSize.zzadi = i2;
        adSize.zzadh = true;
        return adSize;
    }
}
