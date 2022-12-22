package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class ShapeContent implements C1479b, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a */
    private final Path f1299a = new Path();

    /* renamed from: b */
    private final String f1300b;

    /* renamed from: c */
    private final boolean f1301c;

    /* renamed from: d */
    private final LottieDrawable f1302d;

    /* renamed from: e */
    private final BaseKeyframeAnimation<?, Path> f1303e;

    /* renamed from: f */
    private boolean f1304f;

    /* renamed from: g */
    private CompoundTrimPathContent f1305g = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        this.f1300b = shapePath.getName();
        this.f1301c = shapePath.isHidden();
        this.f1302d = lottieDrawable;
        BaseKeyframeAnimation<ShapeData, Path> createAnimation = shapePath.getShapePath().createAnimation();
        this.f1303e = createAnimation;
        baseLayer.addAnimation(createAnimation);
        this.f1303e.addUpdateListener(this);
    }

    public void onValueChanged() {
        m1282a();
    }

    /* renamed from: a */
    private void m1282a() {
        this.f1304f = false;
        this.f1302d.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.mo15218a() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f1305g.mo15211a(trimPathContent);
                    trimPathContent.mo15219a(this);
                }
            }
        }
    }

    public Path getPath() {
        if (this.f1304f) {
            return this.f1299a;
        }
        this.f1299a.reset();
        if (this.f1301c) {
            this.f1304f = true;
            return this.f1299a;
        }
        this.f1299a.set(this.f1303e.getValue());
        this.f1299a.setFillType(Path.FillType.EVEN_ODD);
        this.f1305g.apply(this.f1299a);
        this.f1304f = true;
        return this.f1299a;
    }

    public String getName() {
        return this.f1300b;
    }
}
