package com.didichuxing.mas.sdk.quality.report.analysis;

import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didichuxing.mas.sdk.quality.report.record.EventsRecord;
import com.didichuxing.mas.sdk.quality.report.record.RecordFactory;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventStorageFixed {
    private static boolean hasChecked = false;

    public static void uploadLastEvent() {
        String str;
        String str2;
        String str3;
        if (!hasChecked) {
            hasChecked = true;
            try {
                File lastCacheFile = getLastCacheFile();
                if (lastCacheFile != null) {
                    String[] split = lastCacheFile.getName().split("_");
                    if (split.length == 5) {
                        str3 = split[split.length - 3];
                        str = split[split.length - 4];
                        str2 = split[split.length - 2];
                    } else if (split.length == 4) {
                        String str4 = split[split.length - 2];
                        String str5 = split[split.length - 3];
                        str2 = split[split.length - 1];
                        str3 = str4;
                        str = str5;
                    } else if (split.length == 3) {
                        str3 = split[split.length - 1];
                        str = split[split.length - 2];
                        str2 = "";
                    } else {
                        str3 = "";
                        str2 = str3;
                        str = str2;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = PackageCollector.getVN();
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = PackageCollector.getVC() + "";
                    }
                    if (TextUtils.isEmpty(str2) || "null".equals(str2)) {
                        str2 = MASConfig.APP_ISSUE;
                    }
                    EventsRecord createLastEventsRecord = RecordFactory.createLastEventsRecord(str3, str, str2);
                    List<Event> allEvents = getAllEvents(lastCacheFile);
                    if (allEvents != null) {
                        if (!allEvents.isEmpty()) {
                            createLastEventsRecord.addAllEvents(allEvents);
                            RecordStorage.save(createLastEventsRecord);
                            lastCacheFile.delete();
                            return;
                        }
                    }
                    lastCacheFile.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|13|14|15|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0040, code lost:
        if (r3 == null) goto L_0x0043;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003b A[SYNTHETIC, Splitter:B:30:0x003b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.didichuxing.mas.sdk.quality.report.record.Event> getAllEvents(java.io.File r3) {
        /*
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            if (r3 == 0) goto L_0x0052
            boolean r1 = r3.exists()
            if (r1 != 0) goto L_0x000e
            goto L_0x0052
        L_0x000e:
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0033 }
            r2.<init>(r3)     // Catch:{ all -> 0x0033 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0030 }
            r3.<init>(r2)     // Catch:{ all -> 0x0030 }
        L_0x0019:
            java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x0031 }
            if (r1 != 0) goto L_0x0026
            r2.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            r3.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0043
        L_0x0026:
            com.didichuxing.mas.sdk.quality.report.record.Event r1 = com.didichuxing.mas.sdk.quality.report.record.Event.fromJson(r1)     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0019
            r0.add(r1)     // Catch:{ all -> 0x0031 }
            goto L_0x0019
        L_0x0030:
            r3 = r1
        L_0x0031:
            r1 = r2
            goto L_0x0034
        L_0x0033:
            r3 = r1
        L_0x0034:
            java.lang.String r2 = "pollAll fail"
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34424w(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0040
        L_0x003f:
        L_0x0040:
            if (r3 == 0) goto L_0x0043
            goto L_0x0022
        L_0x0043:
            return r0
        L_0x0044:
            r0 = move-exception
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004c
        L_0x004b:
        L_0x004c:
            if (r3 == 0) goto L_0x0051
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0051:
            throw r0
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.analysis.EventStorageFixed.getAllEvents(java.io.File):java.util.List");
    }

    private static File getLastCacheFile() {
        File recordDir = RecordStorage.getRecordDir();
        if (!recordDir.exists()) {
            return null;
        }
        try {
            File[] listFiles = recordDir.listFiles();
            if (listFiles != null) {
                if (listFiles.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (File file : listFiles) {
                        String name = file.getName();
                        String vn = PackageCollector.getVN();
                        String[] split = name.split("_");
                        if (name.startsWith("e.cache") && !split[2].equals(vn)) {
                            arrayList.add(file);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    if (arrayList.size() == 1) {
                        return (File) arrayList.get(0);
                    }
                    Collections.sort(arrayList, new Comparator<File>() {
                        public int compare(File file, File file2) {
                            return file.lastModified() - file2.lastModified() > 0 ? -1 : 0;
                        }
                    });
                    for (int size = arrayList.size(); 1 < size; size--) {
                        ((File) arrayList.get(1)).delete();
                    }
                    return (File) arrayList.get(0);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
