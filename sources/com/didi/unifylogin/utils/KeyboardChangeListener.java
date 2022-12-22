package com.didi.unifylogin.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.sdk.apm.SystemUtils;

public class KeyboardChangeListener implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private static final String f44919a = "ListenerHandler";

    /* renamed from: b */
    private View f44920b;

    /* renamed from: c */
    private int f44921c;

    /* renamed from: d */
    private int f44922d;

    /* renamed from: e */
    private KeyBoardListener f44923e;

    public interface KeyBoardListener {
        void onKeyboardChange(boolean z, int i);
    }

    public void setKeyBoardListener(KeyBoardListener keyBoardListener) {
        this.f44923e = keyBoardListener;
    }

    public KeyboardChangeListener(Activity activity) {
        if (activity == null) {
            SystemUtils.log(4, f44919a, "contextObj is null", (Throwable) null, "com.didi.unifylogin.utils.KeyboardChangeListener", 32);
            return;
        }
        View a = m32212a(activity);
        this.f44920b = a;
        if (a != null) {
            m32213a();
        }
    }

    /* renamed from: a */
    private View m32212a(Activity activity) {
        return activity.findViewById(16908290);
    }

    /* renamed from: a */
    private void m32213a() {
        this.f44920b.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGlobalLayout() {
        /*
            r7 = this;
            android.view.View r0 = r7.f44920b
            int r0 = r0.getHeight()
            if (r0 != 0) goto L_0x0016
            r1 = 4
            r4 = 0
            r6 = 53
            java.lang.String r2 = "ListenerHandler"
            java.lang.String r3 = "currHeight is 0"
            java.lang.String r5 = "com.didi.unifylogin.utils.KeyboardChangeListener"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
            return
        L_0x0016:
            int r1 = r7.f44922d
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0022
            r7.f44922d = r0
            r7.f44921c = r0
        L_0x0020:
            r1 = 0
            goto L_0x0027
        L_0x0022:
            if (r1 == r0) goto L_0x0020
            r7.f44922d = r0
            r1 = 1
        L_0x0027:
            if (r1 == 0) goto L_0x0038
            int r1 = r7.f44921c
            if (r1 != r0) goto L_0x002f
            r2 = 0
            goto L_0x0031
        L_0x002f:
            int r3 = r1 - r0
        L_0x0031:
            com.didi.unifylogin.utils.KeyboardChangeListener$KeyBoardListener r0 = r7.f44923e
            if (r0 == 0) goto L_0x0038
            r0.onKeyboardChange(r2, r3)
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.utils.KeyboardChangeListener.onGlobalLayout():void");
    }

    public void destroy() {
        this.f44923e = null;
        if (this.f44920b != null && Build.VERSION.SDK_INT >= 16) {
            this.f44920b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
