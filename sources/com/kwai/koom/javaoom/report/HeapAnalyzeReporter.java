package com.kwai.koom.javaoom.report;

import android.os.Build;
import android.os.Debug;
import android.util.Pair;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.gson.Gson;
import com.kwai.koom.javaoom.analysis.LeakDetector;
import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.common.KUtils;
import com.kwai.koom.javaoom.monitor.TriggerReason;
import com.kwai.koom.javaoom.report.HeapReport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kshark.ApplicationLeak;
import kshark.Leak;
import kshark.LeakTrace;
import kshark.LeakTraceObject;
import kshark.LeakTraceReference;
import kshark.LibraryLeak;
import net.lingala.zip4j.util.InternalZipConstants;

public class HeapAnalyzeReporter {

    /* renamed from: a */
    private static final String f55646a = "HeapAnalyzeReporter";

    /* renamed from: b */
    private static HeapAnalyzeReporter f55647b;

    /* renamed from: c */
    private File f55648c = KHeapFile.getKHeapFile().report.file();

    /* renamed from: d */
    private HeapReport f55649d;

    /* renamed from: e */
    private Gson f55650e = new Gson();

    public HeapAnalyzeReporter() {
        HeapReport c = m40125c();
        this.f55649d = c;
        if (c == null) {
            this.f55649d = new HeapReport();
        }
    }

    /* renamed from: a */
    private static HeapAnalyzeReporter m40118a() {
        HeapAnalyzeReporter heapAnalyzeReporter = f55647b;
        if (heapAnalyzeReporter != null) {
            return heapAnalyzeReporter;
        }
        HeapAnalyzeReporter heapAnalyzeReporter2 = new HeapAnalyzeReporter();
        f55647b = heapAnalyzeReporter2;
        return heapAnalyzeReporter2;
    }

