package p242io.flutter.embedding.engine.loader;

/* renamed from: io.flutter.embedding.engine.loader.FlutterApplicationInfo */
public final class FlutterApplicationInfo {

    /* renamed from: b */
    private static final String f57633b = "libapp.so";

    /* renamed from: c */
    private static final String f57634c = "vm_snapshot_data";

    /* renamed from: d */
    private static final String f57635d = "isolate_snapshot_data";

    /* renamed from: e */
    private static final String f57636e = "flutter_assets";

    /* renamed from: a */
    final boolean f57637a;
    public final String aotSharedLibraryName;
    public final String domainNetworkPolicy;
    public final String flutterAssetsDir;
    public final String isolateSnapshotData;
    public final String nativeLibraryDir;
    public final String vmSnapshotData;

    public FlutterApplicationInfo(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this.aotSharedLibraryName = str == null ? f57633b : str;
        this.vmSnapshotData = str2 == null ? f57634c : str2;
        this.isolateSnapshotData = str3 == null ? f57635d : str3;
        this.flutterAssetsDir = str4 == null ? f57636e : str4;
        this.nativeLibraryDir = str6;
        this.domainNetworkPolicy = str5 == null ? "" : str5;
        this.f57637a = z;
    }
}
