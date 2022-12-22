package com.didichuxing.mlcp.drtc.p192a;

import android.content.Context;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15899h;
import com.didichuxing.mlcp.drtc.models.C15901a;
import org.json.JSONObject;
import org.webrtc.EglBase;

/* renamed from: com.didichuxing.mlcp.drtc.a.h */
/* compiled from: PluginHandleWebRTCCallbacks */
public class C15886h implements C15899h {

    /* renamed from: a */
    private final C15901a f48323a;

    /* renamed from: b */
    private final JSONObject f48324b;

    /* renamed from: c */
    private final boolean f48325c;

    public C15886h(C15901a aVar, JSONObject jSONObject, boolean z) {
        this.f48323a = aVar;
        this.f48324b = jSONObject;
        this.f48325c = z;
    }

    /* renamed from: a */
    public void mo118908a(JSONObject jSONObject) {
    }

    /* renamed from: b */
    public Context mo118909b() {
        return null;
    }

    /* renamed from: c */
    public void mo118890c(String str) {
    }

    /* renamed from: j */
    public JSONObject mo118910j() {
        return this.f48324b;
    }

    /* renamed from: m */
    public EglBase.Context mo118911m() {
        return null;
    }

    /* renamed from: r */
    public C15901a mo118912r() {
        return this.f48323a;
    }

    /* renamed from: s */
    public Boolean mo118913s() {
        return Boolean.valueOf(this.f48325c);
    }
}
