package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.-$$Lambda$ky9PmMQY9PhnKcqK77KNYHUaLEk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ky9PmMQY9PhnKcqK77KNYHUaLEk implements SQLiteEventStore.Function {
    public static final /* synthetic */ $$Lambda$ky9PmMQY9PhnKcqK77KNYHUaLEk INSTANCE = new $$Lambda$ky9PmMQY9PhnKcqK77KNYHUaLEk();

    private /* synthetic */ $$Lambda$ky9PmMQY9PhnKcqK77KNYHUaLEk() {
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
