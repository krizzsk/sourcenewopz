package p242io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import android.view.InputDevice;
import android.view.KeyEvent;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.JSONMessageCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.KeyEventChannel */
public class KeyEventChannel {

    /* renamed from: a */
    private static final String f57709a = "KeyEventChannel";
    public final BasicMessageChannel<Object> channel;

    /* renamed from: io.flutter.embedding.engine.systemchannels.KeyEventChannel$EventResponseHandler */
    public interface EventResponseHandler {
        void onFrameworkResponse(boolean z);
    }

    public KeyEventChannel(BinaryMessenger binaryMessenger) {
        this.channel = new BasicMessageChannel<>(binaryMessenger, "flutter/keyevent", JSONMessageCodec.INSTANCE);
    }

    public void sendFlutterKeyEvent(FlutterKeyEvent flutterKeyEvent, boolean z, EventResponseHandler eventResponseHandler) {
        this.channel.send(m41487a(flutterKeyEvent, z), m41486a(eventResponseHandler));
    }

    /* renamed from: a */
    private Map<String, Object> m41487a(FlutterKeyEvent flutterKeyEvent, boolean z) {
        int i;
        HashMap hashMap = new HashMap();
        hashMap.put("type", z ? "keyup" : "keydown");
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(flutterKeyEvent.event.getFlags()));
        int i2 = 0;
        hashMap.put("plainCodePoint", Integer.valueOf(flutterKeyEvent.event.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(flutterKeyEvent.event.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(flutterKeyEvent.event.getKeyCode()));
        hashMap.put(InternalJSMethod.SCAN_CODE, Integer.valueOf(flutterKeyEvent.event.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(flutterKeyEvent.event.getMetaState()));
        if (flutterKeyEvent.complexCharacter != null) {
            hashMap.put(FirebaseAnalytics.Param.CHARACTER, flutterKeyEvent.complexCharacter.toString());
        }
        hashMap.put("source", Integer.valueOf(flutterKeyEvent.event.getSource()));
        InputDevice device = InputDevice.getDevice(flutterKeyEvent.event.getDeviceId());
        if (device == null || Build.VERSION.SDK_INT < 19) {
            i = 0;
        } else {
            i2 = device.getVendorId();
            i = device.getProductId();
        }
        hashMap.put("vendorId", Integer.valueOf(i2));
        hashMap.put("productId", Integer.valueOf(i));
        hashMap.put("deviceId", Integer.valueOf(flutterKeyEvent.event.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(flutterKeyEvent.event.getRepeatCount()));
        return hashMap;
    }

    /* renamed from: a */
    private static BasicMessageChannel.Reply<Object> m41486a(EventResponseHandler eventResponseHandler) {
        return new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                KeyEventChannel.m41488a(KeyEventChannel.EventResponseHandler.this, obj);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m41488a(EventResponseHandler eventResponseHandler, Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e) {
                Log.m41136e(f57709a, "Unable to unpack JSON message: " + e);
            }
        }
        eventResponseHandler.onFrameworkResponse(z);
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.KeyEventChannel$FlutterKeyEvent */
    public static class FlutterKeyEvent {
        public final Character complexCharacter;
        public final KeyEvent event;

        public FlutterKeyEvent(KeyEvent keyEvent) {
            this(keyEvent, (Character) null);
        }

        public FlutterKeyEvent(KeyEvent keyEvent, Character ch) {
            this.event = keyEvent;
            this.complexCharacter = ch;
        }
    }
}
