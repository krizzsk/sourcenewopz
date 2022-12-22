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

/* renamed from: com.didi.dimina.container.ui.statusbar.EMUI3NavigationBarObserver */
final class EMUI3NavigationBarObserver extends ContentObserver {

    /* renamed from: a */
    private ArrayList<C7684d> f17703a;

    /* renamed from: b */
    private Application f17704b;

    /* renamed from: c */
    private Boolean f17705c;

    /* renamed from: a */
    static EMUI3NavigationBarObserver m13182a() {
        return NavigationBarObserverInstance.INSTANCE;
    }

    private EMUI3NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.f17705c = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56538a(Application application) {
        Application application2;
        Uri uriFor;
        this.f17704b = application;
        if (Build.VERSION.SDK_INT >= 17 && (application2 = this.f17704b) != null && application2.getContentResolver() != null && !this.f17705c.booleanValue() && (uriFor = Settings.System.getUriFor("navigationbar_is_min")) != null) {
            this.f17704b.getContentResolver().registerContentObserver(uriFor, true, this);
            this.f17705c = true;
        }
    }

    public void onChange(boolean z) {
        Application application;
        ArrayList<C7684d> arrayList;
        super.onChange(z);
        if (Build.VERSION.SDK_INT >= 17 && (application = this.f17704b) != null && application.getContentResolver() != null && (arrayList = this.f17703a) != null && !arrayList.isEmpty()) {
            int i = Settings.System.getInt(this.f17704b.getContentResolver(), "navigationbar_is_min", 0);
            Iterator<C7684d> it = this.f17703a.iterator();
            while (it.hasNext()) {
                C7684d next = it.next();
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
    public void mo56539a(C7684d dVar) {
        if (dVar != null) {
            if (this.f17703a == null) {
                this.f17703a = new ArrayList<>();
            }
            if (!this.f17703a.contains(dVar)) {
                this.f17703a.add(dVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo56540b(C7684d dVar) {
        ArrayList<C7684d> arrayList;
        if (dVar != null && (arrayList = this.f17703a) != null) {
            arrayList.remove(dVar);
        }
    }

    /* renamed from: com.didi.dimina.container.ui.statusbar.EMUI3NavigationBarObserver$NavigationBarObserverInstance */
    private static class NavigationBarObserverInstance {
        /* access modifiers changed from: private */
        public static final EMUI3NavigationBarObserver INSTANCE = new EMUI3NavigationBarObserver();

        private NavigationBarObserverInstance() {
        }
    }
}
