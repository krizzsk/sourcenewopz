package com.didi.beatles.p099im.access.notify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.utils.Parser;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.omega.IMMessageTraceUtil;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;

/* renamed from: com.didi.beatles.im.access.notify.IMDispatcherActivity */
public class IMDispatcherActivity extends Activity {
    public static final String KEY_INTENT_GSON_NOTIFICATION = "im_notification_gons_data";
    public static final String PUSH_DISPATCHER = "com.didi.im.action.PUSH_DISPATCHER";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        IMLog.m6631d("im-sdk", "onPushArrive IMDispatcherActivity onReceive");
        if (intent == null) {
            finish();
            return;
        }
        try {
            String string = intent.getExtras().getString(KEY_INTENT_GSON_NOTIFICATION);
            if (string == null) {
                finish();
                return;
            }
            IMMessage iMMessage = (IMMessage) IMJsonUtil.objectFromJson(string, IMMessage.class);
            if (iMMessage != null) {
                if (iMMessage.msgForUid != IMContextInfoHelper.getUid()) {
                    IMLog.m6637w("message is error , ignore it", new Object[0]);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("msg_ck", 1);
                hashMap.put("btn1_ck", 0);
                hashMap.put("btn2_ck", 0);
                hashMap.put("ostype", 2);
                OmegaUtil.trackExtendMsg("ddim_msg_all_open_ck", iMMessage, hashMap);
                IMMessageTraceUtil.trackMessageCoreEvent("ddim_push_all_ck", iMMessage).add("push_type", 0).add("push_type_new", Integer.valueOf(iMMessage.notifyType)).report();
                IMTraceUtil.addBusinessEvent("msg_remind_ck").add("business_id", Integer.valueOf(iMMessage.getBusinessId())).add("type", 1).add("msg_id", Long.valueOf(iMMessage.getMid())).report();
                if (!IMContextInfoHelper.isMainActivityAlive()) {
                    if (IMContextInfoHelper.getAppMainClass() != null) {
                        IMLog.m6631d("im-sdk", "onPushArrive push from outside with start :" + IMContextInfoHelper.getAppMainClass().getSimpleName());
                        if (IMContextInfoHelper.getAppMainClass() != null) {
                            Intent intent2 = new Intent(this, IMContextInfoHelper.getAppMainClass());
                            intent2.putExtra(KEY_INTENT_GSON_NOTIFICATION, string);
                            startActivity(intent2);
                        }
                        finish();
                    }
                }
                IMLog.m6631d("im-sdk", "onPushArrive push from outside with no start MainActivity");
                String dispatchMessageActionUrl = Parser.getDispatchMessageActionUrl(iMMessage);
                if (!TextUtils.isEmpty(dispatchMessageActionUrl)) {
                    IMLog.m6631d("im-sdk", "IM Push Log Open Uri:" + dispatchMessageActionUrl);
                    IMCommonUtil.startUriActivity(this, dispatchMessageActionUrl, (Object) null);
                } else {
                    IMBusinessParam iMBusinessParam = new IMBusinessParam();
                    iMBusinessParam.setSessionId(iMMessage.getSid());
                    iMBusinessParam.setSelfUid(IMContextInfoHelper.getUid());
                    iMBusinessParam.setPeerUid(iMMessage.getSenderUid());
                    iMBusinessParam.setBusinessId(iMMessage.getBusinessId());
                    iMBusinessParam.setOrderId(iMMessage.getoId());
                    iMBusinessParam.setRouteId(iMMessage.getRouteId());
                    iMBusinessParam.setSessionType(iMMessage.getSidType());
                    iMBusinessParam.setSourceId(2);
                    IMLog.m6631d("im-sdk", "IM Push Log MainActivityAlive:" + iMBusinessParam.toString());
                    IMEngine.startChatDetailActivity(this, iMBusinessParam, 3);
                }
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
            IMLog.m6632e("im-sdk", "onPushArrive IM Push Log Error", e);
            finish();
        }
    }
}
