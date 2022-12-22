package com.didichuxing.sdk.alphaface.core.liveness;

import android.graphics.Point;
import android.util.Pair;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.IMirrorCallback;
import com.didichuxing.sdk.alphaface.utils.AFLog;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* renamed from: com.didichuxing.sdk.alphaface.core.liveness.d */
/* compiled from: FaceDetect */
class C16338d extends C16335a<Pair<List<ILivenessCallback.PicWithScore>, List<ILivenessCallback.PicWithScore>>> {

    /* renamed from: f */
    private final List<ILivenessCallback.PicWithScore> f48739f;

    /* renamed from: g */
    private final List<ILivenessCallback.PicWithScore> f48740g;

    /* renamed from: h */
    private final List<ILivenessCallback.PicWithScore> f48741h;

    /* renamed from: i */
    private final double f48742i;

    /* renamed from: j */
    private final double f48743j;

    /* renamed from: k */
    private final int f48744k;

    /* renamed from: l */
    private final boolean f48745l;

    /* renamed from: m */
    private final Random f48746m;

    /* renamed from: n */
    private int f48747n;

    /* renamed from: o */
    private final int f48748o;

    /* renamed from: p */
    private final int f48749p;

    /* renamed from: q */
    private final int f48750q;

    /* renamed from: r */
    private boolean f48751r;

    /* renamed from: s */
    private long f48752s;

    /* renamed from: t */
    private int f48753t;

    /* renamed from: u */
    private boolean f48754u;

    /* renamed from: v */
    private int f48755v;

