package com.datadog.android.core.configuration;

import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.event.SpanEventMapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Configuration.kt */
final class Configuration$Builder$setSpanEventMapper$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SpanEventMapper $eventMapper;
    final /* synthetic */ Configuration.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Configuration$Builder$setSpanEventMapper$1(Configuration.Builder builder, SpanEventMapper spanEventMapper) {
        super(0);
        this.this$0 = builder;
        this.$eventMapper = spanEventMapper;
    }

    public final void invoke() {
        Configuration.Builder builder = this.this$0;
        builder.tracesConfig = Configuration.Feature.Tracing.copy$default(builder.tracesConfig, (String) null, (List) null, this.$eventMapper, 3, (Object) null);
    }
}
