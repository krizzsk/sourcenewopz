package kshark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, mo175978d2 = {"Lkshark/AndroidMetadataExtractor;", "Lkshark/MetadataExtractor;", "()V", "extractMetadata", "", "", "graph", "Lkshark/HeapGraph;", "readLeakCanaryVersion", "readProcessName", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: AndroidMetadataExtractor.kt */
public final class AndroidMetadataExtractor implements MetadataExtractor {
    public static final AndroidMetadataExtractor INSTANCE = new AndroidMetadataExtractor();

    private AndroidMetadataExtractor() {
    }

    public Map<String, String> extractMetadata(HeapGraph heapGraph) {
        Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
        AndroidBuildMirror fromHeapGraph = AndroidBuildMirror.Companion.fromHeapGraph(heapGraph);
        return MapsKt.mapOf(TuplesKt.m42317to("Build.VERSION.SDK_INT", String.valueOf(fromHeapGraph.getSdkInt())), TuplesKt.m42317to("Build.MANUFACTURER", fromHeapGraph.getManufacturer()), TuplesKt.m42317to("LeakCanary version", m2903a(heapGraph)), TuplesKt.m42317to("App process name", m2904b(heapGraph)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        r2 = (r2 = (r2 = r2.get("version")).getValue()).readAsJavaString();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m2903a(kshark.HeapGraph r2) {
        /*
            r1 = this;
            java.lang.String r0 = "leakcanary.internal.InternalLeakCanary"
            kshark.HeapObject$HeapClass r2 = r2.findClassByName(r0)
            if (r2 == 0) goto L_0x001d
            java.lang.String r0 = "version"
            kshark.HeapField r2 = r2.get(r0)
            if (r2 == 0) goto L_0x001d
            kshark.HeapValue r2 = r2.getValue()
            if (r2 == 0) goto L_0x001d
            java.lang.String r2 = r2.readAsJavaString()
            if (r2 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            java.lang.String r2 = "Unknown"
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.AndroidMetadataExtractor.m2903a(kshark.HeapGraph):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r4 = r4.get("sCurrentActivityThread");
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m2904b(kshark.HeapGraph r4) {
        /*
            r3 = this;
            java.lang.String r0 = "android.app.ActivityThread"
            kshark.HeapObject$HeapClass r4 = r4.findClassByName(r0)
            r1 = 0
            if (r4 == 0) goto L_0x0016
            java.lang.String r2 = "sCurrentActivityThread"
            kshark.HeapField r4 = r4.get(r2)
            if (r4 == 0) goto L_0x0016
            kshark.HeapObject$HeapInstance r4 = r4.getValueAsInstance()
            goto L_0x0017
        L_0x0016:
            r4 = r1
        L_0x0017:
            if (r4 == 0) goto L_0x0026
            java.lang.String r2 = "mBoundApplication"
            kshark.HeapField r4 = r4.get((java.lang.String) r0, (java.lang.String) r2)
            if (r4 == 0) goto L_0x0026
            kshark.HeapObject$HeapInstance r4 = r4.getValueAsInstance()
            goto L_0x0027
        L_0x0026:
            r4 = r1
        L_0x0027:
            if (r4 == 0) goto L_0x0037
            java.lang.String r0 = "android.app.ActivityThread$AppBindData"
            java.lang.String r2 = "appInfo"
            kshark.HeapField r4 = r4.get((java.lang.String) r0, (java.lang.String) r2)
            if (r4 == 0) goto L_0x0037
            kshark.HeapObject$HeapInstance r1 = r4.getValueAsInstance()
        L_0x0037:
            if (r1 == 0) goto L_0x0050
            java.lang.String r4 = "android.content.pm.ApplicationInfo"
            java.lang.String r0 = "processName"
            kshark.HeapField r4 = r1.get((java.lang.String) r4, (java.lang.String) r0)
            if (r4 == 0) goto L_0x0050
            kshark.HeapObject$HeapInstance r4 = r4.getValueAsInstance()
            if (r4 == 0) goto L_0x0050
            java.lang.String r4 = r4.readAsJavaString()
            if (r4 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            java.lang.String r4 = "Unknown"
        L_0x0052:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.AndroidMetadataExtractor.m2904b(kshark.HeapGraph):java.lang.String");
    }
}
