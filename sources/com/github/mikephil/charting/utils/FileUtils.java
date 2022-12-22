package com.github.mikephil.charting.utils;

import com.didi.sdk.apm.SystemUtils;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import rui.config.RConfigConstants;

public class FileUtils {

    /* renamed from: a */
    private static final String f52493a = "MPChart-FileUtils";

    public static List<Entry> loadEntriesFromFile(String str) {
        File file = new File(SystemUtils.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split(RConfigConstants.KEYWORD_COLOR_SIGN);
                if (split.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(split[0]), (float) Integer.parseInt(split[1])));
                } else {
                    int length = split.length - 1;
                    float[] fArr = new float[length];
                    for (int i = 0; i < length; i++) {
                        fArr[i] = Float.parseFloat(split[i]);
                    }
                    arrayList.add(new BarEntry((float) Integer.parseInt(split[split.length - 1]), fArr));
                }
            }
        } catch (IOException e) {
            SystemUtils.log(6, f52493a, e.toString(), (Throwable) null, "com.github.mikephil.charting.utils.FileUtils", 68);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082 A[SYNTHETIC, Splitter:B:26:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099 A[SYNTHETIC, Splitter:B:32:0x0099] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.Entry> loadEntriesFromAssets(android.content.res.AssetManager r8, java.lang.String r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0070 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0070 }
            java.io.InputStream r8 = r8.open(r9)     // Catch:{ IOException -> 0x0070 }
            java.lang.String r9 = "UTF-8"
            r3.<init>(r8, r9)     // Catch:{ IOException -> 0x0070 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0070 }
            java.lang.String r8 = r2.readLine()     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
        L_0x001a:
            if (r8 == 0) goto L_0x0064
            java.lang.String r9 = "#"
            java.lang.String[] r8 = r8.split(r9)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            int r9 = r8.length     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r1 = 2
            r3 = 0
            r4 = 1
            if (r9 > r1) goto L_0x003d
            com.github.mikephil.charting.data.Entry r9 = new com.github.mikephil.charting.data.Entry     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r1 = r8[r4]     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r8 = r8[r3]     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            float r8 = java.lang.Float.parseFloat(r8)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r9.<init>(r1, r8)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r0.add(r9)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            goto L_0x005f
        L_0x003d:
            int r9 = r8.length     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            int r9 = r9 - r4
            float[] r1 = new float[r9]     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
        L_0x0041:
            if (r3 >= r9) goto L_0x004e
            r5 = r8[r3]     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r1[r3] = r5     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            int r3 = r3 + 1
            goto L_0x0041
        L_0x004e:
            com.github.mikephil.charting.data.BarEntry r9 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            int r3 = r8.length     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            int r3 = r3 - r4
            r8 = r8[r3]     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            float r8 = (float) r8     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r9.<init>((float) r8, (float[]) r1)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r0.add(r9)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
        L_0x005f:
            java.lang.String r8 = r2.readLine()     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            goto L_0x001a
        L_0x0064:
            r2.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x0096
        L_0x0068:
            r8 = move-exception
            r1 = r2
            goto L_0x0097
        L_0x006b:
            r8 = move-exception
            r1 = r2
            goto L_0x0071
        L_0x006e:
            r8 = move-exception
            goto L_0x0097
        L_0x0070:
            r8 = move-exception
        L_0x0071:
            java.lang.String r3 = "MPChart-FileUtils"
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x006e }
            r2 = 6
            r5 = 0
            java.lang.String r6 = "com.github.mikephil.charting.utils.FileUtils"
            r7 = 139(0x8b, float:1.95E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0096
            r1.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x0096
        L_0x0086:
            r8 = move-exception
            java.lang.String r3 = r8.toString()
            r1 = 6
            r4 = 0
            r6 = 147(0x93, float:2.06E-43)
            java.lang.String r2 = "MPChart-FileUtils"
            java.lang.String r5 = "com.github.mikephil.charting.utils.FileUtils"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
        L_0x0096:
            return r0
        L_0x0097:
            if (r1 == 0) goto L_0x00ad
            r1.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00ad
        L_0x009d:
            r9 = move-exception
            java.lang.String r2 = r9.toString()
            r0 = 6
            r3 = 0
            r5 = 147(0x93, float:2.06E-43)
            java.lang.String r1 = "MPChart-FileUtils"
            java.lang.String r4 = "com.github.mikephil.charting.utils.FileUtils"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x00ad:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.loadEntriesFromAssets(android.content.res.AssetManager, java.lang.String):java.util.List");
    }

    public static void saveToSdCard(List<Entry> list, String str) {
        File file = new File(SystemUtils.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                SystemUtils.log(6, f52493a, e.toString(), (Throwable) null, "com.github.mikephil.charting.utils.FileUtils", 209);
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry next : list) {
                bufferedWriter.append(next.getY() + RConfigConstants.KEYWORD_COLOR_SIGN + next.getX());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e2) {
            SystemUtils.log(6, f52493a, e2.toString(), (Throwable) null, "com.github.mikephil.charting.utils.FileUtils", 226);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b A[SYNTHETIC, Splitter:B:19:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072 A[SYNTHETIC, Splitter:B:25:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.BarEntry> loadBarEntriesFromAssets(android.content.res.AssetManager r8, java.lang.String r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0049 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0049 }
            java.io.InputStream r8 = r8.open(r9)     // Catch:{ IOException -> 0x0049 }
            java.lang.String r9 = "UTF-8"
            r3.<init>(r8, r9)     // Catch:{ IOException -> 0x0049 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0049 }
            java.lang.String r8 = r2.readLine()     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
        L_0x001a:
            if (r8 == 0) goto L_0x003d
            java.lang.String r9 = "#"
            java.lang.String[] r8 = r8.split(r9)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            com.github.mikephil.charting.data.BarEntry r9 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r1 = 1
            r1 = r8[r1]     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r3 = 0
            r8 = r8[r3]     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            float r8 = java.lang.Float.parseFloat(r8)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r9.<init>((float) r1, (float) r8)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r0.add(r9)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            java.lang.String r8 = r2.readLine()     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            goto L_0x001a
        L_0x003d:
            r2.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x006f
        L_0x0041:
            r8 = move-exception
            r1 = r2
            goto L_0x0070
        L_0x0044:
            r8 = move-exception
            r1 = r2
            goto L_0x004a
        L_0x0047:
            r8 = move-exception
            goto L_0x0070
        L_0x0049:
            r8 = move-exception
        L_0x004a:
            java.lang.String r3 = "MPChart-FileUtils"
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x0047 }
            r2 = 6
            r5 = 0
            java.lang.String r6 = "com.github.mikephil.charting.utils.FileUtils"
            r7 = 250(0xfa, float:3.5E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x006f
        L_0x005f:
            r8 = move-exception
            java.lang.String r3 = r8.toString()
            r1 = 6
            r4 = 0
            r6 = 258(0x102, float:3.62E-43)
            java.lang.String r2 = "MPChart-FileUtils"
            java.lang.String r5 = "com.github.mikephil.charting.utils.FileUtils"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
        L_0x006f:
            return r0
        L_0x0070:
            if (r1 == 0) goto L_0x0086
            r1.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x0086
        L_0x0076:
            r9 = move-exception
            java.lang.String r2 = r9.toString()
            r0 = 6
            r3 = 0
            r5 = 258(0x102, float:3.62E-43)
            java.lang.String r1 = "MPChart-FileUtils"
            java.lang.String r4 = "com.github.mikephil.charting.utils.FileUtils"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x0086:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.loadBarEntriesFromAssets(android.content.res.AssetManager, java.lang.String):java.util.List");
    }
}
