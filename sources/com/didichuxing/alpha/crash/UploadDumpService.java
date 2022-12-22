package com.didichuxing.alpha.crash;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didichuxing.alpha.crash.dump.AnalysisResult;
import com.didichuxing.alpha.crash.dump.AndroidExcludedRefs;
import com.didichuxing.alpha.crash.dump.AndroidReachabilityInspectors;
import com.didichuxing.alpha.crash.dump.Exclusion;
import com.didichuxing.alpha.crash.dump.HeapAnalyzer;
import com.didichuxing.alpha.crash.dump.LeakTrace;
import com.didichuxing.alpha.crash.dump.LeakTraceElement;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class UploadDumpService extends IntentService {
    private static final String DIVIDE_FILE_SIZE = "divide_file_size";
    private static final String INVALID_PERIOD = "invalid_period";
    private static final String SWITCH_UPLOAD_HPROF = "upload_hprof";
    private static final String TRACK_ERROR_NAME = "analysis hprof failed";
    private static final String UPLOAD_URL = "https://apm.didiglobal.com/sdk/upload_oom";
    private long divideSize;
    private ThreadPoolExecutor executor;
    private long invalidPeriod;
    private boolean uploadHprof;

    public static void startUploadService(Context context, long j, long j2, boolean z) {
        if (context != null) {
            Intent intent = new Intent(context, UploadDumpService.class);
            intent.putExtra(INVALID_PERIOD, j);
            intent.putExtra(DIVIDE_FILE_SIZE, j2);
            intent.putExtra(SWITCH_UPLOAD_HPROF, z);
            context.startService(intent);
        }
    }

    public UploadDumpService() {
        super("upload_dump");
    }

    public void onCreate() {
        super.onCreate();
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        this.invalidPeriod = intent.getLongExtra(INVALID_PERIOD, OmegaConfig.VALIDITY_PERIOD_DUMP_FILE);
        this.divideSize = intent.getLongExtra(DIVIDE_FILE_SIZE, OmegaConfig.SIZE_DIVIDE_DUMP_FILE);
        this.uploadHprof = intent.getBooleanExtra(SWITCH_UPLOAD_HPROF, OmegaConfig.SWITCH_UPLOAD_HPROF);
        this.executor = new ThreadPoolExecutor(3, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
        analysisDumpFile();
        uploadHprofFile();
    }

    private void analysisDumpFile() {
        File dumpFileDirectory = DumpHelper.getDumpFileDirectory(this);
        if (dumpFileDirectory.exists() && dumpFileDirectory.isDirectory()) {
            uploadLastResults(dumpFileDirectory);
            String[] list = dumpFileDirectory.list(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.endsWith(".hprof");
                }
            });
            if (list != null && list.length >= 1) {
                HeapAnalyzer heapAnalyzer = new HeapAnalyzer(AndroidExcludedRefs.createAppDefaults().build(), AndroidReachabilityInspectors.defaultAndroidInspectors());
                long currentTimeMillis = System.currentTimeMillis();
                JSONArray jSONArray = new JSONArray();
                String str = "";
                for (String file : list) {
                    File file2 = new File(dumpFileDirectory.getAbsolutePath(), file);
                    if (file2.lastModified() - currentTimeMillis > this.invalidPeriod) {
                        doubleDelete(file2);
                    } else {
                        JSONObject startAnalysis = startAnalysis(heapAnalyzer, file2);
                        if (startAnalysis != null) {
                            str = startAnalysis.optString("msg_id");
                            jSONArray.put(startAnalysis);
                        }
                        if (!TextUtils.isEmpty(str) && jSONArray.length() > 0 && saveResultToFileAndUpload(str, jSONArray.toString())) {
                            doubleDelete(file2);
                        }
                    }
                }
            }
        }
    }

    private boolean saveResultToFileAndUpload(String str, String str2) {
        File dumpFileDirectory = DumpHelper.getDumpFileDirectory(this);
        File file = new File(dumpFileDirectory, str + ".result");
        writeFile(file, str2);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        try {
            if (!postResultFile(file)) {
                return false;
            }
            doubleDelete(file);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Tracker.trackError(TRACK_ERROR_NAME, e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021 A[Catch:{ IOException -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFile(java.io.File r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "rw"
            r1.<init>(r5, r2)     // Catch:{ all -> 0x001e }
            long r2 = r1.length()     // Catch:{ all -> 0x001c }
            r1.seek(r2)     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "UTF-8"
            byte[] r5 = r6.getBytes(r5)     // Catch:{ all -> 0x001c }
            r1.write(r5)     // Catch:{ all -> 0x001c }
            r1.close()     // Catch:{ IOException -> 0x0024 }
            goto L_0x0024
        L_0x001c:
            r0 = r1
            goto L_0x001f
        L_0x001e:
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r0.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.alpha.crash.UploadDumpService.writeFile(java.io.File, java.lang.String):void");
    }

    private void uploadLastResults(File file) {
        String[] list = file.list(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(".result");
            }
        });
        if (list != null && list.length >= 1) {
            for (String file2 : list) {
                File file3 = new File(file.getAbsolutePath(), file2);
                try {
                    if (postResultFile(file3)) {
                        doubleDelete(file3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Tracker.trackError(TRACK_ERROR_NAME, e);
                }
            }
        }
    }

    private void uploadHprofFile() {
        uploadLastZipFiles();
        File dumpFileDirectory = DumpHelper.getDumpFileDirectory(this);
        String[] list = dumpFileDirectory.list(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(".hprof");
            }
        });
        if (list != null && list.length >= 1) {
            long currentTimeMillis = System.currentTimeMillis();
            for (String file : list) {
                File file2 = new File(dumpFileDirectory.getAbsolutePath(), file);
                if (!this.uploadHprof || file2.lastModified() - currentTimeMillis > this.invalidPeriod) {
                    doubleDelete(file2);
                } else {
                    try {
                        File file3 = new File(DumpHelper.getDumpFileDirectory(this), file2.getName().split(".hprof")[0] + PmFileConstant.ZIP_SUFFIX);
                        DumpHelper.zipFile(file2, file3);
                        doubleDelete(file2);
                        String[] divideBigFile = DumpHelper.divideBigFile(file3, this.divideSize);
                        doubleDelete(file3);
                        if (divideBigFile != null && divideBigFile.length > 0) {
                            for (String file4 : divideBigFile) {
                                commitUploadTask(new File(file4));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Tracker.trackError(TRACK_ERROR_NAME, e);
                    }
                }
            }
        }
    }

    private void uploadLastZipFiles() {
        File dumpFileDirectory = DumpHelper.getDumpFileDirectory(this);
        String[] list = dumpFileDirectory.list(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(".temp");
            }
        });
        if (list != null && list.length >= 1) {
            long currentTimeMillis = System.currentTimeMillis();
            for (String file : list) {
                File file2 = new File(dumpFileDirectory.getAbsolutePath(), file);
                if (!this.uploadHprof || file2.lastModified() - currentTimeMillis > this.invalidPeriod) {
                    doubleDelete(file2);
                } else {
                    commitUploadTask(file2);
                }
            }
        }
    }

    private boolean postResultFile(File file) throws Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        String str = file.getName().split(".result")[0];
        MultipartUtility multipartUtility = new MultipartUtility(UPLOAD_URL);
        multipartUtility.addFormField("ot", "android");
        multipartUtility.addFormField("an", getPackageName());
        multipartUtility.addFormField("msgid", str);
        multipartUtility.addFormField("ft", "result");
        multipartUtility.addFilePart(SDKConsts.TAG_KEY_FILENAME, file);
        if (new JSONObject(multipartUtility.finish()).optInt(C12407a.f36608f) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean postZipFile(File file) throws Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        String[] split = file.getName().split("--");
        String str = split[0];
        String str2 = split[1].split(".temp")[0];
        MultipartUtility multipartUtility = new MultipartUtility(UPLOAD_URL);
        multipartUtility.addFormField("ot", "android");
        multipartUtility.addFormField("an", getPackageName());
        multipartUtility.addFormField("msgid", str);
        multipartUtility.addFormField("ft", "hprof");
        multipartUtility.addFormField("part", str2);
        multipartUtility.addFilePart(SDKConsts.TAG_KEY_FILENAME, file);
        if (new JSONObject(multipartUtility.finish()).optInt(C12407a.f36608f) == 0) {
            return true;
        }
        return false;
    }

    private JSONObject startAnalysis(HeapAnalyzer heapAnalyzer, File file) {
        String str = file.getName().split(".hprof")[0];
        List<AnalysisResult> checkForLeak = heapAnalyzer.checkForLeak(file, true);
        if (checkForLeak == null || checkForLeak.isEmpty()) {
            Tracker.trackError(TRACK_ERROR_NAME, str, new Exception(" no leak found."));
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        int size = checkForLeak.size();
        for (int i = 0; i < size; i++) {
            AnalysisResult analysisResult = checkForLeak.get(i);
            String str2 = analysisResult.className;
            long j = analysisResult.retainedHeapSize;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONObject.put("msg_id", str);
                    jSONObject.put("leak_class", str2);
                    jSONObject.put("leak_size", j);
                    LeakTrace leakTrace = analysisResult.leakTrace;
                    if (leakTrace != null) {
                        List<LeakTraceElement> list = leakTrace.elements;
                        JSONArray jSONArray = new JSONArray();
                        JSONArray jSONArray2 = new JSONArray();
                        int size2 = list.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            LeakTraceElement leakTraceElement = list.get(i2);
                            jSONArray.put(formatTitle(leakTraceElement));
                            jSONArray2.put(formatDetails(leakTraceElement));
                        }
                        jSONObject.put("leak_path", jSONArray);
                        jSONObject.put("leak_detail", jSONArray2);
                    }
                } catch (Exception e) {
                    Tracker.trackError(TRACK_ERROR_NAME, str, e);
                }
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public boolean doubleDelete(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return true;
        }
        return file.delete();
    }

    private String formatDetails(LeakTraceElement leakTraceElement) {
        String str = "";
        if (leakTraceElement == null) {
            return str;
        }
        if (leakTraceElement.extra != null) {
            str = str + leakTraceElement.extra;
        }
        Exclusion exclusion = leakTraceElement.exclusion;
        if (exclusion != null) {
            String str2 = str + "Excluded by rule";
            if (exclusion.name != null) {
                str2 = str2 + exclusion.name;
            }
            str = str2 + " matching " + exclusion.matching;
            if (exclusion.reason != null) {
                str = str + " because " + exclusion.reason;
            }
        }
        return str + leakTraceElement.toDetailedString();
    }

    private String formatTitle(LeakTraceElement leakTraceElement) {
        String str;
        if (leakTraceElement == null) {
            return "";
        }
        String simpleClassName = leakTraceElement.getSimpleClassName();
        if (leakTraceElement.reference != null) {
            str = "" + (simpleClassName + "." + leakTraceElement.reference.getDisplayName());
        } else {
            str = "" + simpleClassName;
        }
        if (leakTraceElement.exclusion == null) {
            return str;
        }
        return str + " (excluded)";
    }

    private void commitUploadTask(final File file) {
        this.executor.execute(new Runnable() {
            public void run() {
                try {
                    if (UploadDumpService.this.postZipFile(file)) {
                        boolean unused = UploadDumpService.this.doubleDelete(file);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Tracker.trackError(UploadDumpService.TRACK_ERROR_NAME, e);
                }
            }
        });
    }
}
