package com.ddmap.sdk.degrade.gnav;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ddmap.sdk.degrade.ICrashMonitor;
import com.ddmap.sdk.degrade.TrackReporter;
import com.ddmap.sdk.degrade.gnav.restorerule.VersionRestoreRule;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.map.sdk.maprouter.MapType;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0003J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0006J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0013H\u0007J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0013H\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0006H\u0007J\b\u0010#\u001a\u00020\u0010H\u0003J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013H\u0003J\b\u0010%\u001a\u00020\u0010H\u0003J\b\u0010&\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/ddmap/sdk/degrade/gnav/GoogleNavDegrade;", "", "()V", "initMonitor", "", "mContext", "Landroid/content/Context;", "mCrashMonitor", "Lcom/ddmap/sdk/degrade/ICrashMonitor;", "getMCrashMonitor", "()Lcom/ddmap/sdk/degrade/ICrashMonitor;", "mCrashMonitor$delegate", "Lkotlin/Lazy;", "mSp", "Landroid/content/SharedPreferences;", "clearCrashInfo", "", "debug", "msg", "", "getCrashAccArray", "Lorg/json/JSONArray;", "crashKey", "getCrashContinuousCounts", "", "getCrashInfo", "Lorg/json/JSONObject;", "getSp", "init", "context", "needDegrade", "curVerName", "needRestore", "curVer", "resetContinuousCount", "resetDegradeFlag", "saveCrashInfo", "saveNeedDegradeFlag", "startCrashMonitor", "Companion", "Degrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: GoogleNavDegrade.kt */
public final class GoogleNavDegrade {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    static final /* synthetic */ KProperty[] f4285a = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(GoogleNavDegrade.class), "mCrashMonitor", "getMCrashMonitor()Lcom/ddmap/sdk/degrade/ICrashMonitor;"))};
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Lazy f4286f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GoogleNavDegrade$Companion$instance$2.INSTANCE);

    /* renamed from: g */
    private static final String f4287g = "sp_g_nav_degrade";

    /* renamed from: h */
    private static final String f4288h = "key_degrade_flag";

    /* renamed from: i */
    private static final String f4289i = "crashArray";

    /* renamed from: j */
    private static final String f4290j = "ConCounts";

    /* renamed from: b */
    private final Lazy f4291b;

    /* renamed from: c */
    private SharedPreferences f4292c;

    /* renamed from: d */
    private boolean f4293d;

    /* renamed from: e */
    private Context f4294e;

    /* renamed from: a */
    private final ICrashMonitor m2606a() {
        Lazy lazy = this.f4291b;
        KProperty kProperty = f4285a[0];
        return (ICrashMonitor) lazy.getValue();
    }

    private GoogleNavDegrade() {
        this.f4291b = LazyKt.lazy(GoogleNavDegrade$mCrashMonitor$2.INSTANCE);
    }

    public /* synthetic */ GoogleNavDegrade(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, mo175978d2 = {"Lcom/ddmap/sdk/degrade/gnav/GoogleNavDegrade$Companion;", "", "()V", "KEY_CONTINUOUS_COUNTS", "", "KEY_CRASH_ACCUMULATE_ARRAY", "KEY_DEGRADE_FLAG", "SP_MAP_DEGRADE", "instance", "Lcom/ddmap/sdk/degrade/gnav/GoogleNavDegrade;", "getInstance", "()Lcom/ddmap/sdk/degrade/gnav/GoogleNavDegrade;", "instance$delegate", "Lkotlin/Lazy;", "debug", "", "msg", "Degrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* compiled from: GoogleNavDegrade.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/ddmap/sdk/degrade/gnav/GoogleNavDegrade;"))};

        public final GoogleNavDegrade getInstance() {
            Lazy access$getInstance$cp = GoogleNavDegrade.f4286f;
            KProperty kProperty = $$delegatedProperties[0];
            return (GoogleNavDegrade) access$getInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void debug(String str) {
            Intrinsics.checkParameterIsNotNull(str, "msg");
            SystemUtils.log(3, "GoogleNavDegrade", str, (Throwable) null, "com.ddmap.sdk.degrade.gnav.GoogleNavDegrade$Companion", 55);
        }
    }

    /* renamed from: b */
    private final void m2609b() {
        if (!this.f4293d) {
            GNavApollo gNavApollo = GNavApollo.get();
            Intrinsics.checkExpressionValueIsNotNull(gNavApollo, GlobalCashierCoreModule.APOLLO);
            if (gNavApollo.isIsMonitor() && !TextUtils.isEmpty(gNavApollo.getCrashKey())) {
                m2606a().start(new GoogleNavDegrade$startCrashMonitor$1(this, gNavApollo));
            }
        }
    }

    /* renamed from: c */
    private final SharedPreferences m2611c() {
        if (this.f4292c == null) {
            Context context = this.f4294e;
            this.f4292c = context != null ? SystemUtils.getSharedPreferences(context, f4287g, 0) : null;
        }
        return this.f4292c;
    }

    public final void init(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (this.f4294e == null) {
            this.f4294e = context.getApplicationContext();
        }
    }

    /* renamed from: a */
    private final JSONObject m2607a(String str) {
        m2617f("获取Crash信息 crashKey = " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SharedPreferences c = m2611c();
            if (c == null) {
                Intrinsics.throwNpe();
            }
            String string = c.getString(str, "");
            m2617f("getCrashInfo info = " + string);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return new JSONObject(string);
        } catch (Exception e) {
            e.printStackTrace();
            m2617f("getCrashInfo exception = " + e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final JSONArray m2608b(String str) {
        JSONObject a = m2607a(str);
        if (a == null) {
            return new JSONArray();
        }
        JSONArray optJSONArray = a.optJSONArray(f4289i);
        return optJSONArray == null ? new JSONArray() : optJSONArray;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final int m2610c(String str) {
        JSONObject a = m2607a(str);
        if (a != null) {
            return a.optInt(f4290j, 0);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m2613d(String str) {
        SharedPreferences.Editor putString;
        JSONObject a = m2607a(str);
        if (a == null) {
            a = new JSONObject();
        }
        try {
            JSONArray optJSONArray = a.optJSONArray(f4289i);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            optJSONArray.put(System.currentTimeMillis());
            a.put(f4289i, optJSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            a.put(f4290j, a.optInt(f4290j, 0) + 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        SharedPreferences c = m2611c();
        Boolean bool = null;
        SharedPreferences.Editor edit = c != null ? c.edit() : null;
        if (!(edit == null || (putString = edit.putString(str, a.toString())) == null)) {
            bool = Boolean.valueOf(putString.commit());
        }
        m2617f("存储crash信息 = " + a + "  是否保存成功=" + bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m2612d() {
        SharedPreferences.Editor putBoolean;
        try {
            Companion.debug("保存降级标识 true,下次启动进行降级处理");
            SharedPreferences c = m2611c();
            SharedPreferences.Editor edit = c != null ? c.edit() : null;
            if (!(edit == null || (putBoolean = edit.putBoolean(f4288h, true)) == null)) {
                putBoolean.commit();
            }
            TrackReporter.INSTANCE.reportDegrade();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean needDegrade(Context context, String str) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "curVerName");
        PlatInfo instance = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "PlatInfo.getInstance()");
        boolean z2 = false;
        if (instance.getMapType() == MapType.didi) {
            m2617f("自建地图，不使用Google内置导航 不进行降级处理");
            return false;
        }
        if (this.f4294e == null) {
            this.f4294e = context.getApplicationContext();
        }
        try {
            SharedPreferences c = m2611c();
            if (c == null) {
                Intrinsics.throwNpe();
            }
            z = c.getBoolean(f4288h, false);
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        m2617f("进行降级判断 needDegrade = " + z);
        if (!z || !m2615e(str)) {
            z2 = z;
        } else {
            m2617f("需要恢复，不进行降级 重置降级标识 = " + false);
            m2614e();
            m2616f();
            TrackReporter.INSTANCE.reportRestore();
        }
        if (!z2) {
            m2609b();
        }
        return z2;
    }

    public final void resetContinuousCount(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        try {
            if (this.f4294e == null) {
                this.f4294e = context.getApplicationContext();
            }
            GNavApollo gNavApollo = GNavApollo.get();
            Intrinsics.checkExpressionValueIsNotNull(gNavApollo, "GNavApollo.get()");
            if (gNavApollo.isIsMonitor()) {
                m2617f("准备重置连续崩溃次数");
                GNavApollo gNavApollo2 = GNavApollo.get();
                Intrinsics.checkExpressionValueIsNotNull(gNavApollo2, "GNavApollo.get()");
                String crashKey = gNavApollo2.getCrashKey();
                Intrinsics.checkExpressionValueIsNotNull(crashKey, "crashKey");
                JSONObject a = m2607a(crashKey);
                if (a != null) {
                    m2617f("当前CrashInfo = " + a);
                    if (a.optInt(f4290j, 0) > 0) {
                        a.put(f4290j, 0);
                        SharedPreferences c = m2611c();
                        if (c == null) {
                            Intrinsics.throwNpe();
                        }
                        boolean commit = c.edit().putString(crashKey, a.toString()).commit();
                        m2617f("崩溃信息 = " + a + "  是否成功 :" + commit);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private final boolean m2615e(String str) {
        try {
            GNavApollo gNavApollo = GNavApollo.get();
            Intrinsics.checkExpressionValueIsNotNull(gNavApollo, GlobalCashierCoreModule.APOLLO);
            if (gNavApollo.isRestoreFlag()) {
                m2617f("恢复标识生效，进行恢复");
                return true;
            } else if (!new VersionRestoreRule(gNavApollo.getRestoreVersion()).needRestore(str)) {
                return false;
            } else {
                m2617f("恢复版本符合，进行恢复");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: e */
    private final void m2614e() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        try {
            m2617f("重置降级标志位");
            SharedPreferences c = m2611c();
            if (c != null && (edit = c.edit()) != null && (putBoolean = edit.putBoolean(f4288h, false)) != null) {
                putBoolean.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        r0 = (r1 = r1.edit()).putString(r0, "");
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2616f() {
        /*
            r3 = this;
            com.ddmap.sdk.degrade.gnav.GNavApollo r0 = com.ddmap.sdk.degrade.gnav.GNavApollo.get()
            java.lang.String r1 = "apollo"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r0 = r0.getCrashKey()
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0017
            return
        L_0x0017:
            java.lang.String r1 = "crashKey"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            org.json.JSONObject r1 = r3.m2607a(r0)
            if (r1 == 0) goto L_0x0059
            android.content.SharedPreferences r1 = r3.m2611c()     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x003f
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x003f
            java.lang.String r2 = ""
            android.content.SharedPreferences$Editor r0 = r1.putString(r0, r2)     // Catch:{ Exception -> 0x0055 }
            if (r0 == 0) goto L_0x003f
            boolean r0 = r0.commit()     // Catch:{ Exception -> 0x0055 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0055 }
            r1.<init>()     // Catch:{ Exception -> 0x0055 }
            java.lang.String r2 = "清空crash缓存信息 是否成功 = "
            r1.append(r2)     // Catch:{ Exception -> 0x0055 }
            r1.append(r0)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0055 }
            r3.m2617f(r0)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ddmap.sdk.degrade.gnav.GoogleNavDegrade.m2616f():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m2617f(String str) {
        SystemUtils.log(3, "GoogleNavDegrade", str, (Throwable) null, "com.ddmap.sdk.degrade.gnav.GoogleNavDegrade", 322);
    }
}
