package com.didichuxing.xpanel.channel.global.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.taxis99.R;

public class XPanelHeaderBarView extends FrameLayout {

    /* renamed from: a */
    private static final int f49409a = 40;

    /* renamed from: b */
    private static final int f49410b = 5;

    /* renamed from: c */
    private static final int f49411c = 20;

    /* renamed from: d */
    private Paint f49412d;

    /* renamed from: e */
    private Paint f49413e;

    /* renamed from: f */
    private RectF f49414f;

    /* renamed from: g */
    private float f49415g;

    /* renamed from: h */
    private float f49416h;

    /* renamed from: i */
    private boolean f49417i;

    /* renamed from: j */
    private float f49418j;

    /* renamed from: k */
    private int f49419k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f49420l;

    /* renamed from: m */
    private int f49421m;

    /* renamed from: n */
    private float f49422n;

    /* renamed from: o */
    private boolean f49423o;

    /* renamed from: p */
    private boolean f49424p;

    /* renamed from: q */
    private View f49425q;

    /* renamed from: r */
    private XPanelDragBarView f49426r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public XPanelHeardBarTopView f49427s;

    /* renamed from: t */
    private ValueAnimator f49428t;

    /* renamed from: u */
    private final long f49429u;

    /* renamed from: v */
    private final int f49430v;

