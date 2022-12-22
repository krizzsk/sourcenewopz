package com.didichuxing.xpanel.message;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class XPanelMessageItem {
    public static final int M_COMMON = 1;
    public static final int M_IMPORTANT = 2;

    /* renamed from: a */
    C16574b f49546a;

    /* renamed from: b */
    private View f49547b;

    /* renamed from: c */
    private int f49548c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {
    }

    public XPanelMessageItem(View view, int i) {
        this.f49547b = view;
        this.f49548c = i;
        this.f49546a = new C16575c(view);
    }

    public View getContentView() {
        return this.f49547b;
    }

    public int getMessageType() {
        return this.f49548c;
    }
}
