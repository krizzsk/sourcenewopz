package com.didichuxing.mlcp.drtc.p192a;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15892a;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15895d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15900i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.a.a */
/* compiled from: DrtcAttachPluginTransaction */
class C15875a implements C15900i {

    /* renamed from: a */
    private final C15892a f48294a;

    /* renamed from: b */
    private final DrtcSupportedPlugins f48295b;

    /* renamed from: c */
    private final C15895d f48296c;

    public C15875a(C15892a aVar, DrtcSupportedPlugins drtcSupportedPlugins, C15895d dVar) {
        this.f48294a = aVar;
        this.f48295b = drtcSupportedPlugins;
        this.f48296c = dVar;
    }

    /* renamed from: a */
    public void mo118877a(JSONObject jSONObject) {
        try {
            if (DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f48336c)) != DrtcMessageType.success) {
                this.f48294a.mo118892c(jSONObject, this.f48295b, this.f48296c);
            } else {
                this.f48294a.mo118893d(jSONObject, this.f48295b, this.f48296c);
            }
        } catch (JSONException e) {
            this.f48294a.mo118890c(e.getMessage());
        }
    }
}
