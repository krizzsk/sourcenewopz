package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* renamed from: com.firebase.jobdispatcher.f */
/* compiled from: GooglePlayMessengerCallback */
class C17818f implements JobCallback {

    /* renamed from: a */
    private final Messenger f52206a;

    /* renamed from: b */
    private final String f52207b;

    C17818f(Messenger messenger, String str) {
        this.f52206a = messenger;
        this.f52207b = str;
    }

    public void jobFinished(int i) {
        try {
            this.f52206a.send(m37231a(i));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private Message m37231a(int i) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i;
        Bundle bundle = new Bundle();
        bundle.putString("tag", this.f52207b);
        obtain.setData(bundle);
        return obtain;
    }
}
