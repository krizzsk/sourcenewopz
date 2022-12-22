package com.didi.app.nova.skeleton.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.UUID;

public abstract class Dialog {

    /* renamed from: a */
    private View f8422a;

    /* renamed from: b */
    private boolean f8423b;

    /* renamed from: c */
    private boolean f8424c = false;

    /* renamed from: d */
    private DialogInstrument f8425d;

    /* renamed from: e */
    private String f8426e = UUID.randomUUID().toString();

    /* renamed from: f */
    private boolean f8427f = true;

    public abstract TransformAnimation getEnterAnimation();

    public abstract TransformAnimation getExitAnimation();

    public abstract View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public abstract void onDestroy();

    public abstract void onDismiss();

    public boolean onHandleBack() {
        return false;
    }

    public abstract void onShow();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40886a(DialogInstrument dialogInstrument) {
        this.f8425d = dialogInstrument;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo40885a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.f8422a == null) {
            View onCreate = onCreate(layoutInflater, viewGroup);
            this.f8422a = onCreate;
            if (onCreate == null) {
                throw new IllegalStateException("Dialog's onCreateView method returned Null.");
            } else if (onCreate == viewGroup) {
                throw new IllegalStateException("Don't set attachToRoot = true");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo40884a() {
        return this.f8426e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo40887b() {
        this.f8424c = true;
        onShow();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo40889c() {
        this.f8424c = false;
        onDismiss();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo40890d() {
        if (!this.f8423b) {
            onDestroy();
        }
        this.f8423b = true;
        this.f8422a = null;
        this.f8425d = null;
    }

    public final boolean isCancelable() {
        return this.f8427f;
    }

    public final void setCancelable(boolean z) {
        this.f8427f = z;
    }

    public final boolean isAttached() {
        return this.f8424c;
    }

    public final boolean isDestroyed() {
        return this.f8423b;
    }

    public final View getView() {
        return this.f8422a;
    }

    public final void show(PageInstrument pageInstrument, String str) {
        show(pageInstrument.getDialogInstrument(), str);
    }

    public final void show(DialogInstrument dialogInstrument, String str) {
        if (dialogInstrument == null) {
            TraceUtil.trace("Dialog", "call PageInstrument.attachDialogFragment() first, or activity is destroyed.");
        } else {
            dialogInstrument.mo40909a(C3727a.m5630a(this).mo40921a(str));
        }
    }

    public final void dismiss() {
        DialogInstrument dialogInstrument = this.f8425d;
        if (dialogInstrument == null) {
            TraceUtil.trace("Dialog", this + " isn't in dialog stack.");
            return;
        }
        dialogInstrument.mo40908a(this);
    }

    public final void bind(ScopeContext scopeContext) {
        if (scopeContext.getLiveHandler().isDestroyed()) {
            dismiss();
        } else {
            scopeContext.addObserver(new IScopeLifecycle() {
                public void onCreate(ILive iLive) {
                }

                public void onPause(ILive iLive) {
                }

                public void onResume(ILive iLive) {
                }

                public void onStart(ILive iLive) {
                }

                public void onStop(ILive iLive) {
                }

                public void onDestroy(ILive iLive) {
                    Dialog.this.dismiss();
                }
            });
        }
    }
}
