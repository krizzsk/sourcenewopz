package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.BaseHybridModule;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.p106ui.custom.ComponentManager;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import org.json.JSONException;
import org.json.JSONObject;

public class DMWebViewJSModule extends BaseHybridModule {
    public static final String EXPORT_NAME = "DMWebViewBridgeModule";
    private Activity mActivity;
    /* access modifiers changed from: private */
    public final DMWebViewJSModuleLazyParameter mParameter = new DMWebViewJSModuleLazyParameter(this.mWebViewDelegate);
    private WebViewEngine mWebViewDelegate;

    public DMWebViewJSModule(WebViewEngine webViewEngine) {
        super(webViewEngine);
        LogUtil.m13411i("DiminaWebViewJSModule init start");
        this.mWebViewDelegate = webViewEngine;
        this.mActivity = webViewEngine.getActivity();
        LogUtil.m13411i("DiminaWebViewJSModule init end");
    }

    @JsInterface({"mounted"})
    public void mounted(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.mWebViewDelegate != null) {
            UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
                public final /* synthetic */ JSONObject f$1;
                public final /* synthetic */ CallbackFunction f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    DMWebViewJSModule.this.lambda$mounted$0$DMWebViewJSModule(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$mounted$0$DMWebViewJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getTouchView().mo54722a(jSONObject, callbackFunction);
    }

    @JsInterface({"updated"})
    public void updated(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.mWebViewDelegate != null) {
            UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
                public final /* synthetic */ JSONObject f$1;
                public final /* synthetic */ CallbackFunction f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    DMWebViewJSModule.this.lambda$updated$1$DMWebViewJSModule(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$updated$1$DMWebViewJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getTouchView().mo54723b(jSONObject, callbackFunction);
    }

    @JsInterface({"attach"})
    public void attach(JSONObject jSONObject, CallbackFunction callbackFunction) {
        WebViewEngine webViewEngine = this.mWebViewDelegate;
        if (webViewEngine != null) {
            UIHandlerUtil.safePost(webViewEngine.getDmMina(), new Runnable(jSONObject) {
                public final /* synthetic */ JSONObject f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DMWebViewJSModule.this.lambda$attach$2$DMWebViewJSModule(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$attach$2$DMWebViewJSModule(JSONObject jSONObject) {
        SameLayerRenderingUtil.createComponent(jSONObject, this.mWebViewDelegate);
    }

    @JsInterface({"propertiesUpdate"})
    public void propertiesUpdate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.mWebViewDelegate != null) {
            UIHandlerUtil.post(new Runnable(jSONObject) {
                public final /* synthetic */ JSONObject f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DMWebViewJSModule.this.lambda$propertiesUpdate$3$DMWebViewJSModule(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$propertiesUpdate$3$DMWebViewJSModule(JSONObject jSONObject) {
        SameLayerRenderingUtil.propertiesUpdate(jSONObject, this.mWebViewDelegate);
    }

    @JsInterface({"destroyed"})
    public void destroyed(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.mWebViewDelegate != null) {
            UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
                public final /* synthetic */ JSONObject f$1;
                public final /* synthetic */ CallbackFunction f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    DMWebViewJSModule.this.lambda$destroyed$4$DMWebViewJSModule(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$destroyed$4$DMWebViewJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getTouchView().mo54724c(jSONObject, callbackFunction);
        SameLayerRenderingUtil.destroyComponent(jSONObject, this.mWebViewDelegate);
    }

    @JsInterface({"comMounted"})
    public void comMounted(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (this.mWebViewDelegate != null) {
            UIHandlerUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DMWebViewJSModule.this.mParameter.getComponent(true).comMounted(jSONObject, callbackFunction);
                }
            });
        }
    }

    @JsInterface({"comUpdated"})
    public void comUpdated(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (this.mWebViewDelegate != null) {
            UIHandlerUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DMWebViewJSModule.this.mParameter.getComponent(true).comUpdated(jSONObject, callbackFunction);
                }
            });
        }
    }

    @JsInterface({"comDestroyed"})
    public void comDestroyed(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (this.mWebViewDelegate != null) {
            UIHandlerUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DMWebViewJSModule.this.mParameter.getComponent(true).comDestroyed(jSONObject, callbackFunction);
                }
            });
        }
    }

    @JsInterface({"hideKeyboard"})
    public void hideKeyboard(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.mWebViewDelegate != null) {
            this.mParameter.getKeyboard().mo54458a(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"showKeyboard"})
    public void showKeyboard(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.mWebViewDelegate != null) {
            this.mParameter.getKeyboard().mo54459b(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"ifOpenVconsole"})
    public void ifOpenVconsole(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getVConsole().ifOpenVConsole(jSONObject, callbackFunction);
    }

    @JsInterface({"vConsoleReady"})
    public void vConsoleReady(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getVConsole().vConsoleReady(jSONObject, callbackFunction);
    }

    @JsInterface({"enableNativeOnPageScroll"})
    public void enableNativeOnPageScroll(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getWebViewPageInner().mo54551b(jSONObject, callbackFunction);
    }

    @JsInterface({"scrollWebViewTo"})
    public void pageScrollTo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getWebViewPageInner().mo54552c(jSONObject, callbackFunction);
    }

    @JsInterface({"invokeWebViewReady"})
    public void invokeWebViewReady(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getWebViewPageInner().invokeWebViewReady(jSONObject, callbackFunction);
    }

    @JsInterface({"domReady"})
    public void domReady(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getWebViewPageInner().mo54550a(jSONObject, callbackFunction);
    }

    @JsInterface({"setBackgroundColor"})
    public void setBackgroundColor(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getPageStyle().setBackgroundColor(jSONObject, callbackFunction);
    }

    @JsInterface({"getEnv"})
    public void getEnv(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("miniprogram", true);
            callbackFunction.onCallBack(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JsInterface({"postMessage"})
    public void postMessage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (!(jSONObject == null || jSONObject.optJSONObject("data") == null)) {
            jSONObject = jSONObject.optJSONObject("data");
        }
        this.mWebViewDelegate.getDmPage().getDMMina().getMessageTransfer().sendMessageToWebView(this.mWebViewDelegate, "bindWebviewPostMessage", new MessageWrapperBuilder().data(jSONObject).webViewId(this.mWebViewDelegate.getDmPage().getWebViewId()).build());
    }

    @JsInterface({"getLocalFilePath"})
    public void getLocalFilePath(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getLocalFilePathSubJSBridge().getFilePath(jSONObject, callbackFunction);
    }

    @JsInterface({"showPickerView"})
    public void showPickerView(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getPickViewSubJSBridge().showPickerView(jSONObject, callbackFunction);
    }

    @JsInterface({"checkBridgeExist"})
    public void canIUse(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("moduleName");
        if (TextUtils.isEmpty(optString)) {
            optString = "DMWebViewBridgeModule";
        }
        this.mParameter.getBridgeCheckBridge().checkBridgeExist(jSONObject, optString, callbackFunction);
    }

    public /* synthetic */ void lambda$reportMiniProgram$5$DMWebViewJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mParameter.getReportMiniProgramSubJSBridge().report(jSONObject, callbackFunction);
    }

    @JsInterface({"reportMiniProgram"})
    public void reportMiniProgram(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMWebViewJSModule.this.lambda$reportMiniProgram$5$DMWebViewJSModule(this.f$1, this.f$2);
            }
        });
    }

    @JsInterface({"renderSuccess"})
    public void renderSuccess(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("renderSuccess dimina默认不应该实现，添加是为了避免log报错");
    }

    @JsInterface({"initReady"})
    public void initReady(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("initReady dimina默认不应该实现，添加是为了避免log报错");
    }

    public void onDestroy() {
        ComponentManager.destroyComponents(this.mWebViewDelegate);
        super.onDestroy();
        ComponentSubJSBridge component = this.mParameter.getComponent(false);
        if (component != null) {
            component.comOtherDestroy();
        }
    }
}
