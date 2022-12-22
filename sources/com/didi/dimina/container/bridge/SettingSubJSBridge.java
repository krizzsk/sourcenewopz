package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SettingSubJSBridge {

    /* renamed from: c */
    private static final String f16656c = "scope.userLocation";

    /* renamed from: d */
    private static final String f16657d = "scope.writePhotosAlbum";

    /* renamed from: e */
    private static final String f16658e = "scope.camera";

    /* renamed from: f */
    private static final String f16659f = "scope.record";

    /* renamed from: g */
    private static final String f16660g = "scope.contact";

    /* renamed from: h */
    private static final String f16661h = "authorize:fail 系统错误，错误码：-12001，invalid scope";

    /* renamed from: i */
    private static final String f16662i = "scope";

    /* renamed from: j */
    private static final Map<String, String> f16663j;

    /* renamed from: a */
    private final DMMina f16664a;

    /* renamed from: b */
    private final Activity f16665b;

    static {
        HashMap hashMap = new HashMap();
        f16663j = hashMap;
        hashMap.put(f16656c, Permission.ACCESS_FINE_LOCATION);
        f16663j.put(f16658e, Permission.CAMERA);
        f16663j.put(f16659f, Permission.RECORD_AUDIO);
    }

    public SettingSubJSBridge(DMMina dMMina, Activity activity) {
        this.f16664a = dMMina;
        this.f16665b = activity;
        LogUtil.m13411i("SettingSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54538a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Dimina.getConfig().getAdapterConfig().getPermissionService().openSetting(this.f16665b, 1);
        CallBackUtil.onSuccess(callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54539b(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("scope");
        String str = f16663j.get(optString);
        if (!TextUtils.isEmpty(str) || (str = JSBridgePluginLoader.getPermission(optString)) != null || callbackFunction == null) {
            PermissionUtil.INSTANCE.checkAndRequestPermissionsWithDescDialog(this.f16665b, str, m12284b(optString), new SinglePermissionCallBack() {
                public void onDenied(String str) {
                    CallbackFunction callbackFunction = callbackFunction;
                    if (callbackFunction != null) {
                        CallBackUtil.onFail("", callbackFunction);
                    }
                }

                public void onGranted(String str) {
                    CallbackFunction callbackFunction = callbackFunction;
                    if (callbackFunction != null) {
                        CallBackUtil.onSuccess(callbackFunction);
                    }
                }
            });
        } else {
            CallBackUtil.onFail(f16661h, callbackFunction);
        }
    }

    /* renamed from: a */
    private String m12283a(String str) {
        if (f16657d.equals(str)) {
            return DiminaPermissionDescDialog.PERMISSION_STORAGE_REJECTED_HINT;
        }
        if (f16656c.equals(str)) {
            return DiminaPermissionDescDialog.PERMISSION_LOCATION_REJECTED_HINT;
        }
        if (f16658e.equals(str)) {
            return DiminaPermissionDescDialog.PERMISSION_CAMERA_REJECTED_HINT;
        }
        if (f16659f.equals(str)) {
            return DiminaPermissionDescDialog.PERMISSION_RECORD_REJECTED_HINT;
        }
        return f16660g.equals(str) ? DiminaPermissionDescDialog.PERMISSION_CONTACT_REJECTED_HINT : "";
    }

    /* renamed from: b */
    private PermissionDescInfo m12284b(String str) {
        if (f16656c.equals(str)) {
            return DiminaPermissionDescDialog.createLocationDescInfo(this.f16664a);
        }
        if (f16658e.equals(str)) {
            return DiminaPermissionDescDialog.createCameraDescInfo(this.f16664a);
        }
        if (f16657d.equals(str)) {
            return DiminaPermissionDescDialog.createStorageDescInfo(this.f16664a);
        }
        if (f16659f.equals(str)) {
            return DiminaPermissionDescDialog.createRecordDescInfo(this.f16664a);
        }
        return new PermissionDescInfo("权限申请说明", "");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54540c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject2 = new JSONObject();
        if (PermissionUtil.hasPermissionOperated(this.f16665b, Permission.ACCESS_COARSE_LOCATION)) {
            JSONUtil.put(jSONObject2, f16656c, PermissionUtil.requestLocationPermission(this.f16665b));
        }
        if (PermissionUtil.hasPermissionOperated(this.f16665b, Permission.READ_CONTACTS)) {
            JSONUtil.put(jSONObject2, "scope.address", PermissionUtil.requestContactPermission(this.f16665b));
        }
        if (PermissionUtil.hasPermissionOperated(this.f16665b, Permission.RECORD_AUDIO)) {
            JSONUtil.put(jSONObject2, f16659f, PermissionUtil.requestAudioPermission(this.f16665b));
        }
        if (PermissionUtil.hasPermissionOperated(this.f16665b, Permission.CAMERA)) {
            JSONUtil.put(jSONObject2, f16658e, PermissionUtil.requestCameraPermission(this.f16665b));
        }
        hashMap.put("authSetting", jSONObject2);
        if (callbackFunction != null) {
            CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
        }
    }
}
