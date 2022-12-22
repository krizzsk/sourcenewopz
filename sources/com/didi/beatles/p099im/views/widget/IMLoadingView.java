package com.didi.beatles.p099im.views.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p099im.resource.IMResource;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.widget.IMLoadingView */
public class IMLoadingView extends View {

    /* renamed from: a */
    Runnable f10474a = new Runnable() {
        public void run() {
            IMLoadingView iMLoadingView = IMLoadingView.this;
            iMLoadingView.updateStepView(iMLoadingView.f10475b);
            IMLoadingView.m7115b(IMLoadingView.this);
            if (IMLoadingView.this.f10475b >= 4) {
                int unused = IMLoadingView.this.f10475b = 1;
            }
            IMLoadingView.this.f10480g.postDelayed(IMLoadingView.this.f10474a, 200);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f10475b = 0;

    /* renamed from: c */
    private Paint f10476c;

    /* renamed from: d */
    private Paint f10477d;

    /* renamed from: e */
    private float f10478e = 8.0f;

    /* renamed from: f */
    private float f10479f = 12.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f10480g = new Handler();

    /* renamed from: h */
    private final int f10481h = 120;

    /* renamed from: i */
    private final int f10482i = 40;

    /* renamed from: j */
    private int f10483j;

    /* renamed from: k */
    private int f10484k;

    /* renamed from: l */
    private int f10485l;

    /* renamed from: m */
    private int f10486m;

    /* renamed from: b */
    static /* synthetic */ int m7115b(IMLoadingView iMLoadingView) {
        int i = iMLoadingView.f10475b;
        iMLoadingView.f10475b = i + 1;
        return i;
    }

    public IMLoadingView(Context context) {
        super(context);
        m7114a();
    }

    public IMLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7114a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(120, 40);
    }

    public IMLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7114a();
    }

    /* renamed from: a */
    private void m7114a() {
        Paint paint = new Paint();
        this.f10476c = paint;
        paint.setColor(IMResource.getColor(R.color.title_bar_line_bg));
        this.f10476c.setAntiAlias(true);
        this.f10476c.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f10477d = paint2;
        paint2.setColor(IMResource.getColor(R.color.title_bar_line_bg));
        this.f10477d.setStyle(Paint.Style.FILL);
        this.f10484k = 20;
        this.f10485l = 60;
        this.f10486m = 100;
        this.f10483j = 20;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawColor(IMResource.getColor(R.color.white));
        int i = this.f10475b;
        if (i == 0) {
            canvas.drawCircle((float) this.f10484k, (float) this.f10483j, this.f10478e, this.f10476c);
            canvas.drawCircle((float) this.f10485l, (float) this.f10483j, this.f10478e, this.f10476c);
            canvas.drawCircle((float) this.f10486m, (float) this.f10483j, this.f10478e, this.f10476c);
        } else if (i == 1) {
            canvas.drawCircle((float) this.f10484k, (float) this.f10483j, this.f10479f, this.f10477d);
            canvas.drawCircle((float) this.f10485l, (float) this.f10483j, this.f10478e, this.f10476c);
            canvas.drawCircle((float) this.f10486m, (float) this.f10483j, this.f10478e, this.f10476c);
        } else if (i == 2) {
            canvas.drawCircle((float) this.f10484k, (float) this.f10483j, this.f10478e, this.f10476c);
            canvas.drawCircle((float) this.f10485l, (float) this.f10483j, this.f10479f, this.f10477d);
            canvas.drawCircle((float) this.f10486m, (float) this.f10483j, this.f10478e, this.f10476c);
        } else if (i == 3) {
            canvas.drawCircle((float) this.f10484k, (float) this.f10483j, this.f10478e, this.f10476c);
            canvas.drawCircle((float) this.f10485l, (float) this.f10483j, this.f10478e, this.f10476c);
            canvas.drawCircle((float) this.f10486m, (float) this.f10483j, this.f10479f, this.f10477d);
        }
    }

    public void updateStepView(int i) {
        this.f10475b = i;
        invalidate();
    }

    public void startLoading() {
        this.f10475b = 0;
        this.f10480g.removeCallbacks(this.f10474a);
        this.f10480g.post(this.f10474a);
    }

    public void stopLoading() {
        this.f10475b = 0;
        this.f10480g.removeCallbacks(this.f10474a);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.f10480g;
        if (handler != null) {
            handler.removeCallbacks(this.f10474a);
        }
    }
}
