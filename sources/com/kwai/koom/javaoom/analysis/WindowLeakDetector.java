package com.kwai.koom.javaoom.analysis;

import android.view.Window;
import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapGraph;
import kshark.HeapObject;

public class WindowLeakDetector extends LeakDetector {

    /* renamed from: a */
    static final /* synthetic */ boolean f55565a = (!WindowLeakDetector.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final String f55566d = "WindowLeakDetector";

    /* renamed from: e */
    private static final String f55567e = "android.view.Window";

    /* renamed from: f */
    private static final int f55568f = 1;

    /* renamed from: g */
    private long f55569g;

    /* renamed from: h */
    private ClassCounter f55570h;

    public String className() {
        return f55567e;
    }

    public int generation() {
        return 1;
    }

    public String leakReason() {
        return "Window";
    }

    private WindowLeakDetector() {
    }

    public WindowLeakDetector(HeapGraph heapGraph) {
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f55567e);
        if (f55565a || findClassByName != null) {
            this.f55569g = findClassByName.getObjectId();
            this.f55570h = new ClassCounter();
            return;
        }
        throw new AssertionError();
    }

    public long classId() {
        return this.f55569g;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (this.f55554b) {
            KLog.m40102i(f55566d, "run isLeak");
        }
        this.f55570h.instancesCount++;
        return false;
    }

    public ClassCounter instanceCount() {
        return this.f55570h;
    }

    public Class<?> clazz() {
        return Window.class;
    }
}
