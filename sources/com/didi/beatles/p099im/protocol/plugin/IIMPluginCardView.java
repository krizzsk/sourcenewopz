package com.didi.beatles.p099im.protocol.plugin;

import android.view.View;
import com.didi.beatles.p099im.protocol.host.IMMessageViewStatusCallback;
import com.didi.beatles.p099im.protocol.model.IMRenderCardEnv;

/* renamed from: com.didi.beatles.im.protocol.plugin.IIMPluginCardView */
public interface IIMPluginCardView {
    public static final int INVALID_POSITION = -1;

    boolean isShowInMiddle();

    void onBind(int i, IMRenderCardEnv iMRenderCardEnv, String str, IMMessageViewStatusCallback iMMessageViewStatusCallback);

    void onCardClick(View view);
}
