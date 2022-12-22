package com.didi.beatles.p099im.views.dialog;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.beatles.p099im.common.IMLifecycleHandler;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.beatles.im.views.dialog.IMDialog */
public class IMDialog {

    /* renamed from: a */
    private WeakReference<Activity> f10181a;

    /* renamed from: b */
    private DialogFragment f10182b;

    /* renamed from: c */
    private boolean f10183c = false;

    /* renamed from: com.didi.beatles.im.views.dialog.IMDialog$Callback */
    public interface Callback {
        void onCancel();

        void onSubmit();
    }

    public IMDialog(Activity activity) {
        this.f10181a = new WeakReference<>(activity);
    }

    public void setDialog(DialogFragment dialogFragment) {
        if ((dialogFragment instanceof IMProgressDialogFragment) || (dialogFragment instanceof IMAlertDialogFragment)) {
            this.f10182b = dialogFragment;
            return;
        }
        throw new IllegalArgumentException("IMDialog only accept ProgressDialogFragment or AlertDialogFragment.");
    }

    public void setCancelable(boolean z) {
        this.f10183c = z;
    }

    public void show(IMLifecycleHandler.Controller controller, final FragmentManager fragmentManager, final String str) {
        if (controller != null) {
            controller.post(new Runnable() {
                public void run() {
                    IMDialog.this.m6940a(fragmentManager, str);
                }
            });
        } else {
            m6940a(fragmentManager, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6940a(FragmentManager fragmentManager, String str) {
        if (m6943b()) {
            this.f10182b.setCancelable(this.f10183c);
            this.f10182b.show(fragmentManager, str);
        }
    }

    public void dismiss(IMLifecycleHandler.Controller controller) {
        controller.post(new Runnable() {
            public void run() {
                IMDialog.this.m6939a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6939a() {
        if (m6943b()) {
            this.f10182b.dismiss();
        }
    }

    public void dismiss() {
        m6939a();
    }

    /* renamed from: b */
    private boolean m6943b() {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f10182b == null || (weakReference = this.f10181a) == null || weakReference.get() == null || (activity = (Activity) this.f10181a.get()) == null || activity.isFinishing() || !(activity instanceof FragmentActivity) || ((FragmentActivity) activity).getSupportFragmentManager() == null) {
            return false;
        }
        return true;
    }
}
