package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

public class SolidLayer extends BaseLayer {

    /* renamed from: e */
    private final RectF f1554e = new RectF();

    /* renamed from: f */
    private final Paint f1555f = new LPaint();

    /* renamed from: g */
    private final float[] f1556g = new float[8];

    /* renamed from: h */
    private final Path f1557h = new Path();

    /* renamed from: i */
    private final Layer f1558i;

    /* renamed from: j */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1559j;

    SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.f1558i = layer;
        this.f1555f.setAlpha(0);
        this.f1555f.setStyle(Paint.Style.FILL);
        this.f1555f.setColor(layer.mo15451n());
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.f1558i.mo15451n());
        if (alpha != 0) {
            int intValue = (int) ((((float) i) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) (this.f1501d.getOpacity() == null ? 100 : this.f1501d.getOpacity().getValue().intValue()))) / 100.0f) * 255.0f);
            this.f1555f.setAlpha(intValue);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1559j;
            if (baseKeyframeAnimation != null) {
                this.f1555f.setColorFilter(baseKeyframeAnimation.getValue());
            }
            if (intValue > 0) {
                float[] fArr = this.f1556g;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.f1558i.mo15453p();
                float[] fArr2 = this.f1556g;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.f1558i.mo15453p();
                this.f1556g[5] = (float) this.f1558i.mo15452o();
                float[] fArr3 = this.f1556g;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.f1558i.mo15452o();
                matrix.mapPoints(this.f1556g);
                this.f1557h.reset();
                Path path = this.f1557h;
                float[] fArr4 = this.f1556g;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.f1557h;
                float[] fArr5 = this.f1556g;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.f1557h;
                float[] fArr6 = this.f1556g;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.f1557h;
                float[] fArr7 = this.f1556g;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.f1557h;
                float[] fArr8 = this.f1556g;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.f1557h.close();
                canvas.drawPath(this.f1557h, this.f1555f);
            }
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        this.f1554e.set(0.0f, 0.0f, (float) this.f1558i.mo15453p(), (float) this.f1558i.mo15452o());
        this.f1498a.mapRect(this.f1554e);
        rectF.set(this.f1554e);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t != LottieProperty.COLOR_FILTER) {
            return;
        }
        if (lottieValueCallback == null) {
            this.f1559j = null;
        } else {
            this.f1559j = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        }
    }
}
