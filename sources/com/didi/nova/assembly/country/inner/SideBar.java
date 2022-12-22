package com.didi.nova.assembly.country.inner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.taxis99.R;

public class SideBar extends View {

    /* renamed from: a */
    private OnTouchingLetterChangedListener f29195a;

    /* renamed from: b */
    private String[] f29196b;

    /* renamed from: c */
    private int f29197c;

    /* renamed from: d */
    private Paint f29198d;

    /* renamed from: e */
    private int f29199e;

    public interface OnTouchingLetterChangedListener {
        void onTouchingLetterChanged(String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29196b = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, C16471q.f49112a, C16471q.f49113b, "Z"};
        this.f29197c = -1;
        this.f29198d = new Paint();
        init();
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SideBar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.f29199e = ContextCompat.getColor(getContext(), R.color.assembly_unit_color_333333);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int length = height / this.f29196b.length;
        for (int i = 0; i < this.f29196b.length; i++) {
            this.f29198d.setColor(this.f29199e);
            this.f29198d.setAntiAlias(true);
            this.f29198d.setTextSize(((float) length) * 0.8f);
            canvas.drawText(this.f29196b[i], (((float) width) / 2.0f) - (this.f29198d.measureText(this.f29196b[i]) / 2.0f), (float) ((length * i) + length), this.f29198d);
            this.f29198d.reset();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.f29197c;
        OnTouchingLetterChangedListener onTouchingLetterChangedListener = this.f29195a;
        float height = y / ((float) getHeight());
        String[] strArr = this.f29196b;
        int length = (int) (height * ((float) strArr.length));
        if (action == 1) {
            this.f29197c = -1;
            invalidate();
        } else if (i != length && length >= 0 && length < strArr.length) {
            if (onTouchingLetterChangedListener != null) {
                onTouchingLetterChangedListener.onTouchingLetterChanged(strArr[length]);
            }
            this.f29197c = length;
            invalidate();
        }
        return true;
    }

    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.f29195a = onTouchingLetterChangedListener;
    }
}
