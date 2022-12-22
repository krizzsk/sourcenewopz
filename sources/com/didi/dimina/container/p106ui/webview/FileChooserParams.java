package com.didi.dimina.container.p106ui.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.dimina.container.Dimina;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.didi.dimina.container.ui.webview.FileChooserParams */
public abstract class FileChooserParams {
    private static final int COMPRESS_QUALITY = 100;
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private final Context mContext = Dimina.getConfig().getApp();
    private final File mOutput;

    public abstract Intent createIntent();

    public abstract int getMode();

    public abstract CharSequence getTitle();

    public FileChooserParams() {
        String str = FORMAT.format(new Date()) + ".jpg";
        File externalCacheDir = this.mContext.getExternalCacheDir();
        File file = new File((externalCacheDir == null || !externalCacheDir.canWrite()) ? this.mContext.getCacheDir() : externalCacheDir, str);
        this.mOutput = file;
        file.getParentFile().mkdirs();
        if (this.mOutput.exists()) {
            this.mOutput.delete();
        }
        try {
            this.mOutput.createNewFile();
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public Uri getOutput() {
        File file = this.mOutput;
        if (file == null) {
            return null;
        }
        return Uri.fromFile(file);
    }

    public Uri[] getResult(int i, Intent intent) {
        File file = this.mOutput;
        if (file == null || !file.exists() || this.mOutput.length() <= 0) {
            return parseResult(i, intent);
        }
        return new Uri[]{Uri.fromFile(this.mOutput)};
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090 A[SYNTHETIC, Splitter:B:33:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0097 A[SYNTHETIC, Splitter:B:40:0x0097] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri[] parseResult(int r6, android.content.Intent r7) {
        /*
            r0 = 0
            r1 = -1
            if (r6 != r1) goto L_0x009a
            if (r7 != 0) goto L_0x0008
            goto L_0x009a
        L_0x0008:
            android.net.Uri r6 = r7.getData()
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0015
            android.net.Uri[] r7 = new android.net.Uri[r2]
            r7[r1] = r6
            return r7
        L_0x0015:
            android.content.ClipData r6 = r7.getClipData()
            if (r6 == 0) goto L_0x004b
            android.content.ClipData r6 = r7.getClipData()
            int r6 = r6.getItemCount()
            if (r6 <= 0) goto L_0x004b
            android.content.ClipData r6 = r7.getClipData()
            int r6 = r6.getItemCount()
            android.net.Uri[] r6 = new android.net.Uri[r6]
        L_0x002f:
            android.content.ClipData r0 = r7.getClipData()
            int r0 = r0.getItemCount()
            if (r1 >= r0) goto L_0x004a
            android.content.ClipData r0 = r7.getClipData()
            android.content.ClipData$Item r0 = r0.getItemAt(r1)
            android.net.Uri r0 = r0.getUri()
            r6[r1] = r0
            int r1 = r1 + 1
            goto L_0x002f
        L_0x004a:
            return r6
        L_0x004b:
            java.lang.String r6 = "data"
            boolean r3 = r7.hasExtra(r6)
            if (r3 == 0) goto L_0x009a
            android.os.Bundle r7 = r7.getExtras()
            java.lang.Object r6 = r7.get(r6)
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            if (r6 == 0) goto L_0x009a
            java.text.SimpleDateFormat r7 = FORMAT     // Catch:{ IOException -> 0x0094, all -> 0x008d }
            java.util.Date r3 = new java.util.Date     // Catch:{ IOException -> 0x0094, all -> 0x008d }
            r3.<init>()     // Catch:{ IOException -> 0x0094, all -> 0x008d }
            java.lang.String r7 = r7.format(r3)     // Catch:{ IOException -> 0x0094, all -> 0x008d }
            java.lang.String r3 = ".jpg"
            java.io.File r7 = java.io.File.createTempFile(r7, r3)     // Catch:{ IOException -> 0x0094, all -> 0x008d }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0094, all -> 0x008d }
            r3.<init>(r7)     // Catch:{ IOException -> 0x0094, all -> 0x008d }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            r5 = 100
            r6.compress(r4, r5, r3)     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            android.net.Uri[] r6 = new android.net.Uri[r2]     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            android.net.Uri r7 = android.net.Uri.fromFile(r7)     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            r6[r1] = r7     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            r3.close()     // Catch:{ IOException -> 0x0087 }
        L_0x0087:
            return r6
        L_0x0088:
            r6 = move-exception
            r0 = r3
            goto L_0x008e
        L_0x008b:
            goto L_0x0095
        L_0x008d:
            r6 = move-exception
        L_0x008e:
            if (r0 == 0) goto L_0x0093
            r0.close()     // Catch:{ IOException -> 0x0093 }
        L_0x0093:
            throw r6
        L_0x0094:
            r3 = r0
        L_0x0095:
            if (r3 == 0) goto L_0x009a
            r3.close()     // Catch:{ IOException -> 0x009a }
        L_0x009a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.webview.FileChooserParams.parseResult(int, android.content.Intent):android.net.Uri[]");
    }
}
