package com.datadog.android.rum.internal.monitor;

import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.model.ViewEvent;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\u0003H&J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H&¨\u0006 "}, mo175978d2 = {"Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "Lcom/datadog/android/rum/RumMonitor;", "addCrash", "", "message", "", "source", "Lcom/datadog/android/rum/RumErrorSource;", "throwable", "", "addLongTask", "durationNs", "", "target", "addResourceTiming", "key", "timing", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "eventDropped", "viewId", "type", "Lcom/datadog/android/rum/internal/monitor/EventType;", "eventSent", "resetSession", "updateViewLoadingTime", "", "loadingTimeInNs", "Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "viewTreeChanged", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "waitForResourceTiming", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AdvancedRumMonitor.kt */
public interface AdvancedRumMonitor extends RumMonitor {
    void addCrash(String str, RumErrorSource rumErrorSource, Throwable th);

    void addLongTask(long j, String str);

    void addResourceTiming(String str, ResourceTiming resourceTiming);

    void eventDropped(String str, EventType eventType);

    void eventSent(String str, EventType eventType);

    void resetSession();

    void updateViewLoadingTime(Object obj, long j, ViewEvent.LoadingType loadingType);

    void viewTreeChanged(Time time);

    void waitForResourceTiming(String str);
}
