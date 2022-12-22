package com.datadog.android.core.configuration;

import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.event.EventMapper;
import com.datadog.android.rum.internal.domain.event.RumEventMapper;
import com.datadog.android.rum.internal.tracking.UserActionTrackingStrategy;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.tracking.TrackingStrategy;
import com.datadog.android.rum.tracking.ViewTrackingStrategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Configuration.kt */
final class Configuration$Builder$setRumResourceEventMapper$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EventMapper<ResourceEvent> $eventMapper;
    final /* synthetic */ Configuration.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Configuration$Builder$setRumResourceEventMapper$1(Configuration.Builder builder, EventMapper<ResourceEvent> eventMapper) {
        super(0);
        this.this$0 = builder;
        this.$eventMapper = eventMapper;
    }

    public final void invoke() {
        Configuration.Builder builder = this.this$0;
        builder.rumConfig = Configuration.Feature.RUM.copy$default(builder.rumConfig, (String) null, (List) null, 0.0f, (UserActionTrackingStrategy) null, (ViewTrackingStrategy) null, (TrackingStrategy) null, RumEventMapper.copy$default(this.this$0.getRumEventMapper(), (EventMapper) null, (EventMapper) null, this.$eventMapper, (EventMapper) null, (EventMapper) null, 27, (Object) null), false, 191, (Object) null);
    }
}
