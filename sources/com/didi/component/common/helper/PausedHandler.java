package com.didi.component.common.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class PausedHandler extends Handler {

    /* renamed from: a */
    private final Vector<Message> f11603a = new Vector<>();

    /* renamed from: b */
    private volatile boolean f11604b;

    public PausedHandler(Looper looper) {
        super(looper);
    }

    public void resume() {
        this.f11604b = false;
        while (this.f11603a.size() > 0) {
            final ArrayList arrayList = new ArrayList(this.f11603a);
            this.f11603a.clear();
            post(new Runnable() {
                public void run() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Message message = (Message) it.next();
                        PausedHandler.this.processMessage(message);
                        message.recycle();
                    }
                }
            });
        }
    }

    public void pause() {
        this.f11604b = true;
    }

    public boolean isPaused() {
        return this.f11604b;
    }

    /* access modifiers changed from: protected */
    public void processMessage(Message message) {
        if (message.obj != null) {
            UiThreadHandler.postDelayed((Runnable) message.obj, 100);
        }
    }

    public final void handleMessage(Message message) {
        if (this.f11604b) {
            this.f11603a.add(Message.obtain(message));
            return;
        }
        processMessage(message);
    }
}
