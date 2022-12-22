package com.didichuxing.cardscan.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import java.util.Arrays;

/* renamed from: com.didichuxing.cardscan.view.b */
public class C15188b {

    /* renamed from: a */
    private boolean f46223a = false;

    /* renamed from: b */
    private float f46224b;

    /* renamed from: c */
    private float f46225c;

    public C15188b(float f, float f2) {
        this.f46224b = f;
        this.f46225c = f2;
    }

    /* renamed from: a */
    private static Path m33194a() {
        Path path = new Path();
        path.moveTo(10.0f, 0.0f);
        path.lineTo(0.0f, 11.0f);
        path.lineTo(6.0f, 11.0f);
        path.lineTo(2.0f, 20.0f);
        path.lineTo(13.0f, 8.0f);
        path.lineTo(7.0f, 8.0f);
        path.lineTo(10.0f, 0.0f);
        path.setLastPoint(10.0f, 0.0f);
        Matrix matrix = new Matrix();
        matrix.postTranslate(-6.5f, -10.0f);
        matrix.postScale(0.05f, 0.05f);
        path.transform(matrix);
        return path;
    }

    /* renamed from: a */
    public void mo114857a(Canvas canvas) {
        canvas.save();
        canvas.translate((-this.f46224b) / 2.0f, (-this.f46225c) / 2.0f);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.5f);
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-1);
        paint2.setAlpha(this.f46223a ? 192 : 96);
        float[] fArr = new float[8];
        Arrays.fill(fArr, 5.0f);
        RoundRectShape roundRectShape = new RoundRectShape(fArr, (RectF) null, (float[]) null);
        roundRectShape.resize(this.f46224b, this.f46225c);
        roundRectShape.draw(canvas, paint2);
        roundRectShape.draw(canvas, paint);
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        paint3.setAntiAlias(true);
        if (this.f46223a) {
            paint3.setColor(-1);
        } else {
            paint3.setColor(-16777216);
        }
        Path a = m33194a();
        Matrix matrix = new Matrix();
        float f = this.f46225c * 0.8f;
        matrix.postScale(f, f);
        a.transform(matrix);
        canvas.translate(this.f46224b / 2.0f, this.f46225c / 2.0f);
        canvas.drawPath(a, paint3);
        canvas.restore();
    }

    /* renamed from: a */
    public void mo114858a(boolean z) {
        this.f46223a = z;
    }
}
