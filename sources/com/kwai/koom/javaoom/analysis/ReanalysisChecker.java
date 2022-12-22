package com.kwai.koom.javaoom.analysis;

import android.text.TextUtils;
import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.report.HeapReport;
import java.io.File;

public class ReanalysisChecker {

    /* renamed from: a */
    private static final String f55564a = "ReanalysisChecker";

    public KHeapFile detectReanalysisFile() {
        File[] listFiles = new File(KGlobalConfig.getReportDir()).listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file : listFiles) {
            HeapReport c = m40083c(file);
            if (m40082b(c)) {
                if (!m40080a(c)) {
                    KLog.m40102i(f55564a, "find reanalyze report");
                    return m40081b(file);
                }
                KLog.m40101e(f55564a, "Reanalyze " + file.getName() + " too many times");
                File a = m40078a(m40079a(file));
                if (a != null) {
                    a.delete();
                }
                file.delete();
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m40079a(File file) {
        String name = file.getName();
        return name.substring(0, name.length() - 5);
    }

    /* renamed from: a */
    private File m40078a(String str) {
        File[] listFiles = new File(KGlobalConfig.getHprofDir()).listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file : listFiles) {
            String name = file.getName();
            if (TextUtils.equals(str, name.substring(0, name.length() - 6))) {
                return file;
            }
        }
        return null;
    }

    /* renamed from: b */
    private KHeapFile m40081b(File file) {
        File a = m40078a(m40079a(file));
        if (a != null) {
            return KHeapFile.buildInstance(a, file);
        }
        KLog.m40101e(f55564a, "Reanalyze hprof file not found!");
        file.delete();
        return null;
    }

    /* renamed from: a */
    private boolean m40080a(HeapReport heapReport) {
        return heapReport.reAnalysisTimes != null && heapReport.reAnalysisTimes.intValue() >= KConstants.ReAnalysis.MAX_TIMES;
    }

    /* renamed from: b */
    private boolean m40082b(HeapReport heapReport) {
        return heapReport.analysisDone == null || !heapReport.analysisDone.booleanValue();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|14|17|18|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        r7 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0059 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.kwai.koom.javaoom.report.HeapReport m40083c(java.io.File r7) {
        /*
            r6 = this;
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0059 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0059 }
            int r1 = r2.available()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.read(r1)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            boolean r1 = com.kwai.koom.javaoom.common.KConstants.Debug.VERBOSE_LOG     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = "ReanalysisChecker"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r4.<init>()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            java.lang.String r5 = "loadFile "
            r4.append(r5)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            java.lang.String r5 = r7.getPath()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r4.append(r5)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            java.lang.String r5 = " str:"
            r4.append(r5)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r4.append(r3)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            com.kwai.koom.javaoom.common.KLog.m40102i(r1, r4)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
        L_0x003f:
            java.lang.Class<com.kwai.koom.javaoom.report.HeapReport> r1 = com.kwai.koom.javaoom.report.HeapReport.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r3, r1)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            com.kwai.koom.javaoom.report.HeapReport r0 = (com.kwai.koom.javaoom.report.HeapReport) r0     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            if (r0 != 0) goto L_0x004e
            com.kwai.koom.javaoom.report.HeapReport r0 = new com.kwai.koom.javaoom.report.HeapReport     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r0.<init>()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
        L_0x004e:
            com.kwai.koom.javaoom.common.KUtils.closeQuietly(r2)
            return r0
        L_0x0052:
            r7 = move-exception
            r1 = r2
            goto L_0x0065
        L_0x0055:
            r1 = r2
            goto L_0x0059
        L_0x0057:
            r7 = move-exception
            goto L_0x0065
        L_0x0059:
            r7.delete()     // Catch:{ all -> 0x0057 }
            com.kwai.koom.javaoom.common.KUtils.closeQuietly(r1)
            com.kwai.koom.javaoom.report.HeapReport r7 = new com.kwai.koom.javaoom.report.HeapReport
            r7.<init>()
            return r7
        L_0x0065:
            com.kwai.koom.javaoom.common.KUtils.closeQuietly(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.javaoom.analysis.ReanalysisChecker.m40083c(java.io.File):com.kwai.koom.javaoom.report.HeapReport");
    }
}
