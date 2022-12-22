package com.didi.sdk.event;

import android.os.Bundle;
import android.os.Message;

public class DefaultEvent implements Event {

    /* renamed from: a */
    Bundle f35838a;
    public int arg1;
    public int arg2;

    /* renamed from: b */
    private String f35839b;
    public Object obj;
    public int what;

    public DefaultEvent(String str) {
        this.f35839b = str;
    }

    public DefaultEvent(String str, int i) {
        this.f35839b = str;
        this.what = i;
    }

    public DefaultEvent(String str, int i, int i2, int i3) {
        this.f35839b = str;
        this.what = i;
        this.arg1 = i2;
        this.arg2 = i3;
    }

    public DefaultEvent(String str, int i, int i2, int i3, Object obj2) {
        this.f35839b = str;
        this.what = i;
        this.arg1 = i2;
        this.arg2 = i3;
        this.obj = obj2;
    }

    public DefaultEvent(String str, int i, Object obj2) {
        this.f35839b = str;
        this.what = i;
        this.obj = obj2;
    }

    public DefaultEvent(DefaultEvent defaultEvent) {
        this.f35839b = defaultEvent.f35839b;
        this.what = defaultEvent.what;
        this.arg1 = defaultEvent.arg1;
        this.arg2 = defaultEvent.arg2;
        this.obj = defaultEvent.obj;
        if (defaultEvent.f35838a != null) {
            this.f35838a = new Bundle(defaultEvent.f35838a);
        }
    }

    public String getType() {
        return this.f35839b;
    }

    public Bundle getData() {
        if (this.f35838a == null) {
            this.f35838a = new Bundle();
        }
        return this.f35838a;
    }

    public Bundle peekData() {
        return this.f35838a;
    }

    public void setData(Bundle bundle) {
        this.f35838a = bundle;
    }

    @Deprecated
    public static DefaultEvent obtainDefaultEvent(String str, Message message) {
        DefaultEvent defaultEvent = new DefaultEvent(str, message.what, message.arg1, message.arg2, message.obj);
        if (message.peekData() != null) {
            defaultEvent.setData(new Bundle(message.peekData()));
        }
        message.recycle();
        return defaultEvent;
    }

    @Deprecated
    public Message obtainAndroidMessage() {
        Message obtain = Message.obtain();
        obtain.what = this.what;
        obtain.arg1 = this.arg1;
        obtain.arg2 = this.arg2;
        obtain.obj = this.obj;
        if (this.f35838a != null) {
            obtain.setData(new Bundle(this.f35838a));
        }
        return obtain;
    }

    public String toString() {
        return "DefaultEvent{" + "type='" + this.f35839b + '\'' + ", what=" + this.what + ", arg1=" + this.arg1 + ", arg2=" + this.arg2 + ", obj=" + this.obj + ", data=" + this.f35838a + '}';
    }
}
