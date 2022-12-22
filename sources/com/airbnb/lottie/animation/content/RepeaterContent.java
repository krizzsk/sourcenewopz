package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RepeaterContent implements DrawingContent, KeyPathElementContent, C1478a, C1479b, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a */
    private final Matrix f1289a = new Matrix();

    /* renamed from: b */
    private final Path f1290b = new Path();

    /* renamed from: c */
    private final LottieDrawable f1291c;

    /* renamed from: d */
    private final BaseLayer f1292d;

    /* renamed from: e */
    private final String f1293e;

    /* renamed from: f */
    private final boolean f1294f;

    /* renamed from: g */
    private final BaseKeyframeAnimation<Float, Float> f1295g;

    /* renamed from: h */
    private final BaseKeyframeAnimation<Float, Float> f1296h;

    /* renamed from: i */
    private final TransformKeyframeAnimation f1297i;

    /* renamed from: j */
    private ContentGroup f1298j;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.f1291c = lottieDrawable;
        this.f1292d = baseLayer;
        this.f1293e = repeater.getName();
        this.f1294f = repeater.isHidden();
        BaseKeyframeAnimation<Float, Float> createAnimation = repeater.getCopies().createAnimation();
        this.f1295g = createAnimation;
        baseLayer.addAnimation(createAnimation);
        this.f1295g.addUpdateListener(this);
        BaseKeyframeAnimation<Float, Float> createAnimation2 = repeater.getOffset().createAnimation();
        this.f1296h = createAnimation2;
        baseLayer.addAnimation(createAnimation2);
        this.f1296h.addUpdateListener(this);
        TransformKeyframeAnimation createAnimation3 = repeater.getTransform().createAnimation();
        this.f1297i = createAnimation3;
        createAnimation3.addAnimationsToLayer(baseLayer);
        this.f1297i.addListener(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void absorbContent(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> r9) {
        /*
            r8 = this;
            com.airbnb.lottie.animation.content.ContentGroup r0 = r8.f1298j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r9.previous()
            if (r0 == r8) goto L_0x0012
            goto L_0x0005
        L_0x0012:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0017:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r9.previous()
            r6.add(r0)
            r9.remove()
            goto L_0x0017
        L_0x0028:
            java.util.Collections.reverse(r6)
            com.airbnb.lottie.animation.content.ContentGroup r9 = new com.airbnb.lottie.animation.content.ContentGroup
            com.airbnb.lottie.LottieDrawable r2 = r8.f1291c
            com.airbnb.lottie.model.layer.BaseLayer r3 = r8.f1292d
            boolean r5 = r8.f1294f
            r7 = 0
            java.lang.String r4 = "Repeater"
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.f1298j = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.RepeaterContent.absorbContent(java.util.ListIterator):void");
    }

    public String getName() {
        return this.f1293e;
    }

    public void setContents(List<Content> list, List<Content> list2) {
        this.f1298j.setContents(list, list2);
    }

    public Path getPath() {
        Path path = this.f1298j.getPath();
        this.f1290b.reset();
        float floatValue = this.f1295g.getValue().floatValue();
        float floatValue2 = this.f1296h.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f1289a.set(this.f1297i.getMatrixForRepeater(((float) i) + floatValue2));
            this.f1290b.addPath(path, this.f1289a);
        }
        return this.f1290b;
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.f1295g.getValue().floatValue();
        float floatValue2 = this.f1296h.getValue().floatValue();
        float floatValue3 = this.f1297i.getStartOpacity().getValue().floatValue() / 100.0f;
        float floatValue4 = this.f1297i.getEndOpacity().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f1289a.set(matrix);
            float f = (float) i2;
            this.f1289a.preConcat(this.f1297i.getMatrixForRepeater(f + floatValue2));
            this.f1298j.draw(canvas, this.f1289a, (int) (((float) i) * MiscUtils.lerp(floatValue3, floatValue4, f / floatValue)));
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.f1298j.getBounds(rectF, matrix, z);
    }

    public void onValueChanged() {
        this.f1291c.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (!this.f1297i.applyValueCallback(t, lottieValueCallback)) {
            if (t == LottieProperty.REPEATER_COPIES) {
                this.f1295g.setValueCallback(lottieValueCallback);
            } else if (t == LottieProperty.REPEATER_OFFSET) {
                this.f1296h.setValueCallback(lottieValueCallback);
            }
        }
    }
}
