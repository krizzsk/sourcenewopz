package com.didi.component.common.dialog;

import android.os.Handler;
import android.os.Looper;
import com.didi.component.core.IGroupView;
import com.didi.component.core.dialog.DialogInfo;
import java.util.concurrent.CountDownLatch;

public abstract class DialogHandler {
    protected IGroupView mGroupView;
    protected IDialog mShowDialog;
    protected Handler mUIHandler = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: protected */
    public abstract IDialog createDialog(DialogInfo dialogInfo);

    public DialogHandler(IGroupView iGroupView) {
        this.mGroupView = iGroupView;
    }

    public final boolean show(final DialogInfo dialogInfo) {
        if (dialogInfo == null) {
            return false;
        }
        if (runOnUIThread()) {
            return m7821a(dialogInfo);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final C4774a aVar = new C4774a(false);
        this.mUIHandler.post(new Runnable() {
            public void run() {
                try {
                    aVar.mo46782a(Boolean.valueOf(DialogHandler.this.m7821a(dialogInfo)));
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await();
            return ((Boolean) aVar.mo46781a()).booleanValue();
        } catch (InterruptedException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7821a(DialogInfo dialogInfo) {
        IDialog iDialog = this.mShowDialog;
        if (!(iDialog != null && iDialog.isShowing()) || dialogInfo.getDialogId() != this.mShowDialog.getId()) {
            dismissCurrent();
            IDialog createDialog = createDialog(dialogInfo);
            if (createDialog == null) {
                return false;
            }
            this.mShowDialog = createDialog;
            createDialog.show();
            return true;
        }
        this.mShowDialog.update(dialogInfo);
        return true;
    }

    public final void dismissCurrent() {
        if (runOnUIThread()) {
            m7822b();
        } else {
            this.mUIHandler.post(new Runnable() {
                public void run() {
                    DialogHandler.this.m7822b();
                }
            });
        }
    }

    public final boolean onBackPressed() {
        if (runOnUIThread()) {
            return m7819a();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final C4774a aVar = new C4774a(false);
        this.mUIHandler.post(new Runnable() {
            public void run() {
                try {
                    aVar.mo46782a(Boolean.valueOf(DialogHandler.this.m7819a()));
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await();
            return ((Boolean) aVar.mo46781a()).booleanValue();
        } catch (InterruptedException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7819a() {
        IDialog iDialog = this.mShowDialog;
        if (!(iDialog != null && iDialog.isShowing())) {
            return false;
        }
        if (this.mShowDialog.cancelable()) {
            m7822b();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7822b() {
        IDialog iDialog = this.mShowDialog;
        if (iDialog != null && iDialog.isShowing()) {
            dismiss(this.mShowDialog.getId());
        }
    }

    public final void dismiss(final int i) {
        if (runOnUIThread()) {
            m7816a(i);
        } else {
            this.mUIHandler.post(new Runnable() {
                public void run() {
                    DialogHandler.this.m7816a(i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7816a(int i) {
        IDialog iDialog = this.mShowDialog;
        if ((iDialog != null && iDialog.isShowing()) && iDialog.getId() == i) {
            this.mShowDialog = null;
            iDialog.dismiss();
        }
    }

    public boolean isDialogShowing() {
        IDialog iDialog = this.mShowDialog;
        return iDialog != null && iDialog.isShowing();
    }

    /* access modifiers changed from: protected */
    public boolean runOnUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
