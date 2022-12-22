package p242io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import p242io.flutter.embedding.android.KeyboardManager;
import p242io.flutter.embedding.engine.systemchannels.KeyEventChannel;

/* renamed from: io.flutter.embedding.android.KeyChannelResponder */
public class KeyChannelResponder implements KeyboardManager.Responder {

    /* renamed from: a */
    private static final String f57544a = "KeyChannelResponder";

    /* renamed from: b */
    private final KeyEventChannel f57545b;

    /* renamed from: c */
    private int f57546c;

    public KeyChannelResponder(KeyEventChannel keyEventChannel) {
        this.f57545b = keyEventChannel;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Character mo172294a(int i) {
        char c = (char) i;
        if ((Integer.MIN_VALUE & i) != 0) {
            int i2 = i & Integer.MAX_VALUE;
            int i3 = this.f57546c;
            if (i3 != 0) {
                this.f57546c = KeyCharacterMap.getDeadChar(i3, i2);
            } else {
                this.f57546c = i2;
            }
        } else {
            int i4 = this.f57546c;
            if (i4 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i4, i);
                if (deadChar > 0) {
                    c = (char) deadChar;
                }
                this.f57546c = 0;
            }
        }
        return Character.valueOf(c);
    }

    public void handleEvent(KeyEvent keyEvent, KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        int action = keyEvent.getAction();
        boolean z = false;
        if (action == 0 || action == 1) {
            KeyEventChannel.FlutterKeyEvent flutterKeyEvent = new KeyEventChannel.FlutterKeyEvent(keyEvent, mo172294a(keyEvent.getUnicodeChar()));
            if (action != 0) {
                z = true;
            }
            this.f57545b.sendFlutterKeyEvent(flutterKeyEvent, z, new KeyEventChannel.EventResponseHandler() {
                public final void onFrameworkResponse(boolean z) {
                    KeyboardManager.Responder.OnKeyEventHandledCallback.this.onKeyEventHandled(Boolean.valueOf(z));
                }
            });
            return;
        }
        onKeyEventHandledCallback.onKeyEventHandled(false);
    }
}
