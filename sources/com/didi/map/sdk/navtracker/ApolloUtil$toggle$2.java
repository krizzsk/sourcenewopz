package com.didi.map.sdk.navtracker;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo175978d2 = {"<anonymous>", "Lcom/didichuxing/apollo/sdk/IToggle;", "kotlin.jvm.PlatformType", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: ApolloUtil.kt */
final class ApolloUtil$toggle$2 extends Lambda implements Function0<IToggle> {
    public static final ApolloUtil$toggle$2 INSTANCE = new ApolloUtil$toggle$2();

    ApolloUtil$toggle$2() {
        super(0);
    }

    public final IToggle invoke() {
        return Apollo.getToggle("global_map_nav_usage_ora_toggle");
    }
}
