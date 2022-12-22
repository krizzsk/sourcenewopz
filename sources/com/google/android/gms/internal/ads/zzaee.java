package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaee extends zzaev {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzdgv;
    private final double zzdgw;

    public zzaee(Drawable drawable, Uri uri2, double d, int i, int i2) {
        this.zzdgv = drawable;
        this.uri = uri2;
        this.zzdgw = d;
        this.width = i;
        this.height = i2;
    }

    public final IObjectWrapper zztn() throws RemoteException {
        return ObjectWrapper.wrap(this.zzdgv);
    }

    public final Uri getUri() throws RemoteException {
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
