package com.didi.sdk.p154ms.gms.push;

import android.content.Context;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.p154ms.gms.common.GMSType;
import com.didi.sdk.p154ms.push.ITokenOperation;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;

@ServiceProvider(alias = "GMS", value = {ITokenOperation.class})
/* renamed from: com.didi.sdk.ms.gms.push.GMSTokenOperation */
public class GMSTokenOperation extends GMSType implements ITokenOperation {
    /* access modifiers changed from: private */
    public static final String TAG = GMSTokenOperation.class.getSimpleName();

    public String getTokenSync(final Context context) {
        try {
            FirebaseApp.initializeApp(context.getApplicationContext());
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                public void onComplete(Task<String> task) {
                    if (task.isSuccessful()) {
                        String result = task.getResult();
                        String access$000 = GMSTokenOperation.TAG;
                        LogUtil.m26097d(access$000, "getTokenComplete : exception = " + result);
                        FcmUtil.saveFcmToken(context, result);
                    }
                }
            });
            return FcmUtil.getFcmToken(context);
        } catch (Exception e) {
            String str = TAG;
            LogUtil.m26098e(str, "getTokenSync : exception = " + e);
            return "";
        }
    }

    public String getTokenCached(Context context) {
        return FcmUtil.getFcmToken(context);
    }

    public boolean isTokenCachedSyncWithServer(Context context) {
        return FcmUtil.getSyncStatus(context);
    }
}
