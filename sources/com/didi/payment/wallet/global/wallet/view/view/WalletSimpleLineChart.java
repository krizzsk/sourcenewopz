package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifiedPay.util.UIUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WalletSimpleLineChart extends View {

    /* renamed from: a */
    private static final float f32513a = 0.25f;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public OperationListener f32514A;

    /* renamed from: B */
    private GestureDetector f32515B;

    /* renamed from: C */
    private GestureDetector.SimpleOnGestureListener f32516C;

    /* renamed from: b */
    private int f32517b;

    /* renamed from: c */
    private int f32518c;

    /* renamed from: d */
    private int f32519d;

    /* renamed from: e */
    private int f32520e;

    /* renamed from: f */
    private int f32521f;

    /* renamed from: g */
    private int f32522g;

    /* renamed from: h */
    private RectF f32523h;

    /* renamed from: i */
    private int f32524i;

    /* renamed from: j */
    private int f32525j;

    /* renamed from: k */
    private int f32526k;

    /* renamed from: l */
    private int f32527l;

    /* renamed from: m */
    private Path f32528m;

    /* renamed from: n */
    private Paint f32529n;

    /* renamed from: o */
    private Paint f32530o;

    /* renamed from: p */
    private Paint f32531p;

    /* renamed from: q */
    private Paint f32532q;

    /* renamed from: r */
    private Paint f32533r;

    /* renamed from: s */
    private Paint f32534s;

    /* renamed from: t */
    private Paint f32535t;

    /* renamed from: u */
    private PointF[] f32536u;

    /* renamed from: v */
    private List<PointF> f32537v;

    /* renamed from: w */
    private float[] f32538w;

    /* renamed from: x */
    private String[] f32539x;

    /* renamed from: y */
    private int f32540y;

    /* renamed from: z */
    private OnSelectedListener f32541z;

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

    public WalletSimpleLineChart(Context context) {
        this(context, (AttributeSet) null);
    }

    public WalletSimpleLineChart(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletSimpleLineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32516C = new GestureDetector.SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f2) <= Math.abs(f) + 30.0f || WalletSimpleLineChart.this.f32514A == null) {
                    return false;
                }
                WalletSimpleLineChart.this.f32514A.onOperationVerticalScroll();
                return false;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f2) <= Math.abs(f) || WalletSimpleLineChart.this.f32514A == null) {
                    return false;
                }
                WalletSimpleLineChart.this.f32514A.onOperationVerticalScroll();
                return false;
            }
        };
        m23051a(attributeSet);
    }

    /* renamed from: a */
    private void m23051a(AttributeSet attributeSet) {
        setLayerType(2, (Paint) null);
        this.f32521f = UIUtils.dip2px(getContext(), 1.0f);
        this.f32522g = UIUtils.dip2px(getContext(), 30.0f);
        Paint paint = new Paint(1);
        this.f32529n = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f32529n.setColor(-13421773);
        Paint paint2 = new Paint(1);
        this.f32535t = paint2;
        paint2.setAlpha(255);
        this.f32535t.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.f32534s = paint3;
        paint3.setStrokeCap(Paint.Cap.ROUND);
        this.f32534s.setStyle(Paint.Style.STROKE);
        this.f32534s.setStrokeWidth((float) UIUtils.dip2px(getContext(), 2.0f));
        this.f32534s.setColor(-16320);
        this.f32528m = new Path();
        Paint paint4 = new Paint(1);
        this.f32531p = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f32531p.setColor(-12037798);
        Paint paint5 = new Paint(1);
        this.f32532q = paint5;
        paint5.setStyle(Paint.Style.FILL);
        this.f32532q.setColor(-12037798);
        Paint paint6 = new Paint(1);
        this.f32533r = paint6;
        paint6.setStyle(Paint.Style.FILL);
        this.f32533r.setColor(-1);
        Paint paint7 = new Paint(1);
        this.f32530o = paint7;
        paint7.setTextSize((float) UIUtils.dip2px(getContext(), 12.0f));
        this.f32530o.setColor(-7829368);
        this.f32524i = UIUtils.dip2px(getContext(), 4.5f);
        this.f32525j = UIUtils.dip2px(getContext(), 12.0f);
        this.f32526k = UIUtils.dip2px(getContext(), 2.0f);
        int dip2px = UIUtils.dip2px(getContext(), 10.0f);
        this.f32520e = dip2px;
        this.f32519d = dip2px;
        this.f32527l = UIUtils.dip2px(getContext(), 4.0f);
        this.f32537v = new ArrayList();
        this.f32515B = new GestureDetector(getContext(), this.f32516C);
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.f32541z = onSelectedListener;
    }

    public void setOperationListener(OperationListener operationListener) {
        this.f32514A = operationListener;
    }

    public void setDataList(float[] fArr, String[] strArr) {
        if (!CollectionUtil.isEmpty(fArr) && !CollectionUtil.isEmpty((Object[]) strArr)) {
            m23048a();
            this.f32538w = fArr;
            this.f32539x = strArr;
            m23053b();
            postInvalidate();
        }
    }

    /* renamed from: a */
    private void m23048a() {
        this.f32540y = 0;
    }

    /* renamed from: b */
    private void m23053b() {
        if (!CollectionUtil.isEmpty(this.f32538w) && this.f32517b != 0 && this.f32518c != 0) {
            int i = this.f32518c;
            int i2 = this.f32522g;
            this.f32523h = new RectF((float) this.f32519d, (float) ((i - i2) - this.f32521f), (float) (this.f32517b - this.f32520e), (float) (i - i2));
            float f = 0.0f;
            this.f32535t.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f32523h.top, new int[]{603963456, 16760896}, (float[]) null, Shader.TileMode.CLAMP));
            float[] fArr = this.f32538w;
            float f2 = 0.0f;
            for (float f3 : fArr) {
                if (f2 < f3) {
                    f2 = f3;
                }
            }
            int length = fArr.length;
            this.f32536u = new PointF[length];
            int i3 = length - 1;
            if (i3 > 0) {
                f = ((float) ((this.f32517b - this.f32519d) - this.f32520e)) / ((float) i3);
            } else if (length == 1) {
                f = (float) ((this.f32517b - this.f32519d) - this.f32520e);
            }
            float f4 = (float) (this.f32519d + (this.f32526k / 2));
            float f5 = f2 * 100.0f;
            float f6 = (float) (((this.f32518c - this.f32521f) - this.f32522g) - this.f32525j);
            for (int i4 = 0; i4 < length; i4++) {
                float f7 = (((float) this.f32525j) + f6) - (((fArr[i4] * 100.0f) * f6) / f5);
                if (f7 > this.f32523h.top) {
                    f7 = this.f32523h.top;
                }
                this.f32536u[i4] = new PointF(f4, f7);
                f4 += f;
            }
            m23052a(this.f32536u);
            this.f32540y = i3;
        }
    }

    /* renamed from: a */
    private void m23052a(PointF[] pointFArr) {
        this.f32537v.clear();
        if (!CollectionUtil.isEmpty((Object[]) pointFArr) && pointFArr.length > 1) {
            for (int i = 0; i < pointFArr.length; i++) {
                PointF pointF = pointFArr[i];
                if (i == 0) {
                    PointF pointF2 = pointFArr[i + 1];
                    this.f32537v.add(new PointF(pointF.x + ((pointF2.x - pointF.x) * f32513a), pointF.y));
                } else if (i == pointFArr.length - 1) {
                    PointF pointF3 = pointFArr[i - 1];
                    this.f32537v.add(new PointF(pointF.x - ((pointF.x - pointF3.x) * f32513a), pointF.y));
                } else {
                    PointF pointF4 = pointFArr[i - 1];
                    PointF pointF5 = pointFArr[i + 1];
                    float f = (pointF5.y - pointF4.y) / (pointF5.x - pointF4.x);
                    float f2 = pointF.y - (pointF.x * f);
                    float f3 = pointF.x - ((pointF.x - pointF4.x) * f32513a);
                    this.f32537v.add(new PointF(f3, (f * f3) + f2));
                    float f4 = pointF.x + ((pointF5.x - pointF.x) * f32513a);
                    this.f32537v.add(new PointF(f4, (f * f4) + f2));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f32517b = getMeasuredWidth();
        this.f32518c = getMeasuredHeight();
        m23053b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            m23049a(motionEvent.getX());
        }
        if (this.f32514A != null) {
            if (motionEvent.getAction() == 0) {
                this.f32514A.onOperationStart();
            } else if (motionEvent.getAction() == 1) {
                this.f32514A.onOperationEnd();
            }
        }
        this.f32515B.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: a */
    private void m23049a(float f) {
        if (!CollectionUtil.isEmpty((Object[]) this.f32536u)) {
            int i = 0;
            int i2 = 0;
            while (true) {
                PointF[] pointFArr = this.f32536u;
                if (i2 >= pointFArr.length) {
                    i = -1;
                    break;
                }
                PointF pointF = pointFArr[i2];
                if (f > pointF.x) {
                    i2++;
                } else if (i2 != 0) {
                    int i3 = i2 - 1;
                    i = Math.abs(f - pointF.x) > Math.abs(f - this.f32536u[i3].x) ? i3 : i2;
                }
            }
            if (i == -1) {
                i = this.f32536u.length - 1;
            }
            if (this.f32540y != i) {
                this.f32540y = i;
                postInvalidate();
                OnSelectedListener onSelectedListener = this.f32541z;
                if (onSelectedListener != null) {
                    onSelectedListener.onSelectedListener(this.f32540y);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!CollectionUtil.isEmpty((Object[]) this.f32536u) && this.f32523h != null) {
            canvas.save();
            canvas.clipRect(0.0f, 0.0f, (float) getWidth(), this.f32523h.top);
            m23054b(canvas);
            canvas.restore();
            m23050a(canvas);
            m23056d(canvas);
            m23055c(canvas);
        }
    }

    /* renamed from: a */
    private void m23050a(Canvas canvas) {
        canvas.drawRect(this.f32523h, this.f32529n);
    }

    /* renamed from: b */
    private void m23054b(Canvas canvas) {
        this.f32528m.reset();
        PointF pointF = this.f32536u[0];
        this.f32528m.moveTo(pointF.x, pointF.y);
        if (!CollectionUtil.isEmpty((Collection<?>) this.f32537v)) {
            for (int i = 0; i < (this.f32536u.length - 1) * 2; i += 2) {
                PointF pointF2 = this.f32537v.get(i);
                PointF pointF3 = this.f32537v.get(i + 1);
                PointF pointF4 = this.f32536u[(i / 2) + 1];
                this.f32528m.cubicTo(pointF2.x, pointF2.y, pointF3.x, pointF3.y, pointF4.x, pointF4.y);
            }
        }
        PointF[] pointFArr = this.f32536u;
        PointF pointF5 = pointFArr[pointFArr.length - 1];
        Path path = new Path(this.f32528m);
        path.lineTo(pointF5.x, this.f32523h.top);
        path.lineTo(pointF.x, this.f32523h.top);
        path.lineTo(pointF.x, pointF.y);
        canvas.drawPath(path, this.f32535t);
        canvas.drawPath(this.f32528m, this.f32534s);
    }

    /* renamed from: c */
    private void m23055c(Canvas canvas) {
        PointF pointF = this.f32536u[this.f32540y];
        float f = pointF.x;
        float f2 = pointF.x;
        float f3 = this.f32523h.top;
        this.f32531p.setStrokeWidth((float) this.f32526k);
        canvas.drawLine(f, 0.0f, f2, f3, this.f32531p);
        canvas.drawCircle(pointF.x, pointF.y, (float) this.f32524i, this.f32532q);
        canvas.drawCircle(pointF.x, pointF.y, (float) (this.f32524i / 2), this.f32533r);
    }

    /* renamed from: d */
    private void m23056d(Canvas canvas) {
        String[] strArr = this.f32539x;
        String str = strArr[0];
        String str2 = strArr[strArr.length - 1];
        float abs = this.f32523h.bottom + ((float) this.f32527l) + Math.abs(this.f32530o.getFontMetrics().ascent);
        this.f32530o.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(str, this.f32523h.left, abs, this.f32530o);
        this.f32530o.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(str2, this.f32523h.right, abs, this.f32530o);
    }
}
