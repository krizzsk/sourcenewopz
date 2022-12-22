package com.didichuxing.mlcp.drtc.p192a;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15898g;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15900i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.a.d */
/* compiled from: DrtcSendPluginMessageTransaction */
class C15878d implements C15900i {

    /* renamed from: a */
    private final C15898g f48301a;

    /* renamed from: com.didichuxing.mlcp.drtc.a.d$a */
    /* compiled from: DrtcSendPluginMessageTransaction */
    static /* synthetic */ class C15879a {

        /* renamed from: a */
        static final /* synthetic */ int[] f48302a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType[] r0 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f48302a = r0
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.success     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f48302a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.ack     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mlcp.drtc.p192a.C15878d.C15879a.<clinit>():void");
        }
    }

    public C15878d(C15898g gVar) {
        this.f48301a = gVar;
    }

    /* renamed from: a */
    public void mo118877a(JSONObject jSONObject) {
        try {
            int i = C15879a.f48302a[DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f48336c)).ordinal()];
            if (i == 1) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(SDKConsts.MSG_TAG_PLUGIND);
                DrtcSupportedPlugins fromString = DrtcSupportedPlugins.fromString(jSONObject2.getString(SDKConsts.MSG_TAG_PLUGIN));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                if (fromString == DrtcSupportedPlugins.SATURN_NONE) {
                    C15898g gVar = this.f48301a;
                    gVar.mo118890c("unexpected message: \n\t" + jSONObject.toString());
                    return;
                }
                this.f48301a.mo118905d(jSONObject3);
            } else if (i != 2) {
                this.f48301a.mo118890c(jSONObject.getJSONObject("error").getString("reason"));
            } else {
                this.f48301a.mo118907l();
            }
        } catch (JSONException e) {
            this.f48301a.mo118890c(e.getMessage());
        }
    }
}
