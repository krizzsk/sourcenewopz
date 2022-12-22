package com.datadog.android.rum.tracking;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/rum/tracking/ComponentPredicate;", "T", "", "accept", "", "component", "(Ljava/lang/Object;)Z", "getViewName", "", "(Ljava/lang/Object;)Ljava/lang/String;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComponentPredicate.kt */
public interface ComponentPredicate<T> {
    boolean accept(T t);

    String getViewName(T t);
}
