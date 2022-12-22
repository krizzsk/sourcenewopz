package com.jumio.core.util;

import com.jumio.core.plugins.AnalyticsPlugin;
import com.jumio.core.plugins.C20007a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\n"}, mo175978d2 = {"Lcom/jumio/core/util/DataDogHelper;", "", "key", "", "reportViewStart", "reportViewStop", "Lcom/jumio/core/plugins/AnalyticsPlugin;", "getPlugin", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: DataDogHelper.kt */
public final class DataDogHelper {
    public static final DataDogHelper INSTANCE = new DataDogHelper();

    public final AnalyticsPlugin getPlugin() {
        C20007a.C20010c cVar = C20007a.C20010c.DATADOG;
        if (C20007a.m39595c(cVar)) {
            return (AnalyticsPlugin) C20007a.m39594b(cVar);
        }
        return null;
    }

    public final void reportViewStart(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "key");
        AnalyticsPlugin plugin = getPlugin();
        if (plugin != null) {
            AnalyticsPlugin.C20006a.m39587a(plugin, obj, (Map) null, 2, (Object) null);
        }
    }

    public final void reportViewStop(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "key");
        AnalyticsPlugin plugin = getPlugin();
        if (plugin != null) {
            AnalyticsPlugin.C20006a.m39589b(plugin, obj, (Map) null, 2, (Object) null);
        }
    }
}
