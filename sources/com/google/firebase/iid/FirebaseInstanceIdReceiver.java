package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    /* access modifiers changed from: protected */
    public final int onMessageReceive(Context context, CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.await(new FcmBroadcastProcessor(context).process(cloudMessage.getIntent()))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            SystemUtils.log(6, Constants.TAG, "Failed to send message to service.", e, "com.google.firebase.iid.FirebaseInstanceIdReceiver", 2);
            return 500;
        }
    }

    /* access modifiers changed from: protected */
    public final void onNotificationDismissed(Context context, Bundle bundle) {
        Intent putExtras = new Intent(CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS).putExtras(bundle);
        if (MessagingAnalytics.shouldUploadScionMetrics(putExtras)) {
            MessagingAnalytics.logNotificationDismiss(putExtras);
        }
    }
}
