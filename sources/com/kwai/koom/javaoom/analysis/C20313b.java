package com.kwai.koom.javaoom.analysis;

import android.util.Pair;
import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.report.HeapAnalyzeReporter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.C21490Reflection;
import kshark.AndroidReferenceMatchers;
import kshark.ApplicationLeak;
import kshark.GcRoot;
import kshark.HeapAnalyzer;
import kshark.HeapGraph;
import kshark.HeapObject;
import kshark.Hprof;
import kshark.HprofHeapGraph;
import kshark.LibraryLeak;
import kshark.ProguardMapping;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.kwai.koom.javaoom.analysis.b */
/* compiled from: SuspicionLeaksFinder */
class C20313b {

    /* renamed from: b */
    private static final String f55573b = "LeaksFinder";

    /* renamed from: h */
    private static final int f55574h = 45;

    /* renamed from: a */
    public Map<Long, String> f55575a;

    /* renamed from: c */
    private Set<Long> f55576c = new HashSet();

    /* renamed from: d */
    private KHeapFile.Hprof f55577d;

    /* renamed from: e */
    private HeapGraph f55578e;

    /* renamed from: f */
    private List<LeakDetector> f55579f = new ArrayList();

    /* renamed from: g */
    private Set<Integer> f55580g = new HashSet();

    public C20313b(KHeapFile.Hprof hprof) {
        this.f55577d = hprof;
    }

    /* renamed from: e */
    private void m40087e() {
        m40085a((LeakDetector) new ActivityLeakDetector(this.f55578e));
        m40085a((LeakDetector) new FragmentLeakDetector(this.f55578e));
        m40085a((LeakDetector) new BitmapLeakDetector(this.f55578e));
        m40085a((LeakDetector) new NativeAllocationRegistryLeakDetector(this.f55578e));
        m40085a((LeakDetector) new WindowLeakDetector(this.f55578e));
        ClassHierarchyFetcher.m40071a(this.f55580g);
        this.f55575a = new HashMap();
    }

    /* renamed from: a */
    private void m40085a(LeakDetector leakDetector) {
        this.f55579f.add(leakDetector);
        this.f55580g.add(Integer.valueOf(leakDetector.generation()));
    }

    /* renamed from: a */
    public Pair<List<ApplicationLeak>, List<LibraryLeak>> mo164756a() {
        if (!m40090h()) {
            return null;
        }
        m40087e();
        mo164757b();
        return mo164758c();
    }

    /* renamed from: b */
    public void mo164757b() {
        KLog.m40102i(f55573b, "start find leaks");
        for (HeapObject.HeapInstance next : this.f55578e.getInstances()) {
            if (!next.isPrimitiveWrapper()) {
                ClassHierarchyFetcher.m40070a(next.getInstanceClassId(), next.getInstanceClass().getClassHierarchy());
                for (LeakDetector next2 : this.f55579f) {
                    if (next2.isSubClass(next.getInstanceClassId()) && next2.isLeak(next) && next2.instanceCount().leakInstancesCount <= 45) {
                        this.f55576c.add(Long.valueOf(next.getObjectId()));
                        this.f55575a.put(Long.valueOf(next.getObjectId()), next2.leakReason());
                    }
                }
            }
        }
        HeapAnalyzeReporter.addClassInfo(this.f55579f);
        m40088f();
        m40089g();
    }

    /* renamed from: f */
    private void m40088f() {
        for (HeapObject.HeapPrimitiveArray next : this.f55578e.getPrimitiveArrays()) {
            int arrayLength = next.getArrayLength();
            if (arrayLength >= 262144) {
                String arrayClassName = next.getArrayClassName();
                String primitiveType = next.getPrimitiveType().toString();
                KLog.m40101e(f55573b, "primitive arrayName:" + arrayClassName + " typeName:" + primitiveType + " objectId:" + (next.getObjectId() & InternalZipConstants.ZIP_64_SIZE_LIMIT) + " arraySize:" + arrayLength);
                this.f55576c.add(Long.valueOf(next.getObjectId()));
                Map<Long, String> map = this.f55575a;
                Long valueOf = Long.valueOf(next.getObjectId());
                map.put(valueOf, "primitive array size over threshold:" + arrayLength + "," + (arrayLength / KConstants.Bytes.f55585KB) + "KB");
            }
        }
    }

    /* renamed from: g */
    private void m40089g() {
        for (HeapObject.HeapObjectArray next : this.f55578e.getObjectArrays()) {
            int arrayLength = next.getArrayLength();
            if (arrayLength >= 262144) {
                String arrayClassName = next.getArrayClassName();
                KLog.m40102i(f55573b, "object arrayName:" + arrayClassName + " objectId:" + next.getObjectId());
                this.f55576c.add(Long.valueOf(next.getObjectId()));
                Map<Long, String> map = this.f55575a;
                Long valueOf = Long.valueOf(next.getObjectId());
                map.put(valueOf, "object array size over threshold:" + arrayLength);
            }
        }
    }

    /* renamed from: c */
    public Pair<List<ApplicationLeak>, List<LibraryLeak>> mo164758c() {
        KLog.m40102i(f55573b, "findPath object size:" + this.f55576c.size());
        kotlin.Pair<List<ApplicationLeak>, List<LibraryLeak>> findLeaks = new HeapAnalyzer($$Lambda$b$mv2JeW4XED0joeF8YMa1OiQof6E.INSTANCE).findLeaks(new HeapAnalyzer.FindLeakInput(this.f55578e, AndroidReferenceMatchers.Companion.getAppDefaults(), false, Collections.emptyList()), this.f55576c, true);
        return new Pair<>(findLeaks.getFirst(), findLeaks.getSecond());
    }

    /* renamed from: h */
    private boolean m40090h() {
        KLog.m40102i(f55573b, "build index file:" + this.f55577d.path);
        if (this.f55577d.file() == null || !this.f55577d.file().exists()) {
            KLog.m40101e(f55573b, "hprof file is not exists : " + this.f55577d.path + "!!");
            return false;
        }
        this.f55578e = HprofHeapGraph.Companion.indexHprof(Hprof.Companion.open(this.f55577d.file()), (ProguardMapping) null, SetsKt.setOf(C21490Reflection.getOrCreateKotlinClass(GcRoot.JniGlobal.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.JniLocal.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.NativeStack.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.StickyClass.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.ThreadBlock.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.ThreadObject.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.JniMonitor.class)));
        return true;
    }

    /* renamed from: d */
    public Map<Long, String> mo164759d() {
        return this.f55575a;
    }
}
