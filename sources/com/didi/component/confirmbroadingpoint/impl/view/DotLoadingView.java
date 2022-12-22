package com.didi.component.confirmbroadingpoint.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.didi.component.common.util.UIUtils;
import com.didi.sdk.util.ResourcesHelper;

public class DotLoadingView extends View {
    public static final int COLOR_LOADING_DEFAULT_NORMAL = 419430400;
    public static final int COlor_LOADING_DEFAULT_PUSH = 2131101823;

    /* renamed from: a */
    Runnable f12671a = new Runnable() {
        public void run() {
            DotLoadingView dotLoadingView = DotLoadingView.this;
            dotLoadingView.updateStepView(dotLoadingView.f12672b);
            DotLoadingView.m8627b(DotLoadingView.this);
            if (DotLoadingView.this.f12672b >= 4) {
                int unused = DotLoadingView.this.f12672b = 1;
            }
            DotLoadingView.this.f12677g.postDelayed(DotLoadingView.this.f12671a, 200);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f12672b = 0;

    /* renamed from: c */
    private Paint f12673c;

    /* renamed from: d */
    private Paint f12674d;

    /* renamed from: e */
    private float f12675e = 8.0f;

    /* renamed from: f */
    private float f12676f = 12.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f12677g = new Handler();

    /* renamed from: h */
    private final int f12678h = UIUtils.dip2pxInt(getContext(), 47.0f);

    /* renamed from: i */
    private final int f12679i = UIUtils.dip2pxInt(getContext(), 15.0f);

    /* renamed from: j */
    private int f12680j;

    /* renamed from: k */
    private int f12681k;

    /* renamed from: l */
    private int f12682l;

    /* renamed from: m */
    private int f12683m;

    /* renamed from: b */
    static /* synthetic */ int m8627b(DotLoadingView dotLoadingView) {
        int i = dotLoadingView.f12672b;
        dotLoadingView.f12672b = i + 1;
        return i;
    }

    public DotLoadingView(Context context) {
        super(context);
        m8626a();
    }

    public DotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8626a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.f12678h, this.f12679i);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8626a();
    }

    /* renamed from: a */
    private void m8626a() {
        Paint paint = new Paint();
        this.f12673c = paint;
        paint.setColor(COLOR_LOADING_DEFAULT_NORMAL);
        this.f12673c.setAntiAlias(true);
        this.f12673c.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f12674d = paint2;
        paint2.setColor(838860800);
        this.f12674d.setStyle(Paint.Style.FILL);
        int i = this.f12678h;
        this.f12681k = i / 6;
        this.f12682l = i / 2;
        this.f12683m = (i / 6) * 5;
        this.f12680j = this.f12679i / 2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.f12672b;
        if (i == 0) {
            canvas.drawCircle((float) this.f12681k, (float) this.f12680j, this.f12675e, this.f12673c);
            canvas.drawCircle((float) this.f12682l, (float) this.f12680j, this.f12675e, this.f12673c);
            canvas.drawCircle((float) this.f12683m, (float) this.f12680j, this.f12675e, this.f12673c);
        } else if (i == 1) {
            canvas.drawCircle((float) this.f12681k, (float) this.f12680j, this.f12676f, this.f12674d);
            canvas.drawCircle((float) this.f12682l, (float) this.f12680j, this.f12675e, this.f12673c);
            canvas.drawCircle((float) this.f12683m, (float) this.f12680j, this.f12675e, this.f12673c);
        } else if (i == 2) {
            canvas.drawCircle((float) this.f12681k, (float) this.f12680j, this.f12675e, this.f12673c);
            canvas.drawCircle((float) this.f12682l, (float) this.f12680j, this.f12676f, this.f12674d);
            canvas.drawCircle((float) this.f12683m, (float) this.f12680j, this.f12675e, this.f12673c);
        } else if (i == 3) {
            canvas.drawCircle((float) this.f12681k, (float) this.f12680j, this.f12675e, this.f12673c);
            canvas.drawCircle((float) this.f12682l, (float) this.f12680j, this.f12675e, this.f12673c);
            canvas.drawCircle((float) this.f12683m, (float) this.f12680j, this.f12676f, this.f12674d);
        }
    }

    public void updateStepView(int i) {
        this.f12672b = i;
        invalidate();
    }

    public void startLoading() {
        this.f12672b = 0;
        this.f12677g.removeCallbacks(this.f12671a);
        this.f12677g.post(this.f12671a);
    }

    public void stopLoading() {
        this.f12672b = 0;
        this.f12677g.removeCallbacks(this.f12671a);
    }

    public void resetLoadingBarColor(int i, int i2) {
        this.f12673c.setColor(ResourcesHelper.getColor(getContext(), i));
        this.f12674d.setColor(ResourcesHelper.getColor(getContext(), i2));
    }
}
