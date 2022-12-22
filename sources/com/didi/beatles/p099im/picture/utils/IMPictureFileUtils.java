package com.didi.beatles.p099im.picture.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;
import com.didi.sdk.apm.SystemUtils;
import com.didi.security.uuid.share.ShareDBHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.picture.utils.IMPictureFileUtils */
public class IMPictureFileUtils {
    public static final String APP_NAME = "ImImage";
    public static final String CAMERA_PATH = "/ImImage/ImCamera/";
    public static final String CROP_PATH = "/ImImage/ImCrop/";
    public static final String POSTFIX = ".JPEG";
    public static final String POST_VIDEO = ".mp4";

    /* renamed from: a */
    static final String f9453a = "PictureFileUtils";

    /* renamed from: b */
    private static String f9454b = "picture_cache";

    public static File createCameraFile(Context context, int i, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = CAMERA_PATH;
        }
        return m6419a(context, str, i, str2);
    }

    public static File createCropFile(Context context, int i, String str) {
        return m6419a(context, CROP_PATH, i, str);
    }

    /* renamed from: a */
    private static File m6419a(Context context, String str, int i, String str2) {
        File filesDir = context.getFilesDir();
        if (Build.VERSION.SDK_INT < 23) {
            filesDir = Environment.getExternalStorageState().equals("mounted") ? SystemUtils.getExternalStorageDirectory() : context.getFilesDir();
        }
        File file = new File(filesDir.getAbsolutePath() + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = "ImImage_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date()) + "";
        if (i == 1) {
            if (TextUtils.isEmpty(str2)) {
                str2 = ".JPEG";
            }
            return new File(file, str3 + str2);
        } else if (i != 2) {
            return null;
        } else {
            return new File(file, str3 + POST_VIDEO);
        }
    }

    private IMPictureFileUtils() {
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

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r8 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (r8 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x0033, all -> 0x0031 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0033, all -> 0x0031 }
            if (r8 == 0) goto L_0x002b
            boolean r9 = r8.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x0029 }
            if (r9 == 0) goto L_0x002b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ IllegalArgumentException -> 0x0029 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ IllegalArgumentException -> 0x0029 }
            if (r8 == 0) goto L_0x0028
            r8.close()
        L_0x0028:
            return r9
        L_0x0029:
            r9 = move-exception
            goto L_0x0035
        L_0x002b:
            if (r8 == 0) goto L_0x0057
        L_0x002d:
            r8.close()
            goto L_0x0057
        L_0x0031:
            r9 = move-exception
            goto L_0x005a
        L_0x0033:
            r9 = move-exception
            r8 = r7
        L_0x0035:
            java.lang.String r1 = "PictureFileUtils"
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0058 }
            java.lang.String r11 = "getDataColumn: _data - [%s]"
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0058 }
            r2 = 0
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0058 }
            r0[r2] = r9     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = java.lang.String.format(r10, r11, r0)     // Catch:{ all -> 0x0058 }
            r0 = 4
            r3 = 0
            java.lang.String r4 = "com.didi.beatles.im.picture.utils.IMPictureFileUtils"
            r5 = 174(0xae, float:2.44E-43)
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0058 }
            if (r8 == 0) goto L_0x0057
            goto L_0x002d
        L_0x0057:
            return r7
        L_0x0058:
            r9 = move-exception
            r7 = r8
        L_0x005a:
            if (r7 == 0) goto L_0x005f
            r7.close()
        L_0x005f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.picture.utils.IMPictureFileUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static File getPhotoCacheDir(Context context, File file) {
        String str;
        File cacheDir = context.getCacheDir();
        String name = file.getName();
        if (cacheDir != null) {
            File file2 = new File(cacheDir, f9454b);
            if (!file2.mkdirs() && (!file2.exists() || !file2.isDirectory())) {
                return file;
            }
            if (name.endsWith(".webp")) {
                str = System.currentTimeMillis() + ".webp";
            } else {
                str = System.currentTimeMillis() + IMPictureMimeType.PNG;
            }
            return new File(file2, str);
        }
        if (Log.isLoggable(f9453a, 6)) {
            SystemUtils.log(6, f9453a, "default disk cache dir is null", (Throwable) null, "com.didi.beatles.im.picture.utils.IMPictureFileUtils", 201);
        }
        return file;
    }

    public static int readPictureDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap rotaingImageView(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        PrintStream printStream = System.out;
        printStream.println("angle2=" + i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void saveBitmapFile(Bitmap bitmap, File file) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        float f;
        float f2;
        float f3;
        float f4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f4 = (float) (width / 2);
            f3 = (float) width;
            f = f3;
            f2 = 0.0f;
        } else {
            f2 = (float) ((width - height) / 2);
            f = (float) height;
            f3 = ((float) width) - f2;
            width = height;
            f4 = (float) (height / 2);
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f2, (int) 0.0f, (int) f3, (int) f);
        Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f, (int) f);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, f4, f4, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static String getDCIMCameraPath() {
        try {
            return "%" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void deleteCacheDirFile(Context context) {
        File cacheDir = context.getCacheDir();
        File file = new File(context.getCacheDir() + "/picture_cache");
        File file2 = new File(context.getCacheDir() + "/luban_disk_cache");
        if (cacheDir != null) {
            for (File file3 : cacheDir.listFiles()) {
                if (file3.isFile()) {
                    file3.delete();
                }
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file4 : listFiles) {
                if (file4.isFile()) {
                    file4.delete();
                }
            }
        }
        File[] listFiles2 = file2.listFiles();
        if (listFiles2 != null) {
            for (File file5 : listFiles2) {
                if (file5.isFile()) {
                    file5.delete();
                }
            }
        }
    }

    public static boolean deleteFile(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new File(str).delete();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isImageUriFormat(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("content:");
    }

    public static boolean isFileExists(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (Build.VERSION.SDK_INT <= 28) {
            return new File(str).exists();
        }
        if (!isImageUriFormat(str)) {
            return new File(str).exists();
        }
        Uri contentUri = MediaStore.Files.getContentUri("external");
        String[] strArr = {String.valueOf(ContentUris.parseId(Uri.parse(str)))};
        Cursor query = context.getContentResolver().query(contentUri, new String[]{ShareDBHelper.ID_NAME}, "_id = ?", strArr, (String) null);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return false;
        }
        query.close();
        return true;
    }
}
