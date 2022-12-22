package com.iproov.sdk.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ToneGenerator;
import com.iproov.sdk.face.model.FaceFeature;
import java.util.List;
import p066native.C2381if;
import p089public.C3008do;
import p089public.C3009for;
import p093switch.C3106case;
import p093switch.C3130while;
import p096try.C3136do;
import p232do.C20817break;
import p232do.C20821for;
import p232do.C20824new;

/* renamed from: com.iproov.sdk.core.const */
/* compiled from: LivenessManager */
class C19880const implements C19908try {

    /* renamed from: a */
    private static final C3106case.C3107do f54209a = C3106case.C3107do.FIT;

    /* renamed from: b */
    private static final C3130while f54210b = new C3130while(0.0d, 0.0d, 0.0d);

    /* renamed from: c */
    private final C2381if f54211c;

    /* renamed from: d */
    private final Rect f54212d;

    /* renamed from: e */
    private final Rect f54213e;

    /* renamed from: f */
    private final C19881do f54214f;

    /* renamed from: g */
    private final C19886final f54215g;

    /* renamed from: h */
    private final C19878class f54216h;

    /* renamed from: i */
    private final C3008do f54217i;

    /* renamed from: j */
    private final int f54218j;

    /* renamed from: k */
    private final ToneGenerator f54219k;

    /* renamed from: l */
    private Rect f54220l;

    /* renamed from: m */
    private C3130while f54221m;

    /* renamed from: n */
    private Cdefault f54222n;

    /* renamed from: o */
    private Rect f54223o;

    /* renamed from: p */
    private Rect f54224p;

    /* renamed from: q */
    private C3130while f54225q;

    /* renamed from: r */
    private C3130while f54226r;

    /* renamed from: s */
    private C3130while f54227s;

    /* renamed from: t */
    private C3130while f54228t;

    /* renamed from: u */
    private C3130while f54229u;

    /* renamed from: v */
    private double f54230v;

    /* renamed from: w */
    private int f54231w = 0;

    /* renamed from: x */
    private double f54232x = 0.0d;

    /* renamed from: com.iproov.sdk.core.const$do */
    /* compiled from: LivenessManager */
    interface C19881do {
        /* renamed from: do */
        void mo162066do(Rect rect, Rect rect2, Rect rect3, Rect rect4);

        /* renamed from: do */
        void mo162067do(Rect rect, RectF rectF);

        /* renamed from: do */
        void mo162068do(C20821for forR, boolean z, RectF rectF);

        /* renamed from: do */
        void mo162069do(Exception exc);
    }

    C19880const(Context context, C20824new newR, C20817break breakR, C19886final finalR, C19881do doVar) {
        this.f54211c = new C2381if(context.getApplicationContext());
        boolean z = !newR.m47618new().isPortrait();
        this.f54212d = new Rect(0, 0, z ? newR.mo161911if().mo170629do() : newR.mo161911if().mo170632if(), z ? newR.mo161911if().mo170632if() : newR.mo161911if().mo170629do());
        this.f54213e = new Rect(0, 0, breakR.mo170632if(), breakR.mo170629do());
        this.f54214f = doVar;
        newR.m47617for();
        this.f54215g = finalR;
        this.f54219k = m39080d();
        int max = Math.max(1, finalR.m47518try());
        this.f54218j = max;
        this.f54216h = new C19878class(doVar, finalR.m47516new(), max);
        this.f54217i = new C3008do(finalR.m47515goto(), finalR.m47517this());
    }

    /* renamed from: a */
    private void m39077a(C20821for forR, RectF rectF) {
        this.f54231w++;
        StringBuilder sb = new StringBuilder();
        sb.append("🏁 Completed checkpoint ");
        sb.append(this.f54231w);
        if (this.f54219k == null) {
            return;
        }
        if (this.f54231w == this.f54215g.m47516new()) {
            this.f54219k.startTone(0, 50);
        } else {
            this.f54219k.startTone(10, 50);
        }
    }

    /* renamed from: b */
    private void m39079b(Rect rect) {
        this.f54214f.mo162066do(m39075a(this.f54220l), m39075a(this.f54224p), m39075a(rect), m39075a(this.f54223o));
    }