    public C16338d(LivenessManager livenessManager) {
        super(livenessManager);
        this.f48753t = 0;
        this.f48754u = true;
        this.f48755v = 0;
        this.f48748o = 1;
        this.f48749p = this.f48717c.getAttackPicCount();
        this.f48739f = new ArrayList(this.f48748o);
        this.f48740g = new ArrayList(this.f48749p);
        this.f48741h = new ArrayList();
        this.f48755v = this.f48717c.getWaterType();
        this.f48742i = this.f48717c.getAttackPicQualityThreshold();
        this.f48743j = this.f48717c.getBestPicQualityThreshold();
        this.f48750q = this.f48717c.getDetectTime();
        this.f48744k = this.f48717c.getFaceQualityErrorMaxTimes();
        this.f48747n = this.f48717c.getFaceQualityErrorDelay();
        this.f48745l = this.f48717c.attackEnable();
        this.f48746m = new Random();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo120636b(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3) {
        ILivenessCallback.PicWithScore picWithScore;
        int i4;
        int i5 = i;
        int i6 = i2;
        if (this.f48754u) {
            long currentTimeMillis = System.currentTimeMillis();
            int[] maxFaceDetect = this.f48715a.maxFaceDetect(bArr, i, i2, i3, f, f2, f3);
            if (maxFaceDetect == null || maxFaceDetect.length == 0) {
                m34989b(0);
            } else if (maxFaceDetect[0] == 0) {
                m34989b(0);
            } else if (maxFaceDetect[1] == 0) {
                m34989b(5);
            } else {
                int i7 = maxFaceDetect[2];
                if (i7 == 0) {
                    if (this.f48741h.size() == 0) {
                        ILivenessCallback.PicWithScore picWithScore2 = new ILivenessCallback.PicWithScore();
                        if (this.f48755v == -2) {
                            picWithScore2.rgba = bArr;
                            picWithScore = picWithScore2;
                            i4 = 1;
                        } else {
                            byte[] bArr2 = bArr;
                            byte[] bArr3 = new byte[(i5 * i6 * 4)];
                            picWithScore = picWithScore2;
                            i4 = this.f48715a.addWaterMark(bArr, i, i2, bArr3, this.f48755v);
                            picWithScore.rgba = bArr3;
                        }
                        picWithScore.qualityScore = 0.0d;
                        picWithScore.qualityOk = (double) i4;
                        picWithScore.attackScore = 0.0d;
                        picWithScore.width = i5;
                        picWithScore.height = i6;
                        this.f48741h.add(picWithScore);
                    }
                    IMirrorCallback.FaceInfo a = m34984a(maxFaceDetect);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    AFLog.m34998v("maxFaceDetect consume: " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    int i8 = maxFaceDetect[3];
                    int i9 = maxFaceDetect[4];
                    int i10 = maxFaceDetect[5];
                    int i11 = maxFaceDetect[6];
                    int i12 = (int) (((double) (i11 - i9)) * 0.8d);
                    int i13 = (i10 + i8) / 2;
                    int i14 = i11 - i12;
                    int i15 = i12 / 2;
                    int i16 = i13 - i15;
                    double d = ((double) i12) * 0.0485d;
                    int max = Math.max(Math.min((int) (((double) i16) - d), i5), 0);
                    int max2 = Math.max(Math.min((int) (((double) i14) - d), i6), 0);
                    int max3 = Math.max(Math.min((int) (((double) (i13 + i15)) + d), i5), 0);
                    int max4 = Math.max(Math.min((int) (((double) i11) + d), i6), 0);
                    int i17 = max3 - max;
                    int i18 = max4 - max2;
                    byte[] bArr4 = new byte[(i17 * i18 * 4)];
                    m34983a(bArr, bArr4, max, max2, max3, max4, i);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    AFLog.m34998v("crop face from ARGB: " + (currentTimeMillis3 - currentTimeMillis2) + "ms");
                    long currentTimeMillis4 = System.currentTimeMillis();
                    float[] a2 = m34988a(bArr, bArr4, i17, i18, i, i2);
                    long currentTimeMillis5 = System.currentTimeMillis();
                    AFLog.m34998v("qualityDetect cost time : " + (currentTimeMillis5 - currentTimeMillis4) + "ms");
                    if (a2 != null && a2.length != 0) {
                        AFLog.m34998v("qualityInfo: " + Arrays.toString(a2));
                        float f4 = a2[0];
                        float f5 = a2[1];
                        if (a2[2] == 1.0f) {
                            m34985a(8);
                        } else if (a2[3] == 1.0f) {
                            m34985a(9);
                        } else if (a2[4] == 1.0f) {
                            m34985a(10);
                        } else if (a2[5] == 1.0f) {
                            m34985a(11);
                        } else {
                            m34985a(-1);
                        }
                        long currentTimeMillis6 = System.currentTimeMillis();
                        AFLog.m34998v("qualityDetect consume: " + (currentTimeMillis6 - currentTimeMillis2) + "ms, qualityScore:" + f4);
                        StringBuilder sb = new StringBuilder();
                        sb.append("qualityDetect quality_ok: ");
                        sb.append(f5);
                        AFLog.m34998v(sb.toString());
                        double a3 = m34982a(bArr, i, i2, (double) f4, (double) f5);
                        long currentTimeMillis7 = System.currentTimeMillis();
                        AFLog.m34998v("antiAttack consume: " + (currentTimeMillis7 - currentTimeMillis6) + "ms, attackScore: " + a3);
                        m34987a(a);
                        if (this.f48752s == 0) {
                            this.f48752s = System.currentTimeMillis();
                        }
                        m34986a(System.currentTimeMillis() - this.f48752s);
                        if (System.currentTimeMillis() - this.f48752s >= ((long) this.f48750q)) {
                            m34990f();
                        }
                    }
                } else if (i7 == -1) {
                    m34989b(6);
                } else {
                    m34989b(7);
                }
            }
        }
    }

    /* renamed from: f */
    private void m34990f() {
        this.f48754u = false;
        int i = this.f48753t;
        if (i < this.f48744k) {
            this.f48753t = i + 1;
            List<ILivenessCallback.PicWithScore> list = this.f48739f;
            if (list == null || list.size() <= 0) {
                this.f48751r = true;
                this.f48716b.onMirrorSuccess(this.f48739f, this.f48740g, this.f48741h);
            } else if (Double.compare(this.f48739f.get(0).qualityOk, 1.0d) != 0) {
                this.f48716b.onMirrorFaceQualityError();
                UIHandler.postDelayed((long) this.f48747n, new FaceDetect$1(this));
            } else {
                this.f48751r = true;
                this.f48716b.onMirrorSuccess(this.f48739f, this.f48740g, this.f48741h);
            }
        } else {
            this.f48751r = true;
            this.f48716b.onMirrorSuccess(this.f48739f, this.f48740g, this.f48741h);
        }
    }

    /* renamed from: a */
    private void m34986a(long j) {
        this.f48716b.onMirrorProcess(j);
    }

    /* renamed from: a */
    private void m34987a(IMirrorCallback.FaceInfo faceInfo) {
        this.f48716b.onDetectFace(faceInfo);
    }

    /* renamed from: a */
    private void m34985a(int i) {
        this.f48716b.mo120641a(i);
    }

    /* renamed from: b */
    private void m34989b(int i) {
        this.f48716b.mo120642b(i);
    }

    /* renamed from: a */
    private IMirrorCallback.FaceInfo m34984a(int[] iArr) {
        IMirrorCallback.FaceInfo faceInfo = new IMirrorCallback.FaceInfo();
        faceInfo.leftTop = new Point();
        faceInfo.leftTop.x = iArr[3];
        faceInfo.leftTop.y = iArr[4];
        faceInfo.rightBottom = new Point();
        faceInfo.rightBottom.x = iArr[5];
        faceInfo.rightBottom.y = iArr[6];
        faceInfo.keyPoints = new Point[5];
        for (int i = 0; i < faceInfo.keyPoints.length; i++) {
            faceInfo.keyPoints[i] = new Point();
            faceInfo.keyPoints[i].x = iArr[i + 7];
            faceInfo.keyPoints[i].y = iArr[i + 10 + 2];
        }
        return faceInfo;
    }

    /* renamed from: a */
    private int m34983a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5) {
        int i6 = i3 - i;
        int i7 = 0;
        while (i2 < i4) {
            int i8 = i6 * 4;
            System.arraycopy(bArr, (i2 * i5 * 4) + (i * 4), bArr2, i7, i8);
            i7 += i8;
            i2++;
        }
        return 0;
    }

    /* renamed from: a */
    private double m34982a(byte[] bArr, int i, int i2, double d, double d2) {
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        double d3 = d;
        if (this.f48745l) {
            double attackDetect = this.f48715a.attackDetect(bArr, i3, i4);
            if (d3 > this.f48742i) {
                SortUtils.sortPicList(d, d2, attackDetect, bArr, i, i2, this.f48749p, this.f48740g);
            }
            return attackDetect;
        }
        ILivenessCallback.PicWithScore picWithScore = new ILivenessCallback.PicWithScore();
        picWithScore.qualityScore = d3;
        picWithScore.qualityOk = d2;
        picWithScore.attackScore = d3;
        picWithScore.rgba = bArr2;
        picWithScore.width = i3;
        picWithScore.height = i4;
        if (d3 <= this.f48742i) {
            return 0.0d;
        }
        int size = this.f48740g.size();
        int i5 = this.f48749p;
        if (size < i5) {
            this.f48740g.add(picWithScore);
            return 0.0d;
        }
        this.f48740g.set(this.f48746m.nextInt(i5), picWithScore);
        return 0.0d;
    }

    /* renamed from: a */
    private float[] m34988a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        float[] qualityDetect = this.f48715a.qualityDetect(bArr2, i, i2);
        if (!(qualityDetect == null || qualityDetect.length == 0 || ((double) qualityDetect[0]) <= this.f48743j)) {
            SortUtils.sortPicList((double) qualityDetect[0], (double) qualityDetect[1], (double) qualityDetect[0], bArr, i3, i4, this.f48748o, this.f48739f);
        }
        return qualityDetect;
    }

    /* renamed from: b */
    public boolean mo120637b() {
        return this.f48751r;
    }

    /* renamed from: c */
    public void mo120638c() {
        this.f48716b.onMirrorReset();
        this.f48754u = true;
        this.f48751r = false;
        this.f48740g.clear();
        this.f48739f.clear();
        this.f48741h.clear();
        this.f48752s = 0;
        m34986a(0);
    }

    /* renamed from: e */
    public Pair<List<ILivenessCallback.PicWithScore>, List<ILivenessCallback.PicWithScore>> mo120633a() {
        return new Pair<>(this.f48739f, this.f48740g);
    }
}
