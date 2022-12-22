package com.kwai.koom.javaoom.analysis;

import android.graphics.Bitmap;
import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapField;
import kshark.HeapGraph;
import kshark.HeapObject;

public class BitmapLeakDetector extends LeakDetector {

    /* renamed from: a */
    static final /* synthetic */ boolean f55520a = (!BitmapLeakDetector.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final String f55521d = "android.graphics.Bitmap";

    /* renamed from: e */
    private static final String f55522e = "BitmapLeakDetector";

    /* renamed from: f */
    private long f55523f;

    /* renamed from: g */
    private ClassCounter f55524g;

    public String className() {
        return f55521d;
    }

    public String leakReason() {
        return "Bitmap Size";
    }

    private BitmapLeakDetector() {
    }

    public BitmapLeakDetector(HeapGraph heapGraph) {
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f55521d);
        if (f55520a || findClassByName != null) {
            this.f55523f = findClassByName.getObjectId();
            this.f55524g = new ClassCounter();
            return;
        }
        throw new AssertionError();
    }

    public long classId() {
        return this.f55523f;
    }

    public Class<?> clazz() {
        return Bitmap.class;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (this.f55554b) {
            KLog.m40102i(f55522e, "run isLeak");
        }
        this.f55524g.instancesCount++;
        HeapField heapField = heapInstance.get(f55521d, "mWidth");
        HeapField heapField2 = heapInstance.get(f55521d, "mHeight");
        if (!f55520a && heapField2 == null) {
            throw new AssertionError();
        } else if (f55520a || heapField != null) {
            boolean z = false;
            if (heapField2.getValue().getAsInt() == null || heapField.getValue().getAsInt() == null) {
                KLog.m40101e(f55522e, "ABNORMAL fieldWidth or fieldHeight is null");
                return false;
            }
            int intValue = heapField.getValue().getAsInt().intValue();
            int intValue2 = heapField2.getValue().getAsInt().intValue();
            if (intValue * intValue2 >= 1049088) {
                z = true;
            }
            if (z) {
                KLog.m40101e(f55522e, "bitmap leak : " + heapInstance.getInstanceClassName() + " width:" + intValue + " height:" + intValue2);
                ClassCounter classCounter = this.f55524g;
                classCounter.leakInstancesCount = classCounter.leakInstancesCount + 1;
            }
            return z;
        } else {
            throw new AssertionError();
        }
    }

    public ClassCounter instanceCount() {
        return this.f55524g;
    }
}
