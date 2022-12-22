package com.didi.beatles.p099im.protocol.plugin;

import android.content.Context;
import android.view.View;
import com.didi.beatles.p099im.protocol.host.IMTabInvokeEnv;
import com.didi.beatles.p099im.protocol.model.IMExtendActionItem;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;
import com.didi.beatles.p099im.protocol.service.IIMSpiProvider;

/* renamed from: com.didi.beatles.im.protocol.plugin.IMPluginService */
public interface IMPluginService extends IIMSpiProvider {
    IMExtendActionItem getExtendActionItem(Context context);

    String getMessageBracket(Context context);

    Class<? extends View> getMessageViewClazz();

    int getPluginId();

    IMTabActionItem getTabActionItem(Context context, IMTabInvokeEnv iMTabInvokeEnv);
}
