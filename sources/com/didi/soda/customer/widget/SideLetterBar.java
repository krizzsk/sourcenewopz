package com.didi.soda.customer.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.didi.app.nova.support.util.DisplayUtils;
import com.taxis99.R;

public class SideLetterBar extends View {

    /* renamed from: a */
    private String[] f41587a = {"★", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, C16471q.f49112a, C16471q.f49113b, "Z"};

    /* renamed from: b */
    private int f41588b = -1;

    /* renamed from: c */
    private Paint f41589c = new Paint();

    /* renamed from: d */
    private boolean f41590d = false;

    /* renamed from: e */
    private OnLetterChangedListener f41591e;

    /* renamed from: f */
    private TextView f41592f;

    /* renamed from: g */
    private ViewTreeObserver.OnGlobalLayoutListener f41593g = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            Rect rect = new Rect();
            ((Activity) SideLetterBar.this.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int screenHeight = DisplayUtils.getScreenHeight(SideLetterBar.this.getContext());
            if (Math.abs(screenHeight - rect.bottom) > screenHeight / 4) {
                if (SideLetterBar.this.getVisibility() == 0) {
                    SideLetterBar.this.setVisibility(8);
                }
            } else if (SideLetterBar.this.getVisibility() == 8) {
                SideLetterBar.this.setVisibility(0);
            }
        }
    };

    public interface OnLetterChangedListener {
        void onLetterChanged(String str);
    }

    public SideLetterBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SideLetterBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SideLetterBar(Context context) {
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.f41588b;
        OnLetterChangedListener onLetterChangedListener = this.f41591e;
        float height = y / ((float) getHeight());
        String[] strArr = this.f41587a;
        int length = (int) (height * ((float) strArr.length));
        if (action == 0) {
            this.f41590d = true;
            if (i != length && onLetterChangedListener != null && length >= 0 && length < strArr.length) {
                onLetterChangedListener.onLetterChanged(strArr[length]);
                this.f41588b = length;
                invalidate();
                TextView textView = this.f41592f;
                if (textView != null) {
                    textView.setVisibility(0);
                    this.f41592f.setText(this.f41587a[length]);
                }
            }
        } else if (action == 1) {
            this.f41590d = false;
            this.f41588b = -1;
            invalidate();
            TextView textView2 = this.f41592f;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else if (action == 2 && i != length && onLetterChangedListener != null && length >= 0 && length < strArr.length) {
            onLetterChangedListener.onLetterChanged(strArr[length]);
            this.f41588b = length;
            invalidate();
            TextView textView3 = this.f41592f;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.f41592f.setText(this.f41587a[length]);
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setLetters(String[] strArr) {
        this.f41587a = strArr;
        postInvalidate();
    }

    public void setOnLetterChangedListener(OnLetterChangedListener onLetterChangedListener) {
        this.f41591e = onLetterChangedListener;
    }

    public void setOverlay(TextView textView) {
        this.f41592f = textView;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f41590d) {
            canvas.drawColor(0);
        }
        int height = getHeight();
        int width = getWidth();
        String[] strArr = this.f41587a;
        if (strArr != null && strArr.length > 0) {
            int length = height / strArr.length;
            for (int i = 0; i < this.f41587a.length; i++) {
                this.f41589c.setTextSize(DisplayUtils.sp2px(getContext(), 12.0f));
                this.f41589c.setColor(getResources().getColor(R.color.rf_color_gery_2_40_666666));
                this.f41589c.setAntiAlias(true);
                canvas.drawText(this.f41587a[i], ((float) (width / 2)) - (this.f41589c.measureText(this.f41587a[i]) / 2.0f), (float) ((length * i) + length), this.f41589c);
                this.f41589c.reset();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
