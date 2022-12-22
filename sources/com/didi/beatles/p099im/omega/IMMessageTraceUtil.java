package com.didi.beatles.p099im.omega;

import android.text.TextUtils;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.omega.IMMessageTraceUtil */
public class IMMessageTraceUtil {
    public static IMTraceUtil.BusinessParam trackMessageCoreEvent(String str, IMMessage iMMessage) {
        if (TextUtils.isEmpty(str) || iMMessage == null) {
            return new IMTraceUtil.BusinessParam("invalid");
        }
        IMLog.m6631d("IMMessageTraceUtil", "event: " + str + ",uniq_msg_id: " + iMMessage.getCloudUniqueMsgId());
        return IMTraceUtil.addBusinessEvent(str).add("product_id", Integer.valueOf(iMMessage.getBusinessId())).add("client_type", IMContextInfoHelper.getPackageName()).add("msg_type", Integer.valueOf(iMMessage.getType())).add("send_uid", Long.valueOf(iMMessage.getSenderUid())).add("activityid", iMMessage.getMessageExtendInfo() == null ? "" : Long.valueOf(iMMessage.getMessageExtendInfo().activity_id)).add("batcheid", iMMessage.batcheid).add("batchid", iMMessage.batcheid).add("mid", Long.valueOf(iMMessage.getMid())).add("mattr", Long.valueOf(iMMessage.getMattr())).add("send_time", Long.valueOf(iMMessage.getCreateTime())).add("current_time", Long.valueOf(System.currentTimeMillis())).add("session_type", Integer.valueOf(iMMessage.getSidType())).add("mact", Integer.valueOf(iMMessage.mact)).add("uniq_msg_id", iMMessage.getCloudUniqueMsgId()).add("pull_scene", Integer.valueOf(iMMessage.pullScene));
    }
}
