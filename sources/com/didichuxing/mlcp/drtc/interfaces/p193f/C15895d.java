package com.didichuxing.mlcp.drtc.interfaces.p193f;

import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.enums.DrtcPluginRoleType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle;
import org.json.JSONObject;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;

/* renamed from: com.didichuxing.mlcp.drtc.interfaces.f.d */
/* compiled from: IDrtcPluginCallbacks */
public interface C15895d extends C15893b {
    /* renamed from: a */
    void mo118947a(int i);

    /* renamed from: a */
    void mo118948a(DrtcCameraType drtcCameraType);

    /* renamed from: a */
    void mo118949a(DrtcPluginHandle drtcPluginHandle);

    /* renamed from: a */
    void mo118950a(String str);

    /* renamed from: a */
    void mo118951a(JSONObject jSONObject, JSONObject jSONObject2, DrtcPluginHandle drtcPluginHandle);

    /* renamed from: a */
    void mo118952a(MediaStream mediaStream);

    /* renamed from: a */
    void mo118953a(PeerConnection.IceConnectionState iceConnectionState);

    /* renamed from: a */
    boolean mo118954a();

    /* renamed from: c */
    DrtcPluginRoleType mo118955c();

    /* renamed from: d */
    void mo118956d();

    /* renamed from: d */
    void mo118957d(String str);

    /* renamed from: g */
    DrtcSupportedPlugins mo118958g();

    /* renamed from: o */
    void mo118959o();

    /* renamed from: p */
    String mo118960p();
}
