package com.didi.sdk.p154ms.gms.common;

import android.content.Context;
import androidx.core.util.Consumer;
import com.didi.sdk.p154ms.common.IAnalytics;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;

@ServiceProvider(alias = "GMS", value = {IAnalytics.class})
/* renamed from: com.didi.sdk.ms.gms.common.GMSAnalytics */
public class GMSAnalytics extends GMSType implements IAnalytics {
    /* access modifiers changed from: private */
    public static final String TAG = GMSAnalytics.class.getSimpleName();

    public void getAppInstanceIdAsync(Context context, final Consumer<String> consumer) {
        FirebaseAnalytics.getInstance(context).getAppInstanceId().addOnCompleteListener(new OnCompleteListener<String>() {
            public void onComplete(Task<String> task) {
                try {
                    if (consumer != null) {
                        consumer.accept(task.getResult());
                    }
                } catch (Exception e) {
                    String access$000 = GMSAnalytics.TAG;
                    LogUtil.m26101w(access$000, "onComplete:e = " + e);
                    e.printStackTrace();
                }
            }
        });
    }
}
