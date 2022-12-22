package com.didi.soda.home.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.taxis99.R;

public class HomeCardBarAnimView extends View {

    /* renamed from: a */
    private static final String f43276a = "HomeCardBarAnimView";

    /* renamed from: b */
    private int f43277b;

    /* renamed from: c */
    private int f43278c;

    /* renamed from: d */
    private float f43279d;

    /* renamed from: e */
    private Paint f43280e;

    /* renamed from: f */
    private Paint f43281f;

    /* renamed from: g */
    private Paint f43282g;

    /* renamed from: h */
    private int f43283h;

    /* renamed from: i */
    private int f43284i;

    /* renamed from: j */
    private int f43285j;

    /* renamed from: k */
    private int f43286k;

    /* renamed from: l */
    private int f43287l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f43288m = 0;

    /* renamed from: n */
    private int f43289n = 0;

    /* renamed from: o */
    private ValueAnimator f43290o;

    /* renamed from: p */
    private ScopeContext f43291p;

    /* renamed from: q */
    private IScopeLifecycle f43292q;

    public HomeCardBarAnimView(Context context) {
        super(context);
        m30596a(context, (AttributeSet) null);
    }

    public HomeCardBarAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30596a(context, attributeSet);
    }

    public HomeCardBarAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30596a(context, attributeSet);
    }

    public HomeCardBarAnimView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m30596a(context, attributeSet);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtil.m29100d(f43276a, "onAttachedToWindow:" + this.f43288m);
        m30603e();
        m30607i();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtil.m29100d(f43276a, "onDetachedFromWindow:" + this.f43288m);
        m30604f();
        m30608j();
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f43291p = scopeContext;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f43283h = getMeasuredWidth();
        this.f43284i = getMeasuredHeight();
        int dip2px = DisplayUtils.dip2px(getContext(), 30.0f);
        this.f43285j = dip2px;
        int i5 = this.f43283h;
        this.f43286k = (dip2px * 3) + i5;
        this.f43287l = (i5 + (dip2px * 2)) / 50;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f43283h, (float) this.f43289n);
        int i = this.f43289n;
        path.addRoundRect(rectF, new float[]{(float) i, (float) i, (float) i, (float) i, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawRect(rectF, this.f43282g);
        canvas.save();
        canvas.translate((float) (this.f43287l * this.f43288m), 0.0f);
        m30602d();
        canvas.drawRect(new RectF((float) (-this.f43286k), 0.0f, 0.0f, (float) this.f43284i), this.f43280e);
        canvas.restore();
        canvas.save();
        canvas.skew(-0.75f, 0.0f);
        int i2 = this.f43283h / 4;
        for (int i3 = 1; i3 <= this.f43278c; i3++) {
            float f = ((float) (i2 * i3)) - (this.f43279d / 2.0f);
            canvas.drawRect(new RectF(f, 0.0f, this.f43279d + f, (float) this.f43284i), this.f43281f);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m30596a(Context context, AttributeSet attributeSet) {
        m30598b(context, attributeSet);
        m30595a();
        m30600c();
        m30597b();
        LogUtil.m29100d(f43276a, "init:" + this);
    }

    /* renamed from: b */
    private void m30598b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.HomeCardBarAnimView);
        this.f43277b = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.rf_color_v2_brands_1_100));
        this.f43278c = obtainStyledAttributes.getInt(1, 3);
        this.f43279d = (float) obtainStyledAttributes.getInt(2, DisplayUtils.dip2px(getContext(), 5.0f));
        this.f43289n = obtainStyledAttributes.getInt(3, (int) getResources().getDimension(R.dimen.rf_dimen_28));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m30595a() {
        Paint paint = new Paint();
        this.f43280e = paint;
        paint.setColor(this.f43277b);
        Paint paint2 = new Paint();
        this.f43282g = paint2;
        paint2.setColor(this.f43277b);
        this.f43282g.setAlpha(51);
        Paint paint3 = new Paint();
        this.f43281f = paint3;
        paint3.setColor(-1);
    }

    /* renamed from: b */
    private void m30597b() {
        this.f43292q = new IScopeLifecycle() {
            public void onCreate(ILive iLive) {
            }

            public void onDestroy(ILive iLive) {
            }

            public void onStart(ILive iLive) {
            }

            public void onStop(ILive iLive) {
            }

            public void onResume(ILive iLive) {
                LogUtil.m29100d(HomeCardBarAnimView.f43276a, "resumeScrollAnim:" + HomeCardBarAnimView.this.f43288m);
                HomeCardBarAnimView.this.m30606h();
            }

            public void onPause(ILive iLive) {
                LogUtil.m29100d(HomeCardBarAnimView.f43276a, "pauseScrollAnim:" + HomeCardBarAnimView.this.f43288m);
                HomeCardBarAnimView.this.m30605g();
            }
        };
    }

    /* renamed from: c */
    private void m30600c() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 100});
        this.f43290o = ofInt;
        ofInt.setRepeatCount(-1);
        Path path = new Path();
        path.quadTo(0.082f, 0.0f, 0.13f, 0.5f);
        path.lineTo(0.826f, 0.5f);
        path.quadTo(0.88f, 1.0f, 0.95f, 1.0f);
        path.lineTo(1.0f, 1.0f);
        this.f43290o.setInterpolator(PathInterpolatorCompat.create(path));
        this.f43290o.setDuration(4600);
        this.f43290o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = HomeCardBarAnimView.this.f43288m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                HomeCardBarAnimView.this.invalidate();
            }
        });
    }

    /* renamed from: d */
    private void m30602d() {
        if (this.f43288m <= 50) {
            int i = this.f43277b;
            this.f43280e.setShader(new LinearGradient((float) (-this.f43285j), 0.0f, 0.0f, 0.0f, new int[]{-855638017 & i, i & 16777215}, (float[]) null, Shader.TileMode.CLAMP));
            return;
        }
        int i2 = this.f43277b;
        Paint paint = this.f43280e;
        int i3 = this.f43286k;
        paint.setShader(new LinearGradient((float) (-i3), 0.0f, (float) ((-i3) + this.f43285j), 0.0f, new int[]{16777215 & i2, -855638017 & i2}, (float[]) null, Shader.TileMode.CLAMP));
    }

    /* renamed from: e */
    private void m30603e() {
        ValueAnimator valueAnimator = this.f43290o;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* renamed from: f */
    private void m30604f() {
        ValueAnimator valueAnimator = this.f43290o;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m30605g() {
        ValueAnimator valueAnimator = this.f43290o;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m30606h() {
        ValueAnimator valueAnimator = this.f43290o;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    /* renamed from: i */
    private void m30607i() {
        if (this.f43291p != null) {
            LogUtil.m29100d(f43276a, "bindScopeContextLife:" + this.f43292q);
            this.f43291p.addObserver(this.f43292q);
        }
    }

    /* renamed from: j */
    private void m30608j() {
        if (this.f43291p != null) {
            LogUtil.m29100d(f43276a, "unbindScopeContextLife:" + this.f43292q);
            this.f43291p.removeObserver(this.f43292q);
        }
    }
}
