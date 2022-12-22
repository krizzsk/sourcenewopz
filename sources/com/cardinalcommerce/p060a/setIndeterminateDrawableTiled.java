package com.cardinalcommerce.p060a;

import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setIndeterminateDrawableTiled */
public final class setIndeterminateDrawableTiled {
    public String cca_continue;
    public String init;

    public setIndeterminateDrawableTiled() {
    }

    public setIndeterminateDrawableTiled(JSONObject jSONObject) {
        jSONObject.optString("crv", "");
        jSONObject.optString("kty", "");
        this.cca_continue = jSONObject.optString("x", "");
        this.init = jSONObject.optString(SameLayerRenderingUtil.KEY_COMP_Y, "");
    }
}
