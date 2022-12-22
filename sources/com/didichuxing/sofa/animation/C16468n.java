package com.didichuxing.sofa.animation;

import android.view.View;
import com.didichuxing.sofa.animation.Animator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sofa.animation.n */
/* compiled from: FakeAnimator */
class C16468n extends Animator {

    /* renamed from: a */
    private static final String f49107a = "FakeAnimator";

    /* renamed from: b */
    private List<C16472s> f49108b = new ArrayList();

    /* renamed from: c */
    private boolean f49109c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f49110d = false;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121013a() {
    }

    public void stop() {
    }

    C16468n() {
    }

    /* renamed from: a */
    private C16474u[] m35350a(List<C16456b> list) {
        int size = list.size();
        C16474u[] uVarArr = new C16474u[size];
        for (int i = 0; i < size; i++) {
            float[] b = list.get(i).mo121103b();
            uVarArr[i] = C16474u.m35389a(list.get(i).mo121102a(), b[b.length - 1]);
        }
        return uVarArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m35351d() {
        this.f49109c = true;
        AnimatorListener c = mo121105c();
        if (c != null) {
            c.onAnimationStart(this, (View) null);
        }
        for (C16472s next : this.f49108b) {
            AnimatorListener c2 = next.mo121105c();
            if (c2 != null) {
                c2.onAnimationStart(this, next.mo121124b());
            }
            View b = next.mo121124b();
            if (b != null) {
                m35347a(b, m35350a(next.mo121119a()));
                b.setVisibility(0);
                if (c2 != null) {
                    c2.onAnimationEnd(this, next.mo121124b());
                }
            }
        }
        if (c != null) {
            c.onAnimationEnd(this, (View) null);
        }
        this.f49109c = false;
    }

    /* renamed from: a */
    private void m35347a(View view, C16474u[] uVarArr) {
        for (C16474u uVar : uVarArr) {
            String a = uVar.mo121142a();
            char c = 65535;
            switch (a.hashCode()) {
                case -1225497657:
                    if (a.equals("translationX")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (a.equals("translationY")) {
                        c = 3;
                        break;
                    }
                    break;
                case -908189618:
                    if (a.equals("scaleX")) {
                        c = 5;
                        break;
                    }
                    break;
                case -908189617:
                    if (a.equals("scaleY")) {
                        c = 6;
                        break;
                    }
                    break;
                case -40300674:
                    if (a.equals("rotation")) {
                        c = 4;
                        break;
                    }
                    break;
                case 88:
                    if (a.equals(C16471q.f49112a)) {
                        c = 0;
                        break;
                    }
                    break;
                case 89:
                    if (a.equals(C16471q.f49113b)) {
                        c = 1;
                        break;
                    }
                    break;
                case 92909918:
                    if (a.equals("alpha")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    view.setX(uVar.mo121143b());
                    break;
                case 1:
                    view.setY(uVar.mo121143b());
                    break;
                case 2:
                    view.setTranslationX(uVar.mo121143b());
                    break;
                case 3:
                    view.setTranslationY(uVar.mo121143b());
                    break;
                case 4:
                    view.setRotation(uVar.mo121143b());
                    break;
                case 5:
                    view.setScaleX(uVar.mo121143b());
                    break;
                case 6:
                    view.setScaleY(uVar.mo121143b());
                    break;
                case 7:
                    view.setAlpha(uVar.mo121143b());
                    break;
                default:
                    C16470p.m35362a(view, uVar.mo121142a(), uVar.mo121143b());
                    break;
            }
        }
    }

    /* renamed from: a */
    public void mo121015a(C16472s sVar) {
        this.f49108b.add(sVar);
    }

    /* renamed from: b */
    public void mo121017b(C16472s sVar) {
        this.f49108b.add(sVar);
    }

    /* renamed from: c */
    public void mo121019c(C16472s sVar) {
        this.f49108b.add(sVar);
    }

    /* renamed from: d */
    public void mo121020d(C16472s sVar) {
        this.f49108b.add(sVar);
    }

    public Animator start() {
        this.f49110d = true;
        mo121014a((Animator.PrepareAnimationCallback) new FakeAnimator$1(this));
        return this;
    }

    public boolean isRunning() {
        return this.f49109c;
    }

    public boolean isStarted() {
        return this.f49110d;
    }

    /* renamed from: e */
    private List<C16472s> m35352e() {
        return this.f49108b;
    }

    /* renamed from: a */
    private List<C16472s> m35346a(Animator[] animatorArr) {
        ArrayList arrayList = new ArrayList();
        int length = animatorArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            C16468n nVar = animatorArr[i];
            if (!(nVar instanceof C16468n)) {
                LoggerUtil.m35315e(f49107a, "collectAnimations: unsupported Animator type: " + nVar.getClass().getSimpleName());
                break;
            }
            arrayList.addAll(nVar.m35352e());
            i++;
        }
        return arrayList;
    }

    public Animator playTogether(Animator... animatorArr) {
        this.f49108b.clear();
        this.f49108b.addAll(m35346a(animatorArr));
        return this;
    }

    public Animator playSequentially(Animator... animatorArr) {
        return playTogether(animatorArr);
    }
}
