package com.didi.dimina.container.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/WifiSubJSBridge;", "", "mDmMina", "Lcom/didi/dimina/container/DMMina;", "(Lcom/didi/dimina/container/DMMina;)V", "isWifiStart", "", "()Z", "setWifiStart", "(Z)V", "mWifiManager", "Landroid/net/wifi/WifiManager;", "mWifiReceiver", "Lcom/didi/dimina/container/bridge/WifiSubJSBridge$WifiReceiver;", "getConnectedWifi", "", "paras", "Lorg/json/JSONObject;", "callback", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "onDestroy", "parseWifi", "info", "Landroid/net/wifi/WifiInfo;", "starWifi", "stopWifi", "Companion", "WifiReceiver", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: WifiSubJSBridge.kt */
public final class WifiSubJSBridge {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String WIFI_AUTH_OPEN = "";
    public static final String WIFI_AUTH_ROAM = "[ESS]";

    /* renamed from: e */
    private static final String f16674e = "NetworkSubJSBridge";

    /* renamed from: f */
    private static final String f16675f = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: a */
    private final WifiManager f16676a;

    /* renamed from: b */
    private final WifiReceiver f16677b;

    /* renamed from: c */
    private boolean f16678c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final DMMina f16679d;

    public WifiSubJSBridge(DMMina dMMina) {
        this.f16679d = dMMina;
        if (dMMina == null) {
            Intrinsics.throwNpe();
        }
        FragmentActivity activity = dMMina.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "mDmMina!!.activity");
        Object systemService = activity.getApplicationContext().getSystemService("wifi");
        if (systemService != null) {
            this.f16676a = (WifiManager) systemService;
            this.f16677b = new WifiReceiver();
            LogUtil.m13411i("WifiSubJSBridge init");
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.WifiManager");
    }

    public final boolean isWifiStart() {
        return this.f16678c;
    }

    public final void setWifiStart(boolean z) {
        this.f16678c = z;
    }

    public final void starWifi(JSONObject jSONObject, CallbackFunction callbackFunction) {
        FragmentActivity activity;
        this.f16678c = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        DMMina dMMina = this.f16679d;
        if (!(dMMina == null || (activity = dMMina.getActivity()) == null)) {
            try {
                activity.registerReceiver(this.f16677b, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
        CallBackUtil.onSuccess$default((JSONObject) null, callbackFunction, 1, (Object) null);
    }

    public final void stopWifi(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (!this.f16678c) {
            CallBackUtil.onFail$default((JSONObject) null, "startWifi is not invoke", callbackFunction, 1, (Object) null);
            return;
        }
        DMMina dMMina = this.f16679d;
        if (dMMina == null) {
            Intrinsics.throwNpe();
        }
        try {
            dMMina.getActivity().unregisterReceiver(this.f16677b);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        this.f16678c = false;
        CallBackUtil.onSuccess$default((JSONObject) null, callbackFunction, 1, (Object) null);
    }

    public final void getConnectedWifi(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (!this.f16678c) {
            CallBackUtil.onFail$default((JSONObject) null, "startWifi is not invoke", callbackFunction, 1, (Object) null);
        } else if (this.f16676a.getWifiState() == 3) {
            WifiInfo connectionInfo = this.f16676a.getConnectionInfo();
            JSONObject jSONObject2 = new JSONObject();
            JSONUtil.put(jSONObject2, "wifi", (Object) m12296a(connectionInfo));
            CallBackUtil.onSuccess(jSONObject2, callbackFunction);
        } else {
            CallBackUtil.onFail$default((JSONObject) null, "wifi is disable", callbackFunction, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final JSONObject m12296a(WifiInfo wifiInfo) {
        return new JSONObject();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/WifiSubJSBridge$WifiReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/didi/dimina/container/bridge/WifiSubJSBridge;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: WifiSubJSBridge.kt */
    private final class WifiReceiver extends BroadcastReceiver {
        public WifiReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.net.wifi.RSSI_CHANGED")) {
                LogUtil.m13407d("wifi信号强度变化");
            }
            if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.net.wifi.STATE_CHANGE")) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo == null) {
                    Intrinsics.throwNpe();
                }
                if (networkInfo.getState() == NetworkInfo.State.DISCONNECTED) {
                    LogUtil.m13407d("wifi断开");
                } else if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    Object systemService = context.getSystemService("wifi");
                    if (systemService != null) {
                        WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
                        LogUtil.m13407d("连接到网络");
                        JSONObject jSONObject = new JSONObject();
                        JSONUtil.put(jSONObject, "wifi", (Object) WifiSubJSBridge.this.m12296a(connectionInfo));
                        DMMina access$getMDmMina$p = WifiSubJSBridge.this.f16679d;
                        if (access$getMDmMina$p == null) {
                            Intrinsics.throwNpe();
                        }
                        access$getMDmMina$p.getMessageTransfer().sendMessageToServiceFromNative("onWifiConnected", new MessageWrapperBuilder().data(jSONObject).build());
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.WifiManager");
                    }
                }
            }
            if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.net.wifi.WIFI_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("wifi_state", 1);
                if (intExtra == 1) {
                    LogUtil.m13407d("系统关闭wifi");
                } else if (intExtra == 3) {
                    LogUtil.m13407d("系统开启wifi");
                }
            }
        }
    }

    public final void onDestroy() {
        DMMina dMMina = this.f16679d;
        if (dMMina != null && dMMina.getActivity() != null && this.f16677b != null) {
            try {
                this.f16679d.getActivity().unregisterReceiver(this.f16677b);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/WifiSubJSBridge$Companion;", "", "()V", "ANDROID_NET_CHANGE_ACTION", "", "TAG", "WIFI_AUTH_OPEN", "WIFI_AUTH_ROAM", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: WifiSubJSBridge.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
