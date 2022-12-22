package com.didichuxing.drtl.auto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didichuxing/drtl/auto/IDrtl;", "T", "", "apply", "", "(Ljava/lang/Object;)V", "filter", "", "any", "getType", "Ljava/lang/Class;", "onApply", "drtl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: IDrtl.kt */
public interface IDrtl<T> {
    void apply(T t);

    boolean filter(Object obj);

    Class<T> getType();

    void onApply(Object obj);

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    /* compiled from: IDrtl.kt */
    public static final class DefaultImpls {
        public static <T> boolean filter(IDrtl<T> iDrtl, Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "any");
            return Intrinsics.areEqual((Object) obj.getClass(), (Object) iDrtl.getType());
        }

        public static <T> void onApply(IDrtl<T> iDrtl, Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "any");
            iDrtl.apply(obj);
        }
    }
}
