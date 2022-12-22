package com.didi.dimina.container.p106ui.custom;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.custom.CustomComponent */
public abstract class CustomComponent {
    protected DMPage mDMPage;
    protected String mId;
    protected View mView;
    protected WebViewEngine mWebView;

    /* access modifiers changed from: protected */
    public Point getComponentViewExtraMargin() {
        return null;
    }

    public abstract void onDestroyed();

    public abstract View onMounted(Context context, JSONObject jSONObject);

    public void onPropertiesUpdate(JSONObject jSONObject) {
    }

    public View innerMounted(String str, DMPage dMPage, JSONObject jSONObject) {
        this.mId = str;
        this.mDMPage = dMPage;
        this.mWebView = dMPage.getWebViewContainer().getWebView();
        View onMounted = onMounted(this.mDMPage.getContext(), jSONObject);
        this.mView = onMounted;
        return onMounted;
    }

    public View getView() {
        return this.mView;
    }

    public void emitEvent2WebView(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "id", (Object) this.mId);
        for (Map.Entry next : map.entrySet()) {
            JSONUtil.put(jSONObject, (String) next.getKey(), next.getValue());
        }
        this.mWebView.getDmMina().getMessageTransfer().sendMessageToWebView(this.mWebView, str, new MessageWrapperBuilder().data(jSONObject.toString()).webViewId(this.mDMPage.getWebViewId()).stackId(this.mDMPage.getNavigator().getIndex()).build());
    }
}
