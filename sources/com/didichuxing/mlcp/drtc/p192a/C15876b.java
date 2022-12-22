package com.didichuxing.mlcp.drtc.p192a;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15896e;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15900i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.a.b */
/* compiled from: DrtcCreateSessionTransaction */
class C15876b implements C15900i {

    /* renamed from: a */
    private final C15896e f48297a;

    public C15876b(C15896e eVar) {
        this.f48297a = eVar;
    }

    /* renamed from: a */
    public void mo118877a(JSONObject jSONObject) {
        try {
            if (DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f48336c)) != DrtcMessageType.success) {
                this.f48297a.mo118891c(jSONObject.getJSONObject("error"));
            } else {
                this.f48297a.mo118888b(jSONObject);
            }
        } catch (JSONException e) {
            this.f48297a.mo118890c(e.getMessage());
        }
    }
}
