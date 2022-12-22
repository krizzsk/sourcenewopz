package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzqa extends Surface {
    private static boolean zzble;
    private static boolean zzblf;
    private final boolean zzbdc;
    private final zzqc zzblg;
    private boolean zzblh;

    public static synchronized boolean zzc(Context context) {
        boolean z;
        synchronized (zzqa.class) {
            if (!zzblf) {
                if (zzpt.SDK_INT >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (!(zzpt.SDK_INT == 24 && (zzpt.MODEL.startsWith("SM-G950") || zzpt.MODEL.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    zzble = z2;
                }
                zzblf = true;
            }
            z = zzble;
        }
        return z;
    }

    public static zzqa zzc(Context context, boolean z) {
        if (zzpt.SDK_INT >= 17) {
            zzpg.checkState(!z || zzc(context));
            return new zzqc().zzn(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    private zzqa(zzqc zzqc, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.zzblg = zzqc;
        this.zzbdc = z;
    }

    public final void release() {
        super.release();
        synchronized (this.zzblg) {
            if (!this.zzblh) {
                this.zzblg.release();
                this.zzblh = true;
            }
        }
    }
}
