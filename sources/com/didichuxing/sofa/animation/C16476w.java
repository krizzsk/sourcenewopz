package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import com.didichuxing.sofa.animation.Animator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sofa.animation.w */
/* compiled from: ViewAnimator */
class C16476w extends Animator {

    /* renamed from: a */
    private static final String f49136a = "ViewAnimator";

    /* renamed from: b */
    private AnimatorSet f49137b;

    /* renamed from: c */
    private C16472s f49138c;

    /* renamed from: d */
    private List<C16472s> f49139d = new ArrayList();

    /* renamed from: e */
    private List<C16472s> f49140e = new ArrayList();

    /* renamed from: f */
    private List<C16472s> f49141f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f49142g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f49143h = false;

    C16476w() {
    }

    /* renamed from: a */
    private PropertyValuesHolder[] m35406a(List<C16456b> list) {
        int size = list.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size];
        for (int i = 0; i < size; i++) {
            propertyValuesHolderArr[i] = PropertyValuesHolder.ofFloat(list.get(i).mo121102a(), list.get(i).mo121103b());
        }
        return propertyValuesHolderArr;
    }

    /* renamed from: e */
    private Animator m35411e(C16472s sVar) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(sVar.mo121124b(), m35406a(sVar.mo121119a()));
        ofPropertyValuesHolder.setDuration((long) sVar.mo121129d());
        ofPropertyValuesHolder.setInterpolator(sVar.mo121135g());
        ofPropertyValuesHolder.setRepeatCount(sVar.mo121133f());
        ofPropertyValuesHolder.setRepeatMode(sVar.mo121131e());
        ofPropertyValuesHolder.setStartDelay(sVar.mo121137h());
        TypeEvaluator i = sVar.mo121139i();
        if (sVar.mo121139i() instanceof C16462h) {
            ((C16462h) sVar.mo121139i()).mo121113a((float) sVar.mo121129d());
        }
        ofPropertyValuesHolder.setEvaluator(i);
        ofPropertyValuesHolder.addListener(new ViewAnimator$1(this, sVar));
        if (sVar.mo121105c() != null) {
            ofPropertyValuesHolder.addListener(new C16458d(this, sVar, sVar.mo121105c()));
        }
        return ofPropertyValuesHolder;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m35410d() {
        this.f49137b = new AnimatorSet();
        m35404a("createAnimation mPlayViewBuilder: " + this.f49138c + " mWithViewBuilders: " + this.f49139d + " mAfterViewBuilders: " + this.f49141f);
        C16472s sVar = this.f49138c;
        if (sVar != null) {
            AnimatorSet.Builder play = this.f49137b.play(m35411e(sVar));
            if (!this.f49139d.isEmpty()) {
                for (C16472s e : this.f49139d) {
                    play.with(m35411e(e));
                }
            }
            if (!this.f49140e.isEmpty()) {
                for (C16472s e2 : this.f49140e) {
                    play.before(m35411e(e2));
                }
            }
            if (!this.f49141f.isEmpty()) {
                for (C16472s e3 : this.f49141f) {
                    play.after(m35411e(e3));
                }
            }
        }
        if (mo121105c() != null) {
            this.f49137b.addListener(new C16460f(this, mo121105c()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m35412e() {
        LoggerUtil.m35314d(f49136a, "startAnimation mAnimatorSet: " + this.f49137b);
        if (this.f49137b.isStarted()) {
            this.f49137b.end();
        }
        this.f49137b.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35404a(String str) {
        LoggerUtil.m35314d(f49136a, str);
    }

    /* renamed from: a */
    public void mo121015a(C16472s sVar) {
        this.f49138c = sVar;
    }

    /* renamed from: b */
    public void mo121017b(C16472s sVar) {
        this.f49139d.add(sVar);
    }

    /* renamed from: c */
    public void mo121019c(C16472s sVar) {
        this.f49140e.add(sVar);
    }

    /* renamed from: d */
    public void mo121020d(C16472s sVar) {
        this.f49141f.add(sVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121013a() {
        if (this.f49137b != null) {
            m35404a("Please do not build animator repeatedly!");
        } else {
            mo121014a((Animator.PrepareAnimationCallback) new ViewAnimator$2(this));
        }
    }

    public Animator start() {
        m35404a("start mPrepared: " + this.f49142g);
        if (this.f49142g) {
            m35412e();
        } else {
            this.f49143h = true;
        }
        return this;
    }

    public void stop() {
        StringBuilder sb = new StringBuilder();
        sb.append("stop mAnimatorSet: ");
        sb.append(this.f49137b);
        sb.append(" isStarted: ");
        AnimatorSet animatorSet = this.f49137b;
        boolean z = true;
        sb.append(animatorSet != null && animatorSet.isStarted());
        sb.append(" isRunning: ");
        AnimatorSet animatorSet2 = this.f49137b;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            z = false;
        }
        sb.append(z);
        m35404a(sb.toString());
        AnimatorSet animatorSet3 = this.f49137b;
        if (animatorSet3 == null) {
            LoggerUtil.m35315e(f49136a, "Stop: this animator has not built yet!");
        } else {
            animatorSet3.end();
        }
    }

    public boolean isRunning() {
        AnimatorSet animatorSet = this.f49137b;
        return animatorSet != null && animatorSet.isRunning();
    }

    public boolean isStarted() {
        AnimatorSet animatorSet = this.f49137b;
        return animatorSet != null && animatorSet.isStarted();
    }

    /* renamed from: f */
    private AnimatorSet m35413f() {
        return this.f49137b;
    }

    /* renamed from: a */
    private List<android.animation.Animator> m35401a(Animator... animatorArr) {
        ArrayList arrayList = new ArrayList();
        for (C16476w wVar : animatorArr) {
            if (wVar instanceof C16476w) {
                arrayList.add(wVar.m35413f());
            } else {
                LoggerUtil.m35315e(f49136a, "collectAnimators: unsupported Animator type: " + wVar.getClass().getSimpleName());
            }
        }
        return arrayList;
    }

    public Animator playTogether(Animator... animatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f49137b = animatorSet;
        animatorSet.playTogether(m35401a(animatorArr));
        this.f49142g = true;
        return this;
    }

    public Animator playSequentially(Animator... animatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f49137b = animatorSet;
        animatorSet.playSequentially(m35401a(animatorArr));
        this.f49142g = true;
        return this;
    }
}
