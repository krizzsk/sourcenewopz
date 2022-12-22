package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* compiled from: JvmPackageScope.kt */
final class JvmPackageScope$kotlinScopes$2 extends Lambda implements Function0<MemberScope[]> {
    final /* synthetic */ JvmPackageScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmPackageScope$kotlinScopes$2(JvmPackageScope jvmPackageScope) {
        super(0);
        this.this$0 = jvmPackageScope;
    }

    public final MemberScope[] invoke() {
        JvmPackageScope jvmPackageScope = this.this$0;
        Collection arrayList = new ArrayList();
        for (KotlinJvmBinaryClass createKotlinPackagePartScope : this.this$0.f60510c.getBinaryClasses$descriptors_jvm().values()) {
            MemberScope createKotlinPackagePartScope2 = jvmPackageScope.f60509b.getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(jvmPackageScope.f60510c, createKotlinPackagePartScope);
            if (createKotlinPackagePartScope2 != null) {
                arrayList.add(createKotlinPackagePartScope2);
            }
        }
        Object[] array = ScopeUtilsKt.listOfNonEmptyScopes((List) arrayList).toArray(new MemberScope[0]);
        if (array != null) {
            return (MemberScope[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
