package p242io.flutter.embedding.android;

import android.view.KeyEvent;
import android.view.View;
import java.util.HashSet;
import p242io.flutter.Log;
import p242io.flutter.plugin.editing.TextInputPlugin;

/* renamed from: io.flutter.embedding.android.KeyboardManager */
public class KeyboardManager {

    /* renamed from: a */
    private static final String f57547a = "KeyboardManager";

    /* renamed from: b */
    private final HashSet<KeyEvent> f57548b = new HashSet<>();

    /* renamed from: c */
    private final TextInputPlugin f57549c;

    /* renamed from: d */
    private final View f57550d;
    protected final Responder[] responders;

    /* renamed from: io.flutter.embedding.android.KeyboardManager$Responder */
    interface Responder {

        /* renamed from: io.flutter.embedding.android.KeyboardManager$Responder$OnKeyEventHandledCallback */
        public interface OnKeyEventHandledCallback {
            void onKeyEventHandled(Boolean bool);
        }

        void handleEvent(KeyEvent keyEvent, OnKeyEventHandledCallback onKeyEventHandledCallback);
    }

    public KeyboardManager(View view, TextInputPlugin textInputPlugin, Responder[] responderArr) {
        this.f57550d = view;
        this.f57549c = textInputPlugin;
        this.responders = responderArr;
    }

    /* renamed from: io.flutter.embedding.android.KeyboardManager$PerEventCallbackBuilder */
    private class PerEventCallbackBuilder {
        boolean isEventHandled = false;
        final KeyEvent keyEvent;
        int unrepliedCount = KeyboardManager.this.responders.length;

        /* renamed from: io.flutter.embedding.android.KeyboardManager$PerEventCallbackBuilder$Callback */
        private class Callback implements Responder.OnKeyEventHandledCallback {
            boolean isCalled;

            private Callback() {
                this.isCalled = false;
            }

            public void onKeyEventHandled(Boolean bool) {
                if (!this.isCalled) {
                    this.isCalled = true;
                    PerEventCallbackBuilder.this.unrepliedCount--;
                    PerEventCallbackBuilder perEventCallbackBuilder = PerEventCallbackBuilder.this;
                    perEventCallbackBuilder.isEventHandled = bool.booleanValue() | perEventCallbackBuilder.isEventHandled;
                    if (PerEventCallbackBuilder.this.unrepliedCount == 0 && !PerEventCallbackBuilder.this.isEventHandled) {
                        KeyboardManager.this.m41409a(PerEventCallbackBuilder.this.keyEvent);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
            }
        }

        PerEventCallbackBuilder(KeyEvent keyEvent2) {
            this.keyEvent = keyEvent2;
        }

        public Responder.OnKeyEventHandledCallback buildCallback() {
            return new Callback();
        }
    }

    public boolean handleEvent(KeyEvent keyEvent) {
        if (this.f57548b.remove(keyEvent)) {
            return false;
        }
        if (this.responders.length > 0) {
            PerEventCallbackBuilder perEventCallbackBuilder = new PerEventCallbackBuilder(keyEvent);
            for (Responder handleEvent : this.responders) {
                handleEvent.handleEvent(keyEvent, perEventCallbackBuilder.buildCallback());
            }
            return true;
        }
        m41409a(keyEvent);
        return true;
    }

    public void destroy() {
        int size = this.f57548b.size();
        if (size > 0) {
            Log.m41142w(f57547a, "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41409a(KeyEvent keyEvent) {
        if (!this.f57549c.handleKeyEvent(keyEvent) && this.f57550d != null) {
            this.f57548b.add(keyEvent);
            this.f57550d.getRootView().dispatchKeyEvent(keyEvent);
            if (this.f57548b.remove(keyEvent)) {
                Log.m41142w(f57547a, "A redispatched key event was consumed before reaching KeyboardManager");
            }
        }
    }
}
