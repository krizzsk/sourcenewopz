package com.jumio.core.plugins;

import android.content.Context;
import com.jumio.core.Controller;
import com.jumio.core.models.ScanPartModel;
import java.util.Map;
import jumio.core.C21343c0;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H&JC\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H&J(\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001aH&J(\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001aH&¨\u0006\u001e"}, mo175978d2 = {"Lcom/jumio/core/plugins/AnalyticsPlugin;", "Ljumio/core/c0;", "Landroid/content/Context;", "context", "", "clientId", "appId", "", "run", "id", "url", "", "size", "method", "reportRequest", "statusCode", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "reportResponse", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/Exception;)V", "", "boolean", "enableDataCollection", "", "key", "", "attributes", "reportViewStart", "reportViewStop", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: AnalyticsPlugin.kt */
public interface AnalyticsPlugin extends C21343c0 {

    /* renamed from: com.jumio.core.plugins.AnalyticsPlugin$a */
    /* compiled from: AnalyticsPlugin.kt */
    public static final class C20006a {
        /* renamed from: a */
        public static /* synthetic */ void m39588a(AnalyticsPlugin analyticsPlugin, String str, String str2, Integer num, int i, Exception exc, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 16) != 0) {
                    exc = null;
                }
                analyticsPlugin.reportResponse(str, str2, num, i, exc);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportResponse");
        }

        /* renamed from: b */
        public static /* synthetic */ void m39589b(AnalyticsPlugin analyticsPlugin, Object obj, Map map, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    map = MapsKt.emptyMap();
                }
                analyticsPlugin.reportViewStop(obj, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportViewStop");
        }

        /* renamed from: a */
        public static /* synthetic */ void m39587a(AnalyticsPlugin analyticsPlugin, Object obj, Map map, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    map = MapsKt.emptyMap();
                }
                analyticsPlugin.reportViewStart(obj, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportViewStart");
        }
    }

    void enableDataCollection(boolean z);

    /* synthetic */ boolean isUsable(Controller controller, ScanPartModel scanPartModel);

    void reportRequest(String str, String str2, int i, String str3);

    void reportResponse(String str, String str2, Integer num, int i, Exception exc);

    void reportViewStart(Object obj, Map<String, ? extends Object> map);

    void reportViewStop(Object obj, Map<String, ? extends Object> map);

    void run(Context context, String str, String str2);
}
