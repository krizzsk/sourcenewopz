package com.didiglobal.security;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\r*\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fJ=\u0010\u0010\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\u0016\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0012¢\u0006\u0002\u0010\u0013JI\u0010\u0010\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\"\u0010\u0011\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u000f\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0014¢\u0006\u0002\u0010\u0015J1\u0010\u0016\u001a\u00020\f\"\b\b\u0000\u0010\r*\u00020\u00012\u0006\u0010\u0017\u001a\u0002H\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didiglobal/security/SharedPrefsDataStore;", "", "context", "Landroid/content/Context;", "spName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "masterKey", "Landroidx/security/crypto/MasterKey;", "sharedPrefs", "Landroid/content/SharedPreferences;", "remove", "", "T", "clazz", "Ljava/lang/Class;", "restore", "b", "Lkotlin/Function1;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlin/Function2;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "save", "data", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Key", "security_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SharedPrefsDataStore.kt */
public final class SharedPrefsDataStore {

    /* renamed from: a */
    private final MasterKey f51408a;

    /* renamed from: b */
    private final SharedPreferences f51409b;

    @Target(allowedTargets = {AnnotationTarget.CLASS})
    @Retention(AnnotationRetention.RUNTIME)
    @java.lang.annotation.Target({ElementType.TYPE})
    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didiglobal/security/SharedPrefsDataStore$Key;", "", "key", "", "()Ljava/lang/String;", "security_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    @java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
    /* compiled from: SharedPrefsDataStore.kt */
    public @interface Key {
        String key();
    }

    public SharedPrefsDataStore(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        MasterKey build = new MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "MasterKey.Builder(contex…256_GCM)\n        .build()");
        this.f51408a = build;
        if (str == null) {
            str = "SPDataStore_" + context.getApplicationInfo().processName;
        }
        SharedPreferences create = EncryptedSharedPreferences.create(context, str, this.f51408a, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkExpressionValueIsNotNull(create, "EncryptedSharedPreferenc…onScheme.AES256_GCM\n    )");
        this.f51409b = create;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SharedPrefsDataStore(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : str);
    }

    public final <T> T restore(Class<T> cls, Function1<? super String, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        Intrinsics.checkParameterIsNotNull(function1, "b");
        Key key = (Key) cls.getAnnotation(Key.class);
        String key2 = key != null ? key.key() : null;
        if (key2 != null) {
            return function1.invoke(this.f51409b.getString(key2, (String) null));
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final <T> T restore(Class<T> cls, Function2<? super String, ? super Class<T>, ? extends T> function2) {
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        Intrinsics.checkParameterIsNotNull(function2, "b");
        Key key = (Key) cls.getAnnotation(Key.class);
        String key2 = key != null ? key.key() : null;
        if (key2 != null) {
            return function2.invoke(this.f51409b.getString(key2, (String) null), cls);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final <T> void save(T t, Function1<? super T, String> function1) {
        Intrinsics.checkParameterIsNotNull(t, "data");
        Intrinsics.checkParameterIsNotNull(function1, "b");
        Key key = (Key) t.getClass().getAnnotation(Key.class);
        String key2 = key != null ? key.key() : null;
        if (key2 != null) {
            this.f51409b.edit().putString(key2, function1.invoke(t)).apply();
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final <T> void remove(Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        Key key = (Key) cls.getAnnotation(Key.class);
        String key2 = key != null ? key.key() : null;
        if (key2 != null) {
            this.f51409b.edit().remove(key2).apply();
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
