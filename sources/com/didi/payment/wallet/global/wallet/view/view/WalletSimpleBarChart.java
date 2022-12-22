package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.didi.component.confirmbroadingpoint.impl.view.DotLoadingView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class WalletSimpleBarChart extends View {

    /* renamed from: A */
    private OnSelectedListener f32483A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public OperationListener f32484B;

    /* renamed from: C */
    private GestureDetector f32485C;

    /* renamed from: D */
    private GestureDetector.SimpleOnGestureListener f32486D;

    /* renamed from: a */
    private int f32487a;

    /* renamed from: b */
    private int f32488b;

    /* renamed from: c */
    private int f32489c;

    /* renamed from: d */
    private int f32490d;

    /* renamed from: e */
    private RectF f32491e;

    /* renamed from: f */
    private int f32492f;

    /* renamed from: g */
    private int f32493g;

    /* renamed from: h */
    private int f32494h;

    /* renamed from: i */
    private int f32495i;

    /* renamed from: j */
    private int f32496j;

    /* renamed from: k */
    private int f32497k;

    /* renamed from: l */
    private int[] f32498l;

    /* renamed from: m */
    private float f32499m;

    /* renamed from: n */
    private Paint f32500n;

    /* renamed from: o */
    private Paint f32501o;

    /* renamed from: p */
    private Paint f32502p;

    /* renamed from: q */
    private Paint f32503q;

    /* renamed from: r */
    private Paint f32504r;

    /* renamed from: s */
    private Paint f32505s;

    /* renamed from: t */
    private RectF[] f32506t;

    /* renamed from: u */
    private Map<Integer, RectF> f32507u;

    /* renamed from: v */
    private Map<Integer, LinearGradient> f32508v;

    /* renamed from: w */
    private float[] f32509w;

    /* renamed from: x */
    private String[] f32510x;

    /* renamed from: y */
    private int f32511y;

    /* renamed from: z */
    private int f32512z;

    public interface OnSelectedListener {
        void onSelectedListener(int i);
    }

    public interface OperationListener {
        void onOperationEnd();

        void onOperationStart();

        void onOperationVerticalScroll();
    }

    public boolean canScrollHorizontally(int i) {
        return false;
    }

    public WalletSimpleBarChart(Context context) {
        this(context, (AttributeSet) null);
    }

    public WalletSimpleBarChart(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletSimpleBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32486D = new GestureDetector.SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f2) <= Math.abs(f) + 30.0f || WalletSimpleBarChart.this.f32484B == null) {
                    return false;
                }
                WalletSimpleBarChart.this.f32484B.onOperationVerticalScroll();
                return false;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f2) <= Math.abs(f) || WalletSimpleBarChart.this.f32484B == null) {
                    return false;
                }
                WalletSimpleBarChart.this.f32484B.onOperationVerticalScroll();
                return false;
            }
        };
        m23040a(attributeSet);
    }

    /* renamed from: a */
    private void m23040a(AttributeSet attributeSet) {
        setLayerType(2, (Paint) null);
        this.f32489c = UIUtils.dip2px(getContext(), 1.0f);
        this.f32490d = UIUtils.dip2px(getContext(), 30.0f);
        Paint paint = new Paint(1);
        this.f32500n = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f32500n.setColor(DotLoadingView.COLOR_LOADING_DEFAULT_NORMAL);
        this.f32498l = new int[]{-79616, -79616};
        Paint paint2 = new Paint(1);
        this.f32501o = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f32501o.setAntiAlias(true);
        Paint paint3 = new Paint(1);
        this.f32503q = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f32503q.setColor(-12037798);
        Paint paint4 = new Paint(1);
        this.f32504r = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f32504r.setColor(-12037798);
        Paint paint5 = new Paint(1);
        this.f32505s = paint5;
        paint5.setStyle(Paint.Style.FILL);
        this.f32505s.setColor(-1);
        Paint paint6 = new Paint(1);
        this.f32502p = paint6;
        paint6.setTextSize((float) UIUtils.dip2px(getContext(), 12.0f));
        this.f32502p.setColor(-7829368);
        this.f32512z = ResourcesHelper.getColor(getContext(), R.color.wallet_color_3FC790);
        this.f32492f = UIUtils.dip2px(getContext(), 20.0f);
        this.f32496j = UIUtils.dip2px(getContext(), 4.0f);
        this.f32493g = UIUtils.dip2px(getContext(), 6.0f);
        this.f32494h = UIUtils.dip2px(getContext(), 12.0f);
        this.f32495i = 2;
        this.f32497k = UIUtils.dip2px(getContext(), 4.5f);
        this.f32507u = new HashMap();
        this.f32508v = new HashMap();
        this.f32485C = new GestureDetector(getContext(), this.f32486D);
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.f32483A = onSelectedListener;
    }

    public void setOperationListener(OperationListener operationListener) {
        this.f32484B = operationListener;
    }

    public void setDataList(float[] fArr, String[] strArr) {
        if (!CollectionUtil.isEmpty(fArr) && !CollectionUtil.isEmpty((Object[]) strArr)) {
            m23037a();
            this.f32509w = fArr;
            this.f32510x = strArr;
            m23042b();
            m23044c();
            postInvalidate();
        }
    }

    /* renamed from: a */
    private void m23037a() {
        this.f32492f = UIUtils.dip2px(getContext(), 15.0f);
        this.f32511y = 0;
    }

    /* renamed from: b */
    private void m23042b() {
        int i;
        if (!CollectionUtil.isEmpty(this.f32509w) && this.f32487a != 0 && this.f32488b != 0) {
            int i2 = this.f32488b;
            int i3 = this.f32490d;
            float f = 0.0f;
            this.f32491e = new RectF(0.0f, (float) ((i2 - i3) - this.f32489c), (float) this.f32487a, (float) (i2 - i3));
            float[] fArr = this.f32509w;
            int i4 = 0;
            float f2 = 0.0f;
            for (float f3 : fArr) {
                if (f2 < f3) {
                    f2 = f3;
                }
            }
            int length = fArr.length;
            this.f32506t = new RectF[length];
            int i5 = length > 1 ? (this.f32487a - (this.f32492f * length)) / (length - 1) : 0;
            if (length > 1 && i5 < (i = this.f32496j)) {
                this.f32492f = (this.f32487a - ((length - 1) * i)) / length;
                i5 = i;
            }
            float f4 = f2 * 100.0f;
            int i6 = this.f32488b;
            int i7 = this.f32489c;
            int i8 = this.f32490d;
            float f5 = (float) (((i6 - i7) - i8) - this.f32494h);
            float f6 = (float) ((i6 - i7) - i8);
            float f7 = 0.0f;
            while (i4 < length) {
                float f8 = (((float) this.f32494h) + f5) - (f4 == f ? 0.0f : ((fArr[i4] * 100.0f) * f5) / f4);
                float f9 = ((float) this.f32492f) + f7;
                int i9 = this.f32495i;
                if (f6 - f8 < ((float) i9)) {
                    f8 = f6 - ((float) i9);
                }
                this.f32506t[i4] = new RectF(f7, f8, f9, f6);
                f7 = f7 + ((float) this.f32492f) + ((float) i5);
                i4++;
                f = 0.0f;
            }
            this.f32511y = length - 1;
        }
    }

    /* renamed from: c */
    private void m23044c() {
        float f = 0.0f;
        for (String measureText : this.f32510x) {
            f = Math.max(this.f32502p.measureText(measureText), f);
        }
        this.f32499m = f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f32487a = getMeasuredWidth();
        this.f32488b = getMeasuredHeight();
        m23042b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            m23038a(motionEvent.getX());
        }
        if (this.f32484B != null) {
            if (motionEvent.getAction() == 0) {
                this.f32484B.onOperationStart();
            } else if (motionEvent.getAction() == 1) {
                this.f32484B.onOperationEnd();
            }
        }
        this.f32485C.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: a */
    private void m23038a(float f) {
        if (!CollectionUtil.isEmpty((Object[]) this.f32506t)) {
            int i = 0;
            int i2 = 0;
            while (true) {
                RectF[] rectFArr = this.f32506t;
                if (i2 >= rectFArr.length) {
                    i = -1;
                    break;
                }
                RectF rectF = rectFArr[i2];
                if (f > rectF.centerX()) {
                    i2++;
                } else if (i2 != 0) {
                    int i3 = i2 - 1;
                    i = Math.abs(f - rectF.centerX()) > Math.abs(f - this.f32506t[i3].centerX()) ? i3 : i2;
                }
            }
            if (i == -1) {
                i = this.f32506t.length - 1;
            }
            if (this.f32511y != i) {
                this.f32511y = i;
                postInvalidate();
                OnSelectedListener onSelectedListener = this.f32483A;
                if (onSelectedListener != null) {
                    onSelectedListener.onSelectedListener(this.f32511y);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!CollectionUtil.isEmpty((Object[]) this.f32506t)) {
            m23039a(canvas);
            m23043b(canvas);
            m23046d(canvas);
            m23045c(canvas);
        }
    }

    /* renamed from: a */
    private void m23039a(Canvas canvas) {
        canvas.drawRect(this.f32491e, this.f32500n);
    }

    /* renamed from: b */
    private void m23043b(Canvas canvas) {
        for (RectF rectF : this.f32506t) {
            this.f32501o.setShader(m23035a(rectF));
            if (((float) (this.f32493g + 10)) < rectF.height()) {
                int i = this.f32493g;
                canvas.drawRoundRect(rectF, (float) i, (float) i, this.f32501o);
                canvas.drawRect(m23041b(rectF), this.f32501o);
            } else {
                canvas.drawRect(rectF, this.f32501o);
            }
        }
    }

    /* renamed from: a */
    private LinearGradient m23035a(RectF rectF) {
        if (rectF == null || this.f32498l == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(rectF.hashCode());
        if (this.f32508v.containsKey(valueOf)) {
            return this.f32508v.get(valueOf);
        }
        LinearGradient linearGradient = new LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, this.f32498l, (float[]) null, Shader.TileMode.CLAMP);
        this.f32508v.put(valueOf, linearGradient);
        return linearGradient;
    }

    /* renamed from: b */
    private RectF m23041b(RectF rectF) {
        if (rectF == null) {
            return new RectF();
        }
        Integer valueOf = Integer.valueOf(rectF.hashCode());
        if (this.f32507u.containsKey(valueOf)) {
            return this.f32507u.get(valueOf);
        }
        RectF rectF2 = new RectF(rectF.left, rectF.bottom - ((float) this.f32493g), rectF.right, rectF.bottom);
        this.f32507u.put(valueOf, rectF2);
        return rectF2;
    }

    /* renamed from: c */
    private void m23045c(Canvas canvas) {
        RectF rectF = this.f32506t[this.f32511y];
        float centerX = rectF.centerX();
        float centerX2 = rectF.centerX();
        float f = rectF.bottom;
        float width = rectF.width() / 6.0f;
        if (width < 1.0f) {
            width = 1.0f;
        }
        this.f32503q.setStrokeWidth(width);
        canvas.drawLine(centerX, 0.0f, centerX2, f, this.f32503q);
        canvas.drawCircle(rectF.centerX(), rectF.top, (float) (this.f32492f / 2), this.f32504r);
        canvas.drawCircle(rectF.centerX(), rectF.top, (float) (this.f32492f / 5), this.f32505s);
    }

    /* renamed from: d */
    private void m23046d(Canvas canvas) {
        if (this.f32491e != null && !CollectionUtil.isEmpty((Object[]) this.f32510x)) {
            String[] strArr = this.f32510x;
            int i = 0;
            if (strArr.length < 3) {
                this.f32502p.setColor(-7829368);
                String[] strArr2 = this.f32510x;
                String str = strArr2[0];
                String str2 = strArr2[strArr2.length - 1];
                float abs = this.f32491e.bottom + ((float) this.f32497k) + Math.abs(this.f32502p.getFontMetrics().ascent);
                this.f32502p.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(str, this.f32491e.left, abs, this.f32502p);
                this.f32502p.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(str2, this.f32491e.right, abs, this.f32502p);
            } else if (strArr.length == this.f32506t.length) {
                canvas.rotate(-90.0f);
                this.f32502p.setTextAlign(Paint.Align.LEFT);
                Paint.FontMetrics fontMetrics = this.f32502p.getFontMetrics();
                float f = ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) - fontMetrics.descent;
                float f2 = this.f32491e.bottom + ((float) this.f32497k) + this.f32499m;
                while (true) {
                    RectF[] rectFArr = this.f32506t;
                    if (i < rectFArr.length) {
                        RectF rectF = rectFArr[i];
                        if (i == this.f32511y) {
                            this.f32502p.setTypeface(Typeface.DEFAULT_BOLD);
                            this.f32502p.setColor(this.f32512z);
                        } else {
                            this.f32502p.setTypeface(Typeface.DEFAULT);
                            this.f32502p.setColor(-7829368);
                        }
                        canvas.drawText(this.f32510x[i], -f2, rectF.centerX() + f, this.f32502p);
                        i++;
                    } else {
                        canvas.rotate(90.0f);
                        return;
                    }
                }
            }
        }
    }
}
