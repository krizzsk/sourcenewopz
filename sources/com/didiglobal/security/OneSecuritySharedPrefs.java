package com.didiglobal.security;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.didiglobal.security.utils.GsonUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00102\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00122\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00142\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J?\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u0019J.\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J>\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00102\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00122\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00142\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J2\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J,\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J$\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006!"}, mo175978d2 = {"Lcom/didiglobal/security/OneSecuritySharedPrefs;", "", "()V", "clear", "", "context", "Landroid/content/Context;", "spName", "", "createEncryptedSharedPrefs", "Landroid/content/SharedPreferences;", "getBoolean", "", "key", "defValue", "getFloat", "", "getInt", "", "getLong", "", "getObject", "T", "clz", "Ljava/lang/Class;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "getString", "getStringSet", "", "put", "value", "putObject", "remove", "security_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: OneSecuritySharedPrefs.kt */
public final class OneSecuritySharedPrefs {
    public static final OneSecuritySharedPrefs INSTANCE = new OneSecuritySharedPrefs();

    @JvmStatic
    public static final void clear(Context context) {
        clear$default(context, (String) null, 2, (Object) null);
    }

    @JvmStatic
    public static final boolean getBoolean(Context context, String str, boolean z) {
        return getBoolean$default(context, str, z, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final float getFloat(Context context, String str, float f) {
        return getFloat$default(context, str, f, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final int getInt(Context context, String str, int i) {
        return getInt$default(context, str, i, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final long getLong(Context context, String str, long j) {
        return getLong$default(context, str, j, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final <T> T getObject(Context context, String str, Class<T> cls) {
        return getObject$default(context, str, cls, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final String getString(Context context, String str, String str2) {
        return getString$default(context, str, str2, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final Set<String> getStringSet(Context context, String str) {
        return getStringSet$default(context, str, (Set) null, (String) null, 12, (Object) null);
    }

    @JvmStatic
    public static final Set<String> getStringSet(Context context, String str, Set<String> set) {
        return getStringSet$default(context, str, set, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void put(Context context, String str, float f) {
        put$default(context, str, f, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void put(Context context, String str, int i) {
        put$default(context, str, i, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void put(Context context, String str, long j) {
        put$default(context, str, j, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void put(Context context, String str, String str2) {
        put$default(context, str, str2, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void put(Context context, String str, Set<String> set) {
        put$default(context, str, (Set) set, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void put(Context context, String str, boolean z) {
        put$default(context, str, z, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void putObject(Context context, String str, Object obj) {
        putObject$default(context, str, obj, (String) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void remove(Context context, String str) {
        remove$default(context, str, (String) null, 4, (Object) null);
    }

    private OneSecuritySharedPrefs() {
    }

    /* renamed from: a */
    static /* synthetic */ SharedPreferences m36809a(OneSecuritySharedPrefs oneSecuritySharedPrefs, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return oneSecuritySharedPrefs.m36808a(context, str);
    }

    /* renamed from: a */
    private final SharedPreferences m36808a(Context context, String str) {
        MasterKey build = new MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "MasterKey.Builder(contex…GCM)\n            .build()");
        if (str == null) {
            str = "SharedPrefs_" + context.getApplicationInfo().processName;
        }
        SharedPreferences create = EncryptedSharedPreferences.create(context, str, build, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkExpressionValueIsNotNull(create, "EncryptedSharedPreferenc…heme.AES256_GCM\n        )");
        return create;
    }

    public static /* synthetic */ void put$default(Context context, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        put(context, str, i, str2);
    }

    @JvmStatic
    public static final void put(Context context, String str, int i, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        INSTANCE.m36808a(context, str2).edit().putInt(str, i).apply();
    }

    public static /* synthetic */ void put$default(Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        put(context, str, z, str2);
    }

    @JvmStatic
    public static final void put(Context context, String str, boolean z, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        INSTANCE.m36808a(context, str2).edit().putBoolean(str, z).apply();
    }

    public static /* synthetic */ void put$default(Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        put(context, str, str2, str3);
    }

    @JvmStatic
    public static final void put(Context context, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        INSTANCE.m36808a(context, str3).edit().putString(str, str2).apply();
    }

    public static /* synthetic */ void put$default(Context context, String str, long j, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        put(context, str, j, str2);
    }

    @JvmStatic
    public static final void put(Context context, String str, long j, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        INSTANCE.m36808a(context, str2).edit().putLong(str, j).apply();
    }

    public static /* synthetic */ void put$default(Context context, String str, float f, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        put(context, str, f, str2);
    }

    @JvmStatic
    public static final void put(Context context, String str, float f, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        INSTANCE.m36808a(context, str2).edit().putFloat(str, f).apply();
    }

    public static /* synthetic */ void put$default(Context context, String str, Set set, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        put(context, str, (Set<String>) set, str2);
    }

    @JvmStatic
    public static final void put(Context context, String str, Set<String> set, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(set, "value");
        INSTANCE.m36808a(context, str2).edit().putStringSet(str, set).apply();
    }

    public static /* synthetic */ void putObject$default(Context context, String str, Object obj, String str2, int i, Object obj2) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        putObject(context, str, obj, str2);
    }

    @JvmStatic
    public static final void putObject(Context context, String str, Object obj, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(obj, "value");
        SharedPreferences.Editor edit = INSTANCE.m36808a(context, str2).edit();
        edit.putString(str, GsonUtils.INSTANCE.serialize(obj));
        edit.apply();
    }

    public static /* synthetic */ String getString$default(Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        return getString(context, str, str2, str3);
    }

    @JvmStatic
    public static final String getString(Context context, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "defValue");
        return INSTANCE.m36808a(context, str3).getString(str, str2);
    }

    public static /* synthetic */ long getLong$default(Context context, String str, long j, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return getLong(context, str, j, str2);
    }

    @JvmStatic
    public static final long getLong(Context context, String str, long j, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return INSTANCE.m36808a(context, str2).getLong(str, j);
    }

    public static /* synthetic */ boolean getBoolean$default(Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return getBoolean(context, str, z, str2);
    }

    @JvmStatic
    public static final boolean getBoolean(Context context, String str, boolean z, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return INSTANCE.m36808a(context, str2).getBoolean(str, z);
    }

    public static /* synthetic */ int getInt$default(Context context, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return getInt(context, str, i, str2);
    }

    @JvmStatic
    public static final int getInt(Context context, String str, int i, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return INSTANCE.m36808a(context, str2).getInt(str, i);
    }

    public static /* synthetic */ float getFloat$default(Context context, String str, float f, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return getFloat(context, str, f, str2);
    }

    @JvmStatic
    public static final float getFloat(Context context, String str, float f, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return INSTANCE.m36808a(context, str2).getFloat(str, f);
    }

    public static /* synthetic */ Set getStringSet$default(Context context, String str, Set set, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            set = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return getStringSet(context, str, set, str2);
    }

    @JvmStatic
    public static final Set<String> getStringSet(Context context, String str, Set<String> set, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return INSTANCE.m36808a(context, str2).getStringSet(str, set);
    }

    public static /* synthetic */ Object getObject$default(Context context, String str, Class cls, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return getObject(context, str, cls, str2);
    }

    @JvmStatic
    public static final <T> T getObject(Context context, String str, Class<T> cls, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(cls, "clz");
        return GsonUtils.INSTANCE.fromJson(INSTANCE.m36808a(context, str2).getString(str, (String) null), cls);
    }

    public static /* synthetic */ void remove$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        remove(context, str, str2);
    }

    @JvmStatic
    public static final void remove(Context context, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "key");
        INSTANCE.m36808a(context, str2).edit().remove(str).apply();
    }

    public static /* synthetic */ void clear$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        clear(context, str);
    }

    @JvmStatic
    public static final void clear(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        INSTANCE.m36808a(context, str).edit().clear().apply();
    }
}
