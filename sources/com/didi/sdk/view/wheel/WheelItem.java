package com.didi.sdk.view.wheel;

import android.graphics.Canvas;
import android.graphics.Paint;

public class WheelItem {
    public static final int MARGIN = 5;
    public static final int TEXT_ALIGN_BOTTOM = 1048576;
    public static final int TEXT_ALIGN_CENTER_HORIZONTAL = 4096;
    public static final int TEXT_ALIGN_CENTER_VERTICAL = 256;
    public static final int TEXT_ALIGN_LEFT = 1;
    public static final int TEXT_ALIGN_RIGHT = 16;
    public static final int TEXT_ALIGN_TOP = 65536;

    /* renamed from: a */
    private Paint f38346a;

    /* renamed from: b */
    private int f38347b;

    /* renamed from: c */
    private float f38348c;

    /* renamed from: d */
    private float f38349d;

    /* renamed from: e */
    private float f38350e;

    /* renamed from: f */
    private float f38351f;

    /* renamed from: g */
    private float f38352g;

    /* renamed from: h */
    private String f38353h;

    /* renamed from: i */
    private int f38354i;

    public WheelItem(int i, int i2, int i3) {
        this.f38349d = (float) i;
        this.f38347b = i2;
        this.f38354i = i3;
    }

    public void setPaint(Paint paint) {
        this.f38346a = paint;
    }

    public String getTitle() {
        return this.f38353h;
    }

    public void setTitle(String str) {
        this.f38353h = str;
    }

    public float getTextCenterX() {
        return this.f38351f;
    }

    public void setTextCenterX(float f) {
        this.f38351f = f;
    }

    public float getTextBaselineY() {
        return this.f38352g;
    }

    public void setTextBaselineY(float f) {
        this.f38352g = f;
    }

    public float getWidth() {
        return this.f38349d;
    }

    public int getHeight() {
        return this.f38347b;
    }

    public float getLeft() {
        return this.f38348c;
    }

    public void setLeft(float f) {
        this.f38348c = f;
    }

    public float getRight() {
        return this.f38348c + this.f38349d;
    }

    public float getTop() {
        return this.f38350e;
    }

    public void setTop(float f) {
        this.f38350e = f;
    }

    public void draw(Canvas canvas) {
        String str = this.f38353h;
        float measureText = this.f38346a.measureText(str);
        int length = str.length();
        float f = this.f38349d - ((float) this.f38354i);
        do {
            if (measureText > f) {
                StringBuilder sb = new StringBuilder();
                length--;
                sb.append(str.substring(0, length));
                sb.append("...");
                str = sb.toString();
                measureText = this.f38346a.measureText(str);
            }
            if (measureText <= f) {
                break;
            }
        } while (length > 0);
        canvas.drawText(str, this.f38351f, this.f38350e + this.f38352g, this.f38346a);
    }
}
