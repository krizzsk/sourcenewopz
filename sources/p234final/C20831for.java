package p234final;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import p234final.C20831for;

/* renamed from: final.for */
/* compiled from: Vibrator */
public class C20831for {

    /* renamed from: a */
    private final Vibrator f57231a;

    /* renamed from: b */
    private final Handler f57232b = new Handler();

    /* renamed from: final.for$do */
    /* compiled from: Vibrator */
    public enum C20832do {
        FACE_FOUND(50, new long[]{0, 20, 100, 20}, new int[]{0, 255, 0, 255}),
        COMPLETED(0, new long[]{0, 50, 100, 50}, new int[]{0, 255, 0, 255}),
        START_FLASHING(0, new long[]{0, 20}, new int[]{0, 255});
        
        /* access modifiers changed from: private */

        /* renamed from: do */
        public long f57233do;
        /* access modifiers changed from: private */

        /* renamed from: for  reason: not valid java name */
        public int[] f61839for;
        /* access modifiers changed from: private */

        /* renamed from: if */
        public long[] f57234if;

        private C20832do(long j, long[] jArr, int[] iArr) {
            this.f57233do = j;
            this.f57234if = jArr;
            this.f61839for = iArr;
        }
    }

    public C20831for(Context context) {
        this.f57231a = (Vibrator) context.getSystemService("vibrator");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41034b(C20832do doVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.f57231a.vibrate(VibrationEffect.createWaveform(doVar.f57234if, doVar.f61839for, -1));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } else {
            this.f57231a.vibrate(doVar.f57234if, -1, (AudioAttributes) null);
        }
    }

    /* renamed from: for  reason: not valid java name */
    public void m47637for(C20832do doVar) {
        if (this.f57231a.hasVibrator()) {
            this.f57232b.postDelayed(new Runnable(doVar) {
                public final /* synthetic */ C20831for.C20832do f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20831for.this.m41034b(this.f$1);
                }
            }, doVar.f57233do);
        }
    }
}
