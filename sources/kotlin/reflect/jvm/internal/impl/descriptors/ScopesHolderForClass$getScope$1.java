package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ScopesHolderForClass.kt */
final class ScopesHolderForClass$getScope$1 extends Lambda implements Function0<T> {
    final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
    final /* synthetic */ ScopesHolderForClass<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScopesHolderForClass$getScope$1(ScopesHolderForClass<T> scopesHolderForClass, KotlinTypeRefiner kotlinTypeRefiner) {
        super(0);
        this.this$0 = scopesHolderForClass;
        this.$kotlinTypeRefiner = kotlinTypeRefiner;
    }

    public final T invoke() {
        return (MemberScope) this.this$0.f60183c.invoke(this.$kotlinTypeRefiner);
    }
}
