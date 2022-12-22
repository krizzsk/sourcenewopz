package com.didi.dimina.starbox.util;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.util.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/dimina/starbox/util/PermissionUtil;", "", "()V", "OP_SYSTEM_ALERT_WINDOW", "", "canDrawOverlays", "", "context", "Landroid/content/Context;", "requestDrawOverlays", "", "starbox_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PermissionUtil.kt */
public final class PermissionUtil {
    public static final PermissionUtil INSTANCE = new PermissionUtil();

    /* renamed from: a */
    private static final int f18172a = 24;

    private PermissionUtil() {
    }

    public final boolean canDrawOverlays(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Object systemService = context.getSystemService("appops");
            if (systemService != null) {
                AppOpsManager appOpsManager = (AppOpsManager) systemService;
                Class<AppOpsManager> cls = AppOpsManager.class;
                try {
                    Method declaredMethod = cls.getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
                    Dimina.Config config = Dimina.getConfig();
                    Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
                    Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
                    Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
                    Object invoke = declaredMethod.invoke(appOpsManager, new Object[]{24, Integer.valueOf(Process.myUid()), adapterConfig.getWsgService().getPackageName(context)});
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                    } else if (((Integer) invoke).intValue() == 0) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.app.AppOpsManager");
            }
        }
        return true;
    }

    public final void requestDrawOverlays(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        sb.append(adapterConfig.getWsgService().getPackageName(context));
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(sb.toString()));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (context.getPackageManager().resolveActivity(intent, 0) != null) {
            context.startActivity(intent);
        } else {
            LogUtil.iRelease("PermissionUtil", "starbox 没有解析OVERLAY_PERMISSIONd的页面");
        }
    }
}
