package com.didi.rfusion.widget.floating;

import android.os.Bundle;
import android.os.Handler;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.dialog.Dialog;
import java.io.Serializable;

class RFFloatingControllerProxy implements Serializable {
    private static final long serialVersionUID = -1439007860836023060L;
    private final transient C11557a controller;
    private final transient RFFloating floating;
    private int floatingId;
    private final transient Handler mHandler = new Handler();

    RFFloatingControllerProxy(RFFloating rFFloating, C11557a aVar, int i) {
        this.controller = aVar;
        this.floating = rFFloating;
        this.floatingId = i;
    }

    /* access modifiers changed from: package-private */
    public void setGestureEnable(boolean z) {
        this.controller.mo87892a(this.floatingId, z);
    }

    public /* synthetic */ void lambda$setShowBackground$0$RFFloatingControllerProxy(boolean z) {
        this.floating.setShowBackground(z);
    }

    /* access modifiers changed from: package-private */
    public void setShowBackground(boolean z) {
        this.mHandler.post(new Runnable(z) {
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RFFloatingControllerProxy.this.lambda$setShowBackground$0$RFFloatingControllerProxy(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$pushPage$1$RFFloatingControllerProxy(Page page, int i) {
        this.floating.pushPage(page, i);
    }

    /* access modifiers changed from: package-private */
    public void pushPage(Page page, int i) {
        this.mHandler.post(new Runnable(page, i) {
            public final /* synthetic */ Page f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                RFFloatingControllerProxy.this.lambda$pushPage$1$RFFloatingControllerProxy(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$pushOuter$2$RFFloatingControllerProxy(Page page) {
        this.floating.push(page);
    }

    /* access modifiers changed from: package-private */
    public void pushOuter(Page page) {
        this.mHandler.post(new Runnable(page) {
            public final /* synthetic */ Page f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RFFloatingControllerProxy.this.lambda$pushOuter$2$RFFloatingControllerProxy(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$pushOuter$3$RFFloatingControllerProxy(Dialog dialog, String str) {
        this.floating.getScopeContext().getNavigator().showDialog(dialog, str);
    }

    /* access modifiers changed from: package-private */
    public void pushOuter(Dialog dialog, String str) {
        this.mHandler.post(new Runnable(dialog, str) {
            public final /* synthetic */ Dialog f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                RFFloatingControllerProxy.this.lambda$pushOuter$3$RFFloatingControllerProxy(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void dismiss() {
        Handler handler = this.mHandler;
        RFFloating rFFloating = this.floating;
        rFFloating.getClass();
        handler.post(new Runnable() {
            public final void run() {
                RFFloating.this.dismiss();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void dismiss(Bundle bundle) {
        this.mHandler.post(new Runnable(bundle) {
            public final /* synthetic */ Bundle f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RFFloatingControllerProxy.this.lambda$dismiss$4$RFFloatingControllerProxy(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$dismiss$4$RFFloatingControllerProxy(Bundle bundle) {
        this.floating.dismiss(bundle);
    }

    /* access modifiers changed from: package-private */
    public Bundle getArgs() {
        return this.floating.getArgs();
    }
}
