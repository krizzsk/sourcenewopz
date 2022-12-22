package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaex extends NativeAd.Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzdgw;
    private final zzaes zzdhb;
    private final Drawable zzdhc;

    public zzaex(zzaes zzaes) {
        Drawable drawable;
        int i;
        this.zzdhb = zzaes;
        Uri uri2 = null;
        try {
            IObjectWrapper zztn = zzaes.zztn();
            if (zztn != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zztn);
                this.zzdhc = drawable;
                uri2 = this.zzdhb.getUri();
                this.uri = uri2;
                double d = 1.0d;
                d = this.zzdhb.getScale();
                this.zzdgw = d;
                int i2 = -1;
                i = this.zzdhb.getWidth();
                this.width = i;
                i2 = this.zzdhb.getHeight();
                this.height = i2;
            }
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
        drawable = null;
        this.zzdhc = drawable;
        try {
            uri2 = this.zzdhb.getUri();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
        this.uri = uri2;
        double d2 = 1.0d;
        try {
            d2 = this.zzdhb.getScale();
        } catch (RemoteException e3) {
            zzbao.zzc("", e3);
        }
        this.zzdgw = d2;
        int i22 = -1;
        try {
            i = this.zzdhb.getWidth();
        } catch (RemoteException e4) {
            zzbao.zzc("", e4);
            i = -1;
        }
        this.width = i;
        try {
            i22 = this.zzdhb.getHeight();
        } catch (RemoteException e5) {
            zzbao.zzc("", e5);
        }
        this.height = i22;
    }

    public final Drawable getDrawable() {
        return this.zzdhc;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final double getScale() {
        return this.zzdgw;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
