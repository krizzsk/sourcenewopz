package com.kwai.koom.javaoom.analysis;

import android.app.Activity;
import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapField;
import kshark.HeapGraph;
import kshark.HeapObject;

public class ActivityLeakDetector extends LeakDetector {

    /* renamed from: a */
    static final /* synthetic */ boolean f55513a = (!ActivityLeakDetector.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final String f55514d = "ActivityLeakDetector";

    /* renamed from: e */
    private static final String f55515e = "android.app.Activity";

    /* renamed from: f */
    private static final String f55516f = "mFinished";

    /* renamed from: g */
    private static final String f55517g = "mDestroyed";

    /* renamed from: h */
    private long f55518h;

    /* renamed from: i */
    private ClassCounter f55519i;

    public String className() {
        return f55515e;
    }

    public String leakReason() {
        return "Activity Leak";
    }

    private ActivityLeakDetector() {
    }

    public ActivityLeakDetector(HeapGraph heapGraph) {
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f55515e);
        if (f55513a || findClassByName != null) {
            this.f55518h = findClassByName.getObjectId();
            this.f55519i = new ClassCounter();
            return;
        }
        throw new AssertionError();
    }

    public long classId() {
        return this.f55518h;
    }

    public Class<?> clazz() {
        return Activity.class;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (this.f55554b) {
            KLog.m40102i(f55514d, "run isLeak");
        }
        this.f55519i.instancesCount++;
        HeapField heapField = heapInstance.get(f55515e, f55517g);
        HeapField heapField2 = heapInstance.get(f55515e, f55516f);
        if (!f55513a && heapField == null) {
            throw new AssertionError();
        } else if (f55513a || heapField2 != null) {
            boolean z = false;
            if (heapField.getValue().getAsBoolean() == null || heapField2.getValue().getAsBoolean() == null) {
                KLog.m40101e(f55514d, "ABNORMAL destroyField or finishedField is null");
                return false;
            }
            if (heapField.getValue().getAsBoolean().booleanValue() || heapField2.getValue().getAsBoolean().booleanValue()) {
                z = true;
            }
            if (z) {
                if (this.f55554b) {
                    KLog.m40101e(f55514d, "activity leak : " + heapInstance.getInstanceClassName());
                }
                this.f55519i.leakInstancesCount++;
            }
            return z;
        } else {
            throw new AssertionError();
        }
    }

    public ClassCounter instanceCount() {
        return this.f55519i;
    }
}
