package com.didi.rfusion.widget.toast.helper;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import com.didi.rfusion.utils.RFActivityManager;

public class RFNotificationToastHelper extends Handler {

    /* renamed from: d */
    private static final long f34008d = 4000;

    /* renamed from: a */
    private final Toast f34009a;

    /* renamed from: b */
    private final String f34010b;

    /* renamed from: c */
    private boolean f34011c;

    public RFNotificationToastHelper(Toast toast, Application application) {
        super(Looper.getMainLooper());
        this.f34009a = toast;
        this.f34010b = application.getPackageName();
    }

    public void handleMessage(Message message) {
        cancel();
    }

    public void show() {
        WindowManager windowManager;
        if (!mo88603a()) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 16973828;
            layoutParams.flags = 152;
            layoutParams.packageName = this.f34010b;
            layoutParams.gravity = this.f34009a.getGravity();
            layoutParams.x = this.f34009a.getXOffset();
            layoutParams.y = this.f34009a.getYOffset();
            try {
                Activity topActivity = RFActivityManager.getInstance().getTopActivity();
                if (!(topActivity == null || topActivity.isFinishing() || (windowManager = (WindowManager) topActivity.getSystemService("window")) == null)) {
                    windowManager.addView(this.f34009a.getView(), layoutParams);
                }
                sendEmptyMessageDelayed(hashCode(), 4000);
                mo88602a(true);
            } catch (WindowManager.BadTokenException | IllegalStateException unused) {
            }
        }
    }

    public void cancel() {
        WindowManager windowManager;
        removeMessages(hashCode());
        if (mo88603a()) {
            try {
                Activity topActivity = RFActivityManager.getInstance().getTopActivity();
                if (!(topActivity == null || (windowManager = (WindowManager) topActivity.getSystemService("window")) == null)) {
                    windowManager.removeViewImmediate(this.f34009a.getView());
                }
            } catch (IllegalArgumentException unused) {
            }
            mo88602a(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo88603a() {
        return this.f34011c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88602a(boolean z) {
        this.f34011c = z;
    }
}
