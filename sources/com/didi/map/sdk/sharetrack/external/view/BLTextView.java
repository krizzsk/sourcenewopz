package com.didi.map.sdk.sharetrack.external.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.didi.common.map.util.SystemUtil;
import com.didi.passenger.C10448R;

public class BLTextView extends View {

    /* renamed from: a */
    private Paint f28689a;

    /* renamed from: b */
    private Paint f28690b;

    /* renamed from: c */
    private Paint.FontMetrics f28691c;

    /* renamed from: d */
    private Paint.FontMetrics f28692d;

    /* renamed from: e */
    private String f28693e;

    /* renamed from: f */
    private int f28694f;

    /* renamed from: g */
    private int f28695g;

    /* renamed from: h */
    private int f28696h;

    /* renamed from: i */
    private int f28697i;

    /* renamed from: j */
    private int f28698j;

    /* renamed from: k */
    private float f28699k;

    public BLTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BLTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BLTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28694f = GravityCompat.START;
        this.f28697i = -13421773;
        this.f28698j = -869059789;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.BLTextView);
        if (obtainStyledAttributes != null) {
            if (obtainStyledAttributes.getInt(5, 1) == 2) {
                this.f28694f = GravityCompat.END;
            } else {
                this.f28694f = GravityCompat.START;
            }
            this.f28693e = obtainStyledAttributes.getString(4);
            this.f28695g = obtainStyledAttributes.getDimensionPixelSize(1, SystemUtil.dip2px(context, 22.0f));
            this.f28696h = obtainStyledAttributes.getDimensionPixelSize(3, SystemUtil.dip2px(context, 16.0f));
            this.f28697i = obtainStyledAttributes.getColor(0, -13421773);
            this.f28698j = obtainStyledAttributes.getColor(2, -869059789);
            obtainStyledAttributes.recycle();
        }
        m20229a();
    }

    /* renamed from: a */
    private void m20229a() {
        Paint paint = new Paint();
        this.f28689a = paint;
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        this.f28689a.setColor(this.f28697i);
        this.f28689a.setStyle(Paint.Style.FILL);
        this.f28689a.setFlags(1);
        this.f28689a.setTextSize((float) this.f28695g);
        Paint paint2 = new Paint();
        this.f28690b = paint2;
        paint2.setTypeface(Typeface.DEFAULT);
        this.f28690b.setColor(this.f28698j);
        this.f28690b.setStyle(Paint.Style.FILL);
        this.f28690b.setFlags(1);
        this.f28690b.setTextSize((float) this.f28696h);
        if (this.f28694f == 8388611) {
            this.f28689a.setTextAlign(Paint.Align.LEFT);
            this.f28690b.setTextAlign(Paint.Align.LEFT);
        } else {
            this.f28689a.setTextAlign(Paint.Align.RIGHT);
            this.f28690b.setTextAlign(Paint.Align.RIGHT);
        }
        this.f28691c = this.f28689a.getFontMetrics();
        this.f28692d = this.f28690b.getFontMetrics();
    }

    public void setGravity(int i) {
        int i2 = i == 2 ? GravityCompat.END : GravityCompat.START;
        this.f28694f = i2;
        if (i2 == 8388611) {
            this.f28689a.setTextAlign(Paint.Align.LEFT);
            this.f28690b.setTextAlign(Paint.Align.LEFT);
        } else {
            this.f28689a.setTextAlign(Paint.Align.RIGHT);
            this.f28690b.setTextAlign(Paint.Align.RIGHT);
        }
        m20231b();
    }

    public void setTextSize(int i, int i2) {
        this.f28695g = i;
        this.f28696h = i2;
        this.f28689a.setTextSize((float) i);
        this.f28690b.setTextSize((float) this.f28696h);
        m20231b();
    }

    public void setTextColor(int i, int i2) {
        this.f28695g = i;
        this.f28698j = i2;
        this.f28689a.setColor(i);
        this.f28690b.setColor(i2);
        m20231b();
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        if (!str.equals(this.f28693e)) {
            this.f28693e = str;
            requestLayout();
        }
    }

    public String getText() {
        return this.f28693e;
    }

    /* renamed from: b */
    private void m20231b() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            Paint.FontMetricsInt fontMetricsInt = this.f28689a.getFontMetricsInt();
            setMeasuredDimension(m20232c(), (fontMetricsInt.bottom - fontMetricsInt.top) + getPaddingTop() + getPaddingBottom());
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(m20232c(), size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            Paint.FontMetricsInt fontMetricsInt2 = this.f28689a.getFontMetricsInt();
            setMeasuredDimension(size, (fontMetricsInt2.bottom - fontMetricsInt2.top) + getPaddingTop() + getPaddingBottom());
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    /* renamed from: c */
    private int m20232c() {
        float f;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        float f2 = 0.0f;
        if (!TextUtils.isEmpty(this.f28693e)) {
            float measureText = this.f28690b.measureText(" ");
            for (int i = 0; i < this.f28693e.length(); i++) {
                char charAt = this.f28693e.charAt(i);
                String valueOf = String.valueOf(charAt);
                if ((charAt >= '0' && charAt <= '9') || charAt == ',' || charAt == '.') {
                    f = this.f28689a.measureText(valueOf);
                } else {
                    f = this.f28690b.measureText(valueOf);
                }
                f2 += f;
            }
            f2 += measureText * 2.0f;
        }
        return (int) (((float) paddingLeft) + f2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(this.f28693e)) {
            if (this.f28691c == null) {
                this.f28691c = this.f28689a.getFontMetrics();
            }
            if (this.f28692d == null) {
                this.f28692d = this.f28690b.getFontMetrics();
            }
            float height = ((float) (getHeight() >> 1)) + ((Math.abs(this.f28691c.ascent) - this.f28691c.descent) / 2.0f);
            float f = (this.f28692d.bottom + height) - this.f28692d.descent;
            int i = this.f28694f;
            if (i == 8388611) {
                this.f28699k = (float) getPaddingLeft();
                m20230a(canvas, this.f28690b, " ", f);
                for (int i2 = 0; i2 < this.f28693e.length(); i2++) {
                    char charAt = this.f28693e.charAt(i2);
                    String valueOf = String.valueOf(charAt);
                    if ((charAt >= '0' && charAt <= '9') || charAt == ',' || charAt == '.') {
                        m20230a(canvas, this.f28689a, valueOf, height);
                    } else {
                        m20230a(canvas, this.f28690b, valueOf, f);
                    }
                }
                m20230a(canvas, this.f28690b, " ", f);
            } else if (i == 8388613) {
                this.f28699k = (float) (getWidth() - getPaddingRight());
                m20230a(canvas, this.f28690b, " ", f);
                for (int length = this.f28693e.length() - 1; length >= 0; length--) {
                    char charAt2 = this.f28693e.charAt(length);
                    String valueOf2 = String.valueOf(charAt2);
                    if ((charAt2 >= '0' && charAt2 <= '9') || charAt2 == ',' || charAt2 == '.') {
                        m20230a(canvas, this.f28689a, valueOf2, height);
                    } else {
                        m20230a(canvas, this.f28690b, valueOf2, f);
                    }
                }
                m20230a(canvas, this.f28690b, " ", f);
            }
        }
    }

    /* renamed from: a */
    private void m20230a(Canvas canvas, Paint paint, String str, float f) {
        canvas.drawText(str, this.f28699k, f, paint);
        float measureText = paint.measureText(str);
        if (this.f28694f == 8388611) {
            this.f28699k += measureText;
        } else {
            this.f28699k -= measureText;
        }
    }
}
