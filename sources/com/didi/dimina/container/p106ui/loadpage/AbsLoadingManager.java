package com.didi.dimina.container.p106ui.loadpage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.UIHandlerUtil;

/* renamed from: com.didi.dimina.container.ui.loadpage.AbsLoadingManager */
public abstract class AbsLoadingManager {
    protected final Context mContext;
    protected DMMina mDMMina;
    protected AlertDialog mDialog;

    /* access modifiers changed from: protected */
    public abstract int getDialogStyle();

    /* access modifiers changed from: protected */
    public abstract View getLoadingView();

    public AbsLoadingManager(Context context, DMMina dMMina) {
        this.mContext = context;
        this.mDMMina = dMMina;
    }

    public void show() {
        UIHandlerUtil.getHandler().post(new Runnable() {
            public final void run() {
                AbsLoadingManager.this.m13088c();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m13088c() {
        if (this.mContext != null) {
            AlertDialog alertDialog = this.mDialog;
            if (alertDialog == null || !alertDialog.isShowing()) {
                AlertDialog.Builder view = new AlertDialog.Builder(this.mContext, getDialogStyle()).setCancelable(false).setView(getLoadingView());
                Context context = this.mContext;
                if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                    this.mDialog = view.show();
                }
                AlertDialog alertDialog2 = this.mDialog;
                if (alertDialog2 != null && alertDialog2.getWindow() != null) {
                    this.mDialog.getWindow().setBackgroundDrawable((Drawable) null);
                    Window window = this.mDialog.getWindow();
                    window.getDecorView().setPadding(0, 0, 0, 0);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.height = -2;
                    attributes.width = -2;
                    attributes.gravity = 17;
                    window.setAttributes(attributes);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m13086a() {
        UIHandlerUtil.runOnUiThread(new Runnable() {
            public final void run() {
                AbsLoadingManager.this.m13087b();
            }
        });
    }

    public void dismiss() {
        final $$Lambda$AbsLoadingManager$44hODn5eMFAyUOGhA4KDZkwNFxE r0 = new Runnable() {
            public final void run() {
                AbsLoadingManager.this.m13086a();
            }
        };
        if (this.mDMMina.getFrontBackgroundManager().inFrontStatus()) {
            r0.run();
        } else {
            this.mDMMina.getFrontBackgroundManager().registerFrontCallback(new IDMCommonAction<Void>() {
                public void callback(Void voidR) {
                    r0.run();
                    AbsLoadingManager.this.mDMMina.getFrontBackgroundManager().unRegisterFrontCallback(this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m13087b() {
        AlertDialog alertDialog;
        Context context = this.mContext;
        if (context != null && (context instanceof Activity) && !((Activity) context).isFinishing() && (alertDialog = this.mDialog) != null) {
            alertDialog.dismiss();
            this.mDialog = null;
        }
    }
}
