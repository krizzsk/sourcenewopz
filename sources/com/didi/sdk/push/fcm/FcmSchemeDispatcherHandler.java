package com.didi.sdk.push.fcm;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.sdk.app.ISchemeDispatcherHandler;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.push.manager.DPushType;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

@ServiceProvider({ISchemeDispatcherHandler.class})
public class FcmSchemeDispatcherHandler implements ISchemeDispatcherHandler {
    /* access modifiers changed from: private */
    public Logger logger;
    private String mProductPreFix;

    public void handleSchemeOfPush(Intent intent, Activity activity) {
    }

    public FcmSchemeDispatcherHandler() {
        this.logger = LoggerFactory.getLogger("fcmlink");
        this.mProductPreFix = "";
        this.mProductPreFix = NationTypeUtil.getNationComponentData().getProductPreFix();
    }

    public void handleClickOfPush(String str, Activity activity) {
        String str2;
        String str3;
        String str4;
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            FcmMessageProcesser fcmMessageProcesser = new FcmMessageProcesser();
            for (Method method : fcmMessageProcesser.getClass().getDeclaredMethods()) {
                IntentFilter intentFilter = (IntentFilter) method.getAnnotation(IntentFilter.class);
                String linkType = intentFilter.linkType();
                String[] messageType = intentFilter.messageType();
                String str5 = "";
                String optString = jSONObject.optString(Constact.KEY_LINK_TYPE, str5);
                String optString2 = jSONObject.optString("lt");
                JSONObject optJSONObject = jSONObject.optJSONObject(Constact.KEY_LINK_CONTENT);
                if (optJSONObject != null) {
                    str5 = optJSONObject.optString(Constact.KEY_LINK_MESSAGETYPE, str5);
                }
                String str6 = str5;
                int i2 = 0;
                while (i2 < messageType.length) {
                    if (!TextUtils.equals(linkType, optString) || !TextUtils.equals(messageType[i2], str6)) {
                        i = i2;
                        str4 = str6;
                        str3 = optString2;
                        str2 = optString;
                    } else {
                        C129721 r1 = r2;
                        i = i2;
                        final Method method2 = method;
                        str4 = str6;
                        final FcmMessageProcesser fcmMessageProcesser2 = fcmMessageProcesser;
                        str3 = optString2;
                        final String str7 = str;
                        str2 = optString;
                        final Activity activity2 = activity;
                        C129721 r2 = new Runnable() {
                            public void run() {
                                try {
                                    method2.invoke(fcmMessageProcesser2, new Object[]{str7, activity2});
                                } catch (IllegalAccessException e) {
                                    FcmSchemeDispatcherHandler.this.logger.info("handleClickOfPush invoke IllegalAccessException", new Object[0]);
                                    e.printStackTrace();
                                } catch (InvocationTargetException e2) {
                                    FcmSchemeDispatcherHandler.this.logger.info("handleClickOfPush invoke InvocationTargetException", new Object[0]);
                                    e2.printStackTrace();
                                }
                            }
                        };
                        UiThreadHandler.postOnceDelayed(r1, 1000);
                    }
                    i2 = i + 1;
                    str6 = str4;
                    optString2 = str3;
                    optString = str2;
                }
                String str8 = optString2;
                if (!TextUtils.isEmpty(str8)) {
                    DPushBody dPushBody = new DPushBody();
                    dPushBody.setData(str.getBytes());
                    DPushManager.getInstance().dispatcherPush(DPushType.FCM_PUSH.getName(), dPushBody, str8);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.logger.info("handleClickOfPush parse json error", new Object[0]);
        }
    }

    public String getProductPrefix() {
        return this.mProductPreFix;
    }
}
