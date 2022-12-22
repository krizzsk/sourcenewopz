package com.didi.map.sdk.navtracker;

import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/map/sdk/navtracker/ApolloUtil;", "", "()V", "toggle", "Lcom/didichuxing/apollo/sdk/IToggle;", "getToggle", "()Lcom/didichuxing/apollo/sdk/IToggle;", "toggle$delegate", "Lkotlin/Lazy;", "isNeedUploadByGoogleStatements", "", "navtracker_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: ApolloUtil.kt */
public final class ApolloUtil {
    public static final ApolloUtil INSTANCE = new ApolloUtil();

    /* renamed from: a */
    static final /* synthetic */ KProperty[] f28547a = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(ApolloUtil.class), "toggle", "getToggle()Lcom/didichuxing/apollo/sdk/IToggle;"))};

    /* renamed from: b */
    private static final Lazy f28548b = LazyKt.lazy(ApolloUtil$toggle$2.INSTANCE);

    /* renamed from: a */
    private final IToggle m20188a() {
        Lazy lazy = f28548b;
        KProperty kProperty = f28547a[0];
        return (IToggle) lazy.getValue();
    }

    private ApolloUtil() {
    }

    public final boolean isNeedUploadByGoogleStatements() {
        if (m20188a() != null) {
            return m20188a().allow();
        }
        return false;
    }
}
