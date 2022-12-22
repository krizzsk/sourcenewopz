package com.didichuxing.xpanel.models;

import android.content.Context;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.models.AbsXPanelAgentModelView;
import org.json.JSONObject;

public abstract class AbsXPanelModelAssemble<X, T extends AbsXPanelAgentModelView<X>> implements IXPanelAgentModelRecycle<T> {
    /* access modifiers changed from: protected */
    public abstract T createView(Context context);

    public abstract X parseDataAndExtension(JSONObject jSONObject, JSONObject jSONObject2);

    public final XPanelCardData<X> initByData(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, IXPanelAgentClickListener iXPanelAgentClickListener) {
        Object parseDataAndExtension = parseDataAndExtension(jSONObject, jSONObject2);
        if (parseDataAndExtension == null) {
            return null;
        }
        XPanelCardData<X> build = new XPanelCardData.Builder().mo121493id(str).object(parseDataAndExtension).template(str2).build();
        build.isMain = false;
        return build;
    }
}
