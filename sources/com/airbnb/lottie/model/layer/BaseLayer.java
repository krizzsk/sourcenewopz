package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.C1429L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* renamed from: e */
    private static final int f1493e = 2;

    /* renamed from: f */
    private static final int f1494f = 16;

    /* renamed from: g */
    private static final int f1495g = 1;

    /* renamed from: h */
    private static final int f1496h = 19;

    /* renamed from: A */
    private boolean f1497A = true;

    /* renamed from: a */
    final Matrix f1498a = new Matrix();

    /* renamed from: b */
    final LottieDrawable f1499b;

    /* renamed from: c */
    final Layer f1500c;

    /* renamed from: d */
    final TransformKeyframeAnimation f1501d;

    /* renamed from: i */
    private final Path f1502i = new Path();

    /* renamed from: j */
    private final Matrix f1503j = new Matrix();

    /* renamed from: k */
    private final Paint f1504k = new LPaint(1);

    /* renamed from: l */
    private final Paint f1505l = new LPaint(1, PorterDuff.Mode.DST_IN);

    /* renamed from: m */
    private final Paint f1506m = new LPaint(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: n */
    private final Paint f1507n = new LPaint(1);

    /* renamed from: o */
    private final Paint f1508o = new LPaint(PorterDuff.Mode.CLEAR);

    /* renamed from: p */
    private final RectF f1509p = new RectF();

    /* renamed from: q */
    private final RectF f1510q = new RectF();

    /* renamed from: r */
    private final RectF f1511r = new RectF();

    /* renamed from: s */
    private final RectF f1512s = new RectF();

    /* renamed from: t */
    private final String f1513t;

    /* renamed from: u */
    private MaskKeyframeAnimation f1514u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public FloatKeyframeAnimation f1515v;

    /* renamed from: w */
    private BaseLayer f1516w;

    /* renamed from: x */
    private BaseLayer f1517x;

    /* renamed from: y */
    private List<BaseLayer> f1518y;

    /* renamed from: z */
    private final List<BaseKeyframeAnimation<?, ?>> f1519z = new ArrayList();

    /* access modifiers changed from: package-private */
    public abstract void drawLayer(Canvas canvas, Matrix matrix, int i);

    /* access modifiers changed from: package-private */
    public void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
    }

    public void setContents(List<Content> list, List<Content> list2) {
    }

    /* renamed from: a */
    static BaseLayer m1312a(Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (C14902.$SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[layer.getLayerType().ordinal()]) {
            case 1:
                return new ShapeLayer(lottieDrawable, layer);
            case 2:
                return new CompositionLayer(lottieDrawable, layer, lottieComposition.getPrecomps(layer.mo15440f()), lottieComposition);
            case 3:
                return new SolidLayer(lottieDrawable, layer);
            case 4:
                return new ImageLayer(lottieDrawable, layer);
            case 5:
                return new NullLayer(lottieDrawable, layer);
            case 6:
                return new TextLayer(lottieDrawable, layer);
            default:
                Logger.warning("Unknown layer type " + layer.getLayerType());
                return null;
        }
    }

    BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        this.f1499b = lottieDrawable;
        this.f1500c = layer;
        this.f1513t = layer.mo15439e() + "#draw";
        if (layer.mo15447j() == Layer.MatteType.INVERT) {
            this.f1507n.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f1507n.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        TransformKeyframeAnimation createAnimation = layer.mo15450m().createAnimation();
        this.f1501d = createAnimation;
        createAnimation.addListener(this);
        if (layer.mo15445i() != null && !layer.mo15445i().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.mo15445i());
            this.f1514u = maskKeyframeAnimation;
            for (BaseKeyframeAnimation<ShapeData, Path> addUpdateListener : maskKeyframeAnimation.getMaskAnimations()) {
                addUpdateListener.addUpdateListener(this);
            }
            for (BaseKeyframeAnimation next : this.f1514u.getOpacityAnimations()) {
                addAnimation(next);
                next.addUpdateListener(this);
            }
        }
        m1324d();
    }

    public void onValueChanged() {
        m1326e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Layer mo15423a() {
        return this.f1500c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo15424a(BaseLayer baseLayer) {
        this.f1516w = baseLayer;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo15427b() {
        return this.f1516w != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo15426b(BaseLayer baseLayer) {
        this.f1517x = baseLayer;
    }

    /* renamed from: d */
    private void m1324d() {
        boolean z = true;
        if (!this.f1500c.mo15438d().isEmpty()) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.f1500c.mo15438d());
            this.f1515v = floatKeyframeAnimation;
            floatKeyframeAnimation.setIsDiscrete();
            this.f1515v.addUpdateListener(new BaseKeyframeAnimation.AnimationListener() {
                public void onValueChanged() {
                    BaseLayer baseLayer = BaseLayer.this;
                    baseLayer.m1319a(baseLayer.f1515v.getFloatValue() == 1.0f);
                }
            });
            if (((Float) this.f1515v.getValue()).floatValue() != 1.0f) {
                z = false;
            }
            m1319a(z);
            addAnimation(this.f1515v);
            return;
        }
        m1319a(true);
    }

    /* renamed from: e */
    private void m1326e() {
        this.f1499b.invalidateSelf();
    }

    public void addAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation != null) {
            this.f1519z.add(baseKeyframeAnimation);
        }
    }

    public void removeAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.f1519z.remove(baseKeyframeAnimation);
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.f1509p.set(0.0f, 0.0f, 0.0f, 0.0f);
        m1330g();
        this.f1498a.set(matrix);
        if (z) {
            List<BaseLayer> list = this.f1518y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f1498a.preConcat(this.f1518y.get(size).f1501d.getMatrix());
                }
            } else {
                BaseLayer baseLayer = this.f1517x;
                if (baseLayer != null) {
                    this.f1498a.preConcat(baseLayer.f1501d.getMatrix());
                }
            }
        }
        this.f1498a.preConcat(this.f1501d.getMatrix());
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        C1429L.beginSection(this.f1513t);
        if (!this.f1497A || this.f1500c.isHidden()) {
            C1429L.endSection(this.f1513t);
            return;
        }
        m1330g();
        C1429L.beginSection("Layer#parentMatrix");
        this.f1503j.reset();
        this.f1503j.set(matrix);
        for (int size = this.f1518y.size() - 1; size >= 0; size--) {
            this.f1503j.preConcat(this.f1518y.get(size).f1501d.getMatrix());
        }
        C1429L.endSection("Layer#parentMatrix");
        int intValue = (int) ((((((float) i) / 255.0f) * ((float) (this.f1501d.getOpacity() == null ? 100 : this.f1501d.getOpacity().getValue().intValue()))) / 100.0f) * 255.0f);
        if (mo15427b() || mo15428c()) {
            C1429L.beginSection("Layer#computeBounds");
            getBounds(this.f1509p, this.f1503j, false);
            m1321b(this.f1509p, matrix);
            this.f1503j.preConcat(this.f1501d.getMatrix());
            m1317a(this.f1509p, this.f1503j);
            if (!this.f1509p.intersect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight())) {
                this.f1509p.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            C1429L.endSection("Layer#computeBounds");
            if (!this.f1509p.isEmpty()) {
                C1429L.beginSection("Layer#saveLayer");
                this.f1504k.setAlpha(255);
                Utils.saveLayerCompat(canvas, this.f1509p, this.f1504k);
                C1429L.endSection("Layer#saveLayer");
                m1314a(canvas);
                C1429L.beginSection("Layer#drawLayer");
                drawLayer(canvas, this.f1503j, intValue);
                C1429L.endSection("Layer#drawLayer");
                if (mo15428c()) {
                    m1315a(canvas, this.f1503j);
                }
                if (mo15427b()) {
                    C1429L.beginSection("Layer#drawMatte");
                    C1429L.beginSection("Layer#saveLayer");
                    Utils.saveLayerCompat(canvas, this.f1509p, this.f1507n, 19);
                    C1429L.endSection("Layer#saveLayer");
                    m1314a(canvas);
                    this.f1516w.draw(canvas, matrix, intValue);
                    C1429L.beginSection("Layer#restoreLayer");
                    canvas.restore();
                    C1429L.endSection("Layer#restoreLayer");
                    C1429L.endSection("Layer#drawMatte");
                }
                C1429L.beginSection("Layer#restoreLayer");
                canvas.restore();
                C1429L.endSection("Layer#restoreLayer");
            }
            m1313a(C1429L.endSection(this.f1513t));
            return;
        }
        this.f1503j.preConcat(this.f1501d.getMatrix());
        C1429L.beginSection("Layer#drawLayer");
        drawLayer(canvas, this.f1503j, intValue);
        C1429L.endSection("Layer#drawLayer");
        m1313a(C1429L.endSection(this.f1513t));
    }

    /* renamed from: a */
    private void m1313a(float f) {
        this.f1499b.getComposition().getPerformanceTracker().recordRenderTime(this.f1500c.mo15439e(), f);
    }

    /* renamed from: a */
    private void m1314a(Canvas canvas) {
        C1429L.beginSection("Layer#clearLayer");
        canvas.drawRect(this.f1509p.left - 1.0f, this.f1509p.top - 1.0f, this.f1509p.right + 1.0f, this.f1509p.bottom + 1.0f, this.f1508o);
        C1429L.endSection("Layer#clearLayer");
    }

    /* renamed from: a */
    private void m1317a(RectF rectF, Matrix matrix) {
        this.f1510q.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (mo15428c()) {
            int size = this.f1514u.getMasks().size();
            int i = 0;
            while (i < size) {
                Mask mask = this.f1514u.getMasks().get(i);
                this.f1502i.set((Path) this.f1514u.getMaskAnimations().get(i).getValue());
                this.f1502i.transform(matrix);
                int i2 = C14902.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask.getMaskMode().ordinal()];
                if (i2 != 1 && i2 != 2) {
                    if ((i2 != 3 && i2 != 4) || !mask.isInverted()) {
                        this.f1502i.computeBounds(this.f1512s, false);
                        if (i == 0) {
                            this.f1510q.set(this.f1512s);
                        } else {
                            RectF rectF2 = this.f1510q;
                            rectF2.set(Math.min(rectF2.left, this.f1512s.left), Math.min(this.f1510q.top, this.f1512s.top), Math.max(this.f1510q.right, this.f1512s.right), Math.max(this.f1510q.bottom, this.f1512s.bottom));
                        }
                        i++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.f1510q)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$2 */
    static /* synthetic */ class C14902 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            /*
                com.airbnb.lottie.model.content.Mask$MaskMode[] r0 = com.airbnb.lottie.model.content.Mask.MaskMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode = r0
                r1 = 1
                com.airbnb.lottie.model.content.Mask$MaskMode r2 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.Mask$MaskMode r3 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.Mask$MaskMode r4 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.Mask$MaskMode r5 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.airbnb.lottie.model.layer.Layer$LayerType[] r4 = com.airbnb.lottie.model.layer.Layer.LayerType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType = r4
                com.airbnb.lottie.model.layer.Layer$LayerType r5 = com.airbnb.lottie.model.layer.Layer.LayerType.SHAPE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x004e }
                com.airbnb.lottie.model.layer.Layer$LayerType r4 = com.airbnb.lottie.model.layer.Layer.LayerType.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.SOLID     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x006d }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.NULL     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.TEXT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.BaseLayer.C14902.<clinit>():void");
        }
    }

    /* renamed from: b */
    private void m1321b(RectF rectF, Matrix matrix) {
        if (mo15427b() && this.f1500c.mo15447j() != Layer.MatteType.INVERT) {
            this.f1511r.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f1516w.getBounds(this.f1511r, matrix, true);
            if (!rectF.intersect(this.f1511r)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m1315a(Canvas canvas, Matrix matrix) {
        C1429L.beginSection("Layer#saveLayer");
        Utils.saveLayerCompat(canvas, this.f1509p, this.f1505l, 19);
        if (Build.VERSION.SDK_INT < 28) {
            m1314a(canvas);
        }
        C1429L.endSection("Layer#saveLayer");
        for (int i = 0; i < this.f1514u.getMasks().size(); i++) {
            Mask mask = this.f1514u.getMasks().get(i);
            BaseKeyframeAnimation baseKeyframeAnimation = this.f1514u.getMaskAnimations().get(i);
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.f1514u.getOpacityAnimations().get(i);
            int i2 = C14902.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask.getMaskMode().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.f1504k.setColor(-16777216);
                        this.f1504k.setAlpha(255);
                        canvas.drawRect(this.f1509p, this.f1504k);
                    }
                    if (mask.isInverted()) {
                        m1325d(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        m1323c(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (mask.isInverted()) {
                            m1320b(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        } else {
                            m1316a(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        }
                    }
                } else if (mask.isInverted()) {
                    m1328f(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    m1327e(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (m1329f()) {
                this.f1504k.setAlpha(255);
                canvas.drawRect(this.f1509p, this.f1504k);
            }
        }
        C1429L.beginSection("Layer#restoreLayer");
        canvas.restore();
        C1429L.endSection("Layer#restoreLayer");
    }

    /* renamed from: f */
    private boolean m1329f() {
        if (this.f1514u.getMaskAnimations().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f1514u.getMasks().size(); i++) {
            if (this.f1514u.getMasks().get(i).getMaskMode() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m1316a(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.f1502i.set(baseKeyframeAnimation.getValue());
        this.f1502i.transform(matrix);
        this.f1504k.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        canvas.drawPath(this.f1502i, this.f1504k);
    }

    /* renamed from: b */
    private void m1320b(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.f1509p, this.f1504k);
        canvas.drawRect(this.f1509p, this.f1504k);
        this.f1502i.set(baseKeyframeAnimation.getValue());
        this.f1502i.transform(matrix);
        this.f1504k.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        canvas.drawPath(this.f1502i, this.f1506m);
        canvas.restore();
    }

    /* renamed from: c */
    private void m1323c(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.f1502i.set(baseKeyframeAnimation.getValue());
        this.f1502i.transform(matrix);
        canvas.drawPath(this.f1502i, this.f1506m);
    }

    /* renamed from: d */
    private void m1325d(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.f1509p, this.f1506m);
        canvas.drawRect(this.f1509p, this.f1504k);
        this.f1506m.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        this.f1502i.set(baseKeyframeAnimation.getValue());
        this.f1502i.transform(matrix);
        canvas.drawPath(this.f1502i, this.f1506m);
        canvas.restore();
    }

    /* renamed from: e */
    private void m1327e(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.f1509p, this.f1505l);
        this.f1502i.set(baseKeyframeAnimation.getValue());
        this.f1502i.transform(matrix);
        this.f1504k.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        canvas.drawPath(this.f1502i, this.f1504k);
        canvas.restore();
    }

    /* renamed from: f */
    private void m1328f(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.f1509p, this.f1505l);
        canvas.drawRect(this.f1509p, this.f1504k);
        this.f1506m.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        this.f1502i.set(baseKeyframeAnimation.getValue());
        this.f1502i.transform(matrix);
        canvas.drawPath(this.f1502i, this.f1506m);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo15428c() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.f1514u;
        return maskKeyframeAnimation != null && !maskKeyframeAnimation.getMaskAnimations().isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1319a(boolean z) {
        if (z != this.f1497A) {
            this.f1497A = z;
            m1326e();
        }
    }

    /* access modifiers changed from: package-private */
    public void setProgress(float f) {
        this.f1501d.setProgress(f);
        if (this.f1514u != null) {
            for (int i = 0; i < this.f1514u.getMaskAnimations().size(); i++) {
                this.f1514u.getMaskAnimations().get(i).setProgress(f);
            }
        }
        if (this.f1500c.mo15436b() != 0.0f) {
            f /= this.f1500c.mo15436b();
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f1515v;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f / this.f1500c.mo15436b());
        }
        BaseLayer baseLayer = this.f1516w;
        if (baseLayer != null) {
            this.f1516w.setProgress(baseLayer.f1500c.mo15436b() * f);
        }
        for (int i2 = 0; i2 < this.f1519z.size(); i2++) {
            this.f1519z.get(i2).setProgress(f);
        }
    }

    /* renamed from: g */
    private void m1330g() {
        if (this.f1518y == null) {
            if (this.f1517x == null) {
                this.f1518y = Collections.emptyList();
                return;
            }
            this.f1518y = new ArrayList();
            for (BaseLayer baseLayer = this.f1517x; baseLayer != null; baseLayer = baseLayer.f1517x) {
                this.f1518y.add(baseLayer);
            }
        }
    }

    public String getName() {
        return this.f1500c.mo15439e();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.matches(getName(), i)) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.addKey(getName());
                if (keyPath.fullyResolvesTo(getName(), i)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(getName(), i)) {
                resolveChildKeyPath(keyPath, i + keyPath.incrementDepthBy(getName(), i), list, keyPath2);
            }
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        this.f1501d.applyValueCallback(t, lottieValueCallback);
    }
}
