package com.didi.soda.home.component.titlebar;

import android.view.ViewGroup;

public class HomeTitleBarManager {

    /* renamed from: a */
    private static HomeTitleBarManager f42620a = new HomeTitleBarManager();

    /* renamed from: b */
    private ViewGroup f42621b;

    public static HomeTitleBarManager getManager() {
        return f42620a;
    }

    public void bindTitleBar(ViewGroup viewGroup) {
        this.f42621b = viewGroup;
    }

    public void hideTitleBar() {
        ViewGroup viewGroup = this.f42621b;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void showTitleBar() {
        ViewGroup viewGroup = this.f42621b;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public boolean isShow() {
        ViewGroup viewGroup = this.f42621b;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }
}
