package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzad;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzh extends RelativeLayout {
    private zzad zzdts;
    boolean zzdtt;

    public zzh(Context context, String str, String str2, String str3) {
        super(context);
        zzad zzad = new zzad(context, str);
        this.zzdts = zzad;
        zzad.zzu(str2);
        this.zzdts.setAdUnitId(str3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzdtt) {
            return false;
        }
        this.zzdts.zzd(motionEvent);
        return false;
    }
}