    /* renamed from: d */
    private ToneGenerator m39080d() {
        if (this.f54211c.m46148const()) {
            try {
                return new ToneGenerator(3, 100);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<C3009for> mo162061a() {
        return this.f54217i.mo38417do();
    }

    /* renamed from: b */
    public C3008do mo162063b() {
        return this.f54217i;
    }

    /* renamed from: c */
    public void mo162064c() {
        this.f54216h.mo162060a();
    }

    /* renamed from: a */
    private Rect m39075a(Rect rect) {
        return C3106case.m4007do(rect, this.f54212d, this.f54213e, f54209a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3136do mo162062a(C20821for forR, Bitmap bitmap, FaceFeature faceFeature, Rect rect) {
        RectF rectF = faceFeature != null ? new RectF(faceFeature.getFaceBounds().left / ((float) rect.width()), faceFeature.getFaceBounds().top / ((float) rect.height()), faceFeature.getFaceBounds().right / ((float) rect.width()), faceFeature.getFaceBounds().bottom / ((float) rect.height())) : null;
        C3136do a = m39076a(forR, faceFeature, rect, rectF);
        if (rectF == null || a == C3136do.NO_FACE_PATH) {
            return a;
        }
        return this.f54216h.mo162059a(forR, bitmap, faceFeature, rectF, a, this.f54231w, mo162065do());
    }

    /* renamed from: a */
    private C3136do m39076a(C20821for forR, FaceFeature faceFeature, Rect rect, RectF rectF) {
        C20821for forR2 = forR;
        RectF rectF2 = rectF;
        if (faceFeature == null) {
            m39079b((Rect) null);
            if (this.f54231w == this.f54215g.m47516new()) {
                return C3136do.END_FACE_PATH;
            }
            return this.f54220l == null ? C3136do.NO_FACE_PATH : C3136do.FACE_PATH;
        }
        Rect rect2 = C3106case.m4007do(C3106case.m4008do(faceFeature.getFaceBounds()), rect, this.f54212d, f54209a);
        m39079b(rect2);
        if (this.f54220l == null) {
            if (m39078a(rectF)) {
                return C3136do.NO_FACE_PATH;
            }
            this.f54220l = rect2;
            this.f54221m = C3106case.m4010do(rect2);
            Cdefault defaultR = new Cdefault(this.f54220l, this.f54212d, this.f54215g);
            this.f54222n = defaultR;
            Rect a = defaultR.mo162070a(this.f54212d);
            this.f54223o = a;
            RectF rectF3 = C3106case.m4009do(a, this.f54212d);
            StringBuilder sb = new StringBuilder();
            sb.append("CROPRECTpre=");
            sb.append(this.f54223o);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CROPRECTcamera=");
            sb2.append(this.f54212d);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CROPRECTpreF=");
            sb3.append(rectF3);
            this.f54214f.mo162067do(this.f54223o, rectF3);
            m39077a(forR2, rectF2);
            Rect rect3 = C3106case.m4006do(this.f54223o, 0.9f);
            this.f54224p = rect3;
            rect3.offset(0, (int) (((double) this.f54223o.height()) * -0.05d));
            C3130while whileR = C3106case.m4010do(this.f54224p);
            this.f54225q = whileR;
            C3130while whileR2 = whileR.m46206new(this.f54221m).m46207try(this.f54215g.m47512class());
            this.f54226r = whileR2;
            C3130while whileR3 = f54210b;
            this.f54227s = whileR2.m46205for(whileR3);
            this.f54228t = this.f54226r.mo38635if(whileR3);
            double d = this.f54226r.mo38634if();
            this.f54230v = d;
            this.f54229u = this.f54226r.mo38631do(1.0d / d);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("start: ");
            sb4.append(this.f54220l.toShortString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("crop: ");
            sb5.append(this.f54223o.toShortString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("target: ");
            sb6.append(this.f54224p.toShortString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("current: ");
            sb7.append(faceFeature.getFaceBounds().toShortString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("camera: ");
            sb8.append(this.f54212d.toShortString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("screen: ");
            sb9.append(this.f54213e.toShortString());
            return C3136do.FACE_PATH;
        } else if (this.f54222n == null) {
            return C3136do.NO_FACE_PATH;
        } else {
            if (this.f54231w >= this.f54215g.m47516new()) {
                return C3136do.END_FACE_PATH;
            }
            this.f54232x = C3106case.m4010do(rect2).m46206new(this.f54221m).m46207try(this.f54215g.m47512class()).mo38632do(this.f54227s, this.f54228t).mo38629do(this.f54229u) / this.f54230v;
            double d2 = (this.f54215g.m47511catch() * ((double) this.f54231w)) / ((double) (this.f54215g.m47516new() - 1));
            double width = (((double) rect2.width()) * 1.0d) / ((double) this.f54224p.width());
            double abs = Math.abs(1.0d - width);
            double d3 = width;
            double max = Math.max((((double) rect2.width()) * 1.0d) / ((double) this.f54220l.width()), (((double) this.f54220l.width()) * 1.0d) / ((double) rect2.width()));
            double d4 = C3106case.m4012if(C3106case.m4013if(rect2), C3106case.m4013if(this.f54224p)) / ((double) this.f54212d.width());
            if (this.f54231w < this.f54215g.m47516new() - 1 && this.f54232x > d2) {
                m39077a(forR2, rectF2);
            } else if (this.f54231w == this.f54215g.m47516new() - 1 && d4 < this.f54215g.mo162077do() && abs < this.f54215g.mo162081if() && max > this.f54215g.m47514for()) {
                m39077a(forR2, rectF2);
            }
            if (this.f54231w == this.f54215g.m47516new()) {
                return C3136do.END_FACE_PATH;
            }
            if (d4 > this.f54215g.mo162077do()) {
                return C3136do.FACE_PATH;
            }
            return d3 < 1.0d ? C3136do.TOO_FAR_FACE_PATH : C3136do.TOO_CLOSE_FACE_PATH;
        }
    }

    /* renamed from: do */
    public int mo162065do() {
        return this.f54215g.m47516new();
    }

    /* renamed from: a */
    private static boolean m39078a(RectF rectF) {
        return rectF.left <= 0.0f || rectF.top <= 0.0f || rectF.right >= 1.0f || rectF.bottom >= 1.0f;
    }
}
