package com.didi.beatles.p099im.protocol.model;

import android.content.Context;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p099im.protocol.view.IMGuideConfig;
import com.didi.beatles.p099im.protocol.view.IMSkinConfig;
import java.util.List;

/* renamed from: com.didi.beatles.im.protocol.model.IMExtendActionItem */
public abstract class IMExtendActionItem {
    public final int iconId;
    public final int pluginId;
    public final String text;

    public boolean funcRedDot(Context context) {
        return false;
    }

    public IMGuideConfig getBtmGuideConfig(Context context, String str, List<IMBottomGuideConfig> list) {
        return null;
    }

    public abstract IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv);

    public boolean invokeWhenEnter() {
        return false;
    }

    public boolean moreInvokeAction() {
        return false;
    }

    public IMSkinConfig moreSkinConfig(Context context) {
        return null;
    }

    public void showBtmGuide(Context context, IMGuideConfig iMGuideConfig, String str) {
    }

    public IMExtendActionItem(int i, String str, int i2) {
        this.pluginId = i;
        this.text = str;
        this.iconId = i2;
    }
}
