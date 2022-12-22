package com.kwai.koom.javaoom.analysis;

import androidx.fragment.app.Fragment;
import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapField;
import kshark.HeapGraph;
import kshark.HeapObject;

public class FragmentLeakDetector extends LeakDetector {

    /* renamed from: a */
    static final /* synthetic */ boolean f55530a = (!FragmentLeakDetector.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final String f55531d = "android.app.Fragment";

    /* renamed from: e */
    private static final String f55532e = "android.support.v4.app.Fragment";

    /* renamed from: f */
    private static final String f55533f = "androidx.fragment.app.Fragment";

    /* renamed from: g */
    private static final String f55534g = "mFragmentManager";

    /* renamed from: h */
    private static final String f55535h = "mCalled";

    /* renamed from: l */
    private static final String f55536l = "FragmentLeakDetector";

    /* renamed from: m */
    private static final int f55537m = 1;

    /* renamed from: i */
    private long f55538i;

    /* renamed from: j */
    private String f55539j = f55533f;

    /* renamed from: k */
    private ClassCounter f55540k;

    public int generation() {
        return 1;
    }

    public String leakReason() {
        return "Fragment Leak";
    }

    public FragmentLeakDetector(HeapGraph heapGraph) {
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f55533f);
        if (findClassByName == null) {
            findClassByName = heapGraph.findClassByName(f55531d);
            this.f55539j = f55531d;
        }
        if (findClassByName == null) {
            findClassByName = heapGraph.findClassByName(f55532e);
            this.f55539j = f55532e;
        }
        if (f55530a || findClassByName != null) {
            this.f55538i = findClassByName.getObjectId();
            this.f55540k = new ClassCounter();
            return;
        }
        throw new AssertionError();
    }

    public long classId() {
        return this.f55538i;
    }

    public String className() {
        return this.f55539j;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (this.f55554b) {
            KLog.m40102i(f55536l, "run isLeak");
        }
        this.f55540k.instancesCount++;
        HeapField heapField = heapInstance.get(this.f55539j, f55534g);
        boolean z = false;
        if (heapField != null && heapField.getValue().getAsObject() == null) {
            HeapField heapField2 = heapInstance.get(this.f55539j, f55535h);
            if (heapField2 == null || heapField2.getValue().getAsBoolean() == null) {
                KLog.m40101e(f55536l, "ABNORMAL mCalledField is null");
                return false;
            }
            z = heapField2.getValue().getAsBoolean().booleanValue();
            if (z) {
                if (this.f55554b) {
                    KLog.m40101e(f55536l, "fragment leak : " + heapInstance.getInstanceClassName());
                }
                this.f55540k.leakInstancesCount++;
            }
        }
        return z;
    }

    public ClassCounter instanceCount() {
        return this.f55540k;
    }

    public Class<?> clazz() {
        return Fragment.class;
    }
}
