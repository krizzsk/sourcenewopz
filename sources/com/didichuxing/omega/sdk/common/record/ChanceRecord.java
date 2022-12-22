package com.didichuxing.omega.sdk.common.record;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.LogcatCollector;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChanceRecord extends Record {
    public void addScreenshots(List<Bitmap> list) {
        for (Bitmap addScreenshot : list) {
            addScreenshot(addScreenshot);
        }
    }

    public void takeLogcat() {
        putLogcat(LogcatCollector.getLogcat().getBytes());
    }

    public void takeStorageInfo() {
        Security.takeStorageInfo(this);
    }

    public void addFile(String str) {
        synchronized (this.extraFiles) {
            this.extraFiles.add(str);
        }
    }

    public void addFile(File file) {
        synchronized (this.extraFiles) {
            this.extraFiles.add(file.getAbsolutePath());
        }
    }

    public void setScreenshots(List<Bitmap> list) {
        put("screenshots", new LinkedList());
        if (list != null && list.size() != 0) {
            addScreenshots(list);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c A[SYNTHETIC, Splitter:B:21:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addScreenshot(android.graphics.Bitmap r4) {
        /*
            r3 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0025 }
            r1.<init>()     // Catch:{ all -> 0x0025 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0024 }
            int r2 = com.didichuxing.omega.sdk.common.OmegaConfig.PIC_COMPRESS_QUALITY     // Catch:{ all -> 0x0024 }
            boolean r4 = r4.compress(r0, r2, r1)     // Catch:{ all -> 0x0024 }
            if (r4 != 0) goto L_0x0019
            java.lang.String r4 = "addScreenshot(): Bitmap compress fail!"
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r4)     // Catch:{ all -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            return
        L_0x0019:
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x0024 }
            r3.addScreenshot((byte[]) r4)     // Catch:{ all -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x002f
        L_0x0024:
            r0 = r1
        L_0x0025:
            java.lang.String r4 = "addScreenshot.compress fail!"
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r4)     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return
        L_0x0030:
            r4 = move-exception
            if (r0 == 0) goto L_0x0036
            r0.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.record.ChanceRecord.addScreenshot(android.graphics.Bitmap):void");
    }

    public void imageDeepCompress() {
        try {
            List<byte[]> list = (List) get("screenshots");
            if (list == null) {
                return;
            }
            if (list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (byte[] bArr : list) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (decodeByteArray != null) {
                        Matrix matrix = new Matrix();
                        matrix.postScale(OmegaConfig.CRASH_SCREENSHOT_SCALE, OmegaConfig.CRASH_SCREENSHOT_SCALE);
                        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        if (!createBitmap.compress(Bitmap.CompressFormat.JPEG, OmegaConfig.PIC_COMPRESS_QUALITY, byteArrayOutputStream)) {
                            OLog.m34769w("addScreenshot(): Bitmap compress fail! when deep compressed");
                            return;
                        }
                        arrayList.add(byteArrayOutputStream.toByteArray());
                    }
                }
                put("screenshots", arrayList);
            }
        } catch (Throwable th) {
            OLog.m34770w("imageDeepCompress fail!", th);
        }
    }

    public void addScreenshot(byte[] bArr) {
        List list = (List) get("screenshots");
        if (list == null) {
            list = new LinkedList();
            put("screenshots", list);
        }
        list.add(bArr);
    }

    public List<byte[]> getScreenshots() {
        List<byte[]> list = (List) get("screenshots");
        if (list != null) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        put("screenshots", linkedList);
        return linkedList;
    }

    public void putLogcat(byte[] bArr) {
        put("logcat", bArr);
    }

    public byte[] getLogcat() {
        return (byte[]) get("logcat");
    }

    public String toJson() {
        Object remove = this.datamap.remove("screenshots");
        Object remove2 = this.datamap.remove("logcat");
        String map2Json = JsonUtil.map2Json(this.datamap);
        if (remove != null) {
            this.datamap.put("screenshots", remove);
        }
        if (remove2 != null) {
            this.datamap.put("logcat", remove2);
        }
        return map2Json;
    }
}
