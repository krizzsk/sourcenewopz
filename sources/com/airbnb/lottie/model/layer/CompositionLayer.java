package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.C1429L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class CompositionLayer extends BaseLayer {

    /* renamed from: e */
    private BaseKeyframeAnimation<Float, Float> f1520e;

    /* renamed from: f */
    private final List<BaseLayer> f1521f = new ArrayList();

    /* renamed from: g */
    private final RectF f1522g = new RectF();

    /* renamed from: h */
    private final RectF f1523h = new RectF();

    /* renamed from: i */
    private Paint f1524i = new Paint();

    /* renamed from: j */
    private Boolean f1525j;

    /* renamed from: k */
    private Boolean f1526k;

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i;
        BaseLayer baseLayer;
        AnimatableFloatValue s = layer.mo15456s();
        if (s != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = s.createAnimation();
            this.f1520e = createAnimation;
            addAnimation(createAnimation);
            this.f1520e.addUpdateListener(this);
        } else {
            this.f1520e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer a = BaseLayer.m1312a(layer2, lottieDrawable, lottieComposition);
            if (a != null) {
                longSparseArray.put(a.mo15423a().getId(), a);
                if (baseLayer2 != null) {
                    baseLayer2.mo15424a(a);
                    baseLayer2 = null;
                } else {
                    this.f1521f.add(0, a);
                    int i2 = C14911.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[layer2.mo15447j().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        baseLayer2 = a;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i));
            if (!(baseLayer3 == null || (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.mo15423a().mo15448k())) == null)) {
                baseLayer3.mo15426b(baseLayer);
            }
        }
    }

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1 */
    static /* synthetic */ class C14911 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.ADD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.INVERT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.CompositionLayer.C14911.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        C1429L.beginSection("CompositionLayer#draw");
        this.f1523h.set(0.0f, 0.0f, (float) this.f1500c.mo15441g(), (float) this.f1500c.mo15444h());
        matrix.mapRect(this.f1523h);
        boolean z = this.f1499b.isApplyingOpacityToLayersEnabled() && this.f1521f.size() > 1 && i != 255;
        if (z) {
            this.f1524i.setAlpha(i);
            Utils.saveLayerCompat(canvas, this.f1523h, this.f1524i);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.f1521f.size() - 1; size >= 0; size--) {
            if (!this.f1523h.isEmpty() ? canvas.clipRect(this.f1523h) : true) {
                this.f1521f.get(size).draw(canvas, matrix, i);
            }
        }
        canvas.restore();
        C1429L.endSection("CompositionLayer#draw");
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        for (int size = this.f1521f.size() - 1; size >= 0; size--) {
            this.f1522g.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f1521f.get(size).getBounds(this.f1522g, this.f1498a, true);
            rectF.union(this.f1522g);
        }
    }

    public void setProgress(float f) {
        super.setProgress(f);
        if (this.f1520e != null) {
            f = ((this.f1520e.getValue().floatValue() * this.f1500c.mo15435a().getFrameRate()) - this.f1500c.mo15435a().getStartFrame()) / (this.f1499b.getComposition().getDurationFrames() + 0.01f);
        }
        if (this.f1520e == null) {
            f -= this.f1500c.mo15437c();
        }
        if (this.f1500c.mo15436b() != 0.0f) {
            f /= this.f1500c.mo15436b();
        }
        for (int size = this.f1521f.size() - 1; size >= 0; size--) {
            this.f1521f.get(size).setProgress(f);
        }
    }

    public boolean hasMasks() {
        if (this.f1526k == null) {
            for (int size = this.f1521f.size() - 1; size >= 0; size--) {
                BaseLayer baseLayer = this.f1521f.get(size);
                if (baseLayer instanceof ShapeLayer) {
                    if (baseLayer.mo15428c()) {
                        this.f1526k = true;
                        return true;
                    }
                } else if ((baseLayer instanceof CompositionLayer) && ((CompositionLayer) baseLayer).hasMasks()) {
                    this.f1526k = true;
                    return true;
                }
            }
            this.f1526k = false;
        }
        return this.f1526k.booleanValue();
    }

    public boolean hasMatte() {
        if (this.f1525j == null) {
            if (mo15427b()) {
                this.f1525j = true;
                return true;
            }
            for (int size = this.f1521f.size() - 1; size >= 0; size--) {
                if (this.f1521f.get(size).mo15427b()) {
                    this.f1525j = true;
                    return true;
                }
            }
            this.f1525j = false;
        }
        return this.f1525j.booleanValue();
    }

    /* access modifiers changed from: protected */
    public void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        for (int i2 = 0; i2 < this.f1521f.size(); i2++) {
            this.f1521f.get(i2).resolveKeyPath(keyPath, i, list, keyPath2);
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t != LottieProperty.TIME_REMAP) {
            return;
        }
        if (lottieValueCallback == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f1520e;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.setValueCallback((LottieValueCallback<Float>) null);
                return;
            }
            return;
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        this.f1520e = valueCallbackKeyframeAnimation;
        valueCallbackKeyframeAnimation.addUpdateListener(this);
        addAnimation(this.f1520e);
    }
}
