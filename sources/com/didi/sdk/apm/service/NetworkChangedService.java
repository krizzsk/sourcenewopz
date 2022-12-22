package com.didi.sdk.apm.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.JobIntentService;
import com.didi.sdk.apm.model.AsyncReceiverModel;

public class NetworkChangedService extends JobIntentService {
    public static final String WORK_ACTION = "com.didi.sdk.apm.network_changed_receiver_action";

    /* renamed from: a */
    private static final String f35045a = "NetworkChangedService";

    /* renamed from: b */
    private static final int f35046b = 20191028;
    public static AsyncReceiverModel sAsyncReceiverModel;

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, (Class<?>) NetworkChangedService.class, (int) f35046b, intent);
    }

    /* access modifiers changed from: protected */
    public void onHandleWork(Intent intent) {
        if (intent != null && TextUtils.equals(intent.getAction(), WORK_ACTION)) {
            try {
                if (sAsyncReceiverModel != null) {
                    sAsyncReceiverModel.invokeOnReceiveMethod();
                }
                Log.d(f35045a, "network changed receiver migrated to servcie executed!");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
