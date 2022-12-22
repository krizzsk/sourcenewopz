package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbcb extends FrameLayout implements zzbca {
    private final zzbcs zzekz;
    private final FrameLayout zzely;
    private final zzach zzelz;
    private final zzbcu zzema;
    private final long zzemb;
    private zzbbz zzemc;
    private boolean zzemd;
    private boolean zzeme;
    private boolean zzemf;
    private boolean zzemg;
    private long zzemh;
    private long zzemi;
    private String zzemj;
    private String[] zzemk;
    private Bitmap zzeml;
    private ImageView zzemm;
    private boolean zzemn;

    public static void zza(zzbcs zzbcs) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzbcs.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    public static void zza(zzbcs zzbcs, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbcs.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    public static void zza(zzbcs zzbcs, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        zzbcs.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbcb(Context context, zzbcs zzbcs, int i, boolean z, zzach zzach, zzbcp zzbcp) {
        super(context);
        Context context2 = context;
        this.zzekz = zzbcs;
        this.zzelz = zzach;
        this.zzely = new FrameLayout(context);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcnz)).booleanValue()) {
            this.zzely.setBackgroundResource(17170444);
        }
        addView(this.zzely, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbcs.zzaby());
        zzbbz zza = zzbcs.zzaby().zzbov.zza(context, zzbcs, i, z, zzach, zzbcp);
        this.zzemc = zza;
        if (zza != null) {
            this.zzely.addView(zza, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcnq)).booleanValue()) {
                zzabk();
            }
        }
        this.zzemm = new ImageView(context);
        this.zzemb = ((Long) zzww.zzra().zzd(zzabq.zzcnu)).longValue();
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcns)).booleanValue();
        this.zzemg = booleanValue;
        zzach zzach2 = this.zzelz;
        if (zzach2 != null) {
            zzach2.zzg("spinner_used", booleanValue ? "1" : "0");
        }
        this.zzema = new zzbcu(this);
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.zza(this);
        }
        if (this.zzemc == null) {
            zzl("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzely.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzc(String str, String[] strArr) {
        this.zzemj = str;
        this.zzemk = strArr;
    }

    public final void zza(float f, float f2) {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.zza(f, f2);
        }
    }

    public final void zzic() {
        if (this.zzemc != null) {
            if (!TextUtils.isEmpty(this.zzemj)) {
                this.zzemc.zzb(this.zzemj, this.zzemk);
            } else {
                zzd("no_src", new String[0]);
            }
        }
    }

    public final void pause() {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.pause();
        }
    }

    public final void play() {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.play();
        }
    }

    public final void seekTo(int i) {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.seekTo(i);
        }
    }

    public final void zzabi() {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.zzelx.setMuted(true);
            zzbbz.zzabc();
        }
    }

    public final void zzabj() {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.zzelx.setMuted(false);
            zzbbz.zzabc();
        }
    }

    public final void setVolume(float f) {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.zzelx.setVolume(f);
            zzbbz.zzabc();
        }
    }

    public final void zzdq(int i) {
        this.zzemc.zzdq(i);
    }

    public final void zzdr(int i) {
        this.zzemc.zzdr(i);
    }

    public final void zzds(int i) {
        this.zzemc.zzds(i);
    }

    public final void zzdt(int i) {
        this.zzemc.zzdt(i);
    }

    public final void zzdu(int i) {
        this.zzemc.zzdu(i);
    }

    public final void zze(MotionEvent motionEvent) {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzabk() {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            TextView textView = new TextView(zzbbz.getContext());
            String valueOf = String.valueOf(this.zzemc.zzaaw());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzely.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzely.bringChildToFront(textView);
        }
    }

    public final void zzabd() {
        this.zzema.resume();
        zzj.zzegq.post(new zzbcg(this));
    }

    public final void zzff() {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null && this.zzemi == 0) {
            zzd("canplaythrough", "duration", String.valueOf(((float) zzbbz.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.zzemc.getVideoWidth()), "videoHeight", String.valueOf(this.zzemc.getVideoHeight()));
        }
    }

    public final void zzabe() {
        if (this.zzekz.zzabx() != null && !this.zzeme) {
            boolean z = (this.zzekz.zzabx().getWindow().getAttributes().flags & 128) != 0;
            this.zzemf = z;
            if (!z) {
                this.zzekz.zzabx().getWindow().addFlags(128);
                this.zzeme = true;
            }
        }
        this.zzemd = true;
    }

    public final void onPaused() {
        zzd("pause", new String[0]);
        zzabn();
        this.zzemd = false;
    }

    public final void zzabf() {
        zzd("ended", new String[0]);
        zzabn();
    }

    public final void zzl(String str, String str2) {
        zzd("error", "what", str, "extra", str2);
    }

    public final void zzm(String str, String str2) {
        zzd("exception", "what", str, "extra", str2);
    }

    public final void zzabg() {
        if (this.zzemn && this.zzeml != null && !zzabm()) {
            this.zzemm.setImageBitmap(this.zzeml);
            this.zzemm.invalidate();
            this.zzely.addView(this.zzemm, new FrameLayout.LayoutParams(-1, -1));
            this.zzely.bringChildToFront(this.zzemm);
        }
        this.zzema.pause();
        this.zzemi = this.zzemh;
        zzj.zzegq.post(new zzbcf(this));
    }

    public final void destroy() {
        this.zzema.pause();
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            zzbbz.stop();
        }
        zzabn();
    }

    public final void finalize() throws Throwable {
        try {
            this.zzema.pause();
            if (this.zzemc != null) {
                zzbbz zzbbz = this.zzemc;
                zzebs zzebs = zzbat.zzeki;
                zzbbz.getClass();
                zzebs.execute(zzbce.zza(zzbbz));
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzabl() {
        zzbbz zzbbz = this.zzemc;
        if (zzbbz != null) {
            long currentPosition = (long) zzbbz.getCurrentPosition();
            if (this.zzemh != currentPosition && currentPosition > 0) {
                float f = ((float) currentPosition) / 1000.0f;
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue()) {
                    zzd("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzemc.getTotalBytes()), "qoeCachedBytes", String.valueOf(this.zzemc.zznh()), "qoeLoadedBytes", String.valueOf(this.zzemc.zzaba()), "droppedFrames", String.valueOf(this.zzemc.zzabb()), "reportTime", String.valueOf(zzr.zzlc().currentTimeMillis()));
                } else {
                    zzd("timeupdate", "time", String.valueOf(f));
                }
                this.zzemh = currentPosition;
            }
        }
    }

    public final void zzabh() {
        if (this.zzemd && zzabm()) {
            this.zzely.removeView(this.zzemm);
        }
        if (this.zzeml != null) {
            long elapsedRealtime = zzr.zzlc().elapsedRealtime();
            if (this.zzemc.getBitmap(this.zzeml) != null) {
                this.zzemn = true;
            }
            long elapsedRealtime2 = zzr.zzlc().elapsedRealtime() - elapsedRealtime;
            if (zzd.zzyz()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzd.zzed(sb.toString());
            }
            if (elapsedRealtime2 > this.zzemb) {
                zzd.zzez("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzemg = false;
                this.zzeml = null;
                zzach zzach = this.zzelz;
                if (zzach != null) {
                    zzach.zzg("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzm(int i, int i2) {
        if (this.zzemg) {
            int max = Math.max(i / ((Integer) zzww.zzra().zzd(zzabq.zzcnt)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzww.zzra().zzd(zzabq.zzcnt)).intValue(), 1);
            Bitmap bitmap = this.zzeml;
            if (bitmap == null || bitmap.getWidth() != max || this.zzeml.getHeight() != max2) {
                this.zzeml = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzemn = false;
            }
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzema.resume();
        } else {
            this.zzema.pause();
            this.zzemi = this.zzemh;
        }
        zzj.zzegq.post(new zzbcd(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzema.resume();
            z = true;
        } else {
            this.zzema.pause();
            this.zzemi = this.zzemh;
            z = false;
        }
        zzj.zzegq.post(new zzbci(this, z));
    }

    private final boolean zzabm() {
        return this.zzemm.getParent() != null;
    }

    /* access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzekz.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    private final void zzabn() {
        if (this.zzekz.zzabx() != null && this.zzeme && !this.zzemf) {
            this.zzekz.zzabx().getWindow().clearFlags(128);
            this.zzeme = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzay(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }
}
