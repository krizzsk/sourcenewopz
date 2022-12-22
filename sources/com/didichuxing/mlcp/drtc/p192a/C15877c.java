package com.didichuxing.mlcp.drtc.p192a;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15894c;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15895d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15900i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.a.c */
/* compiled from: DrtcDetachPluginTransaction */
class C15877c implements C15900i {

    /* renamed from: a */
    private final C15894c f48298a;

    /* renamed from: b */
    private final DrtcSupportedPlugins f48299b;

    /* renamed from: c */
    private final C15895d f48300c;

    public C15877c(C15894c cVar, DrtcSupportedPlugins drtcSupportedPlugins, C15895d dVar) {
        this.f48298a = cVar;
        this.f48299b = drtcSupportedPlugins;
        this.f48300c = dVar;
    }

    /* renamed from: a */
    public void mo118877a(JSONObject jSONObject) {
        try {
            if (DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f48336c)) != DrtcMessageType.success) {
                this.f48298a.mo118889b(jSONObject, this.f48299b, this.f48300c);
            } else {
                this.f48298a.mo118884a(jSONObject, this.f48299b, this.f48300c);
            }
        } catch (JSONException e) {
            this.f48298a.mo118890c(e.getMessage());
        }
    }
}
