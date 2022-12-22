package com.didi.hawaii.mapsdkv2.core;

import android.graphics.PointF;

public final class Gesture {
    public static final int MOTION_ACTION_DOWN = 0;
    public static final int MOTION_ACTION_MOVE = 2;
    public static final int MOTION_ACTION_POINTER_DOWN = 5;
    public static final int MOTION_ACTION_POINTER_UP = 6;
    public static final int MOTION_ACTION_UP = 1;
    public static final int MOTION_DOUBLE_FINGER_TAP = 36;
    public static final int MOTION_DOUBLE_TAP = 23;
    public static final int MOTION_DOUBLE_TAP_DOWN = 33;
    public static final int MOTION_DOUBLE_TAP_MOVE = 35;
    public static final int MOTION_DOUBLE_TAP_UP = 34;
    public static final int MOTION_DOUBLE_TAP_ZOOMIN = 32;
    public static final int MOTION_FLING = 19;
    public static final int MOTION_LONG_CLICK = 18;
    public static final int MOTION_ROTATE_MOVE = 21;
    public static final int MOTION_SCALE_MOVE = 22;
    public static final int MOTION_SCROLL = 8;
    public static final int MOTION_SINGLE_CLICK = 17;
    public static final int MOTION_SKEW_MOVE = 20;

    /* renamed from: a */
    private static final Object f23966a = new Object();

    /* renamed from: b */
    private static Gesture f23967b = null;

    /* renamed from: c */
    private static int f23968c = 0;

    /* renamed from: d */
    private static final int f23969d = 5;

    /* renamed from: e */
    private int f23970e;

    /* renamed from: f */
    private float f23971f;

    /* renamed from: g */
    private float f23972g;

    /* renamed from: h */
    private Object f23973h;

    /* renamed from: i */
    private Gesture f23974i;

    /* renamed from: j */
    private boolean f23975j;

    /* renamed from: k */
    private GLOverlayView f23976k;
    public PointF postCenter;
    public double postVector;
    public PointF preCenter;
    public double preVector;

    private Gesture(float f, float f2, int i) {
        this.f23971f = f;
        this.f23972g = f2;
        this.f23970e = i;
        this.f23975j = false;
    }

    private Gesture() {
    }

    public int getType() {
        return this.f23970e;
    }

    public float getX() {
        return this.f23971f;
    }

    public float getY() {
        return this.f23972g;
    }

    public Object getObj() {
        return this.f23973h;
    }

    public void setObj(Object obj) {
        this.f23973h = obj;
    }

    public GLOverlayView getGlOverlayView() {
        return this.f23976k;
    }

    public void setGlOverlayView(GLOverlayView gLOverlayView) {
        this.f23976k = gLOverlayView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo70287a() {
        if (!this.f23975j) {
            synchronized (f23966a) {
                if (f23968c < 5) {
                    f23968c++;
                    this.f23974i = f23967b;
                    this.f23973h = null;
                    this.preCenter = null;
                    this.postCenter = null;
                    this.preVector = 0.0d;
                    this.postVector = 0.0d;
                    this.f23976k = null;
                    f23967b = this;
                    this.f23975j = true;
                }
            }
        }
    }

    /* renamed from: b */
    private static Gesture m17050b() {
        synchronized (f23966a) {
            Gesture gesture = f23967b;
            if (gesture == null) {
                Gesture gesture2 = new Gesture();
                return gesture2;
            }
            f23967b = gesture.f23974i;
            f23968c--;
            return gesture;
        }
    }

    /* renamed from: a */
    static Gesture m17048a(float f, float f2, int i, Object obj) {
        Gesture b = m17050b();
        b.f23974i = null;
        b.f23971f = f;
        b.f23972g = f2;
        b.f23970e = i;
        b.f23973h = obj;
        b.f23975j = false;
        return b;
    }

    /* renamed from: a */
    static Gesture m17049a(int i, Object obj) {
        return m17048a(0.0f, 0.0f, i, obj);
    }
}