    public XPanelHeaderBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelHeaderBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelHeaderBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49412d = null;
        this.f49413e = null;
        this.f49414f = new RectF();
        this.f49416h = 1.0f;
        this.f49417i = true;
        this.f49419k = 423706956;
        this.f49420l = -1;
        this.f49421m = -1;
        this.f49422n = 0.0f;
        this.f49423o = false;
        this.f49424p = true;
        this.f49425q = null;
        this.f49429u = 30;
        this.f49430v = 255;
        m35686a(context);
    }

    public XPanelHeaderBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f49412d = null;
        this.f49413e = null;
        this.f49414f = new RectF();
        this.f49416h = 1.0f;
        this.f49417i = true;
        this.f49419k = 423706956;
        this.f49420l = -1;
        this.f49421m = -1;
        this.f49422n = 0.0f;
        this.f49423o = false;
        this.f49424p = true;
        this.f49425q = null;
        this.f49429u = 30;
        this.f49430v = 255;
        m35686a(context);
    }

    /* renamed from: a */
    private void m35686a(Context context) {
        setLayerType(1, (Paint) null);
        Paint paint = new Paint();
        this.f49412d = paint;
        paint.setAntiAlias(true);
        this.f49412d.setStyle(Paint.Style.FILL);
        this.f49412d.setColor(-16777216);
        this.f49412d.setDither(true);
        this.f49422n = TypedValue.applyDimension(1, 13.0f, getResources().getDisplayMetrics());
        this.f49415g = TypedValue.applyDimension(1, 17.0f, getResources().getDisplayMetrics());
        this.f49418j = TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.f49413e = new Paint(this.f49412d);
        XPanelDragBarView xPanelDragBarView = new XPanelDragBarView(context);
        this.f49426r = xPanelDragBarView;
        xPanelDragBarView.setContentDescription(getResources().getString(R.string.oc_x_panel_accessible_drag));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_width), getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_height));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (getResources().getDimensionPixelSize(R.dimen.oc_x_panel_header_view_height) - layoutParams.height) / 2;
        addView(this.f49426r, layoutParams);
        setCanDrag(false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f49414f.left = (float) getPaddingLeft();
        this.f49414f.top = ((float) getPaddingTop()) + getShadowHeight();
        RectF rectF = this.f49414f;
        rectF.right = (rectF.left + ((float) getMeasuredWidth())) - ((float) getPaddingRight());
        RectF rectF2 = this.f49414f;
        rectF2.bottom = (rectF2.top + ((float) getMeasuredHeight())) - ((float) getPaddingBottom());
        View view = this.f49425q;
        if (view != null && view.getVisibility() == 0) {
            this.f49425q.layout((int) this.f49414f.left, (int) this.f49414f.top, (int) (((float) this.f49425q.getMeasuredWidth()) + this.f49414f.left), (int) (this.f49414f.top + ((float) this.f49425q.getMeasuredHeight())));
        }
    }

    public float getShadowHeight() {
        return this.f49418j + this.f49422n;
    }

    public float getShadowShowHeight() {
        return this.f49418j;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f49424p) {
            this.f49413e.setShadowLayer(this.f49422n, 0.0f, -this.f49418j, this.f49419k);
        } else {
            this.f49413e.setShadowLayer(0.0f, 0.0f, -this.f49418j, this.f49419k);
        }
        this.f49413e.setColor(this.f49420l);
        this.f49412d.setColor(this.f49420l);
        m35687a(canvas);
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m35687a(Canvas canvas) {
        float roundRadiusRate = this.f49415g * getRoundRadiusRate();
        canvas.drawRoundRect(this.f49414f, roundRadiusRate, roundRadiusRate, this.f49413e);
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, this.f49414f.bottom - roundRadiusRate, roundRadiusRate, this.f49414f.bottom, this.f49412d);
        canvas2.drawRect(this.f49414f.right - roundRadiusRate, this.f49414f.bottom - roundRadiusRate, this.f49414f.right, this.f49414f.bottom, this.f49412d);
    }

    public void bindXPanelHeardBarTopView(XPanelHeardBarTopView xPanelHeardBarTopView) {
        this.f49427s = xPanelHeardBarTopView;
        if (xPanelHeardBarTopView != null) {
            xPanelHeardBarTopView.setDrawColor(this.f49420l);
        }
    }

    public void setRoundRadiusRate(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f49416h = f;
        setDragBarAngle(1.0f - f);
    }

    private void setDragBarAngle(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        float f2 = 180.0f;
        float f3 = 180.0f - ((f * 20.0f) * 2.0f);
        if (f3 <= 180.0f) {
            f2 = f3 < 90.0f ? 90.0f : f3;
        }
        this.f49426r.setDragAngle(f2);
    }

    public float getDragBarAngle() {
        return this.f49426r.getDragAngle();
    }

    public float getRoundRadiusRate() {
        if (this.f49417i) {
            return this.f49416h;
        }
        return 0.0f;
    }

    public void setShadowHeight(int i) {
        this.f49418j = TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
        requestLayout();
    }

    public void setShadowColor(int i) {
        this.f49419k = i;
        invalidate();
    }

    public void setForegroundColor(int i) {
        if (this.f49421m != i) {
            this.f49421m = i;
            m35685a();
        }
        invalidate();
    }

    /* renamed from: a */
    private void m35685a() {
        ValueAnimator valueAnimator = this.f49428t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i = this.f49420l;
        int i2 = this.f49421m;
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.f49428t = ofObject;
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = XPanelHeaderBarView.this.f49420l = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (XPanelHeaderBarView.this.f49427s != null) {
                    XPanelHeaderBarView.this.f49427s.setDrawColor(XPanelHeaderBarView.this.f49420l);
                }
                XPanelHeaderBarView.this.invalidate();
            }
        });
        this.f49428t.start();
    }

    public void setShadowVisibility(boolean z) {
        this.f49424p = z;
        invalidate();
    }

    public void setCanDrag(boolean z) {
        this.f49423o = z;
        this.f49426r.setVisibility(z ? 0 : 8);
    }

    public void setBarOnClickListener(View.OnClickListener onClickListener) {
        this.f49426r.setOnClickListener(onClickListener);
    }

    public void setRoundEnable(boolean z) {
        if (this.f49417i != z) {
            this.f49417i = z;
            invalidate();
        }
    }

    public void setLoadingView(View view) {
        if (view != null && view.getParent() == null) {
            this.f49425q = view;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            View view2 = this.f49425q;
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -2);
            }
            addView(view2, layoutParams);
        }
    }
}
