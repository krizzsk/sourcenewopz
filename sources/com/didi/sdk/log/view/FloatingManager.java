package com.didi.sdk.log.view;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.WindowManager;
import com.didi.sdk.log.util.UiThreadHandler;

public class FloatingManager {

    /* renamed from: a */
    private static FloatingManager f36465a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FloatingView f36466b = null;

    /* renamed from: c */
    private Handler f36467c = UiThreadHandler.getsUiHandler();

    private FloatingManager() {
    }

    public static FloatingManager getInstance() {
        if (f36465a == null) {
            synchronized (FloatingManager.class) {
                if (f36465a == null) {
                    f36465a = new FloatingManager();
                }
            }
        }
        return f36465a;
    }

    public void init(Context context) {
        if (this.f36466b == null) {
            final WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (this.f36466b == null) {
                this.f36466b = new FloatingView(context);
            }
            this.f36467c.post(new Runnable() {
                public void run() {
                    FloatingManager.this.m25846a(windowManager);
                }
            });
        }
    }

    public void setDChatMsg(final String str) {
        if (this.f36466b != null && !TextUtils.isEmpty(str)) {
            this.f36467c.post(new Runnable() {
                public void run() {
                    FloatingManager.this.f36466b.setMsg(str);
                }
            });
        }
    }

    public void removeFloatingView(final Context context) {
        if (context != null) {
            this.f36467c.post(new Runnable() {
                public void run() {
                    if (FloatingManager.this.f36466b != null) {
                        ((WindowManager) context.getSystemService("window")).removeView(FloatingManager.this.f36466b);
                    }
                }
            });
        }
    }

    public void clear(final Context context) {
        if (context != null) {
            this.f36467c.post(new Runnable() {
                public void run() {
                    if (FloatingManager.this.f36466b != null) {
                        ((WindowManager) context.getSystemService("window")).removeView(FloatingManager.this.f36466b);
                        FloatingView unused = FloatingManager.this.f36466b = null;
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25846a(WindowManager windowManager) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.type = 2002;
        layoutParams.flags = 24;
        layoutParams.format = -2;
        layoutParams.x = 0;
        layoutParams.y = (-windowManager.getDefaultDisplay().getHeight()) / 2;
        windowManager.addView(this.f36466b, layoutParams);
    }
}
