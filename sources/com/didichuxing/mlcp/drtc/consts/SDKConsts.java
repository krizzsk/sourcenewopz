package com.didichuxing.mlcp.drtc.consts;

import com.didichuxing.mlcp.drtc.enums.DrtcEnvType;
import com.didichuxing.mlcp.drtc.models.C15902b;

public class SDKConsts {
    public static final String ACTION_VALUE_DETACH = "detach";
    public static final String ACTION_VALUE_JOIN = "join";
    public static final String ACTION_VALUE_LEAVE = "leave";
    public static final String ACTION_VALUE_START = "start";
    public static final String BOOLEAN_FALSE = "false";
    public static final String BOOLEAN_TRUE = "true";
    public static final String MSG_TAG_HANDLE_ID = "handle_id";
    public static final String MSG_TAG_OPAQUE = "opaque_id";
    public static final String MSG_TAG_PLUGIN = "plugin";
    public static final String MSG_TAG_PLUGIND = "plugindata";
    public static final String MSG_TAG_SESSION_ID = "session_id";
    public static final String MSG_TAG_TRAN = "transaction";
    public static final String TAG_COMMON_MESSAGE = "message";
    public static final String TAG_COMMON_PARTICIPANTS = "participants";
    public static final String TAG_COMMON_PUBLISHERS = "publishers";
    public static final String TAG_COMMON_REQUEST = "request";
    public static final String TAG_KEY_AUDIO = "audio";
    public static final String TAG_KEY_BITRATE = "bitrate";
    public static final String TAG_KEY_DISPLAY = "display";
    public static final String TAG_KEY_FEED = "feed";
    public static final String TAG_KEY_FILENAME = "filename";
    public static final String TAG_KEY_ID = "id";
    public static final String TAG_KEY_PIN = "pin";
    public static final String TAG_KEY_PRIVID = "private_id";
    public static final String TAG_KEY_PTYPE = "ptype";
    public static final String TAG_KEY_RECORD = "record";
    public static final String TAG_KEY_ROOM = "room";
    public static final String TAG_KEY_VIDEO = "video";
    public static final String TAG_VALUE_CONFIGURE = "configure";
    public static final String TAG_VALUE_PUBLISHER = "publisher";
    public static final String TAG_VALUE_SUBSCRIBER = "subscriber";
    private static C15902b sdk_basic_config;

    public static C15902b Set_Sys_Config(DrtcEnvType drtcEnvType) {
        if (sdk_basic_config == null) {
            sdk_basic_config = new C15902b();
        }
        return sdk_basic_config.mo118990a(drtcEnvType);
    }

    public static C15902b Set_Sys_Config_Custom(String str) {
        if (sdk_basic_config == null) {
            sdk_basic_config = new C15902b(str);
        }
        return sdk_basic_config.mo118990a(DrtcEnvType.ENV_CUSTOM);
    }

    public static C15902b getSysConfig() {
        return sdk_basic_config;
    }
}
