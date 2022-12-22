package com.didi.soda.uiwidget.cardview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;

/* renamed from: com.didi.soda.uiwidget.cardview.c */
/* compiled from: SodaCardViewBaseImpl */
class C14226c implements C14228e {

    /* renamed from: a */
    final RectF f43850a = new RectF();

    /* renamed from: f */
    public void mo109164f(C14227d dVar) {
    }

    C14226c() {
    }

    /* renamed from: a */
    public float mo109151a(C14227d dVar) {
        return m31158m(dVar).mo109140f();
    }

    /* renamed from: b */
    public float mo109155b(C14227d dVar) {
        return m31158m(dVar).mo109141g();
    }

    /* renamed from: c */
    public float mo109158c(C14227d dVar) {
        return m31158m(dVar).mo109146i();
    }

    /* renamed from: d */
    public float mo109161d(C14227d dVar) {
        return m31158m(dVar).mo109145h();
    }

    /* renamed from: e */
    public float mo109163e(C14227d dVar) {
        return m31158m(dVar).mo109139e();
    }

    /* renamed from: a */
    public void mo109150a() {
        SodaRoundRectDrawableWithShadow.f43830a = new SodaCardViewBaseImpl$1(this);
    }

    /* renamed from: a */
    public void mo109154a(C14227d dVar, Context context, int i, float f, float f2, float f3, float f4, int i2, int i3) {
        SodaRoundRectDrawableWithShadow a = m31157a(context, i, f, f2, f3, f4, i2, i3);
        a.mo109128a(dVar.getPreventCornerOverlap());
        C14227d dVar2 = dVar;
        dVar.setCardBackground(a);
        mo109170l(dVar);
    }

    /* renamed from: g */
    public void mo109165g(C14227d dVar) {
        m31158m(dVar).mo109128a(dVar.getPreventCornerOverlap());
        mo109170l(dVar);
    }

    /* renamed from: a */
    public void mo109153a(C14227d dVar, int i) {
        m31158m(dVar).mo109126a(i);
    }

    /* renamed from: h */
    public int mo109166h(C14227d dVar) {
        return m31158m(dVar).mo109123a();
    }

    /* renamed from: b */
    public void mo109157b(C14227d dVar, int i) {
        m31158m(dVar).mo109132b(i);
    }

    /* renamed from: c */
    public void mo109160c(C14227d dVar, int i) {
        m31158m(dVar).mo109135c(i);
    }

    /* renamed from: a */
    public void mo109152a(C14227d dVar, float f) {
        m31158m(dVar).mo109131b(f);
    }

    /* renamed from: i */
    public float mo109167i(C14227d dVar) {
        return m31158m(dVar).mo109129b();
    }

    /* renamed from: j */
    public int mo109168j(C14227d dVar) {
        return m31158m(dVar).mo109133c();
    }

    /* renamed from: k */
    public int mo109169k(C14227d dVar) {
        return m31158m(dVar).mo109136d();
    }

    /* renamed from: b */
    public void mo109156b(C14227d dVar, float f) {
        m31158m(dVar).mo109134c(f);
    }

    /* renamed from: c */
    public void mo109159c(C14227d dVar, float f) {
        m31158m(dVar).mo109137d(f);
        mo109170l(dVar);
    }

    /* renamed from: d */
    public void mo109162d(C14227d dVar, float f) {
        m31158m(dVar).mo109124a(f);
        mo109170l(dVar);
    }

    /* renamed from: l */
    public void mo109170l(C14227d dVar) {
        Rect rect = new Rect();
        m31158m(dVar).mo109127a(rect);
        dVar.setMinWidthHeightInternal((int) Math.ceil((double) mo109161d(dVar)), (int) Math.ceil((double) mo109158c(dVar)));
        dVar.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: a */
    private SodaRoundRectDrawableWithShadow m31157a(Context context, int i, float f, float f2, float f3, float f4, int i2, int i3) {
        return new SodaRoundRectDrawableWithShadow(context.getResources(), i, f, f2, f3, f4, i2, i3);
    }

    /* renamed from: m */
    private SodaRoundRectDrawableWithShadow m31158m(C14227d dVar) {
        return (SodaRoundRectDrawableWithShadow) dVar.getCardBackground();
    }
}
