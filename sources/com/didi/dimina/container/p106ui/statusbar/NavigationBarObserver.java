package com.didi.dimina.container.p106ui.statusbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.didi.dimina.container.ui.statusbar.NavigationBarObserver */
final class NavigationBarObserver extends ContentObserver {

    /* renamed from: a */
    private ArrayList<OnNavigationBarListener> f17733a;

    /* renamed from: b */
    private Application f17734b;

    /* renamed from: c */
    private Boolean f17735c;

    /* renamed from: a */
    static NavigationBarObserver m13231a() {
        return NavigationBarObserverInstance.INSTANCE;
    }

    private NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.f17735c = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56665a(Application application) {
        Application application2;
        this.f17734b = application;
        if (Build.VERSION.SDK_INT >= 17 && (application2 = this.f17734b) != null && application2.getContentResolver() != null && !this.f17735c.booleanValue()) {
            Uri uri = null;
            if (OSUtils.isMIUI()) {
                uri = Settings.Global.getUriFor("force_fsg_nav_bar");
            } else if (OSUtils.isEMUI()) {
                if (OSUtils.isEMUI3_x() || Build.VERSION.SDK_INT < 21) {
                    uri = Settings.System.getUriFor("navigationbar_is_min");
                } else {
                    uri = Settings.Global.getUriFor("navigationbar_is_min");
                }
            }
            if (uri != null) {
                this.f17734b.getContentResolver().registerContentObserver(uri, true, this);
                this.f17735c = true;
            }
        }
    }

    public void onChange(boolean z) {
        Application application;
        ArrayList<OnNavigationBarListener> arrayList;
        int i;
        super.onChange(z);
        if (Build.VERSION.SDK_INT >= 17 && (application = this.f17734b) != null && application.getContentResolver() != null && (arrayList = this.f17733a) != null && !arrayList.isEmpty()) {
            if (OSUtils.isMIUI()) {
                i = Settings.Global.getInt(this.f17734b.getContentResolver(), "force_fsg_nav_bar", 0);
            } else {
                i = OSUtils.isEMUI() ? (OSUtils.isEMUI3_x() || Build.VERSION.SDK_INT < 21) ? Settings.System.getInt(this.f17734b.getContentResolver(), "navigationbar_is_min", 0) : Settings.Global.getInt(this.f17734b.getContentResolver(), "navigationbar_is_min", 0) : 0;
            }
            Iterator<OnNavigationBarListener> it = this.f17733a.iterator();
            while (it.hasNext()) {
                OnNavigationBarListener next = it.next();
                boolean z2 = true;
                if (i == 1) {
                    z2 = false;
                }
                next.onNavigationBarChange(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56666a(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            if (this.f17733a == null) {
                this.f17733a = new ArrayList<>();
            }
            if (!this.f17733a.contains(onNavigationBarListener)) {
                this.f17733a.add(onNavigationBarListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo56667b(OnNavigationBarListener onNavigationBarListener) {
        ArrayList<OnNavigationBarListener> arrayList;
        if (onNavigationBarListener != null && (arrayList = this.f17733a) != null) {
            arrayList.remove(onNavigationBarListener);
        }
    }

    /* renamed from: com.didi.dimina.container.ui.statusbar.NavigationBarObserver$NavigationBarObserverInstance */
    private static class NavigationBarObserverInstance {
        /* access modifiers changed from: private */
        public static final NavigationBarObserver INSTANCE = new NavigationBarObserver();

        private NavigationBarObserverInstance() {
        }
    }
}
