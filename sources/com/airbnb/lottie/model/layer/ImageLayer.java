package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

public class ImageLayer extends BaseLayer {

    /* renamed from: e */
    private final Paint f1527e = new LPaint(3);

    /* renamed from: f */
    private final Rect f1528f = new Rect();

    /* renamed from: g */
    private final Rect f1529g = new Rect();

    /* renamed from: h */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1530h;

    ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        Bitmap d = m1336d();
        if (d != null && !d.isRecycled()) {
            float dpScale = Utils.dpScale();
            this.f1527e.setAlpha(i);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1530h;
            if (baseKeyframeAnimation != null) {
                this.f1527e.setColorFilter(baseKeyframeAnimation.getValue());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f1528f.set(0, 0, d.getWidth(), d.getHeight());
            this.f1529g.set(0, 0, (int) (((float) d.getWidth()) * dpScale), (int) (((float) d.getHeight()) * dpScale));
            canvas.drawBitmap(d, this.f1528f, this.f1529g, this.f1527e);
            canvas.restore();
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        Bitmap d = m1336d();
        if (d != null) {
            rectF.set(0.0f, 0.0f, ((float) d.getWidth()) * Utils.dpScale(), ((float) d.getHeight()) * Utils.dpScale());
            this.f1498a.mapRect(rectF);
        }
    }

    /* renamed from: d */
    private Bitmap m1336d() {
        return this.f1499b.getImageAsset(this.f1500c.mo15440f());
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t != LottieProperty.COLOR_FILTER) {
            return;
        }
        if (lottieValueCallback == null) {
            this.f1530h = null;
        } else {
            this.f1530h = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        }
    }
}
