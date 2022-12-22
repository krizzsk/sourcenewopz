package com.didichuxing.omega.sdk.feedback.wheelUi;

import android.graphics.Canvas;
import android.graphics.Paint;

class WheelItem {
    private final int mHeight;
    private Paint mPaint;
    private final int mSideMargin;
    private String mText;
    private float mTop;
    private final float mWidth;
    private float textBaselineY;
    private float textCenterX;

    public WheelItem(int i, int i2, int i3) {
        this.mWidth = (float) i;
        this.mHeight = i2;
        this.mSideMargin = i3;
    }

    public void setPaint(Paint paint) {
        this.mPaint = paint;
    }

    public void setTitle(String str) {
        this.mText = str;
    }

    public void setTextCenterX(float f) {
        this.textCenterX = f;
    }

    public void setTextBaselineY(float f) {
        this.textBaselineY = f;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public float getTop() {
        return this.mTop;
    }

    public void setTop(float f) {
        this.mTop = f;
    }

    public void draw(Canvas canvas) {
        String str = this.mText;
        float measureText = this.mPaint.measureText(str);
        int length = str.length();
        float f = this.mWidth - ((float) this.mSideMargin);
        do {
            if (measureText > f) {
                StringBuilder sb = new StringBuilder();
                length--;
                sb.append(str.substring(0, length));
                sb.append("...");
                str = sb.toString();
                measureText = this.mPaint.measureText(str);
            }
            if (measureText <= f) {
                break;
            }
        } while (length > 0);
        canvas.drawText(str, this.textCenterX, this.mTop + this.textBaselineY, this.mPaint);
    }
}
