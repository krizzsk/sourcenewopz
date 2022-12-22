package com.didichuxing.omega.sdk.common.safe;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.didi.entrega.customer.app.constant.Const;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.record.Event;

public class SafetyEditTextSDK {
    public static boolean SWITCH_TYPING_MONITOR = false;
    /* access modifiers changed from: private */
    public static int delete = 0;
    private static View.OnAttachStateChangeListener safetyAttachListener = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            long currentTimeMillis = System.currentTimeMillis() - SafetyEditTextSDK.startTypingTime;
            Event event = new Event("OMGSafeTyping");
            Security.putEventText(event, SafetyEditTextSDK.text);
            event.putAttr("tl", Long.valueOf(currentTimeMillis));
            event.putAttr("dl", Integer.valueOf(SafetyEditTextSDK.delete));
            event.putAttr(Const.PageParams.COUNT, Integer.valueOf(SafetyEditTextSDK.text.length()));
            Tracker.trackRealtimeEvent(event);
            long unused = SafetyEditTextSDK.startTypingTime = -1;
            String unused2 = SafetyEditTextSDK.text = "";
            int unused3 = SafetyEditTextSDK.delete = 0;
        }
    };
    private static TextWatcher safetyWatcher = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (SafetyEditTextSDK.startTypingTime == -1) {
                long unused = SafetyEditTextSDK.startTypingTime = System.currentTimeMillis();
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String unused = SafetyEditTextSDK.text = charSequence.toString();
            if (i2 > 0) {
                SafetyEditTextSDK.access$208();
            }
        }
    };
    /* access modifiers changed from: private */
    public static long startTypingTime = -1;
    /* access modifiers changed from: private */
    public static String text = "";

    static /* synthetic */ int access$208() {
        int i = delete;
        delete = i + 1;
        return i;
    }

    public static void bindEditText(EditText editText) {
        if (editText != null && SWITCH_TYPING_MONITOR) {
            editText.addTextChangedListener(safetyWatcher);
            editText.addOnAttachStateChangeListener(safetyAttachListener);
        }
    }
}
