package com.didi.dimina.container.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p106ui.dialog.BaseModal;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ModalSubJSBridge {
    public static final String MODAL_PARAM_CANCEL_COLOR = "cancelColor";
    public static final String MODAL_PARAM_CANCEL_TEXT = "cancelText";
    public static final String MODAL_PARAM_CONFIRM_COLOR = "confirmColor";
    public static final String MODAL_PARAM_CONFIRM_TEXT = "confirmText";
    public static final String MODAL_PARAM_CONTENT = "content";
    public static final String MODAL_PARAM_SHOW_CANCEL = "showCancel";
    public static final String MODAL_PARAM_TITLE = "title";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public BaseModal f16612a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f16613b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CopyOnWriteArrayList<CallbackFunction> f16614c = new CopyOnWriteArrayList<>();

    public ModalSubJSBridge(Context context) {
        this.f16613b = context;
        LogUtil.m13411i("ModalSubJSBridge init");
    }

    public void showModal(final JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.f16614c.add(callbackFunction);
        UIHandlerUtil.post(new Runnable() {
            public void run() {
                if (ModalSubJSBridge.this.f16612a == null) {
                    BaseModal unused = ModalSubJSBridge.this.f16612a = new BaseModal(ModalSubJSBridge.this.f16613b, R.style.DiminaDialogNoBg);
                    ModalSubJSBridge.this.f16612a.setCancelable(false);
                    ModalSubJSBridge.this.f16612a.setCanceledOnTouchOutside(false);
                }
                ModalSubJSBridge.this.m12226a(jSONObject);
                ModalSubJSBridge.this.f16612a.setPositiveButtonListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        JSONObject jSONObject = new JSONObject();
                        JSONUtil.put(jSONObject, "success", true);
                        JSONObject jSONObject2 = new JSONObject();
                        JSONUtil.put(jSONObject2, XPanelScene.SCENE_CONFIRM, true);
                        JSONUtil.put(jSONObject, "data", (Object) jSONObject2);
                        Iterator it = ModalSubJSBridge.this.f16614c.iterator();
                        while (it.hasNext()) {
                            ((CallbackFunction) it.next()).onCallBack(jSONObject);
                        }
                        ModalSubJSBridge.this.f16614c.clear();
                        ModalSubJSBridge.this.f16612a.dismiss();
                    }
                });
                if (ModalSubJSBridge.this.f16612a.isShowCancel()) {
                    ModalSubJSBridge.this.f16612a.setNegativeButtonListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            JSONObject jSONObject = new JSONObject();
                            JSONUtil.put(jSONObject, "success", true);
                            JSONObject jSONObject2 = new JSONObject();
                            JSONUtil.put(jSONObject2, "cancel", true);
                            JSONUtil.put(jSONObject, "data", (Object) jSONObject2);
                            Iterator it = ModalSubJSBridge.this.f16614c.iterator();
                            while (it.hasNext()) {
                                ((CallbackFunction) it.next()).onCallBack(jSONObject);
                            }
                            ModalSubJSBridge.this.f16614c.clear();
                            ModalSubJSBridge.this.f16612a.dismiss();
                        }
                    });
                }
                SystemUtils.showDialog(ModalSubJSBridge.this.f16612a);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12226a(JSONObject jSONObject) {
        m12223a();
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
                        m12225a(jSONObject.getString(next));
                        break;
                    case 1:
                        m12229b(jSONObject.getString(next));
                        break;
                    case 2:
                        m12227a(jSONObject.getBoolean(next));
                        break;
                    case 3:
                        m12231c(jSONObject.getString(next));
                        break;
                    case 4:
                        m12232d(jSONObject.getString(next));
                        break;
                    case 5:
                        m12233e(jSONObject.getString(next));
                        break;
                    case 6:
                        m12234f(jSONObject.getString(next));
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m12223a() {
        this.f16612a.reset();
    }

    /* renamed from: a */
    private void m12227a(boolean z) {
        this.f16612a.setShowCancel(z);
    }

    /* renamed from: a */
    private void m12225a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f16612a.setDialogTitle(str);
        }
    }

    /* renamed from: b */
    private void m12229b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f16612a.setContent(str);
        }
    }

    /* renamed from: c */
    private void m12231c(String str) {
        this.f16612a.setNegativeButton(str);
    }

    /* renamed from: d */
    private void m12232d(String str) {
        this.f16612a.setNegativeButtonTextColor(str);
    }

    /* renamed from: e */
    private void m12233e(String str) {
        this.f16612a.setPositiveButtonText(str);
    }

    /* renamed from: f */
    private void m12234f(String str) {
        this.f16612a.setPositiveButtonTextColor(str);
    }
}
