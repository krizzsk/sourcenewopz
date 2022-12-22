package com.didi.dimina.container.p106ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.dimina.container.ui.statusbar.ImmersionBar */
public final class ImmersionBar implements C7684d {

    /* renamed from: A */
    private int f17706A;

    /* renamed from: a */
    private final Activity f17707a;

    /* renamed from: b */
    private Fragment f17708b;

    /* renamed from: c */
    private android.app.Fragment f17709c;

    /* renamed from: d */
    private Dialog f17710d;

    /* renamed from: e */
    private Window f17711e;

    /* renamed from: f */
    private ViewGroup f17712f;

    /* renamed from: g */
    private ViewGroup f17713g;

    /* renamed from: h */
    private ImmersionBar f17714h;

    /* renamed from: i */
    private boolean f17715i;

    /* renamed from: j */
    private boolean f17716j;

    /* renamed from: k */
    private boolean f17717k;

    /* renamed from: l */
    private boolean f17718l;

    /* renamed from: m */
    private BarParams f17719m;

    /* renamed from: n */
    private C7681a f17720n;

    /* renamed from: o */
    private int f17721o;

    /* renamed from: p */
    private int f17722p;

    /* renamed from: q */
    private int f17723q;

    /* renamed from: r */
    private C7683c f17724r;

    /* renamed from: s */
    private final Map<String, BarParams> f17725s;

    /* renamed from: t */
    private int f17726t;

    /* renamed from: u */
    private boolean f17727u;

    /* renamed from: v */
    private boolean f17728v;

    /* renamed from: w */
    private boolean f17729w;

    /* renamed from: x */
    private int f17730x;

    /* renamed from: y */
    private int f17731y;

    /* renamed from: z */
    private int f17732z;

    public static ImmersionBar with(Activity activity) {
        return m13195J().mo56676a(activity);
    }

    public static ImmersionBar with(Fragment fragment) {
        return m13195J().mo56679a(fragment, false);
    }

    public static ImmersionBar with(Fragment fragment, boolean z) {
        return m13195J().mo56679a(fragment, z);
    }

    public static ImmersionBar with(android.app.Fragment fragment) {
        return m13195J().mo56678a(fragment, false);
    }

    public static ImmersionBar with(android.app.Fragment fragment, boolean z) {
        return m13195J().mo56678a(fragment, z);
    }

    public static ImmersionBar with(DialogFragment dialogFragment) {
        return m13195J().mo56679a((Fragment) dialogFragment, false);
    }

    public static ImmersionBar with(android.app.DialogFragment dialogFragment) {
        return m13195J().mo56678a((android.app.Fragment) dialogFragment, false);
    }

    public static ImmersionBar with(Activity activity, Dialog dialog) {
        return m13195J().mo56677a(activity, dialog);
    }

    public static void destroy(Fragment fragment) {
        m13195J().mo56681b(fragment, false);
    }

    public static void destroy(Fragment fragment, boolean z) {
        m13195J().mo56681b(fragment, z);
    }

    public static void destroy(Activity activity, Dialog dialog) {
        m13195J().mo56680b(activity, dialog);
    }

