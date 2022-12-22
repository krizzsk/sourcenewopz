package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcdd extends zzaeq {
    private final zzcdr zzgeo;
    private IObjectWrapper zzgfm;

    public zzcdd(zzcdr zzcdr) {
        this.zzgeo = zzcdr;
    }

    public final float getAspectRatio() throws RemoteException {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcyw)).booleanValue()) {
            return 0.0f;
        }
        if (this.zzgeo.getMediaContentAspectRatio() != 0.0f) {
            return this.zzgeo.getMediaContentAspectRatio();
        }
        if (this.zzgeo.getVideoController() != null) {
            return zzaoi();
        }
        IObjectWrapper iObjectWrapper = this.zzgfm;
        if (iObjectWrapper != null) {
            return zzat(iObjectWrapper);
        }
        zzaes zzaoq = this.zzgeo.zzaoq();
        if (zzaoq == null) {
            return 0.0f;
        }
        float width = (zzaoq == null || zzaoq.getWidth() == -1 || zzaoq.getHeight() == -1) ? 0.0f : ((float) zzaoq.getWidth()) / ((float) zzaoq.getHeight());
        if (width != 0.0f) {
            return width;
        }
        return zzat(zzaoq.zztn());
    }

    public final float getDuration() throws RemoteException {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue() && this.zzgeo.getVideoController() != null) {
            return this.zzgeo.getVideoController().getDuration();
        }
        return 0.0f;
    }

    public final float getCurrentTime() throws RemoteException {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue() && this.zzgeo.getVideoController() != null) {
            return this.zzgeo.getVideoController().getCurrentTime();
        }
        return 0.0f;
    }

    public final zzzd getVideoController() throws RemoteException {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue()) {
            return null;
        }
        return this.zzgeo.getVideoController();
    }

    public final boolean hasVideoContent() throws RemoteException {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue() && this.zzgeo.getVideoController() != null) {
            return true;
        }
        return false;
    }

    public final void zza(zzage zzage) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue() && (this.zzgeo.getVideoController() instanceof zzbgc)) {
            ((zzbgc) this.zzgeo.getVideoController()).zza(zzage);
        }
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzctx)).booleanValue()) {
            this.zzgfm = iObjectWrapper;
        }
    }

    public final IObjectWrapper zztr() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzgfm;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzaes zzaoq = this.zzgeo.zzaoq();
        if (zzaoq == null) {
            return null;
        }
        return zzaoq.zztn();
    }

    private final float zzaoi() {
        try {
            return this.zzgeo.getVideoController().getAspectRatio();
        } catch (RemoteException e) {
            zzd.zzc("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    private static float zzat(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }
}
