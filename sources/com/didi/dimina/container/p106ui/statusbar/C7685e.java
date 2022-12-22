package com.didi.dimina.container.p106ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/* renamed from: com.didi.dimina.container.ui.statusbar.e */
/* compiled from: ImmersionDelegate */
class C7685e implements Runnable {

    /* renamed from: a */
    private ImmersionBar f17787a;

    /* renamed from: b */
    private BarProperties f17788b;

    /* renamed from: c */
    private OnBarListener f17789c;

    /* renamed from: d */
    private int f17790d;

    C7685e(Object obj) {
        if (obj instanceof Activity) {
            if (this.f17787a == null) {
                this.f17787a = new ImmersionBar((Activity) obj);
            }
        } else if (obj instanceof Fragment) {
            if (this.f17787a != null) {
                return;
            }
            if (obj instanceof DialogFragment) {
                this.f17787a = new ImmersionBar((DialogFragment) obj);
            } else {
                this.f17787a = new ImmersionBar((Fragment) obj);
            }
        } else if ((obj instanceof android.app.Fragment) && this.f17787a == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.f17787a = new ImmersionBar((android.app.DialogFragment) obj);
            } else {
                this.f17787a = new ImmersionBar((android.app.Fragment) obj);
            }
        }
    }

    C7685e(Activity activity, Dialog dialog) {
        if (this.f17787a == null) {
            this.f17787a = new ImmersionBar(activity, dialog);
        }
    }

    /* renamed from: a */
    public ImmersionBar mo56695a() {
        return this.f17787a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56696a(Configuration configuration) {
        m13274c(configuration);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo56697b() {
        ImmersionBar immersionBar = this.f17787a;
        if (immersionBar != null) {
            immersionBar.mo56559b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo56699c() {
        this.f17788b = null;
        ImmersionBar immersionBar = this.f17787a;
        if (immersionBar != null) {
            immersionBar.mo56542a();
            this.f17787a = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo56698b(Configuration configuration) {
        ImmersionBar immersionBar = this.f17787a;
        if (immersionBar != null) {
            immersionBar.mo56543a(configuration);
            m13274c(configuration);
        }
    }

    /* renamed from: c */
    private void m13274c(Configuration configuration) {
        ImmersionBar immersionBar = this.f17787a;
        if (immersionBar != null && immersionBar.mo56602n() && Build.VERSION.SDK_INT >= 19) {
            OnBarListener onBarListener = this.f17787a.getBarParams().f17692d;
            this.f17789c = onBarListener;
            if (onBarListener != null) {
                Activity h = this.f17787a.mo56591h();
                if (this.f17788b == null) {
                    this.f17788b = new BarProperties();
                }
                this.f17788b.mo56519a(configuration.orientation == 1);
                int rotation = h.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation == 1) {
                    this.f17788b.mo56521b(true);
                    this.f17788b.mo56523c(false);
                } else if (rotation == 3) {
                    this.f17788b.mo56521b(false);
                    this.f17788b.mo56523c(true);
                } else {
                    this.f17788b.mo56521b(false);
                    this.f17788b.mo56523c(false);
                }
                h.getWindow().getDecorView().post(this);
            }
        }
    }

    public void run() {
        ImmersionBar immersionBar = this.f17787a;
        if (immersionBar != null && immersionBar.mo56591h() != null) {
            Activity h = this.f17787a.mo56591h();
            C7681a aVar = new C7681a(h);
            this.f17788b.mo56518a(aVar.mo56686b());
            this.f17788b.mo56527e(aVar.mo56688d());
            this.f17788b.mo56520b(aVar.mo56689e());
            this.f17788b.mo56522c(aVar.mo56690f());
            this.f17788b.mo56526e(aVar.mo56687c());
            boolean hasNotchScreen = NotchUtils.hasNotchScreen(h);
            this.f17788b.mo56525d(hasNotchScreen);
            if (hasNotchScreen && this.f17790d == 0) {
                int notchHeight = NotchUtils.getNotchHeight(h);
                this.f17790d = notchHeight;
                this.f17788b.mo56524d(notchHeight);
            }
            this.f17789c.onBarChange(this.f17788b);
        }
    }
}
