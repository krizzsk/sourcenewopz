package com.didiglobal.security;

import com.didiglobal.security.Example;
import com.didiglobal.security.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, mo175978d2 = {"<anonymous>", "", "p1", "Lcom/didiglobal/security/Example$StateStorage;", "Lkotlin/ParameterName;", "name", "data", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: Example.kt */
final /* synthetic */ class Example$stateStorage$1 extends FunctionReference implements Function1<Example.StateStorage, String> {
    Example$stateStorage$1(GsonUtils gsonUtils) {
        super(1, gsonUtils);
    }

    public final String getName() {
        return "serialize";
    }

    public final KDeclarationContainer getOwner() {
        return C21490Reflection.getOrCreateKotlinClass(GsonUtils.class);
    }

    public final String getSignature() {
        return "serialize(Ljava/lang/Object;)Ljava/lang/String;";
    }

    public final String invoke(Example.StateStorage stateStorage) {
        Intrinsics.checkParameterIsNotNull(stateStorage, "p1");
        return ((GsonUtils) this.receiver).serialize(stateStorage);
    }
}
