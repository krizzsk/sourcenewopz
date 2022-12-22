package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sdk.alphaface.core.liveness.b */
/* compiled from: ActionDetect */
class C16336b extends C16335a<List<ILivenessCallback.PicWithScore>> {

    /* renamed from: f */
    public static final int f48720f = 0;

    /* renamed from: g */
    public static final int f48721g = 1;

    /* renamed from: h */
    private final List<ILivenessCallback.PicWithScore> f48722h = new ArrayList(this.f48723i);

    /* renamed from: i */
    private final int f48723i = 1;

    /* renamed from: j */
    private final int f48724j = this.f48717c.getActionInterruptTime();

    /* renamed from: k */
    private final int f48725k = this.f48717c.getActionTimeout();

    /* renamed from: l */
    private int f48726l = -1;

    /* renamed from: m */
    private int[] f48727m = this.f48717c.getDetectAction();

    /* renamed from: n */
    private long f48728n;

    /* renamed from: o */
    private long f48729o;

    /* renamed from: b */
    public boolean mo120637b() {
        return false;
    }

    public C16336b(LivenessManager livenessManager) {
        super(livenessManager);
    }

    /* renamed from: e */
    public List<ILivenessCallback.PicWithScore> mo120633a() {
        return this.f48722h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo120636b(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3) {
        if (this.f48726l < 0) {
            m34971f();
            int[] iArr = this.f48727m;
            int i4 = this.f48726l + 1;
            this.f48726l = i4;
            m34970b(0, iArr[i4]);
        }
        float[] livenessDetect = this.f48715a.livenessDetect(bArr, i, i2, i3, f, f2, f3);
        if (livenessDetect != null && livenessDetect.length == 3) {
            if (livenessDetect[0] == 1.0f) {
                m34969a(1, 0);
                int i5 = this.f48726l;
                int[] iArr2 = this.f48727m;
                if (i5 == iArr2.length - 1) {
                    C16337c cVar = this.f48716b;
                    int[] iArr3 = this.f48727m;
                    int i6 = this.f48726l;
                    int i7 = iArr3[i6];
                    int i8 = i6 + 1;
                    this.f48726l = i8;
                    cVar.onActionChange(i7, 5, i8, iArr3.length);
                    this.f48716b.onActionSuccess(this.f48722h);
                } else {
                    int i9 = iArr2[i5];
                    int i10 = i5 + 1;
                    this.f48726l = i10;
                    m34970b(i9, iArr2[i10]);
                }
            } else {
                m34972g();
                if (livenessDetect[1] >= 1.0f && livenessDetect[1] <= 4.0f) {
                    this.f48716b.onActionTip((int) livenessDetect[1]);
                }
                this.f48716b.mo120643c((int) livenessDetect[1]);
                m34968a(livenessDetect[1]);
            }
            SortUtils.sortPicList((double) livenessDetect[2], 1.0d, (double) livenessDetect[2], bArr, i, i2, this.f48723i, this.f48722h);
        }
    }

    /* renamed from: f */
    private void m34971f() {
        this.f48716b.onStartAction(this.f48727m);
    }

    /* renamed from: g */
    private void m34972g() {
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.f48728n);
        this.f48716b.onActionCountdown(currentTimeMillis);
        if (currentTimeMillis >= this.f48725k) {
            m34969a(0, 2);
            this.f48716b.onActionTimeout();
        }
    }

    /* renamed from: a */
    private void m34968a(float f) {
        if (f != 0.0f) {
            this.f48729o = 0;
        } else if (this.f48729o == 0) {
            this.f48729o = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - this.f48729o > ((long) this.f48724j)) {
            m34969a(0, 1);
            this.f48716b.onActionFailed();
        }
    }

    /* renamed from: a */
    private void m34969a(int i, int i2) {
        this.f48716b.onActionInfo(i, i2, this.f48727m[this.f48726l], this.f48715a.livenessProcess(0, this.f48727m[this.f48726l]));
    }

    /* renamed from: b */
    private void m34970b(int i, int i2) {
        this.f48715a.livenessProcess(1, i2);
        this.f48716b.onActionChange(i, i2, this.f48726l, this.f48727m.length);
        this.f48728n = System.currentTimeMillis();
    }

    /* renamed from: c */
    public void mo120638c() {
        this.f48716b.onActionReset();
        this.f48722h.clear();
        this.f48726l = -1;
        this.f48729o = 0;
    }
}
