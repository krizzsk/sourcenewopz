package com.didi.beatles.p099im.utils;

import com.didi.beatles.p099im.api.IMApiConst;
import com.didi.beatles.p099im.module.entity.IMMessage;

/* renamed from: com.didi.beatles.im.utils.IMCommandUtils */
public class IMCommandUtils {
    public static boolean isSysMessageInUnreadCount(IMMessage iMMessage) {
        int[] iArr = {IMApiConst.MsgTypeSystem, IMApiConst.MsgTypeOderStatusChange, IMApiConst.MsgTypeHelperPicture, IMApiConst.MsgTypeHelper, IMApiConst.MsgTypePushSystemMsg, IMApiConst.MsgTypeSystemAudio, 528385};
        if (iMMessage == null) {
            return false;
        }
        for (int i = 0; i < 7; i++) {
            if (iMMessage.getType() == iArr[i]) {
                return true;
            }
        }
        return false;
    }
}
