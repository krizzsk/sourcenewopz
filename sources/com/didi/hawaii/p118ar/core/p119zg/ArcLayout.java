package com.didi.hawaii.p118ar.core.p119zg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.hawaii.p118ar.utils.ARAPollo;
import com.didi.hawaii.p118ar.utils.DisplayUtils;

/* renamed from: com.didi.hawaii.ar.core.zg.ArcLayout */
public class ArcLayout extends FrameLayout {
    public static boolean disableclippath = ARAPollo.getDisableClippath();

    /* renamed from: a */
    private Context f23092a;

    /* renamed from: b */
    private Paint f23093b = new Paint();

    /* renamed from: c */
    private int f23094c = 0;

    public ArcLayout(Context context) {
        super(context);
        this.f23092a = context;
    }

    public ArcLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23092a = context;
    }

    public ArcLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23092a = context;
    }

    public void setClipAreaColor(int i) {
        this.f23094c = i;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        if (!disableclippath) {
            if (Build.VERSION.SDK_INT < 18 && Build.VERSION.SDK_INT >= 11) {
                setLayerType(1, (Paint) null);
            }
            this.f23093b.setColor(-1);
            this.f23093b.setAntiAlias(true);
            float dip2px = (float) DisplayUtils.dip2px(this.f23092a, 20.0f);
            float dip2px2 = (float) DisplayUtils.dip2px(this.f23092a, 18.0f);
            float dip2px3 = (float) DisplayUtils.dip2px(this.f23092a, 2.0f);
            Path path = new Path();
            path.moveTo(0.0f, dip2px);
            float f = -dip2px;
            path.quadTo((float) (canvas.getWidth() / 2), f, (float) canvas.getWidth(), dip2px);
            this.f23093b.setStrokeWidth(2.0f);
            this.f23093b.setStyle(Paint.Style.STROKE);
            this.f23093b.setStrokeCap(Paint.Cap.SQUARE);
            canvas2.drawPath(path, this.f23093b);
            if (Build.VERSION.SDK_INT >= 21) {
                canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
            } else {
                canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, dip2px);
            path2.quadTo((float) (canvas.getWidth() / 2), f, (float) canvas.getWidth(), dip2px);
            path2.lineTo((float) canvas.getWidth(), (float) canvas.getHeight());
            path2.lineTo(0.0f, (float) canvas.getHeight());
            path2.close();
            try {
                canvas2.clipPath(path2);
            } catch (UnsupportedOperationException unused) {
            }
            int i = this.f23094c;
            if (i != 0) {
                canvas2.drawColor(i);
            }
            super.dispatchDraw(canvas);
            Path path3 = new Path();
            float f2 = dip2px + dip2px3;
            path3.moveTo(0.0f, f2);
            path3.quadTo((float) (canvas.getWidth() / 2), f + dip2px3, (float) canvas.getWidth(), f2);
            this.f23093b.setColor(-1);
            this.f23093b.setStrokeWidth(dip2px2);
            this.f23093b.setStyle(Paint.Style.STROKE);
            this.f23093b.setStrokeCap(Paint.Cap.SQUARE);
            canvas2.drawPath(path3, this.f23093b);
            canvas.restore();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
        } else {
            canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
        }
        int i2 = this.f23094c;
        if (i2 != 0) {
            canvas2.drawColor(i2);
        }
        super.dispatchDraw(canvas);
        Path path4 = new Path();
        path4.moveTo(0.0f, 0.0f);
        path4.lineTo((float) canvas.getWidth(), 0.0f);
        this.f23093b.setColor(-1);
        this.f23093b.setStrokeWidth((float) DisplayUtils.dip2px(this.f23092a, 24.0f));
        this.f23093b.setStyle(Paint.Style.STROKE);
        this.f23093b.setStrokeCap(Paint.Cap.SQUARE);
        canvas2.drawPath(path4, this.f23093b);
        canvas.restore();
    }
}
