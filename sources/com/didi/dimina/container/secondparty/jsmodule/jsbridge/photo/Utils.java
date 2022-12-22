package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.graphics.BitmapCompat;
import com.didi.dimina.webview.util.MD5;
import com.didi.map.constant.FileNameConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Utils {

    /* renamed from: a */
    private static final Handler f17263a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static final Object f17264b = new Object();

    /* renamed from: a */
    static String m12819a(Context context, Uri uri) {
        if (uri == null) {
            return "";
        }
        String[] strArr = {"_data"};
        Cursor query = context.getContentResolver().query(uri, strArr, (String) null, (String[]) null, (String) null);
        if (query != null) {
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex(strArr[0]));
            query.close();
            if (string == null) {
                return "";
            }
            return string;
        } else if (uri.getPath() == null) {
            return "";
        } else {
            return uri.getPath();
        }
    }

    public static String getFilePathFromURIForAPI24(Context context, Uri uri) {
        File filesDir = context.getFilesDir();
        String fileName = getFileName(uri);
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        File file = new File(filesDir + File.separator + fileName);
        copyFile(context, uri, file);
        return file.getAbsolutePath();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r3 = r3.getPath();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileName(android.net.Uri r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r3 = r3.getPath()
            r1 = 47
            int r1 = r3.lastIndexOf(r1)
            r2 = -1
            if (r1 == r2) goto L_0x0017
            int r1 = r1 + 1
            java.lang.String r0 = r3.substring(r1)
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.Utils.getFileName(android.net.Uri):java.lang.String");
    }

    public static void copyFile(Context context, Uri uri, File file) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                copyStream(openInputStream, fileOutputStream);
                openInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(3:1|2|(1:4)(1:19))|5|6|7|8|9|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int copyStream(java.io.InputStream r6, java.io.OutputStream r7) throws java.lang.Exception, java.io.IOException {
        /*
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r0]
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream
            r2.<init>(r6, r0)
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream
            r6.<init>(r7, r0)
            r7 = 0
            r3 = 0
        L_0x0010:
            int r4 = r2.read(r1, r7, r0)     // Catch:{ all -> 0x0026 }
            r5 = -1
            if (r4 == r5) goto L_0x001c
            r6.write(r1, r7, r4)     // Catch:{ all -> 0x0026 }
            int r3 = r3 + r4
            goto L_0x0010
        L_0x001c:
            r6.flush()     // Catch:{ all -> 0x0026 }
            r6.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            r2.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            return r3
        L_0x0026:
            r7 = move-exception
            r6.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            r2.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.Utils.copyStream(java.io.InputStream, java.io.OutputStream):int");
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if (Build.VERSION.SDK_INT < 19 || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, (String) null, (String[]) null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return context.getExternalFilesDir((String) null) + "/" + split[1];
            }
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
        } else if (isMediaDocument(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x0032 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0032 }
            if (r8 == 0) goto L_0x002c
            boolean r9 = r8.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r9 == 0) goto L_0x002c
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0029 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x0029 }
            if (r8 == 0) goto L_0x0028
            r8.close()
        L_0x0028:
            return r9
        L_0x0029:
            r9 = move-exception
            r7 = r8
            goto L_0x0033
        L_0x002c:
            if (r8 == 0) goto L_0x0031
            r8.close()
        L_0x0031:
            return r7
        L_0x0032:
            r9 = move-exception
        L_0x0033:
            if (r7 == 0) goto L_0x0038
            r7.close()
        L_0x0038:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.Utils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* renamed from: a */
    static File m12818a(Context context) {
        File file = new File(context.getCacheDir(), "dimina/photo/");
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("tmp_");
        sb.append(MD5.toMD5(System.currentTimeMillis() + ""));
        sb.append(".jpg");
        String sb2 = sb.toString();
        File file2 = new File(file + File.separator + sb2);
        if (!file2.exists() || file2.delete()) {
            return file2;
        }
        return null;
    }

    public static File getPhotoOutputFile(Context context) {
        File file = new File(context.getExternalFilesDir((String) null).getAbsolutePath(), FileNameConstant.ROOT_FOLDER);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("tmp_");
        sb.append(MD5.toMD5(System.currentTimeMillis() + ""));
        sb.append(".jpg");
        String sb2 = sb.toString();
        File file2 = new File(file + File.separator + sb2);
        if (file2.exists() && !file2.delete()) {
            return null;
        }
        try {
            if (!file2.createNewFile()) {
                return null;
            }
            return file2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a A[SYNTHETIC, Splitter:B:13:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[SYNTHETIC, Splitter:B:21:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String m12820a(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0047
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r1.<init>()     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x001f }
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch:{ IOException -> 0x001f }
            r1.flush()     // Catch:{ IOException -> 0x001f }
            r1.close()     // Catch:{ IOException -> 0x001f }
            byte[] r4 = r1.toByteArray()     // Catch:{ IOException -> 0x001f }
            r2 = 0
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ IOException -> 0x001f }
            goto L_0x0049
        L_0x001f:
            r4 = move-exception
            goto L_0x0025
        L_0x0021:
            r4 = move-exception
            goto L_0x0039
        L_0x0023:
            r4 = move-exception
            r1 = r0
        L_0x0025:
            r4.printStackTrace()     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x0035
            r1.flush()     // Catch:{ IOException -> 0x0031 }
            r1.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0035:
            r4 = r0
            goto L_0x0056
        L_0x0037:
            r4 = move-exception
            r0 = r1
        L_0x0039:
            if (r0 == 0) goto L_0x0046
            r0.flush()     // Catch:{ IOException -> 0x0042 }
            r0.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0046:
            throw r4
        L_0x0047:
            r4 = r0
            r1 = r4
        L_0x0049:
            if (r1 == 0) goto L_0x0056
            r1.flush()     // Catch:{ IOException -> 0x0052 }
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0056:
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L_0x006e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "data:image/jpeg;base64,"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            return r4
        L_0x006e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.Utils.m12820a(android.graphics.Bitmap):java.lang.String");
    }

    /* renamed from: a */
    static Bitmap m12817a(Bitmap bitmap, long j) {
        byte[] byteArray;
        if (((long) BitmapCompat.getAllocationByteCount(bitmap)) <= j) {
            return bitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (true) {
            byteArray = byteArrayOutputStream.toByteArray();
            if (((long) byteArray.length) > j && i > 10) {
                byteArrayOutputStream.reset();
                i -= 10;
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            }
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap decodeSampledBitmap(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = m12815a(options, i, i2);
        PrintStream printStream = System.out;
        printStream.println("sampleSize1===" + options.inSampleSize);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeImgByUriStream(android.content.ContentResolver r4, android.net.Uri r5, int r6, int r7) {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            r1.<init>()     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            r2 = 1
            r1.inJustDecodeBounds = r2     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            java.io.InputStream r2 = r4.openInputStream(r5)     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            android.graphics.BitmapFactory.decodeStream(r2, r0, r1)     // Catch:{ Exception -> 0x003d }
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.InputStream) r2)     // Catch:{ Exception -> 0x003d }
            int r6 = m12815a(r1, r6, r7)     // Catch:{ Exception -> 0x003d }
            r1.inSampleSize = r6     // Catch:{ Exception -> 0x003d }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ Exception -> 0x003d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003d }
            r7.<init>()     // Catch:{ Exception -> 0x003d }
            java.lang.String r3 = "sampleSize2==="
            r7.append(r3)     // Catch:{ Exception -> 0x003d }
            int r3 = r1.inSampleSize     // Catch:{ Exception -> 0x003d }
            r7.append(r3)     // Catch:{ Exception -> 0x003d }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x003d }
            r6.println(r7)     // Catch:{ Exception -> 0x003d }
            r6 = 0
            r1.inJustDecodeBounds = r6     // Catch:{ Exception -> 0x003d }
            java.io.InputStream r2 = r4.openInputStream(r5)     // Catch:{ Exception -> 0x003d }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r2, r0, r1)     // Catch:{ Exception -> 0x003d }
            goto L_0x0046
        L_0x003d:
            r4 = move-exception
            goto L_0x0043
        L_0x003f:
            r4 = move-exception
            goto L_0x004c
        L_0x0041:
            r4 = move-exception
            r2 = r0
        L_0x0043:
            r4.printStackTrace()     // Catch:{ all -> 0x004a }
        L_0x0046:
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.InputStream) r2)
            return r0
        L_0x004a:
            r4 = move-exception
            r0 = r2
        L_0x004c:
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.InputStream) r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.Utils.decodeImgByUriStream(android.content.ContentResolver, android.net.Uri, int, int):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0030 A[SYNTHETIC, Splitter:B:19:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[SYNTHETIC, Splitter:B:24:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m12821a(android.graphics.Bitmap r2, java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x000e
            r0.delete()
        L_0x000e:
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002a }
            r1.<init>(r0)     // Catch:{ Exception -> 0x002a }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            r0 = 100
            r2.compress(r3, r0, r1)     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            r1.flush()     // Catch:{ IOException -> 0x0037 }
            r1.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0022:
            r2 = move-exception
            r3 = r1
            goto L_0x003c
        L_0x0025:
            r2 = move-exception
            r3 = r1
            goto L_0x002b
        L_0x0028:
            r2 = move-exception
            goto L_0x003c
        L_0x002a:
            r2 = move-exception
        L_0x002b:
            r2.printStackTrace()     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x003b
            r3.flush()     // Catch:{ IOException -> 0x0037 }
            r3.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r2 = move-exception
            r2.printStackTrace()
        L_0x003b:
            return
        L_0x003c:
            if (r3 == 0) goto L_0x0049
            r3.flush()     // Catch:{ IOException -> 0x0045 }
            r3.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0049:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.Utils.m12821a(android.graphics.Bitmap, java.lang.String):void");
    }

    /* renamed from: a */
    static int m12814a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    static boolean m12823a(Runnable runnable, long j) {
        Handler handler = f17263a;
        if (handler == null) {
            return false;
        }
        handler.removeCallbacks(runnable, f17264b);
        return f17263a.postDelayed(runnable, j);
    }

    /* renamed from: a */
    static void m12822a(Runnable runnable) {
        Handler handler = f17263a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    /* renamed from: a */
    static Bitmap m12816a(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) ((i * height) / width)) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap cropBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null || i <= 0 || i2 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i * height > width * i2) {
            return Bitmap.createBitmap(bitmap, 0, 0, width, (int) (((float) i2) * (((float) width) / ((float) i))));
        }
        return Bitmap.createBitmap(bitmap, 0, 0, (int) (((float) i) * (((float) height) / ((float) i2))), height);
    }

    /* renamed from: a */
    private static int m12815a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            while (i3 / i5 >= i2 && i4 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
