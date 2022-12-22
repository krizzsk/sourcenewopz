package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.-$$Lambda$SQLiteEventStore$58qwLe9VEE9ed-waCrH8OyrydJA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SQLiteEventStore$58qwLe9VEE9edwaCrH8OyrydJA implements SQLiteEventStore.Function {
    public static final /* synthetic */ $$Lambda$SQLiteEventStore$58qwLe9VEE9edwaCrH8OyrydJA INSTANCE = new $$Lambda$SQLiteEventStore$58qwLe9VEE9edwaCrH8OyrydJA();

    private /* synthetic */ $$Lambda$SQLiteEventStore$58qwLe9VEE9edwaCrH8OyrydJA() {
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$getNextCallTime$4((Cursor) obj);
    }
}
