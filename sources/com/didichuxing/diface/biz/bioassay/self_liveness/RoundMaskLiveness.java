package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.MathUtils;
import com.didichuxing.diface.utils.DisplayUtils;
import com.taxis99.R;

public class RoundMaskLiveness extends View {

    /* renamed from: w */
    private static final int f47335w = -657931;

    /* renamed from: x */
    private static int f47336x = -13399809;

    /* renamed from: a */
    private Paint f47337a;

    /* renamed from: b */
    private int f47338b;

    /* renamed from: c */
    private RectF f47339c;

    /* renamed from: d */
    private PorterDuffXfermode f47340d;

    /* renamed from: e */
    private int f47341e;

    /* renamed from: f */
    private Bitmap f47342f;

    /* renamed from: g */
    private int f47343g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f47344h;

    /* renamed from: i */
    private Rect f47345i;

    /* renamed from: j */
    private ValueAnimator f47346j;

    /* renamed from: k */
    private boolean f47347k;

    /* renamed from: l */
    private boolean f47348l;

    /* renamed from: m */
    private final int f47349m = DisplayUtils.dip2px(getContext(), 10.0f);

    /* renamed from: n */
    private Path f47350n;

    /* renamed from: o */
    private String f47351o = "";

    /* renamed from: p */
    private int f47352p = -1;

    /* renamed from: q */
    private int f47353q = 1719960708;

    /* renamed from: r */
    private int f47354r;

    /* renamed from: s */
    private int f47355s;

    /* renamed from: t */
    private Rect f47356t;

    /* renamed from: u */
    private int f47357u = -1;

    /* renamed from: v */
    private Context f47358v;

    /* renamed from: y */
    private int f47359y = 70;

    public RoundMaskLiveness(Context context) {
        super(context);
        this.f47358v = context;
        m33930a();
    }

    public RoundMaskLiveness(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47358v = context;
        m33930a();
    }

