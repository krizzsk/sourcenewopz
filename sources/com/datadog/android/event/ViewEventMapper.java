package com.datadog.android.event;

import com.datadog.android.rum.model.ViewEvent;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, mo175978d2 = {"Lcom/datadog/android/event/ViewEventMapper;", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/rum/model/ViewEvent;", "map", "event", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewEventMapper.kt */
public interface ViewEventMapper extends EventMapper<ViewEvent> {
    ViewEvent map(ViewEvent viewEvent);
}
