package com.didi.sdk.push.fcm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.app.router.DRouterUtils;
import com.didi.app.router.PageRouter;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.notify.IMDispatcherActivity;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.push.IMParseMsg;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.OneMessageInit;
import com.didi.sdk.app.SchemeDispatcher;
import com.didi.sdk.app.scheme.AbsSchemeDispatcherFilter;
import com.didi.sdk.log.Logger;
import com.didi.sdk.push.common.PushAckParams;
import com.didi.sdk.push.common.ThirdPartyMsgHttpApi;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.EventKeys;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import org.json.JSONException;
import org.json.JSONObject;

@ServiceProvider({AbsSchemeDispatcherFilter.class})
public class FcmSchemeFilter extends AbsSchemeDispatcherFilter {
    public static String FROM_NOTIFICATION = "__from_notification";
    public static String FROM_TAG = "__from_tag";

    public boolean doFilter(Intent intent, SchemeDispatcher schemeDispatcher) {
        if (!"com.didi.global.fcm.msg.click".equals(intent.getAction()) && !"com.didi.br.fcm.msg.click".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("payload");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("p_id");
                if (!TextUtils.isEmpty(optString)) {
                    uploadBackToServer(schemeDispatcher, 4, optString, (String) null);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(Constact.KEY_LINK_CONTENT);
                String str = "";
                if (optJSONObject != null) {
                    str = optJSONObject.optString("url", str);
                }
                if (TextUtils.isEmpty(str)) {
                    tryToStartMainActivity(schemeDispatcher);
                    tryToIm(jSONObject, stringExtra);
                }
                if (jSONObject.has("ty")) {
                    FcmNotificationClickedProcessing(jSONObject);
                }
                if (!TextUtils.isEmpty(str)) {
                    DRouterUtils.startUrlSafety(schemeDispatcher, Uri.parse(str));
                }
                schemeDispatcher.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private void tryToIm(JSONObject jSONObject, String str) {
        try {
            if (jSONObject.has("c")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("c");
                if (jSONObject2.has("ty") && jSONObject2.optInt("ty", 0) == 4096) {
                    OneMessageInit.init(DIDIApplication.getAppContext());
                    JSONObject jSONObject3 = new JSONObject(str);
                    int optInt = jSONObject3.optInt("lt");
                    JSONObject optJSONObject = jSONObject3.optJSONObject("c");
                    if (optJSONObject != null) {
                        jSONObject3 = optJSONObject;
                    }
                    IMParseMsg parseFromOutJsonString = new IMParseMsg().parseFromOutJsonString(jSONObject3.toString());
                    IMEngine.pullMessagesSync(optInt);
                    IMMessage iMMessage = new IMMessage(0);
                    iMMessage.setSid(parseFromOutJsonString.sid);
                    iMMessage.oId = parseFromOutJsonString.oid;
                    iMMessage.setSenderUid(parseFromOutJsonString.uid);
                    iMMessage.setType(parseFromOutJsonString.f9582ty);
                    iMMessage.setSidType(parseFromOutJsonString.sty);
                    iMMessage.setBusinessId(parseFromOutJsonString.product);
                    iMMessage.msgForUid = IMContextInfoHelper.getUid();
                    Intent intent = new Intent(IMContextInfoHelper.getContext(), IMDispatcherActivity.class);
                    intent.putExtra(IMDispatcherActivity.KEY_INTENT_GSON_NOTIFICATION, IMJsonUtil.jsonFromObject(iMMessage));
                    intent.setFlags(268435456);
                    IMContextInfoHelper.getContext().startActivity(intent);
                    Logger.easylog("push 跳转:", str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadBackToServer(Context context, int i, String str, String str2) {
        if (context != null) {
            SystemUtils.log(3, "pushupload", "uploadBackToServer params state = " + i + " id = " + str, (Throwable) null, "com.didi.sdk.push.fcm.FcmSchemeFilter", 140);
            PushAckParams pushAckParams = new PushAckParams();
            pushAckParams.state = i;
            pushAckParams.pId = str;
            int i2 = 1016;
            try {
                i2 = Integer.valueOf(AppUtils.getMetaDataByKey(EventKeys.APP_FCM_APPKEY)).intValue();
            } catch (Exception unused) {
            }
            pushAckParams.appType = i2;
            ThirdPartyMsgHttpApi.uploadBackToServer(context.getApplicationContext(), pushAckParams);
        }
    }

    private void FcmNotificationClickedProcessing(JSONObject jSONObject) {
        try {
            jSONObject.putOpt(FROM_TAG, FROM_NOTIFICATION);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DPushBody dPushBody = new DPushBody();
        dPushBody.setData(jSONObject.toString().getBytes());
        FcmPushDispatcher.getInstance().dispatchMessages(dPushBody);
    }

    /* access modifiers changed from: protected */
    public void tryToStartMainActivity(Activity activity) {
        if (!ActivityLifecycleManager.getInstance().isMainActivityRunning()) {
            Logger.easylog("SchemeDispatcher", "MainActivity is not running, start it.");
            Intent intent = new Intent();
            intent.addFlags(805306368);
            PageRouter.getInstance().startMainActivity(activity, intent);
            return;
        }
        activity.startActivity(new Intent("android.action.launch.DidiLoadDexActivity"));
        activity.finish();
    }
}
