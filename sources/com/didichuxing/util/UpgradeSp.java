package com.didichuxing.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\u0012J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u000b\u001a\u00020\rJ\u0010\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u000b\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u000b\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\rJ\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010#\u001a\u00020\rH\u0002J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0012J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0012J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, mo175978d2 = {"Lcom/didichuxing/util/UpgradeSp;", "", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "applyToEditor", "", "editor", "Landroid/content/SharedPreferences$Editor;", "getGoogleAccount", "", "defValue", "getHasJoinedPlan", "", "getIauDialogCount", "getInt", "key", "getLastIauRequestTime", "", "getLastUpgradeDialogTime", "getLong", "getString", "getTaskId", "getUpdateType", "getVersionId", "init", "context", "Landroid/content/Context;", "setGoogleAccount", "account", "setHasJoinedPlan", "join", "setIauDialogCount", "count", "setInt", "value", "setLastIauRequestTime", "timestamp", "setLastUpgradeDialogTime", "time", "setLong", "setString", "setTaskId", "taskId", "setUpdateType", "updateType", "setVersionID", "versionId", "Companion", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: UpgradeSp.kt */
public final class UpgradeSp {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static UpgradeSp f49253b;

    /* renamed from: a */
    private SharedPreferences f49254a;

    public final void init(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f49254a = SystemUtils.getSharedPreferences(context.getApplicationContext(), context.getPackageName() + "_preferences", 0);
    }

    public final void setLastUpgradeDialogTime(long j) {
        m35529b("key_update_interval", j);
    }

    public static /* synthetic */ long getLastUpgradeDialogTime$default(UpgradeSp upgradeSp, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return upgradeSp.getLastUpgradeDialogTime(j);
    }

    public final long getLastUpgradeDialogTime(long j) {
        return m35525a("key_update_interval", j);
    }

    public final void setVersionID(int i) {
        m35528b("key_version_id", i);
    }

    public static /* synthetic */ int getVersionId$default(UpgradeSp upgradeSp, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return upgradeSp.getVersionId(i);
    }

    public final int getVersionId(int i) {
        return m35524a("key_version_id", i);
    }

    public final void setTaskId(int i) {
        m35528b("key_task_id", i);
    }

    public static /* synthetic */ int getTaskId$default(UpgradeSp upgradeSp, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return upgradeSp.getTaskId(i);
    }

    public final int getTaskId(int i) {
        return m35524a("key_task_id", i);
    }

    public final void setUpdateType(int i) {
        m35528b("key_update_type", i);
    }

    public static /* synthetic */ int getUpdateType$default(UpgradeSp upgradeSp, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return upgradeSp.getUpdateType(i);
    }

    public final int getUpdateType(int i) {
        return m35524a("key_update_type", i);
    }

    public final void setGoogleAccount(String str) {
        Intrinsics.checkParameterIsNotNull(str, "account");
        m35530b("key_google_account", str);
    }

    public static /* synthetic */ String getGoogleAccount$default(UpgradeSp upgradeSp, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return upgradeSp.getGoogleAccount(str);
    }

    public final String getGoogleAccount(String str) {
        Intrinsics.checkParameterIsNotNull(str, "defValue");
        return m35526a("key_google_account", str);
    }

    public final void setHasJoinedPlan(int i) {
        m35528b("key_has_joined_plan", i);
    }

    public final int getHasJoinedPlan() {
        return m35524a("key_has_joined_plan", 0);
    }

    public final void setLastIauRequestTime(long j) {
        m35529b("key_iau_request_time", j);
    }

    public final long getLastIauRequestTime() {
        return m35525a("key_iau_request_time", 0);
    }

    public final void setIauDialogCount(int i) {
        m35528b("key_iau_dialog_count", i);
    }

    public final int getIauDialogCount() {
        return m35524a("key_iau_dialog_count", 0);
    }

    /* renamed from: a */
    private final long m35525a(String str, long j) {
        SharedPreferences sharedPreferences = this.f49254a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, j);
        }
        return -1;
    }

    /* renamed from: a */
    private final int m35524a(String str, int i) {
        SharedPreferences sharedPreferences = this.f49254a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, i);
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.getString(r2, r3);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m35526a(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            android.content.SharedPreferences r0 = r1.f49254a
            if (r0 == 0) goto L_0x000b
            java.lang.String r2 = r0.getString(r2, r3)
            if (r2 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            java.lang.String r2 = ""
        L_0x000d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.util.UpgradeSp.m35526a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    private final void m35528b(String str, int i) {
        SharedPreferences sharedPreferences = this.f49254a;
        SharedPreferences.Editor edit = sharedPreferences != null ? sharedPreferences.edit() : null;
        if (edit != null) {
            edit.putInt(str, i);
        }
        m35527a(edit);
    }

    /* renamed from: b */
    private final void m35530b(String str, String str2) {
        SharedPreferences sharedPreferences = this.f49254a;
        SharedPreferences.Editor edit = sharedPreferences != null ? sharedPreferences.edit() : null;
        if (edit != null) {
            edit.putString(str, str2);
        }
        m35527a(edit);
    }

    /* renamed from: b */
    private final void m35529b(String str, long j) {
        SharedPreferences sharedPreferences = this.f49254a;
        SharedPreferences.Editor edit = sharedPreferences != null ? sharedPreferences.edit() : null;
        if (edit != null) {
            edit.putLong(str, j);
        }
        m35527a(edit);
    }

    /* renamed from: a */
    private final void m35527a(SharedPreferences.Editor editor) {
        if (editor != null) {
            editor.apply();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didichuxing/util/UpgradeSp$Companion;", "", "()V", "instance", "Lcom/didichuxing/util/UpgradeSp;", "getInstance", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: UpgradeSp.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UpgradeSp getInstance() {
            if (UpgradeSp.f49253b == null) {
                UpgradeSp.f49253b = new UpgradeSp();
            }
            UpgradeSp access$getInstance$cp = UpgradeSp.f49253b;
            if (access$getInstance$cp == null) {
                Intrinsics.throwNpe();
            }
            return access$getInstance$cp;
        }
    }
}
