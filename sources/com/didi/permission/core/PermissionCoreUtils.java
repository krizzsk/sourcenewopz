package com.didi.permission.core;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/permission/core/PermissionCoreUtils;", "", "()V", "Companion", "PermRes", "DiPermissionCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PermissionCoreUtils.kt */
public final class PermissionCoreUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f33036a = f33036a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int f33037b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final int f33038c = 1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final int f33039d = 2;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/permission/core/PermissionCoreUtils$PermRes;", "", "(Ljava/lang/String;I)V", "GRANTED", "ALLOW_REQUEST", "REJECT_REQUEST", "DiPermissionCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: PermissionCoreUtils.kt */
    public enum PermRes {
        GRANTED,
        ALLOW_REQUEST,
        REJECT_REQUEST
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u0004J\"\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/permission/core/PermissionCoreUtils$Companion;", "", "()V", "SP_NAME", "", "STATE_ALLOW", "", "STATE_DEFAULT", "STATE_REJECT", "checkPermission", "Lcom/didi/permission/core/PermissionCoreUtils$PermRes;", "context", "Landroid/content/Context;", "permName", "savePermission", "", "permissionResult", "DiPermissionCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: PermissionCoreUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PermRes checkPermission(Context context, String str) {
            int i;
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "permName");
            int checkSelfPermission = ContextCompat.checkSelfPermission(context, str);
            LogUtil.m23225fi("PermissionCoreUtils-->checkPermission(): permName:" + str + ",res:" + checkSelfPermission);
            if (checkSelfPermission == 0) {
                return PermRes.GRANTED;
            }
            try {
                i = SystemUtils.getSharedPreferences(context, PermissionCoreUtils.f33036a, 0).getInt(str, PermissionCoreUtils.f33037b);
            } catch (Exception e) {
                LogUtil.m23225fi("PermissionCoreUtils-->checkPermission(): exception:" + e.getMessage());
                i = PermissionCoreUtils.f33037b;
            }
            LogUtil.m23225fi("PermissionCoreUtils-->checkPermission(): permName:" + str + ",permState:" + i);
            if (i == PermissionCoreUtils.f33037b || i == PermissionCoreUtils.f33038c) {
                return PermRes.ALLOW_REQUEST;
            }
            return PermRes.REJECT_REQUEST;
        }

        public final void savePermission(Context context, String str, int i) {
            int i2;
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "permName");
            if (i != 0) {
                i2 = PermissionCoreUtils.f33039d;
            } else {
                i2 = PermissionCoreUtils.f33038c;
            }
            SystemUtils.getSharedPreferences(context, PermissionCoreUtils.f33036a, 0).edit().putInt(str, i2).apply();
            LogUtil.m23225fi("PermissionCoreUtils-->savePermission(): permName:" + str + ",permissionResult:" + i + ",res:" + i2);
        }
    }
}
