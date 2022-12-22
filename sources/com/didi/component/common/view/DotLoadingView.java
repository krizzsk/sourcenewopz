package com.didi.component.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.didi.sdk.util.ResourcesHelper;

public class DotLoadingView extends View {
    public static final int COLOR_LOADING_DEFAULT_NORMAL = 2131101823;

    /* renamed from: a */
    Runnable f11817a = new Runnable() {
        public void run() {
            DotLoadingView dotLoadingView = DotLoadingView.this;
            dotLoadingView.updateStepView(dotLoadingView.f11818b);
            DotLoadingView.m8011b(DotLoadingView.this);
            if (DotLoadingView.this.f11818b >= 4) {
                int unused = DotLoadingView.this.f11818b = 1;
            }
            DotLoadingView.this.f11823g.postDelayed(DotLoadingView.this.f11817a, 200);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f11818b = 0;

    /* renamed from: c */
    private Paint f11819c;

    /* renamed from: d */
    private Paint f11820d;

    /* renamed from: e */
    private float f11821e = 8.0f;

    /* renamed from: f */
    private float f11822f = 12.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f11823g = new Handler();

    /* renamed from: h */
    private final int f11824h = 120;

    /* renamed from: i */
    private final int f11825i = 40;

    /* renamed from: j */
    private int f11826j;

    /* renamed from: k */
    private int f11827k;

    /* renamed from: l */
    private int f11828l;

    /* renamed from: m */
    private int f11829m;

    /* renamed from: b */
    static /* synthetic */ int m8011b(DotLoadingView dotLoadingView) {
        int i = dotLoadingView.f11818b;
        dotLoadingView.f11818b = i + 1;
        return i;
    }

    public DotLoadingView(Context context) {
        super(context);
        m8010a();
    }

    public DotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8010a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(120, 40);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8010a();
    }

    /* renamed from: a */
    private void m8010a() {
        Paint paint = new Paint();
        this.f11819c = paint;
        paint.setColor(ResourcesHelper.getColor(getContext(), COLOR_LOADING_DEFAULT_NORMAL));
        this.f11819c.setAntiAlias(true);
        this.f11819c.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f11820d = paint2;
        paint2.setColor(ResourcesHelper.getColor(getContext(), COLOR_LOADING_DEFAULT_NORMAL));
        this.f11820d.setStyle(Paint.Style.FILL);
        this.f11827k = 20;
        this.f11828l = 60;
        this.f11829m = 100;
        this.f11826j = 20;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.f11818b;
        if (i == 0) {
            canvas.drawCircle((float) this.f11827k, (float) this.f11826j, this.f11821e, this.f11819c);
            canvas.drawCircle((float) this.f11828l, (float) this.f11826j, this.f11821e, this.f11819c);
            canvas.drawCircle((float) this.f11829m, (float) this.f11826j, this.f11821e, this.f11819c);
        } else if (i == 1) {
            canvas.drawCircle((float) this.f11827k, (float) this.f11826j, this.f11822f, this.f11820d);
            canvas.drawCircle((float) this.f11828l, (float) this.f11826j, this.f11821e, this.f11819c);
            canvas.drawCircle((float) this.f11829m, (float) this.f11826j, this.f11821e, this.f11819c);
        } else if (i == 2) {
            canvas.drawCircle((float) this.f11827k, (float) this.f11826j, this.f11821e, this.f11819c);
            canvas.drawCircle((float) this.f11828l, (float) this.f11826j, this.f11822f, this.f11820d);
            canvas.drawCircle((float) this.f11829m, (float) this.f11826j, this.f11821e, this.f11819c);
        } else if (i == 3) {
            canvas.drawCircle((float) this.f11827k, (float) this.f11826j, this.f11821e, this.f11819c);
            canvas.drawCircle((float) this.f11828l, (float) this.f11826j, this.f11821e, this.f11819c);
            canvas.drawCircle((float) this.f11829m, (float) this.f11826j, this.f11822f, this.f11820d);
        }
    }

    public void updateStepView(int i) {
        this.f11818b = i;
        invalidate();
    }

    public void startLoading() {
        this.f11818b = 0;
        this.f11823g.removeCallbacks(this.f11817a);
        this.f11823g.post(this.f11817a);
    }

    public void stopLoading() {
        this.f11818b = 0;
        this.f11823g.removeCallbacks(this.f11817a);
    }

    public void resetLoadingBarColor(int i, int i2) {
        this.f11819c.setColor(ResourcesHelper.getColor(getContext(), i));
        this.f11820d.setColor(ResourcesHelper.getColor(getContext(), i2));
    }
}
