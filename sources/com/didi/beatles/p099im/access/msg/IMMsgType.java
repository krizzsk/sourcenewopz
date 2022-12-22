package com.didi.beatles.p099im.access.msg;

import com.didi.beatles.p099im.api.IMApiConst;

/* renamed from: com.didi.beatles.im.access.msg.IMMsgType */
public enum IMMsgType {
    TYPE_TEXT,
    TYPE_TEXT_RECOMMEND,
    TYPE_VOICE,
    TYPE_SYSTEM,
    TYPE_SYSTEM_AUDIO,
    TYPE_ORDER_STATUS_CHANGE,
    TYPE_CUSTOM_FACE,
    TYPE_HELPER,
    TYPE_SHARE_LOCATION,
    TYPE_CLOSE_SHARE_LOCATION,
    TYPE_SEND_LOCATION,
    TYPE_CMD,
    TYPE_EXTEND,
    TYPE_IMAGE,
    TYPE_RICH_INFO,
    TYPE_UNKNOWN;

    public static IMMsgType parseType(int i) {
        switch (i) {
            case 65536:
                return TYPE_TEXT;
            case 65537:
                return TYPE_TEXT_RECOMMEND;
            case 131072:
                return TYPE_VOICE;
            case 196608:
                return TYPE_IMAGE;
            case 327680:
                return TYPE_CUSTOM_FACE;
            case IMApiConst.MsgTypeSystem /*393217*/:
                return TYPE_SYSTEM;
            case IMApiConst.MsgTypeOderStatusChange /*393219*/:
                return TYPE_ORDER_STATUS_CHANGE;
            case IMApiConst.MsgTypeHelper /*393220*/:
                return TYPE_HELPER;
            case IMApiConst.MsgTypeSystemAudio /*393224*/:
                return TYPE_SYSTEM_AUDIO;
            case 458752:
                return TYPE_RICH_INFO;
            case 524289:
                return TYPE_CMD;
            case 528385:
                return TYPE_EXTEND;
            case IMApiConst.MsgTypeShareLocation /*10485761*/:
                return TYPE_SHARE_LOCATION;
            case IMApiConst.MsgTypeCloseShareLocation /*10485762*/:
                return TYPE_CLOSE_SHARE_LOCATION;
            case IMApiConst.MsgTypeSendLocation /*10486017*/:
                return TYPE_SEND_LOCATION;
            default:
                return TYPE_UNKNOWN;
        }
    }
}