    public void init() {
        if (Build.VERSION.SDK_INT >= 19 && this.f17719m.barEnable) {
            m13204q();
            mo56574c();
            m13211x();
            m13193H();
            m13191F();
            this.f17727u = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56542a() {
        ImmersionBar immersionBar;
        m13192G();
        if (this.f17718l && (immersionBar = this.f17714h) != null) {
            immersionBar.f17719m.keyboardEnable = immersionBar.f17729w;
            if (this.f17714h.f17719m.barHide != BarHide.FLAG_SHOW_BAR) {
                this.f17714h.mo56574c();
            }
        }
        this.f17727u = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo56559b() {
        if (!this.f17716j && this.f17727u && this.f17719m != null) {
            if (OSUtils.isEMUI3_x() && this.f17719m.navigationBarWithEMUI3Enable) {
                init();
            } else if (this.f17719m.barHide != BarHide.FLAG_SHOW_BAR) {
                mo56574c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56543a(Configuration configuration) {
        if (!OSUtils.isEMUI3_x() && Build.VERSION.SDK_INT != 19) {
            m13211x();
        } else if (!this.f17727u || this.f17716j || !this.f17719m.navigationBarWithKitkatEnable) {
            m13211x();
        } else {
            init();
        }
    }

    /* renamed from: q */
    private void m13204q() {
        m13210w();
        if (Build.VERSION.SDK_INT >= 19) {
            m13189D();
            ImmersionBar immersionBar = this.f17714h;
            if (immersionBar != null) {
                if (this.f17716j) {
                    immersionBar.f17719m = this.f17719m;
                }
                if (this.f17718l) {
                    ImmersionBar immersionBar2 = this.f17714h;
                    if (immersionBar2.f17729w) {
                        immersionBar2.f17719m.keyboardEnable = false;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo56574c() {
        int i = 256;
        if (Build.VERSION.SDK_INT < 21 || OSUtils.isEMUI3_x()) {
            m13207t();
        } else {
            m13206s();
            i = m13203d(m13202c(m13196a(256)));
        }
        this.f17712f.setSystemUiVisibility(m13201b(i));
        m13205r();
        if (this.f17719m.f17691c != null) {
            NavigationBarObserver.m13231a().mo56665a(this.f17707a.getApplication());
        }
    }

    /* renamed from: r */
    private void m13205r() {
        if (OSUtils.isMIUI6Later()) {
            C7686f.m13286a(this.f17711e, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.f17719m.statusBarDarkFont);
            if (this.f17719m.navigationBarEnable) {
                C7686f.m13286a(this.f17711e, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", this.f17719m.navigationBarDarkIcon);
            }
        }
        if (!OSUtils.isFlymeOS4Later()) {
            return;
        }
        if (this.f17719m.flymeOSStatusBarFontColor != 0) {
            C7686f.m13281a(this.f17707a, this.f17719m.flymeOSStatusBarFontColor);
        } else {
            C7686f.m13282a(this.f17707a, this.f17719m.statusBarDarkFont);
        }
    }

    /* renamed from: s */
    private void m13206s() {
        if (Build.VERSION.SDK_INT >= 28 && !this.f17727u) {
            WindowManager.LayoutParams attributes = this.f17711e.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.f17711e.setAttributes(attributes);
        }
    }

    /* renamed from: a */
    private int m13196a(int i) {
        if (!this.f17727u) {
            this.f17719m.defaultNavigationBarColor = this.f17711e.getNavigationBarColor();
        }
        int i2 = i | 1024;
        if (this.f17719m.fullScreen && this.f17719m.navigationBarEnable) {
            i2 |= 512;
        }
        this.f17711e.clearFlags(View.STATUS_BAR_TRANSIENT);
        if (this.f17720n.mo56688d()) {
            this.f17711e.clearFlags(View.NAVIGATION_BAR_TRANSIENT);
        }
        this.f17711e.addFlags(Integer.MIN_VALUE);
        if (this.f17719m.statusBarColorEnabled) {
            this.f17711e.setStatusBarColor(ColorUtils.blendARGB(this.f17719m.statusBarColor, this.f17719m.statusBarColorTransform, this.f17719m.statusBarAlpha));
        } else {
            this.f17711e.setStatusBarColor(ColorUtils.blendARGB(this.f17719m.statusBarColor, 0, this.f17719m.statusBarAlpha));
        }
        if (this.f17719m.navigationBarEnable) {
            this.f17711e.setNavigationBarColor(ColorUtils.blendARGB(this.f17719m.navigationBarColor, this.f17719m.navigationBarColorTransform, this.f17719m.navigationBarAlpha));
        }
        return i2;
    }

    /* renamed from: t */
    private void m13207t() {
        this.f17711e.addFlags(View.STATUS_BAR_TRANSIENT);
        m13208u();
        if (this.f17720n.mo56688d() || OSUtils.isEMUI3_x()) {
            if (!this.f17719m.navigationBarEnable || !this.f17719m.navigationBarWithKitkatEnable) {
                this.f17711e.clearFlags(View.NAVIGATION_BAR_TRANSIENT);
            } else {
                this.f17711e.addFlags(View.NAVIGATION_BAR_TRANSIENT);
            }
            if (this.f17721o == 0) {
                this.f17721o = this.f17720n.mo56689e();
            }
            if (this.f17722p == 0) {
                this.f17722p = this.f17720n.mo56690f();
            }
            m13209v();
        }
    }

    /* renamed from: u */
    private void m13208u() {
        View findViewById = this.f17712f.findViewById(C7682b.f17759a);
        if (findViewById == null) {
            findViewById = new View(this.f17707a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f17720n.mo56686b());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(C7682b.f17759a);
            this.f17712f.addView(findViewById);
        }
        if (this.f17719m.statusBarColorEnabled) {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.f17719m.statusBarColor, this.f17719m.statusBarColorTransform, this.f17719m.statusBarAlpha));
        } else {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.f17719m.statusBarColor, 0, this.f17719m.statusBarAlpha));
        }
    }

    /* renamed from: v */
    private void m13209v() {
        FrameLayout.LayoutParams layoutParams;
        View findViewById = this.f17712f.findViewById(C7682b.f17760b);
        if (findViewById == null) {
            findViewById = new View(this.f17707a);
            findViewById.setId(C7682b.f17760b);
            this.f17712f.addView(findViewById);
        }
        if (this.f17720n.mo56685a()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f17720n.mo56689e());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f17720n.mo56690f(), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        findViewById.setLayoutParams(layoutParams);
        findViewById.setBackgroundColor(ColorUtils.blendARGB(this.f17719m.navigationBarColor, this.f17719m.navigationBarColorTransform, this.f17719m.navigationBarAlpha));
        if (!this.f17719m.navigationBarEnable || !this.f17719m.navigationBarWithKitkatEnable || this.f17719m.hideNavigationBar) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    /* renamed from: w */
    private void m13210w() {
        boolean z = true;
        if (this.f17719m.autoStatusBarDarkModeEnable && this.f17719m.statusBarColor != 0) {
            statusBarDarkFont(this.f17719m.statusBarColor > -4539718, this.f17719m.autoStatusBarDarkModeAlpha);
        }
        if (this.f17719m.autoNavigationBarDarkModeEnable && this.f17719m.navigationBarColor != 0) {
            if (this.f17719m.navigationBarColor <= -4539718) {
                z = false;
            }
            navigationBarDarkIcon(z, this.f17719m.autoNavigationBarDarkModeAlpha);
        }
    }

    /* renamed from: com.didi.dimina.container.ui.statusbar.ImmersionBar$2 */
    static /* synthetic */ class C76782 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.dimina.container.ui.statusbar.BarHide[] r0 = com.didi.dimina.container.p106ui.statusbar.BarHide.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide = r0
                com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p106ui.statusbar.BarHide.FLAG_HIDE_BAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p106ui.statusbar.BarHide.FLAG_HIDE_STATUS_BAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p106ui.statusbar.BarHide.FLAG_HIDE_NAVIGATION_BAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p106ui.statusbar.BarHide.FLAG_SHOW_BAR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.statusbar.ImmersionBar.C76782.<clinit>():void");
        }
    }

    /* renamed from: b */
    private int m13201b(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i2 = C76782.$SwitchMap$com$didi$dimina$container$ui$statusbar$BarHide[this.f17719m.barHide.ordinal()];
            if (i2 == 1) {
                i |= 518;
            } else if (i2 == 2) {
                i |= 1028;
            } else if (i2 == 3) {
                i |= 514;
            } else if (i2 == 4) {
                i |= 0;
            }
        }
        return i | 4096;
    }

    /* renamed from: x */
    private void m13211x() {
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT < 21 || OSUtils.isEMUI3_x()) {
                m13212y();
            } else {
                m13186A();
            }
            m13190E();
        }
    }

    /* renamed from: y */
    private void m13212y() {
        if (this.f17719m.isSupportActionBar) {
            this.f17728v = true;
            this.f17713g.post(this);
            return;
        }
        this.f17728v = false;
        m13213z();
    }

    public void run() {
        m13213z();
    }

    /* renamed from: z */
    private void m13213z() {
        m13189D();
        m13187B();
        if (!this.f17716j && OSUtils.isEMUI3_x()) {
            m13188C();
        }
    }

    /* renamed from: A */
    private void m13186A() {
        m13189D();
        if (checkFitsSystemWindows(this.f17712f.findViewById(16908290))) {
            m13197a(0, 0, 0, 0);
            return;
        }
        int b = (!this.f17719m.fits || this.f17726t != 4) ? 0 : this.f17720n.mo56686b();
        if (this.f17719m.isSupportActionBar) {
            b = this.f17720n.mo56686b() + this.f17723q;
        }
        m13197a(0, b, 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* renamed from: B */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13187B() {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.f17712f
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)
            boolean r0 = checkFitsSystemWindows(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0014
            r5.m13197a(r1, r1, r1, r1)
            return
        L_0x0014:
            com.didi.dimina.container.ui.statusbar.BarParams r0 = r5.f17719m
            boolean r0 = r0.fits
            if (r0 == 0) goto L_0x0026
            int r0 = r5.f17726t
            r2 = 4
            if (r0 != r2) goto L_0x0026
            com.didi.dimina.container.ui.statusbar.a r0 = r5.f17720n
            int r0 = r0.mo56686b()
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r5.f17719m
            boolean r2 = r2.isSupportActionBar
            if (r2 == 0) goto L_0x0036
            com.didi.dimina.container.ui.statusbar.a r0 = r5.f17720n
            int r0 = r0.mo56686b()
            int r2 = r5.f17723q
            int r0 = r0 + r2
        L_0x0036:
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f17720n
            boolean r2 = r2.mo56688d()
            if (r2 == 0) goto L_0x008a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r5.f17719m
            boolean r2 = r2.navigationBarEnable
            if (r2 == 0) goto L_0x008a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r5.f17719m
            boolean r2 = r2.navigationBarWithKitkatEnable
            if (r2 == 0) goto L_0x008a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r5.f17719m
            boolean r2 = r2.fullScreen
            if (r2 != 0) goto L_0x0068
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f17720n
            boolean r2 = r2.mo56685a()
            if (r2 == 0) goto L_0x0061
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f17720n
            int r2 = r2.mo56689e()
            r3 = r2
            r2 = 0
            goto L_0x006a
        L_0x0061:
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f17720n
            int r2 = r2.mo56690f()
            goto L_0x0069
        L_0x0068:
            r2 = 0
        L_0x0069:
            r3 = 0
        L_0x006a:
            com.didi.dimina.container.ui.statusbar.BarParams r4 = r5.f17719m
            boolean r4 = r4.hideNavigationBar
            if (r4 == 0) goto L_0x007b
            com.didi.dimina.container.ui.statusbar.a r4 = r5.f17720n
            boolean r4 = r4.mo56685a()
            if (r4 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0079:
            r2 = 0
            goto L_0x008c
        L_0x007b:
            com.didi.dimina.container.ui.statusbar.a r4 = r5.f17720n
            boolean r4 = r4.mo56685a()
            if (r4 != 0) goto L_0x008c
            com.didi.dimina.container.ui.statusbar.a r2 = r5.f17720n
            int r2 = r2.mo56690f()
            goto L_0x008c
        L_0x008a:
            r2 = 0
        L_0x008b:
            r3 = 0
        L_0x008c:
            r5.m13197a(r1, r0, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.statusbar.ImmersionBar.m13187B():void");
    }

    /* renamed from: C */
    private void m13188C() {
        View findViewById = this.f17712f.findViewById(C7682b.f17760b);
        if (!this.f17719m.navigationBarEnable || !this.f17719m.navigationBarWithKitkatEnable) {
            EMUI3NavigationBarObserver.m13182a().mo56540b(this);
            findViewById.setVisibility(8);
        } else if (findViewById != null) {
            EMUI3NavigationBarObserver.m13182a().mo56539a((C7684d) this);
            EMUI3NavigationBarObserver.m13182a().mo56538a(this.f17707a.getApplication());
        }
    }

    /* renamed from: D */
    private void m13189D() {
        this.f17720n = new C7681a(this.f17707a);
        if (!this.f17727u || this.f17728v) {
            this.f17723q = this.f17720n.mo56687c();
        }
    }

    public void onNavigationBarChange(boolean z) {
        View findViewById = this.f17712f.findViewById(C7682b.f17760b);
        if (findViewById != null) {
            this.f17720n = new C7681a(this.f17707a);
            int paddingBottom = this.f17713g.getPaddingBottom();
            int paddingRight = this.f17713g.getPaddingRight();
            if (!z) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                if (!checkFitsSystemWindows(this.f17712f.findViewById(16908290))) {
                    if (this.f17721o == 0) {
                        this.f17721o = this.f17720n.mo56689e();
                    }
                    if (this.f17722p == 0) {
                        this.f17722p = this.f17720n.mo56690f();
                    }
                    if (!this.f17719m.hideNavigationBar) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.f17720n.mo56685a()) {
                            layoutParams.gravity = 80;
                            layoutParams.height = this.f17721o;
                            paddingBottom = !this.f17719m.fullScreen ? this.f17721o : 0;
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = GravityCompat.END;
                            layoutParams.width = this.f17722p;
                            paddingRight = !this.f17719m.fullScreen ? this.f17722p : 0;
                            paddingBottom = 0;
                        }
                        findViewById.setLayoutParams(layoutParams);
                    }
                    m13197a(0, this.f17713g.getPaddingTop(), paddingRight, paddingBottom);
                }
            }
            paddingBottom = 0;
            paddingRight = 0;
            m13197a(0, this.f17713g.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    /* renamed from: c */
    private int m13202c(int i) {
        return (Build.VERSION.SDK_INT < 23 || !this.f17719m.statusBarDarkFont) ? i : i | 8192;
    }

    /* renamed from: d */
    private int m13203d(int i) {
        return (Build.VERSION.SDK_INT < 26 || !this.f17719m.navigationBarDarkIcon) ? i : i | 16;
    }

    /* renamed from: E */
    private void m13190E() {
        int statusBarHeight = this.f17719m.fitsLayoutOverlapEnable ? getStatusBarHeight(this.f17707a) : 0;
        int i = this.f17726t;
        if (i == 1) {
            setTitleBar(this.f17707a, statusBarHeight, this.f17719m.titleBarView);
        } else if (i == 2) {
            setTitleBarMarginTop(this.f17707a, statusBarHeight, this.f17719m.titleBarView);
        } else if (i == 3) {
            setStatusBarView(this.f17707a, statusBarHeight, this.f17719m.statusBarView);
        }
    }

    /* renamed from: F */
    private void m13191F() {
        if (this.f17719m.f17689a.size() != 0) {
            for (Map.Entry next : this.f17719m.f17689a.entrySet()) {
                View view = (View) next.getKey();
                Integer valueOf = Integer.valueOf(this.f17719m.statusBarColor);
                Integer valueOf2 = Integer.valueOf(this.f17719m.statusBarColorTransform);
                for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                    Integer num = (Integer) entry.getKey();
                    valueOf2 = (Integer) entry.getValue();
                    valueOf = num;
                }
                if (view != null) {
                    if (Math.abs(this.f17719m.viewAlpha - 0.0f) == 0.0f) {
                        view.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f17719m.statusBarAlpha));
                    } else {
                        view.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f17719m.viewAlpha));
                    }
                }
            }
        }
    }

    /* renamed from: G */
    private void m13192G() {
        if (this.f17707a != null) {
            C7683c cVar = this.f17724r;
            if (cVar != null) {
                cVar.mo56693b();
                this.f17724r = null;
            }
            EMUI3NavigationBarObserver.m13182a().mo56540b(this);
            NavigationBarObserver.m13231a().mo56667b(this.f17719m.f17691c);
        }
    }

    /* renamed from: H */
    private void m13193H() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (this.f17716j) {
            ImmersionBar immersionBar = this.f17714h;
            if (immersionBar == null) {
                return;
            }
            if (immersionBar.f17719m.keyboardEnable) {
                ImmersionBar immersionBar2 = this.f17714h;
                if (immersionBar2.f17724r == null) {
                    immersionBar2.f17724r = new C7683c(immersionBar2);
                }
                ImmersionBar immersionBar3 = this.f17714h;
                immersionBar3.f17724r.mo56692a(immersionBar3.f17719m.keyboardMode);
                return;
            }
            C7683c cVar = this.f17714h.f17724r;
            if (cVar != null) {
                cVar.mo56691a();
            }
        } else if (this.f17719m.keyboardEnable) {
            if (this.f17724r == null) {
                this.f17724r = new C7683c(this);
            }
            this.f17724r.mo56692a(this.f17719m.keyboardMode);
        } else {
            C7683c cVar2 = this.f17724r;
            if (cVar2 != null) {
                cVar2.mo56691a();
            }
        }
    }

    public BarParams getBarParams() {
        return this.f17719m;
    }

    /* renamed from: a */
    private void m13197a(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.f17713g;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
        }
        this.f17730x = i;
        this.f17731y = i2;
        this.f17732z = i3;
        this.f17706A = i4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo56575d() {
        return this.f17730x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo56576e() {
        return this.f17731y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo56577f() {
        return this.f17732z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo56588g() {
        return this.f17706A;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public Activity mo56591h() {
        return this.f17707a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Window mo56593i() {
        return this.f17711e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public Fragment mo56595j() {
        return this.f17708b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public android.app.Fragment mo56596k() {
        return this.f17709c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo56600l() {
        return this.f17716j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo56601m() {
        return this.f17717k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo56602n() {
        return this.f17727u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public C7681a mo56621o() {
        if (this.f17720n == null) {
            this.f17720n = new C7681a(this.f17707a);
        }
        return this.f17720n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public int mo56623p() {
        return this.f17723q;
    }

    public static boolean isSupportStatusBarDarkFont() {
        return OSUtils.isMIUI6Later() || OSUtils.isFlymeOS4Later() || Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportNavigationIconDark() {
        return OSUtils.isMIUI6Later() || Build.VERSION.SDK_INT >= 26;
    }

    public static void setTitleBar(Activity activity, final int i, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 19 && activity != null) {
            if (i < 0) {
                i = 0;
            }
            for (final View view : viewArr) {
                if (view != null) {
                    final Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i));
                        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, -2);
                        }
                        if (layoutParams.height == -2 || layoutParams.height == -1) {
                            view.post(new Runnable() {
                                public void run() {
                                    layoutParams.height = (view.getHeight() + i) - num.intValue();
                                    View view = view;
                                    view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                                    view.setLayoutParams(layoutParams);
                                }
                            });
                        } else {
                            layoutParams.height += i - num.intValue();
                            view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                            view.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        }
    }

    public static void setTitleBar(Activity activity, View... viewArr) {
        setTitleBar(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setTitleBar(Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setTitleBar((Activity) fragment.getActivity(), i, viewArr);
        }
    }

    public static void setTitleBar(Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBar((Activity) fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBar(android.app.Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setTitleBar(fragment.getActivity(), i, viewArr);
        }
    }

    public static void setTitleBar(android.app.Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBar(fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBarMarginTop(Activity activity, int i, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 19 && activity != null) {
            if (i < 0) {
                i = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i));
                        Object layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        view.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }

    public static void setTitleBarMarginTop(Activity activity, View... viewArr) {
        setTitleBarMarginTop(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setTitleBarMarginTop(Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop((Activity) fragment.getActivity(), i, viewArr);
        }
    }

    public static void setTitleBarMarginTop(Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop((Activity) fragment.getActivity(), viewArr);
        }
    }

    public static void setTitleBarMarginTop(android.app.Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop(fragment.getActivity(), i, viewArr);
        }
    }

    public static void setTitleBarMarginTop(android.app.Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setTitleBarMarginTop(fragment.getActivity(), viewArr);
        }
    }

    public static void setStatusBarView(Activity activity, int i, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 19 && activity != null) {
            if (i < 0) {
                i = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() != i) {
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i));
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-1, 0);
                        }
                        layoutParams.height = i;
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public static void setStatusBarView(Activity activity, View... viewArr) {
        setStatusBarView(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setStatusBarView(Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setStatusBarView((Activity) fragment.getActivity(), i, viewArr);
        }
    }

    public static void setStatusBarView(Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setStatusBarView((Activity) fragment.getActivity(), viewArr);
        }
    }

    public static void setStatusBarView(android.app.Fragment fragment, int i, View... viewArr) {
        if (fragment != null) {
            setStatusBarView(fragment.getActivity(), i, viewArr);
        }
    }

    public static void setStatusBarView(android.app.Fragment fragment, View... viewArr) {
        if (fragment != null) {
            setStatusBarView(fragment.getActivity(), viewArr);
        }
    }

    public static void setFitsSystemWindows(Activity activity, boolean z) {
        if (activity != null) {
            m13198a(((ViewGroup) activity.findViewById(16908290)).getChildAt(0), z);
        }
    }

    public static void setFitsSystemWindows(Activity activity) {
        setFitsSystemWindows(activity, true);
    }

    public static void setFitsSystemWindows(Fragment fragment, boolean z) {
        if (fragment != null) {
            setFitsSystemWindows((Activity) fragment.getActivity(), z);
        }
    }

    public static void setFitsSystemWindows(Fragment fragment) {
        if (fragment != null) {
            setFitsSystemWindows((Activity) fragment.getActivity());
        }
    }

    public static void setFitsSystemWindows(android.app.Fragment fragment, boolean z) {
        if (fragment != null) {
            setFitsSystemWindows(fragment.getActivity(), z);
        }
    }

    public static void setFitsSystemWindows(android.app.Fragment fragment) {
        if (fragment != null) {
            setFitsSystemWindows(fragment.getActivity());
        }
    }

    /* renamed from: a */
    private static void m13198a(View view, boolean z) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup instanceof DrawerLayout) {
                    m13198a(viewGroup.getChildAt(0), z);
                    return;
                }
                viewGroup.setFitsSystemWindows(z);
                viewGroup.setClipToPadding(true);
                return;
            }
            view.setFitsSystemWindows(z);
        }
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (((childAt instanceof DrawerLayout) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasNavigationBar(Activity activity) {
        return new C7681a(activity).mo56688d();
    }

    public static boolean hasNavigationBar(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar((Activity) fragment.getActivity());
    }

    public static boolean hasNavigationBar(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar(fragment.getActivity());
    }

    public static int getNavigationBarHeight(Activity activity) {
        return new C7681a(activity).mo56689e();
    }

    public static int getNavigationBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight((Activity) fragment.getActivity());
    }

    public static int getNavigationBarHeight(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight(fragment.getActivity());
    }

    public static int getNavigationBarWidth(Activity activity) {
        return new C7681a(activity).mo56690f();
    }

    public static int getNavigationBarWidth(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth((Activity) fragment.getActivity());
    }

    public static int getNavigationBarWidth(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth(fragment.getActivity());
    }

    public static boolean isNavigationAtBottom(Activity activity) {
        return new C7681a(activity).mo56685a();
    }

    public static boolean isNavigationAtBottom(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom((Activity) fragment.getActivity());
    }

    public static boolean isNavigationAtBottom(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom(fragment.getActivity());
    }

    public static int getStatusBarHeight(Activity activity) {
        return new C7681a(activity).mo56686b();
    }

    public static int getStatusBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight((Activity) fragment.getActivity());
    }

    public static int getStatusBarHeight(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight(fragment.getActivity());
    }

    public static int getActionBarHeight(Activity activity) {
        return new C7681a(activity).mo56687c();
    }

    public static int getActionBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight((Activity) fragment.getActivity());
    }

    public static int getActionBarHeight(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight(fragment.getActivity());
    }

    public static boolean hasNotchScreen(Activity activity) {
        return NotchUtils.hasNotchScreen(activity);
    }

    public static boolean hasNotchScreen(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen((Activity) fragment.getActivity());
    }

    public static boolean hasNotchScreen(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen(fragment.getActivity());
    }

    public static boolean hasNotchScreen(View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static int getNotchHeight(Activity activity) {
        if (hasNotchScreen(activity)) {
            return NotchUtils.getNotchHeight(activity);
        }
        return 0;
    }

    public static int getNotchHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight((Activity) fragment.getActivity());
    }

    public static int getNotchHeight(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight(fragment.getActivity());
    }

    public static void hideStatusBar(Window window) {
        window.setFlags(1024, 1024);
    }

    public static void showStatusBar(Window window) {
        window.clearFlags(1024);
    }

    ImmersionBar(Activity activity) {
        this.f17715i = false;
        this.f17716j = false;
        this.f17717k = false;
        this.f17718l = false;
        this.f17721o = 0;
        this.f17722p = 0;
        this.f17723q = 0;
        this.f17724r = null;
        this.f17725s = new HashMap();
        this.f17726t = 0;
        this.f17727u = false;
        this.f17728v = false;
        this.f17729w = false;
        this.f17730x = 0;
        this.f17731y = 0;
        this.f17732z = 0;
        this.f17706A = 0;
        this.f17715i = true;
        this.f17707a = activity;
        m13199a(activity.getWindow());
    }

    ImmersionBar(Fragment fragment) {
        this.f17715i = false;
        this.f17716j = false;
        this.f17717k = false;
        this.f17718l = false;
        this.f17721o = 0;
        this.f17722p = 0;
        this.f17723q = 0;
        this.f17724r = null;
        this.f17725s = new HashMap();
        this.f17726t = 0;
        this.f17727u = false;
        this.f17728v = false;
        this.f17729w = false;
        this.f17730x = 0;
        this.f17731y = 0;
        this.f17732z = 0;
        this.f17706A = 0;
        this.f17716j = true;
        this.f17707a = fragment.getActivity();
        this.f17708b = fragment;
        m13194I();
        m13199a(this.f17707a.getWindow());
    }

    ImmersionBar(android.app.Fragment fragment) {
        this.f17715i = false;
        this.f17716j = false;
        this.f17717k = false;
        this.f17718l = false;
        this.f17721o = 0;
        this.f17722p = 0;
        this.f17723q = 0;
        this.f17724r = null;
        this.f17725s = new HashMap();
        this.f17726t = 0;
        this.f17727u = false;
        this.f17728v = false;
        this.f17729w = false;
        this.f17730x = 0;
        this.f17731y = 0;
        this.f17732z = 0;
        this.f17706A = 0;
        this.f17716j = true;
        this.f17707a = fragment.getActivity();
        this.f17709c = fragment;
        m13194I();
        m13199a(this.f17707a.getWindow());
    }

    ImmersionBar(DialogFragment dialogFragment) {
        this.f17715i = false;
        this.f17716j = false;
        this.f17717k = false;
        this.f17718l = false;
        this.f17721o = 0;
        this.f17722p = 0;
        this.f17723q = 0;
        this.f17724r = null;
        this.f17725s = new HashMap();
        this.f17726t = 0;
        this.f17727u = false;
        this.f17728v = false;
        this.f17729w = false;
        this.f17730x = 0;
        this.f17731y = 0;
        this.f17732z = 0;
        this.f17706A = 0;
        this.f17718l = true;
        this.f17717k = true;
        this.f17707a = dialogFragment.getActivity();
        this.f17708b = dialogFragment;
        this.f17710d = dialogFragment.getDialog();
        m13194I();
        m13199a(this.f17710d.getWindow());
    }

    ImmersionBar(android.app.DialogFragment dialogFragment) {
        this.f17715i = false;
        this.f17716j = false;
        this.f17717k = false;
        this.f17718l = false;
        this.f17721o = 0;
        this.f17722p = 0;
        this.f17723q = 0;
        this.f17724r = null;
        this.f17725s = new HashMap();
        this.f17726t = 0;
        this.f17727u = false;
        this.f17728v = false;
        this.f17729w = false;
        this.f17730x = 0;
        this.f17731y = 0;
        this.f17732z = 0;
        this.f17706A = 0;
        this.f17718l = true;
        this.f17717k = true;
        this.f17707a = dialogFragment.getActivity();
        this.f17709c = dialogFragment;
        this.f17710d = dialogFragment.getDialog();
        m13194I();
        m13199a(this.f17710d.getWindow());
    }

    ImmersionBar(Activity activity, Dialog dialog) {
        this.f17715i = false;
        this.f17716j = false;
        this.f17717k = false;
        this.f17718l = false;
        this.f17721o = 0;
        this.f17722p = 0;
        this.f17723q = 0;
        this.f17724r = null;
        this.f17725s = new HashMap();
        this.f17726t = 0;
        this.f17727u = false;
        this.f17728v = false;
        this.f17729w = false;
        this.f17730x = 0;
        this.f17731y = 0;
        this.f17732z = 0;
        this.f17706A = 0;
        this.f17718l = true;
        this.f17707a = activity;
        this.f17710d = dialog;
        m13194I();
        m13199a(this.f17710d.getWindow());
    }

    /* renamed from: I */
    private void m13194I() {
        if (this.f17714h == null) {
            this.f17714h = with(this.f17707a);
        }
        ImmersionBar immersionBar = this.f17714h;
        if (immersionBar != null && !immersionBar.f17727u) {
            immersionBar.init();
        }
    }

    /* renamed from: a */
    private void m13199a(Window window) {
        this.f17711e = window;
        this.f17719m = new BarParams();
        ViewGroup viewGroup = (ViewGroup) this.f17711e.getDecorView();
        this.f17712f = viewGroup;
        this.f17713g = (ViewGroup) viewGroup.findViewById(16908290);
    }

    public ImmersionBar transparentStatusBar() {
        this.f17719m.statusBarColor = 0;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        this.f17719m.navigationBarColor = 0;
        this.f17719m.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentBar() {
        this.f17719m.statusBarColor = 0;
        this.f17719m.navigationBarColor = 0;
        this.f17719m.fullScreen = true;
        return this;
    }

    public ImmersionBar statusBarColor(int i) {
        return statusBarColorInt(ContextCompat.getColor(this.f17707a, i));
    }

    public ImmersionBar statusBarColor(int i, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.f17707a, i), f);
    }

    public ImmersionBar statusBarColor(int i, int i2, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.f17707a, i), ContextCompat.getColor(this.f17707a, i2), f);
    }

    public ImmersionBar statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(String str, float f) {
        return statusBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar statusBarColor(String str, String str2, float f) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar statusBarColorInt(int i) {
        this.f17719m.statusBarColor = i;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, float f) {
        this.f17719m.statusBarColor = i;
        this.f17719m.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, int i2, float f) {
        this.f17719m.statusBarColor = i;
        this.f17719m.statusBarColorTransform = i2;
        this.f17719m.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColor(int i) {
        return navigationBarColorInt(ContextCompat.getColor(this.f17707a, i));
    }

    public ImmersionBar navigationBarColor(int i, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.f17707a, i), f);
    }

    public ImmersionBar navigationBarColor(int i, int i2, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.f17707a, i), ContextCompat.getColor(this.f17707a, i2), f);
    }

    public ImmersionBar navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColor(String str, float f) {
        return navigationBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar navigationBarColor(String str, String str2, float f) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar navigationBarColorInt(int i) {
        this.f17719m.navigationBarColor = i;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, float f) {
        this.f17719m.navigationBarColor = i;
        this.f17719m.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, int i2, float f) {
        this.f17719m.navigationBarColor = i;
        this.f17719m.navigationBarColorTransform = i2;
        this.f17719m.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColor(int i) {
        return barColorInt(ContextCompat.getColor(this.f17707a, i));
    }

    public ImmersionBar barColor(int i, float f) {
        return barColorInt(ContextCompat.getColor(this.f17707a, i), (float) i);
    }

    public ImmersionBar barColor(int i, int i2, float f) {
        return barColorInt(ContextCompat.getColor(this.f17707a, i), ContextCompat.getColor(this.f17707a, i2), f);
    }

    public ImmersionBar barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public ImmersionBar barColor(String str, float f) {
        return barColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar barColor(String str, String str2, float f) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar barColorInt(int i) {
        this.f17719m.statusBarColor = i;
        this.f17719m.navigationBarColor = i;
        return this;
    }

    public ImmersionBar barColorInt(int i, float f) {
        this.f17719m.statusBarColor = i;
        this.f17719m.navigationBarColor = i;
        this.f17719m.statusBarAlpha = f;
        this.f17719m.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColorInt(int i, int i2, float f) {
        this.f17719m.statusBarColor = i;
        this.f17719m.navigationBarColor = i;
        this.f17719m.statusBarColorTransform = i2;
        this.f17719m.navigationBarColorTransform = i2;
        this.f17719m.statusBarAlpha = f;
        this.f17719m.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int i) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.f17707a, i));
    }

    public ImmersionBar statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColorTransformInt(int i) {
        this.f17719m.statusBarColorTransform = i;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int i) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.f17707a, i));
    }

    public ImmersionBar navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColorTransformInt(int i) {
        this.f17719m.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar barColorTransform(int i) {
        return barColorTransformInt(ContextCompat.getColor(this.f17707a, i));
    }

    public ImmersionBar barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar barColorTransformInt(int i) {
        this.f17719m.statusBarColorTransform = i;
        this.f17719m.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.f17719m.statusBarColorTransform);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.f17707a, i));
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i, int i2) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.f17707a, i), ContextCompat.getColor(this.f17707a, i2));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(this.f17719m.statusBarColor), Integer.valueOf(i));
            this.f17719m.f17689a.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i, int i2) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
            this.f17719m.f17689a.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar viewAlpha(float f) {
        this.f17719m.viewAlpha = f;
        return this;
    }

    public ImmersionBar removeSupportView(View view) {
        if (view != null) {
            Map map = this.f17719m.f17689a.get(view);
            if (!(map == null || map.size() == 0)) {
                this.f17719m.f17689a.remove(view);
            }
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar removeSupportAllView() {
        if (this.f17719m.f17689a.size() != 0) {
            this.f17719m.f17689a.clear();
        }
        return this;
    }

    public ImmersionBar fullScreen(boolean z) {
        this.f17719m.fullScreen = z;
        return this;
    }

    public ImmersionBar statusBarAlpha(float f) {
        this.f17719m.statusBarAlpha = f;
        this.f17719m.statusBarTempAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float f) {
        this.f17719m.navigationBarAlpha = f;
        this.f17719m.navigationBarTempAlpha = f;
        return this;
    }

    public ImmersionBar barAlpha(float f) {
        this.f17719m.statusBarAlpha = f;
        this.f17719m.statusBarTempAlpha = f;
        this.f17719m.navigationBarAlpha = f;
        this.f17719m.navigationBarTempAlpha = f;
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean z) {
        return autoDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoDarkModeEnable(boolean z, float f) {
        this.f17719m.autoStatusBarDarkModeEnable = z;
        this.f17719m.autoStatusBarDarkModeAlpha = f;
        this.f17719m.autoNavigationBarDarkModeEnable = z;
        this.f17719m.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z) {
        return autoStatusBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z, float f) {
        this.f17719m.autoStatusBarDarkModeEnable = z;
        this.f17719m.autoStatusBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z) {
        return autoNavigationBarDarkModeEnable(z, 0.2f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z, float f) {
        this.f17719m.autoNavigationBarDarkModeEnable = z;
        this.f17719m.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z) {
        return statusBarDarkFont(z, 0.2f);
    }

    public ImmersionBar statusBarDarkFont(boolean z, float f) {
        this.f17719m.statusBarDarkFont = z;
        if (!z || isSupportStatusBarDarkFont()) {
            BarParams barParams = this.f17719m;
            barParams.flymeOSStatusBarFontColor = barParams.flymeOSStatusBarFontTempColor;
            BarParams barParams2 = this.f17719m;
            barParams2.statusBarAlpha = barParams2.statusBarTempAlpha;
        } else {
            this.f17719m.statusBarAlpha = f;
        }
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z) {
        return navigationBarDarkIcon(z, 0.2f);
    }

    public ImmersionBar navigationBarDarkIcon(boolean z, float f) {
        this.f17719m.navigationBarDarkIcon = z;
        if (!z || isSupportNavigationIconDark()) {
            BarParams barParams = this.f17719m;
            barParams.navigationBarAlpha = barParams.navigationBarTempAlpha;
        } else {
            this.f17719m.navigationBarAlpha = f;
        }
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(int i) {
        this.f17719m.flymeOSStatusBarFontColor = ContextCompat.getColor(this.f17707a, i);
        BarParams barParams = this.f17719m;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String str) {
        this.f17719m.flymeOSStatusBarFontColor = Color.parseColor(str);
        BarParams barParams = this.f17719m;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int i) {
        this.f17719m.flymeOSStatusBarFontColor = i;
        BarParams barParams = this.f17719m;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar hideBar(BarHide barHide) {
        this.f17719m.barHide = barHide;
        if (Build.VERSION.SDK_INT == 19 || OSUtils.isEMUI3_x()) {
            BarParams barParams = this.f17719m;
            barParams.hideNavigationBar = barParams.barHide == BarHide.FLAG_HIDE_NAVIGATION_BAR || this.f17719m.barHide == BarHide.FLAG_HIDE_BAR;
        }
        return this;
    }

    public ImmersionBar applySystemFits(boolean z) {
        this.f17719m.fitsLayoutOverlapEnable = !z;
        setFitsSystemWindows(this.f17707a, z);
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z) {
        this.f17719m.fits = z;
        if (!this.f17719m.fits) {
            this.f17726t = 0;
        } else if (this.f17726t == 0) {
            this.f17726t = 4;
        }
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.f17707a, i));
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i, int i2, float f) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.f17707a, i), ContextCompat.getColor(this.f17707a, i2), f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i) {
        return fitsSystemWindowsInt(z, i, -16777216, 0.0f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i, int i2, float f) {
        this.f17719m.fits = z;
        this.f17719m.contentColor = i;
        this.f17719m.contentColorTransform = i2;
        this.f17719m.contentAlpha = f;
        if (!this.f17719m.fits) {
            this.f17726t = 0;
        } else if (this.f17726t == 0) {
            this.f17726t = 4;
        }
        this.f17713g.setBackgroundColor(ColorUtils.blendARGB(this.f17719m.contentColor, this.f17719m.contentColorTransform, this.f17719m.contentAlpha));
        return this;
    }

    public ImmersionBar fitsLayoutOverlapEnable(boolean z) {
        this.f17719m.fitsLayoutOverlapEnable = z;
        return this;
    }

    public ImmersionBar statusBarView(View view) {
        if (view == null) {
            return this;
        }
        this.f17719m.statusBarView = view;
        if (this.f17726t == 0) {
            this.f17726t = 3;
        }
        return this;
    }

    public ImmersionBar statusBarView(int i) {
        return statusBarView(this.f17707a.findViewById(i));
    }

    public ImmersionBar statusBarView(int i, View view) {
        return statusBarView(view.findViewById(i));
    }

    public ImmersionBar titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public ImmersionBar titleBar(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.f17726t == 0) {
            this.f17726t = 1;
        }
        this.f17719m.titleBarView = view;
        this.f17719m.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar titleBar(int i) {
        return titleBar(i, true);
    }

    public ImmersionBar titleBar(int i, boolean z) {
        Fragment fragment = this.f17708b;
        if (fragment != null && fragment.getView() != null) {
            return titleBar(this.f17708b.getView().findViewById(i), z);
        }
        android.app.Fragment fragment2 = this.f17709c;
        if (fragment2 == null || fragment2.getView() == null) {
            return titleBar(this.f17707a.findViewById(i), z);
        }
        return titleBar(this.f17709c.getView().findViewById(i), z);
    }

    public ImmersionBar titleBar(int i, View view) {
        return titleBar(view.findViewById(i), true);
    }

    public ImmersionBar titleBar(int i, View view, boolean z) {
        return titleBar(view.findViewById(i), z);
    }

    public ImmersionBar titleBarMarginTop(int i) {
        Fragment fragment = this.f17708b;
        if (fragment != null && fragment.getView() != null) {
            return titleBarMarginTop(this.f17708b.getView().findViewById(i));
        }
        android.app.Fragment fragment2 = this.f17709c;
        if (fragment2 == null || fragment2.getView() == null) {
            return titleBarMarginTop(this.f17707a.findViewById(i));
        }
        return titleBarMarginTop(this.f17709c.getView().findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(int i, View view) {
        return titleBarMarginTop(view.findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.f17726t == 0) {
            this.f17726t = 2;
        }
        this.f17719m.titleBarView = view;
        return this;
    }

    public ImmersionBar supportActionBar(boolean z) {
        this.f17719m.isSupportActionBar = z;
        return this;
    }

    public ImmersionBar statusBarColorTransformEnable(boolean z) {
        this.f17719m.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar reset() {
        this.f17719m = new BarParams();
        this.f17726t = 0;
        return this;
    }

    public ImmersionBar addTag(String str) {
        if (!m13200a(str)) {
            this.f17725s.put(str, this.f17719m.clone());
            return this;
        }
        throw new IllegalArgumentException("tag不能为空");
    }

    public ImmersionBar getTag(String str) {
        if (!m13200a(str)) {
            BarParams barParams = this.f17725s.get(str);
            if (barParams != null) {
                this.f17719m = barParams.clone();
            }
            return this;
        }
        throw new IllegalArgumentException("tag不能为空");
    }

    public ImmersionBar keyboardEnable(boolean z) {
        return keyboardEnable(z, this.f17719m.keyboardMode);
    }

    public ImmersionBar keyboardEnable(boolean z, int i) {
        this.f17719m.keyboardEnable = z;
        this.f17719m.keyboardMode = i;
        this.f17729w = z;
        return this;
    }

    public ImmersionBar keyboardMode(int i) {
        this.f17719m.keyboardMode = i;
        return this;
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        if (this.f17719m.f17690b == null) {
            this.f17719m.f17690b = onKeyboardListener;
        }
        return this;
    }

    public ImmersionBar setOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            if (this.f17719m.f17691c == null) {
                this.f17719m.f17691c = onNavigationBarListener;
                NavigationBarObserver.m13231a().mo56666a(this.f17719m.f17691c);
            }
        } else if (this.f17719m.f17691c != null) {
            NavigationBarObserver.m13231a().mo56667b(this.f17719m.f17691c);
            this.f17719m.f17691c = null;
        }
        return this;
    }

    public ImmersionBar setOnBarListener(OnBarListener onBarListener) {
        if (onBarListener != null) {
            if (this.f17719m.f17692d == null) {
                this.f17719m.f17692d = onBarListener;
            }
        } else if (this.f17719m.f17692d != null) {
            this.f17719m.f17692d = null;
        }
        return this;
    }

    public ImmersionBar navigationBarEnable(boolean z) {
        this.f17719m.navigationBarEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean z) {
        this.f17719m.navigationBarWithKitkatEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean z) {
        if (OSUtils.isEMUI3_x()) {
            this.f17719m.navigationBarWithEMUI3Enable = z;
            this.f17719m.navigationBarWithKitkatEnable = z;
        }
        return this;
    }

    public ImmersionBar barEnable(boolean z) {
        this.f17719m.barEnable = z;
        return this;
    }

    /* renamed from: J */
    private static RequestManagerRetriever m13195J() {
        return RequestManagerRetriever.m13249a();
    }

    /* renamed from: a */
    private static boolean m13200a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
