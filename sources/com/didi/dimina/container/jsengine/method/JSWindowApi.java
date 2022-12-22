package com.didi.dimina.container.jsengine.method;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.jsengine.JSArray;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.util.LogUtil;
import java.util.HashMap;
import java.util.Map;

public class JSWindowApi implements Handler.Callback {

    /* renamed from: a */
    private final Handler f16838a;

    /* renamed from: b */
    private final Map<String, MessageArg> f16839b = new HashMap();

    public JSWindowApi(DMMina dMMina) {
        JSEngineWrapper jSEngine = dMMina.getJSEngine();
        this.f16838a = new Handler(jSEngine.getLooper() == null ? Looper.getMainLooper() : jSEngine.getLooper(), this);
    }

    public void setTimeout(JSArray jSArray, CallbackFunction callbackFunction) {
        String b = m12464b(jSArray);
        long a = m12461a(jSArray);
        if (b == null || TextUtils.isEmpty(b) || a < 0) {
            LogUtil.m13409e("clearTimeout:funcId or timeout is invalid");
            return;
        }
        MessageArg create = MessageArg.create(b, a, callbackFunction);
        this.f16839b.put(b, create);
        m12462a(0, create);
    }

    public void setInterval(JSArray jSArray, CallbackFunction callbackFunction) {
        String b = m12464b(jSArray);
        long a = m12461a(jSArray);
        if (b == null || TextUtils.isEmpty(b) || a < 0) {
            LogUtil.m13409e("clearTimeout:funcId or interval is invalid");
            return;
        }
        MessageArg create = MessageArg.create(b, a, callbackFunction);
        this.f16839b.put(b, create);
        m12462a(1, create);
    }

    public void clearTimeout(JSArray jSArray) {
        String b = m12464b(jSArray);
        if (TextUtils.isEmpty(b)) {
            LogUtil.m13409e("clearTimeout:funcId is invalid");
            return;
        }
        m12463a(0, (Object) this.f16839b.get(b));
        this.f16839b.remove(b);
    }

    public void clearInterval(JSArray jSArray) {
        String b = m12464b(jSArray);
        if (TextUtils.isEmpty(b)) {
            LogUtil.m13409e("clearInterval: funcId is invalid");
            return;
        }
        m12463a(1, (Object) this.f16839b.get(b));
        this.f16839b.remove(b);
    }

    public void release() {
        LogUtil.m13411i("Timer removeAllMessages: ");
        this.f16838a.removeCallbacksAndMessages((Object) null);
        this.f16839b.clear();
    }

    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        int i = message.what;
        Object obj = message.obj;
        if (!(obj instanceof MessageArg)) {
            return false;
        }
        MessageArg messageArg = (MessageArg) obj;
        if (i == 0) {
            messageArg.callback.onCallBack(messageArg.funcId);
            this.f16839b.remove(messageArg.funcId);
        } else if (i != 1) {
            return false;
        } else {
            messageArg.callback.onCallBack(messageArg.funcId);
            m12462a(message.what, messageArg);
        }
        return true;
    }

    /* renamed from: a */
    private void m12463a(int i, Object obj) {
        if (obj != null) {
            this.f16838a.removeMessages(i, obj);
        }
    }

    /* renamed from: a */
    private void m12462a(int i, MessageArg messageArg) {
        if (messageArg.delayMills < 0 || TextUtils.isEmpty(messageArg.funcId)) {
            LogUtil.m13409e("postMessage:delayMills or funcId is invalid");
            return;
        }
        this.f16838a.sendMessageDelayed(this.f16838a.obtainMessage(i, messageArg), messageArg.delayMills);
    }

    /* renamed from: a */
    private long m12461a(JSArray jSArray) {
        try {
            if (jSArray.length() < 2) {
                return -1;
            }
            return ((Number) jSArray.get(1)).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: b */
    private String m12464b(JSArray jSArray) {
        try {
            if (jSArray.length() < 1) {
                return null;
            }
            return String.valueOf(jSArray.getInteger(0));
        } catch (Exception unused) {
            return null;
        }
    }

    public Map<String, MessageArg> getMessageArgs() {
        return this.f16839b;
    }

    private static class MessageArg {
        CallbackFunction callback;
        long delayMills;
        String funcId;

        private MessageArg() {
        }

        public static MessageArg create(String str, long j, CallbackFunction callbackFunction) {
            MessageArg messageArg = new MessageArg();
            messageArg.funcId = str;
            messageArg.callback = callbackFunction;
            messageArg.delayMills = j;
            return messageArg;
        }
    }
}
