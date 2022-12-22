package com.didi.dimina.container.secondparty.permission;

import android.content.Context;
import com.didi.dimina.container.bridge.permission.DMPermissionDescConfig;
import com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.secondparty.permission.checker.PermissionChecker;
import com.didi.dimina.container.secondparty.permission.checker.StandardChecker;
import com.didi.dimina.container.service.PermissionService;
import com.didi.dimina.container.util.PermissionUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.permission.core.PermissionCoreUtils;
import com.didi.sdk.apm.SystemUtils;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\bH\u0002J\"\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J)\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u001d\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\bH\u0016J0\u0010!\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/permission/DidiPermissionManager;", "Lcom/didi/dimina/container/service/PermissionService;", "()V", "STANDARD_CHECKER", "Lcom/didi/dimina/container/secondparty/permission/checker/PermissionChecker;", "permissionCache", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "dismissDescDialog", "", "diminaPermissionDescDialog", "Lcom/didi/dimina/container/bridge/permission/DiminaPermissionDescDialog;", "doSinglePermissionCallBack", "callback", "Lcom/didi/dimina/container/bridge/permission/SinglePermissionCallBack;", "permission", "result", "getDescDialog", "activity", "Landroid/content/Context;", "permissionDescInfo", "Lcom/didi/dimina/container/bridge/permission/PermissionDescInfo;", "hasPermissionOperated", "", "context", "hasPermissions", "permissions", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "openSetting", "requestCode", "requestPermission", "privacy", "showDescDialog", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DidiPermissionManager.kt */
public final class DidiPermissionManager implements PermissionService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashMap<String, Integer> f17312a = new HashMap<>();

    /* renamed from: b */
    private final PermissionChecker f17313b = new StandardChecker();

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PermissionCoreUtils.PermRes.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PermissionCoreUtils.PermRes.GRANTED.ordinal()] = 1;
            $EnumSwitchMapping$0[PermissionCoreUtils.PermRes.ALLOW_REQUEST.ordinal()] = 2;
            $EnumSwitchMapping$0[PermissionCoreUtils.PermRes.REJECT_REQUEST.ordinal()] = 3;
        }
    }

    public boolean hasPermissions(Context context, String... strArr) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        if (Arrays.equals(strArr, PermissionUtil.INSTANCE.getCameraPermission())) {
            PermissionChecker permissionChecker = this.f17313b;
            String[] cameraPermission = PermissionUtil.INSTANCE.getCameraPermission();
            return permissionChecker.hasPermission(context, (String[]) Arrays.copyOf(cameraPermission, cameraPermission.length));
        }
        return AndPermission.hasPermissions(context, strArr);
    }

    public boolean hasPermissionOperated(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "permission");
        return PermissionCoreUtils.Companion.checkPermission(context, str) != PermissionCoreUtils.PermRes.ALLOW_REQUEST;
    }

    public void requestPermission(Context context, String str, PermissionDescInfo permissionDescInfo, boolean z, SinglePermissionCallBack singlePermissionCallBack) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "permission");
        Intrinsics.checkParameterIsNotNull(permissionDescInfo, "permissionDescInfo");
        Intrinsics.checkParameterIsNotNull(singlePermissionCallBack, "callback");
        UIHandlerUtil.runOnUiThread(new DidiPermissionManager$requestPermission$1(this, context, str, singlePermissionCallBack, permissionDescInfo, z));
    }

    public void openSetting(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndPermission.with(context).runtime().setting().start(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12862a(SinglePermissionCallBack singlePermissionCallBack, String str, int i) {
        if (i == -1) {
            singlePermissionCallBack.onDenied(str);
            return;
        }
        this.f17312a.put(str, Integer.valueOf(i));
        singlePermissionCallBack.onGranted(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final DiminaPermissionDescDialog m12860a(Context context, PermissionDescInfo permissionDescInfo, String str) {
        if ((str.equals(Permission.CAMERA) || str.equals(Permission.ACCESS_FINE_LOCATION) || str.equals(Permission.ACCESS_COARSE_LOCATION)) && (!Intrinsics.areEqual((Object) DMPermissionDescConfig.NONE_PERMISSION_DESC_CONTENT_MARK, (Object) permissionDescInfo.getContent()))) {
            return new DiminaPermissionDescDialog(context, permissionDescInfo);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12861a(DiminaPermissionDescDialog diminaPermissionDescDialog) {
        if (diminaPermissionDescDialog != null && !diminaPermissionDescDialog.isShowing()) {
            SystemUtils.showDialog(diminaPermissionDescDialog);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m12863b(DiminaPermissionDescDialog diminaPermissionDescDialog) {
        if (diminaPermissionDescDialog != null && diminaPermissionDescDialog.isShowing()) {
            diminaPermissionDescDialog.dismiss();
        }
    }
}
