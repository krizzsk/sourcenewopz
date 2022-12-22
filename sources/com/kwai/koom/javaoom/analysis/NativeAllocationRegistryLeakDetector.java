package com.kwai.koom.javaoom.analysis;

import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapGraph;
import kshark.HeapObject;

public class NativeAllocationRegistryLeakDetector extends LeakDetector {

    /* renamed from: a */
    private static final String f55556a = "NativeAllocation";

    /* renamed from: d */
    private static final String f55557d = "libcore.util.NativeAllocationRegistry";

    /* renamed from: e */
    private static final String f55558e = "libcore.util.NativeAllocationRegistry$CleanerThunk";

    /* renamed from: f */
    private static final int f55559f = 1;

    /* renamed from: g */
    private boolean f55560g;

    /* renamed from: h */
    private long f55561h;

    /* renamed from: i */
    private long f55562i;

    /* renamed from: j */
    private ClassCounter f55563j;

    public String className() {
        return f55557d;
    }

    public Class<?> clazz() {
        return null;
    }

    public int generation() {
        return 1;
    }

    public String leakReason() {
        return f55556a;
    }

    private NativeAllocationRegistryLeakDetector() {
    }

    public NativeAllocationRegistryLeakDetector(HeapGraph heapGraph) {
        if (this.f55554b) {
            KLog.m40102i(f55556a, "run isLeak");
        }
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f55557d);
        HeapObject.HeapClass findClassByName2 = heapGraph.findClassByName(f55558e);
        if (findClassByName != null) {
            this.f55561h = findClassByName.getObjectId();
        } else {
            this.f55560g = false;
        }
        if (findClassByName2 != null) {
            this.f55562i = findClassByName2.getObjectId();
        } else {
            this.f55560g = false;
        }
        this.f55563j = new ClassCounter();
        this.f55560g = true;
    }

    public boolean isSubClass(long j) {
        if (!this.f55560g) {
            return false;
        }
        long a = ClassHierarchyFetcher.m40068a(j, generation());
        if (a == this.f55561h || a == this.f55562i) {
            return true;
        }
        return false;
    }

    public long classId() {
        return this.f55561h;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (!this.f55560g) {
            return false;
        }
        this.f55563j.instancesCount++;
        return false;
    }

    public ClassCounter instanceCount() {
        return this.f55563j;
    }
}
