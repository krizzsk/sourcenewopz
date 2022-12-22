package com.didi.beatles.p099im.plugin.street;

import android.content.Context;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p099im.protocol.model.IMExtendActionItem;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.plugin.street.IMStreetExtendActionItem */
public class IMStreetExtendActionItem extends IMExtendActionItem {
    public IMStreetExtendActionItem(Context context) {
        super(7, context.getString(R.string.im_plugin_street_bracket), R.drawable.im_action_street_icon);
    }

    public IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
        IMStreetBridge.sendStreetMessage(338);
        return null;
    }
}
