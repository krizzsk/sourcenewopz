package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.-$$Lambda$SQLiteEventStore$7lzpdRCmVweMjmsmt2DJiad_WGE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SQLiteEventStore$7lzpdRCmVweMjmsmt2DJiad_WGE implements SQLiteEventStore.Function {
    public static final /* synthetic */ $$Lambda$SQLiteEventStore$7lzpdRCmVweMjmsmt2DJiad_WGE INSTANCE = new $$Lambda$SQLiteEventStore$7lzpdRCmVweMjmsmt2DJiad_WGE();

    private /* synthetic */ $$Lambda$SQLiteEventStore$7lzpdRCmVweMjmsmt2DJiad_WGE() {
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$clearDb$11((SQLiteDatabase) obj);
    }
}
