package com.didi.app.nova.skeleton.conductor;

import android.os.Bundle;
import com.didi.app.nova.skeleton.conductor.internal.TransactionIndexer;

public class RouterTransaction {

    /* renamed from: c */
    private static int f8338c = -1;

    /* renamed from: d */
    private static final String f8339d = "RouterTransaction.controller.bundle";

    /* renamed from: e */
    private static final String f8340e = "RouterTransaction.pushControllerChangeHandler";

    /* renamed from: f */
    private static final String f8341f = "RouterTransaction.popControllerChangeHandler";

    /* renamed from: g */
    private static final String f8342g = "RouterTransaction.tag";

    /* renamed from: h */
    private static final String f8343h = "RouterTransaction.transactionIndex";

    /* renamed from: i */
    private static final String f8344i = "RouterTransaction.attachedToRouter";

    /* renamed from: a */
    final Controller f8345a;

    /* renamed from: b */
    int f8346b = f8338c;

    /* renamed from: j */
    private String f8347j;

    /* renamed from: k */
    private String f8348k;

    /* renamed from: l */
    private ControllerChangeHandler f8349l;

    /* renamed from: m */
    private ControllerChangeHandler f8350m;

    /* renamed from: n */
    private boolean f8351n;

    public static RouterTransaction with(Controller controller) {
        return new RouterTransaction(controller);
    }

    private RouterTransaction(Controller controller) {
        this.f8345a = controller;
    }

    RouterTransaction(Bundle bundle) {
        this.f8345a = Controller.m5452a(bundle.getBundle(f8339d));
        this.f8349l = ControllerChangeHandler.fromBundle(bundle.getBundle(f8340e));
        this.f8350m = ControllerChangeHandler.fromBundle(bundle.getBundle(f8341f));
        this.f8347j = bundle.getString(f8342g);
        this.f8346b = bundle.getInt(f8343h);
        this.f8351n = bundle.getBoolean(f8344i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40758a() {
        this.f8351n = true;
    }

    public Controller controller() {
        return this.f8345a;
    }

    public String tag() {
        return this.f8347j;
    }

    public RouterTransaction tag(String str) {
        if (!this.f8351n) {
            this.f8347j = str;
            return this;
        }
        throw new RuntimeException(getClass().getSimpleName() + "s can not be modified after being added to a Router.");
    }

    public String pageName() {
        return this.f8348k;
    }

    public RouterTransaction pageName(String str) {
        if (!this.f8351n) {
            this.f8348k = str;
            return this;
        }
        throw new RuntimeException(getClass().getSimpleName() + "s can not be modified after being added to a Router.");
    }

    public ControllerChangeHandler pushChangeHandler() {
        ControllerChangeHandler overriddenPushHandler = this.f8345a.getOverriddenPushHandler();
        return overriddenPushHandler == null ? this.f8349l : overriddenPushHandler;
    }

    public RouterTransaction pushChangeHandler(ControllerChangeHandler controllerChangeHandler) {
        if (!this.f8351n) {
            this.f8349l = controllerChangeHandler;
            return this;
        }
        throw new RuntimeException(getClass().getSimpleName() + "s can not be modified after being added to a Router.");
    }

    public ControllerChangeHandler popChangeHandler() {
        ControllerChangeHandler overriddenPopHandler = this.f8345a.getOverriddenPopHandler();
        return overriddenPopHandler == null ? this.f8350m : overriddenPopHandler;
    }

    public RouterTransaction popChangeHandler(ControllerChangeHandler controllerChangeHandler) {
        if (!this.f8351n) {
            this.f8350m = controllerChangeHandler;
            return this;
        }
        throw new RuntimeException(getClass().getSimpleName() + "s can not be modified after being added to a Router.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40759a(TransactionIndexer transactionIndexer) {
        if (transactionIndexer == null) {
            throw new RuntimeException();
        } else if (this.f8346b == f8338c && transactionIndexer != null) {
            this.f8346b = transactionIndexer.nextIndex();
        }
    }

    public Bundle saveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putBundle(f8339d, this.f8345a.mo40610e());
        ControllerChangeHandler controllerChangeHandler = this.f8349l;
        if (controllerChangeHandler != null) {
            bundle.putBundle(f8340e, controllerChangeHandler.mo40698a());
        }
        ControllerChangeHandler controllerChangeHandler2 = this.f8350m;
        if (controllerChangeHandler2 != null) {
            bundle.putBundle(f8341f, controllerChangeHandler2.mo40698a());
        }
        bundle.putString(f8342g, this.f8347j);
        bundle.putInt(f8343h, this.f8346b);
        bundle.putBoolean(f8344i, this.f8351n);
        return bundle;
    }
}
