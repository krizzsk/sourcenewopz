package com.didi.hawaii.mapsdkv2.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import com.didi.entrega.customer.foundation.rpc.ApiErrorConst;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.map.common.utils.SystemUtil;

public class ScaleView extends View implements GLBaseMapView.ScaleRulerUpdateCallback {

    /* renamed from: a */
    private static final int f24159a = 5;

    /* renamed from: b */
    private static final int f24160b = 3;

    /* renamed from: c */
    private static final int f24161c = 10;

    /* renamed from: d */
    private static final int f24162d = 200;

    /* renamed from: e */
    private final int[] f24163e = {2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, ApiErrorConst.Code.ERROR_50000, 100000, 200000, 500000, 1000000, 2000000};

    /* renamed from: f */
    private float f24164f;

    /* renamed from: g */
    private float f24165g = 0.0f;

    /* renamed from: h */
    private float f24166h = 0.0f;

    /* renamed from: i */
    private final Paint f24167i;

    /* renamed from: j */
    private final Paint f24168j;

    /* renamed from: k */
    private final Paint f24169k;

    /* renamed from: l */
    private final Paint f24170l;

    /* renamed from: m */
    private final Path f24171m;

    /* renamed from: n */
    private float f24172n;

    /* renamed from: o */
    private String f24173o;

    /* renamed from: p */
    private final GLBaseMapView f24174p;

    /* renamed from: q */
    private final Handler f24175q;

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public ScaleView(Context context, GLBaseMapView gLBaseMapView, int i, int i2) {
        super(context);
        this.f24172n = SystemUtil.getDensity(context);
        Paint paint = new Paint();
        this.f24167i = paint;
        paint.setColor(i);
        this.f24167i.setStyle(Paint.Style.STROKE);
        this.f24167i.setStrokeWidth(this.f24172n * 1.0f);
        this.f24167i.setAntiAlias(true);
        Paint paint2 = new Paint(this.f24167i);
        this.f24168j = paint2;
        paint2.setColor(i2);
        this.f24168j.setStrokeWidth(this.f24172n * 2.5f);
        TextPaint textPaint = new TextPaint();
        this.f24169k = textPaint;
        textPaint.setTextSize(this.f24172n * 10.0f);
        this.f24169k.setTypeface(Typeface.DEFAULT);
        this.f24169k.setStyle(Paint.Style.FILL);
        this.f24169k.setAntiAlias(true);
        this.f24169k.setTextAlign(Paint.Align.LEFT);
        this.f24169k.setLinearText(true);
        this.f24169k.setColor(i);
        Paint paint3 = new Paint(this.f24169k);
        this.f24170l = paint3;
        paint3.setStrokeWidth(this.f24172n * 1.5f);
        this.f24170l.setStyle(Paint.Style.STROKE);
        this.f24170l.setColor(i2);
        this.f24174p = gLBaseMapView;
        this.f24175q = gLBaseMapView.getMainHandler();
        this.f24171m = new Path();
        this.f24173o = "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71537a() {
        this.f24174p.setScaleRuler(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71539b() {
        this.f24174p.setScaleRuler((GLBaseMapView.ScaleRulerUpdateCallback) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71538a(int i, int i2) {
        this.f24167i.setColor(i);
        this.f24168j.setColor(i2);
        this.f24169k.setColor(i);
        this.f24170l.setColor(i2);
        m17248a((int) this.f24164f, this.f24165g, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17248a(int i, float f, boolean z) {
        if (z || this.f24164f != ((float) i) || this.f24165g != f) {
            this.f24164f = (float) i;
            this.f24165g = f;
            int i2 = this.f24163e[Math.min(Math.max(0, 21 - i), this.f24163e.length - 1)];
            float round = (float) Math.round((320.0d / ((double) f)) * ((double) i2));
            this.f24166h = round;
            if (round > 200.0f) {
                this.f24166h = 200.0f;
            }
            if (i2 < 1000) {
                this.f24173o = i2 + "米";
            } else {
                this.f24173o = (i2 / 1000) + "公里";
            }
            this.f24171m.reset();
            this.f24171m.moveTo(5.0f, this.f24172n * 12.0f);
            Path path = this.f24171m;
            float f2 = this.f24172n;
            path.lineTo(5.0f, (f2 * 12.0f) + (f2 * 3.0f));
            float f3 = this.f24172n;
            this.f24171m.lineTo(this.f24166h + 5.0f, (f3 * 12.0f) + (f3 * 3.0f));
            this.f24171m.lineTo(this.f24166h + 5.0f, this.f24172n * 12.0f);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float f = this.f24172n;
        setMeasuredDimension(((int) Math.max(this.f24169k.measureText(this.f24173o), this.f24166h)) + 5 + 1000, ((int) ((10.0f * f) + (f * 2.0f) + (3.0f * f))) + ((int) (f * 2.0f)));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawColor(0);
        canvas.drawText(this.f24173o, 5.0f, this.f24172n * 10.0f, this.f24170l);
        canvas.drawText(this.f24173o, 5.0f, this.f24172n * 10.0f, this.f24169k);
        canvas.drawPath(this.f24171m, this.f24168j);
        canvas.drawPath(this.f24171m, this.f24167i);
    }

    public void onUpdate(final float f, final float f2) {
        this.f24175q.post(new Runnable() {
            public void run() {
                ScaleView.this.m17248a((int) f, f2, false);
            }
        });
    }
}
