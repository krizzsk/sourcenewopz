package com.didi.beatles.p099im.module.impl;

import com.didi.beatles.p099im.module.IIMGlobalModule;
import com.didi.beatles.p099im.module.IIMMessageModule;
import com.didi.beatles.p099im.module.IIMSessionModule;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMErrorCallback;
import com.didi.beatles.p099im.service.IMServiceProvider;

/* renamed from: com.didi.beatles.im.module.impl.IMModelProvider */
public class IMModelProvider {

    /* renamed from: a */
    private IMMessageModule f9318a;

    /* renamed from: b */
    private IMSessionModule f9319b;

    /* renamed from: c */
    private IMUserModule f9320c;

    /* renamed from: d */
    private IMGlobalModule f9321d;

    /* renamed from: e */
    private IMServiceProvider f9322e;

    /* renamed from: f */
    private IMErrorCallback f9323f;

    private IMModelProvider() {
    }

    public static IMModelProvider getInstance() {
        return Holder.INSTANCE;
    }

    public void init(IMServiceProvider iMServiceProvider) {
        this.f9322e = iMServiceProvider;
        if (this.f9318a == null) {
            IMMessageModule iMMessageModule = new IMMessageModule(this);
            this.f9318a = iMMessageModule;
            iMMessageModule.onStart();
        }
        if (this.f9319b == null) {
            IMSessionModule iMSessionModule = new IMSessionModule(this);
            this.f9319b = iMSessionModule;
            iMSessionModule.onStart();
        }
        if (this.f9320c == null) {
            IMUserModule iMUserModule = new IMUserModule(this);
            this.f9320c = iMUserModule;
            iMUserModule.onStart();
        }
        if (this.f9321d == null) {
            IMGlobalModule iMGlobalModule = new IMGlobalModule(this);
            this.f9321d = iMGlobalModule;
            iMGlobalModule.onStart();
        }
    }

    public void destroy() {
        synchronized (this) {
            if (this.f9318a != null) {
                this.f9318a.onStop();
                this.f9318a = null;
            }
            if (this.f9319b != null) {
                this.f9319b.onStop();
                this.f9319b = null;
            }
            if (this.f9320c != null) {
                this.f9320c.onStop();
                this.f9320c = null;
            }
            if (this.f9321d != null) {
                this.f9321d.onStop();
                this.f9321d = null;
            }
        }
    }

    public IMServiceProvider getIMServiceProvider() {
        return this.f9322e;
    }

    public IIMMessageModule getMessageModule() {
        return this.f9318a;
    }

    public IIMUserModule getUserModule() {
        return this.f9320c;
    }

    public IIMSessionModule getSessionModule() {
        return this.f9319b;
    }

    public IIMGlobalModule getGlobalModule() {
        return this.f9321d;
    }

    public void registerErrorCallback(IMErrorCallback iMErrorCallback) {
        this.f9323f = iMErrorCallback;
    }

    public void unregisterErrorCallback() {
        this.f9323f = null;
    }

    public IMErrorCallback getErrorCallback() {
        return this.f9323f;
    }

    /* renamed from: com.didi.beatles.im.module.impl.IMModelProvider$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMModelProvider INSTANCE = new IMModelProvider();

        private Holder() {
        }
    }
}
