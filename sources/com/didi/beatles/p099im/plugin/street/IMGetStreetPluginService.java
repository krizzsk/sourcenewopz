package com.didi.beatles.p099im.plugin.street;

import android.content.Context;
import android.view.View;
import com.didi.beatles.p099im.protocol.host.IMTabInvokeEnv;
import com.didi.beatles.p099im.protocol.model.IMExtendActionItem;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;
import com.didi.beatles.p099im.protocol.plugin.IMPluginService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "7", value = {IMPluginService.class})
/* renamed from: com.didi.beatles.im.plugin.street.IMGetStreetPluginService */
public class IMGetStreetPluginService implements IMPluginService {
    public String getMessageBracket(Context context) {
        return null;
    }

    public Class<? extends View> getMessageViewClazz() {
        return null;
    }

    public int getPluginId() {
        return 7;
    }

    public IMTabActionItem getTabActionItem(Context context, IMTabInvokeEnv iMTabInvokeEnv) {
        return null;
    }

    public IMExtendActionItem getExtendActionItem(Context context) {
        return new IMStreetExtendActionItem(context);
    }
}
