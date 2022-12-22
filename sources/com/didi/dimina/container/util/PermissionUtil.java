package com.didi.dimina.container.util;

import android.content.Context;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.service.PermissionService;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J0\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015J&\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/dimina/container/util/PermissionUtil;", "", "()V", "cameraPermission", "", "", "getCameraPermission", "()[Ljava/lang/String;", "[Ljava/lang/String;", "permissionCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "checkAndRequestBridgePermission", "", "context", "Landroid/content/Context;", "permission", "permissionDescInfo", "Lcom/didi/dimina/container/bridge/permission/PermissionDescInfo;", "callback", "Lcom/didi/dimina/container/bridge/permission/SinglePermissionCallBack;", "checkAndRequestPermissionsPersonalized", "privacy", "", "checkAndRequestPermissionsWithDescDialog", "doSinglePermissionCallBack", "result", "hasPermissionOperated", "requestAudioPermission", "requestCameraPermission", "requestContactPermission", "requestLocationPermission", "requestStoragePermission", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PermissionUtil.kt */
public final class PermissionUtil {
    public static final PermissionUtil INSTANCE = new PermissionUtil();

    /* renamed from: a */
    private static final HashMap<String, Integer> f17960a = new HashMap<>();

    /* renamed from: b */
    private static final String[] f17961b = {Permission.CAMERA};

    @JvmStatic
    public static final boolean requestStoragePermission(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return false;
    }

    private PermissionUtil() {
    }

    public final String[] getCameraPermission() {
        return f17961b;
    }

    public final void checkAndRequestPermissionsWithDescDialog(Context context, String str, PermissionDescInfo permissionDescInfo, SinglePermissionCallBack singlePermissionCallBack) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "permission");
        Intrinsics.checkParameterIsNotNull(permissionDescInfo, "permissionDescInfo");
        Intrinsics.checkParameterIsNotNull(singlePermissionCallBack, "callback");
        checkAndRequestPermissionsPersonalized(context, str, permissionDescInfo, true, singlePermissionCallBack);
    }

    public static /* synthetic */ void checkAndRequestPermissionsPersonalized$default(PermissionUtil permissionUtil, Context context, String str, PermissionDescInfo permissionDescInfo, boolean z, SinglePermissionCallBack singlePermissionCallBack, int i, Object obj) {
        permissionUtil.checkAndRequestPermissionsPersonalized(context, str, permissionDescInfo, (i & 8) != 0 ? true : z, singlePermissionCallBack);
    }

    public final void checkAndRequestPermissionsPersonalized(Context context, String str, PermissionDescInfo permissionDescInfo, boolean z, SinglePermissionCallBack singlePermissionCallBack) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "permission");
        Intrinsics.checkParameterIsNotNull(permissionDescInfo, "permissionDescInfo");
        Intrinsics.checkParameterIsNotNull(singlePermissionCallBack, "callback");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        adapterConfig.getPermissionService().requestPermission(context, str, permissionDescInfo, z, singlePermissionCallBack);
    }

    @JvmStatic
    public static final boolean requestLocationPermission(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        return adapterConfig.getPermissionService().hasPermissions(context, Permission.ACCESS_COARSE_LOCATION);
    }

    @JvmStatic
    public static final boolean requestContactPermission(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        return adapterConfig.getPermissionService().hasPermissions(context, Permission.READ_CONTACTS);
    }

    @JvmStatic
    public static final boolean requestAudioPermission(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        return adapterConfig.getPermissionService().hasPermissions(context, Permission.RECORD_AUDIO);
    }

    @JvmStatic
    public static final boolean requestCameraPermission(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        PermissionService permissionService = adapterConfig.getPermissionService();
        String[] strArr = f17961b;
        return permissionService.hasPermissions(context, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @JvmStatic
    public static final boolean hasPermissionOperated(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "permission");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        return adapterConfig.getPermissionService().hasPermissionOperated(context, str);
    }

    public final void checkAndRequestBridgePermission(Context context, String str, PermissionDescInfo permissionDescInfo, SinglePermissionCallBack singlePermissionCallBack) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "permission");
        Intrinsics.checkParameterIsNotNull(permissionDescInfo, "permissionDescInfo");
        Intrinsics.checkParameterIsNotNull(singlePermissionCallBack, "callback");
        UIHandlerUtil.runOnUiThread(new PermissionUtil$checkAndRequestBridgePermission$1(str, singlePermissionCallBack, context, permissionDescInfo));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m13425a(SinglePermissionCallBack singlePermissionCallBack, String str, int i) {
        if (i == -1) {
            singlePermissionCallBack.onDenied(str);
            return;
        }
        f17960a.put(str, Integer.valueOf(i));
        singlePermissionCallBack.onGranted(str);
    }
}
