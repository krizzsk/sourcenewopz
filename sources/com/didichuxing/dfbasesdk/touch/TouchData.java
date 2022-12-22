package com.didichuxing.dfbasesdk.touch;

public class TouchData {
    public int action;
    public int actionIndex;
    public int actionMasked;
    public int buttonState;
    public int deviceId;
    public long downTime;
    public int edgeFlags;
    public long eventTime;
    public int flags;
    public int metaState;
    public String page;
    public int pointerCount;
    public Pointer[] pointers;
    public int source;
    public float xPrecision;
    public float yPrecision;

    public static class PView {
        public String content;

        /* renamed from: id */
        public String f46676id;
        public int locationX;
        public int locationY;
        public int measuredHeight;
        public int measuredWidth;
        public String type;
    }

    public static class Pointer {
        public float orientation;
        public int pointerId;
        public float pressure;
        public float size;
        public float toolMajor;
        public float toolMinor;
        public int toolType;
        public float touchMajor;
        public float touchMinor;
        public PView view;

        /* renamed from: x */
        public float f46677x;

        /* renamed from: y */
        public float f46678y;
    }
}
