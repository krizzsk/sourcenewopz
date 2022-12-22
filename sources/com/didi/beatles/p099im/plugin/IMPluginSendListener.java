package com.didi.beatles.p099im.plugin;

import android.content.Context;
import com.didi.beatles.p099im.event.IMSendAddressEvent;

/* renamed from: com.didi.beatles.im.plugin.IMPluginSendListener */
public interface IMPluginSendListener {
    Context getHostContext();

    void sendLocationMessage(IMSendAddressEvent iMSendAddressEvent, boolean z);

    void sendPluginMessage(int i, String str, String str2, int i2);

    void sendPluginTextMessage(int i, String str, int i2, Object obj);

    void sendStreetViewMessage(int i);
}
