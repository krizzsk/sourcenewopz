package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a */
    private final String f1311a;

    /* renamed from: b */
    private final boolean f1312b;

    /* renamed from: c */
    private final List<BaseKeyframeAnimation.AnimationListener> f1313c = new ArrayList();

    /* renamed from: d */
    private final ShapeTrimPath.Type f1314d;

    /* renamed from: e */
    private final BaseKeyframeAnimation<?, Float> f1315e;

    /* renamed from: f */
    private final BaseKeyframeAnimation<?, Float> f1316f;

    /* renamed from: g */
    private final BaseKeyframeAnimation<?, Float> f1317g;

    public void setContents(List<Content> list, List<Content> list2) {
    }

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.f1311a = shapeTrimPath.getName();
        this.f1312b = shapeTrimPath.isHidden();
        this.f1314d = shapeTrimPath.getType();
        this.f1315e = shapeTrimPath.getStart().createAnimation();
        this.f1316f = shapeTrimPath.getEnd().createAnimation();
        this.f1317g = shapeTrimPath.getOffset().createAnimation();
        baseLayer.addAnimation(this.f1315e);
        baseLayer.addAnimation(this.f1316f);
        baseLayer.addAnimation(this.f1317g);
        this.f1315e.addUpdateListener(this);
        this.f1316f.addUpdateListener(this);
        this.f1317g.addUpdateListener(this);
    }

    public void onValueChanged() {
        for (int i = 0; i < this.f1313c.size(); i++) {
            this.f1313c.get(i).onValueChanged();
        }
    }

    public String getName() {
        return this.f1311a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo15219a(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.f1313c.add(animationListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ShapeTrimPath.Type mo15218a() {
        return this.f1314d;
    }

    public BaseKeyframeAnimation<?, Float> getStart() {
        return this.f1315e;
    }

    public BaseKeyframeAnimation<?, Float> getEnd() {
        return this.f1316f;
    }

    public BaseKeyframeAnimation<?, Float> getOffset() {
        return this.f1317g;
    }

    public boolean isHidden() {
        return this.f1312b;
    }
}
