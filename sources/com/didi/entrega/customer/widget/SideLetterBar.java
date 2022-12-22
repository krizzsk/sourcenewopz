package com.didi.entrega.customer.widget;

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
    private String[] f20352a = {"★", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, C16471q.f49112a, C16471q.f49113b, "Z"};

    /* renamed from: b */
    private int f20353b = -1;

    /* renamed from: c */
    private Paint f20354c = new Paint();

    /* renamed from: d */
    private boolean f20355d = false;

    /* renamed from: e */
    private OnLetterChangedListener f20356e;

    /* renamed from: f */
    private TextView f20357f;

    /* renamed from: g */
    private ViewTreeObserver.OnGlobalLayoutListener f20358g = new ViewTreeObserver.OnGlobalLayoutListener() {
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

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20355d) {
            canvas.drawColor(0);
        }
        int height = getHeight();
        int width = getWidth();
        String[] strArr = this.f20352a;
        if (strArr != null && strArr.length > 0) {
            int length = height / strArr.length;
            for (int i = 0; i < this.f20352a.length; i++) {
                this.f20354c.setTextSize(DisplayUtils.sp2px(getContext(), 12.0f));
                this.f20354c.setColor(getResources().getColor(R.color.rf_color_gery_2_40_666666));
                this.f20354c.setAntiAlias(true);
                canvas.drawText(this.f20352a[i], ((float) (width / 2)) - (this.f20354c.measureText(this.f20352a[i]) / 2.0f), (float) ((length * i) + length), this.f20354c);
                this.f20354c.reset();
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.f20353b;
        OnLetterChangedListener onLetterChangedListener = this.f20356e;
        float height = y / ((float) getHeight());
        String[] strArr = this.f20352a;
        int length = (int) (height * ((float) strArr.length));
        if (action == 0) {
            this.f20355d = true;
            if (i != length && onLetterChangedListener != null && length >= 0 && length < strArr.length) {
                onLetterChangedListener.onLetterChanged(strArr[length]);
                this.f20353b = length;
                invalidate();
                TextView textView = this.f20357f;
                if (textView != null) {
                    textView.setVisibility(0);
                    this.f20357f.setText(this.f20352a[length]);
                }
            }
        } else if (action == 1) {
            this.f20355d = false;
            this.f20353b = -1;
            invalidate();
            TextView textView2 = this.f20357f;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else if (action == 2 && i != length && onLetterChangedListener != null && length >= 0 && length < strArr.length) {
            onLetterChangedListener.onLetterChanged(strArr[length]);
            this.f20353b = length;
            invalidate();
            TextView textView3 = this.f20357f;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.f20357f.setText(this.f20352a[length]);
            }
        }
        return true;
    }

    public void setLetters(String[] strArr) {
        this.f20352a = strArr;
        postInvalidate();
    }

    public void setOnLetterChangedListener(OnLetterChangedListener onLetterChangedListener) {
        this.f20356e = onLetterChangedListener;
    }

    public void setOverlay(TextView textView) {
        this.f20357f = textView;
    }
}
