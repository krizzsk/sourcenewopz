package com.didi.sdk.sidebar.compatible;

import android.os.Message;
import com.didi.sdk.event.DefaultEvent;

public class MsgAndEventUtil {
    public static DefaultEvent msgToDefaultEvent(String str, Message message) {
        if (message == null) {
            return null;
        }
        return new DefaultEvent(str, message.what, message.arg1, message.arg2, message.obj);
    }

    public static Message EventToMsg(DefaultEvent defaultEvent) {
        if (defaultEvent == null) {
            return null;
        }
        Message obtain = Message.obtain();
        obtain.what = defaultEvent.what;
        obtain.arg1 = defaultEvent.arg1;
        obtain.arg2 = defaultEvent.arg2;
        obtain.obj = defaultEvent.obj;
        return obtain;
    }
}
