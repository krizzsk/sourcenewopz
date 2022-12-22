package com.didi.dimina.container.p106ui.custom.input;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.dimina.container.p106ui.custom.CustomComponent;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.p106ui.webview.DMWebViewContainer;
import com.didi.dimina.container.util.KeyboardUtils;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.custom.input.InputComponent */
public class InputComponent extends CustomComponent implements WebViewEngine.OnScrollChangedCallback {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7614a f17513a = new C7614a();

    /* renamed from: b */
    private int f17514b = -1;
    protected EditText editText;
    protected InputUtil inputUtil = new InputUtil();

    /* renamed from: a */
    private boolean m13018a(View view, MotionEvent motionEvent) {
        if (!(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int height = view.getHeight() + i2;
        int width = view.getWidth() + i;
        if (motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) height)) {
            return true;
        }
        return false;
    }

    public View onMounted(Context context, JSONObject jSONObject) {
        C7615b.m13031a(this.f17513a, jSONObject);
        this.mWebView.addScrollChangedCallback(this);
        Activity activity = this.mWebView.getActivity();
        if (!activity.isDestroyed() && !activity.isFinishing()) {
            Window window = activity.getWindow();
            if (this.f17514b == -1) {
                this.f17514b = window.getAttributes().softInputMode;
            }
            window.setSoftInputMode(48);
        }
        AppCompatEditText appCompatEditText = new AppCompatEditText(this.mWebView.getActivity());
        this.editText = appCompatEditText;
        appCompatEditText.setSingleLine();
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setBackgroundColor(0);
        this.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                InputComponent.this.m13017a(view, z);
            }
        });
        this.editText.addTextChangedListener(new C7616c() {
            public void afterTextChanged(Editable editable) {
                if ((InputComponent.this.editText.hasFocus() || !TextUtils.isEmpty(editable)) && !TextUtils.equals(InputComponent.this.f17513a.f17524d, editable)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("value", editable.toString());
                    hashMap.put("cursor", Integer.valueOf(InputComponent.this.editText.getSelectionStart()));
                    hashMap.put("height", Integer.valueOf(InputComponent.this.inputUtil.f17515a));
                    InputComponent.this.emitEvent2WebView("bindinput", hashMap);
                }
            }
        });
        return this.editText;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m13017a(View view, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", this.editText.getText().toString());
        hashMap.put("cursor", Integer.valueOf(this.editText.getSelectionStart()));
        hashMap.put("height", Integer.valueOf(this.inputUtil.f17515a));
        if (z) {
            int[] iArr = new int[2];
            this.editText.getLocationInWindow(iArr);
            KeyboardUtils.focusedComponentY = ((this.editText.getHeight() + iArr[1]) - this.mDMPage.getWebTitleBar().getHeight()) - KeyboardUtils.getStatusBarHeight();
        }
        emitEvent2WebView(z ? "bindfocus" : "bindblur", hashMap);
    }

    /* renamed from: a */
    private void m13016a() {
        DMWebViewContainer container;
        this.editText.setBackgroundColor(C7615b.m13028a(this.f17513a));
        this.editText.setText(this.f17513a.f17524d);
        this.editText.setHint(this.f17513a.f17526f);
        this.editText.setHintTextColor(C7615b.m13035e(this.f17513a));
        this.editText.setTextSize(C7615b.m13034d(this.f17513a));
        this.editText.setInputType(C7615b.m13036f(this.f17513a));
        this.editText.setTextColor(C7615b.m13033c(this.f17513a));
        this.editText.setGravity(C7615b.m13032b(this.f17513a));
        if (this.f17513a.f17527g) {
            this.editText.setEnabled(false);
        }
        if (this.f17513a.f17528h > 0) {
            this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f17513a.f17528h)});
        }
        if (this.f17513a.f17529i) {
            this.editText.setEnabled(true);
            this.editText.setFocusable(true);
            this.editText.setFocusableInTouchMode(true);
            this.editText.requestFocus();
            InputUtil.m13024b((View) this.editText);
        }
        if (this.f17513a.f17530j > 0) {
            this.editText.setSelection(Math.min(this.f17513a.f17530j, this.editText.getText().length()));
        }
        this.editText.setImeOptions(C7615b.m13037g(this.f17513a));
        if (!this.f17513a.confirmHold) {
            this.editText.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i != 66) {
                        return false;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("value", InputComponent.this.editText.getText().toString());
                    InputComponent.this.emitEvent2WebView("bindconfirm", hashMap);
                    InputUtil.m13025c(InputComponent.this.editText);
                    return false;
                }
            });
        }
        if (this.f17513a.selectionEnd > 0 && this.f17513a.selectionStart > 0) {
            this.editText.setTextIsSelectable(true);
            this.editText.setSelection(this.f17513a.selectionStart, this.f17513a.selectionEnd);
        }
        if (!this.f17513a.holdKeyboard && (container = this.mWebView.getContainer()) != null) {
            container.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return InputComponent.this.m13019b(view, motionEvent);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ boolean m13019b(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !m13018a((View) this.editText, motionEvent)) {
            return false;
        }
        InputUtil.m13025c(this.editText);
        return false;
    }

    public void onPropertiesUpdate(JSONObject jSONObject) {
        if (this.editText != null && !jSONObject.optBoolean(SameLayerRenderingUtil.KEY_CALL_FROM_D6, false)) {
            C7615b.m13031a(this.f17513a, jSONObject);
            m13016a();
        }
    }

    public void onDestroyed() {
        if (this.mWebView != null) {
            this.mWebView.removeScrollChangedCallback(this);
            Activity activity = this.mWebView.getActivity();
            if (activity != null && !activity.isDestroyed()) {
                Window window = activity.getWindow();
                int i = this.f17514b;
                if (i != -1) {
                    window.setSoftInputMode(i);
                }
            }
        }
        EditText editText2 = this.editText;
        if (editText2 != null) {
            this.inputUtil.mo56233a((View) editText2);
            try {
                InputUtil.m13025c(this.editText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.editText != null && ((!SameLayerRenderingUtil.isSameLayerRenderingReady(this.mWebView)) && (!TextUtils.equals(this.f17513a.f17531k, "fixed")))) {
            this.editText.setTranslationY((float) (-i2));
        }
    }
}
