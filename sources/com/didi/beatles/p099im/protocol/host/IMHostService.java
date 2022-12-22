package com.didi.beatles.p099im.protocol.host;

import com.didi.beatles.p099im.protocol.service.IIMSpiProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.protocol.host.IMHostService */
public interface IMHostService extends IIMSpiProvider {
    public static final String ACTION_NAVIGATION = "navigation";
    public static final String ACTION_SEND_LOCATION_MESSAGE = "send_location_message";
    public static final String ACTION_SEND_PLUGIN_MESSAGE = "send_plugin_message";
    public static final String ACTION_SEND_STREET_MESSAGE = "send_street_message";
    public static final String ACTION_SEND_TEXT_MESSAGE = "send_text_message";

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.protocol.host.IMHostService$HostAction */
    public @interface HostAction {
    }

    boolean invoke(String str, Object... objArr);
}
