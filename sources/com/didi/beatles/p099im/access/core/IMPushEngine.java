package com.didi.beatles.p099im.access.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMAssister;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.notify.IMDispatcherActivity;
import com.didi.beatles.p099im.activity.IMMessageActivity;
import com.didi.beatles.p099im.activity.IMOverDueMessageListActivity;
import com.didi.beatles.p099im.activity.IMValidMessageListActivity;
import com.didi.beatles.p099im.manager.IMBusinessManager;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.push.IMParseMsg;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.didi.beatles.im.access.core.IMPushEngine */
public class IMPushEngine {

    /* renamed from: a */
    static final String f8741a = "key_message";
    public static long holdMessageSessionId;

    /* renamed from: b */
    private IMNotifyLister f8742b;

    /* renamed from: c */
    private boolean f8743c;

    public IMPushEngine() {
        this.f8742b = null;
        this.f8743c = false;
        this.f8742b = new IMNotifyLister() {
            public void onPushArrive(String str, int i) {
                IMLog.m6635i("IMPushEngine", "push arrive");
                if (!IMEngine.getInstance(IMContextInfoHelper.getContext()).hasInit()) {
                    IMLog.m6632e("IMPushEngine", "push arrive but IM not init!");
                    return;
                }
                switch (i) {
                    case 102:
                        IMLog.m6631d("IMPushEngine", "onPushArrive IMEngine getui: " + str + ";pushType:" + i);
                        IMManager.getInstance().pullMessage(0, 0, 5);
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.optInt("lt");
                        jSONObject.optLong("aid");
                        JSONObject optJSONObject = jSONObject.optJSONObject("c");
                        if (optJSONObject != null) {
                            jSONObject = optJSONObject;
                        }
                        if (jSONObject.optInt("ty", 0) == 4096) {
                            new IMParseMsg().parseFromOutJsonString(jSONObject.toString());
                            return;
                        }
                        return;
                    case 103:
                        IMLog.m6631d("IMPushEngine", "onPushArrive IMEngine xiaomi: " + str + ";pushType:" + i);
                        try {
                            JSONObject jSONObject2 = new JSONObject(str);
                            IMLog.m6631d("IMPushEngine", "onPushArrive IMEngine xiaomi parse: " + jSONObject2);
                            jSONObject2.optInt("lt");
                            jSONObject2.optLong("aid");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("c");
                            if (optJSONObject2 != null) {
                                jSONObject2 = optJSONObject2;
                            }
                            if (jSONObject2.optInt("ty", 0) == 4096) {
                                IMParseMsg parseFromOutJsonString = new IMParseMsg().parseFromOutJsonString(jSONObject2.toString());
                                IMManager.getInstance().pullMessage(IMBusinessManager.getBusinessId(parseFromOutJsonString.sid), 0, 4);
                                IMMessage iMMessage = new IMMessage(0);
                                iMMessage.setSid(parseFromOutJsonString.sid);
                                iMMessage.oId = parseFromOutJsonString.oid;
                                iMMessage.setSenderUid(parseFromOutJsonString.uid);
                                iMMessage.setType(parseFromOutJsonString.f9582ty);
                                iMMessage.setSidType(parseFromOutJsonString.sty);
                                iMMessage.setBusinessId(parseFromOutJsonString.product);
                                iMMessage.msgForUid = IMContextInfoHelper.getUid();
                                iMMessage.notifyType = 2;
                                Intent intent = new Intent(IMContextInfoHelper.getContext(), IMDispatcherActivity.class);
                                intent.putExtra(IMDispatcherActivity.KEY_INTENT_GSON_NOTIFICATION, IMJsonUtil.jsonFromObject(iMMessage));
                                intent.setFlags(268435456);
                                IMContextInfoHelper.getContext().startActivity(intent);
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                        }
                    case 104:
                        IMManager.getInstance().pullMessage(0, 0, 1);
                        IMLog.m6631d("IMPushEngine", "onPushArrive IMEngine inner: " + str + ";pushType:" + i);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public static boolean inThisMessagePage(IMMessage iMMessage) {
        String topActivityNameAndProcessName = getTopActivityNameAndProcessName(IMContextInfoHelper.getContext());
        if (!TextUtils.isEmpty(topActivityNameAndProcessName) && (topActivityNameAndProcessName.contains(IMValidMessageListActivity.class.getSimpleName()) || topActivityNameAndProcessName.contains(IMOverDueMessageListActivity.class.getSimpleName()))) {
            return true;
        }
        if (TextUtils.isEmpty(topActivityNameAndProcessName) || !topActivityNameAndProcessName.contains(IMMessageActivity.class.getSimpleName()) || holdMessageSessionId != iMMessage.getSid()) {
            return false;
        }
        return true;
    }

    public static boolean isInApplication() {
        if (!IMContextInfoHelper.isInject()) {
            return false;
        }
        Context context = IMContextInfoHelper.getContext();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks != null) {
                for (int i = 0; i < runningTasks.size(); i++) {
                    if (TextUtils.equals(runningTasks.get(i).topActivity.getPackageName(), context.getPackageName())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String getTopActivityNameAndProcessName(Context context) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks == null) {
                return null;
            }
            String[] split = runningTasks.get(0).topActivity.getClassName().split("\\.");
            return split[split.length - 1];
        } catch (Exception unused) {
            return null;
        }
    }

    public void initEngine(IMAssister iMAssister) {
        if (iMAssister != null && !this.f8743c) {
            iMAssister.createPushChannel(this.f8742b);
            this.f8743c = true;
        }
    }

    public void destoryEngine() {
        this.f8743c = false;
    }

    public void createPushChannel(IMAssister iMAssister) {
        if (iMAssister != null) {
            iMAssister.createPushChannel(this.f8742b);
        }
    }

    public static void parseIMPushInMainActivity(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey(IMDispatcherActivity.KEY_INTENT_GSON_NOTIFICATION)) {
                    IMMessage iMMessage = (IMMessage) IMJsonUtil.objectFromJson(bundle.getString(IMDispatcherActivity.KEY_INTENT_GSON_NOTIFICATION), IMMessage.class);
                    if (iMMessage != null) {
                        IMBusinessParam iMBusinessParam = new IMBusinessParam();
                        iMBusinessParam.setSessionId(iMMessage.getSid());
                        iMBusinessParam.setSelfUid(IMContextInfoHelper.getUid());
                        iMBusinessParam.setPeerUid(iMMessage.getSenderUid());
                        iMBusinessParam.setBusinessId(iMMessage.getBusinessId());
                        iMBusinessParam.setOrderId(iMMessage.getoId());
                        iMBusinessParam.setRouteId(iMMessage.getRouteId());
                        iMBusinessParam.setSessionType(iMMessage.getSidType());
                        IMEngine.startIMActivityWithNewTaskFlag(IMContextInfoHelper.getContext(), iMBusinessParam, 3);
                        return;
                    }
                    return;
                }
                bundle.containsKey(f8741a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
