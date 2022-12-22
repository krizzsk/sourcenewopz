package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = new FileService();
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver2) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver2);
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver2) {
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver2;
        this.parsers = list;
    }

    /* access modifiers changed from: package-private */
    public int getOrientation(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.contentResolver.openInputStream(uri);
            int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, openInputStream, this.byteArrayPool);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return orientation;
        } catch (IOException | NullPointerException e) {
            Throwable th = e;
            if (Log.isLoggable(TAG, 3)) {
                SystemUtils.log(3, TAG, "Failed to open uri: " + uri, th, "com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener", 58);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th2;
        }
    }

    public InputStream open(Uri uri) throws FileNotFoundException {
        String path = getPath(uri);
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        File file = this.service.get(path);
        if (!isValid(file)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(file);
        try {
            return this.contentResolver.openInputStream(fromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030 A[Catch:{ all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getPath(android.net.Uri r9) {
        /*
            r8 = this;
            r0 = 0
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r1 = r8.query     // Catch:{ SecurityException -> 0x0024, all -> 0x0022 }
            android.database.Cursor r1 = r1.query(r9)     // Catch:{ SecurityException -> 0x0024, all -> 0x0022 }
            if (r1 == 0) goto L_0x001c
            boolean r2 = r1.moveToFirst()     // Catch:{ SecurityException -> 0x001a }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r9 = r1.getString(r2)     // Catch:{ SecurityException -> 0x001a }
            if (r1 == 0) goto L_0x0019
            r1.close()
        L_0x0019:
            return r9
        L_0x001a:
            r2 = move-exception
            goto L_0x0026
        L_0x001c:
            if (r1 == 0) goto L_0x0021
            r1.close()
        L_0x0021:
            return r0
        L_0x0022:
            r9 = move-exception
            goto L_0x0053
        L_0x0024:
            r2 = move-exception
            r1 = r0
        L_0x0026:
            r5 = r2
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x004b
            java.lang.String r3 = "ThumbStreamOpener"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r2.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = "Failed to query for thumbnail for Uri: "
            r2.append(r4)     // Catch:{ all -> 0x0051 }
            r2.append(r9)     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0051 }
            r2 = 3
            java.lang.String r6 = "com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener"
            r7 = 107(0x6b, float:1.5E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0051 }
        L_0x004b:
            if (r1 == 0) goto L_0x0050
            r1.close()
        L_0x0050:
            return r0
        L_0x0051:
            r9 = move-exception
            r0 = r1
        L_0x0053:
            if (r0 == 0) goto L_0x0058
            r0.close()
        L_0x0058:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.getPath(android.net.Uri):java.lang.String");
    }

    private boolean isValid(File file) {
        return this.service.exists(file) && 0 < this.service.length(file);
    }
}
