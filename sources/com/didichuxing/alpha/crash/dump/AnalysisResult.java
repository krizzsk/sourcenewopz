package com.didichuxing.alpha.crash.dump;

import java.io.Serializable;

public final class AnalysisResult implements Serializable {
    public static final long RETAINED_HEAP_SKIPPED = -1;
    public final long analysisDurationMs;
    public final String className;
    public final boolean excludedLeak;
    public final Throwable failure;
    public final boolean leakFound;
    public final LeakTrace leakTrace;
    public final long retainedHeapSize;

    public static AnalysisResult noLeak(long j) {
        return new AnalysisResult(false, false, (String) null, (LeakTrace) null, (Throwable) null, 0, j);
    }

    public static AnalysisResult leakDetected(boolean z, String str, LeakTrace leakTrace2, long j, long j2) {
        return new AnalysisResult(true, z, str, leakTrace2, (Throwable) null, j, j2);
    }

    public static AnalysisResult failure(Throwable th, long j) {
        return new AnalysisResult(false, false, (String) null, (LeakTrace) null, th, 0, j);
    }

    public RuntimeException leakTraceAsFakeException() {
        if (this.leakFound) {
            int i = 0;
            LeakTraceElement leakTraceElement = this.leakTrace.elements.get(0);
            String classSimpleName = classSimpleName(leakTraceElement.className);
            String classSimpleName2 = classSimpleName(this.className);
            RuntimeException runtimeException = new RuntimeException(classSimpleName2 + " leak from " + classSimpleName + " (holder=" + leakTraceElement.holder + ", type=" + leakTraceElement.type + ")");
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[this.leakTrace.elements.size()];
            for (LeakTraceElement next : this.leakTrace.elements) {
                String str = next.referenceName != null ? next.referenceName : "leaking";
                stackTraceElementArr[i] = new StackTraceElement(next.className, str, classSimpleName(next.className) + ".java", 42);
                i++;
            }
            runtimeException.setStackTrace(stackTraceElementArr);
            return runtimeException;
        }
        throw new UnsupportedOperationException("leakTraceAsFakeException() can only be called when leakFound is true");
    }

    private AnalysisResult(boolean z, boolean z2, String str, LeakTrace leakTrace2, Throwable th, long j, long j2) {
        this.leakFound = z;
        this.excludedLeak = z2;
        this.className = str;
        this.leakTrace = leakTrace2;
        this.failure = th;
        this.retainedHeapSize = j;
        this.analysisDurationMs = j2;
    }

    private String classSimpleName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }
}
