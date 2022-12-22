package com.didi.app.nova.skeleton.dialog;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class DialogInstrument {

    /* renamed from: a */
    final View.OnTouchListener f8430a = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (DialogInstrument.this.f8432c.mo40926a()) {
                return false;
            }
            if (!DialogInstrument.this.f8432c.mo40929c().mo40924d().isCancelable() || motionEvent.getAction() == 0) {
                return true;
            }
            if (motionEvent.getAction() == 1) {
                return DialogInstrument.this.handleBack();
            }
            return false;
        }
    };

    /* renamed from: b */
    private DialogFrameLayout f8431b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C3728b f8432c = new C3728b();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map<String, ChangeAnimationData> f8433d = new HashMap();

    public DialogInstrument(DialogFrameLayout dialogFrameLayout) {
        this.f8431b = dialogFrameLayout;
    }

    public boolean handleBack() {
        if (this.f8432c.mo40926a()) {
            return false;
        }
        if (!this.f8432c.mo40929c().mo40924d().isCancelable() || this.f8432c.mo40929c().mo40924d().onHandleBack()) {
            return true;
        }
        this.f8432c.mo40929c().mo40924d().dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40909a(C3727a aVar) {
        aVar.mo40924d().mo40886a(this);
        C3727a c = this.f8432c.mo40929c();
        this.f8432c.mo40928b(aVar);
        String c2 = aVar.mo40923c();
        TraceUtil.trace(c2, "will show " + aVar.mo40924d());
        m5623a(aVar, c, true);
        this.f8431b.onDialogChange(aVar.mo40924d(), c == null ? null : c.mo40924d(), true);
        if (this.f8432c.mo40927b() == 1) {
            this.f8431b.setOnTouchListener(this.f8430a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40908a(Dialog dialog) {
        C3727a aVar;
        C3727a c = this.f8432c.mo40929c();
        if (c != null && c.mo40924d() == dialog) {
            this.f8432c.mo40931d();
            TraceUtil.trace(c.mo40923c(), "pop " + c.mo40924d());
            m5623a(this.f8432c.mo40929c(), c, false);
            this.f8431b.onDialogChange(this.f8432c.mo40929c() == null ? null : this.f8432c.mo40929c().mo40924d(), c == null ? null : c.mo40924d(), false);
        } else {
            Iterator<C3727a> it = this.f8432c.iterator();
            C3727a aVar2 = null;
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = it.next();
                if (aVar.mo40924d() == dialog) {
                    aVar2 = aVar;
                } else if (aVar2 != null) {
                    break;
                }
            }
            if (aVar2 != null) {
                this.f8432c.mo40925a(aVar2);
                TraceUtil.trace(aVar2.mo40923c(), "pop " + aVar2.mo40924d());
                m5623a(aVar, aVar2, false);
                this.f8431b.onDialogChange(aVar == null ? null : aVar.mo40924d(), aVar2 == null ? null : aVar2.mo40924d(), false);
            }
        }
        if (this.f8432c.mo40926a()) {
            this.f8431b.setOnTouchListener((View.OnTouchListener) null);
        }
    }

    public void dismissAll() {
        while (!this.f8432c.mo40926a()) {
            mo40908a(this.f8432c.mo40929c().mo40924d());
        }
    }

    public final void onActivityStart() {
        if (!this.f8432c.mo40926a() && !this.f8432c.mo40929c().mo40924d().isAttached()) {
            m5624a(this.f8432c.mo40929c(), (C3727a) null, true, new SimpleTransformAnimation());
        }
    }

    public final void onActivityStop() {
        if (!this.f8432c.mo40926a() && this.f8432c.mo40929c().mo40924d().isAttached()) {
            m5624a((C3727a) null, this.f8432c.mo40929c(), false, new SimpleTransformAnimation(false));
        }
    }

    public final void onActivityDestroy() {
        while (!this.f8432c.mo40926a()) {
            C3727a d = this.f8432c.mo40931d();
            if (d.mo40924d().isAttached()) {
                m5624a((C3727a) null, d, false, new SimpleTransformAnimation());
            } else {
                d.mo40924d().mo40890d();
                String c = d.mo40923c();
                TraceUtil.trace(c, d.mo40924d() + " is destroyed.");
            }
        }
    }

    /* renamed from: a */
    private final void m5623a(C3727a aVar, C3727a aVar2, boolean z) {
        TransformAnimation transformAnimation;
        if (z) {
            transformAnimation = aVar.mo40920a();
        } else {
            transformAnimation = aVar2 != null ? aVar2.mo40922b() : null;
        }
        if (transformAnimation == null) {
            transformAnimation = new SimpleTransformAnimation();
        }
        m5624a(aVar, aVar2, z, transformAnimation);
    }

    /* renamed from: a */
    private final void m5624a(final C3727a aVar, final C3727a aVar2, boolean z, TransformAnimation transformAnimation) {
        View view;
        if (transformAnimation.f8435a) {
            transformAnimation = transformAnimation.copy();
        }
        TransformAnimation transformAnimation2 = transformAnimation;
        transformAnimation2.f8435a = true;
        if (aVar2 != null) {
            if (z) {
                mo40910a(aVar2.mo40924d().mo40884a());
            } else {
                mo40911b(aVar2.mo40924d().mo40884a());
            }
        }
        if (aVar != null) {
            this.f8433d.put(aVar.mo40924d().mo40884a(), new ChangeAnimationData(transformAnimation2, z));
        }
        View view2 = null;
        if (aVar != null) {
            aVar.mo40924d().mo40885a(LayoutInflater.from(this.f8431b.getContext()), this.f8431b);
            view = aVar.mo40924d().getView();
        } else {
            view = null;
        }
        if (aVar2 != null) {
            view2 = aVar2.mo40924d().getView();
        }
        View view3 = view2;
        if (aVar2 != null) {
            aVar2.mo40924d().mo40889c();
            TraceUtil.trace(aVar2.mo40923c(), aVar2.mo40924d() + " will dismiss.");
        }
        transformAnimation2.performChange(this.f8431b, view3, view, z, new TransformAnimation.TransformAnimationListener() {
            public void onAnimationCompleted() {
                if (aVar != null) {
                    DialogInstrument.this.f8433d.remove(aVar.mo40924d().mo40884a());
                    aVar.mo40924d().mo40887b();
                    String c = aVar.mo40923c();
                    TraceUtil.trace(c, aVar.mo40924d() + " had been show.");
                }
                if (aVar2 != null && !DialogInstrument.this.f8432c.mo40930c(aVar2)) {
                    aVar2.mo40924d().mo40890d();
                    String c2 = aVar2.mo40923c();
                    TraceUtil.trace(c2, aVar2.mo40924d() + " is destroyed.");
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo40910a(String str) {
        ChangeAnimationData changeAnimationData = this.f8433d.get(str);
        if (changeAnimationData == null) {
            return false;
        }
        changeAnimationData.animation.completeAnimationImmediately();
        this.f8433d.remove(str);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo40911b(String str) {
        ChangeAnimationData changeAnimationData = this.f8433d.get(str);
        if (changeAnimationData != null) {
            if (changeAnimationData.isPush) {
                changeAnimationData.animation.onAbortPush();
            } else {
                changeAnimationData.animation.completeAnimationImmediately();
            }
            this.f8433d.remove(str);
        }
    }

    static class ChangeAnimationData {
        TransformAnimation animation;
        boolean isPush;

        ChangeAnimationData(TransformAnimation transformAnimation, boolean z) {
            this.animation = transformAnimation;
            this.isPush = z;
        }
    }
}
