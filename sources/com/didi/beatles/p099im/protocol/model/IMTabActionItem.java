package com.didi.beatles.p099im.protocol.model;

import android.content.Context;
import android.view.View;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeReturn;

/* renamed from: com.didi.beatles.im.protocol.model.IMTabActionItem */
public abstract class IMTabActionItem {
    public final View customTabView;
    private View defaultTabView;
    public boolean enable = false;
    public final int iconId;
    public final int pluginId;
    public final String text;

    public abstract IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv);

    public IMTabActionItem(int i, String str, int i2) {
        this.pluginId = i;
        this.text = str;
        this.iconId = i2;
        this.customTabView = null;
    }

    public IMTabActionItem(int i, View view) {
        this.pluginId = i;
        this.text = null;
        this.iconId = 0;
        this.customTabView = view;
    }

    public final int getPluginId() {
        return this.pluginId;
    }

    public final void setDefaultTabView(View view) {
        this.defaultTabView = view;
    }

    public final View getDefaultTabView() {
        return this.defaultTabView;
    }
}
