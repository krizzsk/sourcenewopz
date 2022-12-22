package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ContentGroup implements DrawingContent, C1479b, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* renamed from: a */
    private Paint f1195a;

    /* renamed from: b */
    private RectF f1196b;

    /* renamed from: c */
    private final Matrix f1197c;

    /* renamed from: d */
    private final Path f1198d;

    /* renamed from: e */
    private final RectF f1199e;

    /* renamed from: f */
    private final String f1200f;

    /* renamed from: g */
    private final boolean f1201g;

    /* renamed from: h */
    private final List<Content> f1202h;

    /* renamed from: i */
    private final LottieDrawable f1203i;

    /* renamed from: j */
    private List<C1479b> f1204j;

    /* renamed from: k */
    private TransformKeyframeAnimation f1205k;

    /* renamed from: a */
    private static List<Content> m1263a(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i).toContent(lottieDrawable, baseLayer);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static AnimatableTransform m1262a(List<ContentModel> list) {
        for (int i = 0; i < list.size(); i++) {
            ContentModel contentModel = list.get(i);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.getName(), shapeGroup.isHidden(), m1263a(lottieDrawable, baseLayer, shapeGroup.getItems()), m1262a(shapeGroup.getItems()));
    }

    ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z, List<Content> list, AnimatableTransform animatableTransform) {
        this.f1195a = new LPaint();
        this.f1196b = new RectF();
        this.f1197c = new Matrix();
        this.f1198d = new Path();
        this.f1199e = new RectF();
        this.f1200f = str;
        this.f1203i = lottieDrawable;
        this.f1201g = z;
        this.f1202h = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation createAnimation = animatableTransform.createAnimation();
            this.f1205k = createAnimation;
            createAnimation.addAnimationsToLayer(baseLayer);
            this.f1205k.addListener(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof C1478a) {
                arrayList.add((C1478a) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((C1478a) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
        }
    }

    public void onValueChanged() {
        this.f1203i.invalidateSelf();
    }

    public String getName() {
        return this.f1200f;
    }

    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f1202h.size());
        arrayList.addAll(list);
        for (int size = this.f1202h.size() - 1; size >= 0; size--) {
            Content content = this.f1202h.get(size);
            content.setContents(arrayList, this.f1202h.subList(0, size));
            arrayList.add(content);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C1479b> mo15214a() {
        if (this.f1204j == null) {
            this.f1204j = new ArrayList();
            for (int i = 0; i < this.f1202h.size(); i++) {
                Content content = this.f1202h.get(i);
                if (content instanceof C1479b) {
                    this.f1204j.add((C1479b) content);
                }
            }
        }
        return this.f1204j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Matrix mo15215b() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f1205k;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.getMatrix();
        }
        this.f1197c.reset();
        return this.f1197c;
    }

    public Path getPath() {
        this.f1197c.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.f1205k;
        if (transformKeyframeAnimation != null) {
            this.f1197c.set(transformKeyframeAnimation.getMatrix());
        }
        this.f1198d.reset();
        if (this.f1201g) {
            return this.f1198d;
        }
        for (int size = this.f1202h.size() - 1; size >= 0; size--) {
            Content content = this.f1202h.get(size);
            if (content instanceof C1479b) {
                this.f1198d.addPath(((C1479b) content).getPath(), this.f1197c);
            }
        }
        return this.f1198d;
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (!this.f1201g) {
            this.f1197c.set(matrix);
            TransformKeyframeAnimation transformKeyframeAnimation = this.f1205k;
            if (transformKeyframeAnimation != null) {
                this.f1197c.preConcat(transformKeyframeAnimation.getMatrix());
                i = (int) ((((((float) (this.f1205k.getOpacity() == null ? 100 : this.f1205k.getOpacity().getValue().intValue())) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
            }
            boolean z = this.f1203i.isApplyingOpacityToLayersEnabled() && m1264c() && i != 255;
            if (z) {
                this.f1196b.set(0.0f, 0.0f, 0.0f, 0.0f);
                getBounds(this.f1196b, this.f1197c, true);
                this.f1195a.setAlpha(i);
                Utils.saveLayerCompat(canvas, this.f1196b, this.f1195a);
            }
            if (z) {
                i = 255;
            }
            for (int size = this.f1202h.size() - 1; size >= 0; size--) {
                Content content = this.f1202h.get(size);
                if (content instanceof DrawingContent) {
                    ((DrawingContent) content).draw(canvas, this.f1197c, i);
                }
            }
            if (z) {
                canvas.restore();
            }
        }
    }

    /* renamed from: c */
    private boolean m1264c() {
        int i = 0;
        for (int i2 = 0; i2 < this.f1202h.size(); i2++) {
            if ((this.f1202h.get(i2) instanceof DrawingContent) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.f1197c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f1205k;
        if (transformKeyframeAnimation != null) {
            this.f1197c.preConcat(transformKeyframeAnimation.getMatrix());
        }
        this.f1199e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f1202h.size() - 1; size >= 0; size--) {
            Content content = this.f1202h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.f1199e, this.f1197c, z);
                rectF.union(this.f1199e);
            }
        }
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
                int incrementDepthBy = i + keyPath.incrementDepthBy(getName(), i);
                for (int i2 = 0; i2 < this.f1202h.size(); i2++) {
                    Content content = this.f1202h.get(i2);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).resolveKeyPath(keyPath, incrementDepthBy, list, keyPath2);
                    }
                }
            }
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f1205k;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(t, lottieValueCallback);
        }
    }
}
