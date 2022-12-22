package com.firebase.jobdispatcher;

import android.app.AppOpsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.JobInvocation;

/* renamed from: com.firebase.jobdispatcher.e */
/* compiled from: GooglePlayMessageHandler */
class C17817e extends Handler {

    /* renamed from: a */
    static final int f52201a = 1;

    /* renamed from: b */
    static final int f52202b = 2;

    /* renamed from: c */
    static final int f52203c = 3;

    /* renamed from: d */
    private static final int f52204d = 4;

    /* renamed from: e */
    private final GooglePlayReceiver f52205e;

    public C17817e(Looper looper, GooglePlayReceiver googlePlayReceiver) {
        super(looper);
        this.f52205e = googlePlayReceiver;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            try {
                ((AppOpsManager) this.f52205e.getApplicationContext().getSystemService("appops")).checkPackage(message.sendingUid, "com.google.android.gms");
                int i = message.what;
                if (i == 1) {
                    m37229a(message);
                } else if (i == 2) {
                    m37230b(message);
                } else if (i != 4) {
                    SystemUtils.log(6, "FJD.GooglePlayReceiver", "Unrecognized message received: " + message, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayMessageHandler", 79);
                }
            } catch (SecurityException unused) {
                SystemUtils.log(6, "FJD.GooglePlayReceiver", "Message was not sent from GCM.", (Throwable) null, "com.firebase.jobdispatcher.GooglePlayMessageHandler", 61);
            }
        }
    }

    /* renamed from: a */
    private void m37229a(Message message) {
        Bundle data = message.getData();
        Messenger messenger = message.replyTo;
        String string = data.getString("tag");
        if (messenger != null && string != null) {
            this.f52205e.mo131099b().mo131082a(this.f52205e.mo131096a((JobCallback) new C17818f(messenger, string), data));
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            SystemUtils.log(3, "FJD.GooglePlayReceiver", "Invalid start execution message.", (Throwable) null, "com.firebase.jobdispatcher.GooglePlayMessageHandler", 91);
        }
    }

    /* renamed from: b */
    private void m37230b(Message message) {
        JobInvocation.Builder b = GooglePlayReceiver.m37199c().mo131192b(message.getData());
        if (b != null) {
            ExecutionDelegator.m37190a(b.build(), true);
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            SystemUtils.log(3, "FJD.GooglePlayReceiver", "Invalid stop execution message.", (Throwable) null, "com.firebase.jobdispatcher.GooglePlayMessageHandler", 105);
        }
    }
}
