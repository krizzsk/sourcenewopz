package com.didi.unifylogin.utils;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;
import com.didi.sdk.util.UiThreadHandler;

public class LoginLayoutChangeListener implements View.OnLayoutChangeListener {

    /* renamed from: a */
    private static final String f44929a = "LoginLayoutChangeListener";

    /* renamed from: b */
    private int f44930b = 0;

    /* renamed from: c */
    private int f44931c = 0;

    /* renamed from: d */
    private Context f44932d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ScrollView f44933e;

    public LoginLayoutChangeListener(Context context, ScrollView scrollView, int i) {
        this.f44932d = context;
        this.f44933e = scrollView;
        this.f44930b = i;
        this.f44931c = i / 3;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, final int i4, int i5, int i6, int i7, final int i8) {
        if (i8 != 0 && i4 != 0 && i8 - i4 > this.f44931c && this.f44933e != null) {
            LoginLog.write("LoginLayoutChangeListener: scrollTo " + i8 + "-" + i4);
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    LoginLayoutChangeListener.this.f44933e.scrollTo(0, i8 - i4);
                }
            }, 100);
        }
    }
}