    /* renamed from: a */
    private void m33930a() {
        f47336x = -13399809;
        this.f47338b = DisplayUtils.dip2px(getContext(), 5.0f);
        this.f47337a = new Paint(1);
        this.f47340d = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.df_face_gradient_rect_area);
        this.f47342f = decodeResource;
        int height = decodeResource.getHeight();
        this.f47343g = height;
        this.f47344h = (-height) / 3;
        this.f47354r = DisplayUtils.dip2px(getContext(), 17.0f);
        this.f47355s = DisplayUtils.dip2px(getContext(), 12.0f);
        this.f47356t = new Rect();
    }

    public void setProgress(int i) {
        this.f47341e = MathUtils.clamp(i, 0, 100);
        invalidate();
    }

    public void setHintMessage(String str) {
        this.f47351o = str;
        postInvalidate();
    }

    public void setHintMessage(int i) {
        try {
            this.f47351o = getResources().getString(i);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        this.f47337a.setColor(this.f47357u);
        int i = width / 2;
        int i2 = i - this.f47349m;
        float f = (float) i;
        float f2 = (float) i2;
        canvas2.drawCircle(f, f, f2, this.f47337a);
        this.f47337a.setXfermode(this.f47340d);
        canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.f47337a);
        this.f47337a.setXfermode((Xfermode) null);
        if (this.f47339c == null) {
            int i3 = this.f47338b;
            int i4 = this.f47349m;
            this.f47339c = new RectF((float) (i3 / 2), (float) (((i - i2) - i4) + (i3 / 2)), (float) (width - (i3 / 2)), (float) (((i + i2) + i4) - (i3 / 2)));
        }
        mo116362a(canvas2, i2);
        this.f47337a.setColor(f47335w);
        this.f47337a.setStyle(Paint.Style.STROKE);
        this.f47337a.setStrokeWidth((float) this.f47338b);
        float f3 = (float) 90;
        float f4 = (float) 360;
        canvas.drawArc(this.f47339c, f3, f4, false, this.f47337a);
        if (this.f47341e != 0) {
            this.f47337a.setColor(f47336x);
            this.f47337a.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawArc(this.f47339c, f3, (float) ((int) ((((float) this.f47341e) / 100.0f) * f4)), false, this.f47337a);
        }
        if (this.f47348l && !this.f47347k) {
            if (this.f47350n == null) {
                Path path = new Path();
                this.f47350n = path;
                path.addCircle(f, f, f2, Path.Direction.CCW);
            }
            Rect rect = this.f47345i;
            if (rect == null) {
                int i5 = this.f47344h;
                this.f47345i = new Rect(0, i5, width, this.f47343g + i5);
            } else {
                rect.top = this.f47344h;
                this.f47345i.bottom = this.f47344h + this.f47343g;
            }
            LogUtils.m33563d("progress 100, rectStartY===" + this.f47344h);
            canvas2.clipRect(this.f47345i);
            canvas2.clipPath(this.f47350n, Region.Op.INTERSECT);
            canvas2.drawBitmap(this.f47342f, (Rect) null, this.f47345i, this.f47337a);
            if (this.f47346j == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f47344h, width - this.f47343g});
                this.f47346j = ofInt;
                ofInt.setRepeatCount(-1);
                this.f47346j.setRepeatMode(1);
                this.f47346j.setInterpolator(new LinearInterpolator());
                this.f47346j.setDuration(3000);
                this.f47346j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int unused = RoundMaskLiveness.this.f47344h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        RoundMaskLiveness.this.postInvalidate();
                    }
                });
                this.f47346j.start();
            }
        }
        this.f47337a.reset();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo116362a(Canvas canvas, int i) {
        if (!TextUtils.isEmpty(this.f47351o)) {
            this.f47337a.setStrokeJoin(Paint.Join.BEVEL);
            this.f47337a.setStyle(Paint.Style.FILL);
            this.f47337a.setColor(this.f47353q);
            this.f47337a.setTextSize((float) this.f47354r);
            Paint paint = this.f47337a;
            String str = this.f47351o;
            paint.getTextBounds(str, 0, str.length(), this.f47356t);
            double d = (double) i;
            int sin = (int) (((Math.sin(1.0471975511965976d) * d) * 3.0d) / 2.0d);
            int cos = (int) (d - (Math.cos(1.0471975511965976d) * d));
            if (this.f47356t.width() > sin) {
                this.f47337a.setTextSize((float) this.f47355s);
                Paint paint2 = this.f47337a;
                String str2 = this.f47351o;
                paint2.getTextBounds(str2, 0, str2.length(), this.f47356t);
            }
            canvas.drawArc(this.f47339c, 210.0f, 120.0f, false, this.f47337a);
            this.f47337a.setColor(this.f47352p);
            this.f47337a.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f47351o, this.f47339c.width() / 2.0f, (float) (((cos * 2) / 3) + (this.f47338b / 2) + (this.f47356t.height() / 2)), this.f47337a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo116361a(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-13244);
        canvas.drawBitmap(this.f47342f, (Rect) null, this.f47345i, paint);
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Bitmap mo116363b(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-10048769);
        float f = (float) (i / 2);
        canvas.drawCircle(f, f, f, paint);
        return createBitmap;
    }

    public void onFaceOk() {
        this.f47348l = true;
        invalidate();
    }

    public void cancelRectAnim() {
        ValueAnimator valueAnimator = this.f47346j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f47347k = true;
            this.f47346j = null;
            invalidate();
        }
    }

    public void resetRectAnim() {
        this.f47344h = (-this.f47343g) / 3;
        this.f47347k = false;
        this.f47348l = false;
    }

    /* renamed from: b */
    private void m33931b() {
        int i = this.f47359y - 5;
        this.f47359y = i;
        if (((float) i) <= 10.0f) {
            this.f47359y = 70;
        }
        postDelayed(new Runnable() {
            public void run() {
                RoundMaskLiveness.this.invalidate();
            }
        }, 200);
    }

    public void updateStatus(int i, int i2) {
        this.f47357u = i;
        this.f47341e = i2;
        invalidate();
    }
}
