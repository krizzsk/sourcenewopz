package p092super;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import com.didi.raven.config.RavenKey;
import com.iproov.sdk.cameray.C19775const;
import com.iproov.sdk.cameray.C19792try;
import com.iproov.sdk.face.model.FaceFeature;
import p092super.C3098for;
import p096try.C3136do;
import p096try.C3138if;
import p232do.C20822goto;
import p232do.C20825this;

/* renamed from: super.new */
/* compiled from: LightingDetectorImpl */
public class C3102new implements C3098for {

    /* renamed from: a */
    private final C3098for.C3099do f6884a;

    /* renamed from: b */
    private final C3104try f6885b;

    /* renamed from: c */
    private final C19775const f6886c;

    /* renamed from: d */
    private Bitmap f6887d;

    /* renamed from: e */
    private boolean f6888e = false;

    /* renamed from: f */
    private boolean f6889f = false;

    /* renamed from: g */
    private long f6890g = 0;

    public C3102new(Context context, C19792try tryR, C3097else elseR, C3098for.C3099do doVar, C20822goto gotoR) {
        this.f6885b = new C3104try(context, elseR, gotoR);
        this.f6886c = tryR.mo161905if();
        this.f6884a = doVar;
        StringBuilder sb = new StringBuilder();
        sb.append("Started lighting detector for ");
        sb.append(tryR.mo161905if());
    }

    /* renamed from: a */
    private boolean m3950a() {
        return this.f6886c == C19775const.CAMERA1;
    }

    /* renamed from: b */
    private void m3952b() {
        this.f6885b.mo38610e();
    }

    /* renamed from: do */
    public void mo38587do(C20825this thisR) {
        this.f6885b.mo38600a(thisR);
    }

    /* renamed from: for  reason: not valid java name */
    public C3138if.C3145if m46199for(Bitmap bitmap, FaceFeature faceFeature) throws C3095case {
        long currentTimeMillis = System.currentTimeMillis() - this.f6890g;
        StringBuilder sb = new StringBuilder();
        sb.append("Legacy: FRAME ");
        sb.append(this.f6888e ? "LOCKED" : "UNLOCKED");
        sb.append(" for ");
        sb.append(((double) currentTimeMillis) / 1000.0d);
        sb.append(RavenKey.STACK);
        if (this.f6888e) {
            C3138if.C3145if ifVar = mo38596if(bitmap, faceFeature);
            if (faceFeature == null) {
                this.f6884a.mo38592do(false);
            } else if (m3951a(currentTimeMillis)) {
                this.f6889f = true;
                this.f6884a.mo38592do(false);
            }
            return ifVar;
        } else if (faceFeature == null && !this.f6889f && !m3953b(currentTimeMillis)) {
            return null;
        } else {
            this.f6889f = false;
            this.f6884a.mo38591do();
            return null;
        }
    }

    /* renamed from: if */
    public C3138if.C3145if mo38596if(Bitmap bitmap, FaceFeature faceFeature) throws C3095case {
        if (faceFeature == null) {
            this.f6885b.mo38601a((Double) null);
            this.f6885b.mo38603a((C3101if) null);
            this.f6887d = null;
        } else {
            RectF faceBounds = faceFeature.getFaceBounds();
            float f = faceBounds.right;
            float f2 = faceBounds.left;
            float f3 = f - f2;
            int i = (int) ((((double) f3) * 0.6d) / 2.0d);
            float f4 = faceBounds.bottom;
            float f5 = faceBounds.top;
            float f6 = f4 - f5;
            Bitmap bitmap2 = C3100goto.m3948do(bitmap, ((int) f2) + i, ((int) f5) + i, ((int) f3) - (i * 2), ((int) f6) - (((int) ((((double) f6) * 0.4d) / 2.0d)) * 2));
            this.f6887d = bitmap2;
            C3101if ifVar = new C3101if(bitmap2);
            this.f6885b.mo38601a(Double.valueOf(faceFeature.getNormalizedSize()));
            this.f6885b.mo38603a(ifVar);
        }
        C3103this a = this.f6885b.mo38599a(m3950a());
        mo38594do(a);
        C3136do doVar = C3136do.READY;
        if (faceFeature == null) {
            doVar = C3136do.NO_FACE;
        } else if (this.f6885b.mo38608c()) {
            doVar = C3136do.TOO_BRIGHT;
        } else if (this.f6885b.mo38606b()) {
            doVar = C3136do.TOO_FAR;
        } else if (this.f6885b.mo38604a()) {
            doVar = C3136do.TOO_CLOSE;
        }
        return new C3138if.C3145if(doVar, a);
    }

    /* renamed from: do */
    public void mo38586do(float f) {
        this.f6885b.mo38602a(Float.valueOf(f));
    }

    /* renamed from: do */
    public C3138if.C3145if mo38585do(Bitmap bitmap, FaceFeature faceFeature) throws C3095case {
        return m3950a() ? m46199for(bitmap, faceFeature) : mo38596if(bitmap, faceFeature);
    }

    /* renamed from: do */
    public void mo38588do(boolean z) {
        if (m3950a()) {
            this.f6888e = z;
            this.f6890g = System.currentTimeMillis();
            if (z) {
                m3952b();
            }
        }
    }

    /* renamed from: b */
    private boolean m3953b(long j) throws C3095case {
        return this.f6885b.mo38607b(j);
    }

    /* renamed from: do */
    public synchronized void mo38594do(C3103this thisR) {
        thisR.mo38598do("ld", Double.valueOf(this.f6886c == C19775const.CAMERA1 ? 0.0d : 1.0d));
    }

    /* renamed from: do */
    public String mo38584do() {
        return this.f6885b.mo38611f();
    }

    /* renamed from: for  reason: not valid java name */
    public final double m46198for() {
        return this.f6885b.mo38609d();
    }

    /* renamed from: a */
    private boolean m3951a(long j) throws C3095case {
        return this.f6885b.mo38605a(j);
    }

    /* renamed from: if */
    public Bitmap mo38590if() {
        return this.f6887d;
    }
}
