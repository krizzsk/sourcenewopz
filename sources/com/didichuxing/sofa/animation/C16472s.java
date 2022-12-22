package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sofa.animation.s */
/* compiled from: PropertyBuilder */
class C16472s extends C16457c {

    /* renamed from: a */
    private final int f49120a = 1000;

    /* renamed from: b */
    private final long f49121b = 0;

    /* renamed from: c */
    private WeakReference<View> f49122c;

    /* renamed from: d */
    private List<C16456b> f49123d = new ArrayList();

    /* renamed from: e */
    private int f49124e = 1000;

    /* renamed from: f */
    private int f49125f = 0;

    /* renamed from: g */
    private int f49126g = 1;

    /* renamed from: h */
    private Interpolator f49127h = new LinearInterpolator();

    /* renamed from: i */
    private long f49128i = 0;

    /* renamed from: j */
    private TypeEvaluator f49129j;

    C16472s(View view) {
        WeakReference<View> weakReference = null;
        this.f49129j = null;
        this.f49122c = view != null ? new WeakReference<>(view) : weakReference;
    }

    /* renamed from: b */
    private void m35363b(String str, float... fArr) {
        this.f49123d.add(C16456b.m35318a(str, fArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C16472s mo121118a(float... fArr) {
        m35363b(C16471q.f49112a, fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C16472s mo121125b(float... fArr) {
        m35363b(C16471q.f49113b, fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C16472s mo121127c(float... fArr) {
        m35363b("translationX", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C16472s mo121130d(float... fArr) {
        m35363b("translationY", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C16472s mo121132e(float... fArr) {
        m35363b("rotation", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C16472s mo121134f(float... fArr) {
        m35363b("scaleX", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public C16472s mo121136g(float... fArr) {
        m35363b("scaleY", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C16472s mo121138h(float... fArr) {
        m35363b("alpha", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C16472s mo121117a(String str, float... fArr) {
        m35363b(str, fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C16456b> mo121119a() {
        return this.f49123d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo121124b() {
        WeakReference<View> weakReference = this.f49122c;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo121129d() {
        return this.f49124e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121120a(int i) {
        if (i <= 0) {
            this.f49124e = 1000;
        } else {
            this.f49124e = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo121131e() {
        return this.f49126g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo121126b(int i) {
        this.f49126g = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo121133f() {
        return this.f49125f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo121128c(int i) {
        this.f49125f = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Interpolator mo121135g() {
        return this.f49127h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121123a(Interpolator interpolator) {
        this.f49127h = interpolator;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public long mo121137h() {
        return this.f49128i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121121a(long j) {
        if (j < 0) {
            this.f49128i = 0;
        } else {
            this.f49128i = j;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public TypeEvaluator mo121139i() {
        return this.f49129j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121122a(TypeEvaluator typeEvaluator) {
        this.f49129j = typeEvaluator;
    }
}