    /* renamed from: b */
    private void m40124b() {
        FileOutputStream fileOutputStream;
        IOException e;
        try {
            String json = this.f55650e.toJson((Object) this.f55649d);
            fileOutputStream = new FileOutputStream(this.f55648c);
            try {
                KLog.m40102i(f55646a, "flushFile " + this.f55648c.getPath() + " str:" + json);
                fileOutputStream.write(json.getBytes());
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            fileOutputStream = null;
            e = e3;
            try {
                e.printStackTrace();
                KUtils.closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                KUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
            KUtils.closeQuietly(fileOutputStream);
            throw th;
        }
        KUtils.closeQuietly(fileOutputStream);
    }

    /* renamed from: c */
    private HeapReport m40125c() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(this.f55648c);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                if (KConstants.Debug.VERBOSE_LOG) {
                    KLog.m40102i(f55646a, "loadFile " + this.f55648c.getPath() + " str:" + str);
                }
                HeapReport heapReport = (HeapReport) this.f55650e.fromJson(str, HeapReport.class);
                KUtils.closeQuietly(fileInputStream);
                return heapReport;
            } catch (IOException unused) {
                fileInputStream2 = fileInputStream;
                KUtils.closeQuietly(fileInputStream2);
                return new HeapReport();
            } catch (Throwable th2) {
                th = th2;
                KUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (IOException unused2) {
            KUtils.closeQuietly(fileInputStream2);
            return new HeapReport();
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = null;
            th = th4;
            KUtils.closeQuietly(fileInputStream);
            throw th;
        }
    }

    /* renamed from: d */
    private HeapReport.RunningInfo m40126d() {
        if (this.f55649d.runningInfo != null) {
            return this.f55649d.runningInfo;
        }
        HeapReport heapReport = this.f55649d;
        HeapReport.RunningInfo runningInfo = new HeapReport.RunningInfo();
        heapReport.runningInfo = runningInfo;
        return runningInfo;
    }

    /* renamed from: e */
    private void m40127e() {
        KLog.m40102i(f55646a, "addRunningInfoInternal");
        HeapReport.RunningInfo d = m40126d();
        d.buildModel = Build.MODEL;
        d.manufacture = Build.MANUFACTURER;
        d.sdkInt = Integer.valueOf(Build.VERSION.SDK_INT);
        d.usageSeconds = KGlobalConfig.getRunningInfoFetcher().usageSeconds();
        d.currentPage = KGlobalConfig.getRunningInfoFetcher().currentPage();
        d.appVersion = KGlobalConfig.getRunningInfoFetcher().appVersion();
        d.nowTime = KUtils.getTimeStamp();
        d.jvmMax = Integer.valueOf((int) (Runtime.getRuntime().maxMemory() / ((long) KConstants.Bytes.f55586MB)));
        d.jvmUsed = Integer.valueOf((int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / ((long) KConstants.Bytes.f55586MB)));
        d.pss = Integer.valueOf((int) (Debug.getPss() / ((long) KConstants.Bytes.f55585KB)));
        KUtils.ProcessStatus processMemoryUsage = KUtils.getProcessMemoryUsage();
        d.vss = Integer.valueOf((int) (processMemoryUsage.vssKbSize / ((long) KConstants.Bytes.f55585KB)));
        d.rss = Integer.valueOf((int) (processMemoryUsage.rssKbSize / ((long) KConstants.Bytes.f55585KB)));
        d.threadCount = Integer.valueOf(processMemoryUsage.threadsCount);
        d.koomVersion = Integer.valueOf(KConstants.KOOMVersion.CODE);
        this.f55649d.runningInfo = d;
        m40124b();
    }

    public static void addDeviceRunningInfo() {
        m40118a().m40127e();
    }

    /* renamed from: a */
    private void m40121a(TriggerReason.DumpReason dumpReason) {
        m40126d().dumpReason = dumpReason.name();
        m40124b();
    }

    public static void addDumpReason(TriggerReason.DumpReason dumpReason) {
        m40118a().m40121a(dumpReason);
    }

    /* renamed from: a */
    private void m40120a(TriggerReason.AnalysisReason analysisReason) {
        m40126d().analysisReason = analysisReason.name();
        m40124b();
    }

    public static void addAnalysisReason(TriggerReason.AnalysisReason analysisReason) {
        m40118a().m40120a(analysisReason);
    }

    /* renamed from: a */
    private void m40122a(List<LeakDetector> list) {
        KLog.m40102i(f55646a, "addClassInfoInternal");
        this.f55649d.classInfos = new ArrayList();
        for (LeakDetector next : list) {
            HeapReport.ClassInfo classInfo = new HeapReport.ClassInfo();
            classInfo.className = next.className();
            classInfo.instanceCount = Integer.valueOf(next.instanceCount().instancesCount);
            classInfo.leakInstanceCount = Integer.valueOf(next.instanceCount().leakInstancesCount);
            this.f55649d.classInfos.add(classInfo);
            KLog.m40102i(f55646a, "class:" + classInfo.className + " all instances:" + classInfo.instanceCount + ", leaked instances:" + classInfo.leakInstanceCount);
        }
        m40124b();
    }

    public static void addClassInfo(List<LeakDetector> list) {
        m40118a().m40122a(list);
    }

    /* renamed from: a */
    private <T extends Leak> void m40123a(List<T> list, Map<Long, String> map) {
        String str;
        List<T> list2 = list;
        if (list2 == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("add ");
        sb.append(list2.get(0) instanceof ApplicationLeak ? "ApplicationLeak " : "LibraryLeak ");
        sb.append(list.size());
        sb.append(" leaks");
        KLog.m40102i(f55646a, sb.toString());
        for (T t : list) {
            HeapReport.GCPath gCPath = new HeapReport.GCPath();
            this.f55649d.gcPaths.add(gCPath);
            gCPath.signature = t.getSignature();
            gCPath.instanceCount = Integer.valueOf(t.getLeakTraces().size());
            LeakTrace leakTrace = t.getLeakTraces().get(0);
            String description = leakTrace.getGcRootType().getDescription();
            gCPath.gcRoot = description;
            LeakTraceObject leakingObject = leakTrace.getLeakingObject();
            String className = leakingObject.getClassName();
            String typeName = leakingObject.getTypeName();
            KLog.m40102i(f55646a, "GC Root:" + description + ", leakObjClazz:" + className + ", leakObjType:" + typeName + ", leaking reason:" + leakingObject.getLeakingStatusReason() + ", leaking id:" + (leakingObject.getObjectId() & InternalZipConstants.ZIP_64_SIZE_LIMIT));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(map.get(Long.valueOf(leakingObject.getObjectId())));
            if (t instanceof ApplicationLeak) {
                str = "";
            } else {
                str = " " + leakingObject.getLeakingStatusReason();
            }
            sb2.append(str);
            gCPath.leakReason = sb2.toString();
            gCPath.path = new ArrayList();
            HeapReport.GCPath.PathItem pathItem = new HeapReport.GCPath.PathItem();
            pathItem.reference = className;
            pathItem.referenceType = typeName;
            for (LeakTraceReference next : leakTrace.getReferencePath()) {
                String referenceName = next.getReferenceName();
                String className2 = next.getOriginObject().getClassName();
                String referenceDisplayName = next.getReferenceDisplayName();
                String referenceGenericName = next.getReferenceGenericName();
                String referenceType = next.getReferenceType().toString();
                String declaredClassName = next.getDeclaredClassName();
                KLog.m40102i(f55646a, "clazz:" + className2 + ", referenceName:" + referenceName + ", referenceDisplayName:" + referenceDisplayName + ", referenceGenericName:" + referenceGenericName + ", referenceType:" + referenceType + ", declaredClassName:" + declaredClassName);
                HeapReport.GCPath.PathItem pathItem2 = new HeapReport.GCPath.PathItem();
                if (!referenceDisplayName.startsWith(Const.jaLeft)) {
                    className2 = className2 + "." + referenceDisplayName;
                }
                pathItem2.reference = className2;
                pathItem2.referenceType = referenceType;
                pathItem2.declaredClass = declaredClassName;
                gCPath.path.add(pathItem2);
            }
            gCPath.path.add(pathItem);
        }
    }

    /* renamed from: a */
    private void m40119a(Pair<List<ApplicationLeak>, List<LibraryLeak>> pair, Map<Long, String> map) {
        if (this.f55649d.gcPaths == null) {
            this.f55649d.gcPaths = new ArrayList();
        }
        m40123a((List) pair.first, map);
        m40123a((List) pair.second, map);
        m40124b();
    }

    public static void addGCPath(Pair<List<ApplicationLeak>, List<LibraryLeak>> pair, Map<Long, String> map) {
        m40118a().m40119a(pair, map);
    }

    /* renamed from: f */
    private void m40128f() {
        this.f55649d.analysisDone = true;
        m40124b();
    }

    public static void done() {
        m40118a().m40128f();
    }

    /* renamed from: g */
    private void m40129g() {
        KLog.m40102i(f55646a, "reAnalysisInternal");
        HeapReport heapReport = this.f55649d;
        int i = 1;
        if (heapReport.reAnalysisTimes != null) {
            i = 1 + this.f55649d.reAnalysisTimes.intValue();
        }
        heapReport.reAnalysisTimes = Integer.valueOf(i);
        m40124b();
    }

    public static void recordReanalysis() {
        m40118a().m40129g();
    }
}
