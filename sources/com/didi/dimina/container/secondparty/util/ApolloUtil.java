package com.didi.dimina.container.secondparty.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/util/ApolloUtil;", "", "()V", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ApolloUtil.kt */
public final class ApolloUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final boolean getApolloAllow(String str) {
        return Companion.getApolloAllow(str);
    }

    @JvmStatic
    public static final <T> T getApolloValue(String str, String str2, T t) {
        return Companion.getApolloValue(str, str2, t);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J+\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u0002H\bH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/util/ApolloUtil$Companion;", "", "()V", "getApolloAllow", "", "toggle", "", "getApolloValue", "T", "key", "def", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ApolloUtil.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean getApolloAllow(String str) {
            Intrinsics.checkParameterIsNotNull(str, "toggle");
            IToggle toggle = Apollo.getToggle(str);
            if (toggle != null) {
                return toggle.allow();
            }
            return false;
        }

        @JvmStatic
        public final <T> T getApolloValue(String str, String str2, T t) {
            Intrinsics.checkParameterIsNotNull(str, "toggle");
            Intrinsics.checkParameterIsNotNull(str2, "key");
            IToggle toggle = Apollo.getToggle(str);
            return (toggle == null || !toggle.allow()) ? t : toggle.getExperiment().getParam(str2, t);
        }
    }
}
