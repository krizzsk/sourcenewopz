package com.didi.rfusion.widget.titlebar.tools;

import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: com.didi.rfusion.widget.titlebar.tools.a */
/* compiled from: RFViewOffsetHelper */
class C11588a {

    /* renamed from: a */
    private final View f33993a;

    /* renamed from: b */
    private int f33994b;

    /* renamed from: c */
    private int f33995c;

    /* renamed from: d */
    private int f33996d;

    /* renamed from: e */
    private int f33997e;

    /* renamed from: f */
    private boolean f33998f = true;

    /* renamed from: g */
    private boolean f33999g = true;

    public C11588a(View view) {
        this.f33993a = view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88584a() {
        this.f33994b = this.f33993a.getTop();
        this.f33995c = this.f33993a.getLeft();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo88587b() {
        View view = this.f33993a;
        ViewCompat.offsetTopAndBottom(view, this.f33996d - (view.getTop() - this.f33994b));
        View view2 = this.f33993a;
        ViewCompat.offsetLeftAndRight(view2, this.f33997e - (view2.getLeft() - this.f33995c));
    }

    /* renamed from: a */
    public boolean mo88586a(int i) {
        if (!this.f33998f || this.f33996d == i) {
            return false;
        }
        this.f33996d = i;
        mo88587b();
        return true;
    }

    /* renamed from: b */
    public boolean mo88589b(int i) {
        if (!this.f33999g || this.f33997e == i) {
            return false;
        }
        this.f33997e = i;
        mo88587b();
        return true;
    }

    /* renamed from: c */
    public int mo88590c() {
        return this.f33996d;
    }

    /* renamed from: d */
    public int mo88591d() {
        return this.f33997e;
    }

    /* renamed from: e */
    public int mo88592e() {
        return this.f33994b;
    }

    /* renamed from: f */
    public int mo88593f() {
        return this.f33995c;
    }

    /* renamed from: a */
    public void mo88585a(boolean z) {
        this.f33998f = z;
    }

    /* renamed from: g */
    public boolean mo88594g() {
        return this.f33998f;
    }

    /* renamed from: b */
    public void mo88588b(boolean z) {
        this.f33999g = z;
    }

    /* renamed from: h */
    public boolean mo88595h() {
        return this.f33999g;
    }
}
