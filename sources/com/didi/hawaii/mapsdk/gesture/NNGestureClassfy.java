package com.didi.hawaii.mapsdk.gesture;

import android.graphics.PointF;
import android.view.MotionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NNGestureClassfy {
    public static final String ROTATE_LABLE = "rotate";
    public static final String SCALE_LABLE = "scale";

    /* renamed from: d */
    private static final int f23554d = 255;

    /* renamed from: e */
    private static final int f23555e = 5;

    /* renamed from: f */
    private static final int f23556f = 6;

    /* renamed from: g */
    private static final int f23557g = 4;

    /* renamed from: h */
    private static final float f23558h = ((float) Math.cos(0.0017453292780017621d));

    /* renamed from: i */
    private static final float[][] f23559i = {new float[]{-2.471219f, 2.1069329f, -0.8714474f, -0.58557045f}, new float[]{0.55966336f, -0.09991011f, 0.19126992f, -0.14390568f}, new float[]{-1.0188024f, 0.36453947f, -0.6132143f, 0.20783454f}, new float[]{-0.30913615f, -0.017312443f, -0.063314214f, -0.2751378f}, new float[]{2.5818212f, -1.948909f, 0.5149268f, 0.9224255f}, new float[]{0.035883997f, -0.037764445f, -0.009480436f, 0.0045879353f}, new float[]{3.6362724f, -3.127408f, 1.8685201f, 0.8372771f}, new float[]{0.01401783f, 0.020174429f, -0.17118452f, 0.23226455f}};

    /* renamed from: j */
    private static final float[][] f23560j = {new float[]{-2.7031126f, 2.4003828f, -1.0142001f, -0.74108267f}};

    /* renamed from: k */
    private static final float[][] f23561k = {new float[]{5.097351f, -4.131727f}, new float[]{5.113865f, -2.3753471f}, new float[]{-2.3084853f, 3.646426f}, new float[]{-2.375553f, 2.3262072f}};

    /* renamed from: l */
    private static final float[][] f23562l = {new float[]{0.51410097f, -0.8743408f}};

    /* renamed from: m */
    private static final String f23563m = "";

    /* renamed from: a */
    float[][] f23564a = ((float[][]) Array.newInstance(float.class, new int[]{1, 8}));

    /* renamed from: b */
    private boolean f23565b;

    /* renamed from: c */
    private boolean f23566c;

    /* renamed from: n */
    private PointF f23567n = new PointF();

    /* renamed from: o */
    private PointF f23568o = new PointF();

    /* renamed from: p */
    private PointF f23569p = new PointF();

    /* renamed from: q */
    private PointF f23570q = new PointF();

    /* renamed from: r */
    private List<Feature> f23571r = new ArrayList();

    /* renamed from: s */
    private int f23572s = 0;

    /* renamed from: t */
    private String f23573t = "";

    /* renamed from: u */
    private float f23574u;

    public void dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f23565b = false;
        } else if (action != 2) {
            if (action == 5) {
                this.f23572s = 0;
                this.f23573t = "";
                this.f23574u = 0.0f;
                this.f23565b = true;
                this.f23566c = false;
                m16797a(this.f23567n, this.f23568o, motionEvent);
            } else if (action == 6 && !this.f23566c) {
                this.f23566c = true;
            }
        } else if (this.f23565b && !this.f23566c) {
            m16797a(this.f23569p, this.f23570q, motionEvent);
            m16796a();
        }
    }

    /* renamed from: a */
    private void m16797a(PointF pointF, PointF pointF2, MotionEvent motionEvent) {
        try {
            pointF.set(motionEvent.getX(0), motionEvent.getY(0));
            if (motionEvent.getPointerCount() >= 2) {
                pointF2.set(motionEvent.getX(1), motionEvent.getY(1));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16796a() {
        /*
            r24 = this;
            r0 = r24
            int r1 = r0.f23572s
            r2 = 1
            int r1 = r1 + r2
            r0.f23572s = r1
            android.graphics.PointF r1 = r0.f23568o
            float r1 = r1.x
            android.graphics.PointF r3 = r0.f23567n
            float r3 = r3.x
            float r1 = r1 - r3
            double r3 = (double) r1
            android.graphics.PointF r1 = r0.f23568o
            float r1 = r1.y
            android.graphics.PointF r5 = r0.f23567n
            float r5 = r5.y
            float r1 = r1 - r5
            double r5 = (double) r1
            android.graphics.PointF r1 = r0.f23570q
            float r1 = r1.x
            android.graphics.PointF r7 = r0.f23569p
            float r7 = r7.x
            float r1 = r1 - r7
            double r7 = (double) r1
            android.graphics.PointF r1 = r0.f23570q
            float r1 = r1.y
            android.graphics.PointF r9 = r0.f23569p
            float r9 = r9.y
            float r1 = r1 - r9
            double r9 = (double) r1
            double r11 = r3 * r3
            double r13 = r5 * r5
            double r11 = r11 + r13
            double r11 = java.lang.Math.sqrt(r11)
            double r13 = r7 * r7
            double r15 = r9 * r9
            double r13 = r13 + r15
            double r13 = java.lang.Math.sqrt(r13)
            double r15 = r11 * r13
            r17 = 0
            int r1 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r1 <= 0) goto L_0x007c
            double r19 = r3 * r7
            double r21 = r5 * r9
            double r19 = r19 + r21
            double r19 = r19 / r15
            double r15 = java.lang.Math.abs(r19)
            float r1 = f23558h
            r22 = r3
            double r2 = (double) r1
            int r1 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x007c
            r1 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r3 = java.lang.Math.acos(r19)
            double r3 = r3 * r1
            r1 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r3 = r3 / r1
            float r1 = (float) r3
            double r3 = r22 * r9
            double r5 = r5 * r7
            double r3 = r3 - r5
            int r2 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r2 >= 0) goto L_0x007d
            float r1 = -r1
            goto L_0x007d
        L_0x007c:
            r1 = 0
        L_0x007d:
            r0.f23574u = r1
            double r13 = r13 / r11
            float r2 = (float) r13
            int r3 = r0.f23572s
            r4 = 4
            if (r3 > r4) goto L_0x00f0
            com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature r3 = new com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature
            r5 = 0
            r3.<init>()
            r3.scale = r2
            r3.angle = r1
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r5 = r0.f23571r
            r5.add(r3)
            r5 = 4594932627813569659(0x3fc47ae147ae147b, double:0.16)
            r3 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r3
            float r3 = java.lang.Math.abs(r2)
            double r7 = (double) r3
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b6
            float r3 = java.lang.Math.abs(r1)
            r5 = 1082130432(0x40800000, float:4.0)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x00b6
            java.lang.String r1 = "scale"
            r0.f23573t = r1
            goto L_0x00f0
        L_0x00b6:
            float r3 = java.lang.Math.abs(r1)
            r5 = 1092616192(0x41200000, float:10.0)
            java.lang.String r6 = "rotate"
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00dc
            java.lang.String r3 = r0.f23573t
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x00dc
            float r2 = java.lang.Math.abs(r2)
            double r2 = (double) r2
            r7 = 4585925428558828667(0x3fa47ae147ae147b, double:0.04)
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x00dc
            r0.f23573t = r6
            goto L_0x00f0
        L_0x00dc:
            float r1 = java.lang.Math.abs(r1)
            r2 = 1101004800(0x41a00000, float:20.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x00f0
            java.lang.String r1 = r0.f23573t
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00f0
            r0.f23573t = r6
        L_0x00f0:
            int r1 = r0.f23572s
            if (r1 != r4) goto L_0x0192
            java.lang.String r1 = r0.f23573t
            java.lang.String r2 = ""
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x018d
            float[][] r1 = r0.f23564a
            r2 = 0
            r1 = r1[r2]
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r3 = r0.f23571r
            java.lang.Object r3 = r3.get(r2)
            com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature r3 = (com.didi.hawaii.mapsdk.gesture.NNGestureClassfy.Feature) r3
            float r3 = r3.scale
            r1[r2] = r3
            float[][] r1 = r0.f23564a
            r1 = r1[r2]
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r3 = r0.f23571r
            java.lang.Object r3 = r3.get(r2)
            com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature r3 = (com.didi.hawaii.mapsdk.gesture.NNGestureClassfy.Feature) r3
            float r3 = r3.angle
            r5 = 1
            r1[r5] = r3
            float[][] r1 = r0.f23564a
            r1 = r1[r2]
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r3 = r0.f23571r
            java.lang.Object r3 = r3.get(r5)
            com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature r3 = (com.didi.hawaii.mapsdk.gesture.NNGestureClassfy.Feature) r3
            float r3 = r3.scale
            r6 = 2
            r1[r6] = r3
            float[][] r1 = r0.f23564a
            r1 = r1[r2]
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r3 = r0.f23571r
            java.lang.Object r3 = r3.get(r5)
            com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature r3 = (com.didi.hawaii.mapsdk.gesture.NNGestureClassfy.Feature) r3
            float r3 = r3.angle
            r5 = 3
            r1[r5] = r3
            float[][] r1 = r0.f23564a
            r1 = r1[r2]
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r3 = r0.f23571r
            java.lang.Object r3 = r3.get(r6)
            com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature r3 = (com.didi.hawaii.mapsdk.gesture.NNGestureClassfy.Feature) r3
            float r3 = r3.scale
            r1[r4] = r3
            float[][] r1 = r0.f23564a
            r1 = r1[r2]
            r3 = 5
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r4 = r0.f23571r
            java.lang.Object r4 = r4.get(r6)
            com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature r4 = (com.didi.hawaii.mapsdk.gesture.NNGestureClassfy.Feature) r4
            float r4 = r4.angle
            r1[r3] = r4
            float[][] r1 = r0.f23564a
            r1 = r1[r2]
            r3 = 6
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r4 = r0.f23571r
            java.lang.Object r4 = r4.get(r5)
            com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature r4 = (com.didi.hawaii.mapsdk.gesture.NNGestureClassfy.Feature) r4
            float r4 = r4.scale
            r1[r3] = r4
            float[][] r1 = r0.f23564a
            r1 = r1[r2]
            r2 = 7
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r3 = r0.f23571r
            java.lang.Object r3 = r3.get(r5)
            com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature r3 = (com.didi.hawaii.mapsdk.gesture.NNGestureClassfy.Feature) r3
            float r3 = r3.angle
            r1[r2] = r3
            float[][] r1 = r0.f23564a
            java.lang.String r1 = r0.m16795a(r1)
            r0.f23573t = r1
        L_0x018d:
            java.util.List<com.didi.hawaii.mapsdk.gesture.NNGestureClassfy$Feature> r1 = r0.f23571r
            r1.clear()
        L_0x0192:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdk.gesture.NNGestureClassfy.m16796a():void");
    }

    /* renamed from: a */
    private String m16795a(float[][] fArr) {
        try {
            float[][] add = MatrixOperation.add(MatrixOperation.multiplication(MatrixOperation.relu(MatrixOperation.add(MatrixOperation.multiplication(fArr, f23559i), f23560j)), f23561k), f23562l);
            if (add[0].length == 2) {
                return add[0][0] > add[0][1] ? SCALE_LABLE : ROTATE_LABLE;
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getLable() {
        return this.f23573t;
    }

    public float getCurAngle() {
        return this.f23574u;
    }

    private static class Feature {
        float angle;
        float scale;

        private Feature() {
        }
    }
}
