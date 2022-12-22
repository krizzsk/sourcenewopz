package com.didi.dimina.starbox.module.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p106ui.dialog.BaseModal;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class InputModalSubJSBridge {
    public static final String MODAL_PARAM_CANCEL_COLOR = "cancelColor";
    public static final String MODAL_PARAM_CANCEL_TEXT = "cancelText";
    public static final String MODAL_PARAM_CONFIRM_COLOR = "confirmColor";
    public static final String MODAL_PARAM_CONFIRM_TEXT = "confirmText";
    public static final String MODAL_PARAM_CONTENT = "content";
    public static final String MODAL_PARAM_EDITABLE = "editable";
    public static final String MODAL_PARAM_PLACEHOLDER_TEXT = "placeholderText";
    public static final String MODAL_PARAM_SHOW_CANCEL = "showCancel";
    public static final String MODAL_PARAM_TITLE = "title";

    /* renamed from: a */
    private final Activity f18007a;

    /* renamed from: b */
    private BaseModal f18008b;

    InputModalSubJSBridge(Activity activity) {
        this.f18007a = activity;
    }

    public void showInputModal(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                InputModalSubJSBridge.this.m13466a(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m13466a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.f18008b == null) {
            BaseModal baseModal = new BaseModal(this.f18007a, R.style.DiminaDialogNoBg);
            this.f18008b = baseModal;
            baseModal.setCancelable(false);
            this.f18008b.setCanceledOnTouchOutside(false);
        }
        m13465a(jSONObject);
        this.f18008b.setPositiveButtonListener(new View.OnClickListener(callbackFunction) {
            public final /* synthetic */ CallbackFunction f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                InputModalSubJSBridge.this.m13468b(this.f$1, view);
            }
        });
        if (this.f18008b.isShowCancel()) {
            this.f18008b.setNegativeButtonListener(new View.OnClickListener(callbackFunction) {
                public final /* synthetic */ CallbackFunction f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    InputModalSubJSBridge.this.m13463a(this.f$1, view);
                }
            });
        }
        SystemUtils.showDialog(this.f18008b);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m13468b(CallbackFunction callbackFunction, View view) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, XPanelScene.SCENE_CONFIRM, true);
        JSONUtil.put(jSONObject, "content", (Object) this.f18008b.getContent());
        CallBackUtil.onSuccess(jSONObject, callbackFunction);
        this.f18008b.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m13463a(CallbackFunction callbackFunction, View view) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "cancel", true);
        CallBackUtil.onSuccess(jSONObject, callbackFunction);
        this.f18008b.dismiss();
    }

    /* renamed from: a */
    private void m13465a(JSONObject jSONObject) {
        m13462a();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            char c = 65535;
            try {
                switch (next.hashCode()) {
                    case -1597633271:
                        if (next.equals("cancelColor")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 110371416:
                        if (next.equals("title")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 307364823:
                        if (next.equals("showCancel")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 344408077:
                        if (next.equals("confirmText")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 951530617:
                        if (next.equals("content")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1602416228:
                        if (next.equals(MODAL_PARAM_EDITABLE)) {
                            c = 8;
                            break;
                        }
                        break;
                    case 1750748480:
                        if (next.equals(MODAL_PARAM_PLACEHOLDER_TEXT)) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1888623303:
                        if (next.equals("cancelText")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 2071302275:
                        if (next.equals("confirmColor")) {
                            c = 6;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        m13464a(jSONObject.getString(next));
                        break;
                    case 1:
                        m13469b(jSONObject.getString(next));
                        break;
                    case 2:
                        m13467a(jSONObject.getBoolean(next));
                        break;
                    case 3:
                        m13471c(jSONObject.getString(next));
                        break;
                    case 4:
                        m13472d(jSONObject.getString(next));
                        break;
                    case 5:
                        m13473e(jSONObject.getString(next));
                        break;
                    case 6:
                        m13474f(jSONObject.getString(next));
                        break;
                    case 7:
                        m13475g(jSONObject.getString(next));
                        break;
                    case 8:
                        m13470b(jSONObject.getBoolean(next));
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m13462a() {
        this.f18008b.reset();
    }

    /* renamed from: a */
    private void m13467a(boolean z) {
        this.f18008b.setShowCancel(z);
    }

    /* renamed from: a */
    private void m13464a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f18008b.setDialogTitle(str);
        }
    }

    /* renamed from: b */
    private void m13469b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f18008b.setContent(str);
        }
    }

    /* renamed from: c */
    private void m13471c(String str) {
        this.f18008b.setNegativeButton(str);
    }

    /* renamed from: d */
    private void m13472d(String str) {
        this.f18008b.setNegativeButtonTextColor(str);
    }

    /* renamed from: e */
    private void m13473e(String str) {
        this.f18008b.setPositiveButtonText(str);
    }

    /* renamed from: f */
    private void m13474f(String str) {
        this.f18008b.setPositiveButtonTextColor(str);
    }

    /* renamed from: g */
    private void m13475g(String str) {
        this.f18008b.setPlaceholderText(str);
    }

    /* renamed from: b */
    private void m13470b(boolean z) {
        this.f18008b.setModalEditable(z);
    }
}
