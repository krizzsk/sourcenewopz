package com.kwai.koom.javaoom.analysis;

import android.util.Pair;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.report.HeapAnalyzeReporter;
import java.util.List;
import kshark.ApplicationLeak;
import kshark.LibraryLeak;

/* renamed from: com.kwai.koom.javaoom.analysis.a */
/* compiled from: KHeapAnalyzer */
class C20312a {

    /* renamed from: a */
    private static final String f55571a = "HeapAnalyzer";

    /* renamed from: b */
    private C20313b f55572b;

    public C20312a(KHeapFile kHeapFile) {
        this.f55572b = new C20313b(kHeapFile.hprof);
    }

    /* renamed from: a */
    public boolean mo164755a() {
        KLog.m40102i(f55571a, "analyze");
        Pair<List<ApplicationLeak>, List<LibraryLeak>> a = this.f55572b.mo164756a();
        if (a == null) {
            return false;
        }
        HeapAnalyzeReporter.addGCPath(a, this.f55572b.f55575a);
        HeapAnalyzeReporter.done();
        return true;
    }
}
